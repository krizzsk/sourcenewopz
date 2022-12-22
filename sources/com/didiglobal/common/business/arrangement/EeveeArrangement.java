package com.didiglobal.common.business.arrangement;

import com.didiglobal.common.business.arrangement.model.EeveeArrangementBizConfig;
import com.didiglobal.common.business.arrangement.model.EeveeArrangementComponentModel;
import com.google.gson.JsonObject;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EeveeArrangement {

    /* renamed from: a */
    private static final Map<String, List<EeveeArrangementComponentModel>> f49736a = new HashMap();

    /* renamed from: b */
    private static EeveeArrangementBizConfig f49737b = new EeveeArrangementBizConfig();

    /* renamed from: c */
    private static Map<String, JsonObject> f49738c = new HashMap();

    public static Map<String, List<EeveeArrangementComponentModel>> getArrangementMap() {
        return f49736a;
    }

    public static void putModel(String str, List<EeveeArrangementComponentModel> list) {
        f49736a.put(str, list);
    }

    public static List<EeveeArrangementComponentModel> getModel(String str) {
        return f49736a.get(str);
    }

    public static void putAll(Map<String, List<EeveeArrangementComponentModel>> map) {
        f49736a.clear();
        f49736a.putAll(map);
    }

    public static EeveeArrangementBizConfig getBizConfig() {
        return f49737b;
    }

    public static void setConfig(EeveeArrangementBizConfig eeveeArrangementBizConfig) {
        f49737b = eeveeArrangementBizConfig;
    }
}
