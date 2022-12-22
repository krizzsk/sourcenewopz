package global.didi.pay.threeds.network.api;

import global.didi.pay.threeds.network.callback.ThreedsNetCallback;
import global.didi.pay.threeds.network.model.ThreedsAuthCode;
import global.didi.pay.threeds.network.model.ThreedsCybsResultResponse;
import global.didi.pay.threeds.network.model.ThreedsInit;
import global.didi.pay.threeds.network.model.ThreedsVerify;
import kotlin.Metadata;

@Metadata(mo175977d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u001e\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H&J\u001e\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000b2\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H&J\u001e\u0010\f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u000e2\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H&¨\u0006\u000f"}, mo175978d2 = {"Lglobal/didi/pay/threeds/network/api/ThreedsApi;", "", "channelInfo3DSAuthCode", "", "authCode", "Lglobal/didi/pay/threeds/network/model/ThreedsAuthCode;", "callback", "Lglobal/didi/pay/threeds/network/callback/ThreedsNetCallback;", "Lglobal/didi/pay/threeds/network/model/ThreedsCybsResultResponse;", "channelInfo3DSInit", "init", "Lglobal/didi/pay/threeds/network/model/ThreedsInit;", "channelInfo3DSVerify", "verify", "Lglobal/didi/pay/threeds/network/model/ThreedsVerify;", "payThreeds_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: ThreedsApi.kt */
public interface ThreedsApi {
    void channelInfo3DSAuthCode(ThreedsAuthCode threedsAuthCode, ThreedsNetCallback<ThreedsCybsResultResponse> threedsNetCallback);

    void channelInfo3DSInit(ThreedsInit threedsInit, ThreedsNetCallback<ThreedsCybsResultResponse> threedsNetCallback);

    void channelInfo3DSVerify(ThreedsVerify threedsVerify, ThreedsNetCallback<ThreedsCybsResultResponse> threedsNetCallback);
}
