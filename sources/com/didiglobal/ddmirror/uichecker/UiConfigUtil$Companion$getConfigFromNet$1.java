package com.didiglobal.ddmirror.uichecker;

import com.didi.sdk.apm.SystemUtils;
import com.didichuxing.foundation.rpc.RpcService;
import com.didiglobal.ddmirror.uichecker.model.UiConfig;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0012\u0010\u0007\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u0002H\u0016¨\u0006\t"}, mo175978d2 = {"com/didiglobal/ddmirror/uichecker/UiConfigUtil$Companion$getConfigFromNet$1", "Lcom/didichuxing/foundation/rpc/RpcService$Callback;", "Lcom/didiglobal/ddmirror/uichecker/model/UiConfig;", "onFailure", "", "exception", "Ljava/io/IOException;", "onSuccess", "value", "DDMirror_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
/* compiled from: UiConfigUtil.kt */
public final class UiConfigUtil$Companion$getConfigFromNet$1 implements RpcService.Callback<UiConfig> {
    UiConfigUtil$Companion$getConfigFromNet$1() {
    }

    public void onSuccess(UiConfig uiConfig) {
        SystemUtils.log(4, "UiConfigUtil", "getConfigFromNet success", (Throwable) null, "com.didiglobal.ddmirror.uichecker.UiConfigUtil$Companion$getConfigFromNet$1", 49);
        UiConfigUtil.Companion.setConfig(uiConfig);
        UiChecker.Companion.initConfig(UiConfigUtil.Companion.getConfig());
    }

    public void onFailure(IOException iOException) {
        Intrinsics.checkParameterIsNotNull(iOException, "exception");
        SystemUtils.log(4, "UiConfigUtil", "getConfigFromNet onFailure", (Throwable) null, "com.didiglobal.ddmirror.uichecker.UiConfigUtil$Companion$getConfigFromNet$1", 55);
    }
}
