package com.didi.global.fintech.cashier.p117ui;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

@Metadata(mo175977d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J*\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\tH&¨\u0006\n"}, mo175978d2 = {"Lcom/didi/global/fintech/cashier/ui/IGlobalCashierPayBtnViewHolder;", "Lcom/didi/global/fintech/cashier/ui/IGlobalCashierBaseViewHolder;", "updateBtn", "", "clickable", "", "content", "", "click", "Lkotlin/Function0;", "cashier_ui_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* renamed from: com.didi.global.fintech.cashier.ui.IGlobalCashierPayBtnViewHolder */
/* compiled from: IGlobalCashierViewHolders.kt */
public interface IGlobalCashierPayBtnViewHolder extends IGlobalCashierBaseViewHolder {
    void updateBtn(boolean z, String str, Function0<Unit> function0);

    @Metadata(mo175979k = 3, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* renamed from: com.didi.global.fintech.cashier.ui.IGlobalCashierPayBtnViewHolder$DefaultImpls */
    /* compiled from: IGlobalCashierViewHolders.kt */
    public static final class DefaultImpls {
        public static /* synthetic */ void updateBtn$default(IGlobalCashierPayBtnViewHolder iGlobalCashierPayBtnViewHolder, boolean z, String str, Function0 function0, int i, Object obj) {
            if (obj == null) {
                if ((i & 2) != 0) {
                    str = null;
                }
                iGlobalCashierPayBtnViewHolder.updateBtn(z, str, function0);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: updateBtn");
        }
    }
}
