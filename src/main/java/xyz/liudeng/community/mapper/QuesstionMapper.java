package xyz.liudeng.community.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import xyz.liudeng.community.model.Question;

/**
 * @author liudeng
 * @date 2019 -08-16-23:01
 */
@Mapper
public interface QuesstionMapper {

    @Insert("insert into question (title,description,gmt_create,gmt_modified,creater,tag) values (#{title},#{description},#{gmtCreate},#{gmtModified},#{creater},#{tag})")
    void create(Question question);
}
