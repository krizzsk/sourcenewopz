package com.didi.global.fintech.cashier.p117ui;

import com.didi.global.fintech.cashier.p117ui.viewholder.FastPayOrderItem;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

@Metadata(mo175977d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\bf\u0018\u00002\u00020\u0001J\u000e\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H&J\u001a\u0010\u0005\u001a\u00020\u00062\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\bH&J\u0012\u0010\t\u001a\u00020\u00062\b\u0010\n\u001a\u0004\u0018\u00010\u000bH&J\u0012\u0010\f\u001a\u00020\u00062\b\u0010\n\u001a\u0004\u0018\u00010\u000bH&J\u001e\u0010\r\u001a\u00020\u00062\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u000f\u001a\u00020\u0004H&J\u0018\u0010\u0010\u001a\u00020\u00062\u000e\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\bH&¨\u0006\u0012"}, mo175978d2 = {"Lcom/didi/global/fintech/cashier/ui/IFastPayOrderContentViewHolder;", "Lcom/didi/global/fintech/cashier/ui/IGlobalCashierBaseViewHolder;", "getOrderItems", "", "Lcom/didi/global/fintech/cashier/ui/viewholder/FastPayOrderItem;", "updateAddClick", "", "click", "Lkotlin/Function0;", "updateBottomMsg", "content", "", "updateBubble", "updateOrderItems", "items", "infoItem", "updateToastChannel", "channel", "cashier_ui_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* renamed from: com.didi.global.fintech.cashier.ui.IFastPayOrderContentViewHolder */
/* compiled from: IFastPayViewHolders.kt */
public interface IFastPayOrderContentViewHolder extends IGlobalCashierBaseViewHolder {
    List<FastPayOrderItem> getOrderItems();

    void updateAddClick(Function0<Unit> function0);

    void updateBottomMsg(String str);

    void updateBubble(String str);

    void updateOrderItems(List<FastPayOrderItem> list, FastPayOrderItem fastPayOrderItem);

    void updateToastChannel(Function0<Unit> function0);

    @Metadata(mo175979k = 3, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* renamed from: com.didi.global.fintech.cashier.ui.IFastPayOrderContentViewHolder$DefaultImpls */
    /* compiled from: IFastPayViewHolders.kt */
    public static final class DefaultImpls {
        public static /* synthetic */ void updateAddClick$default(IFastPayOrderContentViewHolder iFastPayOrderContentViewHolder, Function0 function0, int i, Object obj) {
            if (obj == null) {
                if ((i & 1) != 0) {
                    function0 = null;
                }
                iFastPayOrderContentViewHolder.updateAddClick(function0);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: updateAddClick");
        }
    }
}
