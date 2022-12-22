package com.didi.global.fintech.cashier.p117ui.viewholder.item;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.didi.global.fintech.cashier.p117ui.kts.ViewKtxKt;
import com.didi.global.fintech.cashier.p117ui.viewholder.GlobalCashierBaseViewHolder;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\b&\u0018\u00002\u00020\u0001:\u0001\u001bB-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0016\b\u0002\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0007¢\u0006\u0002\u0010\nJ\u0010\u0010\u0013\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\u0012H\u0004J\u0010\u0010\u0015\u001a\u00020\t2\u0006\u0010\u0016\u001a\u00020\bH\u0016J\u0010\u0010\f\u001a\u00020\t2\u0006\u0010\u0017\u001a\u00020\rH\u0002J\b\u0010\u0018\u001a\u00020\tH\u0016J\b\u0010\u0019\u001a\u00020\u001aH&R\u000e\u0010\u000b\u001a\u00020\bX.¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R\u001f\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011X.¢\u0006\u0002\n\u0000¨\u0006\u001c"}, mo175978d2 = {"Lcom/didi/global/fintech/cashier/ui/viewholder/item/GlobalCashierBaseItemViewHolder;", "Lcom/didi/global/fintech/cashier/ui/viewholder/GlobalCashierBaseViewHolder;", "context", "Landroid/content/Context;", "parent", "Landroid/view/ViewGroup;", "onClick", "Lkotlin/Function1;", "Lcom/didi/global/fintech/cashier/ui/viewholder/item/ChannelItemViewHolderData;", "", "(Landroid/content/Context;Landroid/view/ViewGroup;Lkotlin/jvm/functions/Function1;)V", "data", "enable", "", "getOnClick", "()Lkotlin/jvm/functions/Function1;", "subViews", "", "Landroid/view/View;", "addColorChangeView", "view", "bindData", "d", "boolean", "initView", "viewType", "Lcom/didi/global/fintech/cashier/ui/viewholder/item/GlobalCashierBaseItemViewHolder$ViewType;", "ViewType", "cashier_ui_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* renamed from: com.didi.global.fintech.cashier.ui.viewholder.item.GlobalCashierBaseItemViewHolder */
/* compiled from: GlobalCashierBaseItemViewHolder.kt */
public abstract class GlobalCashierBaseItemViewHolder extends GlobalCashierBaseViewHolder {

    /* renamed from: a */
    private final Function1<ChannelItemViewHolderData, Unit> f21858a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public ChannelItemViewHolderData f21859b;

    /* renamed from: c */
    private List<View> f21860c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public boolean f21861d;

    @Metadata(mo175977d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, mo175978d2 = {"Lcom/didi/global/fintech/cashier/ui/viewholder/item/GlobalCashierBaseItemViewHolder$ViewType;", "", "(Ljava/lang/String;I)V", "Default", "Balance", "Card", "AllMethod", "AddCard", "Third", "cashier_ui_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* renamed from: com.didi.global.fintech.cashier.ui.viewholder.item.GlobalCashierBaseItemViewHolder$ViewType */
    /* compiled from: GlobalCashierBaseItemViewHolder.kt */
    public enum ViewType {
        Default,
        Balance,
        Card,
        AllMethod,
        AddCard,
        Third
    }

    public abstract ViewType viewType();

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ GlobalCashierBaseItemViewHolder(Context context, ViewGroup viewGroup, Function1 function1, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, viewGroup, (i & 4) != 0 ? null : function1);
    }

    public final Function1<ChannelItemViewHolderData, Unit> getOnClick() {
        return this.f21858a;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GlobalCashierBaseItemViewHolder(Context context, ViewGroup viewGroup, Function1<? super ChannelItemViewHolderData, Unit> function1) {
        super(context, viewGroup);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(viewGroup, "parent");
        this.f21858a = function1;
        this.f21861d = true;
    }

    public void initView() {
        this.f21860c = new ArrayList();
        ViewKtxKt.click(getMRootView(), 1000, new GlobalCashierBaseItemViewHolder$initView$1(this));
    }

    /* access modifiers changed from: protected */
    public final boolean addColorChangeView(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        List<View> list = this.f21860c;
        if (list == null) {
            Intrinsics.throwUninitializedPropertyAccessException("subViews");
            list = null;
        }
        return list.add(view);
    }

    public void bindData(ChannelItemViewHolderData channelItemViewHolderData) {
        Intrinsics.checkNotNullParameter(channelItemViewHolderData, "d");
        this.f21859b = channelItemViewHolderData;
        m15838a(channelItemViewHolderData.enabled());
    }

    /* renamed from: a */
    private final void m15838a(boolean z) {
        this.f21861d = z;
        List<View> list = this.f21860c;
        if (list == null) {
            Intrinsics.throwUninitializedPropertyAccessException("subViews");
            list = null;
        }
        for (View enabled : list) {
            enabled.setEnabled(this.f21861d);
        }
    }
}
