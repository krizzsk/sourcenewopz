package com.didiglobal.pay.paysecure;

import kotlin.Metadata;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H&J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0005H&¨\u0006\t"}, mo175978d2 = {"Lcom/didiglobal/pay/paysecure/PayPwdResultListener;", "", "onFailure", "", "status", "", "desc", "onSuccess", "token", "paysecure_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
/* compiled from: Listener.kt */
public interface PayPwdResultListener {
    void onFailure(String str, String str2);

    void onSuccess(String str);
}
