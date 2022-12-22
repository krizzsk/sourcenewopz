package com.didi.global.fintech.cashier.p117ui.viewholder;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.didi.global.fintech.cashier.p117ui.viewholder.ItemViewFactory;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b&\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J$\u0010\u0018\u001a\u00020\u00192\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0010\b\u0002\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u001bH\u0016R\u001a\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001c\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\b\"\u0004\b\u0013\u0010\nR\u0012\u0010\u0014\u001a\u00020\u0015X¤\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017¨\u0006\u001c"}, mo175978d2 = {"Lcom/didi/global/fintech/cashier/ui/viewholder/BaseItemView;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "view", "Landroid/view/View;", "(Landroid/view/View;)V", "available", "", "getAvailable", "()Z", "setAvailable", "(Z)V", "data", "Lcom/didi/global/fintech/cashier/ui/viewholder/FastPayOrderItem;", "getData", "()Lcom/didi/global/fintech/cashier/ui/viewholder/FastPayOrderItem;", "setData", "(Lcom/didi/global/fintech/cashier/ui/viewholder/FastPayOrderItem;)V", "dragable", "getDragable", "setDragable", "type", "Lcom/didi/global/fintech/cashier/ui/viewholder/ItemViewFactory$Type;", "getType", "()Lcom/didi/global/fintech/cashier/ui/viewholder/ItemViewFactory$Type;", "bind", "", "addCardClick", "Lkotlin/Function0;", "cashier_ui_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* renamed from: com.didi.global.fintech.cashier.ui.viewholder.BaseItemView */
/* compiled from: FastPayOrderContentViewHolder.kt */
public abstract class BaseItemView extends RecyclerView.ViewHolder {

    /* renamed from: a */
    private boolean f21765a;

    /* renamed from: b */
    private boolean f21766b = true;

    /* renamed from: c */
    private FastPayOrderItem f21767c;

    /* access modifiers changed from: protected */
    public abstract ItemViewFactory.Type getType();

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BaseItemView(View view) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "view");
    }

    public final boolean getDragable() {
        return this.f21765a;
    }

    public final void setDragable(boolean z) {
        this.f21765a = z;
    }

    public final boolean getAvailable() {
        return this.f21766b;
    }

    public final void setAvailable(boolean z) {
        this.f21766b = z;
    }

    public final FastPayOrderItem getData() {
        return this.f21767c;
    }

    public final void setData(FastPayOrderItem fastPayOrderItem) {
        this.f21767c = fastPayOrderItem;
    }

    public static /* synthetic */ void bind$default(BaseItemView baseItemView, FastPayOrderItem fastPayOrderItem, Function0 function0, int i, Object obj) {
        if (obj == null) {
            if ((i & 2) != 0) {
                function0 = null;
            }
            baseItemView.bind(fastPayOrderItem, function0);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: bind");
    }

    public void bind(FastPayOrderItem fastPayOrderItem, Function0<Unit> function0) {
        boolean z;
        OrderType orderType;
        this.f21767c = fastPayOrderItem;
        boolean z2 = false;
        if (fastPayOrderItem == null) {
            z = false;
        } else {
            z = fastPayOrderItem.getDragable();
        }
        this.f21765a = z;
        if (fastPayOrderItem == null) {
            orderType = null;
        } else {
            orderType = fastPayOrderItem.getOrderType();
        }
        if (orderType == OrderType.Deduction && Intrinsics.areEqual((Object) fastPayOrderItem.getAvailable(), (Object) true)) {
            z2 = true;
        }
        this.f21766b = z2;
    }
}
