package com.xworkz.icecream_app.icecream.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.xworkz.icecream_app.icecream.dto.IceCreamDTO;
import com.xworkz.singleton.HibernateUtil;

public class IceCreamDAOImpl implements IceCreamDAO {
	Session session = null;
	Transaction transaction = null;
	public void save(IceCreamDTO iDTO) {
		try {
		session = HibernateUtil.getSessionFactory().openSession();
		transaction = session.beginTransaction();
		session.save(iDTO);
		transaction.commit();
		}
		catch (HibernateException e) {
			e.printStackTrace();
			transaction.rollback();
		}
		finally {
			session.close();
			HibernateUtil.getSessionFactory().close();
		}
	}

}
