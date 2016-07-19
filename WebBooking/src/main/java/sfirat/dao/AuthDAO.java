package sfirat.dao;

import sfirat.entity.User;

public interface AuthDAO {
    public User findUserByLogin(String email);
}
