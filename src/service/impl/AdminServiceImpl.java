package service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sun.org.apache.regexp.internal.recompile;

import dao.AdminMapper;
import net.sf.cglib.transform.impl.InterceptFieldFilter;
import po.CourseInfo;
import po.StudentInfo;
import po.TeacherInfo;
import service.AdminService;

@Service
public class AdminServiceImpl implements AdminService
{
	@Autowired
	private AdminMapper adminMapper;
	
	@Override
	public List<StudentInfo> studentinfo(){
		return adminMapper.studentinfo();
	}
	
	@Override
	public List<TeacherInfo> teacherinfo(){
		return adminMapper.teacherinfo();
	}
	
	@Override
	public List<CourseInfo> course(){
		return adminMapper.courseinfo();
	}
	
	@Override
	public StudentInfo showstudent(Integer studentid) {
		return adminMapper.showstudent(studentid);//学生的信息记录
	}
	
	@Override
	public String flag(Integer studentid,String name,String gender,String email,String phone,Integer classno) {
		if(adminMapper.flag(classno)==1){
			adminMapper.modifystudent(studentid,name,gender,email,phone,classno);
			return "success";
		}
		else {
			return "error";
		}	
	}

	@Override
	public String addflag(Integer studentid,String name,String gender,String email,String phone,Integer classno) {
		if((adminMapper.flag(classno)==1) &&adminMapper.studentexist(studentid) == 0) {
			adminMapper.addstudent(studentid,name,gender,email,phone,classno);
			adminMapper.addaccount(studentid,String.valueOf(studentid),"student");
			return "success";
		}
		else {
			return "error";
		}
	}
	
	@Override
	public void deletestudent(Integer studentid) {
		//adminMapper.deletestudentcourse(studentid);
		adminMapper.deleteaccount(studentid);
		adminMapper.deletestudent(studentid);
	}
	
	@Override 
	public String searchstudent(Integer studentid) {
		if(adminMapper.studentexist(studentid)==1) {
			return "success";
		}
		else {
			return "error";
		}
	}
	
	@Override
	public TeacherInfo showteacher(Integer teacherid) {
		return adminMapper.showteacher(teacherid);//学生的信息记录
	}
	
	@Override
	public void modifyteacher(Integer teacherid,String teachername,String gender,String email,String phone,String department,String address) {
		adminMapper.modifyteacher(teacherid, teachername, gender, email, phone,department,address);
	}
	@Override
	public String addteacherflag(Integer teacherid,String teachername,String gender,String email,String phone,String department,String address) {
		if(adminMapper.teacherexist(teacherid)==0) {
			adminMapper.addaccount(teacherid,String.valueOf(teacherid),"teacher");
			adminMapper.addteacher(teacherid, teachername, gender, email, phone,department,address);
			return "success";
		}
		else {
			return "error";
		}
	}
	
	@Override
	public void deleteteacher(Integer teacherid) {
		adminMapper.deleteaccount(teacherid);
//		List<Integer> courseids = adminMapper.courseids(teacherid);
//		for(int i=0;i<courseids.size();i++) {
//			adminMapper.deletecourse(courseids.get(i));
//		}
//		adminMapper.deleteteachercourse(teacherid);
		adminMapper.deleteteacher(teacherid);
	}

	@Override
	public String searchteacher(Integer teacherid) {
		if(adminMapper.teacherexist(teacherid)==1)
			return "success";
		else
			return "false";
	}
	
	@Override
	public CourseInfo showcourse(Integer courseid) {
		return adminMapper.showcourse(courseid);
	}
	
	@Override
	public String modifycourse(Integer courseid,String coursename,Integer teacherid,String courseplace,String weektime,String day,String jieci) {
		if(adminMapper.teacherexist(teacherid)==1) {
			adminMapper.modifycourse(courseid,coursename,teacherid,courseplace,weektime,day,jieci);
			return "success";
		}
		else {
			return "error";
		}
	}
	
	@Override
	public void deletecourse(Integer courseid) {
		adminMapper.deletecourse(courseid);
	}
	
	@Override
	public String searchcourse(Integer courseid) {
		if(adminMapper.courseexist(courseid)==1) {
			return "success";
		}
		else {
			return "error";
		}
	}
	
	@Override
	public 	String addcourse(Integer courseid,String coursename,Integer teacherid,String courseplace,String weektime,String day,String jieci) {
		if(adminMapper.courseexist(courseid)==0 && adminMapper.teacherexist(teacherid)!=0 && adminMapper.teachercourseexist(courseid, teacherid)==0)
		{
			
			adminMapper.addcourse(courseid,coursename,teacherid,courseplace,weektime,day,jieci);
			return "success";
		}
			
		else
			return "error";
	}

}
