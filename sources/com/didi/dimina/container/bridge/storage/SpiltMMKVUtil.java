package com.didi.dimina.container.bridge.storage;

import android.text.TextUtils;
import com.tencent.mmkv.MMKV;

public class SpiltMMKVUtil {

    /* renamed from: a */
    private final MMKV f16771a;

    public SpiltMMKVUtil(String str) {
        if (TextUtils.isEmpty(str)) {
            this.f16771a = MMKV.defaultMMKV();
        } else {
            this.f16771a = MMKV.mmkvWithID(str);
        }
    }

    public void remove(String str) {
        this.f16771a.remove(str);
    }

    public void clearAll() {
        this.f16771a.clearAll();
    }

    public String[] getAllKeys() {
        return this.f16771a.allKeys();
    }

    public void save(String str, Object obj) {
        if (obj instanceof String) {
            this.f16771a.encode(str, (String) obj);
        } else if (obj instanceof Integer) {
            this.f16771a.encode(str, ((Integer) obj).intValue());
        } else if (obj instanceof Long) {
            this.f16771a.encode(str, ((Long) obj).longValue());
        } else if (obj instanceof Float) {
            this.f16771a.encode(str, ((Float) obj).floatValue());
        } else if (obj instanceof Double) {
            this.f16771a.encode(str, ((Double) obj).doubleValue());
        } else if (obj instanceof Boolean) {
            this.f16771a.encode(str, ((Boolean) obj).booleanValue());
        } else {
            this.f16771a.encode(str, obj.toString());
        }
    }

    public Object get(String str, Object obj) {
        if (obj instanceof String) {
            return this.f16771a.decodeString(str, (String) obj);
        }
        if (obj instanceof Integer) {
            return Integer.valueOf(this.f16771a.decodeInt(str, ((Integer) obj).intValue()));
        }
        if (obj instanceof Long) {
            return Long.valueOf(this.f16771a.decodeLong(str, ((Long) obj).longValue()));
        }
        if (obj instanceof Float) {
            return Float.valueOf(this.f16771a.decodeFloat(str, ((Float) obj).floatValue()));
        }
        if (obj instanceof Double) {
            return Double.valueOf(this.f16771a.decodeDouble(str, ((Double) obj).doubleValue()));
        }
        if (obj instanceof Boolean) {
            return Boolean.valueOf(this.f16771a.decodeBool(str, ((Boolean) obj).booleanValue()));
        }
        return obj != null ? this.f16771a.decodeString(str, obj.toString()) : "";
    }
}
