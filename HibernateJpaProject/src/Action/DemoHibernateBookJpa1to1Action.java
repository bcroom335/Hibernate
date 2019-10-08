package Action;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import Model.Book;
import Model.BookDetail;
import Utils.HibernateUtil;

public class DemoHibernateBookJpa1to1Action {
	public static void main(String[] args) {
		SessionFactory sessionFactory =HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		try {
			session.beginTransaction();
			Book bBean=new Book();
			BookDetail bTail=new BookDetail();
			bBean.setBookname("LaLaLand");
			bBean.setAuthor("Rynos");
			bBean.setPrice(450);
			
			bTail.setPublisher("Hollywood");
			bTail.setPublisheraddress("LA");
			bBean.setBookDetail(bTail);
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
