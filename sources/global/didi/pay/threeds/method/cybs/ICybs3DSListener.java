package global.didi.pay.threeds.method.cybs;

import global.didi.pay.threeds.network.model.ThreedsCybsDataResponse;
import global.didi.pay.threeds.network.model.ThreedsError;
import kotlin.Metadata;

@Metadata(mo175977d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0010\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H&J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\tH&¨\u0006\n"}, mo175978d2 = {"Lglobal/didi/pay/threeds/method/cybs/ICybs3DSListener;", "", "onCancel", "", "onFailure", "error", "Lglobal/didi/pay/threeds/network/model/ThreedsError;", "onSuccess", "data", "Lglobal/didi/pay/threeds/network/model/ThreedsCybsDataResponse;", "payThreeds_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: ICybs3DSListener.kt */
public interface ICybs3DSListener {
    void onCancel();

    void onFailure(ThreedsError threedsError);

    void onSuccess(ThreedsCybsDataResponse threedsCybsDataResponse);
}
