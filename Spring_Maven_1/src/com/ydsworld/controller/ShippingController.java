package com.ydsworld.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.*;
import org.hibernate.cfg.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ydsworld.dao.OrderDAOImpl;
import com.ydsworld.model.Employee;
import com.ydsworld.model.Order;

@Controller
@RequestMapping("/shipping")
public class ShippingController {

	@SuppressWarnings("deprecation")
	@RequestMapping("/orders")
	public ModelAndView orders() {
		
		OrderDAOImpl ord = new OrderDAOImpl();
		
		List<Order> list = new  ArrayList<Order>();
		
		list = ord.list();

		return new ModelAndView("orders", "results", list);
		
		
	}
}
