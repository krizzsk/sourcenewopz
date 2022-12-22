package com.didi.soda.goodsV2.component.purchase;

import android.animation.ArgbEvaluator;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.animation.Interpolator;
import android.widget.ImageView;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import com.didi.soda.customer.animation.CustomerInterpolator;
import com.didi.soda.customer.foundation.log.util.LogUtil;
import com.didi.soda.customer.foundation.rpc.entity.bill.RuleDescEntity;
import com.didi.soda.customer.foundation.util.DialogUtil;
import com.didi.soda.customer.foundation.util.KeyboardUtils;
import com.didi.soda.customer.foundation.util.ToastUtil;
import com.didi.soda.customer.foundation.util.ViewSafeHelper;
import com.didi.soda.customer.widget.abnormal.topgun.TopGunAbnormalView;
import com.didi.soda.customer.widget.abnormal.topgun.TopGunAbnormalViewModel;
import com.didi.soda.customer.widget.goodsV2.GoodsQuantityListener;
import com.didi.soda.customer.widget.goodsV2.purchase.GoodsPurchaseCounter;
import com.didi.soda.goodsV2.binder.GoodsPurchaseHeaderBinder;
import com.didi.soda.goodsV2.binder.GoodsPurchaseTitleBinder;
import com.didi.soda.goodsV2.component.purchase.Contract;
import com.didi.soda.goodsV2.model.GoodsPurchaseCounterRvModel;
import com.didi.soda.router.DiRouter;
import com.taxis99.R;

public class GoodsPurchaseView extends Contract.AbsGoodsPurchaseView {

    /* renamed from: a */
    private static final String f42493a = "GoodsPurchaseView";
    /* access modifiers changed from: private */

    /* renamed from: b */
    public View f42494b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public View f42495c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public View f42496d;

    /* renamed from: e */
    private ArgbEvaluator f42497e = new ArgbEvaluator();

    /* renamed from: f */
    private ViewTreeObserver.OnGlobalLayoutListener f42498f;
    @BindView(17908)
    TopGunAbnormalView mAbnormalView;
    @BindView(18451)
    ImageView mBackBg;
    @BindView(17928)
    GoodsPurchaseCounter mGoodsPurchaseCounter;

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
                GoodsPurchaseView.this.m29967a();
            }
        });
    }

    public void showLoadingView() {
        DialogUtil.showLoadingDialog(getScopeContext(), false);
    }

    public void updateHeadImage(boolean z) {
        this.f42498f = new ViewTreeObserver.OnGlobalLayoutListener(z) {
            public final /* synthetic */ boolean f$1;

            {
                this.f$1 = r2;
            }

            public final void onGlobalLayout() {
                GoodsPurchaseView.this.m29970a(this.f$1);
            }
        };
        getView().getViewTreeObserver().addOnGlobalLayoutListener(this.f42498f);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m29970a(boolean z) {
        getView().getViewTreeObserver().removeOnGlobalLayoutListener(this.f42498f);
        this.mSmoothScroller.setOffset(this.mTitleView.getBottom());
        if (z) {
            this.mTitleView.setBackgroundColor(0);
        } else {
            this.mTitleView.setBackgroundColor(-1);
        }
    }

    public void showGoodsContent() {
        this.mBottomButton.setVisibility(0);
        this.mShadowConstrain.setVisibility(0);
        this.mStickyHeaderContainer.setVisibility(0);
    }

    public void hideGoodsContent() {
        this.mStickyHeaderContainer.setVisibility(4);
        this.mBottomButton.setVisibility(4);
        this.mShadowConstrain.setVisibility(4);
    }

    public void bindGoodsPurchaseCounter(GoodsPurchaseCounterRvModel goodsPurchaseCounterRvModel, GoodsQuantityListener goodsQuantityListener) {
        this.mGoodsPurchaseCounter.setVisibility(0);
        this.mGoodsPurchaseCounter.bindData(goodsPurchaseCounterRvModel, goodsQuantityListener);
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
        this.mShadowConstrain.setVisibility(4);
    }

    public void showBottomButton() {
        this.mBottomButton.setVisibility(0);
        this.mShadowConstrain.setVisibility(0);
    }

    /* access modifiers changed from: protected */
    public View inflateView(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        return layoutInflater.inflate(R.layout.customer_component_goods_purchase_v2, viewGroup, true);
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        KeyboardUtils.hideSoftInput(getContext(), getView());
        getView().getViewTreeObserver().removeOnGlobalLayoutListener(this.f42498f);
    }

    /* access modifiers changed from: protected */
    public void initItemBinders() {
        super.initItemBinders();
        registerBinder(new GoodsPurchaseHeaderBinder() {
            public void onBind(View view, View view2, View view3) {
                View unused = GoodsPurchaseView.this.f42496d = view;
                View unused2 = GoodsPurchaseView.this.f42495c = view2;
                View unused3 = GoodsPurchaseView.this.f42494b = view3;
            }

            public void onPurchaseTagClick(String str, String str2, String str3) {
                RuleDescEntity ruleDescEntity = new RuleDescEntity();
                ruleDescEntity.title = str;
                ruleDescEntity.content = str2;
                ruleDescEntity.btnDesc = str3;
                DiRouter.request().path("priceRuleDescPage").putSerializable("entity", ruleDescEntity).open();
            }
        });
        registerBinder(new GoodsPurchaseTitleBinder());
    }

    /* renamed from: a */
    private void m29969a(String str) {
        LogUtil.m29100d(f42493a, str);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m29967a() {
        if (this.f42495c != null && this.f42494b != null && this.f42496d != null && ViewSafeHelper.safeIndexOfView(this.mRecyclerView, this.f42496d) >= 0) {
            int[] iArr = new int[2];
            this.mTitleView.getLocationInWindow(iArr);
            if (this.f42494b.getVisibility() == 0) {
                int[] iArr2 = new int[2];
                this.f42494b.getLocationInWindow(iArr2);
                this.mTitleView.setBackgroundColor(((Integer) this.f42497e.evaluate(Math.min(1.0f, ((float) Math.max(0, (iArr[1] - iArr2[1]) - (this.f42494b.getHeight() / 2))) / ((float) ((this.f42494b.getHeight() - this.mTitleView.getHeight()) - (this.f42494b.getHeight() / 2)))), Integer.valueOf(Color.argb(0, 255, 255, 255)), Integer.valueOf(Color.argb(255, 255, 255, 255)))).intValue());
                int[] iArr3 = new int[2];
                this.f42495c.getLocationInWindow(iArr3);
                float min = Math.min(1.0f, ((float) Math.max(0, ((this.mTitleView.getHeight() + iArr[1]) - this.f42495c.getHeight()) - iArr3[1])) / ((float) this.f42495c.getHeight()));
                this.mTitleTvView.setAlpha(min);
                float f = 1.0f - min;
                this.mBackBg.setAlpha(f);
                this.f42495c.setAlpha(f);
            }
        }
    }

    /* renamed from: b */
    private Interpolator m29972b() {
        return CustomerInterpolator.newInstance();
    }
}
