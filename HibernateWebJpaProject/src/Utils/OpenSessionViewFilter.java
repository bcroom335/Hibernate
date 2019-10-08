package Utils;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.hibernate.SessionFactory;

public class OpenSessionViewFilter implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		try {
		sessionFactory.getCurrentSession().beginTransaction();
		System.out.println("Transaction begin");
		chain.doFilter(request, response);
		sessionFactory.getCurrentSession().getTransaction().commit();
		System.out.println("Transaction commit");
		}catch(Exception e) {
			sessionFactory.getCurrentSession().getTransaction().rollback();
			System.out.println("Transaction rollback");
			chain.doFilter(request, response);
		}finally {
			sessionFactory.getCurrentSession().close();
			System.out.println("Transaction closed");
		}
	}

}
