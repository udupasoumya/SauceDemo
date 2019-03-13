package com.saucedemo.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadConfig {
    Properties prop;

    public ReadConfig() throws IOException {
        File src=new File("./Configurations/config.properties");

        try{
            FileInputStream fs=new FileInputStream(src);
            prop=new Properties();
            prop.load(fs);

        }
        catch(Exception e){
            System.out.println("Exception is " + e.getMessage());

        }
    }

    public String returnConfigdata(String value){
        String data= prop.getProperty(value);
        return data;
    }
}
