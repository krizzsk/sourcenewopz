package com.didichuxing.apollo.sdk;

import android.text.TextUtils;
import com.google.gson.annotations.SerializedName;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class Experiment implements IExperiment {
    @SerializedName("args")
    public Map<String, Object> mParamMap;
    @SerializedName("testKey")
    public String mTestKey = "";

    @Deprecated
    public <T> T getParam(String str, T t) {
        T t2;
        Map<String, Object> map = this.mParamMap;
        if (!(map == null || (t2 = map.get(str)) == null)) {
            if (t != null) {
                try {
                    if (t2 instanceof Double) {
                        if (t.getClass().equals(Byte.class)) {
                            return Byte.valueOf(((Double) t2).byteValue());
                        }
                        if (t.getClass().equals(Short.class)) {
                            return Short.valueOf(((Double) t2).shortValue());
                        }
                        if (t.getClass().equals(Integer.class)) {
                            return Integer.valueOf(((Double) t2).intValue());
                        }
                        if (t.getClass().equals(Long.class)) {
                            return Long.valueOf(((Double) t2).longValue());
                        }
                        if (t.getClass().equals(Float.class)) {
                            return Float.valueOf(((Double) t2).floatValue());
                        }
                        if (t.getClass().equals(String.class)) {
                            return t2.toString();
                        }
                    }
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
            if (t == null || t2.getClass() != t.getClass()) {
                return t;
            }
            return t2;
        }
        return t;
    }

    public int getIntParam(String str, Integer num) {
        String a = m32682a(str);
        if (a == null) {
            return num.intValue();
        }
        try {
            return Double.valueOf(a).intValue();
        } catch (Exception unused) {
            return num.intValue();
        }
    }

    public double getDoubleParam(String str, Double d) {
        String a = m32682a(str);
        if (a == null) {
            return d.doubleValue();
        }
        try {
            return Double.valueOf(a).doubleValue();
        } catch (Exception unused) {
            return d.doubleValue();
        }
    }

    public String getStringParam(String str, String str2) {
        String a = m32682a(str);
        return a == null ? str2 : a;
    }

    public String getHitGroup() {
        String str = this.mTestKey;
        if (str == null) {
            return "";
        }
        return str.substring(str.lastIndexOf(":") + 1);
    }

    /* renamed from: a */
    private String m32682a(String str) {
        Object obj;
        Map<String, Object> map = this.mParamMap;
        if (map == null || (obj = map.get(str)) == null) {
            return null;
        }
        return String.valueOf(obj);
    }

    public String getTestKey() {
        String str = this.mTestKey;
        return str == null ? "" : str;
    }

    public JSONObject toJsonObject() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("testKey", this.mTestKey == null ? "" : this.mTestKey);
            JSONObject jSONObject2 = new JSONObject();
            if (this.mParamMap != null) {
                for (Map.Entry next : this.mParamMap.entrySet()) {
                    String str = (String) next.getKey();
                    Object value = next.getValue();
                    if (!TextUtils.isEmpty(str)) {
                        if (value != null) {
                            jSONObject2.put(str, value);
                        }
                    }
                }
            }
            jSONObject.put("params", jSONObject2);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    public boolean equals(Object obj) {
        Map<String, Object> map;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Experiment)) {
            return false;
        }
        Experiment experiment = (Experiment) obj;
        if (experiment.getTestKey().equals(getTestKey())) {
            if (experiment.mParamMap == null && this.mParamMap == null) {
                return true;
            }
            Map<String, Object> map2 = experiment.mParamMap;
            if (map2 == null || (map = this.mParamMap) == null || !map2.equals(map)) {
                return false;
            }
            return true;
        }
        return false;
    }

    public int hashCode() {
        int hashCode = getTestKey().hashCode();
        Map<String, Object> map = this.mParamMap;
        return map != null ? (hashCode * 31) + map.hashCode() : hashCode;
    }

    public String toString() {
        return String.format("{Experiment: [testKey=%s]}", new Object[]{this.mTestKey});
    }
}
