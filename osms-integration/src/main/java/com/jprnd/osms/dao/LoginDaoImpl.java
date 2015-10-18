package com.jprnd.osms.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jprnd.osms.entity.UserEntity;

@Repository
public class LoginDaoImpl implements LoginDao{
	
	 
	 private SessionFactory sessionFactory;
	 @Autowired
	 public LoginDaoImpl(SessionFactory sessionFactory) {
		this.sessionFactory=sessionFactory;
	}

	@Override
	public boolean dummy() {
		System.out.println("From DAO - calling dummy");
		return false;
	}

	@Override
	public UserEntity login(String userName, String password) {
		Session session = sessionFactory.openSession();
		Criteria criteria = session.createCriteria(UserEntity.class);
		criteria.add(Restrictions.eq("userName", userName));
		criteria.add(Restrictions.eq("password", password));
		List<UserEntity> userList = criteria.list();
		if(userList != null && !userList.isEmpty()){
			return userList.get(0);
		}
			
		return null;
	}

}
