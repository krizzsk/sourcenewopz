package global.didi.pay.presenter;

import android.content.Context;
import com.didi.unifiedPay.util.UniPaySharedPreferencesUtil;

public class GlobalRedPointHelper {
    private static final String CHANNEL_KEY = "uni_channel_red_point";
    private static final String INSTALLMENT_KEY = "uni_installment_red_point";

    public static boolean getInstallmentRedPointVisibility(Context context) {
        return UniPaySharedPreferencesUtil.getBoolean(context, INSTALLMENT_KEY, true);
    }

    public static void setInstallmentRedPointVisibility(Context context) {
        UniPaySharedPreferencesUtil.putBoolean(context, INSTALLMENT_KEY, false);
    }

    public static void markAsClicked(Context context, int i) {
        String string = UniPaySharedPreferencesUtil.getString(context, CHANNEL_KEY, "");
        if (!string.contains("" + i)) {
            UniPaySharedPreferencesUtil.putString(context, CHANNEL_KEY, string + i);
        }
    }

    public static int getRedPointVisibility(Context context, int i, boolean z) {
        return (z && !isClicked(context, i)) ? 0 : 8;
    }

    public static boolean isClicked(Context context, int i) {
        String string = UniPaySharedPreferencesUtil.getString(context, CHANNEL_KEY, "");
        StringBuilder sb = new StringBuilder();
        sb.append("");
        sb.append(i);
        return string.contains(sb.toString());
    }
}
