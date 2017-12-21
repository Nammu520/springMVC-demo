package com.danlu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DemoController {

	@RequestMapping("/danlu")
	public String helloWorld(Model model) {
		System.out.println("hahahhaha !success");
		String word0 = "Hello ";
		String word1 = "World!";
		//��������ӵ���ͼ����������
		model.addAttribute("word0",word0);
		model.addAttribute("word1",word1);
		return "index";
	}
}
