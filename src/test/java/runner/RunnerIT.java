package test.java.runner;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.service.ExtentService;
import io.cucumber.testng.CucumberOptions;
import org.apache.commons.io.FileUtils;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;

import java.io.File;
import java.net.InetAddress;
import java.net.UnknownHostException;


@CucumberOptions(glue = {"test.java.stepDefinitions"},
        plugin = {"json:target/cucumber-parallel/cucumber.json", "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
        features = {"src/test/java/feature/"}
)
/**
 * The Class RunnerIT.
 */
public class RunnerIT extends AbstractTestNGCucumberParallelTests{
    public static void setSystemInfo(String key, String value) {
        getExtentReports().setSystemInfo(key, value);
    }

    private static ExtentReports getExtentReports() {
        return ExtentService.getInstance();
    }

    private String getHostName(){
        String hostname = "Unknown";

        try
        {
            InetAddress addr;
            addr = InetAddress.getLocalHost();
            hostname = addr.getHostName();
        }
        catch (UnknownHostException ex)
        {
            System.out.println("Hostname can not be resolved");
        }
        return hostname;
    }


    @AfterClass
    public void writeExtent(){

        setSystemInfo("UserName",getHostName());
        setSystemInfo("Java Version",System.getProperty("java.version"));
    }

    @AfterSuite
    public void tearDown(){
        try {
            String localRepoPath = System.getProperty("tempLocalRepoPath");
            System.out.println(localRepoPath + "    >>> To Be Deleted");
            //FileUtils.deleteDirectory(new File(localRepoPath));
            System.out.println(localRepoPath + "    >>>  Automation Local Temp Repo Folder has been deleted");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
