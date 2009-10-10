package com.myconnector.service;

public interface FriendService {

    public void addFriend(String friendId);
    
    public void removeFriend(String friendId);
    
    public boolean isFriend(String friendId);
    
}
