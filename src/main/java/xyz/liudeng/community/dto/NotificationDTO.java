package xyz.liudeng.community.dto;

import lombok.Data;
import xyz.liudeng.community.model.User;

/**
 * @author liudeng
 * @date 2019 -09-18-9:49
 */
@Data
public class NotificationDTO {
    private Long id;
    private Long gmtCreate;
    private Integer stauts;
    private Long notifier;
    private String notifierName;
    private String outerTitle;
    private Long outerid;
    private String typeName;
    private Integer type;


}
