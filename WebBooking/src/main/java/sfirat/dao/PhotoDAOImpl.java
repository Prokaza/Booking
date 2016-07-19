package sfirat.dao;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import sfirat.entity.Bike;
import sfirat.entity.Photo;

import java.util.List;

@Repository
public class PhotoDAOImpl implements PhotoDAO{

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public void savePhoto(Photo photo) {
        sessionFactory.getCurrentSession().save(photo);
    }

    @Override
    public void updatePhoto(Photo photo) {

    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Photo> photoList() {
        return sessionFactory.getCurrentSession().createQuery("from Photo").list();
    }

    @Override
    public void deletePhoto(Integer id) {
        Photo photo = (Photo)sessionFactory.getCurrentSession().load(Photo.class, id);
        if (photo != null)
            sessionFactory.getCurrentSession().delete(photo);
    }

    @Override
    public Photo findPhotoByBikeId(Integer bikeId) {
        System.out.println("photoDAO findPhotoByBikeId: " + bikeId);
        Query query = sessionFactory.getCurrentSession().createQuery("from Photo as u where u.bikeId = :bikeId");
        query.setInteger("bikeId", bikeId);
        return (Photo)query.uniqueResult();
    }
}
