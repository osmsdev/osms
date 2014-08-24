package com.jprnd.osms.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

public class RestAuthenticationSuccessHandler implements
		AuthenticationSuccessHandler {

	@Override
	public void onAuthenticationSuccess(HttpServletRequest arg0,
			HttpServletResponse response, Authentication auth) throws IOException,
			ServletException {
		System.out.println("onAuthenticationSuccess");
		/*response.getWriter().print("{\"responseCode\":\"SUCCESS\"}");
        response.getWriter().flush();*/
        
		response.setContentType("application/json");
		response.setStatus(HttpServletResponse.SC_OK);
		
		//TODO - GEnerate Token
		
		String token = "jflskfjklaflkasflksafkla";
		
		response.getOutputStream().println("{\"status\":\"success\" , \"token\":\"" + token + "\" }");
        
	}

}
