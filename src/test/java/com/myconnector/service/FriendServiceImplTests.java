package com.myconnector.service;

import org.easymock.MockControl;
import org.springframework.mock.web.MockHttpSession;

import com.myconnector.dao.FriendDAO;
import com.myconnector.domain.Friend;
import com.myconnector.domain.FriendPK;
import com.myconnector.exception.MessageException;
import com.myconnector.util.HttpSessionThreadLocal;

import junit.framework.TestCase;

public class FriendServiceImplTests extends TestCase {

    String id = "ADMINID";
    String username = "admin";

    MockControl friendDAOMC;
    FriendDAO friendDAO;
    FriendServiceImpl serviceImpl;

    @Override
    protected void setUp() throws Exception {
        friendDAOMC = MockControl.createControl(FriendDAO.class);
        friendDAO = (FriendDAO) friendDAOMC.getMock();

        serviceImpl = new FriendServiceImpl();
        serviceImpl.setFriendDAO(friendDAO);

        MockHttpSession httpSession = new MockHttpSession();
        httpSession.setAttribute("userId", id);
        httpSession.setAttribute("username", username);
        HttpSessionThreadLocal.set(httpSession);
    }

    private void replay() {
        friendDAOMC.replay();
    }

    private void verify() {
        friendDAOMC.verify();
    }

    private FriendService getService() {
        return serviceImpl;
    }
    
    
    public void testAddFriend() {
        // TODO should it just try the insert only instead of the select first?
        
        String friendId = "FRIENDID";
        FriendPK pk = new FriendPK(id, friendId); 
        friendDAO.load(pk);
        friendDAOMC.setMatcher(MockControl.ALWAYS_MATCHER);
        friendDAOMC.setReturnValue(null);
        friendDAO.save(new Friend(pk));
        friendDAOMC.setMatcher(MockControl.ALWAYS_MATCHER);
        replay();
        getService().addFriend(friendId);
        verify();       
    }

    public void testAddFriend_alreadyExists() {
        String friendId = "FRIENDID";
        FriendPK pk = new FriendPK(id, friendId); 
        friendDAO.load(pk);
        friendDAOMC.setMatcher(MockControl.ALWAYS_MATCHER);
        friendDAOMC.setReturnValue(new Friend(pk));
        replay();
        try {
            getService().addFriend(friendId);
            fail(); // should not reach here
        } catch(MessageException ex) {
            assertEquals("friend.alreadyFriend", ex.getCode());            
        }
        verify();        
    }
    
    
    public void testRemoveFriend() {
        String friendId = "FRIENDID";
        FriendPK pk = new FriendPK(id, friendId);
        Friend friend = new Friend(pk);
        friendDAO.load(pk);
        friendDAOMC.setMatcher(MockControl.ALWAYS_MATCHER);
        friendDAOMC.setReturnValue(friend);
        friendDAO.delete(friend);
        replay();
        getService().removeFriend(friendId);
        verify();
    }

    public void testRemoveFriendDoesNotExist() {
        String friendId = "FRIENDID";
        FriendPK pk = new FriendPK(id, friendId);
        friendDAO.load(pk);
        friendDAOMC.setMatcher(MockControl.ALWAYS_MATCHER);
        friendDAOMC.setReturnValue(null);        
        replay();
        try {
            getService().removeFriend(friendId);
            fail(); // should not reach here
        } catch(MessageException ex) {
            assertEquals("friend.doesNotExist", ex.getCode());
        }
        verify();
    }    
    
    public void testIsFriend() {
        String friendId = "FRIENDID";
        FriendPK pk = new FriendPK(id, friendId);
        Friend friend = new Friend(pk);
        friendDAO.load(pk);
        friendDAOMC.setMatcher(MockControl.ALWAYS_MATCHER);
        friendDAOMC.setReturnValue(friend);
        replay();
        boolean isFriend = getService().isFriend(friendId);
        verify();
        assertTrue(isFriend);
    }

    public void testIsNotFriend() {
        String friendId = "FRIENDID";
        FriendPK pk = new FriendPK(id, friendId);
        Friend friend = new Friend(pk);
        friendDAO.load(pk);
        friendDAOMC.setMatcher(MockControl.ALWAYS_MATCHER);
        friendDAOMC.setReturnValue(null);
        replay();
        boolean isFriend = getService().isFriend(friendId);
        verify();
        assertFalse(isFriend);
    }    
    
}
