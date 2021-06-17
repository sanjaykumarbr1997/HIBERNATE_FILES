package com.xworkz.perfumes_app.perfumes.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.xworkz.perfumes_app.perfumes.dto.PerfumeDTO;
import com.xworkz.singleton.HibernateUtil;

public class PerfumeDAOImpl implements PerfumeDAO {
	SessionFactory sf=null;
	Session session=null;
	Transaction transaction=null;
	public void save(PerfumeDTO pDTO) {
		Transaction transaction=null;
		try {
		sf = HibernateUtil.getSessionFactory();
		System.out.println(sf);
		session = sf.openSession();
		transaction =session.beginTransaction();
		session.save(pDTO);
		transaction.commit();
		
		}catch (HibernateException e) {
			if(transaction!=null) {
				transaction.rollback();
			}
		}
		finally {
			if(session!=null) {
				session.close();
			}
		}
		
		
	}

	public PerfumeDTO getDetailsByName(int id, String name) {
		Transaction transaction=null;
		try {
			sf = HibernateUtil.getSessionFactory();
		session = sf.openSession();
		PerfumeDTO prDTO = session.get(PerfumeDTO.class, id);
		if(prDTO.getPerfumeName().equalsIgnoreCase(name)) {
			return prDTO;
			
		}
		else {
			System.out.println("Name not matching with id , enter correct id");
		}
		
		
		}
		finally {
			if(session!=null) {
				session.close();
			}
		}
		return null;
	}

	public void updateColorByName(int id, String name, String color) {
		Transaction transaction=null;
		try {
			sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		PerfumeDTO prDTO = session.get(PerfumeDTO.class, id);
		transaction =session.beginTransaction();
		if(prDTO.getPerfumeName().equalsIgnoreCase(name)) {
			prDTO.setPerfumeColor(color);
			session.update(prDTO);
			transaction.commit();
		}
		else {
			System.out.println("Name not matching with id , enter correct id");
		}
		
	}catch (HibernateException e) {
		if(transaction!=null) {
			transaction.rollback();
		}
	}
	finally {
		if(session!=null) {
			session.close();
		}
	}
		
	}

	public void deleteDetailsByName(int id, String name) {
		Transaction transaction=null;
		try {
			sf = HibernateUtil.getSessionFactory();
		session = sf.openSession();
		PerfumeDTO prDTO = session.get(PerfumeDTO.class, id);
		transaction =session.beginTransaction();
		if(prDTO.getPerfumeName().equalsIgnoreCase(name)) {
			session.delete(prDTO);
			transaction.commit();
		}
		else {
			System.out.println("Name not matching with id , enter correct id");
		}
		
		}catch (HibernateException e) {
			if(transaction!=null) {
				transaction.rollback();
			}
		}
		finally {
			if(session!=null) {
				session.close();
			}
		}
		
		
	}

}
