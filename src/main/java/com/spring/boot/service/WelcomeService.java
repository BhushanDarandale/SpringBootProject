package com.spring.boot.service;

import javax.servlet.http.HttpServletRequest;

public interface WelcomeService {

	String retrieveWelcomeMessage();

	String login(String username, String password,HttpServletRequest request);


}
