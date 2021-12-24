package dao;

import org.apache.ibatis.annotations.Param;

public interface IdentifyMapper
{
	String identity(@Param("accountid")Integer accountid,@Param("password")String password);

	void changepw(@Param("accountid")Integer accountid,@Param("newpw")String newpw);

	Integer accountexist(@Param("accountid")Integer accountid);
	
	String getflag(@Param("accountid")Integer accountid);
	
//	void resetpw1(@Param("accountid")Integer accountid);
//	
//	void resetpw2(@Param("accountid")Integer accountid);

	void resetpw(@Param("accountid")Integer accountid,@Param("flag")String flag);
}
