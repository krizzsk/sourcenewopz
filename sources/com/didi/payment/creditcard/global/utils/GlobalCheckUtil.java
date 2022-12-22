package com.didi.payment.creditcard.global.utils;

import android.content.Context;
import com.didi.payment.creditcard.base.utils.PaymentCheckUtil;
import com.didi.payment.creditcard.base.utils.PaymentTextUtil;
import com.didi.sdk.util.TextUtil;
import com.didi.sdk.util.ToastHelper;
import com.taxis99.R;

public class GlobalCheckUtil {

    /* renamed from: a */
    private static final String f30459a = "^4\\d{15}$|^4\\d{12}$|^4\\d{18}$";

    /* renamed from: b */
    private static final String f30460b = "^5[1-5]\\d{14}$";

    public static String formatCard(String str) {
        String replaceAllSpace = PaymentTextUtil.replaceAllSpace(str);
        try {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < replaceAllSpace.length(); i++) {
                String str2 = replaceAllSpace.charAt(i) + "";
                if (i != 0 && i % 4 == 0) {
                    sb.append(" ");
                }
                sb.append(str2);
            }
            return sb.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return replaceAllSpace;
        }
    }

    public static int getCardOrg(String str) {
        if (TextUtil.isEmpty(str)) {
            return 0;
        }
        String replaceAllSpace = PaymentTextUtil.replaceAllSpace(str);
        if (replaceAllSpace.matches(f30459a)) {
            return 1;
        }
        if (replaceAllSpace.matches(f30460b)) {
            return 2;
        }
        return 0;
    }

    public static boolean checkCreditCardNo(Context context, String str) {
        if (!PaymentCheckUtil.checkLength(str, 13, 19)) {
            ToastHelper.showShortInfo(context, context.getString(R.string.one_payment_creditcard_global_error_cardnumber));
            return false;
        } else if (PaymentCheckUtil.checkLuhn(str)) {
            return true;
        } else {
            ToastHelper.showShortInfo(context, context.getString(R.string.one_payment_creditcard_global_error_cardnumber));
            return false;
        }
    }

    public static boolean checkCreditDebitCardNo(Context context, String str) {
        if (!PaymentCheckUtil.checkLength(str, 13, 19)) {
            ToastHelper.showShortInfo(context, context.getString(R.string.one_payment_creditcard_global_error_cardnumber));
            return false;
        } else if (PaymentCheckUtil.checkLuhn(str)) {
            return true;
        } else {
            ToastHelper.showShortInfo(context, context.getString(R.string.one_payment_creditcard_global_error_cardnumber));
            return false;
        }
    }

    public static boolean checkDate(String str) {
        return PaymentCheckUtil.checkDate(str);
    }

    public static boolean checkCVV(Context context, String str) {
        if (PaymentCheckUtil.checkLength(PaymentTextUtil.replaceAllSpace(str), 2, 4)) {
            return true;
        }
        ToastHelper.showShortInfo(context, context.getString(R.string.one_payment_creditcard_global_error_safe_code));
        return false;
    }
}
