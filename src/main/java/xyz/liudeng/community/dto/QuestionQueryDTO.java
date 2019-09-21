package xyz.liudeng.community.dto;

import lombok.Data;

/**
 * @author liudeng
 * @date 2019 -09-20-16:23
 */
@Data
public class QuestionQueryDTO {
    private String search;
    private Integer page;
    private Integer size;
}
