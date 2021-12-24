package dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import po.CourseInfo;
import po.StudentInfo;
import po.TeacherInfo;

public interface AdminMapper
{
	List<StudentInfo> studentinfo();
	
	List<TeacherInfo> teacherinfo();
	
	List<CourseInfo> courseinfo();
	
	StudentInfo showstudent(@Param("studentid")Integer studentid);
	
	Integer flag(@Param("classno")Integer classno);
	
	void modifystudent(@Param("studentid")Integer studentid
						,@Param("name")String name
						,@Param("gender")String gender
						,@Param("email")String email
						,@Param("phone")String phone
						,@Param("classno")Integer classno);
	
	Integer studentexist(@Param("studentid")Integer studentid);
	
	void addstudent(@Param("studentid")Integer studentid
						,@Param("name")String name
						,@Param("gender")String gender
						,@Param("email")String email
						,@Param("phone")String phone
						,@Param("classno")Integer classno);
	
	void deletestudent(@Param("studentid")Integer studentid);
	
	void deleteaccount(@Param("studentid")Integer studentid);
	
	void deletestudentcourse(@Param("studentid")Integer studentid);
	
	TeacherInfo showteacher(@Param("teacherid")Integer teacherid);

	void modifyteacher(@Param("teacherid")Integer teacherid
						,@Param("teachername")String teachername
						,@Param("gender")String gender
						,@Param("email")String email
						,@Param("phone")String phone
						,@Param("department")String department
						,@Param("address")String address);
	
	Integer teacherexist(@Param("teacherid")Integer teacherid);

	void addteacher(@Param("teacherid")Integer teacherid
			,@Param("teachername")String teachername
			,@Param("gender")String gender
			,@Param("email")String email
			,@Param("phone")String phone
			,@Param("department")String department
			,@Param("address")String address);	

	void deleteteachercourse(@Param("teacherid")Integer teacherid);
	
	void deleteteacher(@Param("teacherid")Integer teacherid);
	
	List <Integer> courseids(@Param("teacherid")Integer teacherid);
	
	void deletecourse(@Param("courseid")Integer courseid);
	
	CourseInfo showcourse(@Param("courseid")Integer courseid);
	
	Integer teachercourseexist(@Param("courseid")Integer courseid,@Param("teacherid")Integer teacherid);
	
	void modifycourse(@Param("courseid")Integer courseid
						,@Param("coursename")String coursename
						,@Param("teacherid")Integer teacherid
						,@Param("courseplace")String courseplace
						,@Param("weektime")String weektime
						,@Param("day")String day
						,@Param("jieci")String jieci);
	
	Integer courseexist(@Param("courseid")Integer courseid);
	
	void addcourse(@Param("courseid")Integer courseid
					,@Param("coursename")String coursename
					,@Param("teacherid")Integer teacherid
					,@Param("courseplace")String courseplace
					,@Param("weektime")String weektime
					,@Param("day")String day
					,@Param("jieci")String jieci);
	
	void addaccount(@Param("accountid")Integer accountid,@Param("password")String password,@Param("flag")String flag);
}
