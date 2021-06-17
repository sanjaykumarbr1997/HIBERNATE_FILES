package com.xworkz.sweets_app.sweets.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.xworkz.singleton.HibernateUtil;
import com.xworkz.sweets_app.sweets.dto.SweetsDTO;

public class SweetsDAOImpl implements SweetsDAO {
	
	

	public void save(SweetsDTO sDTO) {
		SessionFactory sessionFactory=null;
		Session session =null;
		Transaction transaction =null;
		try {
		 sessionFactory=HibernateUtil.getSessionFactory();
		System.out.println((sessionFactory));
		session = sessionFactory.openSession();
		transaction= session.beginTransaction();
		session.save(sDTO);
		transaction.commit();
		
		}catch (HibernateException e) {
			if(transaction!=null) {
			transaction.rollback();
			}
		}
		finally{
			if(session!=null) {
			session.close();
			}
			if(sessionFactory!=null) {
			sessionFactory.close();
			}
			
		}
		
		
		
	}

	public SweetsDTO getDetailsByName(int id, String name) {
		SessionFactory sessionFactory=null;
		Session session =null;
		
		try {
		sessionFactory=HibernateUtil.getSessionFactory();
		System.out.println((sessionFactory));
		session = sessionFactory.openSession();
		SweetsDTO swtDTO = session.get(SweetsDTO.class, id);
		if(swtDTO.getName().equalsIgnoreCase(name)) {
			return swtDTO;	
		}
		else {
			System.out.println("id not matching with sweet name, enter correct id");
		}
		
		return null;
		}
		finally{
			if(session!=null) {
			session.close();
			}
			if(sessionFactory!=null) {
			sessionFactory.close();
			}
			
		}
		
	}

	public void updateColorByName(int id, String name, String color) {
		SessionFactory sessionFactory=null;
		Session session =null;
		Transaction transaction =null;
		try {
		sessionFactory=HibernateUtil.getSessionFactory();
		System.out.println((sessionFactory));
		session = sessionFactory.openSession();
		transaction =session.beginTransaction();
		SweetsDTO swtDTO = session.get(SweetsDTO.class, id);
		if(swtDTO.getName().equalsIgnoreCase(name)) {
			swtDTO.setColor(color);
			session.update(swtDTO);
			transaction.commit();
			System.out.println("transaction commited");
		}
		else {
			System.out.println("id not matching with sweet name, enter correct id");
		}
		
		}catch (HibernateException e) {
			if(transaction!=null) {
				transaction.rollback();
				}
		}
		finally{
			if(session!=null) {
			session.close();
			}
			if(sessionFactory!=null) {
			sessionFactory.close();
			}
			
		}
		
	}

	public void deleteByName(int id, String name) {
		SessionFactory sessionFactory=null;
		Session session =null;
		Transaction transaction =null;
		try {
		sessionFactory=HibernateUtil.getSessionFactory();
		System.out.println((sessionFactory));
		session = sessionFactory.openSession();
		transaction =session.beginTransaction();
		SweetsDTO swtDTO = session.get(SweetsDTO.class, id);
		if(swtDTO.getName().equalsIgnoreCase(name)) {
			session.delete(swtDTO);
			transaction.commit();
		}
		else {
			System.out.println("id not matching with sweet name, enter correct id");
		}
		session.close();
		sessionFactory.close();
		}catch (HibernateException e) {
			if(transaction!=null) {
				transaction.rollback();
				}
		}
		finally{
			if(session!=null) {
			session.close();
			}
			if(sessionFactory!=null) {
			sessionFactory.close();
			}
			
		}
	}

}
