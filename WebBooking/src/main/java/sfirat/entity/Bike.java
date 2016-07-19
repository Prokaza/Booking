package sfirat.entity;

import sfirat.entity.enumeration.Type;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "BIKE", schema = "BOOKING_BIKE")
public class Bike {

    @Id
    @Column(name = "ID", nullable = false, insertable = true, updatable = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "BIKE_NAME", nullable = false, insertable = true, updatable = true, length = 255)
    private String bikeName;

    @Column(name = "INFO", nullable = false, insertable = true, updatable = true)
    private String info;

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition="enum('MAN','WOMAN')", name = "TYPE", nullable = false, insertable = true, updatable = true, length = 7)
    private Type type;


    @ManyToOne
    @JoinColumn(name = "CLASS_ID", referencedColumnName = "ID", nullable = false)
    private Clazz clazzId;


    @OneToMany(mappedBy = "bikeId")
    private Set<Booking> bookingsById = new HashSet<Booking>();

    @OneToMany(mappedBy = "bikeId")
    private Set<Photo> fotosById = new HashSet<Photo>();


    public Bike() {
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBikeName() {
        return bikeName;
    }

    public void setBikeName(String bikeName) {
        this.bikeName = bikeName;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public Clazz getClazzId() {
        return clazzId;
    }

    public void setClazzId(Clazz clazzId) {
        this.clazzId = clazzId;
    }

    public Set<Booking> getBookingsById() {
        return bookingsById;
    }

    public void setBookingsById(Set<Booking> bookingsById) {
        this.bookingsById = bookingsById;
    }

    public Set<Photo> getFotosById() {
        return fotosById;
    }

    public void setFotosById(Set<Photo> fotosById) {
        this.fotosById = fotosById;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Bike bike = (Bike) o;

        if (id != bike.id) return false;
        if (bikeName != null ? !bikeName.equals(bike.bikeName) : bike.bikeName != null) return false;
        if (info != null ? !info.equals(bike.info) : bike.info != null) return false;
        if (type != null ? !type.equals(bike.type) : bike.type != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (bikeName != null ? bikeName.hashCode() : 0);
        result = 31 * result + (info != null ? info.hashCode() : 0);
        result = 31 * result + (type != null ? type.hashCode() : 0);
        return result;
    }
}
