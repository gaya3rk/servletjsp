package myBeans;
import java.io.Serializable;
public class Exp implements Serializable{
	private String empno;
	private Name name;
	public Exp() {
		this("111","Ravi","Shankar");
		}
	public Exp(String e, String f, String l){
		empno=e;
		name=new Name(f,l);
	}
	public void setEmpno(String expno){
		this.empno=empno;
	}
	public void setName(Name n){
		this.name=n;
	}
	public String getEmpno() {
		return empno;
	}
	public Name getName() {
		return name;
	}
	

}
