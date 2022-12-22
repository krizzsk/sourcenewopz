package com.didi.dimina.container.bridge.storage;

import com.tencent.mmkv.MMKV;

public class MMKVUtil {

    /* renamed from: a */
    private static MMKVUtil f16769a;

    /* renamed from: b */
    private final MMKV f16770b = MMKV.defaultMMKV();

    private MMKVUtil() {
    }

    public static MMKVUtil getInstance() {
        if (f16769a == null) {
            synchronized (MMKVUtil.class) {
                if (f16769a == null) {
                    f16769a = new MMKVUtil();
                }
            }
        }
        return f16769a;
    }

    public void remove(String str) {
        this.f16770b.remove(str);
    }

    public void clearAll() {
        this.f16770b.clearAll();
    }

    public String[] getAllKeys() {
        return this.f16770b.allKeys();
    }

    public void save(String str, Object obj) {
        if (obj instanceof String) {
            this.f16770b.encode(str, (String) obj);
        } else if (obj instanceof Integer) {
            this.f16770b.encode(str, ((Integer) obj).intValue());
        } else if (obj instanceof Long) {
            this.f16770b.encode(str, ((Long) obj).longValue());
        } else if (obj instanceof Float) {
            this.f16770b.encode(str, ((Float) obj).floatValue());
        } else if (obj instanceof Double) {
            this.f16770b.encode(str, ((Double) obj).doubleValue());
        } else if (obj instanceof Boolean) {
            this.f16770b.encode(str, ((Boolean) obj).booleanValue());
        } else {
            this.f16770b.encode(str, obj.toString());
        }
    }

    public Object get(String str, Object obj) {
        if (obj instanceof String) {
            return this.f16770b.decodeString(str, (String) obj);
        }
        if (obj instanceof Integer) {
            return Integer.valueOf(this.f16770b.decodeInt(str, ((Integer) obj).intValue()));
        }
        if (obj instanceof Long) {
            return Long.valueOf(this.f16770b.decodeLong(str, ((Long) obj).longValue()));
        }
        if (obj instanceof Float) {
            return Float.valueOf(this.f16770b.decodeFloat(str, ((Float) obj).floatValue()));
        }
        if (obj instanceof Double) {
            return Double.valueOf(this.f16770b.decodeDouble(str, ((Double) obj).doubleValue()));
        }
        if (obj instanceof Boolean) {
            return Boolean.valueOf(this.f16770b.decodeBool(str, ((Boolean) obj).booleanValue()));
        }
        return obj != null ? this.f16770b.decodeString(str, obj.toString()) : "";
    }
}
