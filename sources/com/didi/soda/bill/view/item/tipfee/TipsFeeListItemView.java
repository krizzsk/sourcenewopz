package com.didi.soda.bill.view.item.tipfee;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.airbnb.lottie.LottieAnimationView;
import com.didi.app.nova.skeleton.ScopeContext;
import com.didi.soda.customer.app.constant.Const;
import com.didi.soda.customer.foundation.skin.SkinUtil;
import com.didi.soda.customer.foundation.util.FlyImageLoader;
import com.didi.soda.customer.foundation.util.ResourceHelper;
import com.didi.soda.customer.widget.support.CustomerAppCompatTextView;
import com.taxis99.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u001a\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0002J\u0016\u0010\u0012\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u000e\u001a\u00020\u000fJ(\u0010\u0015\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0016\u001a\u00020\u00142\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011J\u0018\u0010\u0017\u001a\u00020\r2\u0006\u0010\u0018\u001a\u00020\u000f2\u0006\u0010\u0019\u001a\u00020\u000fH\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000¨\u0006\u001a"}, mo175978d2 = {"Lcom/didi/soda/bill/view/item/tipfee/TipsFeeListItemView;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "mIvTipFeeListItemIcon", "Landroid/widget/ImageView;", "mLottieTipsFeeSelectedAnim", "Lcom/airbnb/lottie/LottieAnimationView;", "mLvTipFeeListItemAnim", "mTvTipAmountText", "Lcom/didi/soda/customer/widget/support/CustomerAppCompatTextView;", "executeSelectedAnim", "", "isSelected", "", "scopeContext", "Lcom/didi/app/nova/skeleton/ScopeContext;", "setAmountSelectedState", "text", "", "setData", "iconUrl", "setTipFeeImgAndAnim", "showImg", "showAnim", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: TipsFeeListItemView.kt */
public final class TipsFeeListItemView extends FrameLayout {

    /* renamed from: a */
    private CustomerAppCompatTextView f39259a;

    /* renamed from: b */
    private LottieAnimationView f39260b;

    /* renamed from: c */
    private ImageView f39261c;

    /* renamed from: d */
    private LottieAnimationView f39262d;

    public void _$_clearFindViewByIdCache() {
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TipsFeeListItemView(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        View inflate = LayoutInflater.from(context).inflate(R.layout.customer_tips_fee_list_item_view, this);
        View findViewById = inflate.findViewById(R.id.customer_tv_tips_fee_item_amount);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById<CustomerApp…_tv_tips_fee_item_amount)");
        this.f39259a = (CustomerAppCompatTextView) findViewById;
        View findViewById2 = inflate.findViewById(R.id.customer_lat_tip_fee_list_anim);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById<LottieAnima…er_lat_tip_fee_list_anim)");
        this.f39260b = (LottieAnimationView) findViewById2;
        View findViewById3 = inflate.findViewById(R.id.customer_iv_tip_fee_icon);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById<LottieAnima…customer_iv_tip_fee_icon)");
        this.f39261c = (ImageView) findViewById3;
        View findViewById4 = inflate.findViewById(R.id.customer_lat_tip_fee_anim);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "findViewById<LottieAnima…ustomer_lat_tip_fee_anim)");
        this.f39262d = (LottieAnimationView) findViewById4;
        setClipToPadding(false);
        setClipChildren(false);
    }

    public final void setData(String str, boolean z, String str2, ScopeContext scopeContext) {
        Intrinsics.checkNotNullParameter(str, "text");
        Intrinsics.checkNotNullParameter(str2, "iconUrl");
        if (!TextUtils.isEmpty(str2)) {
            FlyImageLoader.loadImage1x1(getContext(), str2).into(this.f39261c);
            m27814a(true, !z);
        } else {
            m27814a(false, false);
        }
        setAmountSelectedState(str, z);
        m27813a(z, scopeContext);
    }

    /* renamed from: a */
    private final void m27813a(boolean z, ScopeContext scopeContext) {
        if (z) {
            if (Intrinsics.areEqual((Object) (Boolean) (scopeContext == null ? null : scopeContext.getObject(Const.BundleKey.BILL_MANUAL_UPDATE_TIPS_FEE)), (Object) true)) {
                if (scopeContext != null) {
                    scopeContext.attach(Const.BundleKey.BILL_MANUAL_UPDATE_TIPS_FEE, false);
                }
                this.f39262d.setVisibility(0);
                this.f39262d.playAnimation();
                return;
            }
            this.f39262d.setVisibility(8);
            return;
        }
        this.f39262d.setVisibility(8);
    }

    /* renamed from: a */
    private final void m27814a(boolean z, boolean z2) {
        if (z) {
            this.f39261c.setVisibility(0);
            if (z2) {
                this.f39260b.setVisibility(0);
                this.f39260b.playAnimation();
                return;
            }
            this.f39260b.setVisibility(8);
            this.f39260b.cancelAnimation();
            return;
        }
        this.f39261c.setVisibility(8);
        this.f39260b.setVisibility(8);
    }

    public final void setAmountSelectedState(String str, boolean z) {
        Intrinsics.checkNotNullParameter(str, "text");
        this.f39259a.setText(str);
        setSelected(z);
        if (z) {
            this.f39259a.setTextColor(SkinUtil.getBrandPrimaryColor());
        } else {
            this.f39259a.setTextColor(ResourceHelper.getColor(R.color.rf_color_gery_1_0_000000));
        }
    }
}
