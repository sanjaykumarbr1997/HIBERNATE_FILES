package com.xworkz.suitcase_app.suitcase.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.xworkz.singleton.HibernateUtil;
import com.xworkz.suitcase_app.suitcase.dto.SuitcaseDTO;

public class SuitcaseDAOImpl implements SuitcaseDAO {
	Session session =null;

	@Override
	public void save(SuitcaseDTO suiDTO) {
		Transaction transaction = null;
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
		Transaction trans= null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			trans = session.beginTransaction();
			SuitcaseDTO ctDTO = session.get(SuitcaseDTO.class, id);
			if(ctDTO.getName().equalsIgnoreCase(name)) {
				ctDTO.setColor(color);
				session.update(ctDTO);
				trans.commit();
				
			}
			else {
				System.out.println("Please enter correct id of suitcase");
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
			SuitcaseDTO stDTO = session.get(SuitcaseDTO.class, id);
			if(stDTO.getName().equalsIgnoreCase(name)) {
				session.delete(stDTO);
				trans.commit();
				
			}
			else {
				System.out.println("Please enter correct id of suitcase");
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

}
