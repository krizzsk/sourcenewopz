package com.didi.global.fintech.cashier.p117ui;

import kotlin.Metadata;

@Metadata(mo175977d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bf\u0018\u00002\u00020\u0001J\u0014\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&¨\u0006\u0006"}, mo175978d2 = {"Lcom/didi/global/fintech/cashier/ui/IGlobalCashierCVVBtnViewHolder;", "Lcom/didi/global/fintech/cashier/ui/IGlobalCashierPayBtnViewHolder;", "updateBrandInfo", "", "url", "", "cashier_ui_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* renamed from: com.didi.global.fintech.cashier.ui.IGlobalCashierCVVBtnViewHolder */
/* compiled from: IGlobalCashierViewHolders.kt */
public interface IGlobalCashierCVVBtnViewHolder extends IGlobalCashierPayBtnViewHolder {
    void updateBrandInfo(String str);

    @Metadata(mo175979k = 3, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* renamed from: com.didi.global.fintech.cashier.ui.IGlobalCashierCVVBtnViewHolder$DefaultImpls */
    /* compiled from: IGlobalCashierViewHolders.kt */
    public static final class DefaultImpls {
        public static /* synthetic */ void updateBrandInfo$default(IGlobalCashierCVVBtnViewHolder iGlobalCashierCVVBtnViewHolder, String str, int i, Object obj) {
            if (obj == null) {
                if ((i & 1) != 0) {
                    str = null;
                }
                iGlobalCashierCVVBtnViewHolder.updateBrandInfo(str);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: updateBrandInfo");
        }
    }
}
