package com.didi.dimina.starbox.module.jsbridge;

import android.text.TextUtils;
import com.didi.dimina.container.DMMina;
import com.didi.dimina.container.Dimina;
import com.didi.dimina.container.bean.Constant;
import com.didi.dimina.container.bridge.base.CallbackFunction;
import com.didi.dimina.container.bundle.BundleManager;
import com.didi.dimina.container.bundle.BundleManagerStrategy;
import com.didi.dimina.container.bundle.LocalBundleMangerStrategy;
import com.didi.dimina.container.bundle.RemoteBundleMangerStrategy;
import com.didi.dimina.container.bundle.bean.AppInfo;
import com.didi.dimina.container.debug.DevModeManager;
import com.didi.dimina.container.mina.DMMinaPool;
import com.didi.dimina.container.secondparty.bundle.DiminaHelper;
import com.didi.dimina.container.secondparty.bundle.strategy.ReleaseBundleMangerStrategy;
import com.didi.dimina.container.util.CallBackUtil;
import com.didi.dimina.container.util.HttpUtil;
import com.didi.dimina.container.util.JSONUtil;
import com.didi.dimina.container.util.LogUtil;
import org.json.JSONArray;
import org.json.JSONObject;

public class DMMinaInfoSubJSBridge {

    /* renamed from: a */
    private static final String f18001a = "DMMinaInfoSubJSBridge";

    DMMinaInfoSubJSBridge() {
        LogUtil.m13411i("VersionInfoSubJSBridge init");
    }

