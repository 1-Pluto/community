package xyz.liudeng.community.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import xyz.liudeng.community.dto.QuestionDTO;
import xyz.liudeng.community.mapper.QuestionMapper;
import xyz.liudeng.community.service.QuestionService;

import javax.jws.WebParam;

/**
 * @author liudeng
 * @date 2019 -08-21-15:01
 */
@Controller
public class QuestionController  {

    @Autowired
    private QuestionService questionService;

    @GetMapping("/question/{id}")
    public String question(@PathVariable(name = "id") Integer id,
                           Model model){
        QuestionDTO questionDTO = questionService.getById(id);
        //累加阅读数
        questionService.incView(id);
        model.addAttribute("question",questionDTO);
        return "question";
    }
}





















