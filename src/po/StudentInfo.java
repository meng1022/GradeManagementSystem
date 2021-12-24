package po;

public class StudentInfo
{
	private Integer studentid;//学号
	private String name;
	private String email;
	private String phone;
	private Integer classno;//班级
	private String gender;//性别
	private String department;//专业
	public String getDepartment()
	{
		return department;
	}
	public void setDepartment(String department)
	{
		this.department = department;
	}
	public Integer getStudentid()
	{
		return studentid;
	}
	public void setStudentid(Integer studentid)
	{
		this.studentid = studentid;
	}
	public String getName()
	{
		return name;
	}
	public void setName(String name)
	{
		this.name = name;
	}
	public String getEmail()
	{
		return email;
	}
	public void setEmail(String email)
	{
		this.email = email;
	}
	public String getPhone()
	{
		return phone;
	}
	public void setPhone(String phone)
	{
		this.phone = phone;
	}
	public Integer getClassno()
	{
		return classno;
	}
	public void setClassno(Integer classno)
	{
		this.classno = classno;
	}
	public String getGender()
	{
		return gender;
	}
	public void setGender(String gender)
	{
		this.gender = gender;
	}
	
}
