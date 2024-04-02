package com.xl.fan.controller;


import com.xl.fan.model.User;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;

import static com.xl.fan.utils.SignUtils.getSign;

@RestController
@RequestMapping("/name")
public class NameController {

    @GetMapping("/")
    public String getNameByGet(String name){
        return "get的名字"+ name;
    }

    @PostMapping("/")
    public String getNameByPost(@RequestParam String name){
        return "post的名字"+ name;
    }

    @PostMapping("/user")
    public String getUsernameByPost(@RequestBody User user){
//        String accessKey = request.getHeader("accessKey");
//        String nonce = request.getHeader("nonce");
//        String timestamp = request.getHeader("timestamp");
//        String sign = request.getHeader("sign");
//        String body = request.getHeader("body");
//        //去数据库中查是否分配给用户accessKey
//        if(!accessKey.equals("123")){
//            throw new RuntimeException("无权限");
//        }
//        //将字符串（4位数的随机数）转化为长整形
//        if(Long.parseLong(nonce)>1000){
//            throw new RuntimeException("无权限");
//        }
//        //校验时间戳
//        //去数据库中查secretKey,用户同样的方法生成签证sign1，与前端传的签证sign比较
//        String sign1 = getSign(body, "qwer");
//        if(!sign.equals(sign1)){
//            throw new RuntimeException("无权限");
//        }
        return "用户名字是"+user.getUsername();
    }

}
