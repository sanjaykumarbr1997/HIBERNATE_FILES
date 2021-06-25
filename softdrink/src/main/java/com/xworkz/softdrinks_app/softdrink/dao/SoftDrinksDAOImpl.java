package com.xworkz.softdrinks_app.softdrink.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.xworkz.singleton.HibernateUtil;
import com.xworkz.softdrinks_app.softdrink.dto.SoftDrinksDTO;

public class SoftDrinksDAOImpl implements SoftDrinksDAO {
	Transaction transaction = null;
	
	Session session = null;

	@Override
	public void save(SoftDrinksDTO cDTO) {
		
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
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			SoftDrinksDTO stDTO = session.get(SoftDrinksDTO.class, id);
			if(stDTO.getName().equalsIgnoreCase(name)) {
				session.delete(stDTO);
				transaction.commit();
				
			}
			else {
				System.out.println("Please enter correct id of softdrinks");
			}
			
		}catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
			
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

	@Override
	public List<Object[]> getsoftdrinkPriceAndsoftdrinkColorBysoftdrinkmfgyear(int mfgYear) {
String hql = "select dto.color,dto.price from SoftDrinksDTO dto where dto.mfgYear="+mfgYear +" ";
		
		try {
			
			return HibernateUtil.getSessionFactory().openSession().createQuery(hql).list();
			}catch (HibernateException e) {
				e.printStackTrace();
			}
			finally{
				if(session!=null) {
					session.close();
				}
				
				
			}
		return null;
	}

	@Override
	public int updatePriceByNameH(String name, double price) {
String hql = "update SoftDrinksDTO dto set dto.price ="+price+" where dto.name='"+name +"' ";
		
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			Query query = session.createQuery(hql);
			int r = query.executeUpdate();
			
			transaction.commit();
			return r; 
			}catch (HibernateException e) {
				e.printStackTrace();
				transaction.rollback();
			}
			finally{
				if(session!=null) {
					session.close();
				}
				if(HibernateUtil.getSessionFactory()!=null) {
					HibernateUtil.getSessionFactory().close();
				}
				
			}
		return 0;
	}

	@Override
	public int updateColorByNameH(String name, String color) {
String hql = "update SoftDrinksDTO dto set dto.color ='"+color+"' where dto.name='"+name +"' ";
		
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			Query query = session.createQuery(hql);
			int r = query.executeUpdate();
			
			transaction.commit();
			return r; 
			}catch (HibernateException e) {
				e.printStackTrace();
				transaction.rollback();
			}
			finally{
				if(session!=null) {
					session.close();
				}
				if(HibernateUtil.getSessionFactory()!=null) {
					HibernateUtil.getSessionFactory().close();
				}
				
			}
		return 0;
	}

	@Override
	public int updateColorByNameH(String name, int mfgyear) {
String hql = "update SoftDrinksDTO dto set dto.mfgYear ="+mfgyear+" where dto.name='"+name +"' ";
		
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			Query query = session.createQuery(hql);
			int r = query.executeUpdate();
			
			transaction.commit();
			return r; 
			}catch (HibernateException e) {
				e.printStackTrace();
				transaction.rollback();
			}
			finally{
				if(session!=null) {
					session.close();
				}
				if(HibernateUtil.getSessionFactory()!=null) {
					HibernateUtil.getSessionFactory().close();
				}
				
			}
		return 0;
	}

	@Override
	public int deleteColorByNameH(String name) {
String hql = "delete from SoftDrinksDTO dto where dto.name='"+name +"' ";
		
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			Query query = session.createQuery(hql);
			int r = query.executeUpdate();
			
			transaction.commit();
			return r; 
			}catch (HibernateException e) {
				e.printStackTrace();
				transaction.rollback();
			}
			finally{
				if(session!=null) {
					session.close();
				}
				if(HibernateUtil.getSessionFactory()!=null) {
					HibernateUtil.getSessionFactory().close();
				}
				
			}
		return 0;
	}

	@Override
	public int deleteColorByPriceH(double price) {
String hql = "delete from SoftDrinksDTO dto where dto.price="+price +" ";
		
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			Query query = session.createQuery(hql);
			int r = query.executeUpdate();
			
			transaction.commit();
			return r; 
			}catch (HibernateException e) {
				e.printStackTrace();
				transaction.rollback();
			}
			finally{
				if(session!=null) {
					session.close();
				}
				if(HibernateUtil.getSessionFactory()!=null) {
					HibernateUtil.getSessionFactory().close();
				}
				
			}
		return 0;
	}

	@Override
	public int deleteColorByColorH(String color) {
String hql = "delete from SoftDrinksDTO dto where dto.color='"+color +"' ";
		
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			Query query = session.createQuery(hql);
			int r = query.executeUpdate();
			
			transaction.commit();
			return r; 
			}catch (HibernateException e) {
				e.printStackTrace();
				transaction.rollback();
			}
			finally{
				if(session!=null) {
					session.close();
				}
				if(HibernateUtil.getSessionFactory()!=null) {
					HibernateUtil.getSessionFactory().close();
				}
				
			}
		return 0;
	
		
	}

}
