package com.myconnector.web.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.myconnector.domain.UserData;
import com.myconnector.service.FriendService;
import com.myconnector.service.UserService;

/**
 * 
 * @author nil
 */
public class FriendAddController implements Controller {

    static Logger logger = Logger.getLogger(FriendAddController.class);

    private FriendService friendService;
    private UserService userService;
    String view = "users.jsp";

    public void setFriendService(FriendService friendService) {
        this.friendService = friendService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }    
    
    /*
     * (non-Javadoc)
     * 
     * @see org.springframework.web.servlet.mvc.Controller#handleRequest(javax.servlet.http.HttpServletRequest,
     *      javax.servlet.http.HttpServletResponse)
     */
    @SuppressWarnings("unchecked")
    public ModelAndView handleRequest(HttpServletRequest req, HttpServletResponse res)
            throws Exception {
        String id = req.getParameter("id");
        Map model = new HashMap();
        if (id != null && req.getParameter("submit.add") != null) {
            try {
                friendService.addFriend(id);
                UserData user = userService.getUserById(id);
                model.put("added", "Added " + user.getUserLogin() + " to friends list");
            } catch (RuntimeException ex) {  // TODO catch specific excepton
                model.put("failed", "true");
            }
        }
        List userList = userService.getList();
        model.put("userList", userList);
        return new ModelAndView(view, model);
    }

    /**
     * @param view
     *            The view to set.
     */
    public void setView(String view) {
        this.view = view;
    }
}
