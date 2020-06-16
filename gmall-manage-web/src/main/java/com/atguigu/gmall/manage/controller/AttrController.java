package com.atguigu.gmall.manage.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.atguigu.gmall.bean.PmsBaseAttrInfo;
import com.atguigu.gmall.bean.PmsBaseAttrValue;
import com.atguigu.gmall.service.PmsBaseAttrInfoService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
@CrossOrigin(origins = "*", allowCredentials = "true", maxAge = 3600, methods = {RequestMethod.POST, RequestMethod.GET, RequestMethod.OPTIONS, RequestMethod.DELETE})
public class AttrController {

    @Reference  //远程注入
     PmsBaseAttrInfoService pmsBaseAttrInfoService;

    //查询属性值列表
    @RequestMapping(value = "attrInfoList")
    @ResponseBody
    public List<PmsBaseAttrInfo> attrInfoList(String catalog3Id) {

        List<PmsBaseAttrInfo> PmsBaseAttrInfos = pmsBaseAttrInfoService.attrInfoList(catalog3Id);
        return PmsBaseAttrInfos;

    }

    //保存属性值 与属性名称
    @RequestMapping(value = "saveAttrInfo")
    @ResponseBody
    public String saveAttrInfo(@RequestBody PmsBaseAttrInfo pmsBaseAttrInfo) {
        String success = pmsBaseAttrInfoService.saveAttrInfo(pmsBaseAttrInfo);
        return "success";
    }

    //修改属性明与属性值 attrId=12
   /* @RequestMapping(value = "getAttrValueList")
    @ResponseBody
    public String getAttrValueList(@RequestBody PmsBaseAttrInfo pmsBaseAttrInfo) {
        String success = pmsBaseAttrInfoService.getAttrValueList(pmsBaseAttrInfo);
        return "success";
    }*/


    //修改回显示 attrId=12
    @RequestMapping(value = "getAttrValueList")
    @ResponseBody
    public List<PmsBaseAttrValue> getAttrValueList(String attrId) {
     List<PmsBaseAttrValue> PmsBaseAttrValues=pmsBaseAttrInfoService.getAttrValueList(attrId);
        return PmsBaseAttrValues;
    }
}
