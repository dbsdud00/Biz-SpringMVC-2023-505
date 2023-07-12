package com.callor.bbs.dao;

import org.apache.ibatis.annotations.Select;

import com.callor.bbs.models.UserDto;

public interface UserDao {
	
	@Select("SELECT * FROM tbl_user WHERE username = #{name}")
	public UserDto findById(String name);
}
