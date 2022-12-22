package com.didichuxing.mas.sdk.quality.collect.ditest.agent.android.instrumentation;

import com.didi.flutter.nacho2.p115v2.NachoLifecycleManager;
import java.util.HashMap;
import java.util.Map;
import rui.config.RConfigConstants;

public enum MetricCategory {
    NONE("None"),
    VIEW_LOADING("View Loading"),
    VIEW_LAYOUT("Layout"),
    DATABASE("Database"),
    IMAGE("Images"),
    JSON("JSON"),
    NETWORK("Network");
    
    private static final Map<String, MetricCategory> methodMap = null;
    private String categoryName;

    static {
        methodMap = new HashMap<String, MetricCategory>() {
            {
                put(NachoLifecycleManager.LIFECYCLE_ON_CREATE, MetricCategory.VIEW_LOADING);
            }
        };
    }

    private MetricCategory(String str) {
        this.categoryName = str;
    }

    public String getCategoryName() {
        return this.categoryName;
    }

    public static MetricCategory categoryForMethod(String str) {
        if (str == null) {
            return NONE;
        }
        String str2 = null;
        int indexOf = str.indexOf(RConfigConstants.KEYWORD_COLOR_SIGN);
        if (indexOf >= 0) {
            str2 = str.substring(indexOf + 1);
        }
        MetricCategory metricCategory = methodMap.get(str2);
        return metricCategory == null ? NONE : metricCategory;
    }
}
