package Message;

/**
 * @Author gaobaishun
 * @Date 2020-04-22 14:30
 * imformation：
 */
public class LoginRespMessage extends ResponseMessage{


    private int status=-1;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = this.getResponseMessageStatus().getCode();
    }
}
