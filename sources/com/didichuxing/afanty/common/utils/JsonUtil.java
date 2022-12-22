package com.didichuxing.afanty.common.utils;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public class JsonUtil {
    public static String map2Json(Map<String, Object> map) {
        if (map == null) {
            return "";
        }
        if (map.size() == 0) {
            return "{}";
        }
        try {
            return m32667a(map).toString();
        } catch (Throwable unused) {
            return "";
        }
    }

    /* renamed from: a */
    private static JSONObject m32667a(Map<String, Object> map) {
        JSONObject jSONObject = new JSONObject();
        for (String next : map.keySet()) {
            try {
                Object obj = map.get(next);
                if (obj instanceof String) {
                    jSONObject.put(next, obj);
                } else if (obj instanceof Integer) {
                    jSONObject.put(next, obj);
                } else if (obj instanceof Long) {
                    jSONObject.put(next, obj);
                } else if (obj instanceof Float) {
                    jSONObject.put(next, obj);
                } else if (obj instanceof Double) {
                    jSONObject.put(next, obj);
                } else if (obj instanceof Map) {
                    jSONObject.put(next, m32667a((Map<String, Object>) (Map) obj));
                } else if (obj instanceof List) {
                    jSONObject.put(next, m32666a((List<Object>) (List) obj));
                }
            } catch (Exception unused) {
            }
        }
        return jSONObject;
    }

    /* renamed from: a */
    private static JSONArray m32666a(List<Object> list) {
        JSONArray jSONArray = new JSONArray();
        for (Object next : list) {
            if (next instanceof String) {
                jSONArray.put(next);
            } else if (next instanceof Integer) {
                jSONArray.put(next);
            } else if (next instanceof Long) {
                jSONArray.put(next);
            } else if (next instanceof Float) {
                jSONArray.put(next);
            } else if (next instanceof Double) {
                jSONArray.put(next);
            } else if (next instanceof Map) {
                jSONArray.put(m32667a((Map<String, Object>) (Map) next));
            } else if (next instanceof List) {
                jSONArray.put(m32666a((List<Object>) (List) next));
            }
        }
        return jSONArray;
    }

    /* renamed from: a */
    private static Map<String, Object> m32665a(JSONObject jSONObject) {
        HashMap hashMap = new HashMap();
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            try {
                String next = keys.next();
                Object obj = jSONObject.get(next);
                if (obj instanceof String) {
                    hashMap.put(next, obj);
                } else if (obj instanceof Integer) {
                    hashMap.put(next, obj);
                } else if (obj instanceof Long) {
                    hashMap.put(next, obj);
                } else if (obj instanceof Float) {
                    hashMap.put(next, obj);
                } else if (obj instanceof Double) {
                    hashMap.put(next, obj);
                } else if (obj instanceof JSONObject) {
                    hashMap.put(next, m32665a((JSONObject) obj));
                } else if (obj instanceof JSONArray) {
                    hashMap.put(next, m32664a((JSONArray) obj));
                }
            } catch (Exception unused) {
            }
        }
        return hashMap;
    }

    /* renamed from: a */
    private static List<Object> m32664a(JSONArray jSONArray) {
        LinkedList linkedList = new LinkedList();
        int length = jSONArray.length();
        for (int i = 0; i < length; i++) {
            try {
                Object obj = jSONArray.get(i);
                if (obj instanceof String) {
                    linkedList.add(obj);
                } else if (obj instanceof Integer) {
                    linkedList.add(obj);
                } else if (obj instanceof Long) {
                    linkedList.add(obj);
                } else if (obj instanceof Float) {
                    linkedList.add(obj);
                } else if (obj instanceof Double) {
                    linkedList.add(obj);
                } else if (obj instanceof JSONObject) {
                    linkedList.add(m32665a((JSONObject) obj));
                } else if (obj instanceof JSONArray) {
                    linkedList.add(m32664a((JSONArray) obj));
                }
            } catch (Exception unused) {
            }
        }
        return linkedList;
    }
}
