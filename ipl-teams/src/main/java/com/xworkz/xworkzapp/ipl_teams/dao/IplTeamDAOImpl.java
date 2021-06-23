package com.xworkz.xworkzapp.ipl_teams.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

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

}
