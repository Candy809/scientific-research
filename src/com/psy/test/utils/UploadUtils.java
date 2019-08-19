package com.psy.test.utils;

import java.util.UUID;

/**
 * @Auther: Smilence
 * @Description: 文件上传工具类
 * @Date: 2019年04月14日 10：39
 * @Version: 1.0
 */
public class UploadUtils {

    public static String getUuidFileName(String fileName) {
        //解决目录下文件名重复问题
        //得到随机文件名
        int i = fileName.lastIndexOf(".");
        String extions = fileName.substring(i);
        return UUID.randomUUID().toString().replace("-", "") + extions;
    }

    //目录分离的方法
    public static String getPath(String uuidFileName) {
        int code1 = uuidFileName.hashCode();
        int d1 = code1 & 0xf;//一级目录
        int code2 = code1 >>> 4;//右移四位
        int d2 = code2 & 0xf;//二级目录
        return "/" + d1 + "/" + d2;
    }
}
