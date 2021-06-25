package com.xworkz.xworkzapp.ipl_teams.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.xworkz.singleton.HibernateUtil;
import com.xworkz.xworkzapp.ipl_teams.dto.IplTeamDTO;

public class IplTeamDAOImpl implements IplTeamDAO {
	SessionFactory seFactory;
	Session session =null;
	Transaction transaction =null;
	public void save(IplTeamDTO iplDTO) {
		try {
		seFactory = HibernateUtil.getSessionFactory();
		session = seFactory.openSession();
		transaction = session.beginTransaction();
		session.save(iplDTO);
		System.out.println(iplDTO);
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

	public IplTeamDTO getDetailsByName(String name,int id) {
		try {
		seFactory = HibernateUtil.getSessionFactory();
		session = seFactory.openSession();
		IplTeamDTO ipDTO = session.get(IplTeamDTO.class,id);
		System.out.println(ipDTO.getTeamName());
		if(ipDTO.getTeamName().equalsIgnoreCase(name)) {
			System.out.println("Getting details by name");
			return ipDTO;
		}
		else {
			System.out.println("team name not matching with id, please enter correct id");
		}
	
		}
		finally{
			if(session!=null) {
			session.close();
			}
				
		}
		
		return null;
		
	}

	public void deleteDetails(int idd) {
		
		try {
		seFactory = HibernateUtil.getSessionFactory();
		session = seFactory.openSession();
		transaction = session.beginTransaction();
		session = seFactory.openSession();
		IplTeamDTO ipDTO = session.get(IplTeamDTO.class,idd);
		transaction = session.beginTransaction();
		session.delete(ipDTO);
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

	public void updateDetails(String name, int id, int players) {

		try {
		seFactory = HibernateUtil.getSessionFactory();
		session = seFactory.openSession();
		transaction = session.beginTransaction();
		IplTeamDTO ipDTO = session.get(IplTeamDTO.class,id);
		System.out.println(ipDTO.getTeamName());
		transaction = session.beginTransaction();
		
		if(ipDTO.getTeamName().equalsIgnoreCase(name)) {
			
			ipDTO.setNoOfPlayers(players);
			session.update(ipDTO);
			transaction.commit();
		
		}
		else {
			System.out.println("team name not matching with id, please enter correct id");
		}
		seFactory.close();
		
		}catch (HibernateException e) {
			if(transaction!=null) {
			transaction.rollback();
			}
			
		}
		finally{
			if(session!=null) {
			session.close();
			}
			if(seFactory!=null) {
				seFactory.close();
				}
			
			
	}

	}

	@Override
	public List<IplTeamDTO> getAllDetails() {
		try {
			
			 return HibernateUtil.getSessionFactory().openSession().createQuery("from IplTeamDTO iDTO").list();
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
	public String getIplTeamLocationByIplTeamName(String name) {
		String hql ="select dto.location from IplTeamDTO dto where dto.teamName =:nme ";
		try {
			
			 return (String) HibernateUtil.getSessionFactory().openSession().createQuery(hql).setParameter("nme", name).uniqueResult();
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
	public IplTeamDTO getDetailsByIplTeamName(String name) {
		String hql ="select dto from IplTeamDTO dto where dto.teamName =:nme";
		try {
			
			 return (IplTeamDTO) HibernateUtil.getSessionFactory().openSession().createQuery(hql).setParameter("nme", name).uniqueResult();
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
	public Object[] getIplTeamLocationAndNoOfPlayersByIplTeamName(String name) {
		String hql ="select dto.location,dto.noOfPlayers from IplTeamDTO dto where dto.teamName =:nme";
		try {
			
			 return (Object[]) HibernateUtil.getSessionFactory().openSession().createQuery(hql).setParameter("nme", name).uniqueResult();
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
	public List<Object[]> getiplTeamNameAndNoofPlayersByiplTeamLocation(String location) {
		String hql = "select dto.teamName,dto.noOfPlayers from IplTeamDTO dto where dto.location= :loc ";
		
		try {
			
			return HibernateUtil.getSessionFactory().openSession().createQuery(hql).setParameter("loc", location).list();
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
	public int updateNoOfPlayersByNameH(String name, int players) {
		String hql = "update IplTeamDTO dto set dto.noOfPlayers =:play where dto.teamName=:na ";
		
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			Query query = session.createQuery(hql);
			query.setParameter("play", players);
			query.setParameter("na", name);
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
	public int updateTeamNameByLocation(String location, String name) {
String hql = "update IplTeamDTO dto set dto.teamName =:tn where dto.location=:lc ";
		
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			Query query = session.createQuery(hql);
			query.setParameter("tn", name);
			query.setParameter("lc", location);
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
		return 0;	}

	@Override
	public int deleteByNameH(String name) {
String hql = "delete from IplTeamDTO dto where dto.teamName = :tn ";
		
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			Query query = session.createQuery(hql);
			query.setParameter("tn", name);
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
		return 0;		}

	@Override
	public int deleteLocationH(String location) {
String hql = "delete from IplTeamDTO dto where dto.location = :lcn ";
		
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			Query query = session.createQuery(hql);
			query.setParameter("lcn", location);
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
	public int deleteBySizeH(int size) {
String hql = "delete from IplTeamDTO dto where dto.noOfPlayers = :np ";
		
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			Query query = session.createQuery(hql);
			query.setParameter("np", size);
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
