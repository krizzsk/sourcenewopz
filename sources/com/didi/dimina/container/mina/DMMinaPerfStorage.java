package com.didi.dimina.container.mina;

import android.content.Context;
import com.didi.dimina.container.util.LogUtil;
import com.tencent.mmkv.MMKV;
import java.io.File;
import org.json.JSONArray;
import org.json.JSONObject;

public class DMMinaPerfStorage {

    /* renamed from: a */
    private final MMKV f16896a;

    public DMMinaPerfStorage(Context context, String str) {
        this.f16896a = MMKV.mmkvWithID(str + "_PerfStorage", new File(context.getFilesDir(), "DMMinaPerfStorage").getAbsolutePath());
    }

    public void plusStorage(String str, Object obj) {
        if (obj instanceof JSONArray) {
            this.f16896a.putString(str, obj.toString());
        } else if (obj instanceof JSONObject) {
            this.f16896a.putString(str, obj.toString());
        } else if (obj instanceof Boolean) {
            this.f16896a.putBoolean(str, ((Boolean) obj).booleanValue());
        } else if (obj instanceof Double) {
            this.f16896a.putFloat(str, ((Double) obj).floatValue());
        } else if (obj instanceof Integer) {
            this.f16896a.putInt(str, ((Integer) obj).intValue());
        } else if (obj instanceof Long) {
            this.f16896a.putLong(str, ((Long) obj).longValue());
        } else if (obj instanceof String) {
            this.f16896a.putString(str, (String) obj);
        }
    }

    public void minusStorage(String str) {
        this.f16896a.remove(str);
    }

    public void clear() {
        this.f16896a.clear();
    }

    public long getTotal() {
        long currentTimeMillis = System.currentTimeMillis();
        String[] allKeys = this.f16896a.allKeys();
        long j = 0;
        if (allKeys != null) {
            for (String valueActualSize : allKeys) {
                j += (long) this.f16896a.getValueActualSize(valueActualSize);
            }
        }
        LogUtil.m13408d(getClass().getSimpleName(), "getTotal: " + j + " duration:  " + (System.currentTimeMillis() - currentTimeMillis));
        return j;
    }
}
