package com.didi.dimina.starbox.module.jsbridge;

import android.content.Context;
import android.text.TextUtils;
import com.didi.dimina.container.DMMina;
import com.didi.dimina.container.bridge.base.CallbackFunction;
import com.didi.dimina.container.jsengine.JSEngine;
import com.didi.dimina.container.mina.DMMinaPool;
import com.didi.dimina.container.util.CallBackUtil;
import com.didi.dimina.container.util.LogUtil;
import com.didi.sdk.util.ToastUtil;
import org.json.JSONObject;

public class GCSubJSBridge {

    /* renamed from: a */
    private final Context f18006a;

    GCSubJSBridge(Context context) {
        LogUtil.m13411i("GCSubJSBridge init");
        this.f18006a = context;
    }

    /* renamed from: gc */
    public void mo57080gc(JSONObject jSONObject, CallbackFunction callbackFunction) {
        LogUtil.m13411i("GCSubJSBridge GC");
        LogUtil.m13411i("PageInfoSubJSBridge getPageInfo");
        String optString = jSONObject.optString("appId", "");
        if (TextUtils.isEmpty(optString)) {
            CallBackUtil.onFail("appId 为空", callbackFunction);
            return;
        }
        DMMina findDMMinaByAppId = DMMinaPool.findDMMinaByAppId(optString);
        if (findDMMinaByAppId == null) {
            CallBackUtil.onFail("小程序实例不存在", callbackFunction);
            return;
        }
        if (findDMMinaByAppId.getJSEngine() != null) {
            findDMMinaByAppId.getJSEngine().onLowMemory();
            findDMMinaByAppId.getJSEngine().notifyMemoryPress(JSEngine.PressLevel.CRITICAL);
        }
        ToastUtil.show(this.f18006a, (CharSequence) "小程序触发GC");
        CallBackUtil.onSuccess(callbackFunction);
    }
}
