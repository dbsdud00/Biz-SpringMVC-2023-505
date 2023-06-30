package com.callor.address.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.callor.address.models.AddrDto;
import com.callor.address.service.AddrService;

/*
 *  Controller class
 *  @Controller Annotation 이 부착된 class
 *  Client 로 부터 Request(요청)이 다다르면, 어디로 요청을 전달할 지 
 *  Routing 역할을 하는 class 
 *  wlqdp rkrh tlvdj
 */
@Controller
public class HomeController {

//	@Autowired
//	protected AddrDao addrDao;

	protected final AddrService addrService;

	public HomeController(AddrService addrService) {
		this.addrService = addrService;
	}
	
	

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model) {

		List<AddrDto> addrList = addrService.selectAll();
		model.addAttribute("ADDRS", addrList);

		return "home";
	}

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	@ResponseBody
	public List<AddrDto> list() {
		List<AddrDto> addrList = addrService.selectAll();
		return addrList;
	}

	/*
	 * localhost:8080/address/insert 로 요청이 오면 addr/input.jsp 파일을 열어서 Response 하도록
	 * method 생성
	 */
	@RequestMapping(value = "/insert", method = RequestMethod.GET)
	public String insert(Model model) {
		model.addAttribute("BODY", "INPUT");
		/*
		 * Controller 의 method 에서 문자열을 return 하면 "/views/문자열.jsp" 파일을 rendering 하여
		 * Client 로 Response 를 하라는 의미
		 */
		return "home";
	}

	// produces
	// server 가 Browser 에 데이터을 응답할 때
	// 한글이 포함되어 있으면 Encoding 을 하여서 보내라.
	// View 에 rendering 을 할 때는 의미가 없다.
	// @ResponseBody 가 설정되어 있을 때
	@RequestMapping(value = "/insert", method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
	/*
	 * Controller 의 method 에 @ResponseBody Annotation 이 부착되면 문자열을 그대로(direct) client
	 * 로 Response 하라 라는 의미
	 */
//	@ResponseBody
//	public String insert(String a_name, String a_tel, String a_addr, String a_id ) {
//		
//		return String.format("이름 : %s, 전화번호 : %s, 주소 : %s", a_name, a_tel, a_addr);
//	}
	public String insert(@ModelAttribute AddrDto addrDto) {
		
		addrService.insert(addrDto);
		
		// 데이터를 만들고 view 를 생성하여 client  에게 response 하는 
		// URL 이 이미 있으니 
		// client 야 번거롭지만 한번 더 요청해 주라
		return "redirect:/";
//		return String.format("이름 : %s, 전화번호 : %s, 주소 : %s", addrDto.getA_name(), addrDto.getA_tel(),
//				addrDto.getA_addr());
	}

	@RequestMapping(value = "/insert/test", method = RequestMethod.GET)
	public String insert() {
		return "addr/input";
	}

	@RequestMapping(value = "/id_check", method = RequestMethod.GET)
	@ResponseBody
	public String idCheck(String id) {
		return addrService.idCheck(id);
		//		AddrDto addrDto = addrService.findById(id);
//		if (addrDto == null) {
//			return "OK";
//		} else {
//			return "FAIL";
//		}
	}
	
	@RequestMapping(value="/detail", method=RequestMethod.GET)
	public String detail(Model model ,String id) {
		AddrDto addrDto = addrService.findById(id);
		model.addAttribute("ADDR",addrDto);
		model.addAttribute("BODY","DETAIL");
		return "home";
	}
	
 

}
