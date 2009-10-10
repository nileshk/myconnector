package com.myconnector.service;

import java.util.Collection;
import java.util.List;

import com.myconnector.domain.Bookmark;
import com.myconnector.domain.PageCache;

public interface BookmarkService extends OldGenericService {

	public boolean saveBookmark(Bookmark bookmark);
	
	public void saveOrUpdateBookmark(Bookmark bookmark);	

	public void saveBookmarkList(List bookmarkList);

	public Bookmark loadBookmark(String id);        

	public List<Bookmark> getBookmarkListByUserId(String userId);
	
    public Collection getBookmarkListByUserLogin(String userLogin);
    
    public List<Bookmark> getBookmarkListByUserLoginIncludingPrivate(String userLogin);
    
    public PageCache getPageCache(Integer pageListId);
    
    public int getPageListCount();
    
    public int getPageCacheCount();
}