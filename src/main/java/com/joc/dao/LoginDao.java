package com.joc.dao;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;

import com.joc.entity.User;


public interface LoginDao {
   public List<User> checkLogin (User us);
   public String saveUser(User us);
   public List<User> getAllUser();
   public void logOut(HttpServletRequest request, HttpServletResponse res) throws IOException;
 
}
