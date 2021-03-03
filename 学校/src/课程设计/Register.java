package 课程设计;
//注册模型代码
public class Register {
	String id;//用户名
	String password;//密码
	String birth;//日期
	String telephone;//电话
	String department;//部门
	public void setID(String id){
		this.id=id;
	}
	public void setPassword(String password){
		this.password=password;
	}
	public void setBirth(String birth){
		this.birth=birth;
	}
	public String getID(){
		return id;
	}
	public String getPassword(){
		return password;
	}
	public String getBirth(){
		return birth;
	}
	public void settelephone(String telephone){
		this.telephone=telephone;
	}
	public String gettelephone(){
		return telephone;
	}
	public void setdepartment(String department){
		this.department=department;
	}
	public String getdepartment(){
		return department;
	}
}
