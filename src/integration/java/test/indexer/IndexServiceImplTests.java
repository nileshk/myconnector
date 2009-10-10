package test.indexer;

import com.myconnector.dao.BaseDAOTests;
import com.myconnector.indexer.IndexService;

public class IndexServiceImplTests extends BaseDAOTests {

    IndexService service;
    
    @Override
    protected void onSetUpInTransaction() throws Exception {
        super.onSetUpInTransaction();
        service = (IndexService) applicationContext.getBean("indexService");
    }
    
    public void testGenerateIndex() {
        setComplete();
        service.generateIndexFromCache();
    }

}
