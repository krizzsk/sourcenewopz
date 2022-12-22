package com.didi.global.fintech.cashier.user.facade;

import kotlin.Metadata;

@Metadata(mo175977d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\n"}, mo175978d2 = {"Lcom/didi/global/fintech/cashier/user/facade/CashierPayResult;", "", "()V", "CODE_METHOD_CHANGE", "", "CODE_PAY_FAILED", "CODE_PAY_SUCCESS", "CODE_PAY_SUCCESS_HOLD", "CODE_PIX_TIMEOUT", "CODE_USER_CANCEL", "cashier_user_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: CashierPayResult.kt */
public final class CashierPayResult {
    public static final int CODE_METHOD_CHANGE = 5;
    public static final int CODE_PAY_FAILED = 3;
    public static final int CODE_PAY_SUCCESS = 1;
    public static final int CODE_PAY_SUCCESS_HOLD = 7;
    public static final int CODE_PIX_TIMEOUT = 4;
    public static final int CODE_USER_CANCEL = 2;
    public static final CashierPayResult INSTANCE = new CashierPayResult();

    private CashierPayResult() {
    }
}
