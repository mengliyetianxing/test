package pojo;

import java.util.Date;

public class User {
	private String user;
	private String pwd;
	private Date bir;
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public Date getBir() {
		return bir;
	}
	public void setBir(Date bir) {
		this.bir = bir;
	}
	@Override
	public String toString() {
		return "User [user=" + user + ", pwd=" + pwd + ", bir=" + bir + "]";
	}
	public User(String user, String pwd, Date bir) {
		super();
		this.user = user;
		this.pwd = pwd;
		this.bir = bir;
	}
	public User() {
	}
	
}
