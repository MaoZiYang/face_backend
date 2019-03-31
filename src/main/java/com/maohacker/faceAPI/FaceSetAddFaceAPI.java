package com.maohacker.faceAPI;

import com.maohacker.common.sameAPI;

import java.io.File;
import java.util.HashMap;

/**
 * 说明:为一个已经创建的 FaceSet 添加人脸标识 face_token。一个 FaceSet 最多存储1,0000个 face_token。
 * @Author: mzy
 * @Date: 2019-3-27 0:28
 */
public class FaceSetAddFaceAPI {
    public static void main(String[] args) throws Exception{

    File file = new File("C:\\Users\\hasee\\Desktop\\faceHouse\\11.JPG");
    byte[] buff = sameAPI.getBytesFromFile(file);
    String url = "https://api-cn.faceplusplus.com/facepp/v3/faceset/addface";
    HashMap<String, String> map = new HashMap<>();
    HashMap<String, byte[]> byteMap = new HashMap<>();
    map.put("api_key", sameAPI.api_key);
    map.put("api_secret", sameAPI.api_secret);
    map.put("outer_id", sameAPI.outer_id);
    map.put("face_tokens","4fe122cd04569f34a7d6129852106214");
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
