package com.callor.rent.service;

import java.util.List;

import com.callor.rent.models.MemberDto;

public interface MemberService {
	public int insert(MemberDto dto) throws Exception;
	public String getNewCode();
	public List<MemberDto> SelectAll();
	public MemberDto findById(String id);
	public int update(MemberDto memberDto) throws Exception;
}	
