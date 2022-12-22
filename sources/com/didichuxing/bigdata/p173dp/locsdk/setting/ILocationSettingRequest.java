package com.didichuxing.bigdata.p173dp.locsdk.setting;

import android.content.Context;

/* renamed from: com.didichuxing.bigdata.dp.locsdk.setting.ILocationSettingRequest */
public interface ILocationSettingRequest {
    public static final int LOCATION_SETTING_REQUEST_CODE = 4368;

    void checkSettingRequest(Context context, LocationSettingRequestCallback locationSettingRequestCallback);
}
