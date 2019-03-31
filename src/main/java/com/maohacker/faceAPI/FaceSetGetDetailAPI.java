package com.maohacker.faceAPI;

import com.maohacker.common.sameAPI;

import java.io.File;
import java.util.HashMap;

/**
 * 描述:
 * 获取一个 FaceSet 的所有信息，包括此 FaceSet 的 faceset_token, outer_id, display_name 的信息，
 * 以及此 FaceSet 中存放的 face_token 数量与列表。
 * @Author: mzy
 * @Date: 2019-3-31 15:48
 */
public class FaceSetGetDetailAPI {
    public static void main(String[] args) throws Exception{

        byte[] buff = new byte[0];
        String url = "https://api-cn.faceplusplus.com/facepp/v3/faceset/getdetail";
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
