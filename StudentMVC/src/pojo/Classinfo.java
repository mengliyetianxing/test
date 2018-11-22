package pojo;

public class Classinfo {
	private int cid;
	private String cname;
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public Classinfo(int cid, String cname) {
		super();
		this.cid = cid;
		this.cname = cname;
	}
	public Classinfo() {
		
	}
	@Override
	public String toString() {
		return "Classinfo [cid=" + cid + ", cname=" + cname + "]";
	}
	
}
