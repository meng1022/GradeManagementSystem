package web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.sun.javafx.collections.MappingChange.Map;

import po.CourseInfo;
import po.StudentInfo;
import po.TeacherInfo;
import service.AdminService;

@Controller
@RequestMapping(value = "/admin")
public class AdminController
{
	@Autowired
	private AdminService adminService;
	
	//查看学生或老师信息
	@RequestMapping(value="/personalinfo",method=RequestMethod.GET)
	public ModelAndView personal(HttpServletRequest request,@RequestParam Integer flag) {
		if(flag == 1){
			List<StudentInfo> studentInfos = adminService.studentinfo();
			String url = "/pages/studentinfo";//.jsp
			ModelAndView modelAndView = new ModelAndView(url);
			modelAndView.addObject("studentInfos",studentInfos);
			modelAndView.addObject("flag","success");
			return modelAndView;
		}
		else {
			List<TeacherInfo> teacherInfos = adminService.teacherinfo();
			String url = "/pages/teacherinfo";//.jsp
			ModelAndView modelAndView = new ModelAndView(url);
			modelAndView.addObject("teacherInfos",teacherInfos);
			modelAndView.addObject("flag", "success");
			modelAndView.setViewName(url);
			return modelAndView;
		}
	}
	
	//查看课程信息
	@RequestMapping(value="/courseinfo",method=RequestMethod.GET)
	public ModelAndView course(HttpServletRequest request) {
			List<CourseInfo> courseInfos = adminService.course();
			String url = "/pages/courseinfo";//.jsp
			ModelAndView modelAndView = new ModelAndView(url);
			modelAndView.addObject("courseInfos",courseInfos);
			modelAndView.addObject("flag", "success");
			return modelAndView;
	}
	
