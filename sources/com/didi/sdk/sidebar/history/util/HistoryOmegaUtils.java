package com.didi.sdk.sidebar.history.util;

import com.didi.sdk.apm.SystemUtils;
import com.didi.sdk.sidebar.history.HistoryRecordFragment;
import com.didiglobal.omegasdkadapter.OmegaSDKAdapter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;

public class HistoryOmegaUtils {

    /* renamed from: a */
    private static final String f37393a = "gp_myOrder_Business_sw";

    /* renamed from: b */
    private static final String f37394b = "gp_myOrder_getBusiness_err";

    /* renamed from: c */
    private static final String f37395c = "gp_myOrder_changeBusiness_ck";

    /* renamed from: d */
    private static final String f37396d = "business_id";

    /* renamed from: e */
    private static final String f37397e = "defaultTabOrder";

    /* renamed from: f */
    private static final String f37398f = "defaultTabList";

    /* renamed from: g */
    private static final String f37399g = "sense";

    /* renamed from: h */
    private static final String f37400h = "err_no";

    /* renamed from: i */
    private static final String f37401i = "url_type";

    /* renamed from: j */
    private static final String f37402j = "from_business_id";

    /* renamed from: k */
    private static final String f37403k = "to_business_id";

    /* renamed from: l */
    private static final String f37404l = "food";

    /* renamed from: m */
    private static final String f37405m = "ride";

    /* renamed from: n */
    private static final String f37406n = "bike";

    public static void sendTabShow(List<HistoryRecordFragment.HistoryListFragmentModel> list) {
        HashMap hashMap = new HashMap();
        hashMap.put("business_id", 0);
        hashMap.put(f37397e, 0);
        JSONArray jSONArray = new JSONArray();
        if (list != null) {
            for (HistoryRecordFragment.HistoryListFragmentModel historyListFragmentModel : list) {
                jSONArray.put(historyListFragmentModel.type);
            }
            hashMap.put(f37398f, jSONArray.toString());
        }
        hashMap.put(f37399g, 1);
        OmegaSDKAdapter.trackEvent(f37393a, (Map<String, Object>) hashMap);
        SystemUtils.log(6, "wangwei", "sendTabShow - 0 - " + jSONArray, (Throwable) null, "com.didi.sdk.sidebar.history.util.HistoryOmegaUtils", 53);
    }

    public static void sendTabClick(int i, int i2, List<HistoryRecordFragment.HistoryListFragmentModel> list) {
        HashMap hashMap = new HashMap();
        if (list != null && list.size() > i && list.size() > i2) {
            hashMap.put(f37402j, list.get(i).type);
            hashMap.put(f37403k, list.get(i2).type);
            hashMap.put("business_id", 0);
            JSONArray jSONArray = new JSONArray();
            for (HistoryRecordFragment.HistoryListFragmentModel historyListFragmentModel : list) {
                jSONArray.put(historyListFragmentModel.type);
            }
            hashMap.put(f37398f, jSONArray.toString());
            OmegaSDKAdapter.trackEvent(f37395c, (Map<String, Object>) hashMap);
            SystemUtils.log(6, "wangwei", "sendTabClick - " + i + " - " + i2 + " - " + jSONArray, (Throwable) null, "com.didi.sdk.sidebar.history.util.HistoryOmegaUtils", 68);
        }
    }

    public static void sendTabError(int i, String str) {
        HashMap hashMap = new HashMap();
        hashMap.put(f37400h, Integer.valueOf(i));
        if ("soda".equals(str)) {
            hashMap.put(f37401i, "food");
        } else if ("ride".equals(str)) {
            hashMap.put(f37401i, "ride");
        } else if ("bike".equals(str)) {
            hashMap.put(f37401i, "bike");
        }
        hashMap.put(f37401i, str);
        OmegaSDKAdapter.trackEvent(f37394b, (Map<String, Object>) hashMap);
        SystemUtils.log(6, "wangwei", "sendTabError - " + i + " - " + str, (Throwable) null, "com.didi.sdk.sidebar.history.util.HistoryOmegaUtils", 84);
    }
}
