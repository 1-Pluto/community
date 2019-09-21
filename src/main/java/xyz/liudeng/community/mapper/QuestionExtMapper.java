package xyz.liudeng.community.mapper;

import xyz.liudeng.community.dto.QuestionQueryDTO;
import xyz.liudeng.community.model.Question;

import java.util.List;


public interface QuestionExtMapper {

    int incView(Question record);

    int incCommentCount(Question record);

    List<Question> selectRelated(Question question);

    Integer countBySearch(QuestionQueryDTO questionQueryDTO);

    List<Question> selectBySearch(QuestionQueryDTO questionQueryDTO);
}