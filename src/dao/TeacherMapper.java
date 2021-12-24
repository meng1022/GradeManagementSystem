package dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import po.RankScore;
import po.StudentCourseInfo;
import po.StudentInfo;
import po.StudentScoreInfo;
import po.TeacherCourseInfo;
import po.TeacherInfo;
import po.TeacherScoreInfo;

public interface TeacherMapper
{
	TeacherInfo personal(@Param("accountid")Integer accountid);
	
	List<TeacherCourseInfo> teachercourse(@Param("accountid")Integer accountid);
	
	List<TeacherScoreInfo> teacherscore(@Param("accountid")Integer accountid);
	
	TeacherScoreInfo showscore(@Param("courseid")Integer courseid,@Param("studentid")Integer studentid,@Param("teacherid")Integer teacherid);
	
	void modifyscore(@Param("courseid")Integer courseid,@Param("studentid")Integer studentid,@Param("teacherid")Integer teacherid,@Param("score")Integer score);
	
	void deletescore(@Param("courseid")Integer courseid,@Param("studentid")Integer studentid);
	
	Integer teachercourseexist(@Param("teacherid")Integer teacherid,@Param("courseid")Integer courseid);

	Integer scoreexist(@Param("courseid")Integer courseid,@Param("studentid")Integer studentid);
	
	void addscore(@Param("courseid")Integer courseid,@Param("studentid")Integer studentid,@Param("score")Integer score);

	Integer scoreexist1(@Param("studentid")Integer studentid,@Param("teacherid")Integer teacherid);
	
	Integer scoreexist2(@Param("courseid")Integer courseid,@Param("teacherid")Integer teacherid);

	List<TeacherScoreInfo> searchscore1(@Param("teacherid")Integer teacherid,@Param("courseid")Integer courseid);
	
	List<TeacherScoreInfo> searchscore2(@Param("teacherid")Integer teacherid,@Param("studentid")Integer studentid);

	List<TeacherScoreInfo> searchscore3(@Param("studentid")Integer studentid,@Param("courseid")Integer courseid);

	RankScore rankscore(@Param("teacherid")Integer teacherid,@Param("courseid")Integer courseid);
}
