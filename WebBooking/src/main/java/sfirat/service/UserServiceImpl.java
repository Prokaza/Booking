package sfirat.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sfirat.dao.UserDAO;
import sfirat.entity.User;
import sfirat.entity.enumeration.Role;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserDAO userDAO;

    @Override
    @Transactional
    public void saveUser(User user) {
        userDAO.saveUser(user);
    }

    @Override
    @Transactional
    public void updateUser(User user) {
        userDAO.updateUser(user);
    }

    @Override
    @Transactional
    public List<User> userList() {
        return userDAO.userList();
    }

    @Override
    @Transactional
    public List<User> userListByRole(Role role) {
        return userListByRole(role);
    }

    @Override
    @Transactional
    public void deleteUser(Integer id) {
        userDAO.deleteUser(id);
    }

    @Override
    @Transactional
    public User findUserById(Integer id) {
        return userDAO.findUserById(id);
    }

    @Override
    @Transactional
    public User findUserByEmail(String email) {
        return userDAO.findUserByEmail(email);
    }
}
