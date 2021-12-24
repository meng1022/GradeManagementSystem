//package web;
//
//import javax.servlet.http.HttpServletRequest;
//
//import org.codehaus.jackson.map.util.JSONPObject;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.ResponseBody;
//import service.IUserService;
//import po.Userlist;
//import java.util.List;
//
//import net.sf.json.JSONArray;
//
//
//@Controller
//@RequestMapping(value = "/userWeb")
//public class userWeb
//{
//	@Autowired
//	private IUserService iUserService;
//	
//	@RequestMapping(value = "/touser",method=RequestMethod.GET)
//	@ResponseBody
//	public String toUser(HttpServletRequest request)throws Exception{
//		List<Userlist> list=iUserService.selectall();
//		JSONArray jsonArray = JSONArray.fromObject(list);
//		String response = jsonArray.toString();
//		return response;
//	}
//	
//	@RequestMapping(value = "/adduser",method=RequestMethod.GET)
//	@ResponseBody
//	public String addUser(HttpServletRequest request)throws Exception{
//		iUserService.adduser();
//		List<Userlist> list=iUserService.selectall();
//		JSONArray jsonArray = JSONArray.fromObject(list);
//		String response = jsonArray.toString();
//		return response;
//	}
//}
