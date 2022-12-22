package com.didi.payment.creditcard.global.model;

import android.content.Context;
import android.text.TextUtils;
import com.didi.commoninterfacelib.ServiceProviderManager;
import com.didi.commoninterfacelib.sotre.IBusinessInfoStore;
import com.didi.payment.base.utils.PayBaseParamUtil;
import com.didi.payment.creditcard.base.encryption.LianLianEncryptUtils;
import com.didi.sdk.apm.SystemUtils;
import com.didichuxing.apollo.sdk.Apollo;
import com.didichuxing.apollo.sdk.IExperiment;
import com.didichuxing.apollo.sdk.IToggle;
import com.didichuxing.request.ServerParam;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

public class GlobalRiskInfo {

    /* renamed from: A */
    private String f30370A = "";

    /* renamed from: a */
    private String f30371a = "";

    /* renamed from: b */
    private String f30372b = "";

    /* renamed from: c */
    private String f30373c = "";

    /* renamed from: d */
    private String f30374d = "";

    /* renamed from: e */
    private String f30375e = "";

    /* renamed from: f */
    private String f30376f = "";

    /* renamed from: g */
    private String f30377g = "";

    /* renamed from: h */
    private String f30378h = "";

    /* renamed from: i */
    private boolean f30379i = false;

    /* renamed from: j */
    private String f30380j = "";

    /* renamed from: k */
    private String f30381k = "";

    /* renamed from: l */
    private String f30382l = "";

    /* renamed from: m */
    private String f30383m = "";

    /* renamed from: n */
    private String f30384n = "";

    /* renamed from: o */
    private String f30385o = "";

    /* renamed from: p */
    private String f30386p = "";

    /* renamed from: q */
    private String f30387q = "";

    /* renamed from: r */
    private String f30388r = "";

    /* renamed from: s */
    private String f30389s = "";

    /* renamed from: t */
    private String f30390t = "";

    /* renamed from: u */
    private String f30391u = "";

    /* renamed from: v */
    private String f30392v = "";

    /* renamed from: w */
    private String f30393w = "";

    /* renamed from: x */
    private String f30394x = "";

    /* renamed from: y */
    private String f30395y = "";

    /* renamed from: z */
    private String f30396z = "";

    public void setBankCardNo(String str) {
        if (!TextUtils.isEmpty(str)) {
            String b = m21340b(str);
            this.f30394x = b;
            this.f30371a = LianLianEncryptUtils.MD5(b);
        }
    }

