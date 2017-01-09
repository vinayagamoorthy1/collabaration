package com.niit.collabaration.DAOImpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.collabaration.DAO.UserDAO;
import com.niit.collabaration.model.User;
@Transactional
@Repository
public class UserDAOImpl implements UserDAO{
	@Autowired
	SessionFactory sessionFactory;
	public UserDAOImpl(SessionFactory sessionFactory){
		this.sessionFactory=sessionFactory;
	}

	public String save(User user) {
		try {
		if(get(user.getId())!=null){
				return "idexists";
			}
			sessionFactory.getCurrentSession().save(user);
		
			System.out.println("ok");
			return "success";
		} catch (HibernateException e) {

			e.printStackTrace();
			return "exception";
		}
			
	}
	
	public List<User> getlistofuser() {
String hql="from User";
Query query=sessionFactory.openSession().createQuery(hql);
return query.list();
	}

	public User get(String id) {
		return (User) sessionFactory.openSession().get(User.class,id);
	}

public String update(User user) {
try {
	if(get(user.getId())==null){
		return "id not exists";
	}
	sessionFactory.getCurrentSession().update(user);
	return "success";
} catch (HibernateException e) {
	e.printStackTrace();
	return "exception";
}

	}


public String validate(String id, String password) {
	
	String hql="from User where id='"+id+"' and password='"+password+"'";
	try {
		Query query = sessionFactory.openSession().createQuery(hql);
		User user=(User) query.uniqueResult();
		if(user==null){
			return "invalid";
		}else {
			String hql1="select status from User where id='"+id+"' and password='"+password+"'";
			try {
				Query query1=sessionFactory.openSession().createQuery(hql1);
				return query1.uniqueResult().toString();
			} catch (HibernateException e) {
				e.printStackTrace();
				return "validateexception";
			}
		}

	}catch (HibernateException e1) {
		e1.printStackTrace();
		return "connectexception";
	}
	
}

public String reasonforrejection(String id) {
String hql="select reason from User where id='"+id+"'";
Query query1;
try {
	query1 = sessionFactory.getCurrentSession().createQuery(hql);
} catch (HibernateException e) {
e.printStackTrace();
return "rejctionexception";
}
return query1.uniqueResult().toString();
}
	


}
