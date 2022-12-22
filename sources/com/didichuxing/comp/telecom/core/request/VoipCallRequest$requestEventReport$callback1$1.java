package com.didichuxing.comp.telecom.core.request;

import com.didichuxing.comp.telecom.core.request.model.CallEventResponse;
import com.didichuxing.foundation.rpc.RpcService;
import java.io.IOException;
import kotlin.Metadata;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016J\u0012\u0010\u0007\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u0002H\u0016¨\u0006\t"}, mo175978d2 = {"com/didichuxing/comp/telecom/core/request/VoipCallRequest$requestEventReport$callback1$1", "Lcom/didichuxing/foundation/rpc/RpcService$Callback;", "Lcom/didichuxing/comp/telecom/core/request/model/CallEventResponse;", "onFailure", "", "exception", "Ljava/io/IOException;", "onSuccess", "value", "voip-core_release"}, mo175979k = 1, mo175980mv = {1, 1, 13})
/* compiled from: CallRequest.kt */
public final class VoipCallRequest$requestEventReport$callback1$1 implements RpcService.Callback<CallEventResponse> {
    public void onFailure(IOException iOException) {
    }

    public void onSuccess(CallEventResponse callEventResponse) {
    }

    VoipCallRequest$requestEventReport$callback1$1() {
    }
}
