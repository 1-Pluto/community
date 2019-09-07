package xyz.liudeng.community.exception;

/**
 * @author liudeng
 * @date 2019 -09-05-14:14
 */
public class CusomizeException  extends RuntimeException{
    private  String message;

    public CusomizeException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }

}
