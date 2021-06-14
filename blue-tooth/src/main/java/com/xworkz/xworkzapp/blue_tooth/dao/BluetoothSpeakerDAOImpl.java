package com.xworkz.xworkzapp.blue_tooth.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

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

}
