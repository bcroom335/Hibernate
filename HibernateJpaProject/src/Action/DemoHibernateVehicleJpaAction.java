package Action;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import Model.Vehicle;
import Utils.HibernateUtil;

public class DemoHibernateVehicleJpaAction {
	SessionFactory sessionFactory;
	Session session;
	public  void processAction() {
		sessionFactory = HibernateUtil.getSessionFactory();
		session = sessionFactory.openSession();
		try {
			session.beginTransaction();
			
			Vehicle v1=new Vehicle();
			v1.setVehiclename("vtruck");
			
			session.save(v1);
			
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
		DemoHibernateVehicleJpaAction act = new DemoHibernateVehicleJpaAction();
		act.processAction();

	}

}
