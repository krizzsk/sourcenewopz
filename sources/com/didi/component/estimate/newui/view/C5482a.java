package com.didi.component.estimate.newui.view;

import android.view.View;
import androidx.viewpager.widget.ViewPager;

/* renamed from: com.didi.component.estimate.newui.view.a */
/* compiled from: CarDetailPagerTransFormer */
class C5482a implements ViewPager.PageTransformer {
    C5482a() {
    }

    public void transformPage(View view, float f) {
        EstimateDetailPageView estimateDetailPageView = (EstimateDetailPageView) view;
        int i = (f > 0.0f ? 1 : (f == 0.0f ? 0 : -1));
        if (i == 0) {
            estimateDetailPageView.resetAnim();
        }
        if (f >= -1.0f && f <= 0.0f) {
            estimateDetailPageView.startAnimOfMinus(Math.abs(f));
        }
        if (i > 0 && f <= 1.0f) {
            estimateDetailPageView.startAnimOfPositive(f);
        }
    }
}
