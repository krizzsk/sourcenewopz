package com.didi.global.fintech.cashier.p117ui;

import com.didi.global.fintech.cashier.p117ui.viewholder.MerchantButtonData;
import com.didi.global.fintech.cashier.p117ui.viewholder.PaymentMethod;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

@Metadata(mo175977d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J,\u0010\u0004\u001a\u00020\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u000e\u0010\b\u001a\n\u0018\u00010\tj\u0004\u0018\u0001`\nH&J\u0016\u0010\u000b\u001a\u00020\u00032\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH&J$\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u00112\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00030\u0013H&¨\u0006\u0014"}, mo175978d2 = {"Lcom/didi/global/fintech/cashier/ui/IGlobalCashierResultPayViewHolder;", "Lcom/didi/global/fintech/cashier/ui/IGlobalCashierBaseViewHolder;", "disableReturnButton", "", "updateAmountInfo", "symbolStr", "", "priceStr", "sb", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "updatePaymentMethod", "payments", "", "Lcom/didi/global/fintech/cashier/ui/viewholder/PaymentMethod;", "updateReturnButton", "buttonData", "Lcom/didi/global/fintech/cashier/ui/viewholder/MerchantButtonData;", "onClick", "Lkotlin/Function1;", "cashier_ui_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* renamed from: com.didi.global.fintech.cashier.ui.IGlobalCashierResultPayViewHolder */
/* compiled from: IGlobalCashierViewHolders.kt */
public interface IGlobalCashierResultPayViewHolder extends IGlobalCashierBaseViewHolder {
    void disableReturnButton();

    void updateAmountInfo(String str, String str2, StringBuilder sb);

    void updatePaymentMethod(List<PaymentMethod> list);

    void updateReturnButton(MerchantButtonData merchantButtonData, Function1<? super MerchantButtonData, Unit> function1);
}
