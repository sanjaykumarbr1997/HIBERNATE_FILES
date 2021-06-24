package com.xworkz.chocolate_app.chocolate.dao;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import com.xworkz.chocolate_app.chocolate.dto.ChocoloateDTO;
import com.xworkz.singleton.HibernateUtil;


public class ChocolateDAOImpl implements ChocolateDAO {
	Session session =null;
	@Override
	public void save(ChocoloateDTO cDTO) {
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
			/*if(HibernateUtil.getSessionFactory()!=null) {
				HibernateUtil.getSessionFactory().close();
			}*/
		}
		
		
	}
	@Override
	public List<ChocoloateDTO> getAllDetails() {
		
		try {
		session =HibernateUtil.getSessionFactory().openSession();
		Query query = session.createQuery("select csdto from ChocoloateDTO csdto");
		List<ChocoloateDTO> chocoDTOs =query.list();
		return chocoDTOs;
		 //return HibernateUtil.getSessionFactory().openSession().createQuery("from ChocoloateDTO csdto").list();
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
			ChocoloateDTO ctDTO = session.get(ChocoloateDTO.class, id);
			if(ctDTO.getName().equalsIgnoreCase(name)) {
				ctDTO.setColor(color);
				session.update(ctDTO);
				trans.commit();
				
			}
			else {
				System.out.println("Please enter correct id of chocolate");
			}
			
		}catch (Exception e) {
			e.printStackTrace();
			trans.rollback();
			
		}
		finally {
			if(session!=null) {
				session.close();
			}
			
		}
	}
	@Override
	public void deleteColorByName(String name, int id) {
		Transaction trans= null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			trans = session.beginTransaction();
			ChocoloateDTO ctDTO = session.get(ChocoloateDTO.class, id);
			if(ctDTO.getName().equalsIgnoreCase(name)) {
				session.delete(ctDTO);
				trans.commit();
				
			}
			else {
				System.out.println("Please enter correct id of chocolate");
			}
			
		}catch (Exception e) {
			e.printStackTrace();
			trans.rollback();
			
		}
		finally {
			if(session!=null) {
				session.close();
			}
			
		}
		
	}
	@Override
	public String getChocolateCompanyByChocolateName(String name) {
		Session session = null;
		String hql = "Select dto.company from ChocoloateDTO dto where dto.name='"+name+"' ";
		try {
			return (String) HibernateUtil.getSessionFactory().openSession().createQuery(hql).uniqueResult();
		}catch (HibernateException e) {
			e.printStackTrace();
		}
		finally {
			if(session!=null) {
				session.close();
			}
			
		}
		return null;
	}
	@Override
	public ChocoloateDTO getDetailsByChocolatename(String name) {
		Session session = null;
		String hql = "Select dto from ChocoloateDTO dto where dto.name='"+name+"' ";
		try {
			return (ChocoloateDTO) HibernateUtil.getSessionFactory().openSession().createQuery(hql).uniqueResult();
		}catch (HibernateException e) {
			e.printStackTrace();
		}
		finally {
			if(session!=null) {
				session.close();
			}
			
		}
		return null;
	}
	@Override
	public Object[] getChocolatePriceAndChocolateColorByChocolateName(String name) {
		Session session = null;
		String hql = "Select dto.price,dto.color from ChocoloateDTO dto where dto.name='"+name+"' ";
		try {
			return (Object[]) HibernateUtil.getSessionFactory().openSession().createQuery(hql).uniqueResult();
		}catch (HibernateException e) {
			e.printStackTrace();
		}
		finally {
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
