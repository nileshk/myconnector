package com.myconnector.dao;

import org.springframework.dao.DataAccessException;

import com.myconnector.domain.Bookmark;

import java.util.List;

public interface BookmarkDAO {

  public Bookmark loadBookmark(String id) throws DataAccessException;

  public void updateBookmark(Bookmark bookmark) throws DataAccessException;

  public void saveBookmark(Bookmark bookmark) throws DataAccessException;
  
  public void saveOrUpdateBookmark(Bookmark bookmark) throws DataAccessException;  

  public void deleteBookmark(Bookmark bookmark) throws DataAccessException;

  public List<Bookmark> getBookmarkList() throws DataAccessException;
  
  public List<Bookmark> getBookmarkListByUser(String userId) throws DataAccessException;

  public List<Bookmark> getBookmarkListByUserIncludingPrivate(String userId) throws DataAccessException;  
  
  public List<String> getUrlList();
  
  /**
   * Method to determine if user has bookmarked a particular URL
   * @param url
   * @param userId
   * @return
   */
  public boolean userHasBookmark(String url, String userId);
  
  public List<Bookmark> getBookmarkListForURL(String url);

}
