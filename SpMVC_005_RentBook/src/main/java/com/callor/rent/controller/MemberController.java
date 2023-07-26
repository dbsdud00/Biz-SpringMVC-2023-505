package com.callor.rent.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.callor.rent.models.MemberDto;
import com.callor.rent.service.MemberService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping(value="/member")
public class MemberController {
	
	
	protected final MemberService memberService;
	
	public MemberController(MemberService memberService) {
		super();
		this.memberService = memberService;
	}

	@RequestMapping(value={"/",""}, method=RequestMethod.GET)
	public String home(Model model) {
		List<MemberDto> memList = memberService.SelectAll();
		model.addAttribute("MEMBERS",memList);
		return "member/home";
	}
	
	@RequestMapping(value="/input", method=RequestMethod.GET)
	public String input(@ModelAttribute("MEMBER") MemberDto memberDto) {
		
		return "member/input";
	}
	@RequestMapping(value="/input", method=RequestMethod.POST)
	public String input(@ModelAttribute("MEMBER") MemberDto memberDto, Model model) {
		log.debug("회원정보 확인 {} ", memberDto);
		try {
			int result = memberService.insert(memberDto);
		} catch (Exception e) {
			// Service 에서 throw 로 전달한 message getter
			String message = e.getMessage();
			model.addAttribute("MESSAGE",message);
			return "member/input";
		}
		return "redirect:/member";
	}
	
	@RequestMapping(value="/{b_code}/detail" , method = RequestMethod.GET)
	public String detail(@PathVariable String b_code, Model model) {
		MemberDto detailDto = memberService.findById(b_code);
		model.addAttribute("FINDMEMBER",detailDto);
		return "member/detail";
	}
	@RequestMapping(value="/{b_code}/update" , method = RequestMethod.GET)
	public String update(@PathVariable String b_code, Model model) {
		MemberDto detailDto = memberService.findById(b_code);
		model.addAttribute("MEMBER",detailDto);
		return "member/input";
	}
	
	@RequestMapping(value="/{b_code}/update", method=RequestMethod.POST)
	public String update(@PathVariable("b_code") String bcode, @ModelAttribute("MEMBER") MemberDto memberDto, Model model) {
		memberDto.setM_code(bcode);
		try {
			int result = memberService.update(memberDto);
		} catch (Exception e) {
			// console 에 Exception log 출력하기
			e.printStackTrace();
			String message = e.getMessage();
			model.addAttribute("MESSAGE",message);
			return "member/input";
		}
		// @PathVariable 로 받은 b_code 데이터를 
		// redirect 코드에 그대로 적용하기
		// String.format("redirect:/member/%s/detail",bcode)
		return "redirect:/member/{b_code}/detail";
	}
	
	/*
	 *  @ModelAttribute 를 생성하면
	 *  객체, 변수가 작용하는 범위(scope) 가 Request 전체 영역에 
	 *  사용가능한 상태가 된다.
	 *  
	 */
	@ModelAttribute("MEMBER")
	public MemberDto memberDto() {
		return new MemberDto();
	}
}
