package com.didi.component.evaluate.store;

import android.content.Context;
import com.didi.remotereslibrary.store.JsonUtil;
import com.didi.sdk.store.BaseStore;

public class EvaluateStore extends BaseStore {

    /* renamed from: a */
    private static final String f13325a = "framework-evaluate-store";

    /* renamed from: b */
    private static EvaluateStore f13326b;

    private EvaluateStore() {
        super(f13325a);
    }

    public static EvaluateStore getInstance() {
        if (f13326b == null) {
            synchronized (EvaluateStore.class) {
                if (f13326b == null) {
                    f13326b = new EvaluateStore();
                }
            }
        }
        return f13326b;
    }

    public void putJsonObj(Context context, String str, Object obj) {
        if (obj != null) {
            putAndSave(context, str, JsonUtil.jsonFromObject(obj));
        }
    }

    public <T> T getJsonObj(Context context, String str, Class<T> cls) {
        String string = getString(context, str, (String) null);
        if (string == null) {
            return null;
        }
        return JsonUtil.objectFromJson(string, cls);
    }

    public String getString(Context context, String str, String str2) {
        Object inner = getInner(context, str);
        if (inner instanceof byte[]) {
            return new String((byte[]) inner);
        }
        return inner instanceof String ? (String) inner : str2;
    }
}
