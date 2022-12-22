package global.didi.pay.presenter;

import android.content.Context;
import com.didi.unifiedPay.util.UniPaySharedPreferencesUtil;

public class GlobalBubbleShowHelper {
    public static final String INSTALLMENT_KEY = "g_payment_installment_bubble";
    public static final long ONE_WEEK = 604800000;

    public static boolean show(Context context) {
        long parseLong = Long.parseLong(UniPaySharedPreferencesUtil.getString(context, INSTALLMENT_KEY, "0"));
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - parseLong < ONE_WEEK) {
            return false;
        }
        UniPaySharedPreferencesUtil.putString(context, INSTALLMENT_KEY, String.valueOf(currentTimeMillis));
        return true;
    }
}
