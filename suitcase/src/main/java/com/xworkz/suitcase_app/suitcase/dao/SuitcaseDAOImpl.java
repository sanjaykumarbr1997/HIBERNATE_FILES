package com.xworkz.suitcase_app.suitcase.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.xworkz.singleton.HibernateUtil;
import com.xworkz.suitcase_app.suitcase.dto.SuitcaseDTO;

public class SuitcaseDAOImpl implements SuitcaseDAO {
	Session session =null;
	Transaction transaction =null;

	@Override
	public void save(SuitcaseDTO suiDTO) {
		try {
		session =HibernateUtil.getSessionFactory().openSession();
		transaction = session.beginTransaction();
		session.save(suiDTO);
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
	public List<SuitcaseDTO> getAllDetails() {

		try {
		
		 return HibernateUtil.getSessionFactory().openSession().createQuery("from SuitcaseDTO suiDTO").list();
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
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			SuitcaseDTO ctDTO = session.get(SuitcaseDTO.class, id);
			if(ctDTO.getName().equalsIgnoreCase(name)) {
				ctDTO.setColor(color);
				session.update(ctDTO);
				transaction.commit();
				
			}
			else {
				System.out.println("Please enter correct id of suitcase");
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
	public void deleteColorByName(String name, int id) {
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			SuitcaseDTO stDTO = session.get(SuitcaseDTO.class, id);
			if(stDTO.getName().equalsIgnoreCase(name)) {
				session.delete(stDTO);
				transaction.commit();
				
			}
			else {
				System.out.println("Please enter correct id of suitcase");
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
	public String getSuitcaseColorBySuitcaseName(String name) {
		String hql = "select dto.color from SuitcaseDTO dto where dto.name = '"+name+"'";
		try {
			
			 return (String) HibernateUtil.getSessionFactory().openSession().createQuery(hql).uniqueResult();
			}catch (Exception e) {
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
	public SuitcaseDTO getDetailsBySuitcaseName(String name) {
		String hql = "select dto from SuitcaseDTO dto where dto.name = '"+name+"'";
		try {
			
			 return (SuitcaseDTO) HibernateUtil.getSessionFactory().openSession().createQuery(hql).uniqueResult();
			}catch (Exception e) {
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
	public Object[] getSuitcaseSizeAndColorBysuitcaseName(String name) {
		String hql = "select dto.size,dto.color from SuitcaseDTO dto where dto.name = '"+name+"'";
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
	public List<Object[]> getsuitcaseNameAndsuitcaseColorBysuitcaseSize(String size) {
String hql = "select dto.name,dto.color from SuitcaseDTO dto where dto.size='"+size +"' ";
		
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
	public int updateSizeByNameH(String name, String size) {
String hql = "update SuitcaseDTO dto set dto.size ='"+size+"' where dto.name='"+name +"' ";
		
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

	public int updateColorByNameH(String name, String color) {
String hql = "update SuitcaseDTO dto set dto.color ='"+color+"' where dto.name='"+name +"' ";
		
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
	public int deleteByNameH(String name) {
String hql = "delete from SuitcaseDTO dto where dto.name='"+name +"' ";
		
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
	public int deleteByColorH(String color) {
String hql = "delete from SuitcaseDTO dto where dto.color='"+color +"' ";
		
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
	public int deleteBySizeH(String size) {
String hql = "delete from SuitcaseDTO dto where dto.size='"+size +"' ";
		
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
