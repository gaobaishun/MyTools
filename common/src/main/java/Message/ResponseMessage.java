package Message;

import Enumration.ResponseMessageStatus;

/**
 * @Author gaobaishun
 * @Date 2020-04-22 13:58
 * imformation：
 */
public class ResponseMessage {
    private String messageInfo;
    private ResponseMessageStatus responseMessageStatus;

    @Override
    public String toString() {
        return "ResponseMessage{" +
                "messageInfo='" + messageInfo + '\'' +
                ", responseMessageStatus=" + responseMessageStatus +
                '}';
    }

    public ResponseMessageStatus getResponseMessageStatus() {
        return responseMessageStatus;
    }

    public void setResponseMessageStatus(ResponseMessageStatus responseMessageStatus) {
        this.responseMessageStatus = responseMessageStatus;
    }

    public String getMessageInfo() {
        return messageInfo;
    }

    public void setMessageInfo(String messageInfo) {
        this.messageInfo = messageInfo;
    }


}
