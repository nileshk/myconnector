package com.myconnector.service;

import java.util.List;

import com.myconnector.dao.FriendDAO;
import com.myconnector.dao.UserDataDAO;
import com.myconnector.domain.UserData;

/**
 * 
 * @author Nilesh Kapadia (nileshka@gmail.com)
 */
public class UserServiceImpl implements UserService {

    UserDataDAO userDataDAO;

    FriendDAO friendDAO;

    public void setFriendDAO(FriendDAO friendDAO) {
        this.friendDAO = friendDAO;
    }

    public void setUserDataDAO(UserDataDAO userDataDAO) {
        this.userDataDAO = userDataDAO;
    }

    public void deleteUser(UserData userData) {
        userDataDAO.delete(userData);
    }

    public List getList() {
        return userDataDAO.getList();
    }

    public UserData getUserByUserLogin(String userLogin) {
        return userDataDAO.getUserByUserLogin(userLogin);
    }

    public UserData getUserById(String id) {
        UserData userData = userDataDAO.load(id);
        userData.getFriendsById().size();
        userData.getFriendsByFriendId().size();
        return userData;
    }
    
    public UserData getUserByIdWithBookmarks(String id) {
        UserData userData = getUserById(id);
        userData.getBookmarksByUserId().size();
        return userData;
    }

    public void saveUser(UserData userData) {
        userDataDAO.save(userData);
    }

    public void updateUser(UserData userData) {
        userDataDAO.update(userData);
    }

    public void deleteById(String id) {
        userDataDAO.deleteById(id);
    }
}