package xyz.liudeng.community.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import xyz.liudeng.community.dto.PaginationDTO;
import xyz.liudeng.community.dto.QuestionDTO;
import xyz.liudeng.community.mapper.QuestionMapper;
import xyz.liudeng.community.mapper.UserMapper;
import xyz.liudeng.community.model.Question;
import xyz.liudeng.community.model.User;
import xyz.liudeng.community.service.QuestionService;


import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author liudeng
 * @date 2019 -08-15-9:37
 */
@Controller
public class IndexController {
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private QuestionService questionService;

    @GetMapping("/")
    public String index(HttpServletRequest request,
                        Model model,
                        @RequestParam(name = "page", defaultValue = "1") Integer page,
                        @RequestParam(name = "size", defaultValue = "5") Integer size) {
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
            PaginationDTO pagination =questionService.list(page, size);
            model.addAttribute("pagination", pagination);
            return "index";
        } else {
            return "index";
        }
    }
}
