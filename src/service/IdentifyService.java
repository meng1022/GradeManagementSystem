package service;


public interface IdentifyService
{
	String identity(Integer accountid,String password);
	
	void changepw(Integer accountid,String newpw);
	
	void resetpw(Integer accountid);
	
	String accountexist(Integer accountid);
}
