package com.callor.hello.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.callor.hello.models.AddressDto;

@Controller
public class HomeController {
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model) {
		model.addAttribute("name", "홍길동");
		model.addAttribute("age", "24");
		model.addAttribute("tel", "010-1111-1111");

		return "home";
	}

	@RequestMapping(value = "/hello")
	public String hello(Model model) {
		AddressDto addrDto = new AddressDto();
		addrDto.setName("성춘향");
		addrDto.setTel("010-2222-2222");
		addrDto.setAge(16);
		addrDto.setAddress("전라북도 남원시");
		
		model.addAttribute("ADDR",addrDto);
		
		// WEB-INF/views/hello.jsp 를 찾아서 rendering 해달라
		return "hello";
	}
	
	@RequestMapping(value = "/user")
	public String user(Model model) {
		List<AddressDto> addrList = new ArrayList<AddressDto>();
		AddressDto addrDto = new AddressDto("성춘향","010-1111-1111","전북남원", 16);
		addrList.add(addrDto);
		addrDto = new AddressDto("홍길동","010-2222-1111","광주", 17);
		addrList.add(addrDto);
		addrDto = new AddressDto("이몽룡","010-1111-2222","순천", 18);
		addrList.add(addrDto);
		model.addAttribute("ADDRS",addrList);
		
		for (AddressDto dto : addrList) {
			System.out.println(dto.toString());
			System.out.println();
		}
		
		return "user2";
	}

}
