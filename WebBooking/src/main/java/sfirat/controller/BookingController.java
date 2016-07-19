package sfirat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import sfirat.entity.Bike;
import sfirat.entity.Booking;
import sfirat.entity.User;
import sfirat.entity.enumeration.Status;
import sfirat.service.BikeService;
import sfirat.service.BookingService;
import sfirat.service.UserService;

import java.security.Principal;
import java.sql.Date;
import java.sql.Time;
import java.util.Calendar;
import java.util.GregorianCalendar;

@Controller
public class BookingController {

    @Autowired
    BookingService bookingService;
    @Autowired
    BikeService bikeService;
    @Autowired
    UserService userService;

    @RequestMapping(value = "/booking/list", method = RequestMethod.GET)
    public String bookingPage(ModelMap modelMap) {
        modelMap.addAttribute("bookingList", bookingService.bookingList());
        modelMap.addAttribute("message", "Booking list");
        return "booking/list_booking";
    }

    @RequestMapping(value = "/booking/list_for_user", method = RequestMethod.GET)
    public String bookingListForUser(ModelMap modelMap, Principal principal) {
        modelMap.addAttribute("bookingList", bookingService.bookingListForUser(userService.findUserByEmail(principal.getName())));
        modelMap.addAttribute("message", "Booking list");
        return "booking/list_booking";
    }


    @RequestMapping(value = "/rental/list", method = RequestMethod.GET)
    public String rentalPage(ModelMap modelMap) {
        modelMap.addAttribute("rentalList", bookingService.rentalList());
        modelMap.addAttribute("message", "Rental list");
        return "booking/list_rental";
    }

    @RequestMapping(value = "/booking/cancel/{bookingId}", method = RequestMethod.GET)
    public String cancelBooking(@PathVariable("bookingId") Integer bookingId) {
        bookingService.deleteBooking(bookingId);
        return "redirect:/booking/list_for_user";
    }

    @RequestMapping(value = "/rental/cancel/{bookingId}", method = RequestMethod.GET)
    public String cancelRental(@PathVariable("bookingId") Integer bookingId) {
        bookingService.deleteBooking(bookingId);
        return "redirect:/rental/list";
    }

    @RequestMapping(value = "/booking/{id}", method = RequestMethod.GET)
    public String getPageBooking(@PathVariable("id") Integer id, Model model){
        model.addAttribute("booking", new Booking());
        return "booking/add_booking";
    }

    @RequestMapping(value = "/booking/{id}", method = RequestMethod.POST)
    public String saveBooking(@ModelAttribute("booking") Booking booking, @PathVariable("id") Integer id, Principal principal){
        Bike bike = bikeService.findBikeById(id);
        User user = userService.findUserByEmail(principal.getName());

        booking.setBikeId(bike);
        booking.setUserId(user);
        booking.setStatus(Status.BOOKING);

        System.out.println("bike name" + booking.getBikeId().getBikeName());
        System.out.println("user name" + booking.getUserId().getEmail());
        System.out.println(id);

        bookingService.createBooking(booking);
        System.out.println(id);
        return "redirect:/booking/list_for_user";
    }

    @RequestMapping(value = "/rental/{id}", method = RequestMethod.GET)
    public String seveRental(@ModelAttribute("booking") Booking booking, @PathVariable("id") Integer id , Principal principal){
        Bike bike = bikeService.findBikeById(id);
        User user = userService.findUserByEmail(principal.getName());

        Calendar calendar = new GregorianCalendar();
        booking.setTimeBooking(Time.valueOf("12:00:00"));
        booking.setDateBooking(Date.valueOf((calendar.get(Calendar.YEAR) + "-"
                + calendar.get(Calendar.MONTH) + "-"
                + calendar.get(Calendar.DAY_OF_MONTH))));
        booking.setBikeId(bike);
        booking.setUserId(user);
        booking.setStatus(Status.RENTED);

        System.out.println("bike name" + booking.getBikeId().getBikeName());
        System.out.println("user name" + booking.getUserId().getEmail());
        System.out.println(id);

        bookingService.createBooking(booking);
        System.out.println(id);
        return "redirect:/rental/list";
    }

    @RequestMapping(value = "/booking/edit/{bookingId}", method = RequestMethod.GET)
    public ModelAndView editBookingUser(@PathVariable("bookingId") Integer bookingId) {

        ModelAndView model = new ModelAndView("booking/edit");
        System.out.println(bookingId);
        Booking booking = bookingService.getBookingById(bookingId);

        System.out.println(booking.getDateBooking());

        model.addObject("booking", booking);

        return model;
    }

    @RequestMapping(value = "/booking/edit/{bookingId}", method = RequestMethod.POST)
    public String saveEditBookingUser(@PathVariable("bookingId") Integer bookingId, Model model){
        model.addAttribute("bookingEdit", bookingService.getBookingById(bookingId));
        return "booking/edit";
    }
}
