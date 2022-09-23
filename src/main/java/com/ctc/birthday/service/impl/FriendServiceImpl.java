package com.ctc.birthday.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ctc.birthday.entity.Friend;
import com.ctc.birthday.service.FriendService;
import com.ctc.birthday.mapper.FriendMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
* @author 32701
* @description 针对表【friend】的数据库操作Service实现
* @createDate 2022-09-23 14:54:43
*/
@Service
public class FriendServiceImpl extends ServiceImpl<FriendMapper, Friend> implements FriendService{
    @Autowired
    private FriendMapper friendMapper;
    /**
     * 查询今日生日的人
     * @return
     */
    @Override
    public List<Friend> selectAllByDate() {
        return friendMapper.selectAllByDate();
    }
}




