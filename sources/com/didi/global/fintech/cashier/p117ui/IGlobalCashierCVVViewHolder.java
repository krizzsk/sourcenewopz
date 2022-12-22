package com.didi.global.fintech.cashier.p117ui;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

@Metadata(mo175977d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\n\u0010\u0002\u001a\u0004\u0018\u00010\u0003H&J\u001c\u0010\u0004\u001a\u00020\u00052\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00050\u0007H&J&\u0010\t\u001a\u00020\u00052\b\u0010\n\u001a\u0004\u0018\u00010\u00032\b\u0010\u000b\u001a\u0004\u0018\u00010\u00032\b\u0010\f\u001a\u0004\u0018\u00010\u0003H&J \u0010\r\u001a\u00020\u00052\b\u0010\u000e\u001a\u0004\u0018\u00010\u00032\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00050\u0010H&J\u0012\u0010\u0011\u001a\u00020\u00052\b\u0010\u0012\u001a\u0004\u0018\u00010\u0003H&J\u0012\u0010\u0013\u001a\u00020\u00052\b\u0010\u0012\u001a\u0004\u0018\u00010\u0003H&¨\u0006\u0014"}, mo175978d2 = {"Lcom/didi/global/fintech/cashier/ui/IGlobalCashierCVVViewHolder;", "Lcom/didi/global/fintech/cashier/ui/IGlobalCashierBaseViewHolder;", "getCvvContent", "", "registerTextChangeListener", "", "listener", "Lkotlin/Function1;", "", "updateCardInfo", "prefix", "suffix", "icon", "updateDrawerEntrance", "entrance", "click", "Lkotlin/Function0;", "updateSubTile", "title", "updateTile", "cashier_ui_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* renamed from: com.didi.global.fintech.cashier.ui.IGlobalCashierCVVViewHolder */
/* compiled from: IGlobalCashierViewHolders.kt */
public interface IGlobalCashierCVVViewHolder extends IGlobalCashierBaseViewHolder {
    String getCvvContent();

    void registerTextChangeListener(Function1<? super Integer, Unit> function1);

    void updateCardInfo(String str, String str2, String str3);

    void updateDrawerEntrance(String str, Function0<Unit> function0);

    void updateSubTile(String str);

    void updateTile(String str);
}
