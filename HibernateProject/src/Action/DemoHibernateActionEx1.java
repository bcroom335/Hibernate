package Action;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import Model.HouseBean;

public class DemoHibernateActionEx1 {

	public static void main(String[] args) {
		StandardServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().configure().build();
		SessionFactory factory = new MetadataSources(serviceRegistry).buildMetadata().buildSessionFactory();
		Session session = factory.openSession();
		Transaction ts = session.beginTransaction();
		
		HouseBean house=new HouseBean();
		house.setHouseid(1002);
		house.setHousename("Jack House");
		session.save(house);
		
		ts.commit();
		session.close();
		factory.close();

	}

}
