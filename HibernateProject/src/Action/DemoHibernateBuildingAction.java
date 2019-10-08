package Action;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import Model.BuildingBean;
import Utils.HibernateUtil;

public class DemoHibernateBuildingAction {

	public static void main(String[] args) {
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.openSession();
		try {
//		BuildingBean building1=new BuildingBean();
//		BuildingBean building2=new BuildingBean();
		BuildingBean building3=new BuildingBean();
		
//		building1.setBuildingid(1003);
//		building1.setBuildingname("Yellow House");
//		building1.setBuildingage(4);
//		session.save(building1);
//		
//		building2.setBuildingid(1004);
//		building2.setBuildingname("Blue House");
//		building2.setBuildingage(3);
//		session.save(building2);
		
		building3.setBuildingid(1005);
		building3.setBuildingname("White House");
		building3.setBuildingage(2);
		session.save(building3);
		
		
		session.beginTransaction().commit();
		
		HibernateUtil.closeSessionFactory();
		}catch(Exception e) {
			session.getTransaction().rollback();
			e.printStackTrace();
		}finally {
			session.close();
		}

	}

}