	//修改学生信息界面
	@RequestMapping(value="/showstudent",method=RequestMethod.GET)
	public ModelAndView showstudent(HttpServletRequest request,@RequestParam Integer studentid) {
			StudentInfo studentInfo = adminService.showstudent(studentid);
			String flag = "success";
			String url = "/pages/modifystudent";//.jsp
			ModelAndView modelAndView = new ModelAndView(url);
			modelAndView.addObject("studentInfo",studentInfo);
			modelAndView.addObject("flag", flag);
			return modelAndView;
	}
	//修改学生信息
	@RequestMapping(value="/modifystudent",method=RequestMethod.GET)
	public ModelAndView modifystudent(HttpServletRequest request,@RequestParam Integer studentid
																,@RequestParam String name
																,@RequestParam String gender
																,@RequestParam String email
																,@RequestParam String phone
																,@RequestParam Integer classno) {
			String flag = adminService.flag(studentid,name,gender,email,phone,classno);
			if(flag == "error") {
				StudentInfo studentInfo = adminService.showstudent(studentid);
				String url = "/pages/modifystudent";//.jsp
				ModelAndView modelAndView = new ModelAndView(url);
				modelAndView.addObject("studentInfo",studentInfo);
				modelAndView.addObject("flag", flag);
				return modelAndView;
			}
			else {
				List<StudentInfo> studentInfos = adminService.studentinfo();
				String url = "/pages/studentinfo";//.jsp
				ModelAndView modelAndView = new ModelAndView(url);
				modelAndView.addObject("studentInfos",studentInfos);
				modelAndView.addObject("flag","success");
				return modelAndView;
			}
			
	}
	//添加学生界面
	@RequestMapping(value="/addstudentpage",method=RequestMethod.GET)
	public ModelAndView addstudentpage(HttpServletRequest request) {
			String flag = "success";
			String url = "/pages/addstudentpage";//.jsp
			ModelAndView modelAndView = new ModelAndView(url);
			modelAndView.addObject("flag", flag);
			return modelAndView;
	}
	//添加学生
	@RequestMapping(value="/addstudent",method=RequestMethod.GET)
	public ModelAndView addstudent(HttpServletRequest request,@RequestParam Integer studentid
																,@RequestParam String name
																,@RequestParam String gender
																,@RequestParam String email
																,@RequestParam String phone
																,@RequestParam Integer classno) {
			String flag = adminService.addflag(studentid,name,gender,email,phone,classno);
			if(flag == "error") {
				String url = "/pages/addstudentpage";//.jsp
				ModelAndView modelAndView = new ModelAndView(url);
				modelAndView.addObject("flag", flag);
				return modelAndView;
			}
			else {
				List<StudentInfo> studentInfos = adminService.studentinfo();
				String url = "/pages/studentinfo";//.jsp
				ModelAndView modelAndView = new ModelAndView(url);
				modelAndView.addObject("studentInfos",studentInfos);
				modelAndView.addObject("flag", "success");
				return modelAndView;
			}
			
	}
	//删除学生
	@RequestMapping(value="/deletestudent",method=RequestMethod.GET)
	public ModelAndView deletestudent(HttpServletRequest request,@RequestParam Integer studentid) {
			adminService.deletestudent(studentid);
			List<StudentInfo> studentInfos = adminService.studentinfo();
			String url = "/pages/studentinfo";//.jsp
			ModelAndView modelAndView = new ModelAndView(url);
			modelAndView.addObject("studentInfos",studentInfos);
			modelAndView.addObject("flag","success");
			return modelAndView;
	}
	//查找学生信息
	@RequestMapping(value="/searchstudent",method=RequestMethod.GET)
	public ModelAndView searchstudent(HttpServletRequest request,@RequestParam Integer studentid) {
			String flag = adminService.searchstudent(studentid);
			if(flag == "success") {
				String url = "/pages/searchstudent";//.jsp
				StudentInfo studentInfo = adminService.showstudent(studentid);
				ModelAndView modelAndView = new ModelAndView(url);
				modelAndView.addObject("studentInfo",studentInfo);
				return modelAndView;
			}
			else {
				String url = "/pages/studentinfo";//.jsp
				List <StudentInfo> studentInfos = adminService.studentinfo();
				ModelAndView modelAndView = new ModelAndView(url);
				modelAndView.addObject("studentInfos",studentInfos);
				modelAndView.addObject("flag",flag);
				return modelAndView;
			}
	}
//****************************************************************************************************
		//修改老师信息界面
		@RequestMapping(value="/showteacher",method=RequestMethod.GET)
		public ModelAndView showteacher(HttpServletRequest request,@RequestParam Integer teacherid) {
				TeacherInfo teacherInfo = adminService.showteacher(teacherid);
				String flag = "success";
				String url = "/pages/modifyteacher";//.jsp
				ModelAndView modelAndView = new ModelAndView(url);
				modelAndView.addObject("teacherInfo",teacherInfo);
				modelAndView.addObject("flag", flag);
				return modelAndView;
		}
		//修改老师信息
		@RequestMapping(value="/modifyteacher",method=RequestMethod.GET)
		public ModelAndView modifystudent(HttpServletRequest request,@RequestParam Integer teacherid
																	,@RequestParam String teachername
																	,@RequestParam String gender
																	,@RequestParam String email
																	,@RequestParam String phone
																	,@RequestParam String department
																	,@RequestParam String address) {
			adminService.modifyteacher(teacherid,teachername,gender,email,phone,department,address);
			List<TeacherInfo> teacherInfos = adminService.teacherinfo();
			String url = "/pages/teacherinfo";//.jsp
			ModelAndView modelAndView = new ModelAndView(url);
			modelAndView.addObject("teacherInfos",teacherInfos);
			modelAndView.addObject("flag", "success");
			return modelAndView;
		}	
		//添加老师界面
		@RequestMapping(value="/addteacherpage",method=RequestMethod.GET)
		public ModelAndView addteacherpage(HttpServletRequest request) {
				String flag = "success";
				String url = "/pages/addteacherpage";//.jsp
				ModelAndView modelAndView = new ModelAndView(url);
				modelAndView.addObject("flag", flag);
				return modelAndView;
		}
		//添加老师
		@RequestMapping(value="/addteacher",method=RequestMethod.GET)
		public ModelAndView addteacher(HttpServletRequest request,@RequestParam Integer teacherid
																 ,@RequestParam String teachername
																 ,@RequestParam String gender
																 ,@RequestParam String email
																 ,@RequestParam String phone
																 ,@RequestParam String department
																 ,@RequestParam String address) {
				String flag = adminService.addteacherflag(teacherid,teachername,gender,email,phone,department,address);
				if(flag == "error") {
					String url = "/pages/addteacherpage";//.jsp
					ModelAndView modelAndView = new ModelAndView(url);
					modelAndView.addObject("flag", flag);
					return modelAndView;
				}
				else {
					List<TeacherInfo> teacherInfos = adminService.teacherinfo();
					String url = "/pages/teacherinfo";//.jsp
					ModelAndView modelAndView = new ModelAndView(url);
					modelAndView.addObject("teacherInfos",teacherInfos);
					modelAndView.addObject("flag", "success");
					return modelAndView;
				}
				
		}
		//删除老师
		@RequestMapping(value="/deleteteacher",method=RequestMethod.GET)
		public ModelAndView deleteteacher(HttpServletRequest request,@RequestParam Integer teacherid) {
				adminService.deleteteacher(teacherid);
				List<TeacherInfo> teacherInfos= adminService.teacherinfo();
				String url = "/pages/teacherinfo";//.jsp
				ModelAndView modelAndView = new ModelAndView(url);
				modelAndView.addObject("teacherInfos",teacherInfos);
				modelAndView.addObject("flag", "success");
				return modelAndView;
		}
		//查找老师信息
		@RequestMapping(value="/searchteacher",method=RequestMethod.GET)
		public ModelAndView searchteacher(HttpServletRequest request,@RequestParam Integer teacherid) {
				String flag = adminService.searchteacher(teacherid);
				if(flag == "success") {//老师存在
					String url = "/pages/searchteacher";//.jsp
					TeacherInfo teacherInfo = adminService.showteacher(teacherid);
					ModelAndView modelAndView = new ModelAndView(url);
					modelAndView.addObject("teacherInfo",teacherInfo);
					return modelAndView;
				}
				else {
					String url = "/pages/teacherinfo";//.jsp
					List <TeacherInfo> teacherInfos = adminService.teacherinfo();
					ModelAndView modelAndView = new ModelAndView(url);
					modelAndView.addObject("teacherInfos",teacherInfos);
					modelAndView.addObject("flag",flag);
					return modelAndView;
				}
		}
//*************************************************************************************************
		//修改课程信息界面
		@RequestMapping(value="/showcourse",method=RequestMethod.GET)
		public ModelAndView showcourse(HttpServletRequest request,@RequestParam Integer courseid) {
				CourseInfo courseInfo = adminService.showcourse(courseid);
				String flag = "success";
				String url = "/pages/modifycourse";//.jsp
				ModelAndView modelAndView = new ModelAndView(url);
				modelAndView.addObject("courseInfo",courseInfo);
				modelAndView.addObject("flag", flag);
				return modelAndView;
		}
		//修改课程信息
		@RequestMapping(value="/modifycourse",method=RequestMethod.GET)
		public ModelAndView modifycourse(HttpServletRequest request,@RequestParam Integer courseid
																	,@RequestParam String coursename
																	,@RequestParam Integer teacherid
																	,@RequestParam String courseplace
																	,@RequestParam String weektime
																	,@RequestParam String day
																	,@RequestParam String jieci) {
				String flag = adminService.modifycourse(courseid,coursename,teacherid,courseplace,weektime,day,jieci);
				if(flag == "success") {
					List<CourseInfo> courseInfos = adminService.course();
					String url = "/pages/courseinfo";//.jsp
					ModelAndView modelAndView = new ModelAndView(url);
					modelAndView.addObject("courseInfos",courseInfos);
					modelAndView.addObject("flag", "success");
					return modelAndView;
				}
				else {//重复记录或教职工号不存在
					CourseInfo courseInfo = adminService.showcourse(courseid);
					String url = "/pages/modifycourse";//.jsp
					ModelAndView modelAndView = new ModelAndView(url);
					modelAndView.addObject("courseInfo",courseInfo);
					modelAndView.addObject("flag", "error");
					return modelAndView;
				}
				
		}
		//删除课程
		@RequestMapping(value="/deletecourse",method=RequestMethod.GET)
		public ModelAndView deletecourse(HttpServletRequest request,@RequestParam Integer courseid) {
				adminService.deletecourse(courseid);
				List<CourseInfo> courseInfos= adminService.course();
				String url = "/pages/courseinfo";//.jsp
				ModelAndView modelAndView = new ModelAndView(url);
				modelAndView.addObject("courseInfos",courseInfos);
				modelAndView.addObject("flag", "success");
				return modelAndView;
		}
		//查找课程信息
		@RequestMapping(value="/searchcourse",method=RequestMethod.GET)
		public ModelAndView searchcourse(HttpServletRequest request,@RequestParam Integer courseid) {
				String flag = adminService.searchcourse(courseid);
				if(flag == "success") {//课程存在
					String url = "/pages/searchcourse";//.jsp
					CourseInfo courseInfo = adminService.showcourse(courseid);
					ModelAndView modelAndView = new ModelAndView(url);
					modelAndView.addObject("courseInfo",courseInfo);
					return modelAndView;
				}
				else {
					String url = "/pages/courseinfo";//.jsp
					List<CourseInfo> courseInfos= adminService.course();
					ModelAndView modelAndView = new ModelAndView(url);
					modelAndView.addObject("courseInfos",courseInfos);
					modelAndView.addObject("flag",flag);
					return modelAndView;
				}
		}

