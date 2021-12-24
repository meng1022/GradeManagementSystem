package service;

import java.util.List;

import org.springframework.web.bind.annotation.RequestParam;

import com.sun.javafx.binding.StringFormatter;

import po.StudentInfo;
import po.TeacherInfo;
import po.CourseInfo;

public interface AdminService
{
	List<StudentInfo> studentinfo();
	
	List<TeacherInfo> teacherinfo();
	
	List<CourseInfo> course();
	
	StudentInfo showstudent(Integer studentid);

	String flag(Integer studentid,String name,String gender,String email,String phone,Integer classno);
	
	String addflag(Integer studentid,String name,String gender,String email,String phone,Integer classno);
	
	void deletestudent(Integer studentid);
	
	String searchstudent(Integer studentid);
	
	TeacherInfo showteacher(Integer teacherid);

	void modifyteacher(Integer teacherid,String teachername,String gender,String email,String phone,String department,String address);
	
	String addteacherflag(Integer teacherid,String teachername,String gender,String email,String phone,String department,String address);

	void deleteteacher(Integer teacherid);
	
	String searchteacher(Integer teacherid);
	
	CourseInfo showcourse(Integer courseid);
	
	String modifycourse(Integer courseid,String coursename,Integer teacherid,String courseplace,String weektime,String day,String jieci);

	void deletecourse(Integer courseid);
	
	String searchcourse(Integer courseid);
	
	String addcourse(Integer courseid,String coursename,Integer teacherid,String courseplace,String weektime,String day,String jieci);
}
