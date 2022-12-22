package com.didi.global.fintech.cashier.p117ui;

import com.didi.global.fintech.cashier.p117ui.viewholder.FeeHelpInfo;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

@Metadata(mo175977d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J2\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0014\u0010\b\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0012\u0004\u0012\u00020\u00030\tH&J\u0010\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\fH&J\u0012\u0010\r\u001a\u00020\u00032\b\u0010\u000e\u001a\u0004\u0018\u00010\u0005H&J\u001a\u0010\u000f\u001a\u00020\u00032\b\u0010\u000e\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0010\u001a\u00020\u0011H&J\u001c\u0010\u0012\u001a\u00020\u00032\b\u0010\u000e\u001a\u0004\u0018\u00010\u00052\b\u0010\u0013\u001a\u0004\u0018\u00010\u0005H&¨\u0006\u0014"}, mo175978d2 = {"Lcom/didi/global/fintech/cashier/ui/IGlobalCashierFeeViewHolder;", "Lcom/didi/global/fintech/cashier/ui/IGlobalCashierBaseViewHolder;", "updateAdditionalInfo", "", "message", "", "helpInfo", "Lcom/didi/global/fintech/cashier/ui/viewholder/FeeHelpInfo;", "click", "Lkotlin/Function1;", "updateElevation", "e", "", "updateMerchantName", "name", "updateShouldPayFee", "showPaintFlag", "", "updateTotalFee", "symbol", "cashier_ui_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* renamed from: com.didi.global.fintech.cashier.ui.IGlobalCashierFeeViewHolder */
/* compiled from: IGlobalCashierViewHolders.kt */
public interface IGlobalCashierFeeViewHolder extends IGlobalCashierBaseViewHolder {
    void updateAdditionalInfo(String str, FeeHelpInfo feeHelpInfo, Function1<? super FeeHelpInfo, Unit> function1);

    void updateElevation(int i);

    void updateMerchantName(String str);

    void updateShouldPayFee(String str, boolean z);

    void updateTotalFee(String str, String str2);
}
