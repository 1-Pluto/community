package xyz.liudeng.community.provider;

import ch.qos.logback.core.net.SyslogOutputStream;

import com.alibaba.fastjson.JSON;
import okhttp3.*;
import org.springframework.stereotype.Component;

import xyz.liudeng.community.dto.AccessTokendDTO;
import xyz.liudeng.community.dto.GithubUser;

import java.io.IOException;

/**
 * @author liudeng
 * @date 2019 -08-15-10:59
 */
@Component
public class GithubProvider {
    public String getAccessToken(AccessTokendDTO accessTokenDTO) {
        MediaType mediaType = MediaType.get("application/json; charset=utf-8");
        OkHttpClient client = new OkHttpClient();
        RequestBody body = RequestBody.create(mediaType,JSON.toJSONString(accessTokenDTO));
        Request request = new Request.Builder()
                .url("https://github.com/login/oauth/access_token")
                .post(body)
                .build();
        try (Response response = client.newCall(request).execute()) {
            String string=response.body().string();
            String token=string.split("&")[0].split("=")[1];
            return token;
        } catch (Exception e) {
            e.printStackTrace();
        }
            return null;
        }
     public GithubUser getuser(String accessToken){

         OkHttpClient client = new OkHttpClient();

         Request request = new Request.Builder()
                 .url("https://api.github.com/user?access_token="+accessToken)
                 .build();
         try {
             Response response = client.newCall(request).execute();
             String string=response.body().string();
             GithubUser githubUser=JSON.parseObject(string,GithubUser.class);
             return githubUser;
         } catch (IOException e) {
             e.printStackTrace();
         }
         return null;
     }



    }

