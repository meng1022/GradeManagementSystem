package po;


public class TeacherScoreInfo
{
	private Integer courseid;
	private String coursename;
	private Integer studentid;
	private String name;
	private Integer score;
	private Integer teacherid;
	
	public Integer getTeacherid() {
		return teacherid;
	}
	public void setTeacherinfo(Integer teacherid) {
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
	public Integer getScore()
	{
		return score;
	}
	public void setScore(Integer score)
	{
		this.score = score;
	}

	
}
