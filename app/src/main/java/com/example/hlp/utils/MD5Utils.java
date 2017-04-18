package com.example.hlp.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by Administrator on 2017/4/13.
 */

public class MD5Utils {
    public static String encoder(String pwd){
        StringBuffer stringBuffer = new StringBuffer();
        //指定加密算法类型
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            //将需要加密的字符串转换为byte数组,然后进行随机哈希过程
            byte[] data = messageDigest.digest(pwd.getBytes());//16字节
            //遍历data，生成长度32的字符串，固定写法
            for (byte b:data){
                int i = b&0xff;
                String hex2string = Integer.toHexString(i);
                if(hex2string.length() < 2){
                    hex2string = "0"+hex2string;
                }
                stringBuffer.append(hex2string);
            }
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }finally {
            return stringBuffer.toString();
        }
    }
}
