package com.joc.dao;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.joc.entity.User;


@Repository
public class LoginDaoImpl implements LoginDao {

	@Autowired
	SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	  public List<User> checkLogin(User us) { 
		  Session session = sessionFactory.openSession(); 
		  String query =" from User a where a.userName='"+us.getUserName()+
				         "' and a.passWord='"+us.getPassWord()+"'"; 
		  List<User> e=session.createQuery(query).list(); 
		  
		  return e; }
	 

		

	public String saveUser(User us) {
		Session s = sessionFactory.openSession();
		Transaction t = s.beginTransaction();
		s.save(us);
		t.commit();
		String ss = "Exicuted";
		return ss;
	}

	public List<User> getAllUser() {
		Session s = sessionFactory.openSession();
		List<User> e = s.createCriteria(User.class).list();
		return e;
	}

	public void logOut(HttpServletRequest request, HttpServletResponse res) throws IOException{
			HttpSession session= request.getSession();
			session.removeAttribute("username");
			session.invalidate();
	}

	
	
}
