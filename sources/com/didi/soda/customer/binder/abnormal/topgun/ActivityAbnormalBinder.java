package com.didi.soda.customer.binder.abnormal.topgun;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.didi.app.nova.support.view.recyclerview.binder.ItemBinder;
import com.didi.app.nova.support.view.recyclerview.binder.ItemViewHolder;
import com.didi.soda.customer.widget.abnormal.ActivityAbnormalView;
import com.didi.soda.customer.widget.abnormal.ActivityAbnormalViewModel;
import com.taxis99.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u0010B\u0005¢\u0006\u0002\u0010\u0004J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0002H\u0016J\u000e\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00020\nH\u0016J\u001a\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016¨\u0006\u0011"}, mo175978d2 = {"Lcom/didi/soda/customer/binder/abnormal/topgun/ActivityAbnormalBinder;", "Lcom/didi/app/nova/support/view/recyclerview/binder/ItemBinder;", "Lcom/didi/soda/customer/widget/abnormal/ActivityAbnormalViewModel;", "Lcom/didi/soda/customer/binder/abnormal/topgun/ActivityAbnormalBinder$ViewHolder;", "()V", "bind", "", "holder", "item", "bindDataType", "Ljava/lang/Class;", "create", "inflater", "Landroid/view/LayoutInflater;", "parent", "Landroid/view/ViewGroup;", "ViewHolder", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: ActivityAbnormalBinder.kt */
public final class ActivityAbnormalBinder extends ItemBinder<ActivityAbnormalViewModel, ViewHolder> {
    public Class<ActivityAbnormalViewModel> bindDataType() {
        return ActivityAbnormalViewModel.class;
    }

    public ViewHolder create(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        return new ViewHolder(layoutInflater.inflate(R.layout.customer_binder_activity_abnormal_view, viewGroup, false));
    }

    public void bind(ViewHolder viewHolder, ActivityAbnormalViewModel activityAbnormalViewModel) {
        Intrinsics.checkNotNullParameter(viewHolder, "holder");
        Intrinsics.checkNotNullParameter(activityAbnormalViewModel, "item");
        viewHolder.getMAbnormalView().show(activityAbnormalViewModel);
        ViewGroup.LayoutParams layoutParams = viewHolder.getMAbnormalLayout().getLayoutParams();
        if (layoutParams != null) {
            RecyclerView.LayoutParams layoutParams2 = (RecyclerView.LayoutParams) layoutParams;
            layoutParams2.height = activityAbnormalViewModel.getHeight();
            viewHolder.getMAbnormalLayout().setLayoutParams(layoutParams2);
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView.LayoutParams");
    }

    @Metadata(mo175977d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001B\u000f\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\u0005R\u001a\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, mo175978d2 = {"Lcom/didi/soda/customer/binder/abnormal/topgun/ActivityAbnormalBinder$ViewHolder;", "Lcom/didi/app/nova/support/view/recyclerview/binder/ItemViewHolder;", "Lcom/didi/soda/customer/widget/abnormal/ActivityAbnormalViewModel;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "mAbnormalLayout", "Landroid/widget/RelativeLayout;", "getMAbnormalLayout", "()Landroid/widget/RelativeLayout;", "setMAbnormalLayout", "(Landroid/widget/RelativeLayout;)V", "mAbnormalView", "Lcom/didi/soda/customer/widget/abnormal/ActivityAbnormalView;", "getMAbnormalView", "()Lcom/didi/soda/customer/widget/abnormal/ActivityAbnormalView;", "setMAbnormalView", "(Lcom/didi/soda/customer/widget/abnormal/ActivityAbnormalView;)V", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: ActivityAbnormalBinder.kt */
    public static final class ViewHolder extends ItemViewHolder<ActivityAbnormalViewModel> {
        private RelativeLayout mAbnormalLayout;
        private ActivityAbnormalView mAbnormalView;

        public ViewHolder(View view) {
            super(view);
            Object findViewById = findViewById(R.id.customer_custom_abnormal);
            Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.customer_custom_abnormal)");
            this.mAbnormalView = (ActivityAbnormalView) findViewById;
            Object findViewById2 = findViewById(R.id.customer_abnormal_layout);
            Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.customer_abnormal_layout)");
            this.mAbnormalLayout = (RelativeLayout) findViewById2;
        }

        public final RelativeLayout getMAbnormalLayout() {
            return this.mAbnormalLayout;
        }

        public final void setMAbnormalLayout(RelativeLayout relativeLayout) {
            Intrinsics.checkNotNullParameter(relativeLayout, "<set-?>");
            this.mAbnormalLayout = relativeLayout;
        }

        public final ActivityAbnormalView getMAbnormalView() {
            return this.mAbnormalView;
        }

        public final void setMAbnormalView(ActivityAbnormalView activityAbnormalView) {
            Intrinsics.checkNotNullParameter(activityAbnormalView, "<set-?>");
            this.mAbnormalView = activityAbnormalView;
        }
    }
}
