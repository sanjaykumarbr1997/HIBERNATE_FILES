package com.xworkz.paint_app.paint.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.xworkz.paint_app.paint.dto.PaintDTO;
import com.xworkz.singleton.HibernateUtil;

public class PaintDAOImpl implements PaintDAO {

	public void save(PaintDTO pDTO) {
		Session session = null;
		Transaction trans = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			trans = session.beginTransaction();
			session.save(pDTO);
			trans.commit();
			
		}catch (HibernateException e) {
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
	public List<PaintDTO> getAllDetails() {
		Session session = null;
		try {
			return HibernateUtil.getSessionFactory().openSession().createQuery("from PaintDTO pdto").list();
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
	
	public void updatePriceByName(String name, int id, double price) {
		Session session =null;
		Transaction transc=null;
		try {
		session=HibernateUtil.getSessionFactory().openSession();
		transc = session.beginTransaction();
		PaintDTO pnDTO = session.get(PaintDTO.class,id);
		if(pnDTO.getName().equalsIgnoreCase(name)) {
			pnDTO.setPrice(price);
			session.update(pnDTO);
			transc.commit();
		}
		else {
			System.out.println("Enter correct id of paint name");
		}
		}catch (HibernateException e) {
			e.printStackTrace();
			transc.rollback();
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
	public void deleteDetailsByName(String name, int id) {
		Session session =null;
		Transaction transc=null;
		try {
		session=HibernateUtil.getSessionFactory().openSession();
		transc = session.beginTransaction();
		PaintDTO pnDTO = session.get(PaintDTO.class,id);
		if(pnDTO.getName().equalsIgnoreCase(name)) {
			session.delete(pnDTO);
			transc.commit();
		}
		else {
			System.out.println("Enter correct id of paint name");
		}
		}catch (HibernateException e) {
			e.printStackTrace();
			transc.rollback();
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
	public String getPintColorByPrice(double price) {
		Session session =null;
		try {
			session=HibernateUtil.getSessionFactory().openSession();
			Query qry = session.createQuery("select dto.color from PaintDTO dto where dto.price = '"+price+"' ");
			String s =(String) qry.uniqueResult();
			
			return s;
			
		
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

	public PaintDTO getDetailsByName(String name) {
		PaintDTO pntDTO = new PaintDTO();
		Session session =null;
		try {
			session=HibernateUtil.getSessionFactory().openSession();
			Query qry = session.createQuery("select dto from PaintDTO dto where dto.name = '"+name+"' ");
			pntDTO = (PaintDTO) qry.uniqueResult();
			
			return pntDTO;
			
		
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
	public Object[] getPaintPriceAndPaintColorByName(String name) {
		Object[] ob =null;
		Session session =null;
		try {
			session=HibernateUtil.getSessionFactory().openSession();
			Query qry = session.createQuery("select dto.price,dto.color from PaintDTO dto where dto.name = '"+name+"' ");
			ob = (Object[]) qry.uniqueResult();
			
			return ob;
			
		
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
	public List<Object[]> getPaintPriceAndPaintColorByExpiryYear(int year) {
		String hql = "select dto.price,dto.color from PaintDTO dto where dto.year="+year+" ";
		Session session = null;
		try {
			return (List<Object[]>) HibernateUtil.getSessionFactory().openSession().createQuery(hql).list();
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
	public int updatePriceByNameH(String name, double price) {
		String hql = "update PaintDTO dto set dto.price='"+ price+"' where dto.name='"+name+"'";
		Session session =null;
		Transaction transc=null;
		try {
		session=HibernateUtil.getSessionFactory().openSession();
		transc = session.beginTransaction();
		Query query =session.createQuery(hql);
		int rw =query.executeUpdate();
		transc.commit();
		return rw;
		
		}catch (HibernateException e) {
			e.printStackTrace();
			transc.rollback();
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
		String hql = "update PaintDTO dto set dto.color='"+ color+"' where dto.name='"+name+"'";
		Session session =null;
		Transaction transc=null;
		try {
		session=HibernateUtil.getSessionFactory().openSession();
		transc = session.beginTransaction();
		Query query =session.createQuery(hql);
		int rw =query.executeUpdate();
		transc.commit();
		return rw;
		
		}catch (HibernateException e) {
			e.printStackTrace();
			transc.rollback();
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
	public int updateYearOfExpiryByNameH(String name, int year) {
		String hql = "update PaintDTO dto set dto.year="+ year+" where dto.name='"+name+"'";
		Session session =null;
		Transaction transc=null;
		try {
		session=HibernateUtil.getSessionFactory().openSession();
		transc = session.beginTransaction();
		Query query =session.createQuery(hql);
		int rw =query.executeUpdate();
		transc.commit();
		return rw;
		
		}catch (HibernateException e) {
			e.printStackTrace();
			transc.rollback();
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
	public int deletPriceByNameH(String name) {
		String hql = "delete from PaintDTO dto where dto.name = '"+name+"'";
		Session session =null;
		Transaction transc=null;
		try {
		session=HibernateUtil.getSessionFactory().openSession();
		transc = session.beginTransaction();
		Query query =session.createQuery(hql);
		int rw =query.executeUpdate();
		transc.commit();
		return rw;
		
		}catch (HibernateException e) {
			e.printStackTrace();
			transc.rollback();
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
	public int deletPriceByYearH(int year) {
		String hql = "delete from PaintDTO dto where dto.year = "+year+"";
		Session session =null;
		Transaction transc=null;
		try {
		session=HibernateUtil.getSessionFactory().openSession();
		transc = session.beginTransaction();
		Query query =session.createQuery(hql);
		int rw =query.executeUpdate();
		transc.commit();
		return rw;
		
		}catch (HibernateException e) {
			e.printStackTrace();
			transc.rollback();
		}
		finally {
			if(session!=null) {
				session.close();
			}
			
		}
		return 0;
	}

	@Override
	public int deletPriceByColorH(String color) {
		String hql = "delete from PaintDTO dto where dto.color = '"+color+"'";
		Session session =null;
		Transaction transc=null;
		try {
		session=HibernateUtil.getSessionFactory().openSession();
		transc = session.beginTransaction();
		Query query =session.createQuery(hql);
		int rw =query.executeUpdate();
		transc.commit();
		return rw;
		
		}catch (HibernateException e) {
			e.printStackTrace();
			transc.rollback();
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
