package com.didi.global.fintech.cashier.core.spi;

import com.didi.global.fintech.cashier.model.CashierError;
import com.didi.global.fintech.cashier.model.net.response.CanChangeNewVersionResponse;
import com.didi.global.fintech.cashier.network.callback.CashierNetCallback;
import com.didi.global.fintech.cashier.user.spi.IGlobalCashierProcessor;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0002H\u0016¨\u0006\t"}, mo175978d2 = {"com/didi/global/fintech/cashier/core/spi/GlobalCashierProcessorImpl$newVersionCheck$2", "Lcom/didi/global/fintech/cashier/network/callback/CashierNetCallback;", "Lcom/didi/global/fintech/cashier/model/net/response/CanChangeNewVersionResponse;", "onFailure", "", "error", "Lcom/didi/global/fintech/cashier/model/CashierError;", "onSuccess", "response", "cashier_core_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: GlobalCashierProcessorImpl.kt */
public final class GlobalCashierProcessorImpl$newVersionCheck$2 implements CashierNetCallback<CanChangeNewVersionResponse> {
    final /* synthetic */ IGlobalCashierProcessor.Callback $callback;

    GlobalCashierProcessorImpl$newVersionCheck$2(IGlobalCashierProcessor.Callback callback) {
        this.$callback = callback;
    }

    public void onSuccess(CanChangeNewVersionResponse canChangeNewVersionResponse) {
        Intrinsics.checkNotNullParameter(canChangeNewVersionResponse, "response");
        this.$callback.onResult(canChangeNewVersionResponse.getUseNewVersion());
    }

    public void onFailure(CashierError cashierError) {
        Intrinsics.checkNotNullParameter(cashierError, "error");
        this.$callback.onResult(false);
    }
}
