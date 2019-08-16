package xyz.liudeng.community.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import sun.misc.Request;
import xyz.liudeng.community.dto.AccessTokendDTO;
import xyz.liudeng.community.dto.GithubUser;
import xyz.liudeng.community.mapper.UserMapper;
import xyz.liudeng.community.model.User;
import xyz.liudeng.community.provider.GithubProvider;

import javax.servlet.http.HttpServletRequest;
import java.util.UUID;

/**
 * @author liudeng
 * @date 2019 -08-15-10:49
 */
@Controller
public class AuthorizeController {
    @Autowired
    private GithubProvider githubProvider;

    @Value("${github.client.id}")
    private String clientId;

    @Value("${github.client.secret}")
    private String clientSecret;

    @Value("${github.redirect.uri}")
    private String redirectUri;

    @Autowired
    private UserMapper userMapper;



    @GetMapping("/callback")
    public String callback(@RequestParam(name="code")  String code,
                           @RequestParam(name="state") String state,
                           HttpServletRequest request){
        AccessTokendDTO accessTokendDTO=new AccessTokendDTO();
        accessTokendDTO.setRedirect_uri(redirectUri);
        accessTokendDTO.setCode(code);
        accessTokendDTO.setState(state);
        accessTokendDTO.setClient_id(clientId);
        accessTokendDTO.setClient_secret(clientSecret);
        String accessToken = githubProvider.getAccessToken(accessTokendDTO);
        GithubUser githubUser = githubProvider.getuser(accessToken);
        if (githubUser!=null){
            User user= new User();
            user.setToken(UUID.randomUUID().toString());
            user.setName(githubUser.getName());
            user.setAccountId(String.valueOf(githubUser.getId()));
            user.setGmtCreate(System.currentTimeMillis());
            user.setGmtModified(user.getGmtCreate());
            userMapper.insert(user);
            //登录成功    写cookie和session
            request.getSession().setAttribute("user",githubUser);
            return "redirect:/";
        }else{
            //登录失败  重新登陆
            return "redirect:/";
        }
    }
}
