package com.didi.global.fintech.cashier.core.api;

import com.didi.global.fintech.cashier.model.net.response.CVVInfoResponse;
import kotlin.Metadata;

@Metadata(mo175977d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, mo175978d2 = {"Lcom/didi/global/fintech/cashier/core/api/ICashierCVVProcessor;", "Lcom/didi/global/fintech/cashier/core/api/ICashierBaseProcessor;", "onCvvInfoSuccess", "", "response", "Lcom/didi/global/fintech/cashier/model/net/response/CVVInfoResponse;", "cashier_core_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: ICashierCVVProcessor.kt */
public interface ICashierCVVProcessor extends ICashierBaseProcessor {
    void onCvvInfoSuccess(CVVInfoResponse cVVInfoResponse);
}
