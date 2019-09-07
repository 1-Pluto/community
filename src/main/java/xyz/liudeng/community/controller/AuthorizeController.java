package xyz.liudeng.community.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import xyz.liudeng.community.dto.AccessTokendDTO;
import xyz.liudeng.community.dto.GithubUser;
import xyz.liudeng.community.mapper.UserMapper;
import xyz.liudeng.community.model.User;
import xyz.liudeng.community.provider.GithubProvider;
import xyz.liudeng.community.service.UserService;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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

    private String token;

    @Autowired
    private UserService userService;


    @GetMapping("/callback")
    public String callback(@RequestParam(name = "code") String code,
                           @RequestParam(name = "state") String state,
                           HttpServletRequest request,
                           HttpServletResponse response) {
        AccessTokendDTO accessTokendDTO = new AccessTokendDTO();
        accessTokendDTO.setRedirect_uri(redirectUri);
        accessTokendDTO.setCode(code);
        accessTokendDTO.setState(state);
        accessTokendDTO.setClient_id(clientId);
        accessTokendDTO.setClient_secret(clientSecret);
        String accessToken = githubProvider.getAccessToken(accessTokendDTO);
        GithubUser githubUser = githubProvider.getuser(accessToken);
        if (githubUser != null&&githubUser.getId() != null) {
            User user = new User();
            String token = UUID.randomUUID().toString();
            user.setToken(token);
            user.setName(githubUser.getName());
            user.setAccountId(String.valueOf(githubUser.getId()));
            user.setAvatarUrl(githubUser.getAvatarUrl());
            userService.createOrUpdate(user);
            response.addCookie(new Cookie("token", token));
            return "redirect:/";
        } else {
            //登录失败  重新登陆
            return "redirect:/";
        }
    }

    @GetMapping("/logout")
    public String logout(HttpServletRequest request,
                         HttpServletResponse response){
        request.getSession().removeAttribute("user");
        Cookie cookie =new Cookie("token",null);
        cookie.setMaxAge(0);
        response.addCookie(cookie);
        return "redirect:/";
    }




}
