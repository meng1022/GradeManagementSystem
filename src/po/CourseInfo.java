package po;

public class CourseInfo
{
	private Integer courseid;
	private String coursename;//课程名
	private Integer teacherid;
	private String teachername;
	private String courseplace;
	private String weektime;//周次
	private String day;//星期
	private String jieci;//节次
	public Integer getTeacherid()
	{
		return teacherid;
	}
	public void setTeacherid(Integer teacherid)
	{
		this.teacherid = teacherid;
	}
	public Integer getCourseid()
	{
		return courseid;
	}
	public void setCourseid(Integer courseid)
	{
		this.courseid = courseid;
	}
	public String getCoursename()
	{
		return coursename;
	}
	public void setCoursename(String coursename)
	{
		this.coursename = coursename;
	}
	public String getTeachername()
	{
		return teachername;
	}
	public void setTeachername(String teachername)
	{
		this.teachername = teachername;
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
