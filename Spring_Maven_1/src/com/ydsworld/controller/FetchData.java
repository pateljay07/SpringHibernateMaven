package com.ydsworld.controller;
import java.util.Iterator;
import java.util.List;

import org.hibernate.*;
import org.hibernate.cfg.*;

import com.ydsworld.model.Employee;


public class FetchData
{
	
	public static void main(String[] args) {
		
		Session session=null;
		SessionFactory factory;
		Transaction tr;
		
		try {
			factory=new Configuration().configure().buildSessionFactory();
			session=factory.openSession();
			tr=session.beginTransaction();



// this is the query to fetch data from either we can use HQL 
// i.e hibernate Query Language or  we will use Query to fetch data .
//the difference is in HQL we are using table name mentioned in .hbm.xml file
		//	String hql = "FROM emp1";
		//	Query query = session.createQuery(hql);
			
			
// by using query we can use class name i.e Employee class which is Pojo class
			Query query = session.createQuery("From Employee");
			
			
			List results = query.list();
// by using List interface we are copying all the data from table in to list and by using List iterator we are iterating the data same like in collection  because same in collection we are saving object and retrieving objects
			

			
			
			Iterator<Employee> itr=results.iterator();
			while(itr.hasNext())
			{
			Employee e1=itr.next();
// by using this we are fetching one by one and store in Employee Object 
			System.out.println(e1);
			}
		} 
		catch (HibernateException e) {
			System.out.println("Error  : Data not present...!!!");
			e.printStackTrace();
		}
		finally{
			session.flush();
			session.close();
			
		}
	}
}