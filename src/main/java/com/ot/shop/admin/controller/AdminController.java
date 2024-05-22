package com.ot.shop.admin.controller;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

public interface AdminController {
	public ModelAndView selectAllOrder();

	public ModelAndView showLoginPage();

	public ModelAndView loginCheck(@RequestParam String id);

	public ModelAndView createProduct();

	public ModelAndView selectAllProduct();

	public ModelAndView updateProduct();
	
	public ModelAndView index();
}
