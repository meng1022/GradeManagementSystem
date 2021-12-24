package web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.jfree.chart.JFreeChart;
import org.jfree.chart.servlet.ServletUtilities;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.web.servlet.ModelAndView;

import po.RankScore;
import po.TeacherCourseInfo;
import po.TeacherInfo;
import po.TeacherScoreInfo;
import service.TeacherService;
import utils.ColumnChartDataSet;
import utils.PieChartDataSet;

@Controller
@RequestMapping(value = "/teacher")
public class TeacherController
{
	@Autowired
	private TeacherService teacherService;
	
	@RequestMapping(value="/personalinfo",method=RequestMethod.GET)
	public ModelAndView personal(HttpServletRequest request,@RequestParam Integer accountid) {
		TeacherInfo teacherinfo = teacherService.personal(accountid);
		String url = "/pages/teacherpersonalinfo";//.jsp
		ModelAndView modelAndView = new ModelAndView(url,"teacherinfo",teacherinfo);
		return modelAndView;
	}
	
	@RequestMapping(value="/courseinfo",method=RequestMethod.GET)
	public ModelAndView course(HttpServletRequest request,@RequestParam Integer accountid,@RequestParam Integer flag) {
		
		if(flag == 1){
			List<TeacherCourseInfo> teacherCourseInfo = teacherService.course(accountid);
			String url = "/pages/teachercourseinfo";//.jsp
			ModelAndView modelAndView = new ModelAndView(url);
			modelAndView.addObject("teacherCourseInfo",teacherCourseInfo);
			modelAndView.addObject("teacherid", accountid);
			return modelAndView;
		}
			
		else {
			List<TeacherScoreInfo> teacherScoreInfo = teacherService.score(accountid);
			String url = "/pages/teacherscoreinfo";
			ModelAndView modelAndView = new ModelAndView(url);
			modelAndView.addObject("flag", "success");
			modelAndView.addObject("teacherScoreInfo",teacherScoreInfo);
			modelAndView.addObject("teacherid", accountid);
			return modelAndView;
		}

	}
	
	@RequestMapping(value="/showscore",method=RequestMethod.GET)
	public ModelAndView modifyscore(HttpServletRequest request,@RequestParam Integer courseid,@RequestParam Integer studentid,@RequestParam Integer teacherid) {
		TeacherScoreInfo teacherScoreInfo = teacherService.showscore(courseid,studentid,teacherid);
		String url = "/pages/modifyscore";//.jsp
		ModelAndView modelAndView = new ModelAndView(url);
		modelAndView.addObject("flag", "success");
		modelAndView.addObject("teacherScoreInfo",teacherScoreInfo);
		modelAndView.addObject("teacherid", teacherid);
		return modelAndView;
	}
	
	@RequestMapping(value="/modifyscore",method=RequestMethod.GET)
	public ModelAndView modifyscore(HttpServletRequest request,@RequestParam Integer courseid,@RequestParam Integer studentid,@RequestParam Integer teacherid,@RequestParam Integer score) {
		List<TeacherScoreInfo> teacherScoreInfo = teacherService.modifyscore(courseid,studentid,teacherid,score);
		String url = "/pages/teacherscoreinfo";//.jsp
		ModelAndView modelAndView = new ModelAndView(url);
		modelAndView.addObject("teacherid", teacherid);
		modelAndView.addObject("teacherScoreInfo",teacherScoreInfo);
		modelAndView.addObject("flag", "success");
		return modelAndView;
	}
	
	
	@RequestMapping(value="/deletescore",method=RequestMethod.GET)
	public ModelAndView deletescore(HttpServletRequest request,@RequestParam Integer courseid,@RequestParam Integer studentid,@RequestParam Integer teacherid) {
		teacherService.deletescore(courseid,studentid);
		List<TeacherScoreInfo> teacherScoreInfo = teacherService.score(teacherid);
		String url = "/pages/teacherscoreinfo";
		ModelAndView modelAndView = new ModelAndView(url);
		modelAndView.addObject("teacherid", teacherid);
		modelAndView.addObject("flag", "success");
		modelAndView.addObject("teacherScoreInfo", teacherScoreInfo);
		return modelAndView;
	}
	
