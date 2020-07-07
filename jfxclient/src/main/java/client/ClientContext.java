package client;

import Utils.PropertiesHandler;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;

/**
 * @Author gaobaishun
 * @Date 2020-05-08 15:31
 * imformation：
 */
public class ClientContext {
    private static HashMap<String, PropertiesHandler> contextMap=new HashMap<>();
    private static Logger logger= LogManager.getLogger(ClientContext.class);
    public static void setPropertiesHandler(String key,PropertiesHandler propertiesHandler){
        if (!contextMap.containsKey(key)) {
            contextMap.put(key,propertiesHandler);
            return;
        }
        logger.info("ClientContext中已经包含"+key+"此次添加无效");
    }

    public static String getValueFromProperitiesByKey(String propertiesKey,String propertiesValueKey){
        PropertiesHandler propertiesHandler=contextMap.get(propertiesKey);
        return propertiesHandler==null? null:propertiesHandler.getValueByKey(propertiesValueKey);
    }
}
