package com.didi.dimina.container.bridge;

import com.didi.dimina.container.DMMina;
import com.didi.dimina.container.bundle.bean.BundleConfig;
import com.didi.dimina.container.messager.MessageWrapperBuilder;
import com.didi.dimina.container.util.JSONUtil;
import com.didi.dimina.container.util.LogUtil;
import com.didi.dimina.container.util.VersionUtil;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\u000f\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u001a\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rR\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\u0004¨\u0006\u000f"}, mo175978d2 = {"Lcom/didi/dimina/container/bridge/ForceUpdateSubJSBridge;", "", "mDmMina", "Lcom/didi/dimina/container/DMMina;", "(Lcom/didi/dimina/container/DMMina;)V", "getMDmMina", "()Lcom/didi/dimina/container/DMMina;", "setMDmMina", "applyUpdate", "", "obj", "Lorg/json/JSONObject;", "callback", "Lcom/didi/dimina/container/bridge/base/CallbackFunction;", "Companion", "container_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
/* compiled from: ForceUpdateSubJSBridge.kt */
public final class ForceUpdateSubJSBridge {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String TAG = "ForceUpdateSubJSBridge";

    /* renamed from: a */
    private DMMina f16570a;

    @JvmStatic
    public static final JSONObject generateNotifyJson(String str, Integer num) {
        return Companion.generateNotifyJson(str, num);
    }

    @JvmStatic
    public static final void notifyBundleManager(DMMina dMMina) {
        Companion.notifyBundleManager(dMMina);
    }

    public ForceUpdateSubJSBridge(DMMina dMMina) {
        Intrinsics.checkParameterIsNotNull(dMMina, "mDmMina");
        this.f16570a = dMMina;
        LogUtil.m13412i(TAG, "ForceUpdateSubJSBridge init");
    }

    public final DMMina getMDmMina() {
        return this.f16570a;
    }

