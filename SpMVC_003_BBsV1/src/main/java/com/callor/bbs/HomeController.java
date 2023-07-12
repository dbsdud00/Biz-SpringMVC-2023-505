package com.callor.bbs;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.callor.bbs.dao.BBsDao;
import com.callor.bbs.models.BBsDto;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private final BBsDao bbsDao;
	
	public HomeController(BBsDao bbsDao) {
		this.bbsDao = bbsDao;
	}


	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model) {
		
//		List<BBsDto> bbsList = bbsDao.selectAll();
		List<BBsDto> bbsList = bbsDao.findUserSelectLimit();
		
		model.addAttribute("BBS_LIST", bbsList);
		return "home";
	}
	
	@RequestMapping(value="/search/detail", method = RequestMethod.GET)
	public String detail(Model model, Long seq) {
		BBsDto BBS = bbsDao.findBySeq(seq);
		model.addAttribute("bbs", BBS);
		return "detail";
	}
	
	
}
