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
	//��������
		Session session=HibernateSessionFactory.getSession();
		Transaction tr= session.beginTransaction();
		 //��������
		TAddress address=new TAddress();
		 address.setACity("����");
		 
		 //������Ա
		 TPerson p1=new TPerson();
		 p1.setPName("ëë");
		
		// TPerson p2=new TPerson();
		 //p2.setPName("����");
		
		// TPerson p3=new TPerson();
		 //p3.setPName("����");
		
		 //������ϵ
		 address.getPersons().add(p1);
		 //address.getPersons().add(p2);
		// address.getPersons().add(p3);
		 
		 p1.setAddress(address);
		// p2.setAddress(address);
		 //p3.setAddress(address);
		 
		 //����ַ�洢�����ݿ⵱��
		 session.save(address);
		 tr.commit();
		 HibernateSessionFactory.closeSession();	
	}
	@Test
	public void testUpdate(){
		Session session=HibernateSessionFactory.getSession();
		Transaction tr=session.beginTransaction();
		//���ҵ�Ҫ�޸ĵ��˵Ķ���
		TPerson p=(TPerson)session.get(TPerson.class,5);
		p.getAddress().setACity("�Ϻ�");
		tr.commit();
		HibernateSessionFactory.closeSession();
	
	}
	/**
	 * ��ѯ���У���ӡ�����У����Ҵ�ӡ�����о�ס����
	 */
	@Test
	public void testFindAll(){
		Session session=HibernateSessionFactory.getSession();
		String hql="from TAddress";
		Query query=session.createQuery(hql);
		@SuppressWarnings("unchecked")
		List<TAddress> address=query.list();
		for(TAddress add:address){
			System.out.println(add.getACity()+"��ס�ˣ�");
			for(TPerson p:add.getPersons()){
				System.out.println(p.getPName());
			}
		}
		
	}
	//ɾ��
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
