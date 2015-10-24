package com.jprnd.osms.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jprnd.osms.entity.UserEntity;

@Repository
public class LoginDaoImpl implements LoginDao {
	private static final Logger logger = LoggerFactory.getLogger(LoginDaoImpl.class);

	private SessionFactory sessionFactory;

	@Autowired
	public LoginDaoImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public UserEntity login(String userName, String password) {
		Session session = sessionFactory.openSession();
		try {
			Criteria criteria = session.createCriteria(UserEntity.class);
			criteria.add(Restrictions.eq("userName", userName));
			criteria.add(Restrictions.eq("password", password));
			List<UserEntity> userList = criteria.list();
			if (userList != null && !userList.isEmpty()) {
				return userList.get(0);
			}
		} catch (Exception e) {
			logger.error("Error while login, ", e);
		} finally {
			session.close();
		}
		return null;
	}

	@Override
	public UserEntity findUser(String userName) {
		Session session = sessionFactory.openSession();
		try {
			Criteria criteria = session.createCriteria(UserEntity.class);
			criteria.add(Restrictions.eq("userName", userName));
			List<UserEntity> userList = criteria.list();
			if (userList != null && !userList.isEmpty()) {
				return userList.get(0);
			}
		} catch (Exception e) {
			logger.error("Error while finding user, ", e);
		} finally {
			session.close();
		}
		return null;
	}
}
