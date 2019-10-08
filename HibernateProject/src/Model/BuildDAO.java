package Model;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

public class BuildDAO {
	private Session session;
	
	public BuildDAO(Session session) {
		this.session=session;
	}
	public Session getSession() {
		return session;
	}
	public BuildingBean insert(BuildingBean bean) {
		BuildingBean build=(BuildingBean)getSession().get(BuildingBean.class, bean.getBuildingid());
		if(build==null) {
			this.getSession().save(bean);
			return bean;
		}
		return null;
	}
	public BuildingBean select(int buildingid) {
		return getSession().get(BuildingBean.class, buildingid);
	}
	public List<BuildingBean> selectAll(){
		Query query=getSession().createQuery("from BuildingBean");
		return (List<BuildingBean>)query.list();
	}
	public BuildingBean update(int buildingid,String buildingname) {
		BuildingBean build=(BuildingBean)getSession().get(BuildingBean.class, buildingid);
		if(build!=null) { 
			build.setBuildingname(buildingname);
			return build;
		}
		return null;
	}
	public boolean delete(int buildingid) {
		BuildingBean build=(BuildingBean)getSession().get(BuildingBean.class, buildingid);
		if(build!=null) { 
			getSession().delete(build);
			return true;
		}
		return false;
	}
}
