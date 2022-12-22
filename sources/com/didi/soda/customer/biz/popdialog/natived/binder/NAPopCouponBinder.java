package com.didi.soda.customer.biz.popdialog.natived.binder;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.didi.app.nova.support.view.recyclerview.binder.ItemBinder;
import com.didi.app.nova.support.view.recyclerview.binder.ItemViewHolder;
import com.didi.soda.customer.biz.popdialog.natived.Contract;
import com.didi.soda.customer.biz.popdialog.natived.model.NAPopCouponRvModel;
import com.didi.soda.customer.biz.popdialog.natived.view.CouponPopItemView;
import com.taxis99.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u0018B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u001c\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00032\b\u0010\u0010\u001a\u0004\u0018\u00010\u0002H\u0016J\u000e\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00020\u0012H\u0016J\u0018\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\f¨\u0006\u0019"}, mo175978d2 = {"Lcom/didi/soda/customer/biz/popdialog/natived/binder/NAPopCouponBinder;", "Lcom/didi/app/nova/support/view/recyclerview/binder/ItemBinder;", "Lcom/didi/soda/customer/biz/popdialog/natived/model/NAPopCouponRvModel;", "Lcom/didi/soda/customer/biz/popdialog/natived/binder/NAPopCouponBinder$ViewHolder;", "actionListener", "Lcom/didi/soda/customer/biz/popdialog/natived/Contract$NaPopBinderActionListener;", "(Lcom/didi/soda/customer/biz/popdialog/natived/Contract$NaPopBinderActionListener;)V", "couponStyle", "", "getCouponStyle", "()I", "setCouponStyle", "(I)V", "bind", "", "holder", "item", "bindDataType", "Ljava/lang/Class;", "create", "inflater", "Landroid/view/LayoutInflater;", "parent", "Landroid/view/ViewGroup;", "ViewHolder", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: NAPopCouponBinder.kt */
public final class NAPopCouponBinder extends ItemBinder<NAPopCouponRvModel, ViewHolder> {

    /* renamed from: a */
    private final Contract.NaPopBinderActionListener f40495a;

    /* renamed from: b */
    private int f40496b;

    public Class<NAPopCouponRvModel> bindDataType() {
        return NAPopCouponRvModel.class;
    }

    public NAPopCouponBinder(Contract.NaPopBinderActionListener naPopBinderActionListener) {
        Intrinsics.checkNotNullParameter(naPopBinderActionListener, "actionListener");
        this.f40495a = naPopBinderActionListener;
    }

    public final int getCouponStyle() {
        return this.f40496b;
    }

    public final void setCouponStyle(int i) {
        this.f40496b = i;
    }

    public ViewHolder create(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        Intrinsics.checkNotNullParameter(viewGroup, "parent");
        View inflate = layoutInflater.inflate(R.layout.customer_dialog_coupon_pop_item, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflater.inflate(R.layou…_pop_item, parent, false)");
        return new ViewHolder(inflate, this.f40495a, this.f40496b);
    }

    public void bind(ViewHolder viewHolder, NAPopCouponRvModel nAPopCouponRvModel) {
        if (viewHolder != null && nAPopCouponRvModel != null) {
            viewHolder.bind(nAPopCouponRvModel);
        }
    }

    @Metadata(mo175977d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u001d\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u000e\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0013"}, mo175978d2 = {"Lcom/didi/soda/customer/biz/popdialog/natived/binder/NAPopCouponBinder$ViewHolder;", "Lcom/didi/app/nova/support/view/recyclerview/binder/ItemViewHolder;", "Lcom/didi/soda/customer/biz/popdialog/natived/model/NAPopCouponRvModel;", "itemView", "Landroid/view/View;", "actionListener", "Lcom/didi/soda/customer/biz/popdialog/natived/Contract$NaPopBinderActionListener;", "couponStyle", "", "(Landroid/view/View;Lcom/didi/soda/customer/biz/popdialog/natived/Contract$NaPopBinderActionListener;I)V", "item", "Lcom/didi/soda/customer/biz/popdialog/natived/view/CouponPopItemView;", "getItem", "()Lcom/didi/soda/customer/biz/popdialog/natived/view/CouponPopItemView;", "setItem", "(Lcom/didi/soda/customer/biz/popdialog/natived/view/CouponPopItemView;)V", "bind", "", "model", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: NAPopCouponBinder.kt */
    public static final class ViewHolder extends ItemViewHolder<NAPopCouponRvModel> {
        private final Contract.NaPopBinderActionListener actionListener;
        private final int couponStyle;
        private CouponPopItemView item;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public ViewHolder(View view, Contract.NaPopBinderActionListener naPopBinderActionListener, int i) {
            super(view);
            Intrinsics.checkNotNullParameter(view, "itemView");
            Intrinsics.checkNotNullParameter(naPopBinderActionListener, "actionListener");
            this.actionListener = naPopBinderActionListener;
            this.couponStyle = i;
            View findViewById = view.findViewById(R.id.customer_pop_item);
            Intrinsics.checkNotNullExpressionValue(findViewById, "itemView.findViewById(R.id.customer_pop_item)");
            this.item = (CouponPopItemView) findViewById;
        }

        public final CouponPopItemView getItem() {
            return this.item;
        }

        public final void setItem(CouponPopItemView couponPopItemView) {
            Intrinsics.checkNotNullParameter(couponPopItemView, "<set-?>");
            this.item = couponPopItemView;
        }

        public final void bind(NAPopCouponRvModel nAPopCouponRvModel) {
            int i;
            Intrinsics.checkNotNullParameter(nAPopCouponRvModel, "model");
            if (this.item.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.LayoutParams layoutParams = this.item.getLayoutParams();
                if (layoutParams != null) {
                    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                    if (getAdapterPosition() == 0) {
                        i = 0;
                    } else {
                        i = this.itemView.getContext().getResources().getDimensionPixelOffset(R.dimen.customer_20px);
                    }
                    marginLayoutParams.topMargin = i;
                } else {
                    throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
                }
            }
            this.item.updateView(this.couponStyle, nAPopCouponRvModel, getAdapterPosition());
            this.item.setClickListener(this.actionListener);
            Contract.NaPopBinderActionListener naPopBinderActionListener = this.actionListener;
            String couponId = nAPopCouponRvModel.getCouponId();
            if (couponId == null) {
                couponId = "";
            }
            naPopBinderActionListener.onBindAction(couponId, nAPopCouponRvModel.getBusinessCouponType(), nAPopCouponRvModel.getBatchId(), getAdapterPosition());
        }
    }
}
