package global.didi.pay.threeds.network.callback;

import global.didi.pay.threeds.network.model.ThreedsError;
import kotlin.Metadata;

@Metadata(mo175977d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H&J\u0015\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00028\u0000H&¢\u0006\u0002\u0010\t¨\u0006\n"}, mo175978d2 = {"Lglobal/didi/pay/threeds/network/callback/ThreedsNetCallback;", "T", "", "onFailure", "", "error", "Lglobal/didi/pay/threeds/network/model/ThreedsError;", "onSuccess", "response", "(Ljava/lang/Object;)V", "payThreeds_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: ThreedsNetCallback.kt */
public interface ThreedsNetCallback<T> {
    void onFailure(ThreedsError threedsError);

    void onSuccess(T t);
}
