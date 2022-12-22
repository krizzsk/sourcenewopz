package com.didi.app.delegate;

import android.util.Log;
import com.didi.sdk.apm.SystemUtils;
import com.didi.sdk.nation.NationTypeUtil;
import com.didi.sdk.protobuf.MsgType;
import com.didi.sdk.protobuf.PushMsg;
import com.didi.sdk.push.ByteArrayPushResponse;
import com.didi.sdk.push.PushClient;
import com.didi.sdk.push.PushKey;
import com.didi.sdk.push.PushReceiveListener;
import com.didi.sdk.push.PushResponse;
import com.didi.sdk.push.ServerParam;
import com.didi.sdk.util.AppUtils;
import com.didi.sdk.util.EventKeys;
import com.didichuxing.foundation.net.rpc.http.annotation.Get;
import com.didichuxing.foundation.p188io.StringDeserializer;
import com.didichuxing.foundation.rpc.RpcService;
import com.didichuxing.foundation.rpc.RpcServiceFactory;
import com.didichuxing.foundation.rpc.annotation.Deserialization;
import com.didichuxing.foundation.rpc.annotation.Path;
import com.didichuxing.foundation.rpc.annotation.QueryParameter;
import com.didichuxing.foundation.rpc.annotation.TargetThread;
import com.didichuxing.foundation.rpc.annotation.ThreadType;
import com.didichuxing.foundation.spi.annotation.ServiceProvider;
import com.didiglobal.omegasdkadapter.OmegaSDKAdapter;
import com.squareup.wire.Wire;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@ServiceProvider({PushReceiveListener.class})
public class MsgGateService implements PushKey, PushReceiveListener<PushResponse> {
    public static final int MSG_ARRIVED_PASS = 3;
    public static final String URL = "https://msggate.didiglobal.com/server/msgmonitor/update";

    /* renamed from: a */
    private static final String f8248a = "MsgGateService";

    /* renamed from: c */
    private static final ThreadLocal<Wire> f8249c = new ThreadLocal<>();

    /* renamed from: b */
    private PushIdService f8250b;

    @Path("")
    public interface PushIdService extends RpcService {
        @Get
        @Deserialization(StringDeserializer.class)
        void collectCid(@QueryParameter("") Map<String, Object> map, @TargetThread(ThreadType.MAIN) RpcService.Callback<String> callback);
    }

    public void onReceive(PushResponse pushResponse) {
        SystemUtils.log(3, f8248a, "onReceive()", (Throwable) null, "com.didi.app.delegate.MsgGateService", 52);
        if (!(pushResponse instanceof ByteArrayPushResponse)) {
            SystemUtils.log(6, f8248a, "rsp not match", (Throwable) null, "com.didi.app.delegate.MsgGateService", 56);
            return;
        }
        ByteArrayPushResponse byteArrayPushResponse = (ByteArrayPushResponse) pushResponse;
        if (byteArrayPushResponse.getMsgType() == MsgType.kMsgTypeAppPushMessageReq.getValue()) {
            try {
                Wire wire = f8249c.get();
                if (wire == null) {
                    wire = new Wire((Class<?>[]) new Class[0]);
                    f8249c.set(wire);
                }
                PushMsg pushMsg = (PushMsg) wire.parseFrom(byteArrayPushResponse.getOriginData(), PushMsg.class);
                if (pushMsg != null && pushMsg.p_id != null) {
                    m5418a(3, String.valueOf(pushMsg.p_id));
                }
            } catch (Exception e) {
                HashMap hashMap = new HashMap();
                hashMap.put("data", byteArrayPushResponse.getOriginData());
                hashMap.put("error", e.getMessage());
                OmegaSDKAdapter.trackEvent("tech_pax_push_msg_parse_error", (Map<String, Object>) hashMap);
            }
        }
    }

    /* renamed from: a */
    private void m5418a(int i, String str) {
        if (this.f8250b == null) {
            this.f8250b = (PushIdService) new RpcServiceFactory(PushClient.getClient().getOption().getContext()).newRpcService(PushIdService.class, URL);
        }
        HashMap hashMap = new HashMap();
        hashMap.put("p_id", str);
        hashMap.put("state", Integer.valueOf(i));
        hashMap.put(ServerParam.PARAM_APP_TYPE_PUSH, AppUtils.getMetaDataByKey(EventKeys.APP_FCM_APPKEY));
        hashMap.put("token", NationTypeUtil.getNationComponentData().getLoginInfo().getToken());
        this.f8250b.collectCid(hashMap, new RpcService.Callback<String>() {
            public void onSuccess(String str) {
                SystemUtils.log(3, MsgGateService.f8248a, "uploadBackToServer onSuccess() result = " + str, (Throwable) null, "com.didi.app.delegate.MsgGateService$1", 101);
            }

            public void onFailure(IOException iOException) {
                SystemUtils.log(3, MsgGateService.f8248a, Log.getStackTraceString(iOException), (Throwable) null, "com.didi.app.delegate.MsgGateService$1", 106);
                OmegaSDKAdapter.trackEvent("Msggate_Upload_Failed");
            }
        });
    }

    public long generateKey() {
        return PushKey.Creator.createPushMsgKey(MsgType.kMsgTypeAppPushMessageReq.getValue()).generateKey();
    }
}
