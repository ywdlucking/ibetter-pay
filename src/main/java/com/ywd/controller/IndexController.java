package com.ywd.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * 首页请求
 *
 */
@Controller
public class IndexController {

	/**
	 * 网页根目录请求
	 * @return
	 */
	@RequestMapping("/")
	public ModelAndView root(){
		ModelAndView mav=new ModelAndView();
		mav.addObject("title", "在线支付");
		mav.setViewName("index");
		return mav;
	}
}
