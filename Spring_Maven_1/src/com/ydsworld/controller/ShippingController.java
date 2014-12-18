package com.ydsworld.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.*;
import org.hibernate.cfg.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ydsworld.model.Employee;

@Controller
@RequestMapping("/shipping")
public class ShippingController {

	@SuppressWarnings("deprecation")
	@RequestMapping("/orders")
	public ModelAndView orders() {
		
		Session session=null;
		SessionFactory factory;
		Transaction tr;
		String str="";
		
		try {
			factory=new Configuration().configure().buildSessionFactory();
			session=factory.openSession();
			tr=session.beginTransaction();
			
			
			// by using query we can use class name i.e Employee class which is Pojo class
			Query query = session.createQuery("From Employee");
			
			
			List results = query.list();
			
			Iterator<Employee> itr=results.iterator();
			while(itr.hasNext())
			{
			Employee e1=itr.next();
// by using this we are fetching one by one and store in Employee Object 
			//System.out.println(e1);
			  str = str + e1;
			}
			
			//sb.append(" Result" );
		} 
		catch (HibernateException e) {
			System.out.println("Error  : Data not present...!!!");
			e.printStackTrace();
		}
		finally{
			//session.flush();
			//session.close();
			
		}
		
		
		String message = "<br><div align='center'>"
				+ "<h3>**********Shipping Order List</h3> <br><br>";
		message = message + str;
		
		return new ModelAndView("orders", "message", message);
		
		
	}
}
