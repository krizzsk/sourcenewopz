package com.didi.soda.bill.widgets;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.didi.app.nova.support.util.DisplayUtils;
import com.didi.rfusion.widget.tips.RFTips;
import com.didi.soda.bill.model.datamodel.AddressModel;
import com.didi.soda.customer.app.GlobalContext;
import com.didi.soda.customer.foundation.rpc.entity.address.AddressEntity;
import com.taxis99.R;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\u0018\u00002\u00020\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\b\u0010\f\u001a\u00020\rH\u0016J$\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000b\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u00102\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\r0\u0012J\u0016\u0010\u0013\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u000b\u001a\u00020\u0007R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0016"}, mo175978d2 = {"Lcom/didi/soda/bill/widgets/CustomerBillRecommendTipsView;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "mHeaderAddressTip", "Lcom/didi/rfusion/widget/tips/RFTips;", "topMargin", "removeAllViews", "", "setHomeTipContent", "addressEntity", "Lcom/didi/soda/customer/foundation/rpc/entity/address/AddressEntity;", "cancelAction", "Lkotlin/Function0;", "setScrollProgress", "progress", "", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: CustomerBillRecommendTipsView.kt */
public final class CustomerBillRecommendTipsView extends LinearLayout {

    /* renamed from: a */
    private RFTips f39266a;

    /* renamed from: b */
    private int f39267b;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public CustomerBillRecommendTipsView(Context context) {
        this(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public CustomerBillRecommendTipsView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public void _$_clearFindViewByIdCache() {
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ CustomerBillRecommendTipsView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CustomerBillRecommendTipsView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        LayoutInflater.from(context).inflate(R.layout.customer_bill_address_tips, this, true);
        this.f39266a = (RFTips) findViewById(R.id.customer_custom_address_tips);
    }

    public final void setHomeTipContent(int i, AddressEntity addressEntity, Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(addressEntity, "addressEntity");
        Intrinsics.checkNotNullParameter(function0, "cancelAction");
        RFTips rFTips = this.f39266a;
        boolean z = true;
        if (rFTips != null) {
            rFTips.setArrowLocation(1);
        }
        AddressModel addressModel = new AddressModel();
        StringBuilder sb = new StringBuilder();
        sb.append(addressEntity.poi.displayName);
        String aptAndBuildingName = addressEntity.getAptAndBuildingName();
        if (aptAndBuildingName != null) {
            if (!(aptAndBuildingName.length() == 0)) {
                sb.append(" ");
                sb.append(aptAndBuildingName);
            }
        }
        CharSequence contactName = addressModel.getContactName();
        if (!(contactName == null || contactName.length() == 0)) {
            sb.append("\n");
            sb.append(addressModel.getContactName());
        }
        CharSequence contactPhone = addressModel.getContactPhone();
        if (!(contactPhone == null || contactPhone.length() == 0)) {
            CharSequence contactName2 = addressModel.getContactName();
            if (!(contactName2 == null || contactName2.length() == 0)) {
                z = false;
            }
            if (z) {
                sb.append("\n");
            } else {
                sb.append(" ");
            }
            sb.append(addressModel.getContactPhone());
        }
        RFTips rFTips2 = this.f39266a;
        if (rFTips2 != null) {
            rFTips2.setText((CharSequence) sb);
        }
        RFTips rFTips3 = this.f39266a;
        if (rFTips3 != null) {
            rFTips3.setOnCloseListener(new View.OnClickListener(function0) {
                public final /* synthetic */ Function0 f$1;

                {
                    this.f$1 = r2;
                }

                public final void onClick(View view) {
                    CustomerBillRecommendTipsView.m27818a(CustomerBillRecommendTipsView.this, this.f$1, view);
                }
            });
        }
        this.f39267b = i;
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams != null) {
            ((ViewGroup.MarginLayoutParams) layoutParams).topMargin = i + 80;
            setScrollProgress(0.0f, i);
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m27818a(CustomerBillRecommendTipsView customerBillRecommendTipsView, Function0 function0, View view) {
        Intrinsics.checkNotNullParameter(customerBillRecommendTipsView, "this$0");
        Intrinsics.checkNotNullParameter(function0, "$cancelAction");
        customerBillRecommendTipsView.setVisibility(8);
        function0.invoke();
    }

    public void removeAllViews() {
        super.removeAllViews();
        this.f39266a = null;
    }

    public final void setScrollProgress(float f, int i) {
        RFTips rFTips = this.f39266a;
        if (rFTips != null) {
            float f2 = 0.0f;
            if (f > 0.0f) {
                if (rFTips != null) {
                    rFTips.stopShake();
                }
            } else if (rFTips != null) {
                rFTips.startShake();
            }
            float f3 = ((float) 1) - f;
            setAlpha(f3);
            setPivotX(40.0f);
            float dip2px = (float) DisplayUtils.dip2px(getContext(), 20.0f);
            if (GlobalContext.isEmbed()) {
                f2 = getResources().getDimension(R.dimen.customer_topgun_home_embed_address_offset);
            }
            setPivotY(dip2px + f2);
            setScaleX(f3);
            setScaleY(f3);
            setTranslationY((float) (i - this.f39267b));
        }
    }
}
