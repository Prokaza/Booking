package sfirat.service;

import sfirat.entity.Photo;

import java.util.List;

public interface PhotoService {
    public void savePhoto(Photo photo);

    public void updatePhoto(Photo photo);

    public List<Photo> photoList();

    public void deletePhoto(Integer id);

    public Photo findPhotoByBikeId(Integer bikeId);

}
