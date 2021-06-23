package com.xworkz.xworkzapp.blue_tooth.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.xworkz.singleton.HibernateUtil;
import com.xworkz.xworkzapp.blue_tooth.dto.BluetoothSpeakerDTO;

public class BluetoothSpeakerDAOImpl implements BluetoothSpeakerDAO {

	public void save(BluetoothSpeakerDTO bluetoothSpeakerDTO) {
		
		Configuration configuration = new Configuration();
		configuration.configure();
		configuration.addAnnotatedClass(BluetoothSpeakerDTO.class);
		SessionFactory factory = configuration.buildSessionFactory();
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		session.save(bluetoothSpeakerDTO);
		transaction.commit();
		session.close();
		factory.close();
		
		
	}

	public BluetoothSpeakerDTO getBrandById(int id) {
		
		Configuration config = new Configuration();
		config.configure();
		config.addAnnotatedClass(BluetoothSpeakerDTO.class);
		SessionFactory factory = config.buildSessionFactory();
		Session session = factory.openSession();
		BluetoothSpeakerDTO bDTO = session.get(BluetoothSpeakerDTO.class,id);
		session.close();
		factory.close();
		
		return bDTO;
	}

	public List<BluetoothSpeakerDTO> getAllDetails() {
		Session session = null;
		
		try {
			
			 return HibernateUtil.getSessionFactory().openSession().createQuery("from BluetoothSpeakerDTO bDTO").list();
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

	public void deleteById(int id) {
		Configuration config = new Configuration();
		config.configure();
		config.addAnnotatedClass(BluetoothSpeakerDTO.class);
		SessionFactory factory = config.buildSessionFactory();
		Session session = factory.openSession();
		BluetoothSpeakerDTO bDTO1 = session.get(BluetoothSpeakerDTO.class,id);
		Transaction transaction = session.beginTransaction();
		session.delete(bDTO1);
		transaction.commit();
		session.close();
		factory.close();
		
	}

	public void updateRangeByName(int id,String range) {
		Configuration confi = new Configuration();
		confi.configure();
		confi.addAnnotatedClass(BluetoothSpeakerDTO.class);
		SessionFactory factory = confi.buildSessionFactory();
		Session session = factory.openSession();
		BluetoothSpeakerDTO blueeDTO = session.get(BluetoothSpeakerDTO.class,id);
		blueeDTO.setRange(range);
		Transaction transaction = session.beginTransaction();
		session.update(blueeDTO);
		transaction.commit();
		session.close();
		factory.close();
		
	}
	

}
