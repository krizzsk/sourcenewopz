package global.didi.pay.threeds.network.api;

import com.didichuxing.foundation.gson.GsonDeserializer;
import com.didichuxing.foundation.gson.GsonSerializer;
import com.didichuxing.foundation.net.rpc.http.annotation.Post;
import com.didichuxing.foundation.rpc.RpcService;
import com.didichuxing.foundation.rpc.annotation.BodyParameter;
import com.didichuxing.foundation.rpc.annotation.Deserialization;
import com.didichuxing.foundation.rpc.annotation.Interception;
import com.didichuxing.foundation.rpc.annotation.Path;
import com.didichuxing.foundation.rpc.annotation.QueryParameter;
import com.didichuxing.foundation.rpc.annotation.Serialization;
import com.didichuxing.foundation.rpc.annotation.TargetThread;
import com.didichuxing.foundation.rpc.annotation.ThreadType;
import global.didi.pay.threeds.network.ThreedsInterceptor;
import global.didi.pay.threeds.network.model.ThreedsAuthCode;
import global.didi.pay.threeds.network.model.ThreedsBaseResponse;
import global.didi.pay.threeds.network.model.ThreedsCybsResultResponse;
import global.didi.pay.threeds.network.model.ThreedsInit;
import global.didi.pay.threeds.network.model.ThreedsVerify;
import kotlin.Metadata;

@Metadata(mo175977d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001JF\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u00052\b\b\u0003\u0010\u0006\u001a\u00020\u00052\b\b\u0003\u0010\u0007\u001a\u00020\u00052\b\b\u0001\u0010\b\u001a\u00020\t2\u0014\b\u0001\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f0\u000bH'JF\u0010\u000e\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u00052\b\b\u0003\u0010\u0006\u001a\u00020\u00052\b\b\u0003\u0010\u0007\u001a\u00020\u00052\b\b\u0001\u0010\u000f\u001a\u00020\u00102\u0014\b\u0001\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f0\u000bH'JF\u0010\u0011\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u00052\b\b\u0003\u0010\u0006\u001a\u00020\u00052\b\b\u0003\u0010\u0007\u001a\u00020\u00052\b\b\u0001\u0010\u0012\u001a\u00020\u00132\u0014\b\u0001\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f0\u000bH'¨\u0006\u0014"}, mo175978d2 = {"Lglobal/didi/pay/threeds/network/api/ThreedsApiRpcService;", "Lcom/didichuxing/foundation/rpc/RpcService;", "channelInfo3DSAuthCode", "", "caller", "", "interfaceName", "demand", "authCode", "Lglobal/didi/pay/threeds/network/model/ThreedsAuthCode;", "callback", "Lcom/didichuxing/foundation/rpc/RpcService$CallbackV2;", "Lglobal/didi/pay/threeds/network/model/ThreedsBaseResponse;", "Lglobal/didi/pay/threeds/network/model/ThreedsCybsResultResponse;", "channelInfo3DSInit", "init", "Lglobal/didi/pay/threeds/network/model/ThreedsInit;", "channelInfo3DSVerify", "verify", "Lglobal/didi/pay/threeds/network/model/ThreedsVerify;", "payThreeds_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: ThreedsApiRpcService.kt */
public interface ThreedsApiRpcService extends RpcService {
    @Serialization(GsonSerializer.class)
    @Path("risk-api/out/channelInfo3DS")
    @Post(contentType = "application/json")
    @Deserialization(GsonDeserializer.class)
    @Interception({ThreedsInterceptor.class})
    void channelInfo3DSAuthCode(@QueryParameter("caller") String str, @QueryParameter("interfaceName") String str2, @QueryParameter("demand") String str3, @BodyParameter("") ThreedsAuthCode threedsAuthCode, @TargetThread(ThreadType.MAIN) RpcService.CallbackV2<ThreedsBaseResponse<ThreedsCybsResultResponse>> callbackV2);

    @Serialization(GsonSerializer.class)
    @Path("risk-api/out/channelInfo3DS")
    @Post(contentType = "application/json")
    @Deserialization(GsonDeserializer.class)
    @Interception({ThreedsInterceptor.class})
    void channelInfo3DSInit(@QueryParameter("caller") String str, @QueryParameter("interfaceName") String str2, @QueryParameter("demand") String str3, @BodyParameter("") ThreedsInit threedsInit, @TargetThread(ThreadType.MAIN) RpcService.CallbackV2<ThreedsBaseResponse<ThreedsCybsResultResponse>> callbackV2);

    @Serialization(GsonSerializer.class)
    @Path("risk-api/out/channelInfo3DS")
    @Post(contentType = "application/json")
    @Deserialization(GsonDeserializer.class)
    @Interception({ThreedsInterceptor.class})
    void channelInfo3DSVerify(@QueryParameter("caller") String str, @QueryParameter("interfaceName") String str2, @QueryParameter("demand") String str3, @BodyParameter("") ThreedsVerify threedsVerify, @TargetThread(ThreadType.MAIN) RpcService.CallbackV2<ThreedsBaseResponse<ThreedsCybsResultResponse>> callbackV2);

    @Metadata(mo175979k = 3, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: ThreedsApiRpcService.kt */
    public static final class DefaultImpls {
        public static /* synthetic */ void channelInfo3DSInit$default(ThreedsApiRpcService threedsApiRpcService, String str, String str2, String str3, ThreedsInit threedsInit, RpcService.CallbackV2 callbackV2, int i, Object obj) {
            if (obj == null) {
                String str4 = (i & 1) != 0 ? "3ds" : str;
                if ((i & 2) != 0) {
                    str2 = "payrisk-api_3ds_init";
                }
                threedsApiRpcService.channelInfo3DSInit(str4, str2, (i & 4) != 0 ? "3ds" : str3, threedsInit, callbackV2);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: channelInfo3DSInit");
        }

        public static /* synthetic */ void channelInfo3DSAuthCode$default(ThreedsApiRpcService threedsApiRpcService, String str, String str2, String str3, ThreedsAuthCode threedsAuthCode, RpcService.CallbackV2 callbackV2, int i, Object obj) {
            if (obj == null) {
                String str4 = (i & 1) != 0 ? "3ds" : str;
                if ((i & 2) != 0) {
                    str2 = "payrisk-api_3ds_authcode";
                }
                threedsApiRpcService.channelInfo3DSAuthCode(str4, str2, (i & 4) != 0 ? "3ds" : str3, threedsAuthCode, callbackV2);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: channelInfo3DSAuthCode");
        }

        public static /* synthetic */ void channelInfo3DSVerify$default(ThreedsApiRpcService threedsApiRpcService, String str, String str2, String str3, ThreedsVerify threedsVerify, RpcService.CallbackV2 callbackV2, int i, Object obj) {
            if (obj == null) {
                String str4 = (i & 1) != 0 ? "3ds" : str;
                if ((i & 2) != 0) {
                    str2 = "payrisk-api_3ds_verify";
                }
                threedsApiRpcService.channelInfo3DSVerify(str4, str2, (i & 4) != 0 ? "3ds" : str3, threedsVerify, callbackV2);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: channelInfo3DSVerify");
        }
    }
}
