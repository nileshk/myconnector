package test.indexer;

import org.springframework.test.AbstractDependencyInjectionSpringContextTests;

import util.TestData;

import com.myconnector.indexer.IndexService;

public class CopyTitlesToPageList extends AbstractDependencyInjectionSpringContextTests {

    @Override
    protected String[] getConfigLocations() {
        return TestData.getApplicationContextFileList();
    }

    private IndexService indexService;

    public void setIndexService(IndexService indexService) {
        this.indexService = indexService;
    }

    public void testDo() {
        indexService.copyTitlesToPageList();
    }

}
