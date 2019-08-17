package xyz.liudeng.community.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import xyz.liudeng.community.mapper.UserMapper;
import xyz.liudeng.community.model.User;


import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

/**
 * @author liudeng
 * @date 2019 -08-15-9:37
 */
@Controller
public class IndexController {
    @Autowired
    private UserMapper userMapper;

    @GetMapping("/")
    public String index(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        if (cookies != null && cookies.length != 0) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("token")) {
                    String token = cookie.getValue();
                    User user = userMapper.findByToken(token);
                    if (user != null) {
                        request.getSession().setAttribute("user", user);
                    }
                    break;
                }
            }
            return "index";
        } else {
            return "index";
        }
    }
}
