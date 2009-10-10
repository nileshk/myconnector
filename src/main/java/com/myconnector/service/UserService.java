package com.myconnector.service;

import com.myconnector.domain.UserData;

/**
 * 
 * @author Nilesh Kapadia (nileshka@gmail.com)
 */
public interface UserService extends OldGenericService {

    public void deleteUser(UserData userData);            

    public UserData getUserByUserLogin(String userLogin);

    public UserData getUserById(String id);
    
    public UserData getUserByIdWithBookmarks(String id);

    public void saveUser(UserData userData);

    public void updateUser(UserData userData);
}