import Entity.MenuDO;
import Utils.HttpUtils;
import client.ClientContext;
import com.alibaba.fastjson.JSONObject;
import javaFxDemo.ClientStart;
import org.junit.Test;

import java.util.List;

/**
 * @Author gaobaishun
 * @Date 2020-06-11 21:28
 * imformation：
 */
public class RequestTest {

    @Test
    public void requestConvert(){

        ClientStarter.initLocal();
        String httpUrl= ClientContext.getValueFromProperitiesByKey("base","baseUrl")
                +ClientContext.getValueFromProperitiesByKey("uri","menu");
        List<JSONObject> menuList =(List<JSONObject>)HttpUtils.getRequest(httpUrl,List.class);
        for (JSONObject men :
                menuList) {
            System.out.println(JSONObject.toJavaObject(men,MenuDO.class));
            System.out.println(men);
        }
    }
}
