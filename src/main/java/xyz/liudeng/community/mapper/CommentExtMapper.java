package xyz.liudeng.community.mapper;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;
import xyz.liudeng.community.model.Comment;
import xyz.liudeng.community.model.CommentExample;
import xyz.liudeng.community.model.Question;

import java.util.List;

public interface CommentExtMapper {

    int incCommentCount(Comment comment);
}