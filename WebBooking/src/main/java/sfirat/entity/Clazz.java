package sfirat.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "CLASS", schema = "BOOKING_BIKE")
public class Clazz {

    @Id
    @Column(name = "ID", nullable = false, insertable = true, updatable = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Basic
    @Column(name = "CLASS_NAME", nullable = false, insertable = true, updatable = true, length = 10)
    private String className;

    @Basic
    @Column(name = "PRICE_DAY", nullable = false, insertable = true, updatable = true, precision = 0)
    private int priceDay;

    @Basic
    @Column(name = "PRICE_HOUR", nullable = false, insertable = true, updatable = true, precision = 0)
    private int priceHour;


    @OneToMany(mappedBy = "clazzId")
    private Set<Bike> bikesById = new HashSet<Bike>();


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public int getPriceDay() {
        return priceDay;
    }

    public void setPriceDay(int priceDay) {
        this.priceDay = priceDay;
    }

    public int getPriceHour() {
        return priceHour;
    }

    public void setPriceHour(int priceHour) {
        this.priceHour = priceHour;
    }

    public Set<Bike> getBikesById() {
        return bikesById;
    }

    public void setBikesById(Set<Bike> bikesById) {
        this.bikesById = bikesById;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Clazz clazz = (Clazz) o;

        if (id != clazz.id) return false;
        if (priceDay != clazz.priceDay) return false;
        if (priceHour != clazz.priceHour) return false;
        if (className != null ? !className.equals(clazz.className) : clazz.className != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (className != null ? className.hashCode() : 0);
        result = 31 * result + priceDay;
        result = 31 * result + priceHour;
        return result;
    }
}
