package com.osms.api;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.hamcrest.Matchers;
import org.junit.Test;
import org.springframework.test.web.servlet.ResultActions;

import com.jprnd.osms.api.controller.ResourceURL;
import com.jprnd.osms.api.req.AuthRequest;

public class AuthenticationTest extends BaseTest {

	@Test
	public void authenticationTest() throws Exception{
		AuthRequest authReq = new AuthRequest("nimesh","nimesh");
		System.out.println("Request: " + json(authReq));
		ResultActions rs = mockMvc.perform(post(ResourceURL.AUTHENTICATE)
						.contentType(contentType)
						.content(json(authReq)));
		System.out.println("Request URL: " + rs.andReturn().getRequest().getRequestURL());
		System.out.println("Response: "+ rs.andReturn().getResponse().getContentAsString());
		
				rs.andExpect(status().isOk())
				.andExpect(content().contentType(contentType))
				 .andExpect(jsonPath("$.status",Matchers.is("Ok")))
				 .andExpect(jsonPath("$.token",Matchers.notNullValue()));
				;
	}
	
	
	@Test
	public void invalidAuthenticationTest() throws Exception{
		AuthRequest authReq = new AuthRequest("nimesh","nimesh223");
		System.out.println("Request: " + json(authReq));
		ResultActions rs = mockMvc.perform(post(ResourceURL.AUTHENTICATE)
						.contentType(contentType)
						.content(json(authReq)));
		System.out.println("Request URL: " + rs.andReturn().getRequest().getRequestURL());
		System.out.println("Response: "+ rs.andReturn().getResponse().getContentAsString());
		
				rs.andExpect(status().isOk())
				.andExpect(content().contentType(contentType))
				 .andExpect(jsonPath("$.status",Matchers.is("Failed")))
				 .andExpect(jsonPath("$.errorCode",Matchers.is("AUTH_ERROR")))
				;
	}
	
	@Test
	public void usernamePasswordEmptyTest() throws Exception{
		AuthRequest authReq = new AuthRequest("nimesh","");
		System.out.println("Request: " + json(authReq));
		ResultActions rs = mockMvc.perform(post(ResourceURL.AUTHENTICATE)
						.contentType(contentType)
						.content(json(authReq)));
		System.out.println("Request URL: " + rs.andReturn().getRequest().getRequestURL());
		System.out.println("Response: "+ rs.andReturn().getResponse().getContentAsString());
		
				rs.andExpect(status().isOk())
				.andExpect(content().contentType(contentType))
				 .andExpect(jsonPath("$.status",Matchers.is("Failed")))
				 .andExpect(jsonPath("$.errorCode",Matchers.is("VALIDATION_ERROR")))
				;
	}
	
}
