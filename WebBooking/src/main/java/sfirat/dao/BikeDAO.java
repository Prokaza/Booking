package sfirat.dao;

import sfirat.entity.Bike;
import sfirat.entity.Clazz;
import sfirat.entity.enumeration.Type;

import java.util.List;

public interface BikeDAO {

    public void saveBike(Bike bike);

    public void updateBike(Bike user);

    public List<Bike> bikeList();

    public List<Bike> bikeListByType(Type type);

    public List<Bike> bikeListByClazz(Clazz clazz);

    public void deleteBike(Integer id);

    public Bike findBikeById(Integer id);

}
