package com.hibernate04.test;

import static org.junit.Assert.*;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import com.hibernate04.pojo.TAddress;
import com.hibernate04.pojo.TPerson;
import com.hibernate04.util.HibernateSessionFactory;

public class AddTest {

	@Test
	public void testAdd(){
	//新增城市
		Session session=HibernateSessionFactory.getSession();
		Transaction tr= session.beginTransaction();
		 //新增城市
		TAddress address=new TAddress();
		 address.setACity("广州");
		 
		 //新增人员
		 TPerson p1=new TPerson();
		 p1.setPName("毛毛");
		
		// TPerson p2=new TPerson();
		 //p2.setPName("膨胀");
		
		// TPerson p3=new TPerson();
		 //p3.setPName("老刘");
		
		 //关联关系
		 address.getPersons().add(p1);
		 //address.getPersons().add(p2);
		// address.getPersons().add(p3);
		 
		 p1.setAddress(address);
		// p2.setAddress(address);
		 //p3.setAddress(address);
		 
		 //将地址存储在数据库当中
		 session.save(address);
		 tr.commit();
		 HibernateSessionFactory.closeSession();	
	}
	@Test
	public void testUpdate(){
		Session session=HibernateSessionFactory.getSession();
		Transaction tr=session.beginTransaction();
		//先找到要修改的人的对象
		TPerson p=(TPerson)session.get(TPerson.class,5);
		p.getAddress().setACity("上海");
		tr.commit();
		HibernateSessionFactory.closeSession();
	
	}
	/**
	 * 查询城市，打印出城市，并且打印出城市居住的人
	 */
	@Test
	public void testFindAll(){
		Session session=HibernateSessionFactory.getSession();
		String hql="from TAddress";
		Query query=session.createQuery(hql);
		@SuppressWarnings("unchecked")
		List<TAddress> address=query.list();
		for(TAddress add:address){
			System.out.println(add.getACity()+"居住了，");
			for(TPerson p:add.getPersons()){
				System.out.println(p.getPName());
			}
		}
		
	}
	//删除
	@Test
	public void testRemove(){
		Session session=HibernateSessionFactory.getSession();
		Transaction tr=session.beginTransaction();
		TAddress address=(TAddress)session.get(TAddress.class,3);
		session.delete(address);
		tr.commit();
		HibernateSessionFactory.closeSession();
		
	}
	
}
