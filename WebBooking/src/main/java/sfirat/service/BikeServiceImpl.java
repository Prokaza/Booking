package sfirat.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sfirat.dao.BikeDAO;
import sfirat.entity.Bike;
import sfirat.entity.Clazz;
import sfirat.entity.enumeration.Type;

import java.util.List;

@Service
public class BikeServiceImpl implements BikeService{

    @Autowired
    BikeDAO bikeDAO;

    @Override
    @Transactional
    public void saveBike(Bike bike) {
        bikeDAO.saveBike(bike);
    }

    @Override
    @Transactional
    public void updateBike(Bike user) {

    }

    @Override
    @Transactional
    public List<Bike> bikeList() {
        return bikeDAO.bikeList();
    }

    @Override
    @Transactional
    public List<Bike> bikeListByType(Type type) {
        return bikeDAO.bikeListByType(type);
    }

    @Override
    @Transactional
    public List<Bike> bikeListByClazz(Clazz clazz) {
        return bikeDAO.bikeListByClazz(clazz);
    }

    @Override
    @Transactional
    public void deleteBike(Integer id) {
        bikeDAO.deleteBike(id);
    }

    @Override
    @Transactional
    public Bike findBikeById(Integer id) {
        return bikeDAO.findBikeById(id);
    }
}
