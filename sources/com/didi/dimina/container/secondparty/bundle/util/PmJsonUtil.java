package com.didi.dimina.container.secondparty.bundle.util;

import android.text.TextUtils;
import com.didi.dimina.container.secondparty.bundle.bean.DMConfigBean;
import com.didi.dimina.container.util.LogUtil;
import com.google.gson.Gson;
import java.util.HashMap;
import java.util.Map;

public class PmJsonUtil {
    public static final String TAG = "Dimina-PM PmJsonUtil";

    /* renamed from: a */
    private static final Gson f17101a = new Gson();

    /* renamed from: b */
    private static final Map<String, DMConfigBean> f17102b = new HashMap();

    public static String toString(Object obj) {
        if (obj == null) {
            return null;
        }
        return f17101a.toJson(obj);
    }

    public static <T> T toObject(String str, Class<T> cls) {
        if (!TextUtils.isEmpty(str) && cls != null) {
            return f17101a.fromJson(str, cls);
        }
        return null;
    }

    public static DMConfigBean json2DmConfigBean(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (f17102b.containsKey(str)) {
            LogUtil.iRelease(TAG, "json序列化 获取到 map中的缓存值");
            return (DMConfigBean) f17102b.get(str).clone();
        }
        DMConfigBean dMConfigBean = (DMConfigBean) toObject(str, DMConfigBean.class);
        if (!(dMConfigBean == null || dMConfigBean.getAppModules() == null)) {
            for (DMConfigBean.AppModulesBean next : dMConfigBean.getAppModules()) {
                next.setVersion(dMConfigBean.getAppVersionCode());
                next.setVersionName(dMConfigBean.getAppVersionName());
            }
        }
        if (!(dMConfigBean == null || dMConfigBean.getSdkModule() == null)) {
            dMConfigBean.getSdkModule().setVersion(dMConfigBean.getSdkVersionCode());
            dMConfigBean.getSdkModule().setVersionName(dMConfigBean.getSdkVersionName());
        }
        f17102b.put(str, dMConfigBean);
        return dMConfigBean;
    }
}
