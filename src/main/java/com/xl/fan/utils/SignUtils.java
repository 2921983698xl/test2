package com.xl.fan.utils;

import cn.hutool.crypto.digest.DigestAlgorithm;
import cn.hutool.crypto.digest.Digester;

public class SignUtils {
    /**
     * 生成签名
     */
    public static String getSign(String body,String secretKey){
        Digester md5 = new Digester(DigestAlgorithm.SHA256);
        String content = body + "." +secretKey;
        return md5.digestHex(content);
    }
}
