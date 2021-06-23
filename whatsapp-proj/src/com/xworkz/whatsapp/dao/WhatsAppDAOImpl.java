package com.xworkz.whatsapp.dao;

import java.util.List;

import org.hibernate.Session;

import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.xworkz.singleton.HibernateUtil;
import com.xworkz.whatsapp.dto.WhatsAppDTO;

public class WhatsAppDAOImpl implements WhatsAppDAO{

	@Override
	public void createWhatsApp(WhatsAppDTO wDTO) {
		
		//hybernate logic
		
		Configuration configuration = new Configuration();
		configuration.configure();
		configuration.addAnnotatedClass(WhatsAppDTO.class);
		SessionFactory factory = configuration.buildSessionFactory();
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		session.save(wDTO);
		transaction.commit();
		session.close();
		factory.close();
		
		
	}

	@Override
	public List<WhatsAppDTO> getAllDetails() {
		Session session = null;
		try {
			
			 return HibernateUtil.getSessionFactory().openSession().createQuery("from WhatsAppDTO wDTO").list();
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
