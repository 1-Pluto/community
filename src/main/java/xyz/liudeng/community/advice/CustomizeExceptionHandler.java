package xyz.liudeng.community.advice;

import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
import xyz.liudeng.community.exception.CustomizeException;

import javax.servlet.http.HttpServletRequest;

/**
 * @author liudeng
 * @date 2019 -09-05-12:36
 */
@ControllerAdvice
public class CustomizeExceptionHandler {

    @ExceptionHandler(Exception.class)
    ModelAndView handle(Throwable e,Model model) {
        if(e instanceof CustomizeException){
            model.addAttribute("message",e.getMessage());
        }else{
            model.addAttribute("message","页面迷失在星空中...");
        }
        return new ModelAndView("error");
    }

}
