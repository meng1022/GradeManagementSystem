package dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import po.StudentCourseInfo;
import po.StudentInfo;
import po.StudentScoreInfo;

public interface StudentMapper
{
	StudentInfo personal(@Param("accountid")Integer accountid);
	
	List<StudentCourseInfo> studentcourse(@Param("accountid")Integer accountid);
	
	List<StudentScoreInfo> studentscore(@Param("accountid")Integer accountid);
}
