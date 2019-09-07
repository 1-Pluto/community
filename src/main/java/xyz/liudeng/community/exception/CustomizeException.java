package xyz.liudeng.community.exception;

/**
 * @author liudeng
 * @date 2019 -09-05-14:14
 */
public class CustomizeException extends RuntimeException{
    private  String message;
    public CustomizeException(ICustomizeErrorCode errorCode) {
        this.message = errorCode.getMessage();
    }

    public CustomizeException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }

}
