package sfirat.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import sfirat.entity.Booking;
import sfirat.entity.User;
import sfirat.entity.enumeration.Status;

import java.util.List;

@Repository
public class BookingDAOImpl implements BookingDAO{

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public void createBooking(Booking booking) {
        sessionFactory.getCurrentSession().save(booking);
    }

    @Override
    public Booking getBookingById(Integer id) {
        return (Booking)sessionFactory.getCurrentSession().load(Booking.class, id);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Booking> bookingAndRentalList() {
        return sessionFactory.getCurrentSession().createQuery("from Booking").list();
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Booking> bookingList() {
        return sessionFactory.getCurrentSession().createQuery
                ("from Booking as b where b.status = :status")
                .setParameter("status", Status.BOOKING).list();
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Booking> rentalList() {
        return sessionFactory.getCurrentSession().createQuery(
                "from Booking as b where b.status = :status")
                .setParameter("status", Status.RENTED).list();
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Booking> bookingListForUser(User user) {
        return sessionFactory.getCurrentSession().createQuery(
                "from Booking as b where b.userId = :userId" )
                .setParameter("userId", user).list();
    }

    @Override
    public void deleteBooking(Integer id) {
        Booking booking = (Booking)sessionFactory.getCurrentSession().load(Booking.class, id);
        if (booking != null)
            sessionFactory.getCurrentSession().delete(booking);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Booking> findBookingListByUserId(Integer id) {
        User user = (User)sessionFactory.getCurrentSession().load(User.class, id);
        return sessionFactory.getCurrentSession().createQuery
                ("from Booking as b where b.userId = :userId")
                .setParameter("userId", user).list();
    }
}
