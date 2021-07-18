package test.java.stepDefinitions;

import io.cucumber.core.api.Scenario;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import main.java.coreComponents.Cucumber.TestContext;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;


/**
 * The Class Hook
 */
public class Hooks {

    private static final Logger log = Logger.getLogger(Hooks.class);


    TestContext testContext;
    public static String scenarioName = null;
    public Hooks(TestContext context){
        testContext = context;
    }


    @Before
    public void initializeRepo(Scenario scenario) throws Exception {
        scenarioName = scenario.getName();
        System.setProperty("scenario",scenarioName);
        DOMConfigurator.configure(System.getProperty("user.dir") +"/src/test/resources/log4j.xml");
    }

    @After
    public void tearDown(Scenario scenario){

        log.debug("TestCase execution completed !!!" + "/n" + "/n");
    }

}