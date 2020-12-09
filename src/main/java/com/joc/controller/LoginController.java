package com.joc.controller;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.joc.entity.User;
import com.joc.service.LoginService;

@Controller
public class LoginController {
	
	@Autowired
	LoginService loginService;
	
  public LoginService getLoginService() {
		return loginService;
	}

	public void setLoginService(LoginService loginService) {
		this.loginService = loginService;
	}

   @RequestMapping(value="/log")
      public ModelAndView login(@ModelAttribute ("user") User user, HttpServletRequest req) {
	  ModelAndView m=null;
	  List<User> u=loginService.checkLogin(user);	 
	    if(u.size()>0) {
	    	Iterator itr=u.iterator();
	    	while(itr.hasNext()) {
	    		User us=(User) itr.next();
	    		if(us.getUserName().equals(user.getUserName()) 
	    				&& us.getPassWord().equals(user.getPassWord())) {
	    			HttpSession session=req.getSession();
	    			session.setAttribute("username", us.getUserName());
	    			m = new ModelAndView("next");
	    			
	    		}
	    	}
	    }		
	    else {
			m = new ModelAndView("Login");
		    String s="INVALID INPUT OR BAD CREDENTIAL PLEASE REGISTER ";
		    m.addObject("ress",s);
	    }
	    return m;
  } 

    @RequestMapping(value="/register")
    public ModelAndView getRegister() {
	ModelAndView m=new ModelAndView("Registration");
	return m;
	}
 
   @RequestMapping(value="/reg" , method=RequestMethod.POST)
    public ModelAndView register(@ModelAttribute("User") User user) {
	ModelAndView m=new ModelAndView("Registration");
	loginService.saveUser(user);
	List<User>i=loginService.getAllUser();
	m.addObject("res",i);
	return m;
	}
	
	@RequestMapping(value="/logout")
	public ModelAndView logOut(HttpServletRequest request, HttpServletResponse res) throws IOException {
		loginService.logOut(request, res);
		ModelAndView m=new ModelAndView("Login");
	    return m;
	}
	
	@RequestMapping(value="/video")
	public ModelAndView video
	(HttpServletRequest req, HttpServletResponse res ) throws IOException {
		ModelAndView m=new ModelAndView();
		HttpSession session= req.getSession();
		 if(session.getAttribute("username")==null) {
			m.setViewName("Login");
		} 
		 else m.setViewName("Video");
		return m;
	}
}
   
	


