package com.didi.sdk.global.sign.payselect.utils;

import android.content.Context;
import android.text.TextUtils;
import com.datadog.android.rum.internal.instrumentation.gestures.WindowCallbackWrapper;
import com.didi.component.framework.pages.invitation.InvitationPageActivity;
import com.didi.dimina.container.secondparty.trace.inner.LogBase;
import com.didi.payment.base.tracker.FinOmegaSDK;
import com.didi.payment.base.utils.PayBaseParamUtil;
import com.didi.sdk.global.sign.model.local.PaySelItemData;
import com.didi.sdk.global.sign.payselect.module.BalanceItemModuleKt;
import com.didi.soda.customer.app.constant.Const;
import com.didi.soda.customer.foundation.tracker.param.ParamConst;
import com.didi.unifylogin.utils.LoginConstants;
import com.didi.unifylogin.utils.LoginOmegaUtil;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(mo175977d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010%\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\b\u001a\u00020\u00042\b\u0010\t\u001a\u0004\u0018\u00010\u0004J\u0016\u0010\n\u001a\u00020\u00042\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00040\fH\u0002J\u0016\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0006\u001a\u00020\u0004J\u0014\u0010\u0011\u001a\u00020\u000e2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\fJ&\u0010\u0014\u001a\u00020\u000e2\u0006\u0010\u0015\u001a\u00020\u00042\b\u0010\u0016\u001a\u0004\u0018\u00010\u00042\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00040\fJ\u0006\u0010\u0018\u001a\u00020\u000eJ\u000e\u0010\u0019\u001a\u00020\u000e2\u0006\u0010\u001a\u001a\u00020\u0004J\u0016\u0010\u001b\u001a\u00020\u000e2\u0006\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u0004J\u0016\u0010\u001d\u001a\u00020\u000e2\u0006\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u001e\u001a\u00020\u0004J$\u0010\u001f\u001a\u00020\u000e2\u0006\u0010\u001a\u001a\u00020\u00042\u0012\u0010 \u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010!H\u0002J\u000e\u0010\"\u001a\u00020\u000e2\u0006\u0010#\u001a\u00020$J\u0016\u0010%\u001a\u00020\u000e2\u0006\u0010\u001c\u001a\u00020\u00042\u0006\u0010&\u001a\u00020\u0004J&\u0010'\u001a\u00020\u000e2\u0006\u0010(\u001a\u00020)2\b\u0010\u0016\u001a\u0004\u0018\u00010\u00042\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00040\fR\u000e\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000¨\u0006*"}, mo175978d2 = {"Lcom/didi/sdk/global/sign/payselect/utils/PaySelUT;", "", "()V", "curPage", "", "ext", "resourceId", "uid", "getPromotionIdStr", "logData", "getPromotionNameStr", "tags", "", "init", "", "context", "Landroid/content/Context;", "show", "items", "Lcom/didi/sdk/global/sign/model/local/PaySelItemData;", "trackClkWithPromotionInfo", "buttonName", "utData", "cardDiscountTags", "trackCloseBtn", "trackDlgCancelBtn", "eventId", "trackDlgOKBtn", "channels", "trackDlgShow", "channelId", "trackEvent", "attrs", "", "trackPageSourceFrom", "srcFrom", "", "trackPaySelItemClk", "actionType", "trackSwitchBtn", "selected", "", "payment_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: PaySelUT.kt */
public final class PaySelUT {
    public static final PaySelUT INSTANCE = new PaySelUT();

    /* renamed from: a */
    private static String f36280a = "";

    /* renamed from: b */
    private static String f36281b = "PM_Method";

    /* renamed from: c */
    private static String f36282c = "";

    /* renamed from: d */
    private static String f36283d = "";

    private PaySelUT() {
    }

    public final void init(Context context, String str) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(str, InvitationPageActivity.RESOURCE_ID);
        String stringParam = PayBaseParamUtil.getStringParam(context, "uid");
        Intrinsics.checkNotNullExpressionValue(stringParam, "getStringParam(context, PayParam.UID)");
        f36280a = stringParam;
        f36283d = str;
    }

    public final void show(List<? extends PaySelItemData> list) {
        Intrinsics.checkNotNullParameter(list, FirebaseAnalytics.Param.ITEMS);
        JSONArray jSONArray = new JSONArray();
        boolean z = false;
        int i = 3;
        for (PaySelItemData paySelItemData : list) {
            if (PaySelUtils.INSTANCE.isBalanceChannel(paySelItemData.channelId)) {
                z = BalanceItemModuleKt.canShowTopUpBtn(paySelItemData);
                i = paySelItemData.style == 3 ? paySelItemData.isSelected ? 1 : 2 : 3;
            }
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("channel_id", paySelItemData.channelId);
            jSONObject.put("chosen", paySelItemData.isSelected ? 1 : 0);
            jSONObject.put("recommend", true ^ TextUtils.isEmpty(paySelItemData.mostFavorableTxt) ? 1 : 0);
            jSONObject.put("available", paySelItemData.isEnabled ? 1 : 0);
            jSONObject.put(FirebaseAnalytics.Param.PROMOTION_ID, getPromotionIdStr(paySelItemData.logData));
            List<String> list2 = paySelItemData.cardDiscountTags;
            Intrinsics.checkNotNullExpressionValue(list2, "item.cardDiscountTags");
            jSONObject.put(FirebaseAnalytics.Param.PROMOTION_NAME, m25667a(list2));
            jSONArray.put(jSONObject);
        }
        Map linkedHashMap = new LinkedHashMap();
        String jSONArray2 = jSONArray.toString();
        Intrinsics.checkNotNullExpressionValue(jSONArray2, "itemsInfoJSONArray.toString()");
        linkedHashMap.put("pay_list", jSONArray2);
        linkedHashMap.put("combined", Integer.valueOf(i));
        linkedHashMap.put(LoginConstants.AUTH_BIND_METHOD, "1");
        linkedHashMap.put("recharge", Integer.valueOf(z ? 1 : 0));
        m25668a("fin_pmmethod_sw", linkedHashMap);
    }

    public final String getPromotionIdStr(String str) {
        if (str == null) {
            return "";
        }
        try {
            JSONArray optJSONArray = new JSONObject(str).optJSONArray(FirebaseAnalytics.Param.PROMOTION_ID);
            if (optJSONArray == null) {
                return "";
            }
            String jSONArray = optJSONArray.toString();
            if (jSONArray == null) {
                return "";
            }
            return jSONArray;
        } catch (JSONException e) {
            e.printStackTrace();
            return "";
        }
    }

    /* renamed from: a */
    private final String m25667a(List<String> list) {
        try {
            String jSONArray = new JSONArray(list).toString();
            Intrinsics.checkNotNullExpressionValue(jSONArray, "JSONArray(tags).toString()");
            return jSONArray;
        } catch (JSONException e) {
            e.printStackTrace();
            return "";
        }
    }

    /* renamed from: a */
    private final void m25668a(String str, Map<String, Object> map) {
        map.put(ParamConst.PARAM_PUB_BIZ_LINE, Const.PubBizLine.FIN);
        map.put("pub_subbiz", "payment");
        map.put(LogBase.KEY_UID, f36280a);
        map.put("pub_page", f36281b);
        map.put("ext", f36282c);
        map.put("resource_id", f36283d);
        FinOmegaSDK.trackEvent(str, map);
    }

    public final void trackPaySelItemClk(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "channels");
        Intrinsics.checkNotNullParameter(str2, SDKConstants.PARAM_GAME_REQUESTS_ACTION_TYPE);
        Map linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("button_name", "switch");
        linkedHashMap.put("switch_type", str);
        linkedHashMap.put("action_type", str2);
        m25668a("fin_pmmethod_ck", linkedHashMap);
    }

    public final void trackClkWithPromotionInfo(String str, String str2, List<String> list) {
        Intrinsics.checkNotNullParameter(str, "buttonName");
        Intrinsics.checkNotNullParameter(list, "cardDiscountTags");
        Map linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("button_name", str);
        linkedHashMap.put(FirebaseAnalytics.Param.PROMOTION_ID, getPromotionIdStr(str2));
        linkedHashMap.put(FirebaseAnalytics.Param.PROMOTION_NAME, m25667a(list));
        m25668a("fin_pmmethod_ck", linkedHashMap);
    }

    public final void trackSwitchBtn(boolean z, String str, List<String> list) {
        Intrinsics.checkNotNullParameter(list, "cardDiscountTags");
        Map linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("button_name", "combined");
        linkedHashMap.put("button_type", z ? "1" : "0");
        linkedHashMap.put(FirebaseAnalytics.Param.PROMOTION_ID, getPromotionIdStr(str));
        linkedHashMap.put(FirebaseAnalytics.Param.PROMOTION_NAME, m25667a(list));
        m25668a("fin_pmmethod_ck", linkedHashMap);
    }

    public final void trackCloseBtn() {
        Map linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("button_name", WindowCallbackWrapper.BACK_DEFAULT_TARGET_NAME);
        m25668a("fin_pmmethod_ck", linkedHashMap);
    }

    public final void trackDlgShow(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "eventId");
        Intrinsics.checkNotNullParameter(str2, "channelId");
        Map linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("channel_id", str2);
        m25668a(str, linkedHashMap);
    }

    public final void trackDlgCancelBtn(String str) {
        Intrinsics.checkNotNullParameter(str, "eventId");
        Map linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("button_name", LoginOmegaUtil.NO_EMAIL);
        m25668a(str, linkedHashMap);
    }

    public final void trackDlgOKBtn(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "eventId");
        Intrinsics.checkNotNullParameter(str2, "channels");
        Map linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("button_name", "yes");
        linkedHashMap.put("action_type", "pm_swtich");
        linkedHashMap.put("switch_type", str2);
        m25668a(str, linkedHashMap);
    }

    public final void trackPageSourceFrom(int i) {
        Map linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("src_from", Integer.valueOf(i));
        m25668a("tech_wallet_monitor_paysel_src_from", linkedHashMap);
    }
}
