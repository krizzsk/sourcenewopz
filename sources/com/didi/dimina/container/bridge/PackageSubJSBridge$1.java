package com.didi.dimina.container.bridge;

import com.didi.dimina.container.bean.Constant;
import com.didi.dimina.container.bridge.base.CallbackFunction;
import com.didi.dimina.container.bundle.BundleManagerStrategy;
import com.didi.dimina.container.bundle.bean.AppInfo;
import com.didi.dimina.container.util.CallBackUtil;
import com.didi.dimina.container.util.LogUtil;
import com.didi.dimina.container.util.TimeUtil;
import com.didi.dimina.container.util.TraceUtil;

class PackageSubJSBridge$1 implements BundleManagerStrategy.SubpackageInfoCallback {
    final /* synthetic */ C7434d this$0;
    final /* synthetic */ CallbackFunction val$callback;
    final /* synthetic */ String val$finalPackageName;
    final /* synthetic */ String val$packageAppService;
    final /* synthetic */ long val$startTime;

    PackageSubJSBridge$1(C7434d dVar, long j, CallbackFunction callbackFunction, String str, String str2) {
        this.this$0 = dVar;
        this.val$startTime = j;
        this.val$callback = callbackFunction;
        this.val$finalPackageName = str;
        this.val$packageAppService = str2;
    }

    public void callback(int i, AppInfo.ModuleInfo moduleInfo) {
        if (i == 0) {
            this.this$0.f16713c.getPerformance().appendStartSubPackageLoadTime(TimeUtil.currentNanoMillis() - this.val$startTime);
            if (moduleInfo != null) {
                LogUtil.iRelease(InternalJSMethod.LOAD_JS_FILE_TO_DATA_THREAD, "加载分包成功 packageName:" + moduleInfo.moduleName + " version:" + moduleInfo.version);
            }
            this.this$0.m12382a(this.val$callback, this.val$finalPackageName, this.val$packageAppService);
            return;
        }
        CallBackUtil.onFail("分包" + this.val$finalPackageName + this.val$packageAppService + "下载失败", this.val$callback);
        this.this$0.f16714d.dismiss();
        StringBuilder sb = new StringBuilder();
        sb.append("加载分包失败 errCode:");
        sb.append(i);
        LogUtil.iRelease(InternalJSMethod.LOAD_JS_FILE_TO_DATA_THREAD, sb.toString());
        int minaIndex = this.this$0.f16713c.getMinaIndex();
        TraceUtil.trackEventCoreDotting(minaIndex, Constant.CORE_DOTTING.PACKAGE_LOAD_JS_FILE_TO_DATA_THREAD_FAILED, "errCode: " + i);
    }
}
