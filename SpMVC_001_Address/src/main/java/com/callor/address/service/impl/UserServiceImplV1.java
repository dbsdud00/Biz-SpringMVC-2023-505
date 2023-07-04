package com.callor.address.service.impl;

import org.springframework.stereotype.Service;

import com.callor.address.models.UserDto;
import com.callor.address.service.UserService;

@Service
public class UserServiceImplV1 implements UserService {

	@Override
	public UserDto findById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String userLogin(UserDto userDto) {
		// TODO Auto-generated method stub
		String username = userDto.getUsername();
		String password = userDto.getPassword();
		
		if (!username.equalsIgnoreCase("yoon")) {
			/*
			 *  add() : 무한히 데이터를 추가할 수 있다 라는 의미
			 *  set() : 제한적으로 데이터를 추가하는 것이 좋다.
			 *  httpSession 에 set 한 Attribute 는 
			 *  model 에 add 한 Attribute 와 view 에서 사용하는 것은 
			 *  거의 동일하다.
			 */
			return "F_USERNAME";
		} else if (!password.equals("!aa1234")) {
			return "F_PASSWORD";
		} else {
			return "OK";
		}
	}

	@Override
	public int userJoin(UserDto userDto) {
		// TODO Auto-generated method stub
		return 0;
	}

}
