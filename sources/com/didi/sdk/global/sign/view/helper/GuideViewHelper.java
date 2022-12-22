package com.didi.sdk.global.sign.view.helper;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewTreeObserver;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.sdk.apm.SystemUtils;
import com.didi.sdk.global.sign.view.PayMethodCardView;
import com.didi.sdk.pay.util.PaymentSharedPreferencesUtil;
import com.didi.sdk.payment.util.PayUtil;
import com.didi.sdk.view.tips.TipsContainer;
import com.didi.sdk.view.tips.TipsView;
import com.taxis99.R;
import java.util.List;

public class GuideViewHelper {

    /* renamed from: a */
    private static final String f36350a = "KEY_GLOBAL_BALANCE_SWITCH_GUIDE_CLOSED";

    public static void showGuideView(Context context, List<PayMethodCardView> list) {
        PayMethodCardView a = m25721a(list);
        if (a != null) {
            m25723b(context, a);
        }
    }

    /* renamed from: a */
    private static PayMethodCardView m25721a(List<PayMethodCardView> list) {
        for (PayMethodCardView next : list) {
            if ((next.getPayMethodItemInfo().channelId == 120 || next.getPayMethodItemInfo().channelId == 190) && next.getPayMethodItemInfo().style == 3) {
                return next;
            }
        }
        return null;
    }

    /* renamed from: b */
    private static void m25723b(final Context context, final PayMethodCardView payMethodCardView) {
        if (payMethodCardView != null && payMethodCardView.isEnabled() && !PaymentSharedPreferencesUtil.getBoolean(context, f36350a, false)) {
            payMethodCardView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
                public void onGlobalLayout() {
                    GuideViewHelper.m25724c(context, payMethodCardView);
                    payMethodCardView.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                }
            });
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public static void m25724c(final Context context, PayMethodCardView payMethodCardView) {
        TipsContainer tipsContainer = new TipsContainer((Activity) context);
        String string = context.getString(R.string.GRider_1_Balance_preferred_bVoR);
        TipsView tipsView = new TipsView(context);
        tipsView.setMoreLineTips(string);
        tipsView.setId(payMethodCardView.hashCode());
        tipsView.setLeftMargin(PayUtil.dip2px(context, 88.0f));
        tipsView.setRightMargin(PayUtil.dip2px(context, 17.0f));
        tipsView.setMinimumWidth(PayUtil.dip2px(context, 600.0f));
        tipsView.setCloseListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                SystemUtils.log(3, "wallet", "User closed the global balance switch guide", (Throwable) null, "com.didi.sdk.global.sign.view.helper.GuideViewHelper$2", 105);
                PaymentSharedPreferencesUtil.putBoolean(context, GuideViewHelper.f36350a, true);
            }
        });
        tipsContainer.show(tipsView, payMethodCardView, 2, 4, payMethodCardView.getLeft(), payMethodCardView.getChannelId() == 190 ? -PayUtil.dip2px(context, 15.0f) : payMethodCardView.getTop() - PayUtil.dip2px(context, 15.0f), false);
    }
}
