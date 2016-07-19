package sfirat.entity;

import sfirat.entity.enumeration.Gender;
import sfirat.entity.enumeration.Role;
import sfirat.entity.enumeration.State;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "USER", schema = "BOOKING_BIKE")
public class User {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "EMAIL", length = 64)
    private String email;

    @Column(name = "PASSWORD", length = 32)
    private String password;

    @Column(name = "FIRSTNAME", length = 32)
    private String firstname;

    @Column(name = "LASTNAME", length = 32)
    private String lastname;

    @Column(name = "PHONE", length = 20)
    private String phone;

    @Column(name = "BIRTHDAY")
    private Date birthday;

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition="enum('MALE','FEMALE')", name = "GENDER", length = 6)
    private Gender gender;

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition="enum('USER','ADMIN','MANAGER')", name = "ROLE", length = 7)
    private Role role;

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition="enum('INACTIVE','ACTIVE','BANNED')", name = "STATE", length = 8)
    private State state;

    @Column(name = "CREATE_TIME", insertable=false)
    private Timestamp createTime;

    @Column(name = "UPDATE_TIME", insertable=false)
    private Timestamp updateTime;


    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "ADDRESS_ID")
    private Address addressId;


    @OneToMany(mappedBy = "userId")
    private Set<Booking> bookingsById = new HashSet<Booking>();


    public User() {
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    public Timestamp getUpdataTime() {
        return updateTime;
    }

    public void setUpdataTime(Timestamp updataTime) {
        this.updateTime = updataTime;
    }



    public Set<Booking> getBookingsById() {
        return bookingsById;
    }

    public void setBookingsById(Set<Booking> bookingsById) {
        this.bookingsById = bookingsById;
    }


    public Address getAddressId() {
        return addressId;
    }

    public void setAddressId(Address addressId) {
        this.addressId = addressId;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (id != user.id) return false;
        if (password != null ? !password.equals(user.password) : user.password != null) return false;
        if (firstname != null ? !firstname.equals(user.firstname) : user.firstname != null) return false;
        if (lastname != null ? !lastname.equals(user.lastname) : user.lastname != null) return false;
        if (email != null ? !email.equals(user.email) : user.email != null) return false;
        if (phone != null ? !phone.equals(user.phone) : user.phone != null) return false;
        if (birthday != null ? !birthday.equals(user.birthday) : user.birthday != null) return false;
        if (gender != null ? !gender.equals(user.gender) : user.gender != null) return false;
        if (role != null ? !role.equals(user.role) : user.role != null) return false;
        if (state != null ? !state.equals(user.state) : user.state != null) return false;
        if (createTime != null ? !createTime.equals(user.createTime) : user.createTime != null) return false;
        if (updateTime != null ? !updateTime.equals(user.updateTime) : user.updateTime != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (firstname != null ? firstname.hashCode() : 0);
        result = 31 * result + (lastname != null ? lastname.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (phone != null ? phone.hashCode() : 0);
        result = 31 * result + (birthday != null ? birthday.hashCode() : 0);
        result = 31 * result + (gender != null ? gender.hashCode() : 0);
        result = 31 * result + (role != null ? role.hashCode() : 0);
        result = 31 * result + (state != null ? state.hashCode() : 0);
        result = 31 * result + (createTime != null ? createTime.hashCode() : 0);
        result = 31 * result + (updateTime != null ? updateTime.hashCode() : 0);
        return result;
    }
}
