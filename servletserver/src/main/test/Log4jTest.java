import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * @Author gaobaishun
 * @Date 2020-04-29 10:06
 * imformation：
 */
public class Log4jTest {
    static Logger logger= LogManager.getLogger(Log4jTest.class);

    public static void main(String[] args) {
        logger.debug("debug---------------");
        logger.error("error------------");
        logger.info("info--------------");

        Thread thread=new Thread(new Runnable() {
            @Override
            public void run() {
                Log4jTest.test();

            }
        });

        Thread thread2=new Thread(new Runnable() {
            @Override
            public void run() {
                Log4jTest.test();

            }
        });

        thread.start();
        thread2.start();
    }

    public static void test(){
        System.out.println("thread name:"+Thread.currentThread().getName());
        logger.debug("thread-debug---------------");
        logger.error("thread-error------------");
        logger.info("thread-info--------------");
    }
}
