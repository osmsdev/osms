package com.jprnd.osms.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

public class RestAuthenticationFailureHandler implements
		AuthenticationFailureHandler {

	@Override
	public void onAuthenticationFailure(HttpServletRequest request,
			HttpServletResponse response, AuthenticationException exception)
			throws IOException, ServletException {
		System.out.println("onAuthenticationFailure");
		
		/*response.setContentType("application/json");
		response.sendError(401, "Authentication Failed: " );*/
		
		 response.setContentType("application/json");
		 response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
		 response.getOutputStream().println("{\"status\":\"fail\" ,  \"error\": \"" + exception.getMessage() + "\" }");

		    
		//response.getWriter().print("{\"responseCode\":\"Failed\"}");
        //response.getWriter().flush();
        
		
	}

}
