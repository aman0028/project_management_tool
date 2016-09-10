package org.basecamp.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UserIdentificationFilter implements Filter{

	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException 
	{
		HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) res;
        
        //TODO: OpenID Authentication need to handle here and once user is 
        //authenticated then only he will be allowed redirect to controller.
        
        chain.doFilter(req, res);
	}

	public void init(FilterConfig arg0) throws ServletException {}
	
	public void destroy() {}

}
