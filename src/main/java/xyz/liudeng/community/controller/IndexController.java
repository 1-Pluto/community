package xyz.liudeng.community.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author liudeng
 * @date 2019 -08-15-9:37
 */
@Controller
public class IndexController {
        @GetMapping("/")
        public String index(){
            return "index";
        }
}
