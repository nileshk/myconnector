package test.indexer;

import java.util.List;

import com.myconnector.dao.BaseDAOTests;
import com.myconnector.domain.PageIndex;
import com.myconnector.domain.PageList;
import com.myconnector.indexer.SearchService;

public class SearchServiceImplTests extends BaseDAOTests {

    SearchService service;
    
    @Override
    protected void onSetUpInTransaction() throws Exception {
        super.onSetUpInTransaction();
        service = (SearchService) applicationContext.getBean("searchService");
    }

    private void display(List<PageIndex> list) {
        for (PageIndex item : list) {
            System.out.println(item.getCompId().getPage().getId() + ":" 
                    + item.getCompId().getPage().getUrl() + ":"
                    + item.getCompId().getWord() + ":" + item.getOccurances());
        }
    }
    
    private void displayPage(List<PageList> list) {
    	for(PageList item : list) {
    		System.out.println(item.getId() + ":" + item.getUrl());
    	}
    }

    public void testSearch1() {
        List<PageIndex> list = service.search("linux");
        display(list);
    }    
    
    public void testSearch2() {
        List<PageIndex> list = service.search("slashdot linux");
        display(list);
    }

    public void testSearchByUser1() {
        List<PageIndex> list = service.searchByUser("linux", "8ae4818a07c3211a0107c360a7910001");
        display(list);
    }    
    
    public void testSearchByUser2() {
        List<PageIndex> list = service.searchByUser("slashdot linux", "4028828207b61cc00107b61d4c6e0001");
        display(list);
    }    

    public void testSearchByUsers1() {
        List<PageIndex> list = service.searchByUserAndFriends("linux", "ff80808107a6d74a0107a6d7db070001");
        display(list);
    }    
    
    public void testSearchByUsers2() {
        List<PageIndex> list = service.searchByUserAndFriends("slashdot linux", "ff80808107a6d74a0107a6d7db070001");
        display(list);
    }    
    
    
}
