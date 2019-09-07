package xyz.liudeng.community.exception;

/**
 * @author liudeng
 * @date 2019 -09-05-14:54
 */
public enum CustomizeErrorCode  implements ICustomizeErrorCode{
    QUESTION_NOT_FOUND("问题不存在哦...");
    private String message;

    CustomizeErrorCode(String message) {
        this.message = message;
    }
    @Override
    public String getMessage() {
        return message;
    }
}
