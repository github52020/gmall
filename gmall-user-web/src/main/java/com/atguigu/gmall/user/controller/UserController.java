package com.atguigu.gmall.user.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.atguigu.gmall.bean.UmsMember;
import com.atguigu.gmall.bean.UmsMemberReceiveAddress;
import com.atguigu.gmall.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class UserController {
    @Reference
    UserService userService;
    //测试启动
    @RequestMapping("index")
    @ResponseBody
    public String index() {
        return "你好";
    }
    //查询所有会员
    @RequestMapping("getAllUser")
    @ResponseBody
    public List<UmsMember> getUserAll() {
        List<UmsMember> userMembers = userService.getAllUser();
        return userMembers;
    }
    //根据ID查询会员收获地址
    @RequestMapping("getReceiveAddressByMemberId")
    @ResponseBody
    public List<UmsMemberReceiveAddress> getReceiveAddressByMemberId(String memberId) { // @RequestBody主要用来接收前端传递给后端的json字符串中的数据的(请求体中的数据的)
        List<UmsMemberReceiveAddress> UmsMemberReceiveAddresses = userService.getReceiveAddressByMemberId(memberId);
        return UmsMemberReceiveAddresses;
    }
}

