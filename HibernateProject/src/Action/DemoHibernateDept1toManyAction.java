package Action;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import Model.Department;
import Model.Employee;
import Utils.HibernateUtil;

public class DemoHibernateDept1toManyAction {
	
	private SessionFactory sessionFactory;
	private Session session;

	public void processAction() {
		try {
		sessionFactory=HibernateUtil.getSessionFactory();
		session=sessionFactory.openSession();
		session.beginTransaction();
		
//		insertAction();
//		deleteAction(1);
//		updateAction(2,"Apple");
//		selectAction(2);
		List<Employee> emplist = selectAllEmployee();
		for(Employee emps:emplist) {
			System.out.print("Id:"+emps.getEmpid()+" ");
			System.out.print("Name:"+emps.getEmpname()+" ");
			System.out.print("Salary:"+emps.getSalary()+" ");
			System.out.println("Gender:"+emps.getGender());
		}
		
		session.getTransaction().commit();
		}catch(Exception e) {
			session.getTransaction().rollback();
			e.printStackTrace();
		}finally {
			session.close();
			HibernateUtil.closeSessionFactory();
		}
		
	}
	private List<Employee> selectAllEmployee() {
		Query query = session.createQuery("from Employee");
		List<Employee> emplist=query.list();
		return emplist;
	}

	private void selectAction(int deptid) {
		Department dept=session.get(Department.class, deptid);
		if(dept!=null) {
			System.out.println("Id:"+dept.getDeptid());
			System.out.println("Name:"+dept.getDeptname());
		}
		
	}

	private void updateAction(int deptid, String deptname) {
		Department dept=session.get(Department.class, deptid);
		if(dept!=null)
			dept.setDeptname(deptname);
		
	}

	private void deleteAction(int deptid) {
		Department dept=session.get(Department.class, deptid);
		if(dept!=null)
			session.delete(dept);
		
	}

	private void insertAction() {
		Department dept=new Department();
		dept.setDeptname("Google");
		
		Employee emp1=new Employee();
		emp1.setEmpname("Linda");
		emp1.setSalary(60000);
		emp1.setGender("F");
		emp1.setDept(dept);
		
		Employee emp2=new Employee();
		emp2.setEmpname("Jack");
		emp2.setSalary(48000);
		emp2.setGender("M");
		emp2.setDept(dept);
		
		Set<Employee> emps=new LinkedHashSet<Employee>();
		emps.add(emp1);
		emps.add(emp2);
	
		dept.setEmployees(emps);
		
		session.save(dept);		
	}
	

	public static void main(String[] args) {
		DemoHibernateDept1toManyAction action=new DemoHibernateDept1toManyAction();
		action.processAction();

	}

}
