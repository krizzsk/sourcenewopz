package com.didi.remotereslibrary.store;

import android.content.Context;
import android.text.TextUtils;
import com.didi.remotereslibrary.response.ResourceListResponser;
import com.didi.sdk.store.BaseStore;
import java.util.List;

public class RemoteResourceStore extends BaseStore {
    public static final String KEY_RESLIST_DATA = "result_reslist_data";

    /* renamed from: b */
    private static RemoteResourceStore f33181b;

    /* renamed from: a */
    private Context f33182a;

    private RemoteResourceStore(Context context) {
        super("framework-remoteresource");
        this.f33182a = context;
    }

    public static RemoteResourceStore getInstance(Context context) {
        if (f33181b == null) {
            f33181b = new RemoteResourceStore(context);
        }
        return f33181b;
    }

    public void putJsonObj(String str, Object obj) {
        if (obj != null) {
            putAndSave(this.f33182a, str, JsonUtil.jsonFromObject(obj));
        }
    }

    public <T> T getJsonObj(String str, Class<T> cls) {
        String string = getString(str, (String) null);
        if (string == null) {
            return null;
        }
        return JsonUtil.objectFromJson(string, cls);
    }

    public ResourceListResponser getResourceListCache(String str) {
        String string = getString(str, "");
        if (TextUtils.isEmpty(string)) {
            return null;
        }
        ResourceListResponser resourceListResponser = new ResourceListResponser();
        resourceListResponser.parser(string);
        return resourceListResponser;
    }

    public void putResourceListCache(String str, ResourceListResponser resourceListResponser) {
        super.putAndSave(this.f33182a, str, resourceListResponser.getResultData());
    }

    public <T> List<T> getList(String str, Class<T> cls) {
        String string = getString(str, (String) null);
        if (string == null) {
            return null;
        }
        return JsonUtil.jsonToList(string, cls);
    }

    public String getString(String str, String str2) {
        Object inner = getInner(this.f33182a, str);
        if (inner instanceof byte[]) {
            return new String((byte[]) inner);
        }
        return inner instanceof String ? (String) inner : str2;
    }

    public int getInt(String str, int i) {
        try {
            return Integer.valueOf(getString(str, i + "")).intValue();
        } catch (Exception unused) {
            return i;
        }
    }

    public long getLong(String str, long j) {
        try {
            return Long.valueOf(getString(str, j + "")).longValue();
        } catch (Exception unused) {
            return j;
        }
    }

    public boolean getBoolean(String str, boolean z) {
        try {
            return Boolean.valueOf(getString(str, z + "")).booleanValue();
        } catch (Exception unused) {
            return z;
        }
    }

    public void putAndSave(String str, int i) {
        Context context = this.f33182a;
        super.putAndSave(context, str, i + "");
    }

    public void putAndSave(String str, boolean z) {
        Context context = this.f33182a;
        super.putAndSave(context, str, z + "");
    }

    public void putAndSave(String str, long j) {
        Context context = this.f33182a;
        super.putAndSave(context, str, j + "");
    }

    public void putAndSave(String str, String str2) {
        super.putAndSave(this.f33182a, str, str2);
    }

    public void remove(String str) {
        super.remove(str);
        super.wipe(str);
    }
}
