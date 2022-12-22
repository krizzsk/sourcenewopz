package com.didi.component.common.config;

import android.content.Context;
import com.android.didi.bfflib.Bff;
import com.android.didi.bfflib.IBffProxy;
import com.didi.component.business.constant.BffConstants;
import com.didi.component.business.util.GlobalSPUtil;
import com.didi.component.common.cache.CacheManager;
import com.didi.component.common.model.DynamicConfigModel;
import com.didi.component.common.model.DynamicConfigModelList;
import com.didi.sdk.oneconf.OneConfStore;
import com.didi.travel.psnger.common.net.base.ParamKeys;
import com.didichuxing.foundation.rpc.RpcService;
import com.google.gson.JsonObject;
import java.io.IOException;
import java.util.HashMap;

public class DynamicConfigManager {
    public static final String FUNCTION_KEY_PRICING_MODE = "pricing_mode";
    public static final String FUNCTION_KEY_TIP = "tip";

    /* renamed from: a */
    private static DynamicConfigManager f11487a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public DynamicConfigModelList f11488b;

    private DynamicConfigManager() {
    }

    public static DynamicConfigManager getInstance() {
        if (f11487a == null) {
            synchronized (CacheManager.class) {
                if (f11487a == null) {
                    f11487a = new DynamicConfigManager();
                }
            }
        }
        return f11487a;
    }

    public void requestConfig(final Context context) {
        HashMap hashMap = new HashMap();
        hashMap.put(ParamKeys.PARAM_FUNCTION_LIST, m7765a("tip", FUNCTION_KEY_PRICING_MODE));
        hashMap.put("coupon_id", Integer.valueOf(OneConfStore.getInstance().getCountryId()));
        Bff.call(new IBffProxy.Ability.Builder(context, BffConstants.AbilityID.ABILITY_DYNAMIC_CONFIG).setParams(hashMap).setCallback(new RpcService.Callback<JsonObject>() {
            public void onSuccess(JsonObject jsonObject) {
                DynamicConfigModelList unused = DynamicConfigManager.this.f11488b = new DynamicConfigModelList();
                DynamicConfigManager.this.f11488b.parse(jsonObject.toString());
                if (DynamicConfigManager.this.f11488b.errno == 0) {
                    DynamicConfigManager.this.m7766a(context, jsonObject.toString());
                } else {
                    DynamicConfigManager.this.f11488b.parse(DynamicConfigManager.this.m7763a(context));
                }
            }

            public void onFailure(IOException iOException) {
                DynamicConfigModelList unused = DynamicConfigManager.this.f11488b = new DynamicConfigModelList();
                DynamicConfigManager.this.f11488b.parse(DynamicConfigManager.this.m7763a(context));
            }
        }).build());
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public String m7763a(Context context) {
        return GlobalSPUtil.getDynamicConfig(context);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m7766a(Context context, String str) {
        GlobalSPUtil.setDynamicConfig(context, str);
    }

    /* renamed from: a */
    private String m7765a(String... strArr) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < strArr.length; i++) {
            if (i > 0) {
                sb.append(",");
            }
            sb.append(strArr[i]);
        }
        return sb.toString();
    }

    public boolean checkConfigEnable(int i, String str, boolean z) {
        DynamicConfigModelList dynamicConfigModelList = this.f11488b;
        if (!(dynamicConfigModelList == null || dynamicConfigModelList.getDynamicConfigModelList() == null)) {
            for (DynamicConfigModel next : this.f11488b.getDynamicConfigModelList()) {
                if (next.getProductId() == i) {
                    for (String next2 : next.getFunctionSwitchMap().keySet()) {
                        if (next2.equals(str)) {
                            return next.getFunctionSwitchMap().get(next2).booleanValue();
                        }
                    }
                    continue;
                }
            }
        }
        return z;
    }
}
