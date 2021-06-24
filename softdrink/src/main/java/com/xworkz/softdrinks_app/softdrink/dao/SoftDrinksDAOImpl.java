package com.xworkz.softdrinks_app.softdrink.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import com.xworkz.singleton.HibernateUtil;
import com.xworkz.softdrinks_app.softdrink.dto.SoftDrinksDTO;

public class SoftDrinksDAOImpl implements SoftDrinksDAO {
	
	
	Session session = null;

	@Override
	public void save(SoftDrinksDTO cDTO) {
		Transaction transaction = null;
		try {
		session =HibernateUtil.getSessionFactory().openSession();
		transaction = session.beginTransaction();
		session.save(cDTO);
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

	@Override
	public List<SoftDrinksDTO> getAllDetails() {
		try {
			
			 return HibernateUtil.getSessionFactory().openSession().createQuery("from SoftDrinksDTO ssdto").list();
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

	@Override
	public void updateColorByName(String name, int id, String color) {
		Transaction trans= null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			trans = session.beginTransaction();
			SoftDrinksDTO stDTO = session.get(SoftDrinksDTO.class, id);
			if(stDTO.getName().equalsIgnoreCase(name)) {
				stDTO.setColor(color);
				session.update(stDTO);
				trans.commit();
				
			}
			else {
				System.out.println("Please enter correct id of softdrinks");
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

	@Override
	public void deleteColorByName(String name, int id) {
		Transaction trans= null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			trans = session.beginTransaction();
			SoftDrinksDTO stDTO = session.get(SoftDrinksDTO.class, id);
			if(stDTO.getName().equalsIgnoreCase(name)) {
				session.delete(stDTO);
				trans.commit();
				
			}
			else {
				System.out.println("Please enter correct id of softdrinks");
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

	@Override
	public String getSoftdrinkColorBySoftdrinkName(String name) {
		String hql = "select dto.color from SoftDrinksDTO dto where dto.name = '"+name+"' ";
		try {
			
			 return (String) HibernateUtil.getSessionFactory().openSession().createQuery(hql).uniqueResult();
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

	@Override
	public SoftDrinksDTO getDetailsBySoftdrinkName(String name) {
		String hql = "select dto from SoftDrinksDTO dto where dto.name = '"+name+"' ";
		try {
			
			 return (SoftDrinksDTO) HibernateUtil.getSessionFactory().openSession().createQuery(hql).uniqueResult();
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

	@Override
	public Object[] getSoftdrinkManufactureYearAndPricesBySoftdrinkName(String name) {
		String hql = "select dto.mfgYear,dto.price from SoftDrinksDTO dto where dto.name = '"+name+"' ";
		try {
			
			 return (Object[]) HibernateUtil.getSessionFactory().openSession().createQuery(hql).uniqueResult();
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
		
	

}
