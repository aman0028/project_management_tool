package org.basecamp.dao;

import java.util.List;

import org.basecamp.dto.EventNotificationRequestDTO;
import org.basecamp.entity.UserAccountEntity;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class BasecampDAO 
{
	private SessionFactory sessionFactory;
	
    public BasecampDAO() {}
	
    @Autowired
	public BasecampDAO(SessionFactory sessionFactory)
	{
		this.sessionFactory = sessionFactory;
	}
	
    @Transactional
	public void saveUserAccount(UserAccountEntity entity) 
	{
		Session session = sessionFactory.getCurrentSession();
		session.save(entity);
	}

	@Transactional(readOnly=true)
	public UserAccountEntity findUserAccountById(String identiferId) 
	{
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(UserAccountEntity.class);
		criteria.add(Restrictions.eq("identiferId", identiferId));
		@SuppressWarnings("unchecked")
		List<UserAccountEntity> list = criteria.list();
		if(list.isEmpty())
			return null;
		
		return list.get(0);
	}

	@Transactional
	public void updateUserAccount(UserAccountEntity entity) 
	{
		Session session = sessionFactory.getCurrentSession();
		session.update(entity);
	}

	
}
