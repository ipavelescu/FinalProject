package user.dao;

import java.util.List;
 
import org.hibernate.HibernateException;
import org.hibernate.classic.Session;
 
import user.model.Group;
import user.dao.HibernateUtil;
 
public class GroupManager extends HibernateUtil {
 
    public static boolean addGroup(Group registeredGroup) {
    	
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        session.save(registeredGroup);
        session.getTransaction().commit();
        return true;
        
    }
    
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
	public static List<Group> listGroup(String criteria) {
 
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        List<Group> registeredGroups = null;
        try {
       // 	Group register = new Group();
        	//register.setGroupName(criteria);
            registeredGroups = (List<Group>)session.createQuery("from Group").list();
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
}