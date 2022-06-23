package com.newlecture.web.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/")
public class HomeController{
	
	// 문자열로 출력 , Servlet response
	//@RequestMapping("index")
	public void index1(HttpServletResponse response) throws IOException {
		PrintWriter out;
		
		out = response.getWriter();
		out.println("hello");
	}
	
	// 위와같이 전달하는 String이 그냥 문자열일 경우 @ResponseBody 사용
	@RequestMapping("index")
	@ResponseBody
	public String index2() {
		return "Hello Index";
	}
	
	
	// resourceViewResolver로 index.jsp를 찾고 있음
	//@RequestMapping("index")
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
