package Action;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import Model.BookBean;
import Model.BookDetailBean;
import Utils.HibernateUtil;

public class DemoHibernateBook1to1Action {
	public static void main(String[] args) {
		SessionFactory sessionFactory =HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		try {
			session.beginTransaction();
			BookBean bBean=new BookBean();
			BookDetailBean bTail=new BookDetailBean();
			bBean.setBookname("Harry Poter");
			bBean.setAuthor("La K");
			bBean.setPrice(900);
			
			bTail.setPublisher("Crown");
			bTail.setPublisheraddress("7-Kingdom");
			bBean.setBookdetail(bTail);
			bTail.setBook(bBean);
			session.save(bBean);
			
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
