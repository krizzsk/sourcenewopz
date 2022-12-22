package com.didichuxing.bigdata.p173dp.locsdk.setting;

/* renamed from: com.didichuxing.bigdata.dp.locsdk.setting.LocationSettingRequestCallback */
public interface LocationSettingRequestCallback {

    /* renamed from: com.didichuxing.bigdata.dp.locsdk.setting.LocationSettingRequestCallback$-CC  reason: invalid class name */
    public final /* synthetic */ class CC {
        public static void $default$onFailed(LocationSettingRequestCallback locationSettingRequestCallback, boolean z) {
        }
    }

    void onFailed();

    void onFailed(boolean z);

    void onSuccess();
}