		//添加课程界面
		@RequestMapping(value="/addcoursepage",method=RequestMethod.GET)
		public ModelAndView addcoursepage(HttpServletRequest request) {
				String flag = "success";
				String url = "/pages/addcoursepage";//.jsp
				ModelAndView modelAndView = new ModelAndView(url);
				modelAndView.addObject("flag", flag);
				return modelAndView;
		}
		//添加课程
		@RequestMapping(value="/addcourse",method=RequestMethod.GET)
		public ModelAndView addcourse(HttpServletRequest request,@RequestParam Integer courseid
																,@RequestParam String coursename
																,@RequestParam Integer teacherid
																,@RequestParam String courseplace
																,@RequestParam String weektime
																,@RequestParam String day
																,@RequestParam String jieci) {
				String flag = adminService.addcourse(courseid,coursename,teacherid,courseplace,weektime,day,jieci);
				if(flag == "error") {
					String url = "/pages/addcoursepage";//.jsp
					ModelAndView modelAndView = new ModelAndView(url);
					modelAndView.addObject("flag", flag);
					return modelAndView;
				}
				else {
					List<CourseInfo> courseInfos = adminService.course();
					String url = "/pages/courseinfo";//.jsp
					ModelAndView modelAndView = new ModelAndView(url);
					modelAndView.addObject("courseInfos",courseInfos);
					modelAndView.addObject("flag", "success");
					return modelAndView;
				}
				
		}
}