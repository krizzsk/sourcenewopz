package com.didi.crossplatform.track;

import androidx.core.util.Pair;
import com.didi.crossplatform.track.model.EngineItem;
import com.didi.crossplatform.track.model.PerformanceItem;
import com.didi.crossplatform.track.model.PerformanceList;
import com.didi.crossplatform.track.model.TrackConfig;
import com.didichuxing.omega.sdk.init.OmegaSDK;
import com.didiglobal.omegasdkadapter.OmegaSDKAdapter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PTracker {

    /* renamed from: a */
    private final TrackConfig f16383a;

    /* renamed from: b */
    private final HashMap<String, Long> f16384b = new HashMap<>();

    public PTracker(TrackConfig trackConfig) {
        this.f16383a = trackConfig;
    }

    public void trackCommonEngine(EngineItem.CommonIndicator commonIndicator, boolean z, String str, long j) {
        EngineItem engineItem = new EngineItem();
        engineItem.category = commonIndicator.getCategory();
        engineItem.name = commonIndicator.getName();
        engineItem.status = "end";
        engineItem.success = z;
        engineItem.errorMsg = str;
        engineItem.duration = j;
        trackEngineItem(engineItem);
    }

    public void trackCommonEngineStart(EngineItem.CommonIndicator commonIndicator) {
        EngineItem engineItem = new EngineItem();
        engineItem.category = commonIndicator.getCategory();
        engineItem.name = commonIndicator.getName();
        engineItem.status = "start";
        engineItem.success = true;
        this.f16384b.put(engineItem.category, Long.valueOf(System.currentTimeMillis()));
        trackEngineItem(engineItem);
    }

    public void trackCommonEngineEnd(EngineItem.CommonIndicator commonIndicator, boolean z, String str) {
        Long l = this.f16384b.get(commonIndicator.getCategory());
        trackCommonEngine(commonIndicator, z, str, l != null ? System.currentTimeMillis() - l.longValue() : 0);
    }

    public void trackEngineItem(EngineItem engineItem) {
        Map<String, Object> parseMap = this.f16383a.parseMap();
        parseMap.putAll(engineItem.parseMap());
        OmegaSDKAdapter.trackEvent("tech_engine_th", "框架埋点", parseMap);
    }

    public void trackCommonPerformance(PerformanceItem.CommonIndicator commonIndicator, Object obj) {
        trackPerformance(m12005a(commonIndicator, obj));
    }

    public void trackCommonPerformanceList(List<Pair<PerformanceItem.CommonIndicator, Object>> list) {
        if (list != null && list.size() != 0) {
            PerformanceList performanceList = new PerformanceList();
            for (Pair next : list) {
                if (!(next.first == null || next.second == null)) {
                    performanceList.add(m12005a((PerformanceItem.CommonIndicator) next.first, next.second));
                }
            }
            trackPerformance(performanceList);
        }
    }

    public void trackPerformance(PerformanceItem performanceItem) {
        PerformanceList performanceList = new PerformanceList();
        performanceList.add(performanceItem);
        trackPerformance(performanceList);
    }

    public void trackPerformance(PerformanceList performanceList) {
        Map<String, Object> parseMap = this.f16383a.parseMap();
        parseMap.putAll(performanceList.parseMap());
        OmegaSDKAdapter.trackEvent("tech_performance_th", "性能埋点", parseMap);
    }

    public void trackPageView() {
        trackCommonPerformance(PerformanceItem.CommonIndicator.PAGE_VIEW, 1);
    }

    public void trackPageSuccess() {
        trackCommonPerformance(PerformanceItem.CommonIndicator.PAGE_SUCCESS, 1);
    }

    /* renamed from: a */
    private PerformanceItem m12005a(PerformanceItem.CommonIndicator commonIndicator, Object obj) {
        PerformanceItem performanceItem = new PerformanceItem();
        performanceItem.category = commonIndicator.getCategory();
        performanceItem.name = commonIndicator.getName();
        performanceItem.value = obj;
        performanceItem.unit = commonIndicator.getUnit();
        return performanceItem;
    }

    public void trackError(String str, String str2, String str3, Map<String, Object> map) {
        Map<String, Object> parseMap = this.f16383a.parseMap();
        if (map != null) {
            parseMap.putAll(map);
        }
        parseMap.put("o_source", "engine");
        OmegaSDK.trackError(str, str2, str3, parseMap);
    }

    public void trackCustomError(String str, String str2, String str3, String str4) {
        Map<String, Object> parseMap = this.f16383a.parseMap();
        parseMap.put("o_source", "custom");
        parseMap.put("o_extra", str4);
        OmegaSDK.trackError(str, str2, str3, parseMap);
    }
}
