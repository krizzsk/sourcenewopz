package com.didichuxing.omega.sdk.common.utils;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

public class JsonUtil {
    public static String map2Json(Map<String, Object> map) {
        if (map == null) {
            return "";
        }
        if (map.size() == 0) {
            return "{}";
        }
        try {
            return map2Jo(map).toString();
        } catch (Throwable unused) {
            OLog.m34769w("map2Json fail!");
            return "";
        }
    }

    public static <T> String list2Json(List<T> list) {
        if (list == null) {
            return "";
        }
        if (list.size() == 0) {
            return "[]";
        }
        try {
            return list2Ja(list).toString();
        } catch (Throwable th) {
            OLog.m34770w("list2Json fail!", th);
            return "";
        }
    }

    public static <T> String set2Json(Set<T> set) {
        if (set == null) {
            return "";
        }
        if (set.size() == 0) {
            return "[]";
        }
        try {
            return set2Ja(set).toString();
        } catch (Throwable th) {
            OLog.m34770w("list2Json fail!", th);
            return "";
        }
    }

    public static JSONObject map2Jo(Map<String, Object> map) {
        JSONObject jSONObject = new JSONObject();
        for (String next : map.keySet()) {
            try {
                Object obj = map.get(next);
                if (obj instanceof String) {
                    jSONObject.put(next, (String) obj);
                } else if (obj instanceof Integer) {
                    jSONObject.put(next, (Integer) obj);
                } else if (obj instanceof Long) {
                    jSONObject.put(next, (Long) obj);
                } else if (obj instanceof Float) {
                    jSONObject.put(next, (Float) obj);
                } else if (obj instanceof Double) {
                    jSONObject.put(next, (Double) obj);
                } else if (obj instanceof Map) {
                    jSONObject.put(next, map2Jo((Map) obj));
                } else if (obj instanceof List) {
                    jSONObject.put(next, list2Ja((List) obj));
                } else if (obj instanceof Boolean) {
                    jSONObject.put(next, ((Boolean) obj).booleanValue() ? 1 : 0);
                } else {
                    OLog.m34763e("map2Jo: Unexpected value type:" + obj + " of key:" + next);
                }
            } catch (JSONException e) {
                OLog.m34770w("Could not create JSON object for key " + next, e);
            }
        }
        return jSONObject;
    }

    private static <T> JSONArray list2Ja(List<T> list) {
        JSONArray jSONArray = new JSONArray();
        for (T next : list) {
            if (next instanceof String) {
                jSONArray.put((String) next);
            } else if (next instanceof Integer) {
                jSONArray.put((Integer) next);
            } else if (next instanceof Long) {
                jSONArray.put((Long) next);
            } else if (next instanceof Float) {
                jSONArray.put((Float) next);
            } else if (next instanceof Double) {
                jSONArray.put((Double) next);
            } else if (next instanceof Map) {
                jSONArray.put(map2Jo((Map) next));
            } else if (next instanceof List) {
                jSONArray.put(list2Ja((List) next));
            } else if (next instanceof Boolean) {
                jSONArray.put(((Boolean) next).booleanValue() ? 1 : 0);
            } else {
                OLog.m34763e("list2Ja: Unexpected value type:" + next + ".");
            }
        }
        return jSONArray;
    }

    private static <T> JSONArray set2Ja(Set<T> set) {
        JSONArray jSONArray = new JSONArray();
        for (T next : set) {
            if (next instanceof String) {
                jSONArray.put((String) next);
            } else if (next instanceof Integer) {
                jSONArray.put((Integer) next);
            } else if (next instanceof Long) {
                jSONArray.put((Long) next);
            } else if (next instanceof Float) {
                jSONArray.put((Float) next);
            } else if (next instanceof Double) {
                jSONArray.put((Double) next);
            } else if (next instanceof Map) {
                jSONArray.put(map2Jo((Map) next));
            } else if (next instanceof List) {
                jSONArray.put(list2Ja((List) next));
            } else if (next instanceof Boolean) {
                jSONArray.put(((Boolean) next).booleanValue() ? 1 : 0);
            } else {
                OLog.m34763e("set2Ja: Unexpected value type:" + next + ".");
            }
        }
        return jSONArray;
    }

    public static Map<String, Object> json2Map(String str) {
        try {
            Object nextValue = new JSONTokener(str).nextValue();
            if (nextValue instanceof JSONObject) {
                return jo2Map((JSONObject) nextValue);
            }
            return null;
        } catch (Throwable th) {
            OLog.m34770w("json2Map error!", th);
            return null;
        }
    }

    private static Map<String, Object> jo2Map(JSONObject jSONObject) {
        HashMap hashMap = new HashMap();
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            try {
                String next = keys.next();
                Object obj = jSONObject.get(next);
                if (obj instanceof String) {
                    hashMap.put(next, (String) obj);
                } else if (obj instanceof Integer) {
                    hashMap.put(next, (Integer) obj);
                } else if (obj instanceof Long) {
                    hashMap.put(next, (Long) obj);
                } else if (obj instanceof Float) {
                    hashMap.put(next, (Float) obj);
                } else if (obj instanceof Double) {
                    hashMap.put(next, (Double) obj);
                } else if (obj instanceof JSONObject) {
                    hashMap.put(next, jo2Map((JSONObject) obj));
                } else if (obj instanceof JSONArray) {
                    hashMap.put(next, ja2List((JSONArray) obj));
                } else if (obj instanceof Boolean) {
                    hashMap.put(next, Integer.valueOf(((Boolean) obj).booleanValue() ? 1 : 0));
                } else {
                    OLog.m34763e("jo2Map: Unexpected value type:" + obj + ".");
                }
            } catch (JSONException e) {
                OLog.m34770w("jo2Map: error!", e);
            }
        }
        return hashMap;
    }

    private static List<Object> ja2List(JSONArray jSONArray) {
        LinkedList linkedList = new LinkedList();
        int length = jSONArray.length();
        for (int i = 0; i < length; i++) {
            try {
                Object obj = jSONArray.get(i);
                if (obj instanceof String) {
                    linkedList.add((String) obj);
                } else if (obj instanceof Integer) {
                    linkedList.add((Integer) obj);
                } else if (obj instanceof Long) {
                    linkedList.add((Long) obj);
                } else if (obj instanceof Float) {
                    linkedList.add((Float) obj);
                } else if (obj instanceof Double) {
                    linkedList.add((Double) obj);
                } else if (obj instanceof JSONObject) {
                    linkedList.add(jo2Map((JSONObject) obj));
                } else if (obj instanceof JSONArray) {
                    linkedList.add(ja2List((JSONArray) obj));
                } else if (obj instanceof Boolean) {
                    linkedList.add(Integer.valueOf(((Boolean) obj).booleanValue() ? 1 : 0));
                } else {
                    OLog.m34763e("ja2List: Unexpected value type:" + obj + ".");
                }
            } catch (JSONException e) {
                OLog.m34770w("ja2List: error!", e);
            }
        }
        return linkedList;
    }
}