    public void setOriginNumber(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.f30381k = m21340b(str);
        }
    }

    public void setCardNoPrefixSuffix(String str) {
        if (TextUtils.isEmpty(str) || str.length() < 10) {
            this.f30372b = "";
            return;
        }
        String b = m21340b(str);
        String substring = b.substring(0, 6);
        String substring2 = b.substring(b.length() - 4, b.length());
        this.f30372b = substring + substring2;
    }

    public void setBankAccountName(String str) {
        this.f30373c = str;
    }

    public void setValidDate(String str) {
        this.f30374d = str;
    }

    public void setCvv2(String str) {
        this.f30375e = str;
        this.f30395y = str;
    }

    public void setStayTime(String str) {
        this.f30376f = str;
    }

    public void setBindType(String str) {
        this.f30377g = str;
    }

    public void setSignAfterOrder(boolean z) {
        if (z) {
            this.f30388r = "1";
        } else {
            this.f30388r = "0";
        }
    }

    public void setOrderId(String str) {
        this.f30389s = str;
    }

    public void setProductLine(String str) {
        this.f30390t = str;
    }

    public void setIsOcr(boolean z) {
        this.f30379i = z;
    }

    public void setOcrContent(String str) {
        if (TextUtils.isEmpty(str) || str.length() < 10) {
            this.f30380j = "";
            return;
        }
        String b = m21340b(str);
        String substring = b.substring(0, 6);
        String substring2 = b.substring(b.length() - 4, b.length());
        this.f30380j = substring + substring2;
    }

    public void setBankCardType(String str) {
        this.f30378h = str;
    }

    public void setBaseRiskParam(Context context) {
        this.f30382l = PayBaseParamUtil.getStringParam(context, "idfa");
        this.f30383m = PayBaseParamUtil.getStringParam(context, "a3");
        this.f30384n = PayBaseParamUtil.getStringParam(context, "country");
        this.f30385o = PayBaseParamUtil.getStringParam(context, "ip");
        this.f30386p = PayBaseParamUtil.getStringParam(context, "imei");
        this.f30387q = PayBaseParamUtil.getStringParam(context, "networkType");
        this.f30388r = m21338a("sign_after_order");
        this.f30390t = m21338a("product_line");
        this.f30389s = m21338a("order_id");
    }

    public void setIsExistPaste(String str) {
        this.f30396z = str;
    }

    public void setResourceid(String str) {
        this.f30370A = str;
    }

    public String encryptWithAES(String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("bankcard_no", this.f30371a);
            jSONObject.put("card_no_prefix_suffix", this.f30372b);
            jSONObject.put("number", this.f30394x);
            jSONObject.put("bank_account_name", this.f30373c);
            jSONObject.put("valid_date", this.f30374d);
            jSONObject.put("cvc", this.f30395y);
            jSONObject.put("stay_time", this.f30376f);
            jSONObject.put("idfa", this.f30382l);
            jSONObject.put("a3", this.f30383m);
            jSONObject.put("country", this.f30384n);
            jSONObject.put("ip", this.f30385o);
            jSONObject.put("phone_imsi", this.f30386p);
            jSONObject.put("order_id", this.f30389s);
            jSONObject.put("product_line", this.f30390t);
            jSONObject.put("bind_type", this.f30377g);
            jSONObject.put(ServerParam.PARAM_NETWORK_TYPE, this.f30387q);
            jSONObject.put("sign_after_order", this.f30388r);
            jSONObject.put("bankcard_type", this.f30378h);
            jSONObject.put("is_ocr", this.f30379i);
            jSONObject.put("ocr_content", this.f30380j);
            jSONObject.put("bind_phone", this.f30391u);
            jSONObject.put("id_no", this.f30392v);
            jSONObject.put("id_type", this.f30393w);
            if (!TextUtils.isEmpty(this.f30381k)) {
                jSONObject.put("origin_number", this.f30381k);
            }
            if (m21339a()) {
                jSONObject.put("resource_id", this.f30370A);
                jSONObject.put("isExistPaste", this.f30396z);
            }
            return LianLianEncryptUtils.encryptWithAES(jSONObject.toString(), str);
        } catch (JSONException unused) {
            return null;
        }
    }

    /* renamed from: a */
    private boolean m21339a() {
        IExperiment experiment;
        IToggle toggle = Apollo.getToggle("wallet_screen_shot");
        if (toggle == null || !toggle.allow() || (experiment = toggle.getExperiment()) == null || ((Integer) experiment.getParam("paste_Android", 0)).intValue() != 1) {
            return false;
        }
        return true;
    }

    /* renamed from: a */
    private String m21338a(String str) {
        HashMap<String, Object> infos;
        IBusinessInfoStore iBusinessInfoStore = (IBusinessInfoStore) ServiceProviderManager.getInstance().getComponent(IBusinessInfoStore.class);
        if (iBusinessInfoStore != null && (infos = iBusinessInfoStore.getInfos()) != null && !TextUtils.isEmpty(str) && infos.get(str) == null) {
        }
        return "";
    }

    /* renamed from: b */
    private String m21340b(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        return str.trim().replaceAll(" ", "");
    }

    /* renamed from: b */
    private void m21341b() {
        SystemUtils.log(3, "RiskInfo", "--------------------------- RiskInfo Start ----------------------------", (Throwable) null, "com.didi.payment.creditcard.global.model.GlobalRiskInfo", 368);
        String str = "RiskInfo";
        SystemUtils.log(3, str, "bankcard_no = " + this.f30371a, (Throwable) null, "com.didi.payment.creditcard.global.model.GlobalRiskInfo", 369);
        SystemUtils.log(3, str, "card_no_prefix_suffix = " + this.f30372b, (Throwable) null, "com.didi.payment.creditcard.global.model.GlobalRiskInfo", 370);
        SystemUtils.log(3, str, "bank_account_name = " + this.f30373c, (Throwable) null, "com.didi.payment.creditcard.global.model.GlobalRiskInfo", 371);
        SystemUtils.log(3, str, "valid_date = " + this.f30374d, (Throwable) null, "com.didi.payment.creditcard.global.model.GlobalRiskInfo", 372);
        SystemUtils.log(3, str, "cvv2 = " + this.f30375e, (Throwable) null, "com.didi.payment.creditcard.global.model.GlobalRiskInfo", 373);
        SystemUtils.log(3, str, "stay_time = " + this.f30376f, (Throwable) null, "com.didi.payment.creditcard.global.model.GlobalRiskInfo", 374);
        SystemUtils.log(3, str, "idfa = " + this.f30382l, (Throwable) null, "com.didi.payment.creditcard.global.model.GlobalRiskInfo", 375);
        SystemUtils.log(3, str, "a3 = " + this.f30383m, (Throwable) null, "com.didi.payment.creditcard.global.model.GlobalRiskInfo", 376);
        SystemUtils.log(3, str, "country = " + this.f30384n, (Throwable) null, "com.didi.payment.creditcard.global.model.GlobalRiskInfo", 377);
        SystemUtils.log(3, str, "ip = " + this.f30385o, (Throwable) null, "com.didi.payment.creditcard.global.model.GlobalRiskInfo", 378);
        SystemUtils.log(3, str, "phone_imsi = " + this.f30386p, (Throwable) null, "com.didi.payment.creditcard.global.model.GlobalRiskInfo", 379);
        SystemUtils.log(3, str, "order_id = " + this.f30389s, (Throwable) null, "com.didi.payment.creditcard.global.model.GlobalRiskInfo", 380);
        SystemUtils.log(3, str, "product_line = " + this.f30390t, (Throwable) null, "com.didi.payment.creditcard.global.model.GlobalRiskInfo", 381);
        SystemUtils.log(3, str, "bind_type = " + this.f30377g, (Throwable) null, "com.didi.payment.creditcard.global.model.GlobalRiskInfo", 382);
        SystemUtils.log(3, str, "network_type = " + this.f30387q, (Throwable) null, "com.didi.payment.creditcard.global.model.GlobalRiskInfo", 383);
        SystemUtils.log(3, str, "sign_after_order = " + this.f30388r, (Throwable) null, "com.didi.payment.creditcard.global.model.GlobalRiskInfo", 384);
        SystemUtils.log(3, str, "bankcard_type = " + this.f30378h, (Throwable) null, "com.didi.payment.creditcard.global.model.GlobalRiskInfo", 385);
        SystemUtils.log(3, str, "is_ocr = " + this.f30379i, (Throwable) null, "com.didi.payment.creditcard.global.model.GlobalRiskInfo", 386);
        SystemUtils.log(3, str, "ocr_content = " + this.f30380j, (Throwable) null, "com.didi.payment.creditcard.global.model.GlobalRiskInfo", 387);
        SystemUtils.log(3, str, "resource_id = " + this.f30370A, (Throwable) null, "com.didi.payment.creditcard.global.model.GlobalRiskInfo", 388);
        SystemUtils.log(3, str, "isExistPaste = " + this.f30396z, (Throwable) null, "com.didi.payment.creditcard.global.model.GlobalRiskInfo", 389);
        SystemUtils.log(3, str, "--------------------------- RiskInfo End ------------------------------", (Throwable) null, "com.didi.payment.creditcard.global.model.GlobalRiskInfo", 391);
    }
}
