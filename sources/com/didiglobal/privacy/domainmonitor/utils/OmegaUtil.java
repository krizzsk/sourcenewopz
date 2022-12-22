package com.didiglobal.privacy.domainmonitor.utils;

import com.didi.soda.customer.foundation.tracker.param.ParamConst;
import com.didichuxing.omega.sdk.common.collector.ActivityCollector;
import com.didichuxing.omega.sdk.common.collector.FragmentCollector;
import com.didiglobal.omegasdkadapter.OmegaSDKAdapter;
import com.didiglobal.privacy.domainmonitor.DomainMonitor;
import com.didiglobal.privacy.domainmonitor.model.NetworkParam;
import java.util.HashMap;
import java.util.Map;

public class OmegaUtil {
    /* renamed from: a */
    private static String m36333a() {
        String str;
        String curActivityPage = ActivityCollector.getCurActivityPage();
        if (curActivityPage == null || curActivityPage.isEmpty()) {
            str = "";
        } else {
            String[] split = curActivityPage.split("\\.");
            str = split[split.length - 1];
        }
        String curFragmentPage = FragmentCollector.getCurFragmentPage();
        if (curFragmentPage == null || curFragmentPage.isEmpty()) {
            return str;
        }
        String[] split2 = curFragmentPage.split("\\.");
        return str + "_" + split2[split2.length - 1];
    }

    public static void tech_driver_http_url_monitor(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        HashMap hashMap = new HashMap();
        hashMap.put("host", str);
        hashMap.put("absolute_url", str2);
        hashMap.put("source", str3);
        hashMap.put(ParamConst.TRACE_ID, str4);
        hashMap.put("bff_ability", str5);
        hashMap.put("current_page", m36333a());
        hashMap.put("net_lib", str6);
        hashMap.put("debug", DomainMonitor.isDebug() ? "1" : "0");
        hashMap.put("alarm_tag", str7);
        OmegaSDKAdapter.trackEvent("tech_domain_monitor_sdk_bt", (Map<String, Object>) hashMap);
    }

    public static void tech_driver_network_monitor_extra(NetworkParam networkParam) {
        HashMap hashMap = new HashMap();
        hashMap.put("net_url", networkParam.getUrl());
        hashMap.put("up_flow", Long.valueOf(networkParam.getUploadByteCount()));
        hashMap.put("down_flow", Long.valueOf(networkParam.getDownloadByteCount()));
        hashMap.put("http_code", Integer.valueOf(networkParam.getStatusCode()));
        hashMap.put("error_message", networkParam.getErrorMessage());
        OmegaSDKAdapter.trackEvent("tech_driver_network_monitor_extra", (Map<String, Object>) hashMap);
    }
}
