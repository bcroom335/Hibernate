package _DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import org.hibernate.Session;

import Model.BuildingBean;

public class MemberDao  {
private Session session;
	
	public MemberDao(Session session) {
		this.session=session;
	}
	public Session getSession() {
		return session;
	}
	public MemberBean insert(MemberBean bean) {
		MemberBean member=(MemberBean)getSession().get(MemberBean.class, bean.getSeqNo());
		if(member==null) {
			this.getSession().save(bean);
			return bean;
		}
		return null;
	}

	@Override
	public void update(MemberBean m) throws SQLException {
		PreparedStatement stmt = conn.prepareStatement(Update_String);
		stmt.setString(1, m.getName());
		stmt.setString(2, m.getBirth());
		stmt.setString(3, m.getAddress());
		stmt.setString(4, m.getEmail());
		stmt.setString(5, m.getTel());
		stmt.setInt(6, m.getSeqNo());
		stmt.execute();
		stmt.close();
	}

	@Override
	public void delete(int seqNo) throws SQLException {
		PreparedStatement stmt = conn.prepareStatement(Del_String);
		stmt.setInt(1, seqNo);
		stmt.execute();
		stmt.close();
	}

	@Override
	public List<MemberBean> select(MemberBean m) throws SQLException {
		List<MemberBean> mems=new ArrayList<MemberBean>();
		PreparedStatement stmt = conn.prepareStatement(Select_String);
		stmt.setString(1, "%"+m.getName()+"%");
		
		ResultSet rs = stmt.executeQuery();
		while (rs.next()) {
			MemberBean m1 = new MemberBean();
			m1.setSeqNo(rs.getInt(1));
			m1.setName(rs.getString(2));
			m1.setBirth(rs.getString(3));
			m1.setAddress(rs.getString(4));
			m1.setEmail(rs.getString(5));
			m1.setTel(rs.getString(6));
			mems.add(m1);
		}
		return mems ;
	}

	@Override
	public void creatconn() throws SQLException {
		try {
    		Context context = new InitialContext();
			DataSource ds = (DataSource)context.lookup("java:/comp/env/jdbc/FirstIndependentStudy");
			conn=ds.getConnection();
    	} catch (NamingException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void closeconn() throws SQLException {
		if(conn !=null)
			try { conn.close(); } 
		    catch (SQLException e) { e.printStackTrace(); }
	}

}
