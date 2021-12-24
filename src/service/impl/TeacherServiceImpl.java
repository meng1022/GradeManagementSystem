package service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.AdminMapper;
import dao.TeacherMapper;
import po.RankScore;
import po.TeacherCourseInfo;
import po.TeacherInfo;
import po.TeacherScoreInfo;
import service.StudentService;
import service.TeacherService;

@Service
public class TeacherServiceImpl implements TeacherService
{
	@Autowired
	private TeacherMapper teacherMapper;
	@Autowired
	private AdminMapper adminMapper;
	
	@Override
	public TeacherInfo personal(Integer accountid) {
		return teacherMapper.personal(accountid);
	}
	
	@Override
	public List<TeacherCourseInfo> course(Integer accountid) {
		return teacherMapper.teachercourse(accountid);
	}
	
	@Override
	public List<TeacherScoreInfo> score(Integer accountid){
		return teacherMapper.teacherscore(accountid);
	}
	
	@Override
	public TeacherScoreInfo showscore(Integer courseid,Integer studentid,Integer teacherid) {
		return teacherMapper.showscore(courseid,studentid,teacherid);
	}

	@Override
	public List<TeacherScoreInfo> modifyscore(Integer courseid,Integer studentid,Integer teacherid,Integer score) {
		teacherMapper.modifyscore(courseid,studentid,teacherid,score);
		return teacherMapper.teacherscore(teacherid);
	}
	
	@Override
	public void deletescore(Integer courseid,Integer studentid) {
		teacherMapper.deletescore(courseid,studentid);
	}
	
	@Override
	public String addscore(Integer courseid,Integer studentid,Integer score,Integer teacherid) {
		if(adminMapper.studentexist(studentid)==1 &&  /*courseinfo->*/teacherMapper.teachercourseexist(teacherid,courseid)!=0 && teacherMapper.scoreexist(courseid,studentid)==0) {
			teacherMapper.addscore(courseid,studentid,score);
			return "success";
		}
		else {
			return "error";
		}
	}
	
	@Override
	public String searchscoreflag(Integer courseid,Integer studentid,Integer teacherid) {
		if(courseid!=null && studentid!=null){
			if(teacherMapper.scoreexist(courseid,studentid)!=0)
				return "success";
			else
				return "error";
		}
		else if(courseid==null && studentid !=null){
			if(teacherMapper.scoreexist1(studentid,teacherid)!=0)
				return "success";
			else 
				return "error";
		}
		else if(courseid!=null && studentid ==null){
			if(teacherMapper.scoreexist2(courseid, teacherid)!=0)
				return "success";
			else 				
				return "error";
		}
		else 
			return "success";
	}
	
	@Override
	public List<TeacherScoreInfo> searchscore(Integer courseid,Integer studentid,Integer teacherid){
		if(courseid==null && studentid ==null)
		{
			return teacherMapper.teacherscore(teacherid);
		}
		else if(courseid!=null && studentid==null)
		{
			return teacherMapper.searchscore1(teacherid,courseid);
		}
		else if(courseid == null && studentid!=null){
			return teacherMapper.searchscore2(teacherid,studentid);
		}
		else {
			return teacherMapper.searchscore3(studentid,courseid);
		}
	}
	
	@Override
	public RankScore rankscore(Integer teacherid,Integer courseid){
		return teacherMapper.rankscore(teacherid,courseid);
	}
	
	@Override
	public String rankflag(Integer teacherid,Integer courseid) {
		if(teacherMapper.scoreexist2(courseid, teacherid)!=0)
			return "success";
		else
			return "error";
	}
	
	
	
	

}
