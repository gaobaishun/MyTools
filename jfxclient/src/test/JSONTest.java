import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.junit.Test;

import java.util.Date;

/**
 * @Author gaobaishun
 * @Date 2020-05-08 14:25
 * imformation：
 */
public class JSONTest {

    @Test
    public void JSONParseTest(){
        System.out.println("Start");
        String jsonStr="{\n" +
                "\t\"name\":\"atest\",\n" +
                "\t\"age\":\"18\",\n" +
                "\t\"birth\":\"1995-08-25 00:00:00\"\n" +
                "}";
        A a=JSONObject.parseObject(jsonStr,A.class);

        System.out.println(a);
    }

    @Test
    public void JSONParseTestFanXing(){
        A a=(A)ToolTest.parseTest(A.class);
        System.out.println(a);
    }

    private String getJsonStr(){
        return "{\n" +
                "\t\"name\":\"atest\",\n" +
                "\t\"age\":\"18\",\n" +
                "\t\"birth\":\"1995-08-25 00:00:00\"\n" +
                "}";
    }


}
class A{
    private String name;
    private int age;
    private Date birth;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    @Override
    public String toString() {
        return "A{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", birth=" + birth +
                '}';
    }
}

class ToolTest<T>{
    public static Object parseTest(Class cla){
        String jsonStr="{\n" +
                "\t\"name\":\"atest\",\n" +
                "\t\"age\":\"18\",\n" +
                "\t\"birth\":\"1995-08-25 00:00:00\"\n" +
                "}";
        Object o=JSONObject.parseObject(jsonStr,cla);


        return o;
    }
}