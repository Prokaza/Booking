package sfirat.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import sfirat.entity.User;
import sfirat.entity.enumeration.Role;

import java.util.List;

@Repository
public class UserDAOImpl implements UserDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void saveUser(User user) {
        sessionFactory.getCurrentSession().saveOrUpdate(user);
    }

    @Override
    public void updateUser(User user) {
        System.out.println("имя in: " + user.getFirstname());
        Session session = sessionFactory.getCurrentSession();
        User userLoad = (User)session.get(User.class, user.getId());

        userLoad.setEmail(user.getEmail());
        userLoad.setPassword(user.getPassword());
        userLoad.setFirstname(user.getFirstname());
        userLoad.setLastname(user.getLastname());
        userLoad.setPhone(user.getPhone());
        userLoad.setBirthday(user.getBirthday());
        userLoad.setGender(user.getGender());
        userLoad.setRole(user.getRole());
        userLoad.setState(user.getState());
        userLoad.setAddressId(user.getAddressId());

        session.saveOrUpdate(userLoad);
        session.close();

//        sessionFactory.getCurrentSession().save(user);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<User> userList() {
        return sessionFactory.getCurrentSession().createQuery("from User").list();
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<User> userListByRole(Role role) {
        Query query = sessionFactory.getCurrentSession().createQuery("from Uwer where role =: role");
        query.setParameter("role", role);
        return query.list();
    }

    @Override
    public void deleteUser(Integer id) {
        User user = (User) sessionFactory.getCurrentSession().load(User.class, id);
        if (user != null)
            sessionFactory.getCurrentSession().delete(user);
    }

    @Override
    @SuppressWarnings("unchecked")
    public User findUserById(Integer id) {
        return (User) sessionFactory.getCurrentSession().load(User.class, id);
    }

    @Override
    public User findUserByEmail(String email) {
        System.out.println("userDAO findUserByEmail: " + email);
        Query query = sessionFactory.getCurrentSession().createQuery("from User as u where u.email = :email");
        query.setString("email", email);
        return (User)query.uniqueResult();
    }
}
