package user.dao;

import java.util.List;
 
import org.hibernate.HibernateException;
import org.hibernate.classic.Session;
 
import user.model.Register;
import user.dao.HibernateUtil;
 
public class UserManager extends HibernateUtil {
 
//    public static boolean add(Register registeredUser) {
//    	
//        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
//        session.beginTransaction();
//        session.save(registeredUser);
//        session.getTransaction().commit();
//        
//        return true;
//        
//    }
	
	public static boolean addOrUpdateUser(Register user){
	
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        
        try {
        	session.saveOrUpdate(user);
        } catch(HibernateException e){
        	session.getTransaction().rollback();
        }
        
        session.getTransaction().commit();
        
        return true;
		
	}
    
    public boolean delete(Long id) {
    	
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        Register registeredUser = (Register) session.load(Register.class, id);
        if(null != registeredUser) {
            session.delete(registeredUser);
        }
        session.getTransaction().commit();
        return true;
        
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
    
    @SuppressWarnings("unchecked")
	public List<Register> listAllUsers() {
    	 
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        List<Register> users = null;
        try {
 
            users = (List<Register>)session.createQuery("from Register").list();
 
        } catch (HibernateException e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }
        session.getTransaction().commit();
        return users;
    }
    
    public static Register listUserById(Long userId) {
    	
    	Session session = HibernateUtil.getSessionFactory().getCurrentSession();
    	session.beginTransaction();
    	Register user = null;
    	try {
    		user = (Register)session.createQuery("from Register WHERE userId= :userId").setParameter("userId",userId).list().get(0);
    			//(Register) session.get(Register.class, userId);
    	} catch (Exception e) {
    		e.printStackTrace();
    		session.getTransaction().rollback();
    	}
    	session.getTransaction().commit();
    	return user;
    }
}