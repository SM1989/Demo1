package test.java.runner;

import cucumber.api.testng.AbstractTestNGCucumberTests;
import org.testng.annotations.DataProvider;

/**
 * The Class AbstractTestNGCucumberParallelTests.
 */
public class AbstractTestNGCucumberParallelTests extends AbstractTestNGCucumberTests {

    @Override
    @DataProvider(parallel = true)
    public Object[][] scenarios() {
        return super.scenarios();
    }
}
