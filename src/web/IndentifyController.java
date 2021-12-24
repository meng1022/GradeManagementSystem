package web;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import service.IdentifyService;

@Controller
@RequestMapping(value = "/default")
public class IndentifyController
{
	@Autowired
	private IdentifyService identifyService;
	
	@RequestMapping(value="/identify",method=RequestMethod.GET)
	public ModelAndView index(HttpServletRequest request,@RequestParam Integer accountid,@RequestParam String password) {
		String flag = identifyService.identity(accountid,password);
		System.out.println("flag ========>"+flag);
		String url = "";
		if (flag!=null){
			url = "/pages/"+flag;
		}
		else {
			url = "/pages/index";
		}
		ModelAndView modelAndView = new ModelAndView(url,"accountid",accountid);
		modelAndView.setViewName(url);
		return modelAndView;
	}
	
	@RequestMapping(value="/changepw",method=RequestMethod.GET)
	public ModelAndView changepw(HttpServletRequest request,@RequestParam Integer accountid) {
		String url = "/pages/password";
		ModelAndView modelAndView = new ModelAndView(url,"accountid",accountid);
		modelAndView.setViewName(url);
		return modelAndView;
	}
	
	@RequestMapping(value="/changepw_ok",method=RequestMethod.GET)
	public ModelAndView changepw_ok(HttpServletRequest request,@RequestParam Integer accountid,@RequestParam String newpw) {
		identifyService.changepw(accountid,newpw);
		String url = "/pages/index";
		ModelAndView modelAndView = new ModelAndView(url);
		modelAndView.setViewName(url);
		return modelAndView;
	}
	
	@RequestMapping(value="/resetpassword",method=RequestMethod.GET)
	public ModelAndView resetpassword(HttpServletRequest request,@RequestParam Integer accountid) {
		String flag = identifyService.accountexist(accountid);
		if(flag != "success") {
			String url = "/pages/reset_pw";
			ModelAndView modelAndView = new ModelAndView(url);
			modelAndView.addObject("flag", "error");
			return modelAndView;
		}
		else {
			identifyService.resetpw(accountid);
			String url = "/pages/index";
			ModelAndView modelAndView = new ModelAndView(url);
			return modelAndView;
		}
		
	}
	
}
