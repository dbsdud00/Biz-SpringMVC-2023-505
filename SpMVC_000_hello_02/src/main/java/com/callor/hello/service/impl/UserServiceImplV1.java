package com.callor.hello.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.springframework.stereotype.Service;

import com.callor.hello.models.UserDto;
import com.callor.hello.service.UserService;

@Service
public class UserServiceImplV1 implements UserService{
	/*
	 *  List<UserDto> userList 객체를 생성하고
	 *  임의로 생성한 3명의 User 정보를 add 하기
	 *  UserList를 return 하기
	 */
	List<UserDto> userList;
	public UserServiceImplV1() {
		// TODO Auto-generated constructor stub
		userList = new ArrayList<UserDto>();
		UserDto dto;
		dto = new UserDto("hong","ps","홍", "010-1111-1111","서울",10);
		userList.add(dto);
		dto = new UserDto("Kim","ps","김", "010-5111-1111","서울",10);
		userList.add(dto);
		dto = new UserDto("Lee","ps","이", "010-1111-5111","서울",10);
		userList.add(dto);
		
	}
	
	@Override
	public List<UserDto> selectAll() {
		// TODO Auto-generated method stub
		return userList;
	}

	@Override
	public UserDto findById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int input(UserDto dto) {
		// TODO Auto-generated method stub
		userList.add(dto);
		return 1;
	}
	
}
