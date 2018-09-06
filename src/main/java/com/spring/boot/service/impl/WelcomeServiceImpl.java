package com.spring.boot.service.impl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.spring.boot.model.User;
import com.spring.boot.repository.UserRepository;
import com.spring.boot.service.WelcomeService;
import com.spring.boot.util.UserSession;

@Service
public class WelcomeServiceImpl implements WelcomeService {

	@Autowired
	private UserRepository userRepository;

	@Value("${welcome.message}")
	private String welcomeMessage;

	public String retrieveWelcomeMessage() {
		// Complex Method
		return welcomeMessage;
	}

	@Override
	public String login(String username, String password, HttpServletRequest request) {
		List<User> user = userRepository.findByUserName(username);
		if (user.isEmpty()) {
			return "failed";
		} else {
			if (password.equals(user.get(0).getPassword())) {
				if (UserSession.getInstance().session == null) {
					UserSession.getInstance().session = request.getSession();
					System.out.println(UserSession.getInstance().session.getId());

				}
				return "success";
			}
		}
		return "failed";
	}
}
