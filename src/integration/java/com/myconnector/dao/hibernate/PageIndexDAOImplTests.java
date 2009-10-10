package com.myconnector.dao.hibernate;

import java.util.ArrayList;
import java.util.List;

import com.myconnector.dao.BaseDAOTests;
import com.myconnector.dao.PageIndexDAO;
import com.myconnector.domain.PageIndex;

public class PageIndexDAOImplTests extends BaseDAOTests {

	PageIndexDAO dao;

	@Override
	protected void onSetUpInTransaction() throws Exception {
		super.onSetUpInTransaction();
		dao = (PageIndexDAO) applicationContext.getBean("pageIndexDAO");
	}

	private void display(List<PageIndex> list) {
		for (PageIndex item : list) {
			System.out.println(item.getCompId().getPage().getId() + ":"
					+ item.getCompId().getPage().getUrl() + ":"
					+ item.getCompId().getWord() + ":" + item.getOccurances());
		}
	}

	public void testSearch() {
		List<PageIndex> list = dao.search("slashdot");
		display(list);
	}

	public void testSearchByUser() {
		List<PageIndex> list = dao.searchByUser("java", "8ae4818a07c3211a0107c360a7910001");
		display(list);
	}	

	public void testSearchByUser2() {
		List<PageIndex> list = dao.searchByUser("java", "4028828207b61cc00107b61d4c6e0001");
		display(list);
	}
	
	public void testSearchOr() {
		String[] words = new String[2];
		words[0] = "slashdot";
		words[1] = "linux";
		List<PageIndex> list = dao.searchOr(words);
		display(list);
	}

	public void testSearchAnd() {
		String[] words = new String[2];
		words[0] = "slashdot";
		words[1] = "linux";
		List<PageIndex> list = dao.searchAnd(words);
		display(list);
	}

	public void testDeleteAll() {
		dao.deleteAll();
	}

    public void testSearchByUsers() {
        List<String> userIds = new ArrayList<String>();
        userIds.add("ff80808107a6d74a0107a6d7db070001");
        userIds.add("ff80808109be04b30109be2016680003");
        List<PageIndex> list = dao.searchByUsers("java", userIds);
        display(list);
    }   

    public void testSearchByUsers2() {
        List<String> userIds = new ArrayList<String>();
        userIds.add("ff80808107a6d74a0107a6d7db070001");
        userIds.add("ff80808109be04b30109be2016680003");
        userIds.add("ff8080810ac03d07010ac03e0faa0001");
        List<PageIndex> list = dao.searchByUsers("java", userIds);
        display(list);
    }    

    public void testSearchOrByUsers() {
        List<String> userIds = new ArrayList<String>();
        userIds.add("ff80808107a6d74a0107a6d7db070001");
        userIds.add("ff80808109be04b30109be2016680003");
        String[] words = new String[2];
        words[0] = "slashdot";
        words[1] = "linux";
        List<PageIndex> list = dao.searchOrByUsers(words, userIds);
        display(list);
    }   

    public void testSearchAndByUsers() {
        List<String> userIds = new ArrayList<String>();
        userIds.add("ff80808107a6d74a0107a6d7db070001");
        userIds.add("ff80808109be04b30109be2016680003");
        userIds.add("ff8080810ac03d07010ac03e0faa0001");
        String[] words = new String[2];
        words[0] = "slashdot";
        words[1] = "linux";
        List<PageIndex> list = dao.searchAndByUsers(words, userIds);
        display(list);
    }    
    
    
}
