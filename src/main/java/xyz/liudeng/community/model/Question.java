package xyz.liudeng.community.model;

import lombok.Data;

/**
 * @author liudeng
 * @date 2019 -08-16-23:09
 */
@Data
public class Question {
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

}
