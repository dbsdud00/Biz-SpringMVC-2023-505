package com.callor.hello.exec;

import com.callor.hello.service.UserService;
import com.callor.hello.service.impl.UserServiceImplV1;

public class ExecA {
	public static void main(String[] args) {
		UserService userService = new UserServiceImplV1();
		
		System.out.println(userService.selectAll());
	}
}	
