package Action;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import Model.BuildingBean;
import Model.HouseBean;
import Utils.HibernateUtil;

public class DemoHibernateActionEx2 {

	public static void main(String[] args) {
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.openSession();
		Transaction ts = session.beginTransaction();
		
		HouseBean house=new HouseBean();
		house.setHouseid(1004);
		house.setHousename("Luke House");
		session.save(house);
		
		ts.commit();
		session.close();
		HibernateUtil.closeSessionFactory();

	}

}
