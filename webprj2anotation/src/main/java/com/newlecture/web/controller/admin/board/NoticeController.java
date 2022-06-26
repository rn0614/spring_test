package com.newlecture.web.controller.admin.board;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

@Controller("adminNoticeController")
@RequestMapping("/admin/board/notice/")
public class NoticeController {

	@Autowired
	private ServletContext ctx;
	
	@RequestMapping("list")
	public String list(){
	
		return "admin.board.notice.list";
	}
	
	@GetMapping("reg")
	public String reg() {
		
		return "admin.board.notice.reg";
	}
	
	@PostMapping("reg")
	public String reg(String title,String content,String category, MultipartFile[] files, String[] foods, String food, HttpServletRequest request ) throws IllegalStateException, IOException{
		System.out.println(category);
		System.out.println("----------file----------");
		if(files!=null) {
			for(MultipartFile file : files) {
				long size = file.getSize();
				String fileName = file.getOriginalFilename();
				System.out.printf("fileName: %s, fileSize:%d\n",fileName, size);
				// 전역으로 사용
				//ServletContext ctx =request.getServletContext();
				String webPath="/static/upload";
				String realPath=ctx.getRealPath(webPath);
				System.out.printf("realPath : %s\n", realPath);
				
				// 저장할 경로가 없다면 새로 만들기
				File savePath = new File(realPath);
				if(!savePath.exists())
					savePath.mkdirs();
				
				realPath +=File.separator+fileName;
				File saveFile = new File(realPath);
				file.transferTo(saveFile);
			}
		}
		
		System.out.println("-------checkbox-----------");
		for(String f : foods)
			System.out.println(f);
		

		System.out.println("-------radio-----------");
		System.out.println(food);
		
		// 리디렉션 list페이지로
		return "redirect:list";
		// 포워딩
		//return "admin/notice/reg";
		
		
		//return String.format("title:%s<br> content:%s<br> category: %s<br>",title, content,category);
	}
	
	@RequestMapping("edit")
	public String edit(){
	
		return "admin.board.notice.edit";
	}
	
	@RequestMapping("del")
	public String del(){
	
		
		return "admin.board.notice.del";
	}
}
