package com.maohacker.faceAPI;

import com.maohacker.common.sameAPI;

import java.io.File;
import java.util.HashMap;

/**
 * 描述:传入图片进行人脸检测和人脸分析,仅使用到face_token值。
 * @Author: mzy
 * @Date: 2019-3-27 0:32
 */
public class DetectAPI {
    public static void main(String[] args) throws Exception{

        File file = new File("C:\\Users\\hasee\\Desktop\\faceHouse\\101.JPG");
        byte[] buff = sameAPI.getBytesFromFile(file);
        System.out.println("buff-------------"+buff);
        String url = "https://api-cn.faceplusplus.com/facepp/v3/detect";
        HashMap<String, String> map = new HashMap<>();
        HashMap<String, byte[]> byteMap = new HashMap<>();
        map.put("api_key", sameAPI.api_key);
        map.put("api_secret", sameAPI.api_secret);
        map.put("outer_id", sameAPI.outer_id);
        map.put("return_landmark", "0");
        byteMap.put("image_file", buff);
        try{
            byte[] bacd = sameAPI.post(url, map, byteMap);
            String str = new String(bacd);
            System.out.println("str---"+str);
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

}
