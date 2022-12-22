package com.didi.soda.goods.component.multilevel;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import com.didi.soda.goods.component.multilevel.Contract;
import com.taxis99.R;

/* renamed from: com.didi.soda.goods.component.multilevel.b */
/* compiled from: MultiLevelView */
class C13916b extends Contract.AbsMultiLevelView {

    /* renamed from: a */
    private ViewTreeObserver.OnGlobalLayoutListener f42368a;

    C13916b() {
    }

    public void onCreate() {
        super.onCreate();
        this.mBottomButton.changeAddCartText(getString(R.string.customer_dialog_confirm));
        this.f42368a = new ViewTreeObserver.OnGlobalLayoutListener() {
            public final void onGlobalLayout() {
                C13916b.this.m29846a();
            }
        };
        getView().getViewTreeObserver().addOnGlobalLayoutListener(this.f42368a);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m29846a() {
        getView().getViewTreeObserver().removeOnGlobalLayoutListener(this.f42368a);
        this.mSmoothScroller.setOffset(this.mTitleView.getBottom());
        this.mTitleView.setBackgroundColor(-1);
    }

    /* access modifiers changed from: protected */
    public View inflateView(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        return layoutInflater.inflate(R.layout.customer_component_goods_purchase, viewGroup, true);
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        getView().getViewTreeObserver().removeOnGlobalLayoutListener(this.f42368a);
    }
}
