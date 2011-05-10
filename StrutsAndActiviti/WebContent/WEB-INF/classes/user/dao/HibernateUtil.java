package user.dao;

import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class HibernateUtil {

	private static final SessionFactory sessionFactory;

	static {

		try {
				sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
				
		} catch (Throwable ex) {
				System.err.println("Initial SessionFactory creation failed." + ex);
				throw new ExceptionInInitializerError(ex);
		}

	}

	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}

} 
	
