package Action;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import Model.BuildingBean;
import Utils.HibernateUtil;

public class DemoHibernateBuildingAction3 {
	private SessionFactory factory;
	private Session session;

	public DemoHibernateBuildingAction3() {
		factory = HibernateUtil.getSessionFactory();
		session = factory.openSession();
	}
	public void queryDb1() {
		BuildingBean build1 = session.load(BuildingBean.class, 1006);
		System.out.println("id:"+build1.getBuildingid());
		System.out.println("name:"+build1.getBuildingname());
		System.out.println("age:"+build1.getBuildingage());

	}	
	public void queryDb2() {
		BuildingBean build1 = session.get(BuildingBean.class, 1005);
		System.out.println("id:"+build1.getBuildingid());
		System.out.println("name:"+build1.getBuildingname());
		System.out.println("age:"+build1.getBuildingage());

	}
	public void queryDbAll() {
		Query query = session.createQuery("from BuildingBean");
		List<BuildingBean> list = (List<BuildingBean>)query.list();
		for(BuildingBean build:list) {
			System.out.print("ID:"+build.getBuildingid()+" ");
			System.out.print("Name:"+build.getBuildingname()+" ");
			System.out.print("Age:"+build.getBuildingage());
			System.out.println();
		}
	}
	public void insertDb() {
		
		BuildingBean building1=new BuildingBean();
		building1.setBuildingid(1006);
		building1.setBuildingname("Purple House");
		building1.setBuildingage(2);
		session.save(building1);
	}
	public void deleteDb() {
		BuildingBean building1=new BuildingBean();
		session.delete(building1);

	}
	
	public void processAction() {
		try {
			session.beginTransaction();
//			insertDb();
//			queryDb1();
//			queryDb2();
			queryDbAll();
			session.getTransaction().commit();			
		}catch(Exception e) {
			session.getTransaction().rollback();
			e.printStackTrace();
		}finally {
			session.close();
			HibernateUtil.closeSessionFactory();
		}
	}

	public static void main(String[] args) {
		DemoHibernateBuildingAction3 buildaction = new DemoHibernateBuildingAction3();
		buildaction.processAction();
	
	}

}
