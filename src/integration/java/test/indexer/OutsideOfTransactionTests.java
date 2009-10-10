package test.indexer;

import java.util.List;

import org.springframework.test.AbstractDependencyInjectionSpringContextTests;

import com.myconnector.indexer.ErrorResult;
import com.myconnector.indexer.IndexResults;
import com.myconnector.indexer.OutsideOfTransactionService;

import util.TestData;

public class OutsideOfTransactionTests extends AbstractDependencyInjectionSpringContextTests {

    @Override
    protected String[] getConfigLocations() {
        return TestData.getApplicationContextFileList();
    }
    
    private OutsideOfTransactionService outsideOfTransactionService;

    public void setOutsideOfTransactionService(OutsideOfTransactionService outsideOfTransactionService) {
        this.outsideOfTransactionService = outsideOfTransactionService;
    }
    
    public void testDoFetchCache() {
        IndexResults indexResults = outsideOfTransactionService.fetchUncachedPages();
        List<ErrorResult> list = indexResults.getErrors();
        System.out.println("Error count: " + list.size());
        System.out.println("Error pages: ");
        for (ErrorResult result : list) {
            System.out.println(result.getUrl() + ":" + result.getErrorMessage());
        }
    }
    
}
