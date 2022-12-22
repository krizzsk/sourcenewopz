package com.didi.global.fintech.cashier.p117ui;

import com.didi.global.fintech.cashier.p117ui.viewholder.AcceptContent;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

@Metadata(mo175977d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\u0012\u0010\u0006\u001a\u00020\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005H&JN\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\n2\u0014\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\f2\u000e\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000e2\u0016\u0010\u0010\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0012\u0004\u0012\u00020\u0003\u0018\u00010\fH&¨\u0006\u0011"}, mo175978d2 = {"Lcom/didi/global/fintech/cashier/ui/IGlobalCashierPolicyViewHolder;", "Lcom/didi/global/fintech/cashier/ui/IGlobalCashierBaseViewHolder;", "updateBrandLogo", "", "logo", "", "updateContent", "title", "updatePolicy", "selected", "", "cbListener", "Lkotlin/Function1;", "contents", "", "Lcom/didi/global/fintech/cashier/ui/viewholder/AcceptContent;", "linkListener", "cashier_ui_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* renamed from: com.didi.global.fintech.cashier.ui.IGlobalCashierPolicyViewHolder */
/* compiled from: IGlobalCashierViewHolders.kt */
public interface IGlobalCashierPolicyViewHolder extends IGlobalCashierBaseViewHolder {
    void updateBrandLogo(String str);

    void updateContent(String str);

    void updatePolicy(boolean z, Function1<? super Boolean, Unit> function1, List<AcceptContent> list, Function1<? super String, Unit> function12);
}
