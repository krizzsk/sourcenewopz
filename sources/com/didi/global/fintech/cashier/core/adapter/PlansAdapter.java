package com.didi.global.fintech.cashier.core.adapter;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;
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

@Metadata(mo175977d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001dB\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u0012\u001a\u00020\u0013H\u0016J\u0018\u0010\u0014\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u0013H\u0016J\u0018\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0013H\u0016J\u0018\u0010\u001b\u001a\u00020\r2\u000e\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005H\u0007R \u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR(\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\r\u0018\u00010\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006\u001e"}, mo175978d2 = {"Lcom/didi/global/fintech/cashier/core/adapter/PlansAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/didi/global/fintech/cashier/core/adapter/PlansAdapter$ViewHolder;", "()V", "list", "", "Lcom/didi/global/fintech/cashier/ui/viewholder/item/InstallmentVo$PlansVo;", "getList", "()Ljava/util/List;", "setList", "(Ljava/util/List;)V", "onItemClick", "Lkotlin/Function1;", "", "getOnItemClick", "()Lkotlin/jvm/functions/Function1;", "setOnItemClick", "(Lkotlin/jvm/functions/Function1;)V", "getItemCount", "", "onBindViewHolder", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "updateData", "data", "ViewHolder", "cashier_core_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: PlansAdapter.kt */
public final class PlansAdapter extends RecyclerView.Adapter<ViewHolder> {

    /* renamed from: a */
    private List<InstallmentVo.PlansVo> f21421a = new ArrayList();

    /* renamed from: b */
    private Function1<? super InstallmentVo.PlansVo, Unit> f21422b;

    public final List<InstallmentVo.PlansVo> getList() {
        return this.f21421a;
    }

    public final void setList(List<InstallmentVo.PlansVo> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.f21421a = list;
    }

    public final Function1<InstallmentVo.PlansVo, Unit> getOnItemClick() {
        return this.f21422b;
    }

    public final void setOnItemClick(Function1<? super InstallmentVo.PlansVo, Unit> function1) {
        this.f21422b = function1;
    }

    public final void updateData(List<InstallmentVo.PlansVo> list) {
        this.f21421a.clear();
        Collection collection = list;
        if (!(collection == null || collection.isEmpty())) {
            this.f21421a.addAll(collection);
            notifyDataSetChanged();
        }
    }

    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        Intrinsics.checkNotNullParameter(viewGroup, "parent");
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.view_item_plan, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "view");
        return new ViewHolder(inflate);
    }

    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        Intrinsics.checkNotNullParameter(viewHolder, "holder");
        InstallmentVo.PlansVo plansVo = this.f21421a.get(i);
        View view = viewHolder.itemView;
        Intrinsics.checkNotNullExpressionValue(view, "holder.itemView");
        ViewKtxKt.click$default(view, 0, new PlansAdapter$onBindViewHolder$1(this, plansVo), 1, (Object) null);
        viewHolder.bind(plansVo);
    }

    public int getItemCount() {
        return this.f21421a.size();
    }

    @Metadata(mo175977d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0007R\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000¨\u0006\u000f"}, mo175978d2 = {"Lcom/didi/global/fintech/cashier/core/adapter/PlansAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "descTV", "Landroid/widget/TextView;", "statusCB", "Landroid/widget/CheckBox;", "subTitleTV", "titleTV", "bind", "", "data", "Lcom/didi/global/fintech/cashier/ui/viewholder/item/InstallmentVo$PlansVo;", "cashier_core_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: PlansAdapter.kt */
    public static final class ViewHolder extends RecyclerView.ViewHolder {
        private TextView descTV;
        private CheckBox statusCB;
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
            View findViewById4 = view.findViewById(R.id.cb_status);
            Intrinsics.checkNotNullExpressionValue(findViewById4, "itemView.findViewById(R.id.cb_status)");
            this.statusCB = (CheckBox) findViewById4;
        }

        public final void bind(InstallmentVo.PlansVo plansVo) {
            Integer number;
            Intrinsics.checkNotNullParameter(plansVo, "data");
            this.statusCB.setChecked(plansVo.isSelected());
            if (!TextUtils.isEmpty(plansVo.getDisplay())) {
                this.titleTV.setText(plansVo.getDisplay());
            } else {
                TextView textView = this.titleTV;
                textView.setText(plansVo.getNumber() + "x " + plansVo.getEachAmount());
            }
            if (TextUtils.isEmpty(plansVo.getTotalAmount()) || ((number = plansVo.getNumber()) != null && number.intValue() == 1)) {
                this.subTitleTV.setVisibility(4);
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
            this.descTV.setVisibility(8);
        }
    }
}
