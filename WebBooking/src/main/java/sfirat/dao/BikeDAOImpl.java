package sfirat.dao;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import sfirat.entity.Bike;
import sfirat.entity.Clazz;
import sfirat.entity.User;
import sfirat.entity.enumeration.Type;

import java.util.List;

@Repository
public class BikeDAOImpl implements BikeDAO{

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public void saveBike(Bike bike) {
        sessionFactory.getCurrentSession().save(bike);
    }

    @Override
    public void updateBike(Bike bike) {

    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Bike> bikeList() {
        return sessionFactory.getCurrentSession().createQuery("from Bike").list();
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Bike> bikeListByType(Type type) {
        return sessionFactory.getCurrentSession().createQuery(
                "from Bike as b where b.type = :type")
                .setParameter("type", type).list();
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Bike> bikeListByClazz(Clazz clazz) {
        return sessionFactory.getCurrentSession().createQuery(
                "from Bike as b where b.clazzId = :clazzId")
                .setParameter("clazzId", clazz).list();
    }

    @Override
    public void deleteBike(Integer id) {
        Bike bike = (Bike)sessionFactory.getCurrentSession().load(Bike.class, id);
        if (bike != null)
            sessionFactory.getCurrentSession().delete(bike);
    }

    @Override
    public Bike findBikeById(Integer id) {
        System.out.println("bikeDAO findBikeById: " + id);
        Query query = sessionFactory.getCurrentSession().createQuery("from Bike as u where u.id = :id");
        query.setInteger("id", id);
        return (Bike)query.uniqueResult();
    }
}
