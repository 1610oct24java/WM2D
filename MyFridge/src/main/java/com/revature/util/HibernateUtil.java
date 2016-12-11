
package com.revature.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

/**
 * The Class HibernateUtil.
 */
public class HibernateUtil {
	
	/** The session factory. */
	private SessionFactory sessionFactory;
	
	/**
	 * Gets the session factory.
	 *
	 * @return the session factory
	 */
	
	 /*Singleton config*/

	private static HibernateUtil instance = null;
	private HibernateUtil(){
		
	}
	public static HibernateUtil getInstance(){
		if(instance==null){
			instance= new HibernateUtil();
		}
		return instance;
	}
	
	
	
	public SessionFactory getSessionFactory() {
		
		if (sessionFactory == null) {
			// make a new one
			Configuration conf = new Configuration().configure();
			ServiceRegistry serviceRegistry =
					new StandardServiceRegistryBuilder()
							.applySettings(conf.getProperties()).build();
			// Build a session factory from the service registry
			sessionFactory = conf.buildSessionFactory(serviceRegistry);
		}
		return sessionFactory;
	}
	
	/**
	 * Gets the session.
	 *
	 * @return the session
	 */
	public Session getSession() {
		
		return this.getSessionFactory().openSession();
	}
	
	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#finalize()
	 */
	@Override
	protected void finalize() throws Throwable {
		sessionFactory.close();
		super.finalize();
	}
}