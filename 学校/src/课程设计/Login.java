package 课程设计;
//登录模型代码
public class Login {
	boolean loginSuccess=false;
	String id;//用户
	String password;//密码
	String department;//部门
	public void setID(String id){
		this.id=id;
	}
	public void setPassword(String password){
		this.password=password;
	}
	public void setLoginSuccess(boolean bo){
		loginSuccess=bo;
	}
	public boolean getLoginSuccess(){
		return loginSuccess;
	}
	public String getID(){
		return id;
	}
	public String getPassword(){
		return password;
	}
	public void setDepartment(String department){
		this.department=department;
	}
	public String getDepartment(){
		return department;
	}
}
