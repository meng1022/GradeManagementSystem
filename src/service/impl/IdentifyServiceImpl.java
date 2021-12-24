package service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.IdentifyMapper;
import service.IdentifyService;

@Service
public class IdentifyServiceImpl implements IdentifyService
{
	@Autowired
	private IdentifyMapper identifyMapper;
	
	@Override
	public String identity(Integer accountid,String password) {
		String flag = identifyMapper.identity(accountid,password);
		return flag;
	}
	
	@Override
	public void changepw(Integer accountid,String newpw) {
		identifyMapper.changepw(accountid,newpw);
	}
	
	@Override
	public String accountexist(Integer accountid) {
		if(identifyMapper.accountexist(accountid)==0) {
			return "error";
		}
		else {
			return "success";
		}
	}

	@Override
	public void resetpw(Integer accountid) {
		String flag = identifyMapper.getflag(accountid);
		identifyMapper.resetpw(accountid,flag);

	}
}
