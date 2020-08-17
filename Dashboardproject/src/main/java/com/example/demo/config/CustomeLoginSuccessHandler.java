package com.example.demo.config;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
@Configuration
public class CustomeLoginSuccessHandler extends SimpleUrlAuthenticationSuccessHandler{
	
	@Override
	protected void handle(HttpServletRequest request,HttpServletResponse response, Authentication authentication) throws IOException
	{
		String targetUrl= determineTargetUrl(authentication);
		if(response.isCommitted())
		{
			return;
		}
		RedirectStrategy redirectstrategy=new DefaultRedirectStrategy();
		redirectstrategy.sendRedirect(request, response, targetUrl);
	} 
	
	protected String determineTargetUrl(Authentication authentication)
	{
		String url="/login?error=true";
		//Fetch Roles from authentication object
		Collection<? extends GrantedAuthority> authorities=authentication.getAuthorities();
		List<String> roles=new ArrayList<String>();
		for(GrantedAuthority a: authorities)
		{
			roles.add(a.getAuthority());
		}
		//check the user role and determine the redirection url
		if(roles.contains("ADMIN"))
		{
			url="/admin";
		}
		else if(roles.contains("ROLE_USER"))
		{
			url="/home";
		}
		return url;
	}
}
