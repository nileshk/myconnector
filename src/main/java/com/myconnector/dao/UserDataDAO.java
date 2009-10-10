package com.myconnector.dao;

import java.util.List;

import com.myconnector.domain.UserData;

/**
 * DAO for USER_DATA table
 * 
 * @author Nilesh Kapadia (nileshka@gmail.com)
 */
public interface UserDataDAO {

    public UserData load(String id);

    public UserData getUserByUserLogin(String userLogin);
    
    public void update(UserData userData);

    public void save(UserData userData);

    public void delete(UserData userData);
    
    public void deleteById(String id);

    public List getList();
}