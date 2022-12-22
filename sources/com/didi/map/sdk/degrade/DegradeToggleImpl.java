package com.didi.map.sdk.degrade;

import android.content.Context;
import com.didi.map.sdk.navtracker.TrackerPreference;
import com.didi.map.sdk.navtracker.log.DLog;
import com.didi.sdk.apm.SystemUtils;
import com.didiglobal.omegasdkadapter.OmegaSDKAdapter;
import com.sdk.poibase.model.RpcPoiBaseInfo;
import java.util.HashMap;
import java.util.Map;

public class DegradeToggleImpl implements IDegradeToggle {

    /* renamed from: a */
    private Context f28089a;

    public DegradeMode getTargetDegradeMode(DegradeMode degradeMode, Context context) {
        if (degradeMode == null) {
            return null;
        }
        this.f28089a = context;
        DLog.m20199d("ccc", "DegradeMode src is " + degradeMode.toString(), new Object[0]);
        ApolloGetter apolloGetter = AutoDegradeController.getInstance(context).getApolloGetter();
        if (apolloGetter == null) {
            SystemUtils.log(6, "ccc", "apollo is null", (Throwable) null, "com.didi.map.sdk.degrade.DegradeToggleImpl", 29);
            return degradeMode;
        }
        DLog.m20199d("ccc", "apollo ----" + apolloGetter.toString(), new Object[0]);
        if (degradeMode.toString().equals(RpcPoiBaseInfo.MAP_TYPE_DIDI)) {
            int i = apolloGetter.down_dmap_mode;
            if (i == 1) {
                DLog.m20199d("ccc", "自动降级 ", new Object[0]);
                return AutoDegradeController.getInstance(context).isNeedDegradeToLaunch(degradeMode) ? m19960a(apolloGetter.down_dmap_vendor) : degradeMode;
            } else if (i != 2) {
                AutoDegradeController.getInstance(context).clearAllCachedData(degradeMode);
            } else {
                DLog.m20199d("ccc", "强制降级 ", new Object[0]);
                AutoDegradeController.getInstance(context).clearAllCachedData(degradeMode);
                return m19960a(apolloGetter.down_dmap_vendor);
            }
        } else if (degradeMode.toString().equals("gmap")) {
            int i2 = apolloGetter.down_gmap_mode;
            if (i2 == 0) {
                DLog.m20199d("ccc", "=0，不降级 ", new Object[0]);
                AutoDegradeController.getInstance(context).clearAllCachedData(degradeMode);
            } else if (i2 == 1) {
                DLog.m20199d("ccc", "自动降级 ", new Object[0]);
                return AutoDegradeController.getInstance(context).isNeedDegradeToLaunch(degradeMode) ? m19960a(apolloGetter.down_gmap_vendor) : degradeMode;
            } else if (i2 == 2) {
                DLog.m20199d("ccc", "强制降级 ", new Object[0]);
                AutoDegradeController.getInstance(context).clearAllCachedData(degradeMode);
                return m19960a(apolloGetter.down_gmap_vendor);
            }
            DLog.m20199d("ccc", "defaul,不降级 ", new Object[0]);
            AutoDegradeController.getInstance(context).clearAllCachedData(degradeMode);
        }
        DLog.m20199d("ccc", "默认不降级 ", new Object[0]);
        return degradeMode;
    }

    /* renamed from: a */
    private DegradeMode m19960a(String str) {
        m19961a();
        if (str.equals(RpcPoiBaseInfo.MAP_TYPE_DIDI)) {
            DLog.m20199d("ccc", "降级到DIDI ", new Object[0]);
            return DegradeMode.DIDI;
        } else if (str.equals("gmap")) {
            DLog.m20199d("ccc", "降级到google ", new Object[0]);
            return DegradeMode.GOOGLE;
        } else {
            DLog.m20199d("ccc", "降级到EMPTY ", new Object[0]);
            return DegradeMode.EMPTY;
        }
    }

    public void onAppLaunched(DegradeMode degradeMode, Context context) {
        AutoDegradeController.getInstance(context).onAppLaunched(degradeMode);
    }

    /* renamed from: a */
    private void m19961a() {
        if (this.f28089a != null) {
            HashMap hashMap = new HashMap();
            hashMap.put("time", Long.valueOf(System.currentTimeMillis() / 1000));
            hashMap.put("app_name", this.f28089a.getPackageName());
            hashMap.put("os", 1);
            hashMap.put("phone_num", TrackerPreference.getPhoneNum(this.f28089a));
            hashMap.put("country_code", TrackerPreference.getCountryCode(this.f28089a));
            hashMap.put("app_version", TrackerPreference.getAppVersion(this.f28089a));
            hashMap.put("user_id", TrackerPreference.getUserId(this.f28089a));
            OmegaSDKAdapter.trackEvent("tech_global_map_degrade", (Map<String, Object>) hashMap);
            DLog.m20199d("ccc", "triggered tech_global_map_degrade", new Object[0]);
        }
    }
}
