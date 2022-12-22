package global.didi.pay.omega;

import android.content.Context;
import android.text.TextUtils;
import com.didi.payment.base.utils.PayBaseParamUtil;
import com.didi.raven.config.RavenKey;
import com.didi.soda.customer.foundation.tracker.param.ParamConst;
import com.didi.unifiedPay.util.OmegaUtils;
import com.didichuxing.mlcp.drtc.consts.SDKConsts;
import global.didi.pay.omega.GlobalPayOmegaConstant;
import java.util.HashMap;
import java.util.Map;

public class GlobalPayOmegaManager {
    private Map<String, Object> mExtraAttrs;
    private String mOid;
    private String mOutTradeId;

    private String convertToBooleanString(boolean z) {
        return z ? "true" : SDKConsts.BOOLEAN_FALSE;
    }

    public GlobalPayOmegaManager(String str) {
        this.mOid = str;
    }

    public GlobalPayOmegaManager() {
        this.mOid = "";
    }

    public void updateOid(String str, String str2) {
        if (TextUtils.isEmpty(this.mOid)) {
            this.mOid = str;
        }
        this.mOutTradeId = str2;
    }

    public void addOmegaAttr(Map<String, Object> map) {
        if (this.mExtraAttrs == null) {
            this.mExtraAttrs = new HashMap();
        }
        if (map != null) {
            this.mExtraAttrs.putAll(map);
        }
    }

    public String getOmegaAttr(String str) {
        Map<String, Object> map = this.mExtraAttrs;
        if (map == null || map.get(str) == null) {
            return null;
        }
        return (String) this.mExtraAttrs.get(str);
    }

    public void doOmegaForShowLoading(String str, String str2) {
        doOmega("payCard_resultwait_sw", str, str2);
    }

    public void doOmegaForRetry(String str, String str2) {
        doOmega("payCard_ab_retry", str, str2);
    }

    public void doOmegaForPayError(String str, String str2) {
        doOmega("payCard_ab_sw", str, str2);
    }

    public void doOmegaForDoPay(String str, String str2, String str3, String str4, String str5, String str6) {
        HashMap hashMap = new HashMap();
        hashMap.put("order_id", this.mOid);
        hashMap.put("out_trade_id", this.mOutTradeId);
        hashMap.put("app_id", str2);
        hashMap.put("appid", str2);
        hashMap.put("pay_method", str);
        hashMap.put(GlobalPayOmegaConstant.EventKey.IBT_WALLET_IS_COUPON, Boolean.valueOf(convertToStringBoolean(str3)));
        hashMap.put(GlobalPayOmegaConstant.EventKey.IBT_WALLET_INSTALLMENT_PLAN, str4);
        hashMap.put("amount", str5);
        if (!TextUtils.isEmpty(str6)) {
            hashMap.put("type", str6);
        }
        doOmega(GlobalPayOmegaConstant.EventId.PAY_BTN_CLICK_ID, (Map<String, Object>) hashMap, true);
    }

    public void doOmegaForInstallmentClick() {
        doOmega(GlobalPayOmegaConstant.EventId.ibt_didipay_installment_select_ck, new HashMap());
    }

    public void doOmegaForInstallmentPageShow() {
        doOmega(GlobalPayOmegaConstant.EventId.ibt_didipay_installment_option_sw, new HashMap());
    }

    public void doOmegaForInstallmentPageConfirm(String str) {
        HashMap hashMap = new HashMap();
        hashMap.put(GlobalPayOmegaConstant.EventKey.IBT_WALLET_INSTALLMENT_PLAN, str);
        doOmega(GlobalPayOmegaConstant.EventId.ibt_didipay_installment_option_ck, hashMap);
    }

    public void doOmegaForClose(String str, String str2, String str3) {
        HashMap hashMap = new HashMap();
        hashMap.put("order_id", this.mOid);
        hashMap.put("out_trade_id", this.mOutTradeId);
        hashMap.put("pay_method", str);
        hashMap.put(GlobalPayOmegaConstant.EventKey.IBT_WALLET_IS_COUPON, Boolean.valueOf(convertToStringBoolean(str2)));
        if (!TextUtils.isEmpty(str3)) {
            hashMap.put("type", str3);
        }
        doOmega(GlobalPayOmegaConstant.EventId.PAY_CARD_CLOSE_ID, (Map<String, Object>) hashMap, true);
    }

