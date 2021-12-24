package service;

import java.util.List;

import po.RankScore;
import po.StudentCourseInfo;
import po.StudentInfo;
import po.StudentScoreInfo;
import po.TeacherCourseInfo;
import po.TeacherInfo;
import po.TeacherScoreInfo;

public interface TeacherService
{
	TeacherInfo personal(Integer accountid);
	
	List<TeacherCourseInfo> course(Integer accountid);
	
	List<TeacherScoreInfo>score(Integer accountid);
	
	TeacherScoreInfo showscore(Integer courseid,Integer studentid,Integer teacherid) ;
	
	List<TeacherScoreInfo> modifyscore(Integer courseid,Integer studentid,Integer teacherid,Integer score);
	
	void deletescore(Integer courseid,Integer studentid);

	String addscore(Integer courseid,Integer studentid,Integer score,Integer teacherid);

	String searchscoreflag(Integer courseid,Integer studentid,Integer teacherid);
	
	List<TeacherScoreInfo> searchscore(Integer courseid,Integer studentid,Integer teacherid);
	
	RankScore rankscore(Integer teacherid,Integer courseid);
	
	String rankflag(Integer teacherid,Integer courseid);
}