	@RequestMapping(value="/addscorepage",method=RequestMethod.GET)
	public ModelAndView addscorepage(HttpServletRequest request,@RequestParam Integer teacherid) {
		String url = "/pages/addscorepage";
		ModelAndView modelAndView = new ModelAndView(url);
		modelAndView.addObject("teacherid",teacherid);
		modelAndView.addObject("flag", "success");
		return modelAndView;
	}
	
	@RequestMapping(value="/addscore",method=RequestMethod.GET)
	public ModelAndView addscore(HttpServletRequest request,@RequestParam Integer courseid,@RequestParam Integer studentid,@RequestParam Integer teacherid,@RequestParam Integer score) {
		String flag = teacherService.addscore(courseid,studentid,score,teacherid);
		if(flag=="success")
		{
			String url = "/pages/teacherscoreinfo";
			List<TeacherScoreInfo> teacherScoreInfo = teacherService.score(teacherid);
			ModelAndView modelAndView = new ModelAndView(url);
			modelAndView.addObject("teacherid", teacherid);
			modelAndView.addObject("flag", "success");
			modelAndView.addObject("teacherScoreInfo", teacherScoreInfo);
			return modelAndView;
		}
		else {
			String url = "/pages/addscorepage";
			ModelAndView modelAndView = new ModelAndView(url);
			modelAndView.addObject("teacherid",teacherid);
			modelAndView.addObject("flag", flag);
			return modelAndView;
		}
		
	}
	
	@RequestMapping(value="/searchscore",method=RequestMethod.GET)
	public ModelAndView searchscore(HttpServletRequest request,@RequestParam Integer courseid,@RequestParam Integer studentid,@RequestParam Integer teacherid) {
		String flag = teacherService.searchscoreflag(courseid,studentid,teacherid);//结果是否存在
		if(flag == "success") {
			String url = "/pages/searchscore";
			List<TeacherScoreInfo> teacherScoreInfos = teacherService.searchscore(courseid,studentid,teacherid);
			ModelAndView modelAndView = new ModelAndView(url);
			modelAndView.addObject("teacherid",teacherid);
			modelAndView.addObject("teacherScoreInfos", teacherScoreInfos);
			return modelAndView;
		}
		else {
			String url = "/pages/teacherscoreinfo";
			List<TeacherScoreInfo> teacherScoreInfo = teacherService.score(teacherid);
			ModelAndView modelAndView = new ModelAndView(url);
			modelAndView.addObject("teacherid", teacherid);
			modelAndView.addObject("flag", "error");
			modelAndView.addObject("teacherScoreInfo", teacherScoreInfo);
			return modelAndView;
		}
	}
	
	@RequestMapping(value="/rankscore",method=RequestMethod.GET)
	public ModelAndView rankscore(HttpServletRequest request,@RequestParam Integer courseid,@RequestParam Integer teacherid) throws Exception{
		String flag = teacherService.rankflag(teacherid,courseid);
		if(flag == "success")
		{
			String url = "/pages/rankscore";
			RankScore rankScore = teacherService.rankscore(teacherid,courseid);
			JFreeChart chart1 = ColumnChartDataSet.createColumnarTools(rankScore);
			String filename1 = ServletUtilities.saveChartAsJPEG(chart1, 700, 400,null, request.getSession());
			System.out.println("chartpath1===================>"+filename1);
			JFreeChart chart2 = PieChartDataSet.createPieTools(rankScore);
			String filename2 = ServletUtilities.saveChartAsPNG(chart2, 700, 400, null, request.getSession());
			ModelAndView modelAndView = new ModelAndView(url);
			modelAndView.addObject("teacherid",teacherid);
			modelAndView.addObject("filename1", filename1);
			modelAndView.addObject("filename2", filename2);
			modelAndView.addObject("rankscores", rankScore);
			return modelAndView;
		}
		else {
			String url = "/pages/teacherscoreinfo";
			List<TeacherScoreInfo> teacherScoreInfo = teacherService.score(teacherid);
			ModelAndView modelAndView = new ModelAndView(url);
			modelAndView.addObject("teacherid", teacherid);
			modelAndView.addObject("flag", "error");
			modelAndView.addObject("teacherScoreInfo", teacherScoreInfo);
			return modelAndView;
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}