package pojo;

public class Files {
	private String fid;
	private String fname;
	private String fdes;
	public String getFid() {
		return fid;
	}
	public void setFid(String fid) {
		this.fid = fid;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getFdes() {
		return fdes;
	}
	public void setFdes(String fdes) {
		this.fdes = fdes;
	}
	
	public Files() {
		
	}
	public Files(String fid, String fname, String fdes) {
		super();
		this.fid = fid;
		this.fname = fname;
		this.fdes = fdes;
	}
	@Override
	public String toString() {
		return "Files [fid=" + fid + ", fname=" + fname + ", fdes=" + fdes + "]";
	}
	
}
