package com.xworkz.windowsversion_app.windows.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.xworkz.singleton.HibernateUtil;
import com.xworkz.windowsversion_app.windows.dto.WindowsDTO;

public class WindowsDAOImpl implements WindowsDAO {
	
	public void save(WindowsDTO wnDTO) {
		Session session =null;
		Transaction transaction = null;
		try {
		session =HibernateUtil.getSessionFactory().openSession();
		transaction = session.beginTransaction();
		session.save(wnDTO);
		transaction.commit();
		}catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
		}
		finally {
			if(session!=null) {
				session.close();
			}
			
		}
	}

	public List<WindowsDTO> getAllDetails() {
		Session session =null;
		try {
			
			 return HibernateUtil.getSessionFactory().openSession().createQuery("from WindowsDTO wwDTO").list();
			}catch (Exception e) {
				e.printStackTrace();
			}
			finally{
				if(session!=null) {
					session.close();
				}
				if(HibernateUtil.getSessionFactory()!=null) {
					HibernateUtil.getSessionFactory().close();
				}
			}
			return null;
	}

	public void updateColorByName(String name, int id, int year) {
		Session session =null;
		Transaction trans= null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			trans = session.beginTransaction();
			WindowsDTO ctDTO = session.get(WindowsDTO.class, id);
			if(ctDTO.getName().equalsIgnoreCase(name)) {
				ctDTO.setReleaseYear(year);
				session.update(ctDTO);
				trans.commit();
				
			}
			else {
				System.out.println("Please enter correct id of windows");
			}
			
		}catch (Exception e) {
			e.printStackTrace();
			trans.rollback();
			
		}
		finally {
			if(session!=null) {
				session.close();
			}
			if(HibernateUtil.getSessionFactory()!=null) {
				HibernateUtil.getSessionFactory().close();
			}
		}
		
		
	}

	public void deleteByName(String name, int id) {
		Session session =null;
		Transaction trans= null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			trans = session.beginTransaction();
			WindowsDTO stDTO = session.get(WindowsDTO.class, id);
			if(stDTO.getName().equalsIgnoreCase(name)) {
				session.delete(stDTO);
				trans.commit();
				
			}
			else {
				System.out.println("Please enter correct id of windows");
			}
			
		}catch (Exception e) {
			e.printStackTrace();
			trans.rollback();
			
		}
		finally {
			if(session!=null) {
				session.close();
			}
			if(HibernateUtil.getSessionFactory()!=null) {
				HibernateUtil.getSessionFactory().close();
			}
		}
		
		
	}

}
