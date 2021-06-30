package com.xworkz.sweets_app.sweets.dao;

import java.util.List;

import org.hibernate.HibernateException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.xworkz.singleton.HibernateUtil;
import com.xworkz.sweets_app.sweets.dto.SweetsDTO;

public class SweetsDAOImpl implements SweetsDAO {
	

	SessionFactory sessionFactory=null;
	Session session =null;
	Transaction transaction =null;
	public void save(SweetsDTO sDTO) {
		
		try {
			
		 sessionFactory=HibernateUtil.getSessionFactory();
		//System.out.println((sessionFactory));
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
			
			
		}
		
		
		 
	}

	public SweetsDTO getDetailsByName(int id, String name) {
		
		try {
		session=HibernateUtil.getSessionFactory().openSession();
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
			
		}
		
	}

	public void updateColorByName(int id, String name, String color) {
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
			
		}
		
	}

	public void deleteByName(int id, String name) {
		try {
		sessionFactory=HibernateUtil.getSessionFactory();
		//System.out.println((sessionFactory));
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

	@Override
	public List<SweetsDTO> getAllDetails() {
		
		try {
			
			return HibernateUtil.getSessionFactory().openSession().createQuery("from SweetsDTO sDTO").list();
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
	public String getSweetsColorBySweetName(String name) {
//		String hql = "select dto.color from SweetsDTO dto where dto.name =:nam";
		try {
			
			return (String) HibernateUtil.getSessionFactory().openSession().getNamedQuery("getSweetsColorBySweetName").setParameter("nam", name).uniqueResult();
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
	public SweetsDTO getDetailsBySweetName(String name) {
		//String hql = "select dto from SweetsDTO dto where dto.name =:nm ";
		try {
			
			return (SweetsDTO) HibernateUtil.getSessionFactory().openSession().getNamedQuery("getDetailsBySweetName").setParameter("nm", name).uniqueResult();
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
	public Object[] getsweetShapeAndColorBySweetName(String name) {
		//String hql = "select dto.shape,dto.color from SweetsDTO dto where dto.name =:name ";
		try {
			
			return (Object[]) HibernateUtil.getSessionFactory().openSession().getNamedQuery("getsweetShapeAndColorBySweetName").setParameter("name", name).uniqueResult();
			}catch (HibernateException e) {
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
	public List<Object[]> getsweetPriceAndsweetColorBysweetshape(String shape) {
//String hql = "select dto.name,dto.color from SweetsDTO dto where dto.shape=:sha ";
		
		try {
			
			return HibernateUtil.getSessionFactory().openSession().getNamedQuery("getsweetPriceAndsweetColorBysweetshape").setParameter("sha", shape).list();
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
//String hql = "update SweetsDTO dto set dto.price =:pri where dto.name=:nam ";
		
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			Query query = session.getNamedQuery("updatePriceByNameH");
			query.setParameter("nam", name);
			query.setParameter("pri", price);
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
//String hql = "update SweetsDTO dto set dto.color =:cl where dto.name=:nm ";
		
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			Query query = session.getNamedQuery("updateColorByNameH");
			query.setParameter("nm",name);
			query.setParameter("cl", color);
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
	public int updatesweetshapeByNameH(String name, String shape) {
//String hql = "update SweetsDTO dto set dto.shape =:sh where dto.name=:na ";
		
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			Query query = session.getNamedQuery("updatesweetshapeByNameH");
			query.setParameter("na", name);
			query.setParameter("sh", shape);
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
//String hql = "delete from SweetsDTO dto where dto.name=:nam ";
		
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			Query query = session.getNamedQuery("deleteByNameH");
			query.setParameter("nam", name);
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
	public int deleteByPriceH(double price) {
//String hql = "delete from SweetsDTO dto where dto.price=:pri";
		
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			Query query = session.getNamedQuery("deleteByPriceH");
			query.setParameter("pri", price);
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
//String hql = "delete from SweetsDTO dto where dto.color=:clr ";
		
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			Query query = session.getNamedQuery("deleteByColorH");
			query.setParameter("clr", color);
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
