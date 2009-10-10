package com.myconnector.dao;

import java.util.List;

import com.myconnector.domain.FriendPK;
import com.myconnector.domain.Friend;

/**
 * DAO for FRIEND table
 * 
 * @author Nilesh Kapadia (nileshka@gmail.com)
 */
public interface FriendDAO {

    public Friend load(FriendPK pk);

    public void update(Friend friend);

    public void save(Friend friend);

    public void saveOrUpdate(Friend friend);

    public void delete(Friend friend);

    public List getList();

    public List getListByUserId(String userId);
}