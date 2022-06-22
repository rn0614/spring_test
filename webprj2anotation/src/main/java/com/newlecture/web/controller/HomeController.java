package com.newlecture.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class HomeController{
	// resourceViewResolver로 index.jsp를 찾고 있음
	@RequestMapping("index")
	public String index() {
		//리솔빙됨
		return "root.index";
	}
	/*
	 * @Override public ModelAndView handleRequest(HttpServletRequest request,
	 * HttpServletResponse response) throws Exception { // TODO Auto-generated
	 * method stub
	 * 
	 * ModelAndView mv = new ModelAndView("root.index"); mv.addObject("data",
	 * "Hello Spring MVC ~"); //mv.setViewName("/WEB-INF/view/index.jsp");
	 * 
	 * return mv; }
	 */
	
}
