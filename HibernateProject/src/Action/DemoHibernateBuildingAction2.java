package Action;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import Model.BuildingBean;
import Utils.HibernateUtil;

public class DemoHibernateBuildingAction2 {
	private SessionFactory factory;
	private Session session;

	public DemoHibernateBuildingAction2() {
		factory = HibernateUtil.getSessionFactory();
		session = factory.openSession();
	}
	public void queryDb1() {
		BuildingBean build1 = session.load(BuildingBean.class, 1005);
		session.beginTransaction().commit();
		System.out.println("id:"+build1.getBuildingid());
		System.out.println("name:"+build1.getBuildingname());
		System.out.println("age:"+build1.getBuildingage());
		session.close();
	}
	
	public void queryDb2() {
		BuildingBean build1 = session.get(BuildingBean.class, 1005);
		session.beginTransaction().commit();
		System.out.println("id:"+build1.getBuildingid());
		System.out.println("name:"+build1.getBuildingname());
		System.out.println("age:"+build1.getBuildingage());
		session.close();
	}
	public void insertDb() {
		try {
		BuildingBean building1=new BuildingBean();
		building1.setBuildingid(1005);
		building1.setBuildingname("Pink House");
		building1.setBuildingage(16);
		session.save(building1);
		session.beginTransaction().commit();
		}catch(Exception e) {
			session.getTransaction().rollback();
			e.printStackTrace();
		}finally {
			session.close();
		}
	}
	public void deleteDb() {
		BuildingBean building1=new BuildingBean();
		session.delete(building1);
		session.close();
	}

	public static void main(String[] args) {
		DemoHibernateBuildingAction2 buildaction = new DemoHibernateBuildingAction2();
		
//		buildaction.insertDb();
//		buildaction.queryDb1();
		buildaction.queryDb2();
		buildaction.deleteDb();
			
		HibernateUtil.closeSessionFactory();
	}

}
