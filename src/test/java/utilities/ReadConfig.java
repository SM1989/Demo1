package test.java.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadConfig {
    Properties pro;

    public ReadConfig() throws IOException {
        File src = new File(System.getProperty("user.dir")+"/src/test/java/data/config.properties");
        try{
            FileInputStream fis = new FileInputStream(src);
            pro = new Properties();
            pro.load(fis);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public String readData(String data){
        String val = pro.getProperty(data);
        return val;
    }
}
