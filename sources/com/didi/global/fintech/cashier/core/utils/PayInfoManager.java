package com.didi.global.fintech.cashier.core.utils;

import android.text.TextUtils;
import com.didi.global.fintech.cashier.model.net.response.BasicPayInfoResponse;
import com.didi.global.fintech.cashier.model.net.response.PayInfoResponse;
import com.didi.global.fintech.cashier.model.net.response.PayStatusResponse;
import java.util.HashMap;

public class PayInfoManager {

    /* renamed from: a */
    private static PayInfoManager f21494a;

    /* renamed from: b */
    private HashMap<String, PayInfoResponse> f21495b = new HashMap<>();

    /* renamed from: c */
    private HashMap<String, BasicPayInfoResponse> f21496c = new HashMap<>();

    /* renamed from: d */
    private HashMap<String, PayStatusResponse> f21497d = new HashMap<>();

    private PayInfoManager() {
    }

    public static PayInfoManager getInstance() {
        if (f21494a == null) {
            f21494a = new PayInfoManager();
        }
        return f21494a;
    }

    public BasicPayInfoResponse getBasicPayInfo(String str) {
        String a = m15755a(str);
        if (!TextUtils.isEmpty(a)) {
            return this.f21496c.get(a);
        }
        return null;
    }

    public void setBasicPayInfo(String str, BasicPayInfoResponse basicPayInfoResponse) {
        String a = m15755a(str);
        if (!TextUtils.isEmpty(a)) {
            this.f21496c.put(a, basicPayInfoResponse);
        }
    }

    public PayStatusResponse getPayStatus(String str) {
        String a = m15755a(str);
        if (!TextUtils.isEmpty(a)) {
            return this.f21497d.get(a);
        }
        return null;
    }

    public void setPayStatus(String str, PayStatusResponse payStatusResponse) {
        String a = m15755a(str);
        if (!TextUtils.isEmpty(a)) {
            this.f21497d.put(a, payStatusResponse);
        }
    }

    public PayInfoResponse getPayInfo(String str) {
        String a = m15755a(str);
        if (!TextUtils.isEmpty(a)) {
            return this.f21495b.get(a);
        }
        return null;
    }

    public void setPayInfo(String str, PayInfoResponse payInfoResponse) {
        String a = m15755a(str);
        if (!TextUtils.isEmpty(a)) {
            this.f21495b.put(a, payInfoResponse);
        }
    }

    public void removeData(String str) {
        this.f21495b.remove(str);
        this.f21496c.remove(str);
        this.f21497d.remove(str);
    }

    /* renamed from: a */
    private String m15755a(String str) {
        return !TextUtils.isEmpty(str) ? str : "";
    }
}
