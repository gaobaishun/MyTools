package Enumration;

/**
 * @Author gaobaishun
 * @Date 2020-04-22 14:01
 * imformation：
 */
public enum ResponseMessageStatus {
    SUCCESS(0,"成功"),
    FAIL(1,"失败"),
    ERROR(2,"出现错误"),
    ;

    private int code;
    private String desc;
    ResponseMessageStatus(int i,String desc) {
        code=i;
        this.desc=desc;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }}
