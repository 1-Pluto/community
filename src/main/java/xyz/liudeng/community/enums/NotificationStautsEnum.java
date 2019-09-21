package xyz.liudeng.community.enums;

/**
 * @author liudeng
 * @date 2019 -09-18-9:22
 */
public enum NotificationStautsEnum {
    UNREAD(0), READ(1);
    private int stauts;

    public int getStauts() {
        return stauts;
    }

    NotificationStautsEnum(int stauts) {
        this.stauts = stauts;
    }
}
