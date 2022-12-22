package global.didi.pay.threeds.network;

import android.content.Context;
import com.didi.unifylogin.utils.LoginOmegaUtil;
import com.didichuxing.foundation.spi.ServiceLoader;
import global.didi.pay.newview.pix.IPixView;
import global.didi.pay.threeds.contract.ICybs3DSConfig;
import global.didi.pay.threeds.network.api.ThreedsApi;
import global.didi.pay.threeds.network.api.ThreedsApiRpcService;
import global.didi.pay.threeds.network.callback.ThreedsNetCallback;
import global.didi.pay.threeds.network.model.ThreedsAuthCode;
import global.didi.pay.threeds.network.model.ThreedsBaseRequest;
import global.didi.pay.threeds.network.model.ThreedsCybsResultResponse;
import global.didi.pay.threeds.network.model.ThreedsInit;
import global.didi.pay.threeds.network.model.ThreedsVerify;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(mo175977d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u001e\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013H\u0016J\u001e\u0010\u0015\u001a\u00020\u000f2\u0006\u0010\u0016\u001a\u00020\u00172\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013H\u0016J\u001e\u0010\u0018\u001a\u00020\u000f2\u0006\u0010\u0019\u001a\u00020\u001a2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013H\u0016J\u001d\u0010\u001b\u001a\u0002H\u001c\"\b\b\u0000\u0010\u001c*\u00020\u001d2\u0006\u0010\u001e\u001a\u0002H\u001c¢\u0006\u0002\u0010\u001fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0005\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\b\u001a\u00020\t8BX\u0002¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\n\u0010\u000b¨\u0006 "}, mo175978d2 = {"Lglobal/didi/pay/threeds/network/ThreedsNetwork;", "Lglobal/didi/pay/threeds/network/api/ThreedsApi;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "cybs3DSConfiger", "Lglobal/didi/pay/threeds/contract/ICybs3DSConfig;", "kotlin.jvm.PlatformType", "threedsApiRpcService", "Lglobal/didi/pay/threeds/network/api/ThreedsApiRpcService;", "getThreedsApiRpcService", "()Lglobal/didi/pay/threeds/network/api/ThreedsApiRpcService;", "threedsApiRpcService$delegate", "Lkotlin/Lazy;", "channelInfo3DSAuthCode", "", "authCode", "Lglobal/didi/pay/threeds/network/model/ThreedsAuthCode;", "callback", "Lglobal/didi/pay/threeds/network/callback/ThreedsNetCallback;", "Lglobal/didi/pay/threeds/network/model/ThreedsCybsResultResponse;", "channelInfo3DSInit", "init", "Lglobal/didi/pay/threeds/network/model/ThreedsInit;", "channelInfo3DSVerify", "verify", "Lglobal/didi/pay/threeds/network/model/ThreedsVerify;", "process", "T", "Lglobal/didi/pay/threeds/network/model/ThreedsBaseRequest;", "param", "(Lglobal/didi/pay/threeds/network/model/ThreedsBaseRequest;)Lglobal/didi/pay/threeds/network/model/ThreedsBaseRequest;", "payThreeds_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: ThreedsNetwork.kt */
public final class ThreedsNetwork implements ThreedsApi {
    /* access modifiers changed from: private */
    public final Context context;
    private final ICybs3DSConfig cybs3DSConfiger = ((ICybs3DSConfig) ServiceLoader.load(ICybs3DSConfig.class).get());
    private final Lazy threedsApiRpcService$delegate = LazyKt.lazy(new ThreedsNetwork$threedsApiRpcService$2(this));

    public ThreedsNetwork(Context context2) {
        Intrinsics.checkNotNullParameter(context2, "context");
        this.context = context2;
    }

    public final <T extends ThreedsBaseRequest> T process(T t) {
        Intrinsics.checkNotNullParameter(t, "param");
        t.setChannelNameOf3ds("cybersource");
        t.setPassportToken(this.cybs3DSConfiger.token(this.context));
        long currentTimeMillis = System.currentTimeMillis();
        t.setTimestamp(StringsKt.dropLast(String.valueOf(currentTimeMillis), 3));
        t.setNonce(StringsKt.drop(String.valueOf(currentTimeMillis), 7));
        return t;
    }

    private final ThreedsApiRpcService getThreedsApiRpcService() {
        Object value = this.threedsApiRpcService$delegate.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-threedsApiRpcService>(...)");
        return (ThreedsApiRpcService) value;
    }

    public void channelInfo3DSInit(ThreedsInit threedsInit, ThreedsNetCallback<ThreedsCybsResultResponse> threedsNetCallback) {
        Intrinsics.checkNotNullParameter(threedsInit, IPixView.PAGE_STATUS_INIT);
        Intrinsics.checkNotNullParameter(threedsNetCallback, "callback");
        ThreedsApiRpcService.DefaultImpls.channelInfo3DSInit$default(getThreedsApiRpcService(), (String) null, (String) null, (String) null, (ThreedsInit) process(threedsInit), new C20958xf063f37d(threedsNetCallback), 7, (Object) null);
    }

    public void channelInfo3DSAuthCode(ThreedsAuthCode threedsAuthCode, ThreedsNetCallback<ThreedsCybsResultResponse> threedsNetCallback) {
        Intrinsics.checkNotNullParameter(threedsAuthCode, "authCode");
        Intrinsics.checkNotNullParameter(threedsNetCallback, "callback");
        ThreedsApiRpcService.DefaultImpls.channelInfo3DSAuthCode$default(getThreedsApiRpcService(), (String) null, (String) null, (String) null, (ThreedsAuthCode) process(threedsAuthCode), new C20957xa8428cb8(threedsNetCallback), 7, (Object) null);
    }

    public void channelInfo3DSVerify(ThreedsVerify threedsVerify, ThreedsNetCallback<ThreedsCybsResultResponse> threedsNetCallback) {
        Intrinsics.checkNotNullParameter(threedsVerify, LoginOmegaUtil.NEED_VERIFY_EMAIL);
        Intrinsics.checkNotNullParameter(threedsNetCallback, "callback");
        ThreedsApiRpcService.DefaultImpls.channelInfo3DSVerify$default(getThreedsApiRpcService(), (String) null, (String) null, (String) null, (ThreedsVerify) process(threedsVerify), new C20959x53dbf474(threedsNetCallback), 7, (Object) null);
    }
}
