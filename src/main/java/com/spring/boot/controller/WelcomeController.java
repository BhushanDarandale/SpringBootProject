package com.spring.boot.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.spring.boot.service.WelcomeService;

@Controller

public class WelcomeController {
	@Autowired
	private WelcomeService service;

	@RequestMapping("/welcome")
	public String welcome() {

		return service.retrieveWelcomeMessage();

	}

	@RequestMapping("/")
	public String home(Map<String, Object> model) {
		model.put("message", "Welcome to Spring Boot!!");
		return "index";
	}

	@RequestMapping("/next")
	public String next(Map<String, Object> model) {
		model.put("message", "You are in new page !!");
		return "next";
	}

	@RequestMapping("/login")
	public String dashboard(Model model, @RequestParam(value = "username") String username,
			@RequestParam(value = "password") String password, HttpServletRequest request) {

		System.out.println(username);
		String login_status = service.login(username, password, request);

		if (login_status.equals("success")) {
			model.addAttribute("message", "Welcome "+username+"");
			System.out.println("login success");
			return "dashboard";

		} else {
			System.out.println("login failed");
			model.addAttribute("error", "invalid");
			return "index";
		}

	}
}
