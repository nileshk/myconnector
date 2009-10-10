package com.myconnector.service;

import com.myconnector.dao.FriendDAO;
import com.myconnector.domain.Friend;
import com.myconnector.domain.FriendPK;
import com.myconnector.exception.MessageException;
import com.myconnector.util.CommonThreadLocal;

public class FriendServiceImpl implements FriendService, OldGenericDeleteService {

    private FriendDAO friendDAO;

    public void setFriendDAO(FriendDAO friendDAO) {
        this.friendDAO = friendDAO;
    }

    public void addFriend(String friendId) {
        String currentUserId = CommonThreadLocal.getUserId();
        FriendPK pk = new FriendPK(currentUserId, friendId);
        if(friendDAO.load(pk) != null) {
            throw new MessageException("friend.alreadyFriend");
        }
        Friend friend = new Friend(pk);
        friendDAO.save(friend);
    }

    public void removeFriend(String friendId) {
        String currentUserId = CommonThreadLocal.getUserId();
        FriendPK pk = new FriendPK(currentUserId, friendId);
        Friend friend = friendDAO.load(pk);
        if(friend == null) {
            throw new MessageException("friend.doesNotExist");
        }
        friendDAO.delete(friend);
    }

    public boolean isFriend(String friendId) {
        String currentUserId = CommonThreadLocal.getUserId();
        FriendPK pk = new FriendPK(currentUserId, friendId);
        return friendDAO.load(pk) != null;
    }

    public void deleteById(String id) {
        removeFriend(id);
    }

}
