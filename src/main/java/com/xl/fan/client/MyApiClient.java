package com.xl.fan.client;

import cn.hutool.core.util.RandomUtil;
import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSONUtil;
import com.xl.fan.model.User;
import org.springframework.web.bind.annotation.*;


import java.util.HashMap;
import java.util.Map;

import static com.xl.fan.utils.SignUtils.getSign;

public class MyApiClient {

//    private String accessKey;
//    private String secretKey;
//
//    public MyApiClient(){
//        this.accessKey=accessKey;
//        this.secretKey=secretKey;
//    }
//
//    private Map<String,String> getHeaderMap(String body){
//        HashMap<String, String> hashMap = new HashMap<>();
//        hashMap.put("accessKey",accessKey);
//        hashMap.put("nonce", RandomUtil.randomNumbers(4));
//        hashMap.put("body",body);
//        hashMap.put("timestamp",String.valueOf(System.currentTimeMillis()/1000));
//        hashMap.put("sign",getSign(body,secretKey));
//        return hashMap;
//    }


    //    .addHeaders(getHeaderMap(json))

    public String getNameByGet(String name){
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("name",name);
        String result= HttpUtil.get("http://localhost:9999/name/", hashMap);
        System.out.println(result);
        return result;
    }


    public String getNameByPost(@RequestParam String name){
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("name",name);
        String result= HttpUtil.post("http://localhost:9999/name/", hashMap);
        System.out.println(result);
        return result;
    }


    public String getUsernameByPost(@RequestBody User user) {
        String json = JSONUtil.toJsonStr(user);
        String r = HttpRequest.post("http://localhost:9999/name/user").body(json).execute().body();
//        System.out.println(httpResponse.getStatus());
//        System.out.println(httpResponse.body());
        return r;
    }
}