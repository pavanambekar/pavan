package com.joc.service;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.joc.dao.LoginDao;
import com.joc.entity.User;



@Service
public class LoginServiceImpl implements LoginService{
	
	@Autowired
	LoginDao loginDao;

	public LoginDao getLoginDao() {
		return loginDao;
	}

	public void setLoginDao(LoginDao loginDao) {
		this.loginDao = loginDao;
	}

	
	public String saveUser(User us) {
			return loginDao.saveUser(us);
	}

	public List<User> getAllUser() {
		return loginDao.getAllUser();
	}

	@Override
	public List<User> checkLogin(User us) {
		return loginDao.checkLogin(us);
	}

	@Override
	public void logOut(HttpServletRequest request, HttpServletResponse res) throws IOException {
		loginDao.logOut(request, res);
		
	}

}
