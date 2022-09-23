package com.ctc.birthday.mapper;

import com.ctc.birthday.entity.Friend;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
* @author 32701
* @description 针对表【friend】的数据库操作Mapper
* @createDate 2022-09-23 14:54:43
* @Entity com.ctc.birthday.entity.Friend
*/
@Mapper
public interface FriendMapper extends BaseMapper<Friend> {
    @Select("SELECT * FROM friend WHERE MONTH(birthday) = MONTH(NOW()) AND DAY(birthday) = DAY(NOW())")
    List<Friend> selectAllByDate();
}




