package Utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * @Author gaobaishun
 * @Date 2020-05-08 15:12
 * imformation：
 */
public class PropertiesHandler {
    private Properties properties=new Properties();

    public PropertiesHandler(String propertiesUrl) throws IOException {
        FileInputStream fileInputStream=new FileInputStream(propertiesUrl);
        properties.load(fileInputStream);
    }

    public String getValueByKey(String key){
        return properties.getProperty(key);
    }
}
