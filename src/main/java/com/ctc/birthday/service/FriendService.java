package com.ctc.birthday.service;

import com.ctc.birthday.entity.Friend;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
* @author 32701
* @description 针对表【friend】的数据库操作Service
* @createDate 2022-09-23 14:54:43
*/
public interface FriendService extends IService<Friend> {

    /**
     * 查询今日生日人数
     * @return
     */
    List<Friend> selectAllByDate();
}
