package po;

public class TeacherCourseInfo
{
	private Integer teacherid;
	private Integer courseid;
	private String courseplace;
	private String weektime;//周次
	private String coursename;//课程名
	private String day;//星期
	private String jieci;//节次
	public Integer getTeacherid()
	{
		return teacherid;
	}
	public void setTeacherid(Integer studentid)
	{
		this.teacherid = studentid;
	}
	public Integer getCourseid()
	{
		return courseid;
	}
	public void setCourseid(Integer courseid)
	{
		this.courseid = courseid;
	}
	public String getCourseplace()
	{
		return courseplace;
	}
	public void setCourseplace(String courseplace)
	{
		this.courseplace = courseplace;
	}
	public String getWeektime()
	{
		return weektime;
	}
	public void setWeektime(String weektime)
	{
		this.weektime = weektime;
	}
	public String getCoursename()
	{
		return coursename;
	}
	public void setCoursename(String coursename)
	{
		this.coursename = coursename;
	}
	public String getDay()
	{
		return day;
	}
	public void setDay(String day)
	{
		this.day = day;
	}
	public String getJieci()
	{
		return jieci;
	}
	public void setJieci(String jieci)
	{
		this.jieci = jieci;
	}
	
}
