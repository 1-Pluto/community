package xyz.liudeng.community.model;

import lombok.Data;

/**
 * @author liudeng
 * @date 2019 -08-15-20:27
 */
@Data
public class User {
    private Integer id;
    private String name;
    private String accountId;
    private String token;
    private Long gmtCreate;
    private Long gmtModified;
    private String avatarUrl;

}
