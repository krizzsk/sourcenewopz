package com.didi.entrega.bill.binder;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.didi.app.nova.skeleton.ScopeContext;
import com.didi.app.nova.support.util.DisplayUtils;
import com.didi.app.nova.support.view.recyclerview.binder.ItemBinder;
import com.didi.app.nova.support.view.recyclerview.binder.ItemViewHolder;
import com.didi.app.nova.support.view.recyclerview.decorator.ItemDecorator;
import com.didi.entrega.bill.model.ComponentModel;
import com.didi.entrega.bill.model.SectionModel;
import com.didi.entrega.bill.view.BillItemView;
import com.didi.entrega.bill.view.BillItemViewFactory;
import com.didi.entrega.customer.foundation.util.ResourceHelper;
import com.taxis99.R;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\"B\u0015\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0018\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u0002H\u0016J\u000e\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00020\u0014H\u0016J\u0018\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J\b\u0010\u001a\u001a\u00020\u001bH\u0002J \u0010\u001c\u001a\u00020\u00102\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020 H\u0002R\u000e\u0010\t\u001a\u00020\nX.¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006#"}, mo175978d2 = {"Lcom/didi/entrega/bill/binder/CustomerBillBinder;", "Lcom/didi/app/nova/support/view/recyclerview/binder/ItemBinder;", "Lcom/didi/entrega/bill/model/SectionModel;", "Lcom/didi/entrega/bill/binder/CustomerBillBinder$ViewHolder;", "scopeContext", "Lcom/didi/app/nova/skeleton/ScopeContext;", "itemDecorator", "Lcom/didi/app/nova/support/view/recyclerview/decorator/ItemDecorator;", "(Lcom/didi/app/nova/skeleton/ScopeContext;Lcom/didi/app/nova/support/view/recyclerview/decorator/ItemDecorator;)V", "mContext", "Landroid/content/Context;", "mItemFactory", "Lcom/didi/entrega/bill/view/BillItemViewFactory;", "getScopeContext", "()Lcom/didi/app/nova/skeleton/ScopeContext;", "bind", "", "holder", "item", "bindDataType", "Ljava/lang/Class;", "create", "inflater", "Landroid/view/LayoutInflater;", "parent", "Landroid/view/ViewGroup;", "createDivider", "Landroid/view/View;", "setItemBgAndPadding", "itemView", "Lcom/didi/entrega/bill/view/BillItemView;", "index", "", "size", "ViewHolder", "entrega-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: CustomerBillBinder.kt */
public final class CustomerBillBinder extends ItemBinder<SectionModel, ViewHolder> {

    /* renamed from: a */
    private final ScopeContext f19465a;

    /* renamed from: b */
    private final BillItemViewFactory f19466b = new BillItemViewFactory();

    /* renamed from: c */
    private Context f19467c;

    public Class<SectionModel> bindDataType() {
        return SectionModel.class;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CustomerBillBinder(ScopeContext scopeContext, ItemDecorator itemDecorator) {
        super(itemDecorator);
        Intrinsics.checkNotNullParameter(scopeContext, "scopeContext");
        Intrinsics.checkNotNullParameter(itemDecorator, "itemDecorator");
        this.f19465a = scopeContext;
    }

    public final ScopeContext getScopeContext() {
        return this.f19465a;
    }

    public ViewHolder create(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        Intrinsics.checkNotNullParameter(viewGroup, "parent");
        View inflate = layoutInflater.inflate(R.layout.entrega_binder_bill_container, viewGroup, false);
        Context context = viewGroup.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "parent.context");
        this.f19467c = context;
        Intrinsics.checkNotNullExpressionValue(inflate, "view");
        return new ViewHolder(inflate);
    }

    public void bind(ViewHolder viewHolder, SectionModel sectionModel) {
        Intrinsics.checkNotNullParameter(viewHolder, "holder");
        Intrinsics.checkNotNullParameter(sectionModel, "item");
        viewHolder.getMContainer().removeAllViews();
        int i = 0;
        for (Object next : sectionModel.getComponents()) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            ComponentModel componentModel = (ComponentModel) next;
            BillItemViewFactory billItemViewFactory = this.f19466b;
            Context context = this.f19467c;
            if (context == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mContext");
                context = null;
            }
            BillItemView createItemView = billItemViewFactory.createItemView(componentModel, context, getScopeContext());
            m14573a(createItemView, i, sectionModel.getComponents().size());
            viewHolder.getMContainer().addView(createItemView);
            if (i < sectionModel.getComponents().size() - 1) {
                viewHolder.getMContainer().addView(m14572a());
            }
            i = i2;
        }
    }

    /* renamed from: a */
    private final void m14573a(BillItemView billItemView, int i, int i2) {
        int i3;
        if (billItemView.needExtraPadding()) {
            Context context = this.f19467c;
            if (context == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mContext");
                context = null;
            }
            i3 = DisplayUtils.dip2px(context, 10.0f);
        } else {
            i3 = 0;
        }
        if (1 == i2) {
            billItemView.setPadding(0, i3, 0, i3);
            billItemView.setBackgroundResource(R.drawable.entrega_selector_trans_to_f0_top_bottom_12_corners);
        } else if (i == 0) {
            billItemView.setBackgroundResource(R.drawable.entrega_selector_trans_to_f0_top_12_corners);
            billItemView.setPadding(0, i3, 0, 0);
        } else if (i == i2 - 1) {
            billItemView.setBackgroundResource(R.drawable.entrega_selector_trans_to_f0_bottom_12_corners);
            billItemView.setPadding(0, 0, 0, i3);
        } else {
            billItemView.setBackgroundResource(R.drawable.entrega_selector_trans_to_f0);
        }
    }

    /* renamed from: a */
    private final View m14572a() {
        Context context = this.f19467c;
        if (context == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mContext");
            context = null;
        }
        View view = new View(context);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, 1);
        layoutParams.leftMargin = ResourceHelper.getDimensionPixelSize(R.dimen.rf_dimen_32);
        layoutParams.rightMargin = ResourceHelper.getDimensionPixelSize(R.dimen.rf_dimen_32);
        view.setBackgroundColor(ResourceHelper.getColor(R.color.rf_color_gery_5_90_E5E5E5));
        view.setLayoutParams(layoutParams);
        return view;
    }

    @Metadata(mo175977d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005R\u001a\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000b¨\u0006\f"}, mo175978d2 = {"Lcom/didi/entrega/bill/binder/CustomerBillBinder$ViewHolder;", "Lcom/didi/app/nova/support/view/recyclerview/binder/ItemViewHolder;", "Lcom/didi/entrega/bill/model/SectionModel;", "view", "Landroid/view/View;", "(Landroid/view/View;)V", "mContainer", "Landroid/widget/LinearLayout;", "getMContainer", "()Landroid/widget/LinearLayout;", "setMContainer", "(Landroid/widget/LinearLayout;)V", "entrega-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: CustomerBillBinder.kt */
    public static final class ViewHolder extends ItemViewHolder<SectionModel> {
        private LinearLayout mContainer;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public ViewHolder(View view) {
            super(view);
            Intrinsics.checkNotNullParameter(view, "view");
            Object findViewById = findViewById(R.id.entraga_ll_binder_container);
            Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.entraga_ll_binder_container)");
            this.mContainer = (LinearLayout) findViewById;
            setIsRecyclable(false);
        }

        public final LinearLayout getMContainer() {
            return this.mContainer;
        }

        public final void setMContainer(LinearLayout linearLayout) {
            Intrinsics.checkNotNullParameter(linearLayout, "<set-?>");
            this.mContainer = linearLayout;
        }
    }
}
