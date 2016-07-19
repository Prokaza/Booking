package sfirat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import sfirat.component.ImageLouderHelper;
import sfirat.entity.Bike;
import sfirat.entity.Photo;
import sfirat.service.BikeService;
import sfirat.service.ClazzService;
import sfirat.service.PhotoService;

import java.io.*;

@Controller
public class BikesController{

    @Autowired
    BikeService bikeService;
    @Autowired
    ClazzService clazzService;
    @Autowired
    PhotoService photoService;

    @RequestMapping(value = "/product/add_bike", method = RequestMethod.GET)
    public String addBikePage(ModelMap model) {

        model.addAttribute("bike", new Bike());
        return "/product/add_bike";
    }

    @RequestMapping(value = "/product/add_bike", method = RequestMethod.POST)
    public String saveBike(Bike bike,
                           @RequestParam("name") String imageName,
                           @RequestParam(value = "file") MultipartFile image) throws IOException {

        ImageLouderHelper imageLouderHelper = new ImageLouderHelper(imageName, image);

        if (!image.isEmpty()) {
            imageLouderHelper.validateImage();
            imageLouderHelper.saveImage();
        }
        Photo photo = new Photo();
        photo.setPhotoName(imageName);
        photo.setBikeId(bike);
        bike.setClazzId(clazzService.getClazzByClazzName(bike.getClazzId().getClassName()));

        bikeService.saveBike(bike);
        photoService.savePhoto(photo);

        return "redirect:/product?alertAdd=true";
    }

    @RequestMapping(value = "/product/delete_bike/{bikeId}", method = RequestMethod.GET)
    public String deleteBike(@PathVariable("bikeId") Integer bikeId){
        bikeService.deleteBike(bikeId);
        return "redirect:/product?alertDelete=true";
    }

}
