package com.didi.sdk.p146ad.operation;

import com.didichuxing.foundation.rpc.RpcService;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0002H\u0016¨\u0006\t"}, mo175978d2 = {"com/didi/sdk/ad/operation/BaseAdOperation$request$ability$1", "Lcom/didichuxing/foundation/rpc/RpcService$Callback;", "Lcom/google/gson/JsonObject;", "onFailure", "", "exception", "Ljava/io/IOException;", "onSuccess", "value", "TheOneSDKGlobal_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* renamed from: com.didi.sdk.ad.operation.BaseAdOperation$request$ability$1 */
/* compiled from: BaseAdOperation.kt */
public final class BaseAdOperation$request$ability$1 implements RpcService.Callback<JsonObject> {
    final /* synthetic */ String $appEventType;
    final /* synthetic */ BaseAdOperation this$0;

    BaseAdOperation$request$ability$1(BaseAdOperation baseAdOperation, String str) {
        this.this$0 = baseAdOperation;
        this.$appEventType = str;
    }

    public void onSuccess(JsonObject jsonObject) {
        JsonElement jsonElement;
        Intrinsics.checkNotNullParameter(jsonObject, "value");
        JsonElement jsonElement2 = jsonObject.get("errno");
        Integer valueOf = jsonElement2 == null ? null : Integer.valueOf(jsonElement2.getAsInt());
        if (valueOf != null && valueOf.intValue() == 0 && (jsonElement = jsonObject.get("data")) != null) {
            this.this$0.handResponse((JsonObject) jsonElement, this.$appEventType);
        }
    }

    public void onFailure(IOException iOException) {
        Intrinsics.checkNotNullParameter(iOException, "exception");
        iOException.printStackTrace();
    }
}
