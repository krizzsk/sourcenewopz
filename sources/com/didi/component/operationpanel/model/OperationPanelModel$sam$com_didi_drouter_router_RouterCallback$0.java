package com.didi.component.operationpanel.model;

import com.didi.drouter.router.Result;
import com.didi.drouter.router.RouterCallback;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

@Metadata(mo175979k = 3, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: OperationPanelModel.kt */
final class OperationPanelModel$sam$com_didi_drouter_router_RouterCallback$0 implements RouterCallback {
    private final /* synthetic */ Function1 function;

    OperationPanelModel$sam$com_didi_drouter_router_RouterCallback$0(Function1 function1) {
        this.function = function1;
    }

    public final /* synthetic */ void onResult(Result result) {
        this.function.invoke(result);
    }
}
