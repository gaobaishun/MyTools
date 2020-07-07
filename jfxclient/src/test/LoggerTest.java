import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;

/**
 * @Author gaobaishun
 * @Date 2020-05-08 16:51
 * imformation：
 */
public class LoggerTest {

    private static Logger logger= LogManager.getLogger(LoggerTest.class);

    @Test
    public void LoggerUse(){
        //{}是占位符
        logger.info("A: {}","sdf");
    }
}
