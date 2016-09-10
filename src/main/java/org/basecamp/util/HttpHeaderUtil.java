package org.basecamp.util;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.http.Header;
import org.apache.http.message.BasicHeader;

public class HttpHeaderUtil 
{

	/**
	 * This method collect all the requestHeaders and put it in a map
	 * @param request
	 * @return map
	 */
	private static Map<String, String> getHttpHeaders(HttpServletRequest request)
    {
        Map<String, String> map = new HashMap<String,String>();
        @SuppressWarnings("unchecked")
        Enumeration<String> headerNames = request.getHeaderNames();
        while (headerNames.hasMoreElements())
        {
            String headerName = headerNames.nextElement();
            map.put(headerName, getFullHeader(request.getHeaders(headerName)));
        }
        return map;
    }

   
	/**
	 * when there are multiple headers with same header name, this method will return them in a comma-separated string
	 * @param headers
	 * @return
	 */
    private static String getFullHeader(Enumeration<?> headers)
    {
        StringBuilder builder = new StringBuilder();
        if (headers != null)
        {
            while (headers.hasMoreElements())
            {
                if (!"".equals(builder.toString()))
                    builder.append(",");
                builder.append(headers.nextElement());
            }
        }
        else
            return null;
        
        return builder.toString();
    }


	public static List<Header> getHeaderList(HttpServletRequest request) 
	{
		Map<String, String> headersMap = getHttpHeaders(request);
		List<Header> headers = new ArrayList<Header>();
        for(Map.Entry<String, String> entry : headersMap.entrySet())
        {
            headers.add(new BasicHeader(entry.getKey(), entry.getValue()));
        }
        return headers;
	}
}
