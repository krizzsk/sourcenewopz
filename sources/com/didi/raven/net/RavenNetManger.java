package com.didi.raven.net;

import android.content.Context;
import java.util.List;
import java.util.Map;

public abstract class RavenNetManger {
    public abstract void init(Context context);

    public abstract boolean isInit();

    public abstract void post(String str, Map<String, Object> map);

    public abstract void postPool(String str);

    public abstract void postPool(List<Map<String, Object>> list);
}
