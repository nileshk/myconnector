package com.myconnector.indexer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.log4j.Logger;

import com.myconnector.dao.PageIndexDAO;
import com.myconnector.dao.UserDataDAO;
import com.myconnector.domain.Friend;
import com.myconnector.domain.PageIndex;
import com.myconnector.domain.UserData;

public class SearchServiceImpl implements SearchService {

    Logger logger = Logger.getLogger(SearchServiceImpl.class);

    private PageIndexDAO pageIndexDAO;

    private UserDataDAO userDataDAO;

    public void setPageIndexDAO(PageIndexDAO pageIndexDAO) {
        this.pageIndexDAO = pageIndexDAO;
    }

    public void setUserDataDAO(UserDataDAO userDataDAO) {
        this.userDataDAO = userDataDAO;
    }

    private String preProcessSearchTerms(String query) {
        // TODO filter out dashes and include this in the search methods
        return query.replace("-", "");
    }

    public List<PageIndex> search(String query) {
        String[] words = getWordsFromQuery(query);
        if (words.length > 1) {
            if (query.endsWith("OR")) {
                logger.debug("Doing OR search");
                return removeDuplicates(pageIndexDAO.searchOr(words));
            } else {
                logger.debug("Doing AND search");
                return pageIndexDAO.searchAnd(words);
            }
        } else {
            logger.debug("Doing single-word search");
            return pageIndexDAO.search(words[0]);
        }
    }

    public List<PageIndex> searchByUser(String query, String uid) {
        String[] words = getWordsFromQuery(query);
        if (words.length > 1) {
            if (query.endsWith("OR")) {
                logger.debug("Doing OR search");
                return removeDuplicates(pageIndexDAO.searchOrByUser(words, uid));
            } else {
                logger.debug("Doing AND search");
                return pageIndexDAO.searchAndByUser(words, uid);
            }
        } else {
            logger.debug("Doing single-word search");
            return pageIndexDAO.searchByUser(words[0], uid);
        }
    }

    public List<PageIndex> searchByUserAndFriends(String query, String uid) {
        // TODO get user's friends
        List<String> uidList = new ArrayList<String>();
        uidList.add(uid);
        UserData user = userDataDAO.load(uid);
        Set<Friend> friends = user.getFriendsById();
        for (Friend friend : friends) {
            uidList.add(friend.getComp_id().getFriendId());
        }
        String[] words = getWordsFromQuery(query);
        if (words.length > 1) {
            if (query.endsWith("OR")) {
                logger.debug("Doing OR search");
                return removeDuplicates(pageIndexDAO.searchOrByUsers(words, uidList));
            } else {
                logger.debug("Doing AND search");
                return pageIndexDAO.searchAndByUsers(words, uidList);
            }
        } else {
            logger.debug("Doing single-word search");
            return pageIndexDAO.searchByUsers(words[0], uidList);
        }
    }

    private String[] getWordsFromQuery(String query) {
        // TODO: filter out invalid characters?
        String[] words = query.split(" ");
        if (words.length > 1) {
            Map<String, Boolean> map = new HashMap<String, Boolean>();
            for (int i = 0; i < words.length; i++) {
                map.put(words[i].toLowerCase(), Boolean.TRUE);
            }
            if (map.containsKey("or")) {
                map.remove("or");
            }
            words = new String[map.size()];
            int i = 0;
            for (String word : map.keySet()) {
                words[i] = word;
                i++;

            }
        }
        if (logger.isDebugEnabled()) {
            StringBuilder sb = new StringBuilder();
            sb.append("Search terms: ");
            sb.append(words[0]);
            for (int i = 1; i < words.length; i++) {
                sb.append(", ");
                sb.append(words[i]);
            }
            logger.debug(sb);
        }
        return words;
    }

    private List<PageIndex> removeDuplicates(List<PageIndex> list) {
        // XXX Temporary hack to remove duplicates. Need to come up with better
        // way of returning search results.
        Map<String, Boolean> map = new HashMap<String, Boolean>();
        Iterator<PageIndex> it = list.iterator();
        while (it.hasNext()) {
            PageIndex pageIndex = it.next();
            String url = pageIndex.getCompId().getPage().getUrl();
            if (map.containsKey(url)) {
                it.remove();
            } else {
                map.put(url, Boolean.TRUE);
            }
        }
        return list;
    }

}
