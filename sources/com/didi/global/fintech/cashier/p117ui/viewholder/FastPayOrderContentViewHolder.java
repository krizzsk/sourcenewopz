package com.didi.global.fintech.cashier.p117ui.viewholder;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.didi.global.fintech.cashier.p117ui.IFastPayOrderContentViewHolder;
import com.didi.global.fintech.cashier.p117ui.kts.ViewKtxKt;
import com.didi.global.fintech.cashier.p117ui.widget.popup.CashierBubble;
import com.didi.sdk.util.UiThreadHandler;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.taxis99.R;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u0000 )2\u00020\u00012\u00020\u0002:\u0001)B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u000e\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017H\u0016J\b\u0010\u0019\u001a\u00020\u001aH\u0016J\b\u0010\u001b\u001a\u00020\u001cH\u0016J\u0018\u0010\u001d\u001a\u00020\u001a2\u000e\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u001fH\u0016J\u0012\u0010 \u001a\u00020\u001a2\b\u0010!\u001a\u0004\u0018\u00010\"H\u0016J\u0012\u0010#\u001a\u00020\u001a2\b\u0010!\u001a\u0004\u0018\u00010\"H\u0016J\u001e\u0010$\u001a\u00020\u001a2\f\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00180\u00172\u0006\u0010&\u001a\u00020\u0018H\u0016J\u0018\u0010'\u001a\u00020\u001a2\u000e\u0010(\u001a\n\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u001fH\u0016R\u000e\u0010\b\u001a\u00020\tX.¢\u0006\u0002\n\u0000R\u001a\u0010\n\u001a\u00020\u000bX.¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u0011X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015¨\u0006*"}, mo175978d2 = {"Lcom/didi/global/fintech/cashier/ui/viewholder/FastPayOrderContentViewHolder;", "Lcom/didi/global/fintech/cashier/ui/viewholder/GlobalCashierBaseViewHolder;", "Lcom/didi/global/fintech/cashier/ui/IFastPayOrderContentViewHolder;", "context", "Landroid/content/Context;", "parent", "Landroid/view/ViewGroup;", "(Landroid/content/Context;Landroid/view/ViewGroup;)V", "adapter", "Lcom/didi/global/fintech/cashier/ui/viewholder/ItemAdapter;", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "getRecyclerView", "()Landroidx/recyclerview/widget/RecyclerView;", "setRecyclerView", "(Landroidx/recyclerview/widget/RecyclerView;)V", "tvTerm", "Landroid/widget/TextView;", "getTvTerm", "()Landroid/widget/TextView;", "setTvTerm", "(Landroid/widget/TextView;)V", "getOrderItems", "", "Lcom/didi/global/fintech/cashier/ui/viewholder/FastPayOrderItem;", "initView", "", "layout", "", "updateAddClick", "click", "Lkotlin/Function0;", "updateBottomMsg", "content", "", "updateBubble", "updateOrderItems", "items", "infoItem", "updateToastChannel", "channel", "Companion", "cashier_ui_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* renamed from: com.didi.global.fintech.cashier.ui.viewholder.FastPayOrderContentViewHolder */
/* compiled from: FastPayOrderContentViewHolder.kt */
public final class FastPayOrderContentViewHolder extends GlobalCashierBaseViewHolder implements IFastPayOrderContentViewHolder {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    /* renamed from: a */
    private ItemAdapter f21771a;
    public RecyclerView recyclerView;
    public TextView tvTerm;

    public int layout() {
        return R.layout.viewholder_fast_pay_order_content;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FastPayOrderContentViewHolder(Context context, ViewGroup viewGroup) {
        super(context, viewGroup);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(viewGroup, "parent");
    }

    @Metadata(mo175977d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b¨\u0006\t"}, mo175978d2 = {"Lcom/didi/global/fintech/cashier/ui/viewholder/FastPayOrderContentViewHolder$Companion;", "", "()V", "newInstance", "Lcom/didi/global/fintech/cashier/ui/viewholder/FastPayOrderContentViewHolder;", "context", "Landroid/content/Context;", "parent", "Landroid/view/ViewGroup;", "cashier_ui_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* renamed from: com.didi.global.fintech.cashier.ui.viewholder.FastPayOrderContentViewHolder$Companion */
    /* compiled from: FastPayOrderContentViewHolder.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final FastPayOrderContentViewHolder newInstance(Context context, ViewGroup viewGroup) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(viewGroup, "parent");
            return new FastPayOrderContentViewHolder(context, viewGroup);
        }
    }

    public final RecyclerView getRecyclerView() {
        RecyclerView recyclerView2 = this.recyclerView;
        if (recyclerView2 != null) {
            return recyclerView2;
        }
        Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
        return null;
    }

    public final void setRecyclerView(RecyclerView recyclerView2) {
        Intrinsics.checkNotNullParameter(recyclerView2, "<set-?>");
        this.recyclerView = recyclerView2;
    }

    public final TextView getTvTerm() {
        TextView textView = this.tvTerm;
        if (textView != null) {
            return textView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("tvTerm");
        return null;
    }

    public final void setTvTerm(TextView textView) {
        Intrinsics.checkNotNullParameter(textView, "<set-?>");
        this.tvTerm = textView;
    }

    public void initView() {
        super.initView();
        setRecyclerView((RecyclerView) getView(R.id.cy));
        setTvTerm((TextView) getView(R.id.tv_term));
        this.f21771a = new ItemAdapter();
        RecyclerView recyclerView2 = getRecyclerView();
        ItemAdapter itemAdapter = this.f21771a;
        ItemAdapter itemAdapter2 = null;
        if (itemAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
            itemAdapter = null;
        }
        recyclerView2.setAdapter(itemAdapter);
        getRecyclerView().setLayoutManager(new LinearLayoutManager(getContext()));
        getRecyclerView().addItemDecoration(new FastPayItemDividerDecoration(getContext()));
        ItemAdapter itemAdapter3 = this.f21771a;
        if (itemAdapter3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
        } else {
            itemAdapter2 = itemAdapter3;
        }
        new ItemTouchHelper(new FastPayItemTouchHelperCallback(itemAdapter2)).attachToRecyclerView(getRecyclerView());
    }

    public void updateBottomMsg(String str) {
        ViewKtxKt.content(getTvTerm(), str);
    }

    public void updateOrderItems(List<FastPayOrderItem> list, FastPayOrderItem fastPayOrderItem) {
        Intrinsics.checkNotNullParameter(list, FirebaseAnalytics.Param.ITEMS);
        Intrinsics.checkNotNullParameter(fastPayOrderItem, "infoItem");
        ItemAdapter itemAdapter = this.f21771a;
        ItemAdapter itemAdapter2 = null;
        if (itemAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
            itemAdapter = null;
        }
        itemAdapter.update(list);
        ItemAdapter itemAdapter3 = this.f21771a;
        if (itemAdapter3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
        } else {
            itemAdapter2 = itemAdapter3;
        }
        itemAdapter2.setInfoItem(fastPayOrderItem);
    }

    public void updateBubble(String str) {
        FastPayOrderContentViewHolder fastPayOrderContentViewHolder = this;
        CharSequence charSequence = str;
        if ((charSequence == null || charSequence.length() == 0 ? this : null) == null) {
            UiThreadHandler.postDelayed(new Runnable(str) {
                public final /* synthetic */ String f$1;

                {
                    this.f$1 = r2;
                }

                public final void run() {
                    FastPayOrderContentViewHolder.m15823a(FastPayOrderContentViewHolder.this, this.f$1);
                }
            }, 500);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m15823a(FastPayOrderContentViewHolder fastPayOrderContentViewHolder, String str) {
        View findViewById;
        Intrinsics.checkNotNullParameter(fastPayOrderContentViewHolder, "this$0");
        View childAt = fastPayOrderContentViewHolder.getRecyclerView().getChildAt(1);
        if (childAt != null && (findViewById = childAt.findViewById(R.id.iv_drag)) != null) {
            new CashierBubble.Builder(fastPayOrderContentViewHolder.getRecyclerView().getContext()).setText(str).setWidthAndHeight(500, -2).setOutSideTouch(true).setDirection("top_right").build().show(findViewById, 0, 0);
        }
    }

    public List<FastPayOrderItem> getOrderItems() {
        ItemAdapter itemAdapter = this.f21771a;
        if (itemAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
            itemAdapter = null;
        }
        return itemAdapter.getItems();
    }

    public void updateAddClick(Function0<Unit> function0) {
        ItemAdapter itemAdapter = this.f21771a;
        if (itemAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
            itemAdapter = null;
        }
        itemAdapter.setAddCardClick(function0);
    }

    public void updateToastChannel(Function0<Unit> function0) {
        ItemAdapter itemAdapter = this.f21771a;
        if (itemAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
            itemAdapter = null;
        }
        itemAdapter.setToastShow(function0);
    }
}
