package com.xworkz.pub.pub.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.xworkz.pub.pub.dto.PubDTO;
import com.xworkz.singleton.HibernateUtil;

public class PubDAOImpl implements PubDAO {
	Transaction transaction = null;

	public void save(PubDTO pDTO) {
		
		Session session = null;
		Transaction transaction = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			transaction=session.beginTransaction();
			//session.save(pDTO);
			//session.persist(pDTO);
			session.saveOrUpdate(pDTO);
			transaction.commit();
			
		}catch (HibernateException e) {
			e.printStackTrace();
			transaction.rollback();
		}
		finally {
			if(session!=null) {
				session.close();
			}
			
		}
		
	}

	public PubDTO getDetailsByName(String name, int id) {

		Session session = null;
	
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			PubDTO pubDTO =session.get(PubDTO.class, id);
			System.out.println(pubDTO);
			return pubDTO;
			
		}catch (HibernateException e) {
			e.printStackTrace();
			transaction.rollback();
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

	public void update(String name, int id, String contact) {
		Session session1 = null;
		try {
		session1 = HibernateUtil.getSessionFactory().openSession();
		PubDTO pDTO = session1.get(PubDTO.class, id);
		pDTO.setContactNo(contact);
		transaction = session1.beginTransaction();
		session1.update(pDTO);
		//session.merge(pDTO);
		transaction.commit();
		}
		catch (HibernateException e) {
			e.printStackTrace();
			transaction.rollback();
		}
		finally {
			if(session1!=null) {
				session1.close();
			}
			if(HibernateUtil.getSessionFactory()!=null) {
				HibernateUtil.getSessionFactory().close();
			}
			
		}
		
		
	}

	public void checking() {
		try {
		PubDTO emp1 = new PubDTO();
		emp1.setId(7);
		emp1.setName("Dinesh");
		emp1.setLocation("ban");
		emp1.setContactNo("6767676767");
		//create session
		Session session1 =HibernateUtil.getSessionFactory().openSession();
		transaction = session1.beginTransaction();
		session1.saveOrUpdate(emp1);
		transaction.commit();
		session1.close();
		//emp1 object in detached state now

		emp1.setName("Dinesh Rajput");//Updated Name
		//Create session again
		Session session2 = HibernateUtil.getSessionFactory().openSession();
		PubDTO emp2 =(PubDTO)session2.get(PubDTO.class, 7);
		//emp2 object in persistent state with id 100
		Transaction tss = session2.beginTransaction();
		
		//below we try to make on detached object with id 100 to persistent state by using update method of hibernate
		//session2.update(emp1);//It occurs the exception NonUniqueObjectException because emp2 object is having PubDTO with same empid as 100. In order //to avoid this exception we are using merge like given below instead of session.update(emp1);
		
		//session2.merge(emp1); //it merge the object state with emp2
		session2.update(emp1); //Now it will work with exception
		tss.commit();
		session1.close();
		session2.close();
		}
		catch (HibernateException e) {
			e.printStackTrace();
		}
		
		
		
	}

	public void delete(int id) {
		Session session = null;
		try {
			session= HibernateUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			PubDTO pdDTO = session.get(PubDTO.class, id);
			session.delete(pdDTO);
			//session.evict(pdDTO);
			transaction.commit();
		}
		catch (HibernateException e) {
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

}
