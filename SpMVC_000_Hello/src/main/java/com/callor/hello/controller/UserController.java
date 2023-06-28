package com.callor.hello.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/*
 *  class 를 만들고 @Controller 라는 Annotation 을 부착하면
 *  Spring Framework  에서 자동으로
 *  이 클래스에 Controller 기능을 부여한다.
 *  
 *  Controller class 는 Web Application 에서 Request 를 가장 먼저 부착하면
 *  Web 의 URL 을 처리하는 method 가 된다.
 */


@Controller
public class UserController {
	
	// http://
	@RequestMapping(value = "/user/login")
	public String login() {
		return "login";
	}
}
