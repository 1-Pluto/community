package xyz.liudeng.community.dto;

import lombok.Data;
import xyz.liudeng.community.model.User;

/**
 * @author liudeng
 * @date 2019 -09-14-13:55
 */
@Data
public class CommentDTO {
    private Long id;
    private Long parentId;
    private Integer type;
    private Long commentator;
    private Long gmtCreate;
    private Long gmtModified;
    private Long likeCount;
    private String content;
    private User user;
    private Integer commentCount;
}
