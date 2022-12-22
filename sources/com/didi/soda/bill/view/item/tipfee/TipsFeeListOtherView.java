package com.didi.soda.bill.view.item.tipfee;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import com.airbnb.lottie.LottieAnimationView;
import com.didi.app.nova.skeleton.ScopeContext;
import com.didi.rfusion.widget.RFIconView;
import com.didi.soda.bill.widgets.tip.ITipItemView;
import com.didi.soda.customer.app.constant.Const;
import com.didi.soda.customer.foundation.skin.SkinUtil;
import com.didi.soda.customer.foundation.util.ResourceHelper;
import com.didi.soda.customer.widget.support.CustomerAppCompatTextView;
import com.taxis99.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u001a\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0002J \u0010\u0012\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011J\u0010\u0010\u0015\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016R\u000e\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000¨\u0006\u0016"}, mo175978d2 = {"Lcom/didi/soda/bill/view/item/tipfee/TipsFeeListOtherView;", "Landroid/widget/FrameLayout;", "Lcom/didi/soda/bill/widgets/tip/ITipItemView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "mLottieTipsFeeSelectedAnim", "Lcom/airbnb/lottie/LottieAnimationView;", "tipAmountSymbol", "Lcom/didi/rfusion/widget/RFIconView;", "tipAmountText", "Lcom/didi/soda/customer/widget/support/CustomerAppCompatTextView;", "executeSelectedAnim", "", "isSelected", "", "scopeContext", "Lcom/didi/app/nova/skeleton/ScopeContext;", "setData", "text", "", "setSelectedState", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: TipsFeeListOtherView.kt */
public final class TipsFeeListOtherView extends FrameLayout implements ITipItemView {

    /* renamed from: a */
    private CustomerAppCompatTextView f39263a;

    /* renamed from: b */
    private RFIconView f39264b;

    /* renamed from: c */
    private LottieAnimationView f39265c;

    public void _$_clearFindViewByIdCache() {
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TipsFeeListOtherView(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        View inflate = LayoutInflater.from(context).inflate(R.layout.customer_tips_fee_item_other_view, this);
        View findViewById = inflate.findViewById(R.id.customer_tv_tips_fee_other_edit);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById<CustomerApp…r_tv_tips_fee_other_edit)");
        this.f39263a = (CustomerAppCompatTextView) findViewById;
        View findViewById2 = inflate.findViewById(R.id.customer_icon_tips_fee_other_edit);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById<RFIconView>…icon_tips_fee_other_edit)");
        this.f39264b = (RFIconView) findViewById2;
        View findViewById3 = inflate.findViewById(R.id.customer_lat_tip_fee_anim);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById<LottieAnima…ustomer_lat_tip_fee_anim)");
        this.f39265c = (LottieAnimationView) findViewById3;
        setClipChildren(false);
        setClipToPadding(false);
    }

    public final void setData(String str, boolean z, ScopeContext scopeContext) {
        Intrinsics.checkNotNullParameter(str, "text");
        this.f39263a.setText(str);
        setSelectedState(z);
        m27815a(z, scopeContext);
    }

    /* renamed from: a */
    private final void m27815a(boolean z, ScopeContext scopeContext) {
        if (z) {
            if (Intrinsics.areEqual((Object) (Boolean) (scopeContext == null ? null : scopeContext.getObject(Const.BundleKey.BILL_MANUAL_UPDATE_TIPS_FEE)), (Object) true)) {
                if (scopeContext != null) {
                    scopeContext.attach(Const.BundleKey.BILL_MANUAL_UPDATE_TIPS_FEE, false);
                }
                this.f39265c.setVisibility(0);
                this.f39265c.playAnimation();
                return;
            }
            this.f39265c.setVisibility(8);
            return;
        }
        this.f39265c.setVisibility(8);
    }

    public void setSelectedState(boolean z) {
        setSelected(z);
        if (z) {
            this.f39263a.setTextColor(SkinUtil.getBrandPrimaryColor());
            this.f39264b.setTextColor(SkinUtil.getBrandPrimaryColor());
            return;
        }
        this.f39263a.setTextColor(ResourceHelper.getColor(R.color.rf_color_gery_1_0_000000));
        this.f39264b.setTextColor(ResourceHelper.getColor(R.color.rf_color_v2_grey1_4_a40));
    }
}
