package com.callor.rent.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.callor.rent.config.QualifierConfig;
import com.callor.rent.dao.MemberDao;
import com.callor.rent.models.BookDto;
import com.callor.rent.models.MemberDto;
import com.callor.rent.service.MemberService;


@Service(QualifierConfig.SERVICE.MEMBER_V1)
public class MemberServiceImplV1 implements MemberService{

	protected final MemberDao memberDao;
	
	
	public MemberServiceImplV1(MemberDao memberDao) {
		super();
		this.memberDao = memberDao;
	}
	
	/*
	 * 회원을 등록할 때 새로운 코드를 생성하여 memberDto 에 업데이트 하고
	 * 회원정보 insert 하기
	 */
	@Override
	public int insert(MemberDto memberDto) throws Exception  {
		// .trim() : white space 제거하기
		String tel = memberDto.getM_tel().trim();
		String name = memberDto.getM_name().trim();
		// 이름 + 전화번호가 중복되지 않도록 하기
		MemberDto resultDto = memberDao.findNameAndTel(name,tel);
		// 이름 + 전화번호가 중복된 경우
		if(resultDto != null) {
			throw new Exception("NAME_TEL");
		}
		
		String mCode = this.getNewCode();
		memberDto.setM_code(mCode);
		
		return memberDao.insert(memberDto);
	}

	/*
	 *  tbl_members table 의 데이터를 조회하여 새로운 고객코드 생성하기
	 */
	@Override
	public String getNewCode() {
		// TODO Auto-generated method stub
		String mCode = memberDao.getMaxMCode();
		String newCode = "000001";
		if(mCode != null) {
			newCode = String.format("%06d", Integer.valueOf(mCode) + 1);
		}
		
		return newCode;
	}

	@Override
	public List<MemberDto> SelectAll() {
		
		return memberDao.SelectAll();
	}

	@Override
	public MemberDto findById(String id) {
		MemberDto findDto = memberDao.findById(id);
		return findDto;
	}

	@Override
	public int update(MemberDto memberDto) throws Exception {
		String name = memberDto.getM_name();
		String tel = memberDto.getM_tel();
		MemberDto resultDto = memberDao.findNameAndTel(name, tel);
		/*
		 *  수정하기 위해서 입력한 이름과 전화번호로 SELECT 를 했는데 데이터가 있다
		 *  1. 만약 m_code 가 같다 : 이름과 전화번호를 변경하지 않고 저장하기를 클릭했다.
		 *  2. 만약 m_code 가 다르다. : 이미 등록된 회원의 이름, 전화번호로 수정을 시도하였다. -> 중복 데이터 오류
		 */
		if(resultDto != null && !resultDto.getM_code().equals(memberDto.getM_code())) {
			throw new Exception("NAME_TEL");
		}
		return memberDao.update(memberDto);
	}

	@Autowired
	public void create_table() {
		memberDao.create_member_table(null);
	}

	@Override
	public List<MemberDto> findByMName(String mname) {
		// TODO Auto-generated method stub
		return memberDao.findByName(mname);
	}


}
