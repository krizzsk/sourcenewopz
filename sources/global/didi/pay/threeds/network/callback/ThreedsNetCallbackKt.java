package global.didi.pay.threeds.network.callback;

import com.didichuxing.foundation.rpc.RpcService;
import global.didi.pay.threeds.network.model.ThreedsBaseResponse;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u001a+\u0010\u0000\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00030\u00020\u0001\"\u0006\b\u0000\u0010\u0003\u0018\u00012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00030\u0005H\b¨\u0006\u0006"}, mo175978d2 = {"getBaseResponseCallback", "Lcom/didichuxing/foundation/rpc/RpcService$CallbackV2;", "Lglobal/didi/pay/threeds/network/model/ThreedsBaseResponse;", "T", "callback", "Lglobal/didi/pay/threeds/network/callback/ThreedsNetCallback;", "payThreeds_release"}, mo175979k = 2, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: ThreedsNetCallback.kt */
public final class ThreedsNetCallbackKt {
    public static final /* synthetic */ <T> RpcService.CallbackV2<ThreedsBaseResponse<T>> getBaseResponseCallback(ThreedsNetCallback<T> threedsNetCallback) {
        Intrinsics.checkNotNullParameter(threedsNetCallback, "callback");
        Intrinsics.needClassReification();
        return new ThreedsNetCallbackKt$getBaseResponseCallback$1(threedsNetCallback);
    }
}
