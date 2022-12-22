package com.didi.global.fintech.cashier.core.spi;

import com.didi.global.fintech.cashier.model.net.request.CanChangeNewVersionRequest;
import com.didi.global.fintech.cashier.network.processor.GlobalCommonParamsProcessor;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175979k = 3, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: GlobalCashierProcessorImpl.kt */
/* synthetic */ class GlobalCashierProcessorImpl$newVersionCheck$3 extends FunctionReferenceImpl implements Function1<CanChangeNewVersionRequest, CanChangeNewVersionRequest> {
    GlobalCashierProcessorImpl$newVersionCheck$3(Object obj) {
        super(1, obj, GlobalCommonParamsProcessor.class, "process", "process(Lcom/didi/global/fintech/cashier/model/net/request/CashierRequestCommonParams;)Lcom/didi/global/fintech/cashier/model/net/request/CashierRequestCommonParams;", 0);
    }

    public final CanChangeNewVersionRequest invoke(CanChangeNewVersionRequest canChangeNewVersionRequest) {
        Intrinsics.checkNotNullParameter(canChangeNewVersionRequest, "p0");
        return (CanChangeNewVersionRequest) ((GlobalCommonParamsProcessor) this.receiver).process(canChangeNewVersionRequest);
    }
}
