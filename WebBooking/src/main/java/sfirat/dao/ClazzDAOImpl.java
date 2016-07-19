package sfirat.dao;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import sfirat.entity.Clazz;

@Repository
public class ClazzDAOImpl implements ClazzDAO{

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public Clazz getClazzByClazzName(String clazzName) {
        Query query = sessionFactory.getCurrentSession().createQuery("from Clazz as c where c.className = :clazzName");
        query.setString("clazzName",clazzName);
        return (Clazz)query.uniqueResult();
    }
}
