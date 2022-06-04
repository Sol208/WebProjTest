package Member_p.Model_p;

public class MemberDTO {

	private String pid, pName, gender, address, email, pw, telecom;
	private int phoneNum;
	
	
	
	public String getTelecom() {
		return telecom;
	}
	public void setTelecom(String telecom) {
		this.telecom = telecom;
	}
	public String getPid() {
		return pid;
	}
	public void setPid(String pid) {
		this.pid = pid;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getpName() {
		return pName;
	}
	public void setpName(String pName) {
		this.pName = pName;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getPhoneNum() {
		return phoneNum;
	}
	public void setPhoneNum(int phoneNum) {
		this.phoneNum = phoneNum;
	}
	@Override
	public String toString() {
		return "MemberDTO [pid=" + pid + ", pName=" + pName + ", gender=" + gender + ", address=" + address + ", email="
				+ email + ", pw=" + pw + ", telecom=" + telecom + ", phoneNum=" + phoneNum + "]";
	}
	
	
	
}