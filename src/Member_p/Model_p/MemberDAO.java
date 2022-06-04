package Member_p.Model_p;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class MemberDAO {

	PreparedStatement pstmt;
	Connection con;
	ResultSet rs;
	String sql;
	
	public MemberDAO() {
		try {
			Context context = new InitialContext(); 
			DataSource ds = (DataSource) context.lookup("java:comp/env/Member");
			con = ds.getConnection();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public MemberDTO detail(String id) {
		MemberDTO res = null;
		sql = "select * from memlist where pid=?";
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1,id);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				res = new MemberDTO();
				res.setPid(rs.getString("pid"));
				res.setPw(rs.getString("pw"));
				res.setpName(rs.getString("pname"));
				res.setGender(rs.getString("gender"));
				res.setTelecom(rs.getString("telecom"));
				res.setPhoneNum(rs.getInt("phonenum"));
				res.setEmail(rs.getString("email"));
				res.setAddress(rs.getString("address"));	
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close();
		}
		return res;
	}
	
	public ArrayList<MemberDTO> list(){
		sql = "select * from memlist";
		ArrayList<MemberDTO> list = new ArrayList<MemberDTO>();
		
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				MemberDTO dto = new MemberDTO();
				dto.setPid(rs.getString("pid"));
				dto.setpName(rs.getString("pname"));
				dto.setGender(rs.getString("gender"));
				dto.setTelecom(rs.getString("telecom"));
				dto.setPhoneNum(rs.getInt("phonenum"));
				dto.setEmail(rs.getString("email"));
				dto.setAddress(rs.getString("address"));
				
				list.add(dto);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close();
		}
		return list;
	}
	
	public void insert(MemberDTO dto) {
		sql = "insert into memlist (pid, pw, pname, gender, telecom, phonenum, email, address) values"
				+"(?, ?, ?, ?, ?, ?, ?, ?)";
		System.out.println(dto);
		try {
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, dto.getPid());
			pstmt.setString(2, dto.getPw());
			pstmt.setString(3, dto.getpName());
			pstmt.setString(4, dto.getGender());
			pstmt.setString(5, dto.getTelecom());
			pstmt.setInt(6, dto.getPhoneNum());
			pstmt.setString(7, dto.getEmail());
			pstmt.setString(8, dto.getAddress());
			
			pstmt.executeUpdate();
			
		} catch(Exception e){
			e.printStackTrace();
		} finally {
			close();
		}
	}
	
	public void close() {
		if (rs!=null) {try { rs.close(); } catch (SQLException e) {e.printStackTrace();}}
		if (pstmt!=null) { try { pstmt.close(); } catch (SQLException e) {e.printStackTrace();}}
		if (con!=null) { try { con.close(); } catch (SQLException e) {e.printStackTrace();}}
	}
	
}
