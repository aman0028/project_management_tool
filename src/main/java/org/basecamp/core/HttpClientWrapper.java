package org.basecamp.core;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.SocketException;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpException;
import org.apache.http.HttpRequest;
import org.apache.http.HttpRequestInterceptor;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.client.utils.URIUtils;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.EntityEnclosingRequestWrapper;
import org.apache.http.protocol.HttpContext;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;


@Component
public class HttpClientWrapper
{
    private static final int connTimeoutInSecs = 10;
    private static final int socTimoutInSecs = 60;
    
    /**
     * This method trigger evenUrl and the JSON response in return will be converted to EventNotificationRequestDTO
     * @param host - baseUrl. In this method its null
     * @param path - eventUrl
     * @param headers - request headers
     * @param clazz - EventNotificationRequestDTO
     * @return
     */
    public static <T> T executeGetRequest(String host, String path, List<Header> headers, Class<T> clazz)
    {
        HttpResponseWrapper response = executeGetRequest1(host, path, headers);
        if (200 == response.getStatusCode())
        {
            return JsonUtil.getJSONtoObject(response.getContent(), clazz);
        }
        return null;
    }

    @SuppressWarnings("deprecation")
	private static HttpResponseWrapper executeGetRequest1(String host, String path,  List<Header> headers)
    {
        HttpRequestBase request;
        try
        {
            request = new HttpGet(URIUtils.createURI(null, host, -1, path, null, null));
            if (headers != null)
            {
                for (Header header : headers)
                    request.addHeader(header);
            }
            return execute(request);
        }
        catch (URISyntaxException e)
        {
            throw new RuntimeException(e);
        }
    }
   
    private static HttpResponseWrapper execute(HttpRequestBase request)
    {
        HttpClient httpClient = getHttpClient(connTimeoutInSecs, socTimoutInSecs);
        HttpResponseWrapper responseWrapper = new HttpResponseWrapper();
        int retryMax = 1;
        for (int retryCount = 0; retryCount <= retryMax; retryCount++)
        {
            try
            {
                long startTime = System.currentTimeMillis();
                //TODO: need to print startTime in Log4j
                
                HttpResponse response = httpClient.execute(request);
                long responseTime = System.currentTimeMillis() - startTime;
                //TODO: need to print responseTime in Log4j
                
                responseWrapper.setStatusCode(response.getStatusLine().getStatusCode());
                responseWrapper.setContent(logAndGetResponseContent(response));
                responseWrapper.setHeaders(logAndGetResponseHeaders(response));
                return responseWrapper;
            }
            catch (ClientProtocolException e)
            {
                throw new RuntimeException(e);
            }
            catch (HttpClientErrorException e)
            {
            	throw new RuntimeException(e); 
            }
            catch (IOException e)
            {
                String m = e.getMessage();
                if (e instanceof SocketException)
                {
                    if (retryCount < retryMax)
                    {
                        continue;
                    }
                }
                throw new RuntimeException(e);
            }
            finally
            {
                request.releaseConnection();
            }
        }
        return responseWrapper;
    }
    
    private static HttpClient getHttpClient(int connTimeoutInSecs, int socTimoutInSecs)
    {
        DefaultHttpClient httpClient = null;

        httpClient.addRequestInterceptor(new HttpClientRequestLogger());

        return httpClient;
    }

    private static class HttpClientRequestLogger implements HttpRequestInterceptor
    {
        public void process(HttpRequest request, HttpContext context) throws HttpException, IOException
        {
            StringBuilder buf = new StringBuilder();
            buf.append("\n" + request.getRequestLine() + "\n");
            for (Header header : request.getAllHeaders())
                buf.append(header.getName() + ": " + header.getValue() + "\n");
            buf.append("\n");
            if (request instanceof EntityEnclosingRequestWrapper)
            {
                HttpEntity httpEntity = ((EntityEnclosingRequestWrapper) request).getEntity();
                buf.append(getRequestContent(httpEntity));
            }
        }

    }

    private static String getRequestContent(HttpEntity httpEntity) throws IOException
    {
        OutputStream out = new ByteArrayOutputStream();
        httpEntity.writeTo(out);
        String content = out.toString();
        out.close();
        return content;
    }

    private static String logAndGetResponseContent(HttpResponse response) throws IllegalStateException, IOException
    {
        StringBuilder buffer = new StringBuilder();
        buffer.append("\n" + response.getStatusLine() + "\n");
        
        HttpEntity entity = response.getEntity();
        String resp = "";
        if(entity != null)
        {
        	resp = getStreamToString(entity.getContent());
            EntityUtils.consume(entity);
            buffer.append("\n").append(resp);
        }
        

        return resp;
    }

    private static Map<String, String> logAndGetResponseHeaders(HttpResponse response)
    {
        Map<String, String> headers = new HashMap<String, String>();
        for (Header header : response.getAllHeaders())
            headers.put(header.getName(), header.getValue());
        return headers;
    }

    private static String getStreamToString(InputStream stream) throws IOException
    {
        BufferedReader rd = new BufferedReader(new InputStreamReader(stream));
        StringBuffer buf = new StringBuffer();
        String line;
        while ((line = rd.readLine()) != null)
        {
            buf.append(line);
        }
        return buf.toString();
    }

     static class HttpResponseWrapper
    {
        private int statusCode;
        private String content;
        private Map<String, String> headers;

        public int getStatusCode()
        {
            return statusCode;
        }

        public void setStatusCode(int statusCode)
        {
            this.statusCode = statusCode;
        }

        public String getContent()
        {
            return content;
        }

        public void setContent(String content)
        {
            this.content = content;
        }

        public void setHeaders(Map<String, String> headers)
        {
            this.headers = headers;
        }

        public Map<String, String> getHeaders()
        {
            return headers;
        }

        public String getHeader(String name)
        {
            return (headers == null) ? "" : headers.get(name);
        }
    }
}
