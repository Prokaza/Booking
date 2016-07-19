package sfirat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import sfirat.entity.Bike;
import sfirat.entity.Photo;
import sfirat.entity.enumeration.Type;
import sfirat.service.BikeService;
import sfirat.service.ClazzService;
import sfirat.service.PhotoService;

@Controller
public class AssortmentConroller {

    @Autowired
    BikeService bikeService;
    @Autowired
    PhotoService photoService;
    @Autowired
    ClazzService clazzService;

    @RequestMapping(value = "/product", method = RequestMethod.GET)
    public String bikeList(ModelMap model) {
        model.addAttribute("bikeList", bikeService.bikeList());
        model.addAttribute("photoList", photoService.photoList());
        return "product";
    }

    @RequestMapping(value = "/product/type/{type}", method = RequestMethod.GET)
    public String bikeListByType(ModelMap model, @PathVariable("type") String type) {
        if (type.equals("MAN"))
            model.addAttribute("bikeList", bikeService.bikeListByType(Type.MAN));
        else
            model.addAttribute("bikeList", bikeService.bikeListByType(Type.WOMAN));
        model.addAttribute("photoList", photoService.photoList());
        return "product";
    }

    @RequestMapping(value = "/product/clazz/{clazz}", method = RequestMethod.GET)
    public String bikeListByClazz(ModelMap model, @PathVariable("clazz") String clazz) {
        if (clazz.equals("SIMPLE"))
            model.addAttribute("bikeList", bikeService.bikeListByClazz(clazzService.getClazzByClazzName("SIMPLE")));
        else if (clazz.equals("MEDIUM"))
            model.addAttribute("bikeList", bikeService.bikeListByClazz(clazzService.getClazzByClazzName("MEDIUM")));
        else if (clazz.equals("PRO"))
            model.addAttribute("bikeList", bikeService.bikeListByClazz(clazzService.getClazzByClazzName("PRO")));


        model.addAttribute("photoList", photoService.photoList());
        return "product";
    }


    @RequestMapping(value = "/product/bike/{bikeId}", method = RequestMethod.GET)
    public String getBikeInfo(@PathVariable("bikeId") Integer bikeId, Model model){

        Bike bike = bikeService.findBikeById(bikeId);
        Photo photo = photoService.findPhotoByBikeId(bikeId);

        model.addAttribute("id", bike.getId());
        model.addAttribute("name", bike.getBikeName());
        model.addAttribute("info", bike.getInfo());
        model.addAttribute("type", bike.getType());
        model.addAttribute("clazz", bike.getClazzId().getClassName());
        model.addAttribute("priceHour", bike.getClazzId().getPriceHour());
        model.addAttribute("priceDay", bike.getClazzId().getPriceDay());
        model.addAttribute("photo", photo.getPhotoName());

        return "product/bike_info";
    }
}
