package com.didi.global.fintech.cashier.p117ui.viewholder.item;

import android.content.Context;
import android.view.ViewGroup;
import com.didi.global.fintech.cashier.p117ui.viewholder.item.GlobalCashierBaseItemViewHolder;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J4\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0014\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e\u0018\u00010\f¨\u0006\u000f"}, mo175978d2 = {"Lcom/didi/global/fintech/cashier/ui/viewholder/item/GlobalCashierItemViewHolderFactory;", "", "()V", "newInstance", "Lcom/didi/global/fintech/cashier/ui/viewholder/item/GlobalCashierBaseItemViewHolder;", "viewType", "Lcom/didi/global/fintech/cashier/ui/viewholder/item/GlobalCashierBaseItemViewHolder$ViewType;", "context", "Landroid/content/Context;", "parent", "Landroid/view/ViewGroup;", "onClick", "Lkotlin/Function1;", "Lcom/didi/global/fintech/cashier/ui/viewholder/item/ChannelItemViewHolderData;", "", "cashier_ui_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* renamed from: com.didi.global.fintech.cashier.ui.viewholder.item.GlobalCashierItemViewHolderFactory */
/* compiled from: GlobalCashierBaseItemViewHolder.kt */
public final class GlobalCashierItemViewHolderFactory {
    public static final GlobalCashierItemViewHolderFactory INSTANCE = new GlobalCashierItemViewHolderFactory();

    @Metadata(mo175979k = 3, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* renamed from: com.didi.global.fintech.cashier.ui.viewholder.item.GlobalCashierItemViewHolderFactory$WhenMappings */
    /* compiled from: GlobalCashierBaseItemViewHolder.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[GlobalCashierBaseItemViewHolder.ViewType.values().length];
            iArr[GlobalCashierBaseItemViewHolder.ViewType.Balance.ordinal()] = 1;
            iArr[GlobalCashierBaseItemViewHolder.ViewType.Card.ordinal()] = 2;
            iArr[GlobalCashierBaseItemViewHolder.ViewType.AddCard.ordinal()] = 3;
            iArr[GlobalCashierBaseItemViewHolder.ViewType.AllMethod.ordinal()] = 4;
            iArr[GlobalCashierBaseItemViewHolder.ViewType.Third.ordinal()] = 5;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private GlobalCashierItemViewHolderFactory() {
    }

    public final GlobalCashierBaseItemViewHolder newInstance(GlobalCashierBaseItemViewHolder.ViewType viewType, Context context, ViewGroup viewGroup, Function1<? super ChannelItemViewHolderData, Unit> function1) {
        Intrinsics.checkNotNullParameter(viewType, "viewType");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(viewGroup, "parent");
        int i = WhenMappings.$EnumSwitchMapping$0[viewType.ordinal()];
        if (i == 1) {
            return GlobalCashierBalanceItemViewHolder.Companion.newInstance(context, viewGroup, function1);
        }
        if (i == 2) {
            return GlobalCashierCardChannelItemViewHolder.Companion.newInstance(context, viewGroup, function1);
        }
        if (i == 3) {
            return GlobalCashierAddCardItemViewHolder.Companion.newInstance(context, viewGroup, function1);
        }
        if (i == 4) {
            return GlobalCashierAllMethodItemViewHolder.Companion.newInstance(context, viewGroup, function1);
        }
        if (i != 5) {
            return GlobalCashierDefaultItemViewHolder.Companion.newInstance(context, viewGroup, function1);
        }
        return GlobalCashierThirdChannelItemViewHolder.Companion.newInstance(context, viewGroup, function1);
    }
}
