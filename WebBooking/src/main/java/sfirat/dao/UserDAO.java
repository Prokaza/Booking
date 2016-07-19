package sfirat.dao;

import sfirat.entity.User;
import sfirat.entity.enumeration.Role;

import java.util.List;

public interface UserDAO {

    public void saveUser(User user);

    public void updateUser(User user);

    public List<User> userList();

    public List<User> userListByRole(Role role);

    public void deleteUser(Integer id);

    public User findUserById(Integer id);

    public User findUserByEmail(String email);
}
