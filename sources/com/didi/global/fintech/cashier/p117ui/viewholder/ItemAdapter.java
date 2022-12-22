package com.didi.global.fintech.cashier.p117ui.viewholder;

import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.didi.global.fintech.cashier.p117ui.viewholder.ItemViewFactory;
import com.didi.sdk.apm.SystemUtils;
import com.didi.sdk.util.UiThreadHandler;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u0018\u001a\u00020\u0019H\u0016J\u0010\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u0019H\u0016J\u0018\u0010\u001c\u001a\u00020\u00062\u0006\u0010\u001d\u001a\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u0019H\u0016J\u0018\u0010\u001e\u001a\u00020\u00022\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u0019H\u0016J\u0016\u0010\"\u001a\u00020\u00062\u0006\u0010#\u001a\u00020\u00192\u0006\u0010$\u001a\u00020\u0019J\u0014\u0010%\u001a\u00020\u00062\f\u0010&\u001a\b\u0012\u0004\u0012\u00020\f0'J\u000e\u0010(\u001a\u00020\u00062\u0006\u0010)\u001a\u00020*R\"\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u00020\fX.¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\f0\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\"\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\b\"\u0004\b\u0017\u0010\n¨\u0006+"}, mo175978d2 = {"Lcom/didi/global/fintech/cashier/ui/viewholder/ItemAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/didi/global/fintech/cashier/ui/viewholder/BaseItemView;", "()V", "addCardClick", "Lkotlin/Function0;", "", "getAddCardClick", "()Lkotlin/jvm/functions/Function0;", "setAddCardClick", "(Lkotlin/jvm/functions/Function0;)V", "infoItem", "Lcom/didi/global/fintech/cashier/ui/viewholder/FastPayOrderItem;", "getInfoItem", "()Lcom/didi/global/fintech/cashier/ui/viewholder/FastPayOrderItem;", "setInfoItem", "(Lcom/didi/global/fintech/cashier/ui/viewholder/FastPayOrderItem;)V", "items", "", "getItems", "()Ljava/util/List;", "toastShow", "getToastShow", "setToastShow", "getItemCount", "", "getItemViewType", "position", "onBindViewHolder", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onItemMove", "fromPosition", "toPosition", "update", "list", "", "updateDragState", "dragging", "", "cashier_ui_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* renamed from: com.didi.global.fintech.cashier.ui.viewholder.ItemAdapter */
/* compiled from: FastPayOrderContentViewHolder.kt */
public final class ItemAdapter extends RecyclerView.Adapter<BaseItemView> {

    /* renamed from: a */
    private final List<FastPayOrderItem> f21814a = new ArrayList();

    /* renamed from: b */
    private Function0<Unit> f21815b;

    /* renamed from: c */
    private Function0<Unit> f21816c;
    public FastPayOrderItem infoItem;

    public final List<FastPayOrderItem> getItems() {
        return this.f21814a;
    }

    public final FastPayOrderItem getInfoItem() {
        FastPayOrderItem fastPayOrderItem = this.infoItem;
        if (fastPayOrderItem != null) {
            return fastPayOrderItem;
        }
        Intrinsics.throwUninitializedPropertyAccessException("infoItem");
        return null;
    }

    public final void setInfoItem(FastPayOrderItem fastPayOrderItem) {
        Intrinsics.checkNotNullParameter(fastPayOrderItem, "<set-?>");
        this.infoItem = fastPayOrderItem;
    }

    public final Function0<Unit> getToastShow() {
        return this.f21815b;
    }

    public final void setToastShow(Function0<Unit> function0) {
        this.f21815b = function0;
    }

    public final Function0<Unit> getAddCardClick() {
        return this.f21816c;
    }

    public final void setAddCardClick(Function0<Unit> function0) {
        this.f21816c = function0;
    }

    public final void update(List<FastPayOrderItem> list) {
        Intrinsics.checkNotNullParameter(list, "list");
        this.f21814a.clear();
        this.f21814a.addAll(list);
        notifyDataSetChanged();
    }

    public BaseItemView onCreateViewHolder(ViewGroup viewGroup, int i) {
        Intrinsics.checkNotNullParameter(viewGroup, "parent");
        return ItemViewFactory.INSTANCE.getInstance(viewGroup, i);
    }

    public void onBindViewHolder(BaseItemView baseItemView, int i) {
        Intrinsics.checkNotNullParameter(baseItemView, "holder");
        baseItemView.bind(this.f21814a.get(i), this.f21816c);
    }

    public int getItemCount() {
        return this.f21814a.size();
    }

    public int getItemViewType(int i) {
        ItemViewFactory.Type type = this.f21814a.get(i).getType();
        if (type == null) {
            return 0;
        }
        return type.ordinal();
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0046  */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0048  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x004d  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x010c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onItemMove(int r8, int r9) {
        /*
            r7 = this;
            java.util.List<com.didi.global.fintech.cashier.ui.viewholder.FastPayOrderItem> r0 = r7.f21814a
            java.util.Collection r0 = (java.util.Collection) r0
            boolean r0 = r0.isEmpty()
            r1 = 1
            r0 = r0 ^ r1
            if (r0 == 0) goto L_0x0116
            java.util.List<com.didi.global.fintech.cashier.ui.viewholder.FastPayOrderItem> r0 = r7.f21814a
            int r0 = r0.size()
            if (r0 <= r9) goto L_0x0116
            r0 = r7
            com.didi.global.fintech.cashier.ui.viewholder.ItemAdapter r0 = (com.didi.global.fintech.cashier.p117ui.viewholder.ItemAdapter) r0
            r0 = 0
            if (r8 != r1) goto L_0x0042
            java.util.List r2 = r7.getItems()
            int r3 = r8 + 1
            java.lang.Object r2 = r2.get(r3)
            com.didi.global.fintech.cashier.ui.viewholder.FastPayOrderItem r2 = (com.didi.global.fintech.cashier.p117ui.viewholder.FastPayOrderItem) r2
            com.didi.global.fintech.cashier.ui.viewholder.ItemViewFactory$Type r2 = r2.getType()
            com.didi.global.fintech.cashier.ui.viewholder.ItemViewFactory$Type r4 = com.didi.global.fintech.cashier.p117ui.viewholder.ItemViewFactory.Type.AddCard
            if (r2 == r4) goto L_0x0040
            java.util.List r2 = r7.getItems()
            java.lang.Object r2 = r2.get(r3)
            com.didi.global.fintech.cashier.ui.viewholder.FastPayOrderItem r2 = (com.didi.global.fintech.cashier.p117ui.viewholder.FastPayOrderItem) r2
            com.didi.global.fintech.cashier.ui.viewholder.ItemViewFactory$Type r2 = r2.getType()
            com.didi.global.fintech.cashier.ui.viewholder.ItemViewFactory$Type r3 = com.didi.global.fintech.cashier.p117ui.viewholder.ItemViewFactory.Type.Title
            if (r2 != r3) goto L_0x0042
        L_0x0040:
            r2 = 1
            goto L_0x0043
        L_0x0042:
            r2 = 0
        L_0x0043:
            r3 = 0
            if (r2 == 0) goto L_0x0048
            r2 = r7
            goto L_0x0049
        L_0x0048:
            r2 = r3
        L_0x0049:
            com.didi.global.fintech.cashier.ui.viewholder.ItemAdapter r2 = (com.didi.global.fintech.cashier.p117ui.viewholder.ItemAdapter) r2
            if (r2 != 0) goto L_0x010c
            if (r8 >= r9) goto L_0x0051
            r2 = 1
            goto L_0x0052
        L_0x0051:
            r2 = 0
        L_0x0052:
            java.util.List r4 = r7.getItems()
            java.lang.Object r4 = r4.get(r9)
            com.didi.global.fintech.cashier.ui.viewholder.FastPayOrderItem r4 = (com.didi.global.fintech.cashier.p117ui.viewholder.FastPayOrderItem) r4
            com.didi.global.fintech.cashier.ui.viewholder.ItemViewFactory$Type r4 = r4.getType()
            com.didi.global.fintech.cashier.ui.viewholder.ItemViewFactory$Type r5 = com.didi.global.fintech.cashier.p117ui.viewholder.ItemViewFactory.Type.Pay
            if (r4 == r5) goto L_0x0079
            java.util.List r4 = r7.getItems()
            java.lang.Object r4 = r4.get(r9)
            com.didi.global.fintech.cashier.ui.viewholder.FastPayOrderItem r4 = (com.didi.global.fintech.cashier.p117ui.viewholder.FastPayOrderItem) r4
            com.didi.global.fintech.cashier.ui.viewholder.ItemViewFactory$Type r4 = r4.getType()
            com.didi.global.fintech.cashier.ui.viewholder.ItemViewFactory$Type r5 = com.didi.global.fintech.cashier.p117ui.viewholder.ItemViewFactory.Type.Title
            if (r4 != r5) goto L_0x0077
            goto L_0x0079
        L_0x0077:
            r4 = 0
            goto L_0x007a
        L_0x0079:
            r4 = 1
        L_0x007a:
            r2 = r2 & r4
            if (r8 <= r9) goto L_0x007f
            r4 = 1
            goto L_0x0080
        L_0x007f:
            r4 = 0
        L_0x0080:
            java.util.List r5 = r7.getItems()
            java.lang.Object r5 = r5.get(r9)
            com.didi.global.fintech.cashier.ui.viewholder.FastPayOrderItem r5 = (com.didi.global.fintech.cashier.p117ui.viewholder.FastPayOrderItem) r5
            com.didi.global.fintech.cashier.ui.viewholder.ItemViewFactory$Type r5 = r5.getType()
            com.didi.global.fintech.cashier.ui.viewholder.ItemViewFactory$Type r6 = com.didi.global.fintech.cashier.p117ui.viewholder.ItemViewFactory.Type.Pay
            if (r5 == r6) goto L_0x00a6
            java.util.List r5 = r7.getItems()
            java.lang.Object r5 = r5.get(r9)
            com.didi.global.fintech.cashier.ui.viewholder.FastPayOrderItem r5 = (com.didi.global.fintech.cashier.p117ui.viewholder.FastPayOrderItem) r5
            com.didi.global.fintech.cashier.ui.viewholder.ItemViewFactory$Type r5 = r5.getType()
            com.didi.global.fintech.cashier.ui.viewholder.ItemViewFactory$Type r6 = com.didi.global.fintech.cashier.p117ui.viewholder.ItemViewFactory.Type.AddCard
            if (r5 != r6) goto L_0x00a5
            goto L_0x00a6
        L_0x00a5:
            r1 = 0
        L_0x00a6:
            r0 = r4 & r1
            r0 = r0 | r2
            if (r0 == 0) goto L_0x00ac
            r3 = r7
        L_0x00ac:
            com.didi.global.fintech.cashier.ui.viewholder.ItemAdapter r3 = (com.didi.global.fintech.cashier.p117ui.viewholder.ItemAdapter) r3
            if (r3 != 0) goto L_0x00b1
            goto L_0x0116
        L_0x00b1:
            if (r8 >= r9) goto L_0x00d4
            java.util.List r0 = r3.getItems()
            java.lang.Object r0 = r0.get(r9)
            com.didi.global.fintech.cashier.ui.viewholder.FastPayOrderItem r0 = (com.didi.global.fintech.cashier.p117ui.viewholder.FastPayOrderItem) r0
            com.didi.global.fintech.cashier.ui.viewholder.ItemViewFactory$Type r0 = r0.getType()
            com.didi.global.fintech.cashier.ui.viewholder.ItemViewFactory$Type r1 = com.didi.global.fintech.cashier.p117ui.viewholder.ItemViewFactory.Type.Title
            if (r0 != r1) goto L_0x00d4
            java.util.List r0 = r3.getItems()
            java.lang.Object r0 = r0.get(r8)
            com.didi.global.fintech.cashier.ui.viewholder.FastPayOrderItem r0 = (com.didi.global.fintech.cashier.p117ui.viewholder.FastPayOrderItem) r0
            com.didi.global.fintech.cashier.ui.viewholder.OrderType r1 = com.didi.global.fintech.cashier.p117ui.viewholder.OrderType.NoDeduction
            r0.setOrderType(r1)
        L_0x00d4:
            if (r8 <= r9) goto L_0x00f7
            java.util.List r0 = r3.getItems()
            java.lang.Object r0 = r0.get(r9)
            com.didi.global.fintech.cashier.ui.viewholder.FastPayOrderItem r0 = (com.didi.global.fintech.cashier.p117ui.viewholder.FastPayOrderItem) r0
            com.didi.global.fintech.cashier.ui.viewholder.ItemViewFactory$Type r0 = r0.getType()
            com.didi.global.fintech.cashier.ui.viewholder.ItemViewFactory$Type r1 = com.didi.global.fintech.cashier.p117ui.viewholder.ItemViewFactory.Type.AddCard
            if (r0 != r1) goto L_0x00f7
            java.util.List r0 = r3.getItems()
            java.lang.Object r0 = r0.get(r8)
            com.didi.global.fintech.cashier.ui.viewholder.FastPayOrderItem r0 = (com.didi.global.fintech.cashier.p117ui.viewholder.FastPayOrderItem) r0
            com.didi.global.fintech.cashier.ui.viewholder.OrderType r1 = com.didi.global.fintech.cashier.p117ui.viewholder.OrderType.Deduction
            r0.setOrderType(r1)
        L_0x00f7:
            java.util.List r0 = r3.getItems()
            java.lang.Object r0 = r0.remove(r8)
            com.didi.global.fintech.cashier.ui.viewholder.FastPayOrderItem r0 = (com.didi.global.fintech.cashier.p117ui.viewholder.FastPayOrderItem) r0
            java.util.List r1 = r3.getItems()
            r1.add(r9, r0)
            r3.notifyItemMoved(r8, r9)
            goto L_0x0116
        L_0x010c:
            kotlin.jvm.functions.Function0 r8 = r2.getToastShow()
            if (r8 != 0) goto L_0x0113
            goto L_0x0116
        L_0x0113:
            r8.invoke()
        L_0x0116:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.global.fintech.cashier.p117ui.viewholder.ItemAdapter.onItemMove(int, int):void");
    }

    public final void updateDragState(boolean z) {
        boolean z2;
        SystemUtils.log(4, "Arirus", "updateDragState: XXXDDD", (Throwable) null, "com.didi.global.fintech.cashier.ui.viewholder.ItemAdapter", 290);
        Iterator it = this.f21814a.iterator();
        while (true) {
            z2 = false;
            if (!it.hasNext()) {
                break;
            }
            ((FastPayOrderItem) it.next()).setDragable(false);
        }
        UiThreadHandler.post(new Runnable() {
            public final void run() {
                ItemAdapter.m15830a(ItemAdapter.this);
            }
        });
        ItemAdapter itemAdapter = this;
        ItemAdapter itemAdapter2 = null;
        ItemAdapter itemAdapter3 = getItems().get(getItemCount() - 1).getType() == ItemViewFactory.Type.Info && getItems().get(getItemCount() + -2).getType() == ItemViewFactory.Type.Pay ? this : null;
        if (itemAdapter3 != null) {
            itemAdapter3.getItems().remove(itemAdapter3.getItemCount() - 1);
            UiThreadHandler.post(new Runnable() {
                public final void run() {
                    ItemAdapter.m15831b(ItemAdapter.this);
                }
            });
        }
        if (getItems().get(getItemCount() - 1).getType() == ItemViewFactory.Type.Title) {
            z2 = true;
        }
        if (z2) {
            itemAdapter2 = this;
        }
        ItemAdapter itemAdapter4 = itemAdapter2;
        if (itemAdapter4 != null) {
            itemAdapter4.getItems().add(itemAdapter4.getInfoItem());
            UiThreadHandler.post(new Runnable() {
                public final void run() {
                    ItemAdapter.m15832c(ItemAdapter.this);
                }
            });
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m15830a(ItemAdapter itemAdapter) {
        Intrinsics.checkNotNullParameter(itemAdapter, "this$0");
        itemAdapter.notifyDataSetChanged();
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static final void m15831b(ItemAdapter itemAdapter) {
        Intrinsics.checkNotNullParameter(itemAdapter, "$this_apply");
        itemAdapter.notifyItemRemoved(itemAdapter.getItemCount());
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public static final void m15832c(ItemAdapter itemAdapter) {
        Intrinsics.checkNotNullParameter(itemAdapter, "$this_apply");
        itemAdapter.notifyItemInserted(itemAdapter.getItemCount());
    }
}
