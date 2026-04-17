package core.api.request.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class HandlerProperties {

    private static final String CONFIG = "./src/test/resources/config.properties";
    private static Properties prop;

    public static String getValue(String value){
        try {
            if (prop == null){
                HandlerProperties.prop = new Properties();
                HandlerProperties.prop.load(new FileInputStream(CONFIG));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } return HandlerProperties.prop.getProperty(value);
    }
}
