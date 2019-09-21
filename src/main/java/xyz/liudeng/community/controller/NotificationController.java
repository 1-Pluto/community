package xyz.liudeng.community.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import xyz.liudeng.community.dto.NotificationDTO;
import xyz.liudeng.community.dto.PaginationDTO;
import xyz.liudeng.community.enums.NotificationTypeEnum;
import xyz.liudeng.community.model.Notification;
import xyz.liudeng.community.model.User;
import xyz.liudeng.community.service.NotificationService;

import javax.servlet.http.HttpServletRequest;
import javax.xml.ws.Action;

/**
 * @author liudeng
 * @date 2019 -09-18-11:49
 */
@Controller
public class NotificationController {

    @Autowired
    private NotificationService notificationService;

    @GetMapping("/notification/{id}")
    public String profile(@PathVariable(name = "id") Long id,
                          HttpServletRequest request) {

        User user = (User) request.getSession().getAttribute("user");
        if (user == null) {
            return "redirct:/";
        }

        NotificationDTO notificationDTO = notificationService.read(id, user);
        if(NotificationTypeEnum.REPLY_COMMENT.getType() == notificationDTO.getType()
            || NotificationTypeEnum.REPLY_QUESTION.getType()==notificationDTO.getType()){
            return "redirect:/question/"+notificationDTO.getOuterid();
        }else{
            return "redirct:/"; }

    }
}
