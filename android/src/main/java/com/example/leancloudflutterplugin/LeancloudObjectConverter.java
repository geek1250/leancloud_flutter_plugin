package com.example.leancloudflutterplugin;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import cn.leancloud.AVObject;

class LeancloudObjectConverter {

    /**
     * convert String to AVObject
     *
     * @param avObjectString flutter object json string
     * @return AVObject
     */
    static AVObject convertStringToAVObject(String avObjectString) {
        JSONObject avObjectJson = JSON.parseObject(avObjectString);
        String className = avObjectJson.getString("className");
        String fieldsString = avObjectJson.getString("fields");
        JSONObject fieldsJson = JSON.parseObject(fieldsString);
        AVObject avObject = new AVObject(className);
        for (String key : fieldsJson.keySet()) {
            //TODO if those value is Date or byte[] type?
            //TODO more data type? e.g. AVGeoPoint？
            avObject.put(key, fieldsJson.get(key));
        }
        return avObject;
    }

}
