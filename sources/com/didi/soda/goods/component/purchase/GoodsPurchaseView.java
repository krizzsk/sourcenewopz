package com.didi.soda.goods.component.purchase;

import android.animation.ArgbEvaluator;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.animation.Interpolator;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import com.didi.soda.customer.animation.CustomerInterpolator;
import com.didi.soda.customer.foundation.log.util.LogUtil;
import com.didi.soda.customer.foundation.util.DialogUtil;
import com.didi.soda.customer.foundation.util.KeyboardUtils;
import com.didi.soda.customer.foundation.util.ToastUtil;
import com.didi.soda.customer.foundation.util.ViewSafeHelper;
import com.didi.soda.customer.widget.abnormal.topgun.TopGunAbnormalView;
import com.didi.soda.customer.widget.abnormal.topgun.TopGunAbnormalViewModel;
import com.didi.soda.goods.binder.GoodsPurchaseCounterBinder;
import com.didi.soda.goods.binder.GoodsPurchaseHeaderBinder;
import com.didi.soda.goods.binder.GoodsPurchaseTitleBinder;
import com.didi.soda.goods.component.purchase.Contract;
import com.taxis99.R;

public class GoodsPurchaseView extends Contract.AbsGoodsPurchaseView {

    /* renamed from: a */
    private static final String f42403a = "GoodsPurchaseView";
    /* access modifiers changed from: private */

    /* renamed from: b */
    public View f42404b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public View f42405c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public View f42406d;

    /* renamed from: e */
    private ArgbEvaluator f42407e = new ArgbEvaluator();

    /* renamed from: f */
    private ViewTreeObserver.OnGlobalLayoutListener f42408f;
    @BindView(17908)
    TopGunAbnormalView mAbnormalView;

    public void exceedMinAmount() {
    }

    public void exceedMaxAmount(int i) {
        ToastUtil.showCustomerErrorToast(getScopeContext(), getContext().getResources().getQuantityString(R.plurals.customer_business_goods_add_num_restriction, i, new Object[]{Integer.valueOf(i)}));
    }

    public void exceedMaxSaleAmount(int i) {
        ToastUtil.showCustomerErrorToast(getScopeContext(), getContext().getResources().getQuantityString(R.plurals.customer_business_exceed_sale_amount, i, new Object[]{Integer.valueOf(i)}));
    }

    public void hideLoadingView() {
        DialogUtil.hideLoadingDialog();
    }

    public void onCreate() {
        super.onCreate();
        this.mRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            public void onScrolled(RecyclerView recyclerView, int i, int i2) {
                super.onScrolled(recyclerView, i, i2);
                GoodsPurchaseView.this.m29892a();
            }
        });
    }

    public void showLoadingView() {
        DialogUtil.showLoadingDialog(getScopeContext(), false);
    }

    public void updateHeadImage(boolean z) {
        this.f42408f = new ViewTreeObserver.OnGlobalLayoutListener(z) {
            public final /* synthetic */ boolean f$1;

            {
                this.f$1 = r2;
            }

            public final void onGlobalLayout() {
                GoodsPurchaseView.this.m29895a(this.f$1);
            }
        };
        getView().getViewTreeObserver().addOnGlobalLayoutListener(this.f42408f);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m29895a(boolean z) {
        getView().getViewTreeObserver().removeOnGlobalLayoutListener(this.f42408f);
        this.mSmoothScroller.setOffset(this.mTitleView.getBottom());
        if (z) {
            this.mTitleView.setBackgroundColor(0);
            return;
        }
        this.mTitleTvView.setAlpha(1.0f);
        this.mTitleView.setBackgroundColor(-1);
    }

    public void showGoodsContent() {
        this.mBottomButton.setVisibility(0);
        this.mStickyHeaderContainer.setVisibility(0);
    }

    public void hideGoodsContent() {
        this.mStickyHeaderContainer.setVisibility(4);
        this.mBottomButton.setVisibility(4);
    }

    public void hideAbnormalView() {
        this.mAbnormalView.setVisibility(4);
    }

    public void showAbnormalView(TopGunAbnormalViewModel topGunAbnormalViewModel) {
        this.mAbnormalView.setVisibility(0);
        this.mAbnormalView.show(topGunAbnormalViewModel);
    }

    public void hideBottomButton() {
        this.mBottomButton.setVisibility(4);
    }

    public void showBottomButton() {
        this.mBottomButton.setVisibility(0);
    }

    /* access modifiers changed from: protected */
    public View inflateView(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        return layoutInflater.inflate(R.layout.customer_component_goods_purchase, viewGroup, true);
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        KeyboardUtils.hideSoftInput(getContext(), getView());
        getView().getViewTreeObserver().removeOnGlobalLayoutListener(this.f42408f);
    }

    /* access modifiers changed from: protected */
    public void initItemBinders() {
        super.initItemBinders();
        registerBinder(new GoodsPurchaseHeaderBinder() {
            public void onBind(View view, View view2, View view3) {
                View unused = GoodsPurchaseView.this.f42406d = view;
                View unused2 = GoodsPurchaseView.this.f42405c = view2;
                View unused3 = GoodsPurchaseView.this.f42404b = view3;
            }
        });
        registerBinder(new GoodsPurchaseTitleBinder());
        registerBinder(new GoodsPurchaseCounterBinder() {
            public void onAddGoodsClick(String str, View view, Bundle bundle) {
                ((Contract.AbsGoodsPurchasePresenter) GoodsPurchaseView.this.getPresenter()).onAddGoodsClick(str, view, bundle);
            }

            public void onSubtractGoodsClick(String str, Bundle bundle) {
                ((Contract.AbsGoodsPurchasePresenter) GoodsPurchaseView.this.getPresenter()).onSubtractGoodsClick(str, bundle);
            }
        });
    }

    /* renamed from: a */
    private void m29894a(String str) {
        LogUtil.m29100d(f42403a, str);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m29892a() {
        if (this.f42405c != null && this.f42404b != null && this.f42406d != null && ViewSafeHelper.safeIndexOfView(this.mRecyclerView, this.f42406d) >= 0) {
            int[] iArr = new int[2];
            this.mTitleView.getLocationInWindow(iArr);
            if (this.f42404b.getVisibility() == 0) {
                int[] iArr2 = new int[2];
                this.f42404b.getLocationInWindow(iArr2);
                float min = Math.min(1.0f, ((float) Math.max(0, (iArr[1] - iArr2[1]) - (this.f42404b.getHeight() / 2))) / ((float) ((this.f42404b.getHeight() - this.mTitleView.getHeight()) - (this.f42404b.getHeight() / 2))));
                this.mTitleView.setBackgroundColor(((Integer) this.f42407e.evaluate(min, Integer.valueOf(Color.argb(0, 255, 255, 255)), Integer.valueOf(Color.argb(255, 255, 255, 255)))).intValue());
                this.mBackView.setTextColor(((Integer) this.f42407e.evaluate(min, Integer.valueOf(Color.argb(255, 255, 255, 255)), Integer.valueOf(Color.argb(255, 0, 0, 0)))).intValue());
                int[] iArr3 = new int[2];
                this.f42405c.getLocationInWindow(iArr3);
                float min2 = Math.min(1.0f, ((float) Math.max(0, ((this.mTitleView.getHeight() + iArr[1]) - this.f42405c.getHeight()) - iArr3[1])) / ((float) this.f42405c.getHeight()));
                this.mTitleTvView.setAlpha(min2);
                this.f42405c.setAlpha(1.0f - min2);
            }
        }
    }

    /* renamed from: b */
    private Interpolator m29897b() {
        return CustomerInterpolator.newInstance();
    }
}
