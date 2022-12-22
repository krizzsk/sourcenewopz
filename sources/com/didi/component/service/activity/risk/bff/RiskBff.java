package com.didi.component.service.activity.risk.bff;

import android.content.Context;
import com.android.didi.bfflib.Bff;
import com.android.didi.bfflib.IBffProxy;
import com.didi.component.business.constant.BffConstants;
import com.didi.travel.psnger.common.net.base.ParamKeys;
import com.didichuxing.foundation.rpc.RpcService;
import com.google.gson.JsonObject;
import java.util.HashMap;

public class RiskBff {
    public static void getRiskVerifyList(Context context, String str, RpcService.Callback<JsonObject> callback) {
        HashMap hashMap = new HashMap();
        hashMap.put(ParamKeys.PARAM_RISK_VERIFY_MODE, str);
        Bff.call(new IBffProxy.Ability.Builder(context, BffConstants.AbilityID.ABILITY_RISK_VERIFY_LIST).setParams(hashMap).setCallback(callback).build());
    }
}
