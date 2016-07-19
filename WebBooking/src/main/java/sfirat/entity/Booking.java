package sfirat.entity;

import sfirat.entity.enumeration.Status;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;

@Entity
@Table(name = "BOOKING", schema = "BOOKING_BIKE")
public class Booking {

    @Id
    @Column(name = "ID", nullable = false, insertable = true, updatable = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "DATE_BOOKING", nullable = false, insertable = true, updatable = true)
    private Date dateBooking;

    @Column(name = "TIME_BOOKING", nullable = false, insertable = true, updatable = true)
    private Time timeBooking;

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition="enum('BOOKING','RENTED')", name = "STATUS", nullable = false, insertable = true, updatable = true, length = 7)
    private Status status;

    @Column(name = "CREATE_TIME", insertable=false)
    private Timestamp createTime;


    @ManyToOne
    @JoinColumn(name = "BIKE_ID", referencedColumnName = "ID", nullable = false)
    private Bike bikeId;

    @ManyToOne
    @JoinColumn(name = "USERS_ID", referencedColumnName = "ID", nullable = false)
    private User userId;


    public Booking() {
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDateBooking() {
        return dateBooking;
    }

    public void setDateBooking(Date dateBooking) {
        this.dateBooking = dateBooking;
    }

    public Time getTimeBooking() {
        return timeBooking;
    }

    public void setTimeBooking(Time timeBooking) {
        this.timeBooking = timeBooking;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    public Bike getBikeId() {
        return bikeId;
    }

    public void setBikeId(Bike bikeId) {
        this.bikeId = bikeId;
    }

    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Booking booking = (Booking) o;

        if (id != booking.id) return false;
        if (status != null ? !status.equals(booking.status) : booking.status != null) return false;
        if (dateBooking != null ? !dateBooking.equals(booking.dateBooking) : booking.dateBooking != null) return false;
        if (timeBooking != null ? !timeBooking.equals(booking.timeBooking) : booking.timeBooking != null) return false;
        if (createTime != null ? !createTime.equals(booking.createTime) : booking.createTime != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (dateBooking != null ? dateBooking.hashCode() : 0);
        result = 31 * result + (timeBooking != null ? timeBooking.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        result = 31 * result + (createTime != null ? createTime.hashCode() : 0);
        return result;
    }
}
