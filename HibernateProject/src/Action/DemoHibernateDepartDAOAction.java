package Action;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import Model.Department;
import Model.DepartmentDAO;
import Model.Employee;
import Utils.HibernateUtil;

public class DemoHibernateDepartDAOAction {

	public static void main(String[] args) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		try {
			session.beginTransaction();
			DepartmentDAO dDao=new DepartmentDAO(session);
//			Department dept=new Department();
//			Set<Employee> emps=new LinkedHashSet<Employee>();
//			Employee emp1=new Employee();
//			Employee emp2=new Employee();
//			Employee emp3=new Employee();
//			dept.setDeptname("Facebook");
//			
//			emp1.setEmpname("Luke");
//			emp1.setSalary(43000);
//			emp1.setGender("M");
//			emp1.setDept(dept);
//			
//			emp2.setEmpname("Lily");
//			emp2.setSalary(36000);
//			emp2.setGender("F");
//			emp2.setDept(dept);
//			
//			emp3.setEmpname("Yoda");
//			emp3.setSalary(88888);
//			emp3.setGender("M");
//			emp3.setDept(dept);
//			
//			emps.add(emp1);
//			emps.add(emp2);
//			emps.add(emp3);
			
//			dDao.insert(dept, emps);
//			dDao.updateAction(3,"Disney");
//			List<Department> deptList = dDao.selectAllDepartment();
//			for(Department depts:deptList) {
//				System.out.print("ID:"+depts.getDeptid()+" ");
//				System.out.println("Name:"+depts.getDeptname());
//			}
			List<Employee> emplist = dDao.selectAllEmployee();
			for(Employee emps:emplist) {
				System.out.print("ID:"+emps.getEmpid()+" ");
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

}
