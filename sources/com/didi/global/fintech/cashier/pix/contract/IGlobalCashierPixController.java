package com.didi.global.fintech.cashier.pix.contract;

import kotlin.Metadata;

@Metadata(mo175977d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001:\u0001\tJ\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH&¨\u0006\n"}, mo175978d2 = {"Lcom/didi/global/fintech/cashier/pix/contract/IGlobalCashierPixController;", "", "finish", "", "getPixCode", "", "updateState", "state", "Lcom/didi/global/fintech/cashier/pix/contract/IGlobalCashierPixController$State;", "State", "cashier_pix_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: IGlobalCashierPixController.kt */
public interface IGlobalCashierPixController {

    @Metadata(mo175977d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, mo175978d2 = {"Lcom/didi/global/fintech/cashier/pix/contract/IGlobalCashierPixController$State;", "", "(Ljava/lang/String;I)V", "Normal", "Loading", "Success", "Timeout", "cashier_pix_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: IGlobalCashierPixController.kt */
    public enum State {
        Normal,
        Loading,
        Success,
        Timeout
    }

    void finish();

    String getPixCode();

    void updateState(State state);
}
