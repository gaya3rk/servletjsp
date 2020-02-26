package myBeans;

public class Name {
	private String fname;
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname=fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname=lname;
	}
	private String lname;
	Name(String f,String l){
		fname=f; lname=l;
	}
	public Name() {}

}
