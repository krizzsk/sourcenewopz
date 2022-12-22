package com.didi.sdk.p146ad.operation;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Build;
import com.android.didi.bfflib.Bff;
import com.android.didi.bfflib.IBffProxy;
import com.didi.sdk.apm.SystemUtils;
import com.didi.sdk.bff.BffConstants;
import com.didi.sdk.p146ad.AdUtil;
import com.didi.sdk.p146ad.model.AdParams;
import com.didi.sdk.sidebar.setup.mutilocale.MultiLocaleUtil;
import com.google.gson.JsonObject;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.osgi.framework.VersionRange;

@Metadata(mo175977d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0016\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J\b\u0010\b\u001a\u00020\tH\u0004J\b\u0010\n\u001a\u00020\u0004H\u0002J\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0004H\u0016J\u0016\u0010\u0010\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u0004¨\u0006\u0011"}, mo175978d2 = {"Lcom/didi/sdk/ad/operation/BaseAdOperation;", "", "()V", "getAppEventTypeByLogin", "", "context", "Landroid/content/Context;", "getAppId", "getTimeStamp", "", "getUserAgent", "handResponse", "", "dataJson", "Lcom/google/gson/JsonObject;", "appEventType", "request", "TheOneSDKGlobal_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* renamed from: com.didi.sdk.ad.operation.BaseAdOperation */
/* compiled from: BaseAdOperation.kt */
public class BaseAdOperation {
    public void handResponse(JsonObject jsonObject, String str) {
        Intrinsics.checkNotNullParameter(jsonObject, "dataJson");
        Intrinsics.checkNotNullParameter(str, AdParams.APP_EVENT_TYPE);
    }

    public final void request(Context context, String str) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(str, AdParams.APP_EVENT_TYPE);
        Map hashMap = new HashMap();
        hashMap.put("appId", m24675a(context));
        hashMap.put("lat", 0);
        hashMap.put("timestamp", Long.valueOf(getTimeStamp()));
        hashMap.put(AdParams.USER_AGENT, m24674a());
        hashMap.put(AdParams.APP_EVENT_TYPE, str);
        AdUtil.INSTANCE.setFirstOpen(false, context);
        AdUtil.INSTANCE.setDdlType(str);
        Bff.call(new IBffProxy.Ability.Builder(context, BffConstants.AbilityID.ABILITY_GET_REDIRECT_URL_BY_USER_EVENT).setParams(hashMap).setCallback(new BaseAdOperation$request$ability$1(this, str)).build());
    }

    /* renamed from: a */
    private final String m24675a(Context context) {
        try {
            ApplicationInfo applicationInfo = SystemUtils.getApplicationInfo(context.getPackageManager(), context.getPackageName(), 128);
            Intrinsics.checkNotNullExpressionValue(applicationInfo, "packageManager.getApplic…ageManager.GET_META_DATA)");
            String str = applicationInfo.packageName;
            Intrinsics.checkNotNullExpressionValue(str, "applicationInfo.packageName");
            return str;
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    /* access modifiers changed from: protected */
    public final long getTimeStamp() {
        return System.currentTimeMillis() / ((long) 1000);
    }

    /* renamed from: a */
    private final String m24674a() {
        String locale = MultiLocaleUtil.getLanguageModel().getLocale();
        return "AdMob/7.10.1 (Android " + Build.VERSION.RELEASE + "; " + locale + "; " + Build.BOARD + VersionRange.RIGHT_OPEN;
    }

    public String getAppEventTypeByLogin(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return AdUtil.INSTANCE.isFirstOpen(context) ? "first_open" : "session_start";
    }
}