    public void doOmegaForChangePayType(String str, String str2, boolean z, boolean z2, String str3) {
        HashMap hashMap = new HashMap();
        hashMap.put("order_id", this.mOid);
        hashMap.put("out_trade_id", this.mOutTradeId);
        hashMap.put("pay_method", str);
        hashMap.put(GlobalPayOmegaConstant.EventKey.IBT_WALLET_IS_COUPON, Boolean.valueOf(convertToStringBoolean(str2)));
        hashMap.put(GlobalPayOmegaConstant.EventKey.IBT_WALLET_INSTALLMENT_TOAST, Integer.valueOf(z2 ? 1 : 0));
        hashMap.put(GlobalPayOmegaConstant.EventKey.IBT_WALLET_INSTALLMENT_STATUS, Integer.valueOf(z ? 1 : 0));
        if (!TextUtils.isEmpty(str3)) {
            hashMap.put("type", str3);
        }
        doOmega(GlobalPayOmegaConstant.EventId.GLOBAL_PAYFAILURE_PAYMENT_CK, (Map<String, Object>) hashMap, true);
    }

    public void doOmegaForChangecoupon(String str, String str2) {
        HashMap hashMap = new HashMap();
        hashMap.put("order_id", this.mOid);
        hashMap.put("out_trade_id", this.mOutTradeId);
        hashMap.put("pay_method", str);
        hashMap.put(GlobalPayOmegaConstant.EventKey.IBT_WALLET_IS_COUPON, Boolean.valueOf(convertToStringBoolean(str2)));
        doOmega(GlobalPayOmegaConstant.EventId.PAY_SWITCH_COUPON_ID, (Map<String, Object>) hashMap, true);
    }

    public void doOmegaForThreedsCall(String str, String str2) {
        HashMap hashMap = new HashMap();
        hashMap.put("order_id", this.mOid);
        hashMap.put("out_trade_id", this.mOutTradeId);
        hashMap.put("scene", "trade");
        hashMap.put("pub_biz", "fintech");
        hashMap.put("type", str);
        hashMap.put("uid", str2);
        doOmega(GlobalPayOmegaConstant.EventId.ibt_3ds_verify_st, (Map<String, Object>) hashMap, false);
    }

    public void doOmegaForThreedsCallback(String str, String str2, String str3, String str4, int i) {
        HashMap hashMap = new HashMap();
        hashMap.put("order_id", this.mOid);
        hashMap.put("out_trade_id", this.mOutTradeId);
        hashMap.put("uid", str);
        hashMap.put("scene", "trade");
        hashMap.put("pub_biz", "fintech");
        hashMap.put("errno", str3);
        hashMap.put("errno_json", str4);
        hashMap.put("is_cancel", Integer.valueOf(i));
        hashMap.put("auth", str2);
        doOmega(GlobalPayOmegaConstant.EventId.ibt_3ds_verify_result_ex, (Map<String, Object>) hashMap, false);
    }

    public static void doOmegaForThreedsResult(String str, String str2, int i) {
        HashMap hashMap = new HashMap();
        hashMap.put("order_id", str2);
        hashMap.put("scene", "trade");
        hashMap.put("uid", str);
        hashMap.put("pub_biz", "fintech");
        hashMap.put("result", Integer.valueOf(i));
        OmegaUtils.trackEvent(GlobalPayOmegaConstant.EventId.ibt_3ds_verify_result_server_st, (String) null, (Map<String, Object>) hashMap);
    }

    public void doOmegaForPixPrepay(String str, String str2, String str3, String str4) {
        HashMap hashMap = new HashMap();
        if (!TextUtils.isEmpty(str3)) {
            hashMap.put(GlobalPayOmegaConstant.EventKey.TAB, str3);
        }
        if (!TextUtils.isEmpty(str4)) {
            hashMap.put("time", str4);
        }
        if (!TextUtils.isEmpty(str2)) {
            hashMap.put("type", str2);
        }
        doOmega(str, hashMap);
    }

