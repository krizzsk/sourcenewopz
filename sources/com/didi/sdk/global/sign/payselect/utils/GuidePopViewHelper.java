package com.didi.sdk.global.sign.payselect.utils;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.PopupWindow;
import com.didi.payment.base.utils.UIUtil;
import com.didi.sdk.global.sign.model.local.PaySelItemData;
import com.didi.sdk.pay.util.PaymentSharedPreferencesUtil;
import com.taxis99.R;

public class GuidePopViewHelper {

    /* renamed from: a */
    static PopupWindow f36278a = null;

    /* renamed from: b */
    private static final String f36279b = "KEY_GLOBAL_BALANCE_SWITCH_GUIDE_CLOSED";

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static void m25660b(Context context, View view, int i) {
        if (f36278a == null) {
            f36278a = new PopupWindow(LayoutInflater.from(context).inflate(R.layout.payment_paysel_pop_guide_view, (ViewGroup) null), -2, -2);
            int i2 = 0;
            if (i == 190) {
                i2 = UIUtil.dip2px(context, -106.0f);
            } else if (i == 120) {
                i2 = UIUtil.dip2px(context, -132.0f);
            }
            f36278a.showAsDropDown(view, i2, UIUtil.dip2px(context, -84.0f));
            PaymentSharedPreferencesUtil.putBoolean(context, f36279b, true);
        }
    }

    public static void showGuideView(final View view, final PaySelItemData paySelItemData) {
        if (view != null && view.getContext() != null && view.isEnabled() && !paySelItemData.isFrozen && PaySelUtils.INSTANCE.isBalanceChannel(paySelItemData.channelId) && paySelItemData.style == 3) {
            final Context context = view.getContext();
            if (!PaymentSharedPreferencesUtil.getBoolean(context, f36279b, false)) {
                view.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
                    public void onGlobalLayout() {
                        GuidePopViewHelper.m25660b(context, view, paySelItemData.channelId);
                        view.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                    }
                });
            }
        }
    }

    public static void dismiss() {
        PopupWindow popupWindow = f36278a;
        if (popupWindow != null) {
            popupWindow.dismiss();
            f36278a = null;
        }
    }
}
