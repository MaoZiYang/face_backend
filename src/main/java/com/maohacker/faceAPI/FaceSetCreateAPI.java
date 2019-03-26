package com.maohacker.faceAPI;

import com.maohacker.common.sameAPI;

import java.io.File;
import java.util.HashMap;

/**
 * 说明:创建一个人脸的集合 FaceSet，用于存储人脸标识 face_token。一个 FaceSet 能够存储 1,0000 个 face_token。
 * @Author: mzy
 * @Date: 2019-3-27 0:23
 */
public class FaceSetCreateAPI {
    public static void main(String[] args) throws Exception{

        File file = new File("C:\\Users\\hasee\\Desktop\\faceHouse\\22.JPG");
        byte[] buff = sameAPI.getBytesFromFile(file);
        String url = "https://api-cn.faceplusplus.com/facepp/v3/faceset/create";
        HashMap<String, String> map = new HashMap<>();
        HashMap<String, byte[]> byteMap = new HashMap<>();
        map.put("api_key", sameAPI.api_key);
        map.put("api_secret", sameAPI.api_secret);
        map.put("display_name", "高校人脸识别学生图库");
        map.put("outer_id", "facehouse");
        byteMap.put("image_file", buff);
        try{
            byte[] bacd = sameAPI.post(url, map, byteMap);
            String str = new String(bacd);
            System.out.println(str);
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

}
