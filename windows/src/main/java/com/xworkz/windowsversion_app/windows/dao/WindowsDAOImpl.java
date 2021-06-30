package com.xworkz.windowsversion_app.windows.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.xworkz.singleton.HibernateUtil;
import com.xworkz.windowsversion_app.windows.dto.WindowsDTO;

public class WindowsDAOImpl implements WindowsDAO {
	Session session =null;
	Transaction transaction = null;
	public void save(WindowsDTO wnDTO) {
		
		
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
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			WindowsDTO ctDTO = session.get(WindowsDTO.class, id);
			if(ctDTO.getName().equalsIgnoreCase(name)) {
				ctDTO.setReleaseYear(year);
				session.update(ctDTO);
				transaction.commit();
				
			}
			else {
				System.out.println("Please enter correct id of windows");
			}
			
		}catch (Exception e) {
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
		
		
	}

	public void deleteByName(String name, int id) {
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			WindowsDTO stDTO = session.get(WindowsDTO.class, id);
			if(stDTO.getName().equalsIgnoreCase(name)) {
				session.delete(stDTO);
				transaction.commit();
				
			}
			else {
				System.out.println("Please enter correct id of windows");
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
	public String getwindowsNewFeaturesByWindowsName(String name) {
		//String hql = "select dto.newFeatures from WindowsDTO dto where dto.name=:nnn";
		try {
			
			 return (String) HibernateUtil.getSessionFactory().openSession().getNamedQuery("getwindowsNewFeaturesByWindowsName").setParameter("nnn", name).uniqueResult();
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
	public WindowsDTO getDetailsByWindowsName(String name) {
		//String hql = "select dto from WindowsDTO dto where dto.name=:nan";
		try {
			
			 return (WindowsDTO) HibernateUtil.getSessionFactory().openSession().getNamedQuery("getDetailsByWindowsName").setParameter("nan", name).uniqueResult();
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
	public Object[] getwindowsReleaseYearAndNewFeaturesByWindowsName(String name) {
		//String hql = "select dto.releaseYear,dto.newFeatures from WindowsDTO dto where dto.name=:nm";
		try {
			
			 return (Object[]) HibernateUtil.getSessionFactory().openSession().getNamedQuery("getwindowsReleaseYearAndNewFeaturesByWindowsName").setParameter("nm", name).uniqueResult();
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
	public List<Object[]> getwindowsNameAndwindowsNewFeaturesBywindowsReleaseYear(int releaseYear) {
//String hql = "select dto.name,dto.newFeatures from WindowsDTO dto where dto.releaseYear=:ry ";
		
		try {
			
			return HibernateUtil.getSessionFactory().openSession().getNamedQuery("getwindowsNameAndwindowsNewFeaturesBywindowsReleaseYear").setParameter("ry", releaseYear).list();
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
	public int updateReleaseYearByNameH(String name,int releaseYear) {
//String hql = "update WindowsDTO dto set dto.releaseYear = :ryy where dto.name=:nn ";
		
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			Query query = session.getNamedQuery("updateReleaseYearByNameH");
			query.setParameter("ryy", releaseYear);
			query.setParameter("nn", name);
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
	public int updateFearureByNameH(String name, String feature) {
//String hql = "update WindowsDTO dto set dto.newFeatures = :nf where dto.name=:nn ";
		
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			Query query = session.getNamedQuery("updateFearureByNameH");
			query.setParameter("nf", feature);
			query.setParameter("nn", name);
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
				
				
			}
		return 0;
	}

	@Override
	public int deleteByNameH(String name) {
//String hql = "delete from WindowsDTO dto where dto.name=:nn ";
		
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			Query query = session.getNamedQuery("deleteByNameH");
			query.setParameter("nn", name);
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
	public int deleteByYearH(int year) {
//String hql = "delete from WindowsDTO dto where dto.releaseYear=:ry ";
		
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			Query query = session.getNamedQuery("deleteByYearH");
			query.setParameter("ry", year);
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
	public int deleteByFeatureH(String feature) {
//String hql = "delete from WindowsDTO dto where dto.newFeatures=:fy ";
		
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			Query query = session.getNamedQuery("deleteByFeatureH");
			query.setParameter("fy", feature);
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
