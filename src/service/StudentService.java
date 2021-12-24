package service;

import java.util.List;

import po.StudentCourseInfo;
import po.StudentInfo;
import po.StudentScoreInfo;

public interface StudentService
{
	StudentInfo personal(Integer accountid);
	
	List<StudentCourseInfo> course(Integer accountid);
	
	List<StudentScoreInfo>score(Integer accountid);
}
