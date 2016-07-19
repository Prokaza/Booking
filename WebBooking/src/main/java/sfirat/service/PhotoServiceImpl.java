package sfirat.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sfirat.dao.PhotoDAO;
import sfirat.entity.Photo;

import java.util.List;

@Service
public class PhotoServiceImpl implements PhotoService{

    @Autowired
    PhotoDAO photoDAO;

    @Override
    @Transactional
    public void savePhoto(Photo photo) {
        photoDAO.savePhoto(photo);
    }

    @Override
    @Transactional
    public void updatePhoto(Photo photo) {

    }

    @Override
    @Transactional
    public List<Photo> photoList() {
        return photoDAO.photoList();
    }

    @Override
    @Transactional
    public void deletePhoto(Integer id) {
        photoDAO.deletePhoto(id);
    }

    @Override
    @Transactional
    public Photo findPhotoByBikeId(Integer bikeId) {
        return photoDAO.findPhotoByBikeId(bikeId);
    }
}
