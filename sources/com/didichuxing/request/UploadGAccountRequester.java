package com.didichuxing.request;

import android.app.Activity;
import android.os.Build;
import com.didi.dimina.container.secondparty.jsmodule.jsbridge.websocket.DMWebSocketListener;
import com.didi.sdk.push.ServerParam;
import com.didi.soda.customer.biz.popdialog.AppsFlyerHelperKt;
import com.didichuxing.upgrade.UpgradeConfig;
import com.didichuxing.util.UpgradeSp;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\b\u001a\u00020\u0003H\u0002J\u0006\u0010\t\u001a\u00020\nR\u000e\u0010\u0007\u001a\u00020\u0003XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, mo175978d2 = {"Lcom/didichuxing/request/UploadGAccountRequester;", "Lcom/didichuxing/request/UpgradeBaseRequest;", "googleAccount", "", "joinPlan", "", "(Ljava/lang/String;I)V", "TAG", "getParam", "request", "", "upgrade_release"}, mo175979k = 1, mo175980mv = {1, 1, 15})
/* compiled from: UploadGAccountRequester.kt */
public final class UploadGAccountRequester extends UpgradeBaseRequest {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public final String f48504a = "UploadGAccountRequester";

    /* renamed from: b */
    private final String f48505b;

    /* renamed from: c */
    private final int f48506c;

    public UploadGAccountRequester(String str, int i) {
        Intrinsics.checkParameterIsNotNull(str, "googleAccount");
        this.f48505b = str;
        this.f48506c = i;
    }

    public final void request() {
        new UploadGAccountRequester$request$1(this, "UploadGAccount request").start();
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public final String m34791a() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("model", Build.MODEL);
        jSONObject.put("osVersion", Build.VERSION.RELEASE);
        jSONObject.put("account", this.f48505b);
        UpgradeConfig.IConfig iConfig = UpgradeConfig.iConfig;
        Intrinsics.checkExpressionValueIsNotNull(iConfig, "UpgradeConfig.iConfig");
        Activity updateContext = iConfig.getUpdateContext();
        jSONObject.put(AppsFlyerHelperKt.appLinkAppName, updateContext != null ? updateContext.getPackageName() : null);
        jSONObject.put(ServerParam.PARAM_DDRIVER_OSTYPE, "android");
        UpgradeConfig.IConfig iConfig2 = UpgradeConfig.iConfig;
        Intrinsics.checkExpressionValueIsNotNull(iConfig2, "UpgradeConfig.iConfig");
        jSONObject.put("cityId", iConfig2.getCityId());
        UpgradeConfig.IConfig iConfig3 = UpgradeConfig.iConfig;
        Intrinsics.checkExpressionValueIsNotNull(iConfig3, "UpgradeConfig.iConfig");
        jSONObject.put("countryCode", iConfig3.getCountryCode());
        jSONObject.put("joinedPlan", this.f48506c);
        UpgradeConfig.IConfig iConfig4 = UpgradeConfig.iConfig;
        Intrinsics.checkExpressionValueIsNotNull(iConfig4, "UpgradeConfig.iConfig");
        jSONObject.put("uid", iConfig4.getUid());
        jSONObject.put(DMWebSocketListener.KEY_TASK_ID, UpgradeSp.getTaskId$default(UpgradeSp.Companion.getInstance(), 0, 1, (Object) null));
        jSONObject.put("versionId", UpgradeSp.getVersionId$default(UpgradeSp.Companion.getInstance(), 0, 1, (Object) null));
        String jSONObject2 = jSONObject.toString();
        Intrinsics.checkExpressionValueIsNotNull(jSONObject2, "json.toString()");
        return jSONObject2;
    }
}
