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

import po.StudentCourseInfo;
import po.StudentInfo;
import po.StudentScoreInfo;
import service.StudentService;

@Controller
@RequestMapping(value = "/student")
public class StudentController
{
	@Autowired
	private StudentService studentService;
	
	@RequestMapping(value="/personalinfo",method=RequestMethod.GET)
	public ModelAndView personal(HttpServletRequest request,@RequestParam Integer accountid) {
		StudentInfo studentinfo = studentService.personal(accountid);
		String url = "/pages/studentpersonalinfo";//.jsp
		ModelAndView modelAndView = new ModelAndView(url,"studentinfo",studentinfo);
		modelAndView.setViewName(url);
		return modelAndView;
	}
	
	@RequestMapping(value="/courseinfo",method=RequestMethod.GET)
	public ModelAndView course(HttpServletRequest request,@RequestParam Integer accountid,@RequestParam Integer flag) {
		
		if(flag == 1){
			List<StudentCourseInfo> studentCourseInfo = studentService.course(accountid);
			String url = "/pages/studentcourseinfo";//.jsp
			ModelAndView modelAndView = new ModelAndView(url);
			modelAndView.addObject("studentCourseInfo",studentCourseInfo);
			modelAndView.addObject("accountid", accountid);
			modelAndView.setViewName(url);
			return modelAndView;
		}
			
		else {
			List<StudentScoreInfo> studentScoreInfo = studentService.score(accountid);
			String url = "/pages/studentscoreinfo";
			ModelAndView modelAndView = new ModelAndView(url);
			modelAndView.addObject("studentScoreInfo",studentScoreInfo);
			modelAndView.addObject("accountid", accountid);
			modelAndView.setViewName(url);
			return modelAndView;
		}

	}
	
//	@RequestMapping(value="/scoreinfo",method=RequestMethod.GET)
//	public ModelAndView score(HttpServletRequest request,@RequestParam Integer accountid) {
//		String flag = studentService.score(accountid);
//		System.out.println("flag ========>"+flag);
//		String url = "";
//		if (flag!=null){
//			url = "/pages/"+flag;//.jsp
//		}
//		else {
//			url = "/pages/index";//.jsp
//		}
//		ModelAndView modelAndView = new ModelAndView(url,"accountid",accountid);
//		modelAndView.setViewName(url);
//		return modelAndView;
//	}
	
	
}