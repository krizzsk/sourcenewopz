package com.didi.component.business.util;

import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.StyleSpan;
import android.widget.TextView;
import com.didi.sdk.app.BusinessContext;
import com.didichuxing.bigdata.p173dp.locsdk.Const;
import java.util.HashMap;
import java.util.Map;

public class PriceUtils {
    public static final int DEFAULT_TEXT_SIZE = 15;
    public static final String TYPE_ESTIMATE_FEE_AMOUNT = "estimate.fee_amount";
    public static final String TYPE_ESTIMATE_ORIGIN_FEE = "estimate.origin_fee";
    public static final String TYPE_ORDER_ACTUAL_PAY_MONEY = "order.actual_pay_money";
    public static final String TYPE_ORDER_CAP_PRICE = "order.cap_price";
    public static final String TYPE_ORDER_COUPON_FEE = "order.coupon_fee";
    public static final String TYPE_ORDER_TOTAL_FEE = "order.total_fee";
    public static final String TYPE_PUSH_ACTUAL_PAY_MONEY = "push.actual_pay_money";
    public static final String TYPE_PUSH_COUPON_FEE = "push.coupon_fee";
    public static final String TYPE_PUSH_TOTAL_FEE = "push.total_fee";
    public static final String TYPE_REALTIME_TOTAL_FEE = "realtime.total_fee";

    public static String getFeeDisplay(BusinessContext businessContext, double d, String str, String str2) {
        return getFeeDisplay(businessContext, d, str, true, str2);
    }

    public static String getFeeDisplay(BusinessContext businessContext, double d, String str, boolean z, String str2) {
        if (businessContext == null) {
            return "";
        }
        if (TextUtils.isEmpty(str)) {
            String currency = I18NUtils.getCurrency(d, true);
            if (!z) {
                return currency;
            }
            return Const.joLeft + currency + "}";
        } else if (z) {
            return str;
        } else {
            return removeBrackets(str);
        }
    }

    public static String removeBrackets(String str) {
        return !TextUtils.isEmpty(str) ? str.replace(Const.joLeft, "").replace("}", "") : str;
    }

    public static String removeSymbolAndBrackets(String str, String str2) {
        return !TextUtils.isEmpty(str) ? str.replace(Const.joLeft, "").replace("}", "").replace(str2, "") : str;
    }

    public static void setFeeDisplayForTextView(TextView textView, String str) {
        textView.setText(removeBrackets(str));
    }

    public static void setFeeDisplayForTextView(TextView textView, String str, int i, boolean z) {
        textView.setText(m7718a(str, i, z));
    }

    public static String[] getSymbolAndPrice(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String[] strArr = new String[2];
        int indexOf = str.indexOf(Const.joLeft);
        if (indexOf == -1) {
            return strArr;
        }
        strArr[0] = str.substring(0, indexOf);
        strArr[1] = str.substring(indexOf + 1, str.length() - 1);
        return strArr;
    }

    public static String[] getSymbolAndPrice(String str, int i) {
        int indexOf;
        if (i == 0) {
            return getSymbolAndPrice(str);
        }
        String[] strArr = new String[3];
        if (i == 1) {
            String trim = str.trim();
            if (TextUtils.isEmpty(trim)) {
                return null;
            }
            int indexOf2 = trim.indexOf(Const.joLeft);
            if (indexOf2 <= -1 || (indexOf = trim.indexOf("}")) <= 1) {
                return strArr;
            }
            String str2 = "";
            strArr[0] = indexOf2 > 0 ? trim.substring(0, indexOf2) : str2;
            strArr[1] = trim.substring(indexOf2 + 1, indexOf);
            if (indexOf < trim.length() - 1) {
                str2 = trim.substring(indexOf + 1);
            }
            strArr[2] = str2;
        }
        return strArr;
    }

    /* renamed from: a */
    private static SpannableStringBuilder m7718a(String str, int i, boolean z) {
        if (TextUtils.isEmpty(str)) {
            return new SpannableStringBuilder("");
        }
        int indexOf = str.indexOf(Const.joLeft);
        if (indexOf >= 0) {
            str = str.replace(Const.joLeft, "");
        }
        int indexOf2 = str.indexOf("}");
        if (indexOf2 >= 0) {
            str = str.replace("}", "");
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
        try {
            spannableStringBuilder.setSpan(new AbsoluteSizeSpan(i, true), indexOf, indexOf2, 34);
            if (z) {
                spannableStringBuilder.setSpan(new StyleSpan(1), indexOf, indexOf2, 18);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return spannableStringBuilder;
    }

    /* renamed from: a */
    private static void m7719a(String str, String str2) {
        HashMap hashMap = new HashMap();
        hashMap.put("path", str);
        hashMap.put("proj", str2);
        GlobalOmegaUtils.trackEvent("gp_missing_resp_param", (Map<String, Object>) hashMap);
    }
}
