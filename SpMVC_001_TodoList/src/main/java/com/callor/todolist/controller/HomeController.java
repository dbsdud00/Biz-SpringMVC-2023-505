package com.callor.todolist.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;



@Controller
public class HomeController {

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model,String date, String time) {
        // 현재 날짜/시간
        LocalDateTime now = LocalDateTime.now();
        // 포맷팅
        date = now.format(DateTimeFormatter.ofPattern("yyyy/MM/dd"));
        time = now.format(DateTimeFormatter.ofPattern("HH:mm:ss"));
 
        model.addAttribute("DATE",date);
        model.addAttribute("TIME",time);
        
		return "home";
	}
	
}
