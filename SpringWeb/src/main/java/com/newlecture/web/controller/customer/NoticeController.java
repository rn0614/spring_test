package com.newlecture.web.controller.customer;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

//RestController는 return 하면 그냥 String으로 리턴하고 Controller는 view로 리턴

@Controller
@RequestMapping("/customer/notice/")
public class NoticeController {
	
	@GetMapping("list")
	public String list(Model model) {
		model.addAttribute("test","Hello~");
		return "/customer/notice/list";
	}
	
	@GetMapping("detail")
	public String aaa() {
		return "/customer/notice/detail";
	}
	
}
