package com.revature.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateUtil
{
	private SessionFactory sessionFactory;
	public SessionFactory getSessionFactory()
	{
		if(sessionFactory==null)
		{
			//make a new one
			Configuration conf = new Configuration().configure();
			ServiceRegistry serviceRegistry =
					new StandardServiceRegistryBuilder()
						.applySettings(conf.getProperties())
							.build();
			//Build a session factory from the service registry
			sessionFactory = conf.buildSessionFactory(serviceRegistry);
		}
		return sessionFactory;
	}
	public Session getSession()
	{
		return this.getSessionFactory().openSession();
	}
	@Override
	protected void finalize() throws Throwable {
		sessionFactory.close();
		super.finalize();
	}
}