    public void getDMMinaInfo(JSONObject jSONObject, CallbackFunction callbackFunction) {
        CallbackFunction callbackFunction2 = callbackFunction;
        LogUtil.m13411i("DMMinaInfoSubJSBridge getDMMinaInfo");
        String str = "";
        String optString = jSONObject.optString("appId", str);
        if (TextUtils.isEmpty(optString)) {
            CallBackUtil.onFail("appId 为空", callbackFunction2);
            return;
        }
        DMMina findDMMinaByAppId = DMMinaPool.findDMMinaByAppId(optString);
        if (findDMMinaByAppId == null) {
            CallBackUtil.onFail("小程序实例不存在", callbackFunction2);
            return;
        }
        JSONArray jSONArray = new JSONArray();
        JSONObject jSONObject2 = new JSONObject();
        JSONUtil.put(jSONObject2, "name", (Object) "小程序ID");
        JSONUtil.put(jSONObject2, "desc", findDMMinaByAppId.getMinaIndex());
        JSONUtil.put(jSONArray, jSONObject2);
        BundleManagerStrategy bundleManagerStrategy = findDMMinaByAppId.getConfig().getLaunchConfig().getBundleManagerStrategy();
        if (bundleManagerStrategy instanceof ReleaseBundleMangerStrategy) {
            str = "线上模式";
        } else if (bundleManagerStrategy instanceof LocalBundleMangerStrategy) {
            str = "底包模式";
        } else if (bundleManagerStrategy instanceof RemoteBundleMangerStrategy) {
            str = DevModeManager.isGiftDevModel(optString) ? "预览模式" : "IP直连模式";
        } else {
            LogUtil.eRelease(f18001a, "异常Case，bundleStrategy 没有匹配到对应值: " + bundleManagerStrategy);
        }
        JSONObject jSONObject3 = new JSONObject();
        JSONUtil.put(jSONObject3, "name", (Object) "小程序打开方式");
        JSONUtil.put(jSONObject3, "desc", (Object) str);
        JSONUtil.put(jSONArray, jSONObject3);
        try {
            String splitPath = HttpUtil.splitPath(findDMMinaByAppId.getCurNavigator().getCurrentPage().getPage().getUrl());
            JSONObject jSONObject4 = new JSONObject();
            JSONUtil.put(jSONObject4, "name", (Object) "路由");
            JSONUtil.put(jSONObject4, "desc", (Object) splitPath);
            JSONUtil.put(jSONArray, jSONObject4);
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            JSONObject jSONObject5 = new JSONObject();
            AppInfo.ModuleInfo appPackageInfo = BundleManager.getInstance().getAppPackageInfo(findDMMinaByAppId, "app");
            if (appPackageInfo == null || TextUtils.isEmpty(appPackageInfo.version)) {
                JSONUtil.put(jSONObject5, "name", (Object) "JS业务代码版本号");
                JSONUtil.put(jSONObject5, "desc", (Object) "空");
            } else {
                JSONUtil.put(jSONObject5, "name", (Object) "JS业务代码版本号");
                JSONUtil.put(jSONObject5, "desc", (Object) appPackageInfo.versionName + "(" + appPackageInfo.version + ")");
            }
            JSONUtil.put(jSONArray, jSONObject5);
        } catch (Exception unused) {
            JSONObject jSONObject6 = new JSONObject();
            JSONUtil.put(jSONObject6, "name", (Object) "JS业务代码版本号");
            JSONUtil.put(jSONObject6, "desc", (Object) "空");
            JSONUtil.put(jSONArray, jSONObject6);
        }
        try {
            JSONObject jSONObject7 = new JSONObject();
            AppInfo appInfo = DiminaHelper.getAppInfo(findDMMinaByAppId, DiminaHelper.getJsSdkId(findDMMinaByAppId), findDMMinaByAppId.getJsSdkBundleConfig());
            if (appInfo == null || TextUtils.isEmpty(appInfo.f16786id)) {
                JSONUtil.put(jSONObject7, "name", (Object) "JS基础库ID");
                JSONUtil.put(jSONObject7, "desc", (Object) "空");
            } else {
                JSONUtil.put(jSONObject7, "name", (Object) "JS基础库ID");
                JSONUtil.put(jSONObject7, "desc", (Object) appInfo.f16786id);
            }
            JSONUtil.put(jSONArray, jSONObject7);
            JSONObject jSONObject8 = new JSONObject();
            AppInfo.ModuleInfo sDKPackageInfo = BundleManager.getInstance().getSDKPackageInfo(findDMMinaByAppId, Constant.BundleConstant.SDK_MODULE_NAME);
            if (sDKPackageInfo == null || TextUtils.isEmpty(sDKPackageInfo.version)) {
                JSONUtil.put(jSONObject8, "name", (Object) "JS基础库版本号");
                JSONUtil.put(jSONObject8, "desc", (Object) "空");
            } else {
                JSONUtil.put(jSONObject8, "name", (Object) "JS基础库版本号");
                JSONUtil.put(jSONObject8, "desc", (Object) sDKPackageInfo.versionName + "(" + sDKPackageInfo.version + ")");
            }
            JSONUtil.put(jSONArray, jSONObject8);
        } catch (Exception unused2) {
            JSONObject jSONObject9 = new JSONObject();
            JSONUtil.put(jSONObject9, "name", (Object) "JS基础库ID");
            JSONUtil.put(jSONObject9, "desc", (Object) "空");
            JSONUtil.put(jSONArray, jSONObject9);
            JSONObject jSONObject10 = new JSONObject();
            JSONUtil.put(jSONObject10, "name", (Object) "JS基础库版本号");
            JSONUtil.put(jSONObject10, "desc", (Object) "空");
            JSONUtil.put(jSONArray, jSONObject10);
        }
        try {
            JSONObject jSONObject11 = new JSONObject();
            JSONUtil.put(jSONObject11, "name", (Object) "Native基础库版本号");
            JSONUtil.put(jSONObject11, "desc", (Object) Dimina.getVersion());
            JSONUtil.put(jSONArray, jSONObject11);
        } catch (Exception unused3) {
            JSONObject jSONObject12 = new JSONObject();
            JSONUtil.put(jSONObject12, "name", (Object) "Native基础库版本号");
            JSONUtil.put(jSONObject12, "desc", (Object) "空");
            JSONUtil.put(jSONArray, jSONObject12);
        }
        JSONObject jSONObject13 = new JSONObject();
        JSONUtil.put(jSONObject13, "data", (Object) jSONArray);
        CallBackUtil.onSuccess(jSONObject13, callbackFunction2);
    }
}
