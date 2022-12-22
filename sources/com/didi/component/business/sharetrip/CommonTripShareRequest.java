package com.didi.component.business.sharetrip;

import android.content.Context;
import com.didi.component.business.constant.HostConstants;
import com.didi.sdk.commonhttp.GeneralRequest;
import com.didi.travel.psnger.common.net.base.BaseRequest;
import com.didi.travel.psnger.common.net.base.ResponseListener;

public class CommonTripShareRequest extends BaseRequest {

    /* renamed from: a */
    private static CommonTripShareRequest f11350a;

    /* renamed from: b */
    private Context f11351b;

    public CommonTripShareRequest(Context context) {
        this.f11351b = context;
    }

    public static CommonTripShareRequest getInstance(Context context) {
        if (f11350a == null) {
            f11350a = new CommonTripShareRequest(context.getApplicationContext());
        }
        return f11350a;
    }

    public void getTripShareInfo(String str, int i, ResponseListener<CommonTripShareInfo> responseListener) {
        new GeneralRequest(this.f11351b, HostConstants.getHostCommon()).getShareTripInfo(str, i, getRpcCallback(responseListener, new CommonTripShareInfo()));
    }
}
