package com.didi.dimina.container.secondparty.wsg;

import android.content.Context;
import com.didi.dimina.container.service.WsgService;
import com.didichuxing.omega.sdk.init.OmegaSDK;
import com.didichuxing.security.safecollector.WsgSecInfo;
import kotlin.Metadata;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0014\u0010\u0003\u001a\u0004\u0018\u00010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016J\u0012\u0010\u0007\u001a\u00020\b2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016J\u0014\u0010\t\u001a\u0004\u0018\u00010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016J\u0014\u0010\n\u001a\u0004\u0018\u00010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016J\u0014\u0010\u000b\u001a\u0004\u0018\u00010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016J\u0014\u0010\f\u001a\u0004\u0018\u00010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016J\u0014\u0010\r\u001a\u0004\u0018\u00010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016J\u0014\u0010\u000e\u001a\u0004\u0018\u00010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016J\n\u0010\u000f\u001a\u0004\u0018\u00010\u0004H\u0016J\u0014\u0010\u0010\u001a\u0004\u0018\u00010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016J\u0014\u0010\u0011\u001a\u0004\u0018\u00010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016J\u0012\u0010\u0012\u001a\u00020\b2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016J\u0012\u0010\u0013\u001a\u00020\b2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016J\u0012\u0010\u0014\u001a\u00020\u00152\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016J\u0012\u0010\u0016\u001a\u00020\u00152\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016¨\u0006\u0017"}, mo175978d2 = {"Lcom/didi/dimina/container/secondparty/wsg/DidiWsgServiceManager;", "Lcom/didi/dimina/container/service/WsgService;", "()V", "getAppName", "", "context", "Landroid/content/Context;", "getAppVersionCode", "", "getAppVersionName", "getBatteryLevel", "getBrand", "getDeviceId", "getModel", "getNetworkType", "getOAID", "getOsVersion", "getPackageName", "getScreenHeight", "getScreenWidth", "isBackground", "", "isDebug", "2party-impl_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
/* compiled from: DidiWsgServiceManager.kt */
public final class DidiWsgServiceManager implements WsgService {
    public String getOAID() {
        return OmegaSDK.getOAID();
    }

    public String getAppName(Context context) {
        return WsgSecInfo.appName(context);
    }

    public String getPackageName(Context context) {
        return WsgSecInfo.packageName(context);
    }

    public int getAppVersionCode(Context context) {
        return WsgSecInfo.appVersionCode(context);
    }

    public String getAppVersionName(Context context) {
        return WsgSecInfo.appVersionName(context);
    }

    public String getOsVersion(Context context) {
        return WsgSecInfo.osVersion(context);
    }

    public String getModel(Context context) {
        return WsgSecInfo.model(context);
    }

    public String getBrand(Context context) {
        return WsgSecInfo.brand(context);
    }

    public String getDeviceId(Context context) {
        return WsgSecInfo.customId(context);
    }

    public String getNetworkType(Context context) {
        return WsgSecInfo.networkType(context);
    }

    public boolean isDebug(Context context) {
        return WsgSecInfo.isDebugBoolean(context);
    }

    public boolean isBackground(Context context) {
        return WsgSecInfo.isBackgroundBoolean(context);
    }

    public String getBatteryLevel(Context context) {
        return WsgSecInfo.batteryLevel(context);
    }

    public int getScreenWidth(Context context) {
        return WsgSecInfo.screenWidth();
    }

    public int getScreenHeight(Context context) {
        return WsgSecInfo.screenHeight();
    }
}
