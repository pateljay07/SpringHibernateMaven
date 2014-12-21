package com.ydsworld.dao;

import java.util.Iterator;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.ydsworld.model.Employee;
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
		List results = null;
		
		try {
			factory=new Configuration().configure().buildSessionFactory();
			session=factory.openSession();
			tr=session.beginTransaction();
			
			Query query = session.createQuery("From Order");
			
			results =  query.list();
			
		} 
		catch (HibernateException e) {
			System.out.println("Error  : Data not present...!!!");
			e.printStackTrace();
		}
		finally{
			session.flush();
			session.close();		
		}
		
		
		return results;
		
		
	}

}
