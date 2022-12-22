package com.didi.dimina.container.bridge.loading;

import android.content.Context;
import com.didi.dimina.container.DMMina;
import com.didi.dimina.container.bridge.base.CallbackFunction;
import com.didi.dimina.container.p106ui.loadpage.AbsLoadingManager;
import com.didi.dimina.container.util.CallBackUtil;
import com.didi.dimina.container.util.LogUtil;
import org.json.JSONObject;

public class LoadingSubJSBridge {
    public static BackupLoadingWindowManager sBackupPopupWindowManager;

    /* renamed from: a */
    private AbsLoadingManager f16741a;

    /* renamed from: b */
    private final Context f16742b;

    /* renamed from: c */
    private final DMMina f16743c;

    public interface BackupLoadingWindowManager {
        void hideLoading(Context context, JSONObject jSONObject, CallbackFunction callbackFunction);

        void showLoading(Context context, JSONObject jSONObject, CallbackFunction callbackFunction);
    }

    public LoadingSubJSBridge(Context context, DMMina dMMina) {
        this.f16742b = context;
        this.f16743c = dMMina;
        LogUtil.m13411i("LoadingSubJSBridge init");
    }

    public void showLoading(JSONObject jSONObject, CallbackFunction callbackFunction) {
        LogUtil.m13411i("LoadingSubJSBridge showLoading: " + jSONObject);
        BackupLoadingWindowManager backupLoadingWindowManager = sBackupPopupWindowManager;
        if (backupLoadingWindowManager != null) {
            backupLoadingWindowManager.showLoading(this.f16742b, jSONObject, callbackFunction);
        } else if (jSONObject.has("title")) {
            String optString = jSONObject.optString("title");
            AbsLoadingManager absLoadingManager = this.f16741a;
            if (absLoadingManager != null) {
                absLoadingManager.dismiss();
                this.f16741a = null;
            }
            DMMina dMMina = this.f16743c;
            if (dMMina == null || dMMina.getConfig() == null || this.f16743c.getConfig().getUIConfig().getCommonLoadingViewClazz() == null) {
                this.f16741a = new DefaultLoadingManager(this.f16742b, optString, this.f16743c);
            } else {
                this.f16741a = new CustomLoadingManager(this.f16742b, optString, this.f16743c);
            }
            this.f16741a.show();
            CallBackUtil.onSuccess(callbackFunction);
        } else {
            CallBackUtil.onFail("参数出错", callbackFunction);
        }
    }

    public void hideLoading(JSONObject jSONObject, CallbackFunction callbackFunction) {
        LogUtil.m13411i("LoadingSubJSBridge hideLoading: " + jSONObject);
        BackupLoadingWindowManager backupLoadingWindowManager = sBackupPopupWindowManager;
        if (backupLoadingWindowManager != null) {
            backupLoadingWindowManager.hideLoading(this.f16742b, jSONObject, callbackFunction);
            return;
        }
        AbsLoadingManager absLoadingManager = this.f16741a;
        if (absLoadingManager != null) {
            absLoadingManager.dismiss();
            this.f16741a = null;
        }
        CallBackUtil.onSuccess(callbackFunction);
    }
}
