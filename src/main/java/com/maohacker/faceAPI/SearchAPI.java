package com.maohacker.faceAPI;

import com.maohacker.common.sameAPI;

import java.io.File;
import java.util.HashMap;

/**
 * 描述:
 * 在一个已有的 FaceSet 中找出与目标人脸最相似的一张或多张人脸，返回置信度和不同误识率下的阈值。
 * 支持传入图片或 face_token 进行人脸搜索。使用图片进行搜索时会选取图片中检测到人脸尺寸最大的一个人脸。
 *更新日志
 * 2017年3月28日：支持base64编码的图片。
 * @Author: mzy
 * @Date: 2019-3-27 1:06
 */
public class SearchAPI {
    public static void main(String[] args) throws Exception{

        File file = new File("C:\\Users\\hasee\\Desktop\\faceHouse\\22.JPG");
        byte[] buff = sameAPI.getBytesFromFile(file);
        String url = "https://api-cn.faceplusplus.com/facepp/v3/search";
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
