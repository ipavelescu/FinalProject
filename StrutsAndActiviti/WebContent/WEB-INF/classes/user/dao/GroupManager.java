package user.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
 
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.classic.Session;
 
import user.model.Group;
import user.model.MyGroup;
import user.model.Register;
import user.dao.HibernateUtil;
 
public class GroupManager extends HibernateUtil {
 
	public static boolean addGroup(MyGroup Rgst) {

        SessionFactory sf = HibernateUtil.getSessionFactory();
        Transaction t = null;
        
        Session s = sf.openSession();
         try {
               
                t = s.beginTransaction(); // start a new transaction
  
                s.persist(Rgst);
                t.commit(); // commit transaction
                return true;

         } catch (Exception ex) {
        	 System.err.println("Error -->" + ex.getMessage());
        	 if (t != null)
                    t.rollback();
                   return false;

         }
         
         finally {
             s.close();
         }

	}
	
//    public static boolean addGroup(Group registeredGroup) {
//    	
//    	
//    	
//        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
//        
//        try {
//        	
//	        session.beginTransaction();
//	        session.save(registeredGroup);
//	        session.getTransaction().commit();
//	        return true;
//	        
//        } catch (Exception ex) {
//        	
//	       	 System.err.println("Error -->" + ex.getStackTrace());
//	    	 if (session.getTransaction() != null)
//	    		 session.getTransaction().rollback();
//	               return false;
//
//        }
//        
//    }
    
    public Group deleteGroup(Long id) {
    	
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        Group registeredGroup = (Group) session.load(Group.class, id);
        if(null != registeredGroup) {
            session.delete(registeredGroup);
        }
        session.getTransaction().commit();
        return registeredGroup;
    }
 
    @SuppressWarnings("unchecked")
	public static ArrayList<MyGroup> listGroup() {
 
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        ArrayList<MyGroup> registeredGroups = null;
        try {
       // 	Group register = new Group();
        	//register.setGroupName(criteria);
            registeredGroups = (ArrayList<MyGroup>) session.createQuery("from MyGroup").list();
            		//+"u WHERE u.userName="+criteria
            		
            //System.out.println(registeredGroups);
 
        } catch (HibernateException e) {
        	System.out.println("No group match");
            e.printStackTrace();
            session.getTransaction().rollback();
        }
        System.out.println("de aici"+registeredGroups);
        session.getTransaction().commit();
        return registeredGroups;
    }
    
    public static MyGroup findGroupById(Long id){
    	
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        MyGroup group = null;
        
        try {
        	
        	@SuppressWarnings("unchecked")
			ArrayList<MyGroup> foundGroups = (ArrayList<MyGroup>) session.createQuery("from MyGroup WHERE groupId="+id).list();
        	group = foundGroups.get(0);
        	System.out.println("nume grup: "+group.getGroupName());
 
        } catch (HibernateException e) {
        	System.out.println("No group match");
            e.printStackTrace();
            session.getTransaction().rollback();
        }
        
        session.getTransaction().commit();
    	
    	return group;
    }
    
}