package test.java.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadConfig {
    Properties pro;

    public ReadConfig() throws IOException {
        File src = new File(System.getProperty("user.dir")+"/configuration/config.properties");
        try{
            FileInputStream fis = new FileInputStream(src);
            pro = new Properties();
            pro.load(fis);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public String readURL(){
        String url = pro.getProperty("baseURL");
        return url;
    }
    public String readDroppedText(){
        String droppedText = pro.getProperty("droppedText");
        return droppedText;
    }
}
