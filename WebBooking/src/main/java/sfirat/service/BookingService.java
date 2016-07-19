package sfirat.service;

import sfirat.entity.Booking;
import sfirat.entity.User;

import java.util.List;

public interface BookingService {

    public void createBooking(Booking booking);

    public Booking getBookingById(Integer id);

    public List<Booking> bookingAndRentalList();

    public List<Booking> bookingList();

    public List<Booking> rentalList();

    public List<Booking> bookingListForUser(User user);

    public void deleteBooking(Integer id);

    public List<Booking> findBookingListByUserId(Integer id);
}
