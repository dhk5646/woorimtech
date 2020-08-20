package com.aks.woorimtech.common.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class DoController {
	
	@RequestMapping(value = {"/**/*.do", "/"})
	public ModelAndView doGet(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
        String urlExtension = request.getRequestURI();
		ModelAndView mav = new ModelAndView();
		
		if(urlExtension.indexOf(".do") > -1) {
			mav.setViewName(urlExtension.replace(".do", ""));  //화면 설정
		}else {
			mav.setViewName("/index"); //초기페이지 설정
		}
		
		return mav;
	}
}