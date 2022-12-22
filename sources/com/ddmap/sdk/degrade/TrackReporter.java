package com.ddmap.sdk.degrade;

import com.didi.map.sdk.maprouter.global.PlatInfo;
import com.didiglobal.omegasdkadapter.OmegaSDKAdapter;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004J\u0006\u0010\u0005\u001a\u00020\u0004¨\u0006\u0006"}, mo175978d2 = {"Lcom/ddmap/sdk/degrade/TrackReporter;", "", "()V", "reportDegrade", "", "reportRestore", "Degrade_release"}, mo175979k = 1, mo175980mv = {1, 1, 13})
/* compiled from: TrackReporter.kt */
public final class TrackReporter {
    public static final TrackReporter INSTANCE = new TrackReporter();

    private TrackReporter() {
    }

    public final void reportDegrade() {
        Map hashMap = new HashMap();
        PlatInfo instance = PlatInfo.getInstance();
        Intrinsics.checkExpressionValueIsNotNull(instance, "PlatInfo.getInstance()");
        String clientVersion = instance.getClientVersion();
        Intrinsics.checkExpressionValueIsNotNull(clientVersion, "PlatInfo.getInstance().clientVersion");
        hashMap.put("app_version", clientVersion);
        PlatInfo instance2 = PlatInfo.getInstance();
        Intrinsics.checkExpressionValueIsNotNull(instance2, "PlatInfo.getInstance()");
        String countryCode = instance2.getCountryCode();
        Intrinsics.checkExpressionValueIsNotNull(countryCode, "PlatInfo.getInstance().countryCode");
        hashMap.put("country_code", countryCode);
        hashMap.put("os", "Android");
        hashMap.put("time", Long.valueOf(System.currentTimeMillis()));
        OmegaSDKAdapter.trackEvent("tech_global_navigator_degrade", (Map<String, Object>) hashMap);
    }

    public final void reportRestore() {
        Map hashMap = new HashMap();
        PlatInfo instance = PlatInfo.getInstance();
        Intrinsics.checkExpressionValueIsNotNull(instance, "PlatInfo.getInstance()");
        String clientVersion = instance.getClientVersion();
        Intrinsics.checkExpressionValueIsNotNull(clientVersion, "PlatInfo.getInstance().clientVersion");
        hashMap.put("app_version", clientVersion);
        PlatInfo instance2 = PlatInfo.getInstance();
        Intrinsics.checkExpressionValueIsNotNull(instance2, "PlatInfo.getInstance()");
        String countryCode = instance2.getCountryCode();
        Intrinsics.checkExpressionValueIsNotNull(countryCode, "PlatInfo.getInstance().countryCode");
        hashMap.put("country_code", countryCode);
        hashMap.put("os", "Android");
        hashMap.put("time", Long.valueOf(System.currentTimeMillis()));
        OmegaSDKAdapter.trackEvent("tech_global_navigator_degrade_stop", (Map<String, Object>) hashMap);
    }
}
