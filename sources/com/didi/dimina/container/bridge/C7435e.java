package com.didi.dimina.container.bridge;

import android.text.TextUtils;
import com.didi.dimina.container.DMMina;
import com.didi.dimina.container.bridge.base.CallbackFunction;
import com.didi.dimina.container.bridge.storage.StorageServiceSP;
import com.didi.dimina.container.mina.DMMinaPerfStorage;
import com.didi.dimina.container.secondparty.jsmodule.jsbridge.websocket.DMWebSocketListener;
import com.didi.dimina.container.util.CallBackUtil;
import com.didi.dimina.container.util.JSONUtil;
import com.didi.dimina.container.util.LogUtil;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.didi.dimina.container.bridge.e */
/* compiled from: StorageSubJSBridge */
class C7435e {

    /* renamed from: a */
    private static final String f16715a = "JSONObject";

    /* renamed from: b */
    private static final String f16716b = "JSONArray";

    /* renamed from: c */
    private static final String f16717c = "Boolean";

    /* renamed from: d */
    private static final String f16718d = "Double";

    /* renamed from: e */
    private static final String f16719e = "Integer";

    /* renamed from: f */
    private static final String f16720f = "Long";

    /* renamed from: g */
    private static final String f16721g = "String";

    /* renamed from: h */
    private static final int f16722h = 10240;

    /* renamed from: i */
    private final StorageServiceSP f16723i;

    /* renamed from: j */
    private final DMMinaPerfStorage f16724j;

