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
	Transaction transaction =null;
	@Override
	public void save(ChocoloateDTO cDTO) {
		try {
		session =HibernateUtil.getSessionFactory().openSession();
		transaction = session.beginTransaction();
		session.save(cDTO);
		//session.saveOrUpdate(cDTO);
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
		Query query = session.getNamedQuery("getAllDetails");
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
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			ChocoloateDTO ctDTO = session.get(ChocoloateDTO.class, id);
			if(ctDTO.getName().equalsIgnoreCase(name)) {
				session.delete(ctDTO);
				transaction.commit();
				
			}
			else {
				System.out.println("Please enter correct id of chocolate");
			}
			
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
	public String getChocolateCompanyByChocolateName(String name) {
		Session session = null;
		//String hql = "Select dto.company from ChocoloateDTO dto where dto.name = :nm";
		try {
			return (String) HibernateUtil.getSessionFactory().openSession().getNamedQuery("getChocolateCompanyByChocolateName").setParameter("nm", name).uniqueResult();
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
		//String hql = "Select dto from ChocoloateDTO dto where dto.name = :nm";
		try {
			return (ChocoloateDTO) HibernateUtil.getSessionFactory().openSession().getNamedQuery("getDetailsByChocolatename").setParameter("nm", name).uniqueResult();
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
		//String hql = "Select dto.price,dto.color from ChocoloateDTO dto where dto.name = :nm";
		try {
			return (Object[]) HibernateUtil.getSessionFactory().openSession().getNamedQuery("getChocolatePriceAndChocolateColorByChocolateName").setParameter("nm", name).uniqueResult();
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
	@Override
	public List<Object[]> getchocolatePriceAndchocolateColorByChocolateName(String name) {
		//String hql="select dto.price,dto.color from ChocoloateDTO dto where dto.company = :nm";
		try {
		return HibernateUtil.getSessionFactory().openSession().getNamedQuery("getchocolatePriceAndchocolateColorByChocolateName").setParameter("nm", name).list();
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
	@Override
	public int updatePriceByNameH(String name,double price) {
		//String hql="update ChocoloateDTO dto set dto.price=:pr  where dto.name = :nm";
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			Query query= session.getNamedQuery("updatePriceByNameH");
			query.setParameter("pr", price);
			query.setParameter("nm", name);
			int r =query.executeUpdate();
			transaction.commit();
			return r;
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
		return 0;
	}
	@Override
	public int updateColorByNameH(String name, String color) {
		//String hql="update ChocoloateDTO dto set dto.color=:clr where dto.name = :nm";
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			Query query= session.getNamedQuery("updateColorByNameH");
			query.setParameter("clr", color);
			query.setParameter("nm", name);
			int r =query.executeUpdate();
			transaction.commit();
			return r;
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
		return 0;
	}
	@Override
	public int updateCompanyNameByNameH(String name, String companyName) {
	//	String hql="update ChocoloateDTO dto set dto.company=:cmp where dto.name = :nm";
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			Query query= session.getNamedQuery("updateCompanyNameByNameH");
			query.setParameter("cmp", companyName);
			query.setParameter("nm", name);
			int r =query.executeUpdate();
			transaction.commit();
			return r;
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
		return 0;
	}
	@Override
	public int deleteByNameH(String name) {
		//String hql="delete from ChocoloateDTO dto where dto.name = :nm";
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			Query query= session.getNamedQuery("deleteByNameH");
			query.setParameter("nm", name);
			int r =query.executeUpdate();
			transaction.commit();
			return r;
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
		return 0;
	}
	@Override
	public int deleteByPriceH(double price) {
		//String hql="delete from ChocoloateDTO dto where dto.price = :pr";
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			Query query= session.getNamedQuery("deleteByPriceH");
			query.setParameter("pr", price);
			int r =query.executeUpdate();
			transaction.commit();
			return r;
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
		return 0;	}
	@Override
	public int deleteByColorH(String color) {
		//String hql="delete from ChocoloateDTO dto where dto.color = :clr";
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			Query query= session.getNamedQuery("deleteByColorH");
			query.setParameter("clr", color);
			int r =query.executeUpdate();
			transaction.commit();
			return r;
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
		return 0;
	}
	

}
