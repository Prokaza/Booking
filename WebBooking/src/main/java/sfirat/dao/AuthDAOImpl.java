package sfirat.dao;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import sfirat.entity.User;

@Repository
public class AuthDAOImpl implements AuthDAO{

    @Autowired
    SessionFactory sessionFactory;

    @Override
    @SuppressWarnings("unchecked")
    public User findUserByLogin(String email) {
        System.out.println("authDAO findUserByEmail: " + email);
        Query query = sessionFactory.getCurrentSession().createQuery("from User as c where c.email = :email");
        query.setString("email", email);
        return (User)query.uniqueResult();
    }


}
