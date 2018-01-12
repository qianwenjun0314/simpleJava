/**
 * Copyright (C), 2015-2018
 * FileName: JsonUtil
 * Author:   qianwenjun
 * Date:     2018/1/12 13:03
 * Description:
 */
package com.qwj.CommonUtils;

import java.util.List;

/**
 * 〈〉
 *
 * @author qianwenjun
 * @create 2018/1/12
 * @since 1.0.0
 */
public class JsonUtil {

    // gson对于json中含有html的标签的情况，格式化有个问题：html标签转换失败；使用String的替换方法解决 （临时解决方案）
    private static String OPEN_ANGLE = "\\\\u003c";
    private static String CLOSE_ANGLE = "\\\\u003e";
    private static String EQUAL_SIGN = "\\\\u003d";
    private static String QUOTES_SIGN = "\\\\u0027";
    private static String CONN_SIGN = "\\\\u0026";

    @Deprecated
    // 存放jsonStr中，指定key的value
    private List<Object> values;

    /**
     * 根据传入参数们构造json数组形式
     * <用法>
     List<Object> list = new ArrayList<Object>();
     list.add("abc");
     list.add(5);
     JsonUtil.jsonArray(list);

     输出 ：["abc",5]
     * </用法>
     * @param list
     * @return
     * add by youran
     */
//    public static String jsonArray(List<Object> list){
//        JSONArray jsonArray = new JSONArray();
//        for (int i = 0; i < list.size(); i++) {
//            jsonArray.add(i,list.get(i));
//        }
//        return jsonArray.toString();
//    }
//
//    /**
//     * 对json字符串进行格式化,默认对html标签不处理
//     *
//     * @param jsonStr 未格式化的jsonStr
//     * @return 已格式化的json字符串
//     */
//    public static String jsonFormatter(String jsonStr) {
//        return jsonFormatter(jsonStr, false);
//    }
//
//    /**
//     * 对json字符串进行格式化，含有特殊字符，包括html标签，需要特殊处理
//     *
//     * @param jsonStr     未格式化的jsonStr
//     * @param hasSpecChar true：含有特殊字符，包括html标签 false：不含特殊字符，包括html标签
//     * @return 已格式化的json字符串
//     */
//    public static String jsonFormatter(String jsonStr, boolean hasSpecChar) {
//        // 对json字符串先进行格式化，中文unicode转换成中文
//        String result = jsonStr;
//        if (isJson(jsonStr)) {
//            Gson gson = new GsonBuilder().setPrettyPrinting().create();
//            JsonParser jp = new JsonParser();
//            if (jsonStr.startsWith("{") || jsonStr.startsWith("[")) {
//                JsonElement je = jp.parse(jsonStr);
//                String prettyJsonString = gson.toJson(je);
//                result = prettyJsonString;
//                if (hasSpecChar) {
//                    result = result.replace(JsonUtil.OPEN_ANGLE, "<");
//                    result = result.replaceAll(JsonUtil.OPEN_ANGLE, "<");
//                    result = result.replaceAll(JsonUtil.CLOSE_ANGLE, ">");
//                    result = result.replaceAll(JsonUtil.EQUAL_SIGN, "=");
//                    result = result.replaceAll(JsonUtil.QUOTES_SIGN, "'");
//                    result = result.replaceAll(JsonUtil.CONN_SIGN, "&");
//                }
//            }
//        }
//        return result;
//    }
//
//    /**
//     * 将map、list等集合以及object转变成json字符串
//     *
//     * @param obj
//     * @return json字符串
//     */
//    public static String getJsonStr(Object obj) {
//        if (null == obj) {
//            return null;
//        }
//        return new Gson().toJson(obj);
//    }
//
//    /**
//     * 将json字符串，转换成Map对象
//     *
//     * @param jsonStr
//     * @return Map对象
//     */
//    public static Map<String, Object> jsonToMap(String jsonStr) {
//        Gson gson = new Gson();
//        return gson.fromJson(jsonStr, Map.class);
//    }
//
//    /**
//     * json字符串转成对象
//     *
//     * @param jsonStr
//     * @param type
//     * @return
//     */
//    public static <T> T jsonToObject(String jsonStr, Class<T> type) {
//        Gson gson = new Gson();
//        return gson.fromJson(jsonStr, type);
//    }
//
//    /**
//     * 将json字符串，转换成List对象
//     *
//     * @param jsonStr
//     * @return List对象
//     */
//    public static List<Map<String, Object>> jsonToList(String jsonStr) {
//        JSONArray jsonArr = JSONArray.fromObject(jsonStr);
//        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
//        Iterator<JSONObject> it = jsonArr.iterator();
//        while (it.hasNext()) {
//            JSONObject json = it.next();
//            list.add(jsonToMap(json.toString()));
//        }
//        return list;
//    }
//
//    /**
//     * json数组字符串转成对象
//     *
//     * @param jsonStr json数组字符串
//     * @param type
//     * @return
//     */
//    public static <T> List<T> jsonToList(String jsonStr, Class<T> type) {
//        Type listType = new TypeToken<ArrayList<T>>() {
//        }.getType();
//        List<T> list = new Gson().fromJson(jsonStr, listType);
//        return list;
//    }
//
//    /**
//     * 解析接口响应字符串jsonString中指定key对应的value
//     *
//     * @param jsonString 待解析的json字符串，目前都是json对象格式，非json数组格式
//     * @param key        json字符串存在的key， 格式：a[#n].b[#n].c[#n]
//     *                   ...(b是a对应的value中的一个key，c是b对应的value中的一个key，以此类推)
//     *                   [#n]为可选项，举例：a一般只有一个，当b有2个，c有3个时，
//     *                   要取第2个b、第3个c对应的值，key格式为：a.b#2.c#3；要取第2个b、第1个c对应的值，key格式为：a.b#2.
//     *                   c; 参考订单列表的响应结果；
//     * @return Object value
//     */
//    public static Object parseJsonStr(String jsonString, String key) {
//        Object value = null;
//
//        if (jsonString != null && key != null) {
//            String[] ks = key.split("\\.");
//
//            JSONObject jsonObject = JSONObject.fromObject(jsonString);
//            JSONArray jsonArr = null;
//
//            for (int i = 0; i < ks.length; i++) {
//                value = parseValueByCurrentKey(ks[i], jsonObject, jsonArr);
//                if (i < ks.length - 1) {
//                    if (value.toString().startsWith("[")) {
//                        jsonArr = JSONArray.fromObject(value);
//                        jsonObject = null;
//                    } else {
//                        jsonObject = JSONObject.fromObject(value);
//                    }
//                }
//            }
//        }
//        return value;
//    }
//
//    /**
//     * 判断2个Json字符串是否相等
//     * （传递的参数需为合法的json字符串）
//     *
//     * @param expJson  预期json字符串
//     * @param actJson  实际json字符串
//     * @param skipKeys 需要跳过，不作比较的key (用逗号分隔)
//     * @return boolean
//     */
//    public static boolean compareJson(String expJson, String actJson, String skipKeys) {
//        //响应报文一般是JsonObject
//        Map<String, Object> expMap = JsonUtil.jsonToMap(expJson);
//        Map<String, Object> actMap = JsonUtil.jsonToMap(actJson);
//
//        if (skipKeys != null && !"".equals(skipKeys.trim())) {
//            String[] keys = skipKeys.split("\\,");
//
//            CollectionsUtil.sortedMap(expMap, keys);
//            CollectionsUtil.sortedMap(actMap, keys);
//
//        } else {
//            CollectionsUtil.sortedMap(expMap, null);
//            CollectionsUtil.sortedMap(actMap, null);
//        }
//
//        Logger logger = LoggerUtil.getLogger(JsonUtil.class.getName());
//        logger.info("\r\n校验的预期值：" + expMap.toString() + "\r\n校验的实际值:" + actMap.toString());
//
//        return expMap.equals(actMap);
//    }
//
//    /**
//     * 判断一个字符串是否是json字符串
//     *
//     * @return boolean
//     * 1:JSONObject 2:JSONArray  返回true;
//     * 0:非法json字符串   返回false;
//     */
//    public static boolean isJson(String jsonStr) {
//        try {
//            JSONObject.fromObject(jsonStr);
//            return true;
//        } catch (JSONException e) {
//            // TODO: handle exception
//        }
//
//        try {
//            JSONArray.fromObject(jsonStr);
//            return true;
//        } catch (JSONException e) {
//            // TODO: handle exception
//        }
//        return false;
//    }
//
//    /**
//     * 判断一个字符串是否是json字符串
//     *
//     * @return boolean
//     * 1:JSONObject 2:JSONArray  返回true;
//     * 0:非法json字符串   返回false;
//     */
//    public static boolean isJsonObject(String jsonStr) {
//        try {
//            JSONObject.fromObject(jsonStr);
//            return true;
//        } catch (JSONException e) {
//            // TODO: handle exception
//            e.printStackTrace();
//        }
//        return false;
//    }
//
//    /**
//     * 判断一个字符串是否是json字符串数组
//     *
//     * @return boolean
//     */
//    public static boolean isJsonList(String jsonStr) {
//        try {
//            JSONArray.fromObject(jsonStr);
//            return true;
//        } catch (JSONException e) {
//            // TODO: handle exception
//            e.printStackTrace();
//        }
//
//        return false;
//    }
//
//    private static Object parseValueByCurrentKey(String currentKey, JSONObject jsonObject, JSONArray jsonArr) {
//        Object value = null;
//        // 当前key没有下标
//        String temp = currentKey;
//        int index = 0;
//        // 当前key带下标
//        if (currentKey.contains("#")) {
//            temp = currentKey.split("#")[0];
//            index = Integer.parseInt(currentKey.split("#")[1]) - 1;
//        }
//
//        if (jsonObject != null && jsonObject.containsKey(temp)) {
//            value = jsonObject.get(temp);
//        }
//
//        if (jsonArr != null) {
//            Object obj = jsonArr.get(index);
//            JSONObject subObj = JSONObject.fromObject(obj);
//            if (subObj.containsKey(temp)) {
//                value = subObj.get(temp);
//            }
//        }
//
//        return value;
//    }
//
//
//    ///////////////////////////////// 本工程中暂未使用，保留////////////////////////////////////////////
//
//    /**
//     * 解析jsonString中，指定key对应的jsonAarry中的某一个子jsonString，
//     * 根据子jsonString中的subKey和subValue获取
//     *
//     * @param jsonString 待解析的json字符串
//     * @param arrKey     jsonArray对应的key
//     * @param subKey     需要解析出来的子JsonString中的指定字段
//     * @param subValue   需要解析出来的子JsonString中，指定字段对应的指定值
//     * @return 子json字符串（已格式化）
//     */
//    @Deprecated
//    public static String getJsonString(String jsonString, String arrKey, String subKey, String subValue) {
//        JSONObject subObj = JSONObject.fromObject(jsonString);
//        JSONArray jsonArr = subObj.getJSONArray(arrKey);
//
//        Iterator<JSONObject> it = jsonArr.iterator();
//        while (it.hasNext()) {
//            JSONObject obj = it.next();
//            String temp = obj.getString(subKey);
//            if (temp.equals(subValue)) {
//                return jsonFormatter(obj.toString());
//            }
//        }
//        return null;
//    }
//
//    /**
//     * 该方法用于json串中，key重复的情况 解析jsonString中，与subKV属于同一json字符串，指定subKey对应的值
//     * key重复时，一般出现在json数组中；先根据json数组的指定arrKey获取json字符串，
//     * 再根据subKV获取其在所属json中的index； 根据index，获取指定subKey对应的值
//     *
//     * @param jsonString 待解析的json字符串
//     * @param arrKey     jsonString中指定的jsonArray对应的key
//     * @param subKV      解析出来的jsonArray，指定的键值对，用于获取其在jsonArray中的下标 格式同json串中键值对的格式,eg:
//     *                   id:123
//     * @param subKey     根据subKV所在下标，获取指定subKey对应的值
//     * @return subKey对应的值
//     * @author rachel.luo
//     */
//    @Deprecated
//    public static Object getSingleValueFromJson(String jsonString, String arrKey, String subKV, String subKey) {
//        Object result = null;
//        String subK = subKV.split(":")[0].trim();
//        String subV = subKV.split(":")[1].trim();
//        JSONArray jsonArr = (JSONArray) getSingleValueFromJson(jsonString, arrKey);
//        if (jsonArr != null) {
//            List<Object> values = new JsonUtil().getValuesFromJson(jsonArr.toString(), subK);
//            List<Object> results = new JsonUtil().getValuesFromJson(jsonArr.toString(), subKey);
//            for (int i = 0; i < values.size(); i++) {
//                Object obj = values.get(i);
//                if (subV.equals(obj.toString())) {
//                    result = results.get(i);
//                    return result;
//                }
//            }
//        }
//        return null;
//    }
//
//    /**
//     * 该方法用于json串中，key重复的情况
//     * 解析jsonString中，arrKey对应的value（一般是json数组），根据指定的index（元素下标），获取数组中对应的元素值
//     *
//     * @param jsonString 待解析的json字符串
//     * @param arrKey     jsonString中指定的jsonArray对应的key
//     * @param index      json数组中指定元素的下标
//     * @return String 返回json数组中对应下标的元素值（一般是json字符串）
//     * @author rachel.luo
//     */
//    @Deprecated
//    public static Object getSingleValueFromJson(String jsonString, String arrKey, Integer index) {
//        JSONArray jsonArr = (JSONArray) getSingleValueFromJson(jsonString, arrKey);
//        return jsonArr.get(index);
//    }
//
//    /**
//     * 解析json字符串中指定key的value,该方法用于json串中key唯一的情况
//     *
//     * @param jsonString json字符串
//     * @param key        json字符串中的key
//     * @return Object key对应的value,找到一个就返回
//     * @author rachel.luo
//     */
//    @Deprecated
//    public static Object getSingleValueFromJson(String jsonString, String key) {
//        Object value = null;
//        if (jsonString != null || key != null) {
//            if (jsonString.startsWith("[")) {
//                JSONArray jsonArr = JSONArray.fromObject(jsonString);
//                value = getSingleValueFromJSONArray(jsonArr, key);
//            } else if (jsonString.startsWith("{")) {
//                JSONObject jsonObj = JSONObject.fromObject(jsonString);
//                value = getSingleValueFromJSONObject(jsonObj, key);
//            }
//        }
//        return value;
//    }
//
//    /**
//     * 解析json字符串中指定key的value
//     *
//     * @param jsonString json字符串
//     * @param key        json字符串中的key
//     * @return List<Object> key对应的value
//     * @author rachel.luo
//     */
//    @Deprecated
//    public List<Object> getValuesFromJson(String jsonString, String key) {
//        values = new ArrayList<Object>();
//        if (jsonString != null || key != null) {
//            if (jsonString.startsWith("[")) {
//                JSONArray jsonArr = JSONArray.fromObject(jsonString);
//                getValueFromJSONArray(jsonArr, key);
//            } else if (jsonString.startsWith("{")) {
//                JSONObject jsonObj = JSONObject.fromObject(jsonString);
//                getValueFromJSONObject(jsonObj, key);
//            }
//        }
//        return values;
//    }
//
//    /**
//     * 递归解析JSONArray中的指定key
//     *
//     * @author rachel.luo
//     */
//    @Deprecated
//    private void getValueFromJSONArray(JSONArray jsonArr, String key) {
//        for (int i = 0; i < jsonArr.size(); i++) {
//            Object obj = jsonArr.get(i);
//            if (obj.toString().startsWith("[")) {
//                JSONArray subArr = JSONArray.fromObject(obj);
//                getValueFromJSONArray(subArr, key);
//            } else if (obj.toString().startsWith("{")) {
//                JSONObject subObj = JSONObject.fromObject(obj);
//                getValueFromJSONObject(subObj, key);
//            }
//        }
//    }
//
//    /**
//     * 递归解析JSONObject中的指定key
//     *
//     * @author rachel.luo
//     */
//    @Deprecated
//    private void getValueFromJSONObject(JSONObject jsonObj, String key) {
//        Object value = null;
//        if (jsonObj.containsKey(key)) {// json字符串的查找，终结于所有的JSONObject,找到后即可返回
//            value = jsonObj.get(key);
//            values.add(value);
//            return;
//        }
//        Set keys = jsonObj.keySet();
//        Iterator<String> keyIt = keys.iterator();
//        while (keyIt.hasNext()) {
//            String onekey = keyIt.next();
//            Object vObj = jsonObj.get(onekey);
//            if (vObj.toString().startsWith("{")) {
//                JSONObject subJs = JSONObject.fromObject(vObj);
//                getValueFromJSONObject(subJs, key);
//            } else if (vObj.toString().startsWith("[")) {
//                JSONArray subArr = JSONArray.fromObject(vObj);
//                getValueFromJSONArray(subArr, key);
//            }
//        }
//    }
//
//    /**
//     * 递归解析JSONArray中的指定key
//     *
//     * @author rachel.luo
//     */
//    @Deprecated
//    private static Object getSingleValueFromJSONArray(JSONArray jsonArr, String key) {
//        Object result = null;
//        for (int i = 0; i < jsonArr.size(); i++) {
//            Object obj = jsonArr.get(i);
//            if (obj.toString().startsWith("[")) {
//                JSONArray subArr = JSONArray.fromObject(obj);
//                result = getSingleValueFromJSONArray(subArr, key);
//            } else if (obj.toString().startsWith("{")) {
//                JSONObject subObj = JSONObject.fromObject(obj);
//                result = getSingleValueFromJSONObject(subObj, key);
//            }
//            if (result != null) {// 找到就返回
//                break;
//            }
//        }
//        return result;
//    }
//
//    /**
//     * 递归解析JSONObject中的指定key
//     *
//     * @author rachel.luo
//     */
//    @Deprecated
//    private static Object getSingleValueFromJSONObject(JSONObject jsonObj, String key) {
//        Object value = null;
//        if (jsonObj.containsKey(key)) {// json字符串的查找，终结于所有的JSONObject,找到后即可返回
//            value = jsonObj.get(key);
//            return value;
//        }
//        Set keys = jsonObj.keySet();
//        Iterator<String> keyIt = keys.iterator();
//        while (keyIt.hasNext()) {
//            String onekey = keyIt.next();
//            Object vObj = jsonObj.get(onekey);
//            if (vObj.toString().startsWith("{")) {
//                JSONObject subJs = JSONObject.fromObject(vObj);
//                value = getSingleValueFromJSONObject(subJs, key);
//            } else if (vObj.toString().startsWith("[")) {
//                JSONArray subArr = JSONArray.fromObject(vObj);
//                value = getSingleValueFromJSONArray(subArr, key);
//            }
//            if (value != null) {// 找到就返回
//                break;
//            }
//        }
//        return value;
//    }
//
//    public static void main(String[] args) {
//        System.out.println(JsonUtil.class.getResource("").getPath());
//        System.out.println(JsonUtil.class.getResource("/").getPath());
//    }
}