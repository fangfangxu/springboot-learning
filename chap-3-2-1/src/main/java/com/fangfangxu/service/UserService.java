package com.fangfangxu.service;

public interface UserService {
    public void create(String username, Integer age);

    public void deleteByName(String username);

    public Integer getAllUsers();

    public void deleteAllUsers();
}
