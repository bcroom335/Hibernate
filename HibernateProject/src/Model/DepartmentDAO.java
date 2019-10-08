package Model;

import java.util.List;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.query.Query;

public class DepartmentDAO {

	private Session session;

	public DepartmentDAO(Session session) {
		this.session=session;
	}
	public Session getSession() {
		return session;
	}
	public void insert(Department dept,Set<Employee> empset) {
		dept.setEmployees(empset);
		session.save(dept);
	}
	public List<Employee> selectAllEmployee() {
		Query query = session.createQuery("from Employee");
		List<Employee> emplist=query.list();
		return emplist;
	}
	public List<Department> selectAllDepartment() {
		Query query = session.createQuery("from Department");
		List<Department> deptlist=query.list();
		return deptlist;
	}
	public void updateAction(int deptid, String deptname) {
		Department dept=session.get(Department.class, deptid);
		if(dept!=null)
			dept.setDeptname(deptname);		
	}

	public void deleteAction(int deptid) {
		Department dept=session.get(Department.class, deptid);
		if(dept!=null)
			session.delete(dept);		
	}
}