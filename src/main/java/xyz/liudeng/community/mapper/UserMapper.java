package xyz.liudeng.community.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import xyz.liudeng.community.model.User;

/**
 * @author liudeng
 * @date 2019 -08-15-20:16
 */
@Mapper
public interface UserMapper {
        @Insert("insert into USER (name,account_id,token,gmt_create,gmt_modified) values (#{name},#{accountId},#{token},#{gmtCreate},#{gmtModified})")
        void insert(User user);
}
