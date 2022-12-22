package com.didi.global.fintech.cashier.p117ui.viewholder;

import android.view.ViewGroup;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\tB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b¨\u0006\n"}, mo175978d2 = {"Lcom/didi/global/fintech/cashier/ui/viewholder/ItemViewFactory;", "", "()V", "getInstance", "Lcom/didi/global/fintech/cashier/ui/viewholder/BaseItemView;", "parent", "Landroid/view/ViewGroup;", "viewType", "", "Type", "cashier_ui_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* renamed from: com.didi.global.fintech.cashier.ui.viewholder.ItemViewFactory */
/* compiled from: FastPayOrderContentViewHolder.kt */
public final class ItemViewFactory {
    public static final ItemViewFactory INSTANCE = new ItemViewFactory();

    private ItemViewFactory() {
    }

    @Metadata(mo175977d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, mo175978d2 = {"Lcom/didi/global/fintech/cashier/ui/viewholder/ItemViewFactory$Type;", "", "viewType", "", "(Ljava/lang/String;II)V", "Title", "Pay", "AddCard", "Info", "cashier_ui_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* renamed from: com.didi.global.fintech.cashier.ui.viewholder.ItemViewFactory$Type */
    /* compiled from: FastPayOrderContentViewHolder.kt */
    public enum Type {
        Title(0),
        Pay(1),
        AddCard(2),
        Info(3);

        private Type(int i) {
        }
    }

    public final BaseItemView getInstance(ViewGroup viewGroup, int i) {
        Intrinsics.checkNotNullParameter(viewGroup, "parent");
        if (i == Type.Title.ordinal()) {
            return new TitleItem(viewGroup);
        }
        if (i == Type.AddCard.ordinal()) {
            return new AddCardItem(viewGroup);
        }
        if (i == Type.Info.ordinal()) {
            return new InfoItem(viewGroup);
        }
        if (i == Type.Pay.ordinal()) {
            return new PayItem(viewGroup);
        }
        return new PayItem(viewGroup);
    }
}
