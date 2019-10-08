package _Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import _DAO.MemberBean;
import _DAO.MemberDao;
import util.HibernateUtil;

@WebServlet("/MemAddC")
public class MemAddC extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private SessionFactory factory;
	private Session session;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processAction(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processAction(request, response);
	}

	protected void processAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		factory=HibernateUtil.getSessionFactory();
		session=factory.openSession();
		try {
		MemberDao mDao=new MemberDao(session);
		session.beginTransaction();
		MemberBean mb1 = new MemberBean();
		mb1.setName(request.getParameter("name"));
		mb1.setBirth(request.getParameter("birth"));
		mb1.setAddress(request.getParameter("address"));
		mb1.setEmail(request.getParameter("mail"));
		mb1.setTel(request.getParameter("tel"));
		mDao.insert(mb1);
		session.getTransaction().commit();
		}catch(Exception e) {
			session.getTransaction().rollback();
			e.printStackTrace();
		}finally {
			session.close();
			HibernateUtil.closeSessionFactory();
		}
		RequestDispatcher rd = request.getRequestDispatcher("Finish.jsp");
		rd.forward(request, response);		
	}

}
