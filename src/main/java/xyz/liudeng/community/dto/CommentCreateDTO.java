package xyz.liudeng.community.dto;

import lombok.Data;

/**
 * @author liudeng
 * @date 2019 -09-07-10:11
 */
@Data
public class CommentCreateDTO {
    private Long parentId;
    private String content;
    private Integer type;
}
