package com.didi.payment.base.tracker;

import android.text.TextUtils;
import com.didi.sdk.apm.SystemUtils;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;

public class FinExtAttrBiz {
    public static final String FROM_ADD_CARD_INIT = "GlobalCreditCardAddOptActivity init";
    public static final String FROM_ADD_CARD_RESUME = "GlobalCreditCardAddOptActivity onResume";
    public static final String FROM_ADD_CARD_V2_INIT = "GlobalCreditCardAddOptV2Activity init";
    public static final String FROM_ADD_CARD_V2_RESUME = "GlobalCreditCardAddOptV2Activity onResume";
    public static final String FROM_HOME_INIT = "HomePage init";
    public static final String FROM_HOME_RESUME = "HomePage onResume";
    public static final String FROM_PAYSEL_INIT = "PayMethodSelActivity init";
    public static final String FROM_PAYSEL_RESUME = "PayMethodSelActivity onResume";
    public static final String FROM_TOPUP_INIT = "WalletTopUpPage init";
    public static final String FROM_TOPUP_RESUME = "WalletTopUpPage onResume";
    public static final String KEY_ACT_ID = "pub_fin_activity";
    public static final String KEY_CHANNEL_ID = "pub_fin_channel";
    public static final String KEY_RES_ID = "resource_id";

    /* renamed from: a */
    private HashMap<String, Object> f29970a;
    public String resourceId = "";

    public void updateExtAttrs2FinGlobalAttrs(String str) {
        updateExtAttrs2FinGlobalAttrs(str, FROM_TOPUP_INIT);
    }

    public static void updateActId2FinGlobalAttrs(String str) {
        if (!TextUtils.isEmpty(str)) {
            SystemUtils.log(4, "FinExtAttrBiz", String.format("updateActId2FinGlobalAttrs : actId = %s", new Object[]{str}), (Throwable) null, "com.didi.payment.base.tracker.FinExtAttrBiz", 41);
            FinOmegaSDK.putFinGlobalExtAttrs(KEY_ACT_ID, str);
        }
    }

    /* renamed from: a */
    private HashMap<String, Object> m21001a(String str) {
        try {
            return (HashMap) new Gson().fromJson(str, new TypeToken<HashMap<String, Object>>() {
            }.getType());
        } catch (JsonSyntaxException unused) {
            return null;
        }
    }

    public String getNextPageExt(String str) {
        HashMap<String, Object> hashMap = this.f29970a;
        if (hashMap == null || hashMap.isEmpty()) {
            return "";
        }
        HashMap hashMap2 = new HashMap();
        hashMap2.putAll(this.f29970a);
        if (!TextUtils.isEmpty(str)) {
            hashMap2.put(KEY_ACT_ID, str);
        }
        return new Gson().toJson((Object) hashMap2);
    }

    public void updateExtAttrs2FinGlobalAttrs(String str, String str2) {
        FinOmegaSDK.removeFinGlobalExtAttrs();
        if (TextUtils.isEmpty(str)) {
            SystemUtils.log(4, "FinExtAttrBiz", String.format("updateExtAttrs2FinGlobalAttrs ext = %s    %s", new Object[]{str, str2}), (Throwable) null, "com.didi.payment.base.tracker.FinExtAttrBiz", 74);
            return;
        }
        String str3 = null;
        try {
            str3 = URLDecoder.decode(str, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        SystemUtils.log(4, "FinExtAttrBiz", String.format("updateExtAttrs2FinGlobalAttrs ext = %s    %s", new Object[]{str3, str2}), (Throwable) null, "com.didi.payment.base.tracker.FinExtAttrBiz", 84);
        if (this.f29970a == null) {
            this.f29970a = m21001a(str3);
        }
        HashMap<String, Object> hashMap = this.f29970a;
        if (hashMap != null) {
            if (hashMap.containsKey("resource_id")) {
                this.resourceId = String.valueOf(this.f29970a.get("resource_id"));
            }
            for (Map.Entry next : this.f29970a.entrySet()) {
                FinOmegaSDK.putFinGlobalExtAttrs((String) next.getKey(), next.getValue());
            }
        }
    }
}
