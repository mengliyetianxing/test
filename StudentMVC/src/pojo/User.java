package pojo;

public class User {
	private String uid;
	private String name;
	private String password;
	private String sex;
	private String love;
	private String birthday;
	private String address;
	private String bz;
	private String cid;
	
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public String getCid() {
		return cid;
	}
	public void setCid(String cid) {
		this.cid = cid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getLove() {
		return love;
	}
	public void setLove(String love) {
		this.love = love;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getBz() {
		return bz;
	}
	public void setBz(String bz) {
		this.bz = bz;
	}
	
	public User(String name, String password, String sex, String love, String birthday, String address, String bz) {
		super();
		this.name = name;
		this.password = password;
		this.sex = sex;
		this.love = love;
		this.birthday = birthday;
		this.address = address;
		this.bz = bz;
	}
	
	public User(String name, String password) {
		super();
		this.name = name;
		this.password = password;
	}
	public User() {
		
	}
	@Override
	public String toString() {
		return "User [name=" + name + ", password=" + password + ", sex=" + sex + ", love=" + love
				+ ", birthday=" + birthday + ", address=" + address + ", bz=" + bz + "]";
	}
	
	
}
