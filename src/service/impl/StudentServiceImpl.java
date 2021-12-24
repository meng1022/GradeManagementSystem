package service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.StudentMapper;
import po.StudentCourseInfo;
import po.StudentInfo;
import po.StudentScoreInfo;
import service.StudentService;

@Service
public class StudentServiceImpl implements StudentService
{
	@Autowired
	private StudentMapper studentMapper;
	
	@Override
	public StudentInfo personal(Integer accountid) {
		return studentMapper.personal(accountid);
	}
	
	@Override
	public List<StudentCourseInfo> course(Integer accountid) {
		return studentMapper.studentcourse(accountid);
	}
	
	@Override
	public List<StudentScoreInfo> score(Integer accountid){
		return studentMapper.studentscore(accountid);
	}
}
