package com.xworkz.paint_app.paint.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

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
			return HibernateUtil.getSessionFactory().openSession().createQuery("from PaintDTO pdto").getResultList();
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
			if(HibernateUtil.getSessionFactory()!=null) {
				HibernateUtil.getSessionFactory().close();
			}
		}
		
		
	}

}
