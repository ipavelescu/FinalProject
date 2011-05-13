package user.dao;

import java.util.List;
 
import org.hibernate.HibernateException;
import org.hibernate.classic.Session;
 
import user.model.Register;
import user.dao.HibernateUtil;
 
public class UserManager extends HibernateUtil {
 
    public static boolean add(Register registeredUser) {
    	
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        session.save(registeredUser);
        session.getTransaction().commit();
        
        return true;
        
    }
    
    public Register delete(Long id) {
    	
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        Register registeredUser = (Register) session.load(Register.class, id);
        if(null != registeredUser) {
            session.delete(registeredUser);
        }
        session.getTransaction().commit();
        return registeredUser;
        
    }
 
    @SuppressWarnings("unchecked")
	public static List<Register> listUser(String criteria) {
 
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        List<Register> registeredUsers = null;
        try {
       // 	Register register = new Register();
        	//register.setUserName(criteria);
            registeredUsers = (List<Register>)session.createQuery("from Register u WHERE u.userName= :name").setParameter("name",criteria).list();
            		//+"u WHERE u.userName="+criteria
            		
            //System.out.println(registeredUsers);
 
        } catch (HibernateException e) {
        	System.out.println("No user match");
            e.printStackTrace();
            session.getTransaction().rollback();
        }
        System.out.println("de aici"+registeredUsers);
        session.getTransaction().commit();
        return registeredUsers;
    }
}