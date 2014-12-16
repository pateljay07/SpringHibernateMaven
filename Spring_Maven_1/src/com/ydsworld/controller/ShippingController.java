package com.ydsworld.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/shipping")
public class ShippingController {

	@RequestMapping("/orders")
	public ModelAndView orders() {
 
		String message = "<br><div align='center'>"
				+ "<h3>**********Shipping Order List</h3> <br><br>";
		return new ModelAndView("orders", "message", message);
	}
	
	
	
}
