package com.didichuxing.omega.sdk.trafficstat.config;

import com.didi.soda.customer.foundation.tracker.param.ParamConst;
import com.didichuxing.omega.sdk.analysis.Tracker;
import java.util.HashMap;
import java.util.Map;

public class TagConfig {
    public static final Integer TAG_DEFALUT = 0;
    public static final Integer TAG_OMEGA = 1;
    public static final String defaultMapList = "total:0;omega:1;";
    public static Map<Integer, String> mapTable = new HashMap();

    public static void setTagMapping(String str) {
        if (str == null || str.length() == 0) {
            str = "total:0;omega:1;";
        }
        try {
            mapTable.clear();
            String[] split = str.split(";");
            for (String split2 : split) {
                String[] split3 = split2.split(":");
                if (split3.length == 2) {
                    mapTable.put(Integer.valueOf(Integer.parseInt(split3[1])), split3[0]);
                }
            }
        } catch (Exception e) {
            mapTable.put(TAG_DEFALUT, ParamConst.PARAM_TOTAL);
            mapTable.put(TAG_OMEGA, "omega");
            Tracker.trackGood("omega_generic_traffic_stat:parse tag list error", e);
            e.printStackTrace();
        }
    }
}
