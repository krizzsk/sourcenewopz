package com.didi.unifiedPay.component.presenter;

import android.text.TextUtils;
import com.didi.unifiedPay.sdk.model.BasicPayInfo;
import com.didi.unifiedPay.sdk.model.DeductionInfo;
import com.didi.unifiedPay.sdk.model.PayInfo;
import com.didi.unifiedPay.sdk.model.PayStatus;
import java.util.HashMap;

public class PayInfoManager {

    /* renamed from: a */
    private static PayInfoManager f44370a;

    /* renamed from: b */
    private HashMap<String, PayInfo> f44371b = new HashMap<>();

    /* renamed from: c */
    private HashMap<String, BasicPayInfo> f44372c = new HashMap<>();

    /* renamed from: d */
    private HashMap<String, PayStatus> f44373d = new HashMap<>();

    /* renamed from: e */
    private String f44374e;

    private PayInfoManager(String str) {
        this.f44374e = str;
    }

    public static PayInfoManager getInstance(String str) {
        if (f44370a == null) {
            f44370a = new PayInfoManager(str);
        }
        PayInfoManager payInfoManager = f44370a;
        payInfoManager.f44374e = str;
        return payInfoManager;
    }

    public BasicPayInfo getBasicPayInfo(String str) {
        String a = m31508a(str);
        if (!TextUtils.isEmpty(a)) {
            return this.f44372c.get(a);
        }
        return null;
    }

    public void setBasicPayInfo(String str, BasicPayInfo basicPayInfo) {
        String a = m31508a(str);
        if (!TextUtils.isEmpty(a)) {
            this.f44372c.put(a, basicPayInfo);
        }
    }

    public PayStatus getPayStatus(String str) {
        String a = m31508a(str);
        if (!TextUtils.isEmpty(a)) {
            return this.f44373d.get(a);
        }
        return null;
    }

    public void setPayStatus(String str, PayStatus payStatus) {
        String a = m31508a(str);
        if (!TextUtils.isEmpty(a)) {
            this.f44373d.put(a, payStatus);
        }
    }

    public PayInfo getPayInfo(String str) {
        String a = m31508a(str);
        if (!TextUtils.isEmpty(a)) {
            return this.f44371b.get(a);
        }
        return null;
    }

    public void setPayInfo(String str, PayInfo payInfo) {
        String a = m31508a(str);
        if (!TextUtils.isEmpty(a)) {
            this.f44371b.put(a, payInfo);
        }
    }

    public DeductionInfo getVoucherInfo(String str) {
        PayInfo payInfo;
        String a = m31508a(str);
        if (!(TextUtils.isEmpty(a) || (payInfo = this.f44371b.get(a)) == null || payInfo.billDetail == null || payInfo.billDetail.deductions == null)) {
            for (DeductionInfo deductionInfo : payInfo.billDetail.deductions) {
                if (deductionInfo != null && deductionInfo.type == 1) {
                    return deductionInfo;
                }
            }
        }
        return null;
    }

    public void clearData() {
        this.f44371b.clear();
        this.f44372c.clear();
        this.f44373d.clear();
    }

    public void clearPayInfo() {
        this.f44371b.clear();
    }

    /* renamed from: a */
    private String m31508a(String str) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(this.f44374e)) {
            return "";
        }
        return str + this.f44374e;
    }
}