    public final void setMDmMina(DMMina dMMina) {
        Intrinsics.checkParameterIsNotNull(dMMina, "<set-?>");
        this.f16570a = dMMina;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x000f, code lost:
        r4 = r4.getCallbackConfig();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void applyUpdate(org.json.JSONObject r3, com.didi.dimina.container.bridge.base.CallbackFunction r4) {
        /*
            r2 = this;
            java.lang.String r3 = "ForceUpdateSubJSBridge"
            java.lang.String r4 = "enter applyUpdate()"
            com.didi.dimina.container.util.LogUtil.iRelease(r3, r4)
            com.didi.dimina.container.DMMina r4 = r2.f16570a
            com.didi.dimina.container.DMConfig r4 = r4.getConfig()
            if (r4 == 0) goto L_0x001a
            com.didi.dimina.container.DMConfig$CallBackConfig r4 = r4.getCallbackConfig()
            if (r4 == 0) goto L_0x001a
            com.didi.dimina.container.DMConfig$ReLaunchCallback r4 = r4.getRelaunchCallback()
            goto L_0x001b
        L_0x001a:
            r4 = 0
        L_0x001b:
            if (r4 == 0) goto L_0x004d
            java.lang.String r0 = "applyUpdate start"
            com.didi.dimina.container.util.LogUtil.iRelease(r3, r0)
            com.didi.dimina.container.DMMina r0 = r2.f16570a     // Catch:{ Exception -> 0x0028 }
            r4.relaunch(r0)     // Catch:{ Exception -> 0x0028 }
            goto L_0x0047
        L_0x0028:
            r4 = move-exception
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "dimina relaunch 发生异常:"
            r0.append(r1)
            r1 = r4
            java.lang.Throwable r1 = (java.lang.Throwable) r1
            java.lang.String r1 = android.util.Log.getStackTraceString(r1)
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            com.didi.dimina.container.util.LogUtil.eRelease(r3, r0)
            r4.printStackTrace()
        L_0x0047:
            java.lang.String r4 = "applyUpdate end"
            com.didi.dimina.container.util.LogUtil.iRelease(r3, r4)
            goto L_0x0052
        L_0x004d:
            java.lang.String r4 = "relaunch 没有设置, 所以 applyUpdate不生效"
            com.didi.dimina.container.util.LogUtil.wRelease(r3, r4)
        L_0x0052:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.dimina.container.bridge.ForceUpdateSubJSBridge.applyUpdate(org.json.JSONObject, com.didi.dimina.container.bridge.base.CallbackFunction):void");
    }

    @Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J!\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00042\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tH\u0007¢\u0006\u0002\u0010\nJ\u0012\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u000f"}, mo175978d2 = {"Lcom/didi/dimina/container/bridge/ForceUpdateSubJSBridge$Companion;", "", "()V", "TAG", "", "generateNotifyJson", "Lorg/json/JSONObject;", "event", "strategy", "", "(Ljava/lang/String;Ljava/lang/Integer;)Lorg/json/JSONObject;", "notifyBundleManager", "", "mina", "Lcom/didi/dimina/container/DMMina;", "container_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
    /* compiled from: ForceUpdateSubJSBridge.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final void notifyBundleManager(DMMina dMMina) {
            if (dMMina != null && !dMMina.isRelease()) {
                BundleConfig jsAppBundleConfig = dMMina.getJsAppBundleConfig();
                BundleConfig jsSdkBundleConfig = dMMina.getJsSdkBundleConfig();
                BundleConfig jsUpdateAppBundleConfig = dMMina.getJsUpdateAppBundleConfig();
                BundleConfig jsUpdateSdkBundleConfig = dMMina.getJsUpdateSdkBundleConfig();
                int i = jsUpdateAppBundleConfig != null ? jsUpdateAppBundleConfig.updateStrategy : 0;
                if (jsUpdateAppBundleConfig == null || jsUpdateSdkBundleConfig == null) {
                    LogUtil.iRelease(ForceUpdateSubJSBridge.TAG, "dimina notifyBundleManager() updatefail 更新失败");
                    dMMina.getMessageTransfer().sendMessageToServiceFromNative("onUpdateStatusChange", new MessageWrapperBuilder().data(generateNotifyJson$default(this, "updatefail", (Integer) null, 2, (Object) null)).build());
                    return;
                }
                int compareVersion = VersionUtil.compareVersion(jsUpdateAppBundleConfig.versionCode, jsAppBundleConfig.versionCode);
                int compareVersion2 = VersionUtil.compareVersion(jsUpdateSdkBundleConfig.versionCode, jsSdkBundleConfig.versionCode);
                if (compareVersion > 0 || compareVersion2 > 0) {
                    LogUtil.iRelease(ForceUpdateSubJSBridge.TAG, "notifyBundleManager() updateready，需要强制更新");
                    dMMina.getMessageTransfer().sendMessageToServiceFromNative("onUpdateStatusChange", new MessageWrapperBuilder().data(generateNotifyJson("updateready", Integer.valueOf(i))).build());
                    return;
                }
                LogUtil.iRelease(ForceUpdateSubJSBridge.TAG, "notifyBundleManager() noupdate 不需要更新 ");
                dMMina.getMessageTransfer().sendMessageToServiceFromNative("onUpdateStatusChange", new MessageWrapperBuilder().data(generateNotifyJson$default(this, "noupdate", (Integer) null, 2, (Object) null)).build());
            }
        }

        public static /* synthetic */ JSONObject generateNotifyJson$default(Companion companion, String str, Integer num, int i, Object obj) {
            if ((i & 2) != 0) {
                num = null;
            }
            return companion.generateNotifyJson(str, num);
        }

        @JvmStatic
        public final JSONObject generateNotifyJson(String str, Integer num) {
            Intrinsics.checkParameterIsNotNull(str, "event");
            JSONObject jSONObject = new JSONObject();
            JSONUtil.put(jSONObject, "event", (Object) str);
            if (num != null) {
                JSONUtil.put(jSONObject, "strategy", num.intValue());
            }
            LogUtil.iRelease(ForceUpdateSubJSBridge.TAG, "这里返回的数据是: " + jSONObject);
            return jSONObject;
        }
    }
}
