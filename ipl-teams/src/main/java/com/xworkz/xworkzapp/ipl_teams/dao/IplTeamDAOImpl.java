package com.xworkz.xworkzapp.ipl_teams.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.xworkz.xworkzapp.ipl_teams.dto.IplTeamDTO;

public class IplTeamDAOImpl implements IplTeamDAO {

	public void save(IplTeamDTO iplDTO) {
		
		Configuration configure = new Configuration();
		configure.configure();
		configure.addAnnotatedClass(IplTeamDTO.class);
		SessionFactory seFactory = configure.buildSessionFactory();
		Session session = seFactory.openSession();
		Transaction transaction = session.beginTransaction();
		session.save(iplDTO);
		transaction.commit();
		session.close();
		seFactory.close();
		
	}

	public IplTeamDTO getDetailsByName(String name,int id) {
		
		Configuration configure = new Configuration();
		configure.configure();
		configure.addAnnotatedClass(IplTeamDTO.class);
		SessionFactory seFactory = configure.buildSessionFactory();
		Session session = seFactory.openSession();
		IplTeamDTO ipDTO = session.get(IplTeamDTO.class,id);
		System.out.println(ipDTO.getTeamName());
		if(ipDTO.getTeamName().equalsIgnoreCase(name)) {
			System.out.println("Getting details by name");
			
			return ipDTO;
			
		}
		else {
			System.out.println("team name not matching with id, please enter correct id");
		}
		
		session.close();
		seFactory.close();
		return null;
		
		
		
	}

	public void deleteDetails(int idd) {
		Configuration configure = new Configuration();
		configure.configure();
		configure.addAnnotatedClass(IplTeamDTO.class);
		SessionFactory seFactory = configure.buildSessionFactory();
		Session session = seFactory.openSession();
		IplTeamDTO ipDTO = session.get(IplTeamDTO.class,idd);
		Transaction ts = session.beginTransaction();
		session.delete(ipDTO);
		ts.commit();
		session.close();
		seFactory.close();
		
		
	}

	public void updateDetails(String name, int id, int players) {
		Configuration configure = new Configuration();
		configure.configure();
		configure.addAnnotatedClass(IplTeamDTO.class);
		SessionFactory seFactory = configure.buildSessionFactory();
		Session session = seFactory.openSession();
		IplTeamDTO ipDTO = session.get(IplTeamDTO.class,id);
		System.out.println(ipDTO.getTeamName());
		Transaction tss = session.beginTransaction();
		
		if(ipDTO.getTeamName().equalsIgnoreCase(name)) {
			
			ipDTO.setNoOfPlayers(players);
			session.update(ipDTO);
			tss.commit();
		
		}
		else {
			System.out.println("team name not matching with id, please enter correct id");
		}
		
		session.close();
		seFactory.close();
		
	}

}
