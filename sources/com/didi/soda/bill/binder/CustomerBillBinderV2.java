package com.didi.soda.bill.binder;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.didi.app.nova.skeleton.ScopeContext;
import com.didi.app.nova.support.util.DisplayUtils;
import com.didi.app.nova.support.view.recyclerview.binder.ItemBinder;
import com.didi.app.nova.support.view.recyclerview.binder.ItemViewHolder;
import com.didi.app.nova.support.view.recyclerview.decorator.ItemDecorator;
import com.didi.soda.bill.model.ComponentModel;
import com.didi.soda.bill.model.SectionModel;
import com.didi.soda.bill.view.BillItemView;
import com.didi.soda.bill.view.BillItemViewFactoryV2;
import com.didi.soda.customer.foundation.util.CustomerExtentionKt;
import com.didi.soda.customer.widget.RoundLinearLayout;
import com.taxis99.R;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001&B\u0015\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0018\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u0002H\u0016J\u000e\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00020\u0014H\u0016J\u0018\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u0016H\u0002J\u0018\u0010\u0019\u001a\u00020\u00032\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001dH\u0016J4\u0010\u001e\u001a\u00020\u00102\u0006\u0010\u001f\u001a\u00020\u00162\n\u0010 \u001a\u0006\u0012\u0002\b\u00030!2\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\u00162\u0006\u0010%\u001a\u00020\u0016H\u0002R\u000e\u0010\t\u001a\u00020\nX.¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006'"}, mo175978d2 = {"Lcom/didi/soda/bill/binder/CustomerBillBinderV2;", "Lcom/didi/app/nova/support/view/recyclerview/binder/ItemBinder;", "Lcom/didi/soda/bill/model/SectionModel;", "Lcom/didi/soda/bill/binder/CustomerBillBinderV2$ViewHolder;", "scopeContext", "Lcom/didi/app/nova/skeleton/ScopeContext;", "itemDecorator", "Lcom/didi/app/nova/support/view/recyclerview/decorator/ItemDecorator;", "(Lcom/didi/app/nova/skeleton/ScopeContext;Lcom/didi/app/nova/support/view/recyclerview/decorator/ItemDecorator;)V", "mContext", "Landroid/content/Context;", "mItemFactory", "Lcom/didi/soda/bill/view/BillItemViewFactoryV2;", "getScopeContext", "()Lcom/didi/app/nova/skeleton/ScopeContext;", "bind", "", "holder", "item", "bindDataType", "Ljava/lang/Class;", "checkBgType", "", "index", "size", "create", "inflater", "Landroid/view/LayoutInflater;", "parent", "Landroid/view/ViewGroup;", "setItemBgAndPadding", "cardBgType", "itemView", "Lcom/didi/soda/bill/view/BillItemView;", "container", "Lcom/didi/soda/customer/widget/RoundLinearLayout;", "lineTopPadding", "lineBottomPadding", "ViewHolder", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: CustomerBillBinderV2.kt */
public final class CustomerBillBinderV2 extends ItemBinder<SectionModel, ViewHolder> {

    /* renamed from: a */
    private final ScopeContext f38815a;

    /* renamed from: b */
    private final BillItemViewFactoryV2 f38816b = new BillItemViewFactoryV2();

    /* renamed from: c */
    private Context f38817c;

    /* renamed from: a */
    private final int m27522a(int i, int i2) {
        if (1 == i2) {
            return 0;
        }
        if (i == 0) {
            return 1;
        }
        return i == i2 - 1 ? 2 : 3;
    }

    public Class<SectionModel> bindDataType() {
        return SectionModel.class;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CustomerBillBinderV2(ScopeContext scopeContext, ItemDecorator itemDecorator) {
        super(itemDecorator);
        Intrinsics.checkNotNullParameter(scopeContext, "scopeContext");
        Intrinsics.checkNotNullParameter(itemDecorator, "itemDecorator");
        this.f38815a = scopeContext;
    }

    public final ScopeContext getScopeContext() {
        return this.f38815a;
    }

    public ViewHolder create(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        Intrinsics.checkNotNullParameter(viewGroup, "parent");
        View inflate = layoutInflater.inflate(R.layout.customer_binder_bill_container_v2, viewGroup, false);
        Context context = viewGroup.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "parent.context");
        this.f38817c = context;
        Intrinsics.checkNotNullExpressionValue(inflate, "view");
        return new ViewHolder(inflate);
    }

