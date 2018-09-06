package com.spring.boot.util;

import javax.servlet.http.HttpSession;

public class UserSession {
	public boolean session_status = false;

	public HttpSession session = null;

	private UserSession() {
	}

	private static UserSession userSession = null;

	public static UserSession getInstance() {
		if (userSession == null) {
			userSession = new UserSession();
		}
		return userSession;
	}

}