    C7435e(DMMina dMMina) {
        this.f16724j = dMMina.getPerformance().getMinaPerfStorage();
        this.f16723i = new StorageServiceSP(dMMina);
        LogUtil.m13411i("StorageSubJSBridge init");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo54697a(JSONObject jSONObject) {
        if (jSONObject.has("key")) {
            m12391a(jSONObject.optString("key"), jSONObject.opt("data"));
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo54698a(JSONObject jSONObject, CallbackFunction callbackFunction) {
        JSONObject b = m12392b(jSONObject);
        if (callbackFunction != null) {
            callbackFunction.onCallBack(b);
        }
    }

    /* renamed from: b */
    private JSONObject m12392b(JSONObject jSONObject) {
        JSONObject jSONObject2 = new JSONObject();
        if (!jSONObject.has("key") || !jSONObject.has("data")) {
            JSONUtil.put(jSONObject2, "success", false);
            JSONUtil.put(jSONObject2, DMWebSocketListener.KEY_ERR_MSG, (Object) "参数出错：key");
        } else {
            m12391a(jSONObject.optString("key"), jSONObject.opt("data"));
            JSONUtil.put(jSONObject2, "success", true);
            JSONUtil.put(jSONObject2, "data", (Object) "设置成功：");
        }
        return jSONObject2;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public JSONObject mo54700b(JSONObject jSONObject, CallbackFunction callbackFunction) {
        return m12394c(jSONObject);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public void mo54701c(JSONObject jSONObject, CallbackFunction callbackFunction) {
        LogUtil.m13411i("StorageSubJSBridge removeStorage: " + jSONObject);
        JSONObject c = m12394c(jSONObject);
        if (callbackFunction != null) {
            callbackFunction.onCallBack(c);
        }
    }

    /* renamed from: c */
    private JSONObject m12394c(JSONObject jSONObject) {
        JSONObject jSONObject2 = new JSONObject();
        if (jSONObject.has("key")) {
            String optString = jSONObject.optString("key");
            this.f16723i.remove(optString);
            DMMinaPerfStorage dMMinaPerfStorage = this.f16724j;
            if (dMMinaPerfStorage != null) {
                dMMinaPerfStorage.minusStorage(optString);
            }
            JSONUtil.put(jSONObject2, "success", true);
            JSONUtil.put(jSONObject2, "data", (Object) "设置成功：");
        } else {
            JSONUtil.put(jSONObject2, "success", false);
            JSONUtil.put(jSONObject2, DMWebSocketListener.KEY_ERR_MSG, (Object) "参数出错：key");
        }
        return jSONObject2;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public Object mo54702d(JSONObject jSONObject, CallbackFunction callbackFunction) {
        return jSONObject.has("key") ? m12390a(jSONObject.optString("key")) : "";
    }

    /* access modifiers changed from: package-private */
    /* renamed from: e */
    public void mo54703e(JSONObject jSONObject, CallbackFunction callbackFunction) {
        if (callbackFunction == null) {
            return;
        }
        if (jSONObject.has("key")) {
            JSONObject jSONObject2 = new JSONObject();
            JSONUtil.put(jSONObject2, "data", m12390a(jSONObject.optString("key")));
            CallBackUtil.onSuccess(jSONObject2, callbackFunction);
            return;
        }
        CallBackUtil.onFail("参数出错：key", callbackFunction);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo54696a(CallbackFunction callbackFunction) {
        JSONObject c = m12393c();
        if (callbackFunction != null) {
            callbackFunction.onCallBack(c);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public JSONObject mo54695a() {
        return m12395d();
    }

    /* renamed from: c */
    private JSONObject m12393c() {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        List<String> e = m12396e();
        JSONUtil.put(jSONObject2, "keys", (Object) e);
        JSONUtil.put(jSONObject2, "currentSize", e.size());
        JSONUtil.put(jSONObject2, "limitSize", 10240);
        JSONUtil.put(jSONObject, "data", (Object) jSONObject2);
        JSONUtil.put(jSONObject, "success", true);
        return jSONObject;
    }

    /* renamed from: d */
    private JSONObject m12395d() {
        JSONObject jSONObject = new JSONObject();
        List<String> e = m12396e();
        JSONUtil.put(jSONObject, "keys", (Object) e);
        JSONUtil.put(jSONObject, "currentSize", e.size());
        JSONUtil.put(jSONObject, "limitSize", 10240);
        return jSONObject;
    }

    /* renamed from: e */
    private List<String> m12396e() {
        ArrayList arrayList = new ArrayList();
        for (String str : this.f16723i.getAllKeys()) {
            if (!str.contains(":type")) {
                arrayList.add(str);
            }
        }
        return arrayList;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: f */
    public void mo54704f(JSONObject jSONObject, CallbackFunction callbackFunction) {
        LogUtil.m13411i("StorageSubJSBridge clearStorage: " + jSONObject);
        this.f16723i.clearAll();
        DMMinaPerfStorage dMMinaPerfStorage = this.f16724j;
        if (dMMinaPerfStorage != null) {
            dMMinaPerfStorage.clear();
        }
        CallBackUtil.onSuccess(callbackFunction);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public JSONObject mo54699b() {
        LogUtil.m13411i("StorageSubJSBridge clearStorage: ");
        this.f16723i.clearAll();
        DMMinaPerfStorage dMMinaPerfStorage = this.f16724j;
        if (dMMinaPerfStorage != null) {
            dMMinaPerfStorage.clear();
        }
        JSONObject jSONObject = new JSONObject();
        JSONUtil.put(jSONObject, "success", true);
        return jSONObject;
    }

    /* renamed from: a */
    private void m12391a(String str, Object obj) {
        String str2 = str + ":type";
        if (obj instanceof JSONArray) {
            this.f16723i.putString(str2, f16716b);
            DMMinaPerfStorage dMMinaPerfStorage = this.f16724j;
            if (dMMinaPerfStorage != null) {
                dMMinaPerfStorage.plusStorage(str2, f16716b);
            }
            this.f16723i.putString(str, obj.toString());
        } else if (obj instanceof JSONObject) {
            this.f16723i.putString(str2, f16715a);
            DMMinaPerfStorage dMMinaPerfStorage2 = this.f16724j;
            if (dMMinaPerfStorage2 != null) {
                dMMinaPerfStorage2.plusStorage(str2, f16715a);
            }
            this.f16723i.putString(str, obj.toString());
        } else if (obj instanceof Boolean) {
            this.f16723i.putString(str2, f16717c);
            DMMinaPerfStorage dMMinaPerfStorage3 = this.f16724j;
            if (dMMinaPerfStorage3 != null) {
                dMMinaPerfStorage3.plusStorage(str2, f16717c);
            }
            this.f16723i.putBoolean(str, ((Boolean) obj).booleanValue());
        } else if (obj instanceof Double) {
            this.f16723i.putString(str2, f16718d);
            DMMinaPerfStorage dMMinaPerfStorage4 = this.f16724j;
            if (dMMinaPerfStorage4 != null) {
                dMMinaPerfStorage4.plusStorage(str2, f16718d);
            }
            this.f16723i.putFloat(str, ((Double) obj).floatValue());
        } else if (obj instanceof Integer) {
            this.f16723i.putString(str2, f16719e);
            DMMinaPerfStorage dMMinaPerfStorage5 = this.f16724j;
            if (dMMinaPerfStorage5 != null) {
                dMMinaPerfStorage5.plusStorage(str2, f16719e);
            }
            this.f16723i.putInt(str, ((Integer) obj).intValue());
        } else if (obj instanceof Long) {
            this.f16723i.putString(str2, f16720f);
            DMMinaPerfStorage dMMinaPerfStorage6 = this.f16724j;
            if (dMMinaPerfStorage6 != null) {
                dMMinaPerfStorage6.plusStorage(str2, f16720f);
            }
            this.f16723i.putLong(str, ((Long) obj).longValue());
        } else if (obj instanceof String) {
            this.f16723i.putString(str2, f16721g);
            DMMinaPerfStorage dMMinaPerfStorage7 = this.f16724j;
            if (dMMinaPerfStorage7 != null) {
                dMMinaPerfStorage7.plusStorage(str2, f16721g);
            }
            this.f16723i.putString(str, (String) obj);
        }
        DMMinaPerfStorage dMMinaPerfStorage8 = this.f16724j;
        if (dMMinaPerfStorage8 != null) {
            dMMinaPerfStorage8.plusStorage(str, obj);
        }
    }

    /* renamed from: a */
    private Object m12390a(String str) {
        String string = this.f16723i.getString(str + ":type", "");
        if (TextUtils.equals(string, f16716b)) {
            try {
                return new JSONArray(this.f16723i.getString(str, "[]"));
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (TextUtils.equals(string, f16715a)) {
            try {
                return new JSONObject(this.f16723i.getString(str, "{}"));
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        } else if (TextUtils.equals(string, f16717c)) {
            return Boolean.valueOf(this.f16723i.getBoolean(str, false));
        } else {
            if (TextUtils.equals(string, f16718d)) {
                return Double.valueOf(new BigDecimal(String.valueOf(this.f16723i.getFloat(str, 0.0f))).doubleValue());
            }
            if (TextUtils.equals(string, f16719e)) {
                return Integer.valueOf(this.f16723i.getInt(str, 0));
            }
            if (TextUtils.equals(string, f16720f)) {
                return Double.valueOf((double) this.f16723i.getLong(str, 0));
            }
            if (TextUtils.equals(string, f16721g)) {
                return this.f16723i.getString(str, "");
            }
            return "";
        }
    }
}
