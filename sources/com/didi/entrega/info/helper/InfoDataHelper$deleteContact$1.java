package com.didi.entrega.info.helper;

import com.didi.entrega.customer.foundation.rpc.net.CustomerRpcCallback;
import com.didi.entrega.customer.foundation.rpc.net.SFRpcException;
import com.didi.entrega.customer.foundation.util.ResourceHelper;
import com.didi.entrega.info.model.HistoryModel;
import com.taxis99.R;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016J\u001a\u0010\u0007\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u00022\u0006\u0010\t\u001a\u00020\nH\u0016¨\u0006\u000b"}, mo175978d2 = {"com/didi/entrega/info/helper/InfoDataHelper$deleteContact$1", "Lcom/didi/entrega/customer/foundation/rpc/net/CustomerRpcCallback;", "", "onRpcFailure", "", "ex", "Lcom/didi/entrega/customer/foundation/rpc/net/SFRpcException;", "onRpcSuccess", "var1", "var2", "", "entrega-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: InfoDataHelper.kt */
public final class InfoDataHelper$deleteContact$1 extends CustomerRpcCallback<Object> {
    final /* synthetic */ HistoryModel $contactModel;
    final /* synthetic */ Function1<String, Unit> $fail;
    final /* synthetic */ Function1<HistoryModel, Unit> $success;

    InfoDataHelper$deleteContact$1(Function1<? super HistoryModel, Unit> function1, HistoryModel historyModel, Function1<? super String, Unit> function12) {
        this.$success = function1;
        this.$contactModel = historyModel;
        this.$fail = function12;
    }

    public void onRpcSuccess(Object obj, long j) {
        this.$success.invoke(this.$contactModel);
    }

    public void onRpcFailure(SFRpcException sFRpcException) {
        super.onRpcFailure(sFRpcException);
        Function1<String, Unit> function1 = this.$fail;
        String message = sFRpcException == null ? null : sFRpcException.getMessage();
        if (message == null) {
            message = ResourceHelper.getString(R.string.FoodC_info_Unable_to_tlve);
        }
        Intrinsics.checkNotNullExpressionValue(message, "ex?.message\n            …oodC_info_Unable_to_tlve)");
        function1.invoke(message);
    }
}