    public void doOmegaForPixShow(String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("uid", str);
        doOmega(GlobalPayOmegaConstant.EventId.ibt_gp_cashier_pixpayment_sw, (Map<String, Object>) hashMap, true);
    }

    public void doOmegaForPixConfirm(String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("uid", str);
        doOmega(GlobalPayOmegaConstant.EventId.ibt_gp_cashier_pixpayment_copycode_ck, (Map<String, Object>) hashMap, true);
    }

    public void doOmegaForPixCancel(String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("uid", str);
        doOmega(GlobalPayOmegaConstant.EventId.ibt_gp_cashier_pixpayment_cancel_ck, (Map<String, Object>) hashMap, true);
    }

    public void doOmegaForPixPay(String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("uid", str);
        doOmega(GlobalPayOmegaConstant.EventId.ibt_gp_cashier_pixpayment_paid_ck, (Map<String, Object>) hashMap, true);
    }

    public void doOmegaForShowRoot(String str, String str2, String str3, boolean z, String str4) {
        HashMap hashMap = new HashMap();
        hashMap.put("order_id", this.mOid);
        hashMap.put("out_trade_id", this.mOutTradeId);
        hashMap.put("app_id", str3);
        hashMap.put("appid", str3);
        hashMap.put("pay_method", str);
        hashMap.put(GlobalPayOmegaConstant.EventKey.IBT_WALLET_IS_COUPON, Boolean.valueOf(convertToStringBoolean(str2)));
        hashMap.put(GlobalPayOmegaConstant.EventKey.IBT_WALLET_INSTALLMENT_STATUS, Integer.valueOf(z ? 1 : 0));
        if (!TextUtils.isEmpty(str4)) {
            hashMap.put("type", str4);
        }
        doOmega(GlobalPayOmegaConstant.EventId.PAY_CARD_SHOW_ID, (Map<String, Object>) hashMap, true);
    }

    public void doOmegaForShowSuccess(String str, String str2) {
        doOmega("payCard_suc", str, str2);
    }

    public void doOmegaForFeeDetailClick(String str, String str2) {
        doOmega("payCard_detail_sw", str, str2);
    }

    public void doOmegaForWaitResult(String str, String str2) {
        doOmega("payCard_resultwait_sw", str, str2);
    }

    public void doOmegaPayFailFAQClick(String str, String str2) {
        doOmega("ibt_gp_payfail_popup_faq_ck", str, str2);
    }

    public static void doOmegaForPayError(int i, String str, int i2, String str2, String str3) {
        HashMap hashMap = new HashMap();
        hashMap.put("err_type", Integer.valueOf(i));
        hashMap.put("err_msg", str);
        hashMap.put("err_no", Integer.valueOf(i2));
        hashMap.put(ParamConst.TRACE_ID, str2);
        hashMap.put("module", str3);
        OmegaUtils.trackEvent("tech_pax_event_pay_error", (String) null, (Map<String, Object>) hashMap);
    }

    public void trackPayMethodSelectPageSW(Context context, int i, String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("source", Integer.valueOf(i));
        hashMap.put("passenger_id", getPassengerId(context));
        hashMap.put("city_id", getCityId(context));
        hashMap.put("payment", str);
        doOmega("global_pas_payment_sw", hashMap);
    }

    public void trackPayMethodThirdSDKSelectPageSW(String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("type", "3rd merchant");
        hashMap.put(GlobalPayOmegaConstant.EventKey.TAB, com.didi.entrega.customer.foundation.tracker.param.ParamConst.PARAM_PAY_TYPE);
        hashMap.put("k", "access");
        hashMap.put("style", str);
        doOmega(GlobalPayOmegaConstant.EventId.IBT_THIRDSDK_PAYTYPE_PAGE_SW, hashMap);
    }

    public void trackPayMethodSelectPageReturnCK(Context context, int i) {
        HashMap hashMap = new HashMap();
        hashMap.put("source", Integer.valueOf(i));
        hashMap.put("passenger_id", getPassengerId(context));
        hashMap.put("city_id", getCityId(context));
        doOmega("global_pas_payment_return_ck", hashMap);
    }

