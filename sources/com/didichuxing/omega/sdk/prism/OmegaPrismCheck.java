package com.didichuxing.omega.sdk.prism;

import android.text.TextUtils;
import com.didi.soda.customer.foundation.tracker.error.ErrorConst;
import com.didichuxing.omega.sdk.common.OmegaSetting;
import com.didichuxing.omega.sdk.common.utils.CommonUtil;
import com.didichuxing.omega.sdk.common.utils.JsonUtil;
import com.xiaojuchefu.prism.monitor.model.EventData;
import java.util.List;
import java.util.Map;

public class OmegaPrismCheck {
    private static String mInstruction;
    private static Map<String, Object> mInstructionMap;

    private static void init() {
        String str = (String) CommonUtil.getParams(OmegaSetting.OMEGA_AUTOANALYTICS_FILTER_ANDROID, "instruction", "");
        if (TextUtils.isEmpty(str)) {
            mInstructionMap = null;
        } else if (TextUtils.isEmpty(mInstruction)) {
            mInstruction = str;
            mInstructionMap = JsonUtil.json2Map(str);
        } else if (mInstruction.length() != str.length()) {
            mInstruction = str;
            mInstructionMap = JsonUtil.json2Map(str);
        }
    }

    static void prismCheck(EventData eventData) {
        Object obj;
        List list;
        if (eventData != null) {
            init();
            Map<String, Object> map = mInstructionMap;
            if (map != null && map.size() != 0 && (obj = mInstructionMap.get("instruction")) != null && (obj instanceof List) && (list = (List) obj) != null) {
                for (Object next : list) {
                    if (next != null && (next instanceof Map)) {
                        try {
                            Map map2 = (Map) next;
                            if (attrCheck(map2, "vi", eventData.f56110vi) && attrCheck(map2, "vp", eventData.f56112vp) && attrCheck(map2, "vf", eventData.f56109vf) && attrCheck(map2, "vr", eventData.f56114vr) && attrCheck(map2, "vq", eventData.f56113vq) && attrCheck(map2, "vl", eventData.f56111vl) && attrCheck(map2, "w", eventData.f56115w)) {
                                String replaceStr = getReplaceStr(map2, "vr");
                                if (replaceStr != null) {
                                    eventData.f56114vr = replaceStr;
                                }
                                String replaceStr2 = getReplaceStr(map2, "w");
                                if (replaceStr2 != null) {
                                    eventData.f56115w = replaceStr2;
                                }
                                String replaceStr3 = getReplaceStr(map2, "vi");
                                if (replaceStr3 != null) {
                                    eventData.f56110vi = replaceStr3;
                                }
                                String replaceStr4 = getReplaceStr(map2, "vq");
                                if (replaceStr4 != null) {
                                    eventData.f56113vq = replaceStr4;
                                }
                                String replaceStr5 = getReplaceStr(map2, "vl");
                                if (replaceStr5 != null) {
                                    eventData.f56111vl = replaceStr5;
                                }
                                String replaceStr6 = getReplaceStr(map2, "vp");
                                if (replaceStr6 != null) {
                                    eventData.f56112vp = replaceStr6;
                                }
                                String replaceStr7 = getReplaceStr(map2, "vf");
                                if (replaceStr7 != null) {
                                    eventData.f56109vf = replaceStr7;
                                    return;
                                }
                                return;
                            }
                        } catch (Throwable unused) {
                            continue;
                        }
                    }
                }
            }
        }
    }

    private static boolean attrCheck(Map<String, Object> map, String str, String str2) {
        Map map2;
        if (TextUtils.isEmpty(str2) || (map2 = (Map) map.get(str)) == null) {
            return true;
        }
        String str3 = (String) map2.get(ErrorConst.ErrorParam.OPERATOR);
        List<String> list = (List) map2.get("value");
        if ("=".equals(str3)) {
            if (list == null || list.size() <= 0 || !str2.equals(list.get(0))) {
                return false;
            }
            return true;
        } else if ("%".equals(str3) && list != null && list.size() > 0) {
            for (String contains : list) {
                if (!str2.contains(contains)) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    private static String getReplaceStr(Map<String, Object> map, String str) {
        Map map2 = (Map) map.get(str);
        if (map2 == null) {
            return null;
        }
        return (String) map2.get("replace");
    }
}
