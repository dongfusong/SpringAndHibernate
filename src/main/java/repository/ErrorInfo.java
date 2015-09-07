package repository;

/**
 * Created by Thoughtworks on 15/9/7.
 */

public enum ErrorInfo {
    request_checkcode_too_soon("申请验证码太频繁"),
    wrong_password("密码错误");

    private final String content;

    ErrorInfo(String content){
        this.content = content;
    }

    public String getContent() {
        return content;
    }
}