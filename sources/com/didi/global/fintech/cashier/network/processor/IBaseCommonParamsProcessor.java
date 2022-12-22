package com.didi.global.fintech.cashier.network.processor;

import com.didi.global.fintech.cashier.model.net.request.CashierRequestCommonParams;
import kotlin.Metadata;

@Metadata(mo175977d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u001f\u0010\u0002\u001a\u0002H\u0003\"\b\b\u0000\u0010\u0003*\u00020\u00042\u0006\u0010\u0005\u001a\u0002H\u0003H&¢\u0006\u0002\u0010\u0006¨\u0006\u0007"}, mo175978d2 = {"Lcom/didi/global/fintech/cashier/network/processor/IBaseCommonParamsProcessor;", "", "process", "T", "Lcom/didi/global/fintech/cashier/model/net/request/CashierRequestCommonParams;", "param", "(Lcom/didi/global/fintech/cashier/model/net/request/CashierRequestCommonParams;)Lcom/didi/global/fintech/cashier/model/net/request/CashierRequestCommonParams;", "cashier_network_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: IBaseCommonParamsProcessor.kt */
public interface IBaseCommonParamsProcessor {
    <T extends CashierRequestCommonParams> T process(T t);
}
