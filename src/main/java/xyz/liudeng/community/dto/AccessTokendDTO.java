package xyz.liudeng.community.dto;

import lombok.Data;

/**
 * @author liudeng
 * @date 2019 -08-15-11:02
 */
@Data
public class AccessTokendDTO {
    private  String client_id;
    private  String client_secret;
    private  String code;
    private  String redirect_uri;
    private  String state;

}
