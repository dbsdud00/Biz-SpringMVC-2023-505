package com.callor.rent.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.callor.rent.models.BookDto;
import com.callor.rent.service.BookService;

import lombok.extern.slf4j.Slf4j;


/*
 *  localhost:8080/rent/book 또는 localhost:8080/rent/book/* 로 요청이 들어왔을 때
 *  서비스를 제공할 시작점이다.
 */
@Slf4j
@Controller
@RequestMapping(value="/book")
public class BookController {
	

	protected final BookService bookService;
	

	public BookController(BookService bookService) {
		super();
		this.bookService = bookService;
	}


	@RequestMapping(value={"/",""}, method=RequestMethod.GET)
	public String home(Model model) {
		List<BookDto> books = bookService.selectAll();
		model.addAttribute("BOOKS",books);
		return "book/home";
	}
	
	// 도서정보 입력 화면을 보여달라
	@RequestMapping(value="/insert", method=RequestMethod.GET)
	public String insert(@ModelAttribute("BOOK") BookDto bookDto) {
		return "book/input";
	}
	
	
	@RequestMapping(value="/insert", method=RequestMethod.POST)
	public String insert(@ModelAttribute("BOOK") BookDto bookDto, Model model) {
		log.debug("전달된 데이터 {} ", bookDto);
		int result = bookService.insert(bookDto);
		return "redirect:/book";
	}
	
	@RequestMapping(value="/{bcode}/detail" , method=RequestMethod.GET)
	public String detail(@PathVariable("bcode") String bcode, Model model) {
		
		BookDto bookDto = bookService.findById(bcode);
		model.addAttribute("BOOK",bookDto);
		
		return "book/detail";
	}
	
	@RequestMapping(value="/{bcode}/update" , method=RequestMethod.GET)
	public String update(@PathVariable("bcode") String bcode, Model model) {
		
		BookDto bookDto = bookService.findById(bcode);
		model.addAttribute("BOOK",bookDto);
		model.addAttribute("STATE","UPDATE");
		
		return "book/input";
	}
	@RequestMapping(value="/{bcode}/update" , method=RequestMethod.POST)
	public String update(@PathVariable("bcode") String bcode, @ModelAttribute("BOOK") BookDto bookDto, Model model) {
		
		if(!bcode.isBlank()) bookDto.setB_code(bcode);
		int result = bookService.update(bookDto); 
		
		
		return String.format("redirect:/book/%s/detail",bcode);
	}
	
	/*
	 *  @ModelAttribute("BOOK") 이라는 선언이 있는 매개변수가 반견되거든
	 *  BookDto bookDto 객체에 새로운 데이터가 있는지 확인하고
	 *  만약 null 값이면 새로운 BookDto 객체를 생성하여 주입하라
	 */
	@ModelAttribute("BOOK")
	public BookDto newBookDto() {
		return new BookDto().builder().build();
	}
}
