package xyz.liudeng.community.dto;

import lombok.Data;

/**
 * @author liudeng
 * @date 2019 -08-15-12:45
 */
@Data
public class GithubUser {
    private String name;
    private Long id;
    private String bio;
    private String avatar_url;

}
