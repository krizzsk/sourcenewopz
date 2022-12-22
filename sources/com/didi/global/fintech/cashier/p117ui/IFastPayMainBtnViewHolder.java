package com.didi.global.fintech.cashier.p117ui;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

@Metadata(mo175977d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J:\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\nH&¨\u0006\u000b"}, mo175978d2 = {"Lcom/didi/global/fintech/cashier/ui/IFastPayMainBtnViewHolder;", "Lcom/didi/global/fintech/cashier/ui/IGlobalCashierBaseViewHolder;", "updateBtn", "", "enable", "", "selected", "content", "", "click", "Lkotlin/Function0;", "cashier_ui_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* renamed from: com.didi.global.fintech.cashier.ui.IFastPayMainBtnViewHolder */
/* compiled from: IFastPayViewHolders.kt */
public interface IFastPayMainBtnViewHolder extends IGlobalCashierBaseViewHolder {
    void updateBtn(boolean z, boolean z2, String str, Function0<Unit> function0);

    @Metadata(mo175979k = 3, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* renamed from: com.didi.global.fintech.cashier.ui.IFastPayMainBtnViewHolder$DefaultImpls */
    /* compiled from: IFastPayViewHolders.kt */
    public static final class DefaultImpls {
        public static /* synthetic */ void updateBtn$default(IFastPayMainBtnViewHolder iFastPayMainBtnViewHolder, boolean z, boolean z2, String str, Function0 function0, int i, Object obj) {
            if (obj == null) {
                if ((i & 1) != 0) {
                    z = true;
                }
                if ((i & 2) != 0) {
                    z2 = true;
                }
                if ((i & 4) != 0) {
                    str = null;
                }
                if ((i & 8) != 0) {
                    function0 = null;
                }
                iFastPayMainBtnViewHolder.updateBtn(z, z2, str, function0);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: updateBtn");
        }
    }
}
