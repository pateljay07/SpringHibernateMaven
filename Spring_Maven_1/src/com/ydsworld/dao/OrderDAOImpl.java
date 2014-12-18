package com.ydsworld.dao;

import java.util.Iterator;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.ydsworld.model.Order;
import com.ydsworld.util.HibernateUtil;

public class OrderDAOImpl implements OrderDAO{

	
	public void save(Order p) {
		
	}

	
	@SuppressWarnings("deprecation")
	public List<Order> list() {
		
		Session session=null;
		SessionFactory factory;
		Transaction tr;
		List<Order> resultList = null;
		
		try {
			 session = HibernateUtil.getSessionFactory().openSession();
			  
	        session.beginTransaction();
	
	 
	        Query q = session.createQuery("From Order");
	                 
	        resultList = q.list();
	        
	     /*   System.out.println("num of employess:" + resultList.size());
	        for (Employee next : resultList) {
	            System.out.println("next employee: " + next);
	        }*/
	        
			
		} catch (HibernateException e) {
			System.out.println("Error  : Data not present...!!!");
			e.printStackTrace();
		} finally {
		//	session.flush();
			session.close();
		}
		
		return resultList;
		
		
	}

}
