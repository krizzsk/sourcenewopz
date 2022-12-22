package com.didi.soda.bill.view.item;

import android.content.Context;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;
import com.didi.rfusion.widget.RFIconView;
import com.didi.soda.bill.model.ComponentModel;
import com.didi.soda.bill.view.BillItemView;
import com.didi.soda.bill.view.item.logic.ItemViewCommonLogic;
import com.didi.soda.bill.view.item.logic.ItemViewCommonLogicV2;
import com.didi.soda.customer.foundation.util.CustomerExtentionKt;
import com.didi.soda.customer.widget.support.CustomerAppCompatTextView;
import com.taxis99.R;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0016\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u001b\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J\u000e\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017J\u0010\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u001aH\u0016J\u0010\u0010\u001b\u001a\u00020\u00172\u0006\u0010\u001c\u001a\u00020\u001dH\u0016J\b\u0010\u001e\u001a\u00020\u0015H\u0016J\u0010\u0010\u001f\u001a\u00020\u00152\u0006\u0010\u001c\u001a\u00020\u001dH\u0016J\u000e\u0010 \u001a\u00020\u00152\u0006\u0010!\u001a\u00020\"J\u000e\u0010#\u001a\u00020\u00152\u0006\u0010$\u001a\u00020\"R\u001a\u0010\b\u001a\u00020\tX.¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u00020\u000fX.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013¨\u0006%"}, mo175978d2 = {"Lcom/didi/soda/bill/view/item/BillSimpleItemView;", "Lcom/didi/soda/bill/view/BillItemView;", "Lcom/didi/soda/bill/view/item/logic/ItemViewCommonLogicV2;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "mArrowTv", "Lcom/didi/rfusion/widget/RFIconView;", "getMArrowTv", "()Lcom/didi/rfusion/widget/RFIconView;", "setMArrowTv", "(Lcom/didi/rfusion/widget/RFIconView;)V", "mTitle", "Lcom/didi/soda/customer/widget/support/CustomerAppCompatTextView;", "getMTitle", "()Lcom/didi/soda/customer/widget/support/CustomerAppCompatTextView;", "setMTitle", "(Lcom/didi/soda/customer/widget/support/CustomerAppCompatTextView;)V", "activeSelf", "", "active", "", "dispatchClickEvent", "view", "Landroid/view/View;", "enableClick", "componentModel", "Lcom/didi/soda/bill/model/ComponentModel;", "initView", "setData", "updateIcon", "icon", "", "updateTitle", "title", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: BillSimpleItemView.kt */
public class BillSimpleItemView extends BillItemView<ItemViewCommonLogicV2> {
    public RFIconView mArrowTv;
    public CustomerAppCompatTextView mTitle;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public BillSimpleItemView(Context context) {
        this(context, (AttributeSet) null, 2, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public void _$_clearFindViewByIdCache() {
    }

    public boolean dispatchClickEvent(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        return false;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ BillSimpleItemView(Context context, AttributeSet attributeSet, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i & 2) != 0 ? null : attributeSet);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BillSimpleItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public final CustomerAppCompatTextView getMTitle() {
        CustomerAppCompatTextView customerAppCompatTextView = this.mTitle;
        if (customerAppCompatTextView != null) {
            return customerAppCompatTextView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mTitle");
        return null;
    }

    public final void setMTitle(CustomerAppCompatTextView customerAppCompatTextView) {
        Intrinsics.checkNotNullParameter(customerAppCompatTextView, "<set-?>");
        this.mTitle = customerAppCompatTextView;
    }

    public final RFIconView getMArrowTv() {
        RFIconView rFIconView = this.mArrowTv;
        if (rFIconView != null) {
            return rFIconView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mArrowTv");
        return null;
    }

    public final void setMArrowTv(RFIconView rFIconView) {
        Intrinsics.checkNotNullParameter(rFIconView, "<set-?>");
        this.mArrowTv = rFIconView;
    }

    public void initView() {
        View inflate = View.inflate(getContext(), R.layout.customer_item_bill_common2, this);
        View findViewById = inflate.findViewById(R.id.customer_tv_common_name);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.customer_tv_common_name)");
        setMTitle((CustomerAppCompatTextView) findViewById);
        View findViewById2 = inflate.findViewById(R.id.customer_tv_common_arrow);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.customer_tv_common_arrow)");
        setMArrowTv((RFIconView) findViewById2);
    }

    public void setData(ComponentModel componentModel) {
        Intrinsics.checkNotNullParameter(componentModel, "componentModel");
        getMTitle().setText(componentModel.getName());
        if (enableClick(componentModel)) {
            setOnClickListener(new View.OnClickListener(componentModel) {
                public final /* synthetic */ ComponentModel f$1;

                {
                    this.f$1 = r2;
                }

                public final void onClick(View view) {
                    BillSimpleItemView.m27790a(BillSimpleItemView.this, this.f$1, view);
                }
            });
            getMArrowTv().setVisibility(0);
            return;
        }
        getMArrowTv().setVisibility(8);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m27790a(BillSimpleItemView billSimpleItemView, ComponentModel componentModel, View view) {
        ItemViewCommonLogicV2 itemViewCommonLogicV2;
        Intrinsics.checkNotNullParameter(billSimpleItemView, "this$0");
        Intrinsics.checkNotNullParameter(componentModel, "$componentModel");
        Intrinsics.checkNotNullExpressionValue(view, "it");
        if (!billSimpleItemView.dispatchClickEvent(view) && (itemViewCommonLogicV2 = (ItemViewCommonLogicV2) billSimpleItemView.getLogic()) != null) {
            ItemViewCommonLogic.onItemClick$default(itemViewCommonLogicV2, componentModel, (Integer) null, (Bundle) null, (Function1) null, 14, (Object) null);
        }
    }

    public boolean enableClick(ComponentModel componentModel) {
        Intrinsics.checkNotNullParameter(componentModel, "componentModel");
        return componentModel.isCanRedirect() == 1;
    }

    public final void activeSelf(boolean z) {
        if (z) {
            getMArrowTv().setTextColor(CustomerExtentionKt.getColor(R.color.rf_color_gery_1_0_000000));
        } else {
            getMArrowTv().setTextColor(CustomerExtentionKt.getColor(R.color.rf_color_v2_neutral_4_40));
        }
    }

    public final void updateIcon(String str) {
        Intrinsics.checkNotNullParameter(str, "icon");
        getMArrowTv().setText(str);
    }

    public final void updateTitle(String str) {
        Intrinsics.checkNotNullParameter(str, "title");
        getMTitle().setText(str);
    }
}
