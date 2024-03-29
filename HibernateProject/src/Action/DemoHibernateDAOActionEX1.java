package Action;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import Model.BuildDAO;
import Model.BuildingBean;
import Utils.HibernateUtil;

public class DemoHibernateDAOActionEX1 {

	public static void main(String[] args) {
		SessionFactory sessionFactory =HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		try {
		BuildDAO bDao = new BuildDAO(session);
		session.beginTransaction();
		BuildingBean bean = new BuildingBean();
		
		bean.setBuildingid(1008);
		bean.setBuildingname("Grey House");
		bean.setBuildingage(15);
		
		bDao.insert(bean);
//		bDao.update(1007, "White House");
//		bDao.delete(1003);
		
		BuildingBean bean2=bDao.select(1008);
		System.out.println("id:"+bean2.getBuildingid());
		System.out.println("name:"+bean2.getBuildingname());
		System.out.println("age:"+bean2.getBuildingage());
//		List<BuildingBean> list = bDao.selectAll();
//		for(BuildingBean build:list) {
//			System.out.print("ID:"+build.getBuildingid()+" ");
//			System.out.print("Name:"+build.getBuildingname()+" ");
//			System.out.print("Age:"+build.getBuildingage());
//			System.out.println();
//		}				
		session.getTransaction().commit();
		}catch(Exception e) {
			session.getTransaction().rollback();
			e.printStackTrace();
		}finally {
			session.close();
			HibernateUtil.closeSessionFactory();
		}
	}

}
