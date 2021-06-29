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
		//String hql = "Select dto from BluetoothSpeakerDTO dto where dto.brand=:brnd";
		
		try {
			return (BluetoothSpeakerDTO) HibernateUtil.getSessionFactory().openSession().getNamedQuery("getDetailsByBluetoothBrand").setParameter("brnd", brand).uniqueResult();
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
		//String hql = "Select dto.bluetoothName from BluetoothSpeakerDTO dto where dto.brand=:brnd";

		try {
			return (String) HibernateUtil.getSessionFactory().openSession().getNamedQuery("getBluetoothNameByBrand").setParameter("brnd", brand).uniqueResult();
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
		//String hql = "Select dto.range ,dto.bluetoothName from BluetoothSpeakerDTO dto where dto.brand=:brnd";

		try {
			return (Object[]) HibernateUtil.getSessionFactory().openSession().getNamedQuery("getBluetoothRangeAndbluetoothNameByBrand").setParameter("brnd", brand).uniqueResult();
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
		//String hql = "select dto.range,dto.bluetoothName from BluetoothSpeakerDTO dto where dto.brand=:brnd";
		return HibernateUtil.getSessionFactory().openSession().getNamedQuery("getbluetoothRangeAndbluetoothNameBybluetoothCompanyName").setParameter("brnd", brand).list();
	}

	@Override
	public int updateNameByBrandH(String brand, String name) {
		Session session =null;
		//String hql = "update BluetoothSpeakerDTO dto set dto.bluetoothName = :nme where dto.brand=:brnd";

		try {
			session = HibernateUtil.getSessionFactory().openSession();
			Query query = session.getNamedQuery("updateNameByBrandH");
			query.setParameter("brnd", brand);
			query.setParameter("nme", name);

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
			
		
			
		}
		return 0;
	}

	@Override
	public int updateRangeByNameH(String brand, String range) {
		Session session =null;
		//String hql = "update BluetoothSpeakerDTO dto set dto.brand = :brn where dto.range=:rg";

		try {
			session = HibernateUtil.getSessionFactory().openSession();
			Query query = session.getNamedQuery("updateRangeByNameH");
			query.setParameter("brn", brand);
			query.setParameter("rg", range);

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
		//String hql = "delete from BluetoothSpeakerDTO dto where dto.brand=:br";

		try {
			session = HibernateUtil.getSessionFactory().openSession();
			Query query = session.getNamedQuery("deleteByBrandH");
			query.setParameter("br", brand);
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
		//String hql = "delete from BluetoothSpeakerDTO dto where dto.range=:rng";

		try {
			session = HibernateUtil.getSessionFactory().openSession();
			Query query = session.getNamedQuery("deleteByRangeH");
			query.setParameter("rng", range);
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
			
		
			
		}
		return 0;
		
	}

	@Override
	public int deleteByBluetoothNameH(String bluetoothName) {
		Session session =null;
		String hql = "delete from BluetoothSpeakerDTO dto where dto.bluetoothName=:blt";

		try {
			session = HibernateUtil.getSessionFactory().openSession();
			Query query = session.getNamedQuery("deleteByBluetoothNameH");
			query.setParameter("blt", bluetoothName);
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
