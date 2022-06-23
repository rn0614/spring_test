package com.newlecture.web.controller.customer;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.newlecture.web.entity.Notice;
import com.newlecture.web.service.NoticeService;

@Controller
@RequestMapping("/customer/notice/")
public class NoticeController {
	
	@Autowired
	private NoticeService noticeService;
	
	// 그냥 String만 넣어도 HttpServletRequest와 같음 getParameter까지 한 상태 / 디폴트 1에 / int로 파싱가능 / name 대신 value 사용가능
	@RequestMapping("list")
	//public String list(@RequestParam(name="p",defaultValue = "1") int page) throws ClassNotFoundException, SQLException {
	public String list(@RequestParam(name="p", required=false) Integer page) throws ClassNotFoundException, SQLException {
		//String p= request.getParameter("p");
		System.out.println(page);
		
		List<Notice> list = noticeService.getList(1, "TITLE", "");
		
		return "notice.list";
	}
	
	@RequestMapping("detail")
	public String detail() {
		return "notice.detail";
	}
}
