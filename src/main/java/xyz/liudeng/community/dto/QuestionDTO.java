package xyz.liudeng.community.dto;

import lombok.Data;
import xyz.liudeng.community.model.User;

/**
 * @author liudeng
 * @date 2019 -08-18-10:41
 */
@Data
public class QuestionDTO {
    private Integer id;
    private String title;
    private String description;
    private String tag;
    private Long gmtCreate;
    private Long gmtModified;
    private Integer creator;
    private Integer viewCount;
    private Integer commentCount;
    private Integer likeCount;
    private User user;
}
