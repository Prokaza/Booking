package sfirat.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sfirat.dao.BookingDAO;
import sfirat.entity.Booking;
import sfirat.entity.User;

import java.util.List;

@Service
public class BookingServiceImpl implements BookingService {

    @Autowired
    BookingDAO bookingDAO;

    @Override
    @Transactional
    public void createBooking(Booking booking) {
        bookingDAO.createBooking(booking);
    }

    @Override
    @Transactional
    public Booking getBookingById(Integer id) {
        return bookingDAO.getBookingById(id);
    }

    @Override
    @Transactional
    public List<Booking> bookingAndRentalList() {
        return bookingDAO.bookingAndRentalList();
    }

    @Override
    @Transactional
    public List<Booking> bookingList() {
        return bookingDAO.bookingList();
    }

    @Override
    @Transactional
    public List<Booking> rentalList() {
        return bookingDAO.rentalList();
    }

    @Override
    @Transactional
    public List<Booking> bookingListForUser(User user) {
        return bookingDAO.bookingListForUser(user);
    }

    @Override
    @Transactional
    public void deleteBooking(Integer id) {
        bookingDAO.deleteBooking(id);
    }

    @Override
    @Transactional
    public List<Booking> findBookingListByUserId(Integer id) {
        return bookingDAO.findBookingListByUserId(id);
    }
}
