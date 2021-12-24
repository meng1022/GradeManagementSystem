package po;

public class TeacherInfo
{
	private Integer teacherid;//学号
	private String teachername;
	private String email;
	private String phone;
	private String gender;//性别
	private String department;//专业
	private String address;
	public String getTeachername()
	{
		return teachername;
	}
	public void setTeachername(String teachername)
	{
		this.teachername = teachername;
	}
	public String getAddress()
	{
		return address;
	}
	public void setAddress(String address)
	{
		this.address = address;
	}
	public String getDepartment()
	{
		return department;
	}
	public void setDepartment(String department)
	{
		this.department = department;
	}
	public Integer getTeacherid()
	{
		return teacherid;
	}
	public void setTeacherid(Integer teacherid)
	{
		this.teacherid = teacherid;
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
	public String getGender()
	{
		return gender;
	}
	public void setGender(String gender)
	{
		this.gender = gender;
	}
	
}
