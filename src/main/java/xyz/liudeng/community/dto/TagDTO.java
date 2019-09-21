package xyz.liudeng.community.dto;

import lombok.Data;

import java.util.List;

/**
 * @author liudeng
 * @date 2019 -09-17-16:27
 */
@Data
public class TagDTO {
    private String categoryName;
    private List<String> tags;
}
