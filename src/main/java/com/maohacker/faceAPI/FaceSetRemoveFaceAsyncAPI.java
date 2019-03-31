package com.maohacker.faceAPI;

import com.maohacker.common.sameAPI;

import java.util.HashMap;

/**
 * 描述:
 *移除一个FaceSet中的某些或者全部face_token
 * @Author: mzy
 * @Date: 2019-3-31 16:19
 */
public class FaceSetRemoveFaceAsyncAPI {
    public static void main(String[] args) throws Exception{

        byte[] buff = new byte[0];
        String url = "https://api-cn.faceplusplus.com/facepp/v3/faceset/async/removeface";
        HashMap<String, String> map = new HashMap<>();
        HashMap<String, byte[]> byteMap = new HashMap<>();
        map.put("api_key", sameAPI.api_key);
        map.put("api_secret", sameAPI.api_secret);
        map.put("face_tokens", "RemoveAllFaceTokens");
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