    public void bind(ViewHolder viewHolder, SectionModel sectionModel) {
        ViewHolder viewHolder2 = viewHolder;
        Intrinsics.checkNotNullParameter(viewHolder, "holder");
        Intrinsics.checkNotNullParameter(sectionModel, "item");
        viewHolder.getMContainer().removeAllViews();
        viewHolder.getMContainer().setBackgroundResource(R.drawable.customer_binder_card_bg_v2);
        Iterator<ComponentModel> it = sectionModel.getComponents().iterator();
        int i = 0;
        while (it.hasNext()) {
            int i2 = i + 1;
            ComponentModel next = it.next();
            next.setCardBgType(m27522a(i, sectionModel.getComponents().size()));
            BillItemViewFactoryV2 billItemViewFactoryV2 = this.f38816b;
            Context context = this.f38817c;
            Context context2 = null;
            if (context == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mContext");
                context = null;
            }
            BillItemView<?> createItemView = billItemViewFactoryV2.createItemView(next, context, this.f38815a);
            if (createItemView != null) {
                int cardBgType = next.getCardBgType();
                RoundLinearLayout mContainer = viewHolder.getMContainer();
                Context context3 = this.f38817c;
                if (context3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mContext");
                    context3 = null;
                }
                int dip2px = DisplayUtils.dip2px(context3, (float) next.getTopExtraPadding());
                Context context4 = this.f38817c;
                if (context4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mContext");
                } else {
                    context2 = context4;
                }
                m27523a(cardBgType, createItemView, mContainer, dip2px, DisplayUtils.dip2px(context2, (float) next.getBottomExtraPadding()));
                viewHolder.getMContainer().addView(createItemView);
            }
            i = i2;
        }
    }

    /* renamed from: a */
    private final void m27523a(int i, BillItemView<?> billItemView, RoundLinearLayout roundLinearLayout, int i2, int i3) {
        int i4;
        if (!billItemView.needBinderBackground()) {
            roundLinearLayout.setRadius((float) CustomerExtentionKt.getPx(R.dimen.rf_dimen_0));
            roundLinearLayout.setBackgroundColor(0);
        } else {
            roundLinearLayout.setRadius((float) CustomerExtentionKt.getPx(R.dimen.rf_dimen_40));
        }
        if (billItemView.needExtraPadding()) {
            Context context = this.f38817c;
            if (context == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mContext");
                context = null;
            }
            i4 = DisplayUtils.dip2px(context, 10.0f);
        } else {
            i4 = 0;
        }
        if (i == 0) {
            billItemView.setPadding(0, i4, 0, i4);
            billItemView.setBackgroundResource(R.drawable.customer_selector_trans_to_f0_top_bottom_40_corners);
        } else if (i == 1) {
            billItemView.setBackgroundResource(R.drawable.customer_selector_trans_to_f0_top_40_corners);
            billItemView.setPadding(0, i4, 0, i3);
        } else if (i == 2) {
            billItemView.setBackgroundResource(R.drawable.customer_selector_trans_to_f0_bottom_40_corners);
            billItemView.setPadding(0, i2, 0, i4);
        } else if (i == 3) {
            billItemView.setBackgroundResource(R.drawable.customer_selector_trans_to_f0);
            billItemView.setPadding(0, i2, 0, i3);
        }
    }

    @Metadata(mo175977d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005R\u001a\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000b¨\u0006\f"}, mo175978d2 = {"Lcom/didi/soda/bill/binder/CustomerBillBinderV2$ViewHolder;", "Lcom/didi/app/nova/support/view/recyclerview/binder/ItemViewHolder;", "Lcom/didi/soda/bill/model/SectionModel;", "view", "Landroid/view/View;", "(Landroid/view/View;)V", "mContainer", "Lcom/didi/soda/customer/widget/RoundLinearLayout;", "getMContainer", "()Lcom/didi/soda/customer/widget/RoundLinearLayout;", "setMContainer", "(Lcom/didi/soda/customer/widget/RoundLinearLayout;)V", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: CustomerBillBinderV2.kt */
    public static final class ViewHolder extends ItemViewHolder<SectionModel> {
        private RoundLinearLayout mContainer;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public ViewHolder(View view) {
            super(view);
            Intrinsics.checkNotNullParameter(view, "view");
            Object findViewById = findViewById(R.id.customer_ll_binder_container);
            Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.customer_ll_binder_container)");
            this.mContainer = (RoundLinearLayout) findViewById;
            setIsRecyclable(false);
        }

        public final RoundLinearLayout getMContainer() {
            return this.mContainer;
        }

        public final void setMContainer(RoundLinearLayout roundLinearLayout) {
            Intrinsics.checkNotNullParameter(roundLinearLayout, "<set-?>");
            this.mContainer = roundLinearLayout;
        }
    }
}
