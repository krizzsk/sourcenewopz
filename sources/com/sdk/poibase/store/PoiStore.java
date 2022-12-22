package com.sdk.poibase.store;

import android.content.Context;
import com.didi.sdk.apm.SystemUtils;
import com.didi.sdk.store.BaseStore;
import global.didi.pay.newview.pix.IPixView;
import java.util.List;

public class PoiStore extends BaseStore {

    /* renamed from: ID */
    public static final String f56006ID = "didimap";

    /* renamed from: a */
    private static final String f56007a = "PoiStore";

    /* renamed from: b */
    private static PoiStore f56008b;

    /* renamed from: c */
    private Context f56009c;

    /* renamed from: a */
    private static void m40336a(Context context) {
        SystemUtils.log(3, f56007a, IPixView.PAGE_STATUS_INIT, (Throwable) null, "com.sdk.poibase.store.PoiStore", 24);
        synchronized (PoiStore.class) {
            if (f56008b == null) {
                f56008b = new PoiStore(context);
            }
        }
    }

    public static PoiStore getInstance(Context context) {
        if (f56008b == null) {
            m40336a(context);
        }
        return f56008b;
    }

    private PoiStore(Context context) {
        super("didimap");
        this.f56009c = context;
    }

    public void putJsonObj(String str, Object obj) {
        if (obj != null) {
            SystemUtils.log(3, f56007a, "put " + str + " with " + obj.toString(), (Throwable) null, "com.sdk.poibase.store.PoiStore", 59);
            putAndSave(this.f56009c, str, JsonUtil.jsonFromObject(obj));
        }
    }

    public <T> T getJsonObj(String str, Class<T> cls) {
        String string = getString(str, (String) null);
        if (string == null) {
            return null;
        }
        return JsonUtil.objectFromJson(string, cls);
    }

    public <T> List<T> getList(String str, Class<T> cls) {
        SystemUtils.log(3, f56007a, "getList", (Throwable) null, "com.sdk.poibase.store.PoiStore", 81);
        String string = getString(str, (String) null);
        if (string == null) {
            return null;
        }
        return JsonUtil.jsonToList(string, cls);
    }

    public String getString(String str, String str2) {
        Object inner = getInner(str);
        if (inner instanceof byte[]) {
            String str3 = new String((byte[]) inner);
            SystemUtils.log(3, f56007a, "get " + str + " with " + str3, (Throwable) null, "com.sdk.poibase.store.PoiStore", 93);
            return str3;
        } else if (inner instanceof String) {
            String str4 = (String) inner;
            SystemUtils.log(3, f56007a, "get " + str + " with " + str4, (Throwable) null, "com.sdk.poibase.store.PoiStore", 98);
            return str4;
        } else {
            SystemUtils.log(3, f56007a, "return default value for " + str + " with " + str2, (Throwable) null, "com.sdk.poibase.store.PoiStore", 101);
            return str2;
        }
    }

    public int getInt(String str, int i) {
        try {
            int intValue = Integer.valueOf(getString(str, i + "")).intValue();
            SystemUtils.log(3, f56007a, "return value for " + str + " with " + intValue, (Throwable) null, "com.sdk.poibase.store.PoiStore", 109);
            return intValue;
        } catch (Exception unused) {
            return i;
        }
    }

    public long getLong(String str, long j) {
        try {
            long longValue = Long.valueOf(getString(str, j + "")).longValue();
            SystemUtils.log(3, f56007a, "return value for " + str + " with " + longValue, (Throwable) null, "com.sdk.poibase.store.PoiStore", 120);
            return longValue;
        } catch (Exception unused) {
            return j;
        }
    }

    public boolean getBoolean(String str, boolean z) {
        try {
            boolean booleanValue = Boolean.valueOf(getString(str, z + "")).booleanValue();
            SystemUtils.log(3, f56007a, "return value for " + str + " with " + booleanValue, (Throwable) null, "com.sdk.poibase.store.PoiStore", 131);
            return booleanValue;
        } catch (Exception unused) {
            return z;
        }
    }

    public void putAndSave(String str, int i) {
        SystemUtils.log(3, f56007a, "put " + str + " with " + i, (Throwable) null, "com.sdk.poibase.store.PoiStore", 139);
        Context context = this.f56009c;
        StringBuilder sb = new StringBuilder();
        sb.append(i);
        sb.append("");
        super.putAndSave(context, str, sb.toString());
    }

    public void putAndSave(String str, boolean z) {
        SystemUtils.log(3, f56007a, "put " + str + " with " + z, (Throwable) null, "com.sdk.poibase.store.PoiStore", 144);
        Context context = this.f56009c;
        StringBuilder sb = new StringBuilder();
        sb.append(z);
        sb.append("");
        super.putAndSave(context, str, sb.toString());
    }

    public void putAndSave(String str, long j) {
        SystemUtils.log(3, f56007a, "put " + str + " with " + j, (Throwable) null, "com.sdk.poibase.store.PoiStore", 149);
        Context context = this.f56009c;
        StringBuilder sb = new StringBuilder();
        sb.append(j);
        sb.append("");
        super.putAndSave(context, str, sb.toString());
    }

    public void putAndSave(String str, String str2) {
        SystemUtils.log(3, f56007a, "put " + str + " with " + str2, (Throwable) null, "com.sdk.poibase.store.PoiStore", 154);
        super.putAndSave(this.f56009c, str, str2);
    }

    public Object getInner(String str) {
        return super.getInner(this.f56009c, str);
    }

    public void remove(String str) {
        super.remove(str);
        super.wipe(str);
    }
}
