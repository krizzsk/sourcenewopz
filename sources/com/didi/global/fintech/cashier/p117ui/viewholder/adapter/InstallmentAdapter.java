package com.didi.global.fintech.cashier.p117ui.viewholder.adapter;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.didi.global.fintech.cashier.p117ui.kts.ViewKtxKt;
import com.didi.global.fintech.cashier.p117ui.viewholder.item.InstallmentVo;
import com.taxis99.R;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.osgi.framework.VersionRange;

@Metadata(mo175977d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0019B\u001b\u0012\u0014\u0010\u0003\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0004¢\u0006\u0002\u0010\u0007J\b\u0010\u000e\u001a\u00020\u000fH\u0016J\u0018\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u000fH\u0016J\u0018\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u000fH\u0016J\u0018\u0010\u0017\u001a\u00020\u00062\u000e\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\tH\u0007R \u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001c\u0010\u0003\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001a"}, mo175978d2 = {"Lcom/didi/global/fintech/cashier/ui/viewholder/adapter/InstallmentAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/didi/global/fintech/cashier/ui/viewholder/adapter/InstallmentAdapter$ViewHolder;", "onItemClick", "Lkotlin/Function1;", "Lcom/didi/global/fintech/cashier/ui/viewholder/item/InstallmentVo$PlansVo;", "", "(Lkotlin/jvm/functions/Function1;)V", "list", "", "getList", "()Ljava/util/List;", "setList", "(Ljava/util/List;)V", "getItemCount", "", "onBindViewHolder", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "updateData", "data", "ViewHolder", "cashier_ui_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* renamed from: com.didi.global.fintech.cashier.ui.viewholder.adapter.InstallmentAdapter */
/* compiled from: InstallmentAdapter.kt */
public final class InstallmentAdapter extends RecyclerView.Adapter<ViewHolder> {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public final Function1<InstallmentVo.PlansVo, Unit> f21832a;

    /* renamed from: b */
    private List<InstallmentVo.PlansVo> f21833b = new ArrayList();

    public InstallmentAdapter(Function1<? super InstallmentVo.PlansVo, Unit> function1) {
        this.f21832a = function1;
    }

    public final List<InstallmentVo.PlansVo> getList() {
        return this.f21833b;
    }

    public final void setList(List<InstallmentVo.PlansVo> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.f21833b = list;
    }

    public final void updateData(List<InstallmentVo.PlansVo> list) {
        this.f21833b.clear();
        Collection collection = list;
        if (!(collection == null || collection.isEmpty())) {
            this.f21833b.addAll(collection);
            notifyDataSetChanged();
        }
    }

    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        Intrinsics.checkNotNullParameter(viewGroup, "parent");
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.view_item_installment_layout, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "view");
        return new ViewHolder(inflate);
    }

    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        Intrinsics.checkNotNullParameter(viewHolder, "holder");
        InstallmentVo.PlansVo plansVo = this.f21833b.get(i);
        View view = viewHolder.itemView;
        Intrinsics.checkNotNullExpressionValue(view, "holder.itemView");
        ViewKtxKt.click$default(view, 0, new InstallmentAdapter$onBindViewHolder$1(this, plansVo), 1, (Object) null);
        viewHolder.bind(plansVo);
    }

    public int getItemCount() {
        return this.f21833b.size();
    }

    @Metadata(mo175977d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0007R\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000¨\u0006\u000f"}, mo175978d2 = {"Lcom/didi/global/fintech/cashier/ui/viewholder/adapter/InstallmentAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "descTV", "Landroid/widget/TextView;", "outerLayout", "Landroid/widget/LinearLayout;", "subTitleTV", "titleTV", "bind", "", "data", "Lcom/didi/global/fintech/cashier/ui/viewholder/item/InstallmentVo$PlansVo;", "cashier_ui_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* renamed from: com.didi.global.fintech.cashier.ui.viewholder.adapter.InstallmentAdapter$ViewHolder */
    /* compiled from: InstallmentAdapter.kt */
    public static final class ViewHolder extends RecyclerView.ViewHolder {
        private TextView descTV;
        private LinearLayout outerLayout;
        private TextView subTitleTV;
        private TextView titleTV;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public ViewHolder(View view) {
            super(view);
            Intrinsics.checkNotNullParameter(view, "itemView");
            View findViewById = view.findViewById(R.id.tv_title);
            Intrinsics.checkNotNullExpressionValue(findViewById, "itemView.findViewById(R.id.tv_title)");
            this.titleTV = (TextView) findViewById;
            View findViewById2 = view.findViewById(R.id.tv_sub_title);
            Intrinsics.checkNotNullExpressionValue(findViewById2, "itemView.findViewById(R.id.tv_sub_title)");
            this.subTitleTV = (TextView) findViewById2;
            View findViewById3 = view.findViewById(R.id.tv_desc);
            Intrinsics.checkNotNullExpressionValue(findViewById3, "itemView.findViewById(R.id.tv_desc)");
            this.descTV = (TextView) findViewById3;
            View findViewById4 = view.findViewById(R.id.layout_outer);
            Intrinsics.checkNotNullExpressionValue(findViewById4, "itemView.findViewById(R.id.layout_outer)");
            this.outerLayout = (LinearLayout) findViewById4;
        }

        public final void bind(InstallmentVo.PlansVo plansVo) {
            Integer number;
            Intrinsics.checkNotNullParameter(plansVo, "data");
            if (plansVo.isSelected()) {
                this.outerLayout.setBackground(ContextCompat.getDrawable(this.itemView.getContext(), R.drawable.shape_installment_bg_select));
            } else {
                this.outerLayout.setBackground(ContextCompat.getDrawable(this.itemView.getContext(), R.drawable.shape_installment_bg_normal));
            }
            if (!TextUtils.isEmpty(plansVo.getDisplay())) {
                this.titleTV.setText(plansVo.getDisplay());
            } else {
                TextView textView = this.titleTV;
                textView.setText(plansVo.getNumber() + " x " + plansVo.getEachAmount());
            }
            if (TextUtils.isEmpty(plansVo.getTotalAmount()) || ((number = plansVo.getNumber()) != null && number.intValue() == 1)) {
                this.subTitleTV.setVisibility(8);
            } else {
                this.subTitleTV.setVisibility(0);
                TextView textView2 = this.subTitleTV;
                textView2.setText(VersionRange.LEFT_OPEN + plansVo.getTotalAmount() + VersionRange.RIGHT_OPEN);
            }
            if (!TextUtils.isEmpty(plansVo.getTag())) {
                this.descTV.setVisibility(0);
                this.descTV.setText(plansVo.getTag());
                return;
            }
            this.descTV.setVisibility(4);
        }
    }
}
