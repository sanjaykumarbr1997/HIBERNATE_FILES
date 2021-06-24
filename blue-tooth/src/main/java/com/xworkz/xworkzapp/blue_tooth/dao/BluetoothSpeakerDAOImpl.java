package com.xworkz.xworkzapp.blue_tooth.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.xworkz.singleton.HibernateUtil;
import com.xworkz.xworkzapp.blue_tooth.dto.BluetoothSpeakerDTO;

public class BluetoothSpeakerDAOImpl implements BluetoothSpeakerDAO {
	
	Transaction transaction = null;

	public void save(BluetoothSpeakerDTO bluetoothSpeakerDTO) {
		
		Configuration configuration = new Configuration();
		configuration.configure();
		configuration.addAnnotatedClass(BluetoothSpeakerDTO.class);
		SessionFactory factory = configuration.buildSessionFactory();
		Session session = factory.openSession();
		transaction = session.beginTransaction();
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

	@Override
	public BluetoothSpeakerDTO getDetailsByBluetoothBrand(String brand) {
		Session session = null;
		String hql = "Select dto from BluetoothSpeakerDTO dto where dto.brand='"+brand+"'";
		
		try {
			return (BluetoothSpeakerDTO) HibernateUtil.getSessionFactory().openSession().createQuery(hql).uniqueResult();
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
	public String getBluetoothNameByBrand(String brand) {
		Session session =null;
		String hql = "Select dto.bluetoothName from BluetoothSpeakerDTO dto where dto.brand='"+brand+"'";

		try {
			return (String) HibernateUtil.getSessionFactory().openSession().createQuery(hql).uniqueResult();
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
	public Object[] getBluetoothRangeAndbluetoothNameByBrand(String brand) {
		Session session =null;
		String hql = "Select dto.range ,dto.bluetoothName from BluetoothSpeakerDTO dto where dto.brand='"+brand+"'";

		try {
			return (Object[]) HibernateUtil.getSessionFactory().openSession().createQuery(hql).uniqueResult();
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
	public List<Object[]> getbluetoothRangeAndbluetoothNameBybluetoothCompanyName(String brand) {
		String hql = "select dto.range,dto.bluetoothName from BluetoothSpeakerDTO dto where dto.brand = '"+brand+"'";
		return HibernateUtil.getSessionFactory().openSession().createQuery(hql).list();
	}

	@Override
	public int updateNameByBrandH(String brand, String name) {
		Session session =null;
		String hql = "update BluetoothSpeakerDTO dto set dto.bluetoothName = '"+name+"' where dto.brand='"+brand+"'";

		try {
			session = HibernateUtil.getSessionFactory().openSession();
			Query query = session.createQuery(hql);
			transaction = session.beginTransaction();
			int rw = query.executeUpdate();
			
			transaction.commit();
			
			return rw;
			
			
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
		return 0;
	}

	@Override
	public int updateRangeByNameH(String brand, String range) {
		Session session =null;
		String hql = "update BluetoothSpeakerDTO dto set dto.brand = '"+brand+"' where dto.range='"+range+"'";

		try {
			session = HibernateUtil.getSessionFactory().openSession();
			Query query = session.createQuery(hql);
			transaction = session.beginTransaction();
			int rw = query.executeUpdate();
			
			transaction.commit();
			
			return rw;
			
			
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
		return 0;
	}

	@Override
	public int deleteByBrandH(String brand) {
		Session session =null;
		String hql = "delete from BluetoothSpeakerDTO dto where dto.brand='"+brand+"'";

		try {
			session = HibernateUtil.getSessionFactory().openSession();
			Query query = session.createQuery(hql);
			transaction = session.beginTransaction();
			int rw = query.executeUpdate();
			
			transaction.commit();
			
			return rw;
			
			
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
		return 0;
	}

	@Override
	public int deleteByRangeH(String range) {
		Session session =null;
		String hql = "delete from BluetoothSpeakerDTO dto where dto.range='"+range+"'";

		try {
			session = HibernateUtil.getSessionFactory().openSession();
			Query query = session.createQuery(hql);
			transaction = session.beginTransaction();
			int rw = query.executeUpdate();
			
			transaction.commit();
			
			return rw;
			
			
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
		return 0;
		
	}

	@Override
	public int deleteByBluetoothNameH(String bluetoothName) {
		Session session =null;
		String hql = "delete from BluetoothSpeakerDTO dto where dto.bluetoothName='"+bluetoothName+"'";

		try {
			session = HibernateUtil.getSessionFactory().openSession();
			Query query = session.createQuery(hql);
			transaction = session.beginTransaction();
			int rw = query.executeUpdate();
			
			transaction.commit();
			
			return rw;
			
			
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
		return 0;
	}
	

}
