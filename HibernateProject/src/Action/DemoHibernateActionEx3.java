package Action;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import Model.HouseBean;
import Utils.HibernateUtil;

public class DemoHibernateActionEx3 {

	public static void main(String[] args) {
		SessionFactory factory = HibernateUtil.getSessionFactory();
		//.cfg.xml<session factory>換成current_session才能使用
		Session session = factory.getCurrentSession();
		Transaction ts = session.beginTransaction();
		
		HouseBean house=new HouseBean();
		house.setHouseid(1004);
		house.setHousename("Luke House");
		session.save(house);
		
		ts.commit();
		//session.close();
		HibernateUtil.closeSessionFactory();

	}

}
