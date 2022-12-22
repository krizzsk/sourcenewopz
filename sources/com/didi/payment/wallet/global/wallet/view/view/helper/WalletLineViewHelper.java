package com.didi.payment.wallet.global.wallet.view.view.helper;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.widget.LinearLayout;
import com.didi.payment.base.utils.RTLUtil;
import com.didi.payment.creditcard.base.utils.PaymentTextUtil;

public class WalletLineViewHelper {
    public static void addLeftMarginLineView(Context context, LinearLayout linearLayout) {
        if (linearLayout != null) {
            View view = new View(context);
            view.setBackgroundColor(Color.parseColor("#0A000000"));
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, 1);
            int dip2px = PaymentTextUtil.dip2px(context, 18.0f);
            if (!RTLUtil.isInRTLMode()) {
                layoutParams.setMargins(dip2px, 0, 0, 0);
            } else {
                layoutParams.setMargins(0, 0, dip2px, 0);
            }
            linearLayout.addView(view, layoutParams);
        }
    }

    public static void addLineView(Context context, LinearLayout linearLayout) {
        if (linearLayout != null) {
            View view = new View(context);
            view.setBackgroundColor(Color.parseColor("#0A000000"));
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, 1);
            layoutParams.setMargins(0, 0, 0, 0);
            linearLayout.addView(view, layoutParams);
        }
    }
}
