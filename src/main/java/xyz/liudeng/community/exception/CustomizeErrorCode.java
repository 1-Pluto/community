package xyz.liudeng.community.exception;

/**
 * @author liudeng
 * @date 2019 -09-05-14:54
 */
public enum CustomizeErrorCode implements ICustomizeErrorCode {
    QUESTION_NOT_FOUND(2001,"问题不存在哦..."),
    TARGET_PARAM_NOT_FOUND(2002,"未选中任何问题或者评论进行回复"),
    NO_LONGIN(2003,"当前操作需要登录，请登录后重试"),
    SYS_ERROR(2004,"页面迷失在星空中..."),
    TYPE_PARAM_WRONG(2005,"评论类型错误或不存在"),
    COMMENT_NOT_FOUND(2006,"您回复的评论已经不存在了"),
    CONTENT_IS_EMPTY(2007,"输入内容不能为空"),
    READ_NOTIFICATION_FAIL(2008,"禁止偷窥别人信息哦"),
    NOTIFICATION_NOT_FAIL(2009,"消息不翼而飞了"),
    FILE_UPLOAD_FAIL(2010,"图片上传失败")
    ;


    @Override
    public String getMessage() {
        return message;
    }

    @Override
    public Integer getCode() {
        return code;
    }

    private Integer code;
    private String message;


    CustomizeErrorCode( Integer code,String message) {
        this.message = message;
        this.code = code;
    }

}
