package com.didi.sdk.p154ms.gms.p156ad;

import android.content.Context;
import com.didi.sdk.p154ms.common.utils.LogUtil;
import com.didi.sdk.p154ms.gms.common.GMSType;
import com.didi.sdk.p154ms.p155ad.IAdOperation;
import com.didichuxing.foundation.spi.annotation.ServiceProvider;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;

@ServiceProvider(alias = "GMS", value = {IAdOperation.class})
/* renamed from: com.didi.sdk.ms.gms.ad.GMSAdOperation */
public class GMSAdOperation extends GMSType implements IAdOperation {
    private static final String TAG = GMSAdOperation.class.getSimpleName();

    public String getAdvertisingId(Context context) {
        try {
            return AdvertisingIdClient.getAdvertisingIdInfo(context.getApplicationContext()).getId();
        } catch (Exception e) {
            e.printStackTrace();
            String str = TAG;
            LogUtil.m26098e(str, "getAdvertisingId : exception = " + e);
            return "";
        }
    }

    public boolean isLimitAdTrackingEnabled(Context context) throws Exception {
        try {
            return AdvertisingIdClient.getAdvertisingIdInfo(context.getApplicationContext()).isLimitAdTrackingEnabled();
        } catch (Exception e) {
            e.printStackTrace();
            String str = TAG;
            LogUtil.m26098e(str, "getAdvertisingId : exception = " + e);
            throw new Exception(e);
        }
    }
}
