package com.didi.component.homedestination.net;

import android.content.Context;
import com.android.didi.bfflib.Bff;
import com.android.didi.bfflib.IBffProxy;
import com.didi.component.business.bff.callback_adapter.BffTravelCallbackAdapter;
import com.didi.component.business.util.NationComponentDataUtil;
import com.didi.travel.psnger.common.net.base.BaseRequest;
import com.didi.travel.psnger.common.net.base.ResponseListener;
import com.didi.travel.psnger.model.response.SafetyTrainCardInfo;
import java.util.HashMap;
import java.util.Map;

public class HomeSafetyTrainRequest extends BaseRequest {

    /* renamed from: a */
    private Context f14103a;

    public HomeSafetyTrainRequest(Context context) {
        this.f14103a = context;
    }

    public void getSafetyTrainRequest(Map map, ResponseListener<SafetyTrainCardInfo> responseListener) {
        if (!NationComponentDataUtil.isLoginNow()) {
            SafetyTrainCardInfo safetyTrainCardInfo = new SafetyTrainCardInfo();
            safetyTrainCardInfo.errno = 101;
            safetyTrainCardInfo.errmsg = "Login expired";
            responseListener.onFinish(safetyTrainCardInfo);
            return;
        }
        if (map == null) {
            map = new HashMap();
        }
        map.put("passenger_unAvailableService", "");
        Bff.call(new IBffProxy.Ability.Builder(this.f14103a, "expo/passenger").setParams(map).setCallback(new BffTravelCallbackAdapter(responseListener, this.f14103a, true)).build());
    }
}