    public void trackPayMethodBindCardCk(Context context, String str, String str2) {
        HashMap hashMap = new HashMap();
        hashMap.put("app_id", str);
        hashMap.put("appid", str);
        hashMap.put("passenger_id", getPassengerId(context));
        hashMap.put("city_id", getCityId(context));
        hashMap.put("product_id", str2);
        hashMap.put("type", "3");
        hashMap.put("resource_id", "8");
        doOmega("global_pas_payment_credit_ck", hashMap);
    }

    public void trackPayMethodSelectPageChannelCK(Context context, int i, int i2, int i3, int i4, String str, boolean z) {
        HashMap hashMap = new HashMap();
        hashMap.put("source", Integer.valueOf(i2));
        hashMap.put("passenger_id", getPassengerId(context));
        hashMap.put("city_id", getCityId(context));
        hashMap.put("type", Integer.valueOf(i3));
        hashMap.put("card_count", Integer.valueOf(i4));
        hashMap.put(GlobalPayOmegaConstant.EventKey.LAST_PAYMENT_TYPE, str);
        hashMap.put(GlobalPayOmegaConstant.EventKey.HAS_CREDIT_CARD, convertToBooleanString(i4 > 0));
        hashMap.put(GlobalPayOmegaConstant.EventKey.HAS_SUFFICENT_99PAY_BALANCE, convertToBooleanString(z));
        doOmega(i != 121 ? i != 150 ? i != 152 ? i != 190 ? i != 182 ? i != 183 ? "unKnow" : "gp_payment_paypalv2_ck" : "global_pas_payment_paypay_ck" : GlobalPayOmegaConstant.EventId.GLOBAL_PAS_PAYMENT_NINENINEPAY_CK : "global_pas_payment_paypal_ck" : "global_pas_payment_credit_ck" : "global_pas_payment_enterprise_ck", hashMap);
    }

    public void doOmegaForThirdStatusPageSW() {
        HashMap hashMap = new HashMap();
        hashMap.put("type", "3rd merchant");
        hashMap.put(GlobalPayOmegaConstant.EventKey.TAB, "pay_success_page");
        hashMap.put("k", "access");
        doOmega(GlobalPayOmegaConstant.EventId.IBT_THIRDSDK_PAY_SUCCESS_PAGE_SW, hashMap);
    }

    public void doOmegaForThirdStatusPageConfirmCK() {
        HashMap hashMap = new HashMap();
        hashMap.put("type", "3rd merchant");
        hashMap.put(GlobalPayOmegaConstant.EventKey.TAB, "pay_success_page");
        hashMap.put("k", "click");
        hashMap.put(RavenKey.VERSION, "confirm_btn");
        doOmega(GlobalPayOmegaConstant.EventId.IBT_THIRDSDK_CONFIRM_BTN_CK, hashMap);
    }

    private String getPassengerId(Context context) {
        return context == null ? "" : PayBaseParamUtil.getStringParam(context, "uid");
    }

    private String getCityId(Context context) {
        return context == null ? "" : PayBaseParamUtil.getStringParam(context, "trip_city_id");
    }

    private void doOmega(String str, String str2, String str3) {
        HashMap hashMap = new HashMap();
        hashMap.put("order_id", this.mOid);
        hashMap.put("out_trade_id", this.mOutTradeId);
        hashMap.put(GlobalPayOmegaConstant.EventKey.PAYMETHOD_NAME, str2);
        hashMap.put("coupon", str3);
        doOmega(str, hashMap);
    }

    private void doOmega(String str, Map<String, Object> map, boolean z) {
        doOmega(str, map);
    }

    private void doOmega(String str, Map<String, Object> map) {
        HashMap hashMap = new HashMap();
        if (map != null) {
            hashMap.putAll(map);
        }
        Map<String, Object> map2 = this.mExtraAttrs;
        if (map2 != null) {
            hashMap.putAll(map2);
        }
        OmegaUtils.trackEvent(str, (String) null, (Map<String, Object>) hashMap);
    }

    private boolean convertToStringBoolean(String str) {
        return !TextUtils.isEmpty(str);
    }
}
