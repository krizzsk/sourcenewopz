package com.didi.global.fintech.cashier.core.api;

import com.didi.global.fintech.cashier.model.net.response.PrepayResponse;
import kotlin.Metadata;

@Metadata(mo175977d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&J\u0012\u0010\b\u001a\u00020\u00032\b\u0010\t\u001a\u0004\u0018\u00010\nH&¨\u0006\u000b"}, mo175978d2 = {"Lcom/didi/global/fintech/cashier/core/api/ICashierPrepayProcessor;", "Lcom/didi/global/fintech/cashier/core/api/ICashierBaseProcessor;", "onPrePayFail", "", "errorCode", "", "msg", "", "onPrePaySuccess", "prepay", "Lcom/didi/global/fintech/cashier/model/net/response/PrepayResponse;", "cashier_core_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: ICashierPrepayProcessor.kt */
public interface ICashierPrepayProcessor extends ICashierBaseProcessor {
    void onPrePayFail(int i, String str);

    void onPrePaySuccess(PrepayResponse prepayResponse);
}
