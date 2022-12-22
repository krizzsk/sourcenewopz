package com.example.uploadrule.utils;

import android.text.TextUtils;
import com.didichuxing.apollo.sdk.Apollo;
import com.didichuxing.apollo.sdk.IToggle;
import com.didichuxing.bigdata.p173dp.locsdk.Const;
import com.didiglobal.omegasdkadapter.EventWrapper;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public class OURApolloUtil {
    public static boolean rule1Upload(EventWrapper eventWrapper) {
        return isEventContained(eventWrapper, (String) getParamByStatus("global_omega_upload_rules", "rule1_report_event", "", true));
    }

    public static boolean rule2OrderOnce(EventWrapper eventWrapper) {
        return isEventContained(eventWrapper, (String) getParamByStatus("global_omega_upload_rules", "rule2_order_once", "", false));
    }

    public static boolean rule3LifecycleOnce(EventWrapper eventWrapper) {
        return isEventContained(eventWrapper, (String) getParamByStatus("global_omega_upload_rules", "rule3_lifecycle_once", "", false));
    }

    public static boolean rule0NotReport(EventWrapper eventWrapper) {
        return isEventContained(eventWrapper, (String) getParamByStatus("global_omega_upload_rules", "rule0_not_report_event", "", false));
    }

    public static boolean rule4HitNotReportErrorReport(EventWrapper eventWrapper) {
        String str = (String) getParamByStatus("global_omega_upload_rules", "rule4_hit_not_report_error_report", "", false);
        Map<String, Object> eventParams = eventWrapper.getEventParams();
        if (eventParams == null || TextUtils.isEmpty(str) || ((eventParams.get("he") != null && !"0".equals(eventParams.get("he").toString())) || ((eventParams.get("ne") != null && !"0".equals(eventParams.get("ne").toString())) || !str.startsWith(Const.joLeft) || !str.endsWith("}")))) {
            return false;
        }
        return parseList(str, eventWrapper);
    }

    public static boolean rule5HitNotReport(EventWrapper eventWrapper) {
        String str = (String) getParamByStatus("global_omega_upload_rules", "rule5_hit_not_report_appolo", "", false);
        if (TextUtils.isEmpty(str) || !str.startsWith(Const.joLeft) || !str.endsWith("}")) {
            return false;
        }
        return parseList(str, eventWrapper);
    }

    public static boolean parseList(String str, EventWrapper eventWrapper) {
        String eventId = getEventId(eventWrapper);
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has(eventId)) {
                JSONObject optJSONObject = jSONObject.optJSONObject(eventId);
                Iterator<String> keys = optJSONObject.keys();
                if (!keys.hasNext()) {
                    return true;
                }
                while (keys.hasNext()) {
                    String next = keys.next();
                    JSONArray optJSONArray = optJSONObject.optJSONArray(next);
                    if (optJSONArray != null) {
                        Map<String, Object> eventParams = eventWrapper.getEventParams();
                        if (eventParams == null) {
                            return false;
                        }
                        for (String obj : eventParams.keySet()) {
                            String obj2 = obj.toString();
                            String obj3 = eventParams.get(obj2).toString();
                            if (next.equals(obj2)) {
                                for (int i = 0; i < optJSONArray.length(); i++) {
                                    if (optJSONArray.get(i).equals(obj3)) {
                                        return true;
                                    }
                                }
                                continue;
                            }
                        }
                        continue;
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public static String getEventId(EventWrapper eventWrapper) {
        if (eventWrapper == null) {
            return "";
        }
        String eventId = eventWrapper.getEventId();
        if (!TextUtils.isEmpty(eventId)) {
            return eventId;
        }
        if (eventWrapper.getEvent() != null) {
            eventId = eventWrapper.getEvent().getEventId();
        }
        return !TextUtils.isEmpty(eventId) ? eventId : eventId;
    }

    public static boolean isEventContained(EventWrapper eventWrapper, String str) {
        if (!TextUtils.isEmpty(str)) {
            if (str.startsWith(Const.joLeft) && str.endsWith("}")) {
                return parseList(str, eventWrapper);
            }
            String[] split = str.split(",");
            if (split != null && split.length > 0) {
                for (String equals : split) {
                    if (getEventId(eventWrapper).equals(equals)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private static <T> T getParamByStatus(String str, String str2, T t, boolean z) {
        if (z) {
            T valueFromCache = ApolloCache.getValueFromCache(str, str2);
            if (valueFromCache != null) {
                return valueFromCache;
            }
            if (getStatus(str)) {
                T param = getParam(str, str2, t);
                ApolloCache.putValueToCache(str, str2, param);
                return param;
            }
            ApolloCache.putValueToCache(str, str2, t);
        } else if (getStatus(str)) {
            return getParam(str, str2, t);
        }
        return t;
    }

    public static <T> T getParam(String str, String str2, T t) {
        try {
            return Apollo.getToggle(str).getExperiment().getParam(str2, t);
        } catch (Exception e) {
            e.printStackTrace();
            return t;
        }
    }

    public static boolean getStatus(String str) {
        return getStatus(str, false);
    }

    public static boolean getStatus(String str, boolean z) {
        try {
            IToggle toggle = Apollo.getToggle(str, z);
            if (toggle != null) {
                return toggle.allow();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return z;
    }
}
