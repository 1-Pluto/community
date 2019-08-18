package xyz.liudeng.community.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.liudeng.community.dto.QuestionDTO;
import xyz.liudeng.community.mapper.QuestionMapper;
import xyz.liudeng.community.mapper.UserMapper;
import xyz.liudeng.community.model.Question;
import xyz.liudeng.community.model.User;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liudeng
 * @date 2019 -08-18-10:44
 */
@Service
public class QuestionService {

    @Autowired
    private QuestionMapper questionMapper;

    @Autowired
    private UserMapper userMapper;

    public  List<QuestionDTO> list() {
        List<Question> questions=questionMapper.list();
        List<QuestionDTO> questionDTOList=new ArrayList<>();
            for (Question question : questions) {
            User user = userMapper.findById(question.getCreator());
            QuestionDTO questionDTO=new QuestionDTO();
                BeanUtils.copyProperties(question,questionDTO);
                questionDTO.setUser(user);
                questionDTOList.add(questionDTO);
        }

        return questionDTOList;
    }
}
