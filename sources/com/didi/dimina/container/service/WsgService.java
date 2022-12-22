package com.didi.dimina.container.service;

import android.content.Context;
import kotlin.Metadata;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0014\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\u0012\u0010\u0006\u001a\u00020\u00072\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\u0014\u0010\b\u001a\u0004\u0018\u00010\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\u0014\u0010\t\u001a\u0004\u0018\u00010\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\u0014\u0010\n\u001a\u0004\u0018\u00010\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\u0014\u0010\u000b\u001a\u0004\u0018\u00010\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\u0014\u0010\f\u001a\u0004\u0018\u00010\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\u0014\u0010\r\u001a\u0004\u0018\u00010\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\n\u0010\u000e\u001a\u0004\u0018\u00010\u0003H&J\u0014\u0010\u000f\u001a\u0004\u0018\u00010\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\u0014\u0010\u0010\u001a\u0004\u0018\u00010\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\u0012\u0010\u0011\u001a\u00020\u00072\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\u0012\u0010\u0012\u001a\u00020\u00072\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\u0012\u0010\u0013\u001a\u00020\u00142\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\u0012\u0010\u0015\u001a\u00020\u00142\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&¨\u0006\u0016"}, mo175978d2 = {"Lcom/didi/dimina/container/service/WsgService;", "", "getAppName", "", "context", "Landroid/content/Context;", "getAppVersionCode", "", "getAppVersionName", "getBatteryLevel", "getBrand", "getDeviceId", "getModel", "getNetworkType", "getOAID", "getOsVersion", "getPackageName", "getScreenHeight", "getScreenWidth", "isBackground", "", "isDebug", "container_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
/* compiled from: WsgService.kt */
public interface WsgService {
    String getAppName(Context context);

    int getAppVersionCode(Context context);

    String getAppVersionName(Context context);

    String getBatteryLevel(Context context);

    String getBrand(Context context);

    String getDeviceId(Context context);

    String getModel(Context context);

    String getNetworkType(Context context);

    String getOAID();

    String getOsVersion(Context context);

    String getPackageName(Context context);

    int getScreenHeight(Context context);

    int getScreenWidth(Context context);

    boolean isBackground(Context context);

    boolean isDebug(Context context);
}
