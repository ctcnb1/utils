package com.ctc.birthday.controller;

import com.ctc.birthday.common.R;
import com.ctc.birthday.entity.Friend;
import com.ctc.birthday.service.FriendService;
import com.ctc.birthday.util.EmailService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/friend")
@Slf4j
public class FriendController {

    @Autowired
    private FriendService birthdayService;
    @Autowired
    private EmailService emailService;

    /**
     * 查询全部
     * @return 生日集合
     */
    @GetMapping("/getAll")
    public R<List<Friend>> getAll(){
        List<Friend> list = birthdayService.list();
        return R.success(list);
    }

    /**
     * 添加
     * @return 提示信息
     */
    @PostMapping("/add")
    public R<String> add(Friend friend){
        if (friend==null||friend.getName()==null||friend.getBirthday()==null||friend.getEmail()==null)
            return R.error("数据出错");
        birthdayService.save(friend);
        return R.success("添加成功");
    }

    /**
     * 查询并发送短信
     */
    @GetMapping("/message")
    public R<List<Friend>> message(){
        List<Friend> friendList = birthdayService.selectAllByDate();
        if (friendList!=null){
            friendList.forEach(friend ->
                    emailService.send("生日快乐",friend.getEmail(),friend.getName()+",生日快乐"));
        }
        return R.success(friendList);
    }





}
