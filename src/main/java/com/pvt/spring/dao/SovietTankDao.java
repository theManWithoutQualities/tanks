package com.pvt.spring.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Component;

import com.pvt.spring.model.Tank;

public class SovietTankDao {

	private SessionFactory sessionFactory;

	public SovietTankDao() {
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public List list() {

		Session session = sessionFactory.openSession();
		Query query = session.createQuery("from Tank");
		List list = query.getResultList();
                
		session.close();

		return list;
	}

	public Tank get(Long id) {
            
            Session session = sessionFactory.openSession();
            Tank tank = (Tank)session.get(Tank.class, id);
            session.close();
            return tank;
	}

	public Tank create(Tank tank) {
		Session session = sessionFactory.openSession();
                session.beginTransaction();
		session.save(tank);
                session.getTransaction().commit();
                session.close();
		return tank;
	}

	public Long delete(Long id) {
                Session session = sessionFactory.openSession();
                session.beginTransaction();
                Tank tank = session.load(Tank.class, id);
		session.delete(tank);
                session.getTransaction().commit();
                session.close();

		return id;
	}

	public Tank update(Long id, Tank tank) {
                Session session = sessionFactory.openSession();
                session.beginTransaction();
                session.update(tank);
                session.getTransaction().commit();
                session.close();
		return tank;
	}

}