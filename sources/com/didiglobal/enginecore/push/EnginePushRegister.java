package com.didiglobal.enginecore.push;

import android.content.Context;
import com.android.didi.bfflib.BffExtra;
import com.didi.sdk.logging.LoggerFactory;
import com.didi.sdk.protobuf.CommonMsgReq;
import com.didi.sdk.push.PushClient;
import com.didi.sdk.push.PushKey;
import com.didi.sdk.push.PushMsgResponse;
import com.didi.sdk.push.PushReceiveListener;
import com.didichuxing.bigdata.p173dp.locsdk.Const;
import com.didiglobal.enginecore.TemplateCompRegister;
import com.didiglobal.enginecore.XEngineCallback;
import com.didiglobal.enginecore.XEngineCommitCallback;
import com.didiglobal.enginecore.XEngineDataHandleCallback;
import com.didiglobal.enginecore.data.parser.XEEngineParser;
import com.didiglobal.enginecore.data.parser.model.EngineParseModel;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.squareup.wire.Wire;
import java.io.IOException;

public class EnginePushRegister {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public static final String f50189a = EnginePushRegister.class.getSimpleName();

    /* renamed from: b */
    private static final int f50190b = 23;

    /* renamed from: c */
    private static final int f50191c = 252;

    /* renamed from: d */
    private PushReceiver f50192d;

    public void register(Context context, PushCallbackCreator pushCallbackCreator, XEngineDataHandleCallback xEngineDataHandleCallback) {
        this.f50192d = new PushReceiver(context, pushCallbackCreator, xEngineDataHandleCallback);
        PushClient.getClient().registerMessageListener(PushKey.Creator.createAppPushMsgKey(23), this.f50192d);
    }

    public void unregister() {
        PushClient.getClient().unregisterMessageListener(PushKey.Creator.createAppPushMsgKey(23), this.f50192d);
    }

    static class PushReceiver implements PushReceiveListener<PushMsgResponse> {
        private Context context;
        private PushCallbackCreator creator;
        private XEngineDataHandleCallback enginePushCallback;

        PushReceiver(Context context2, PushCallbackCreator pushCallbackCreator, XEngineDataHandleCallback xEngineDataHandleCallback) {
            this.context = context2;
            this.creator = pushCallbackCreator;
            this.enginePushCallback = xEngineDataHandleCallback;
        }

        public void onReceive(PushMsgResponse pushMsgResponse) {
            if (pushMsgResponse != null && pushMsgResponse.getPushMsg() != null) {
                try {
                    CommonMsgReq commonMsgReq = (CommonMsgReq) new Wire((Class<?>[]) new Class[0]).parseFrom(pushMsgResponse.getPushMsg().payload.toByteArray(), CommonMsgReq.class);
                    if (commonMsgReq != null) {
                        int intValue = ((Integer) Wire.get(commonMsgReq.recommond_type, CommonMsgReq.DEFAULT_RECOMMOND_TYPE)).intValue();
                        String str = (String) Wire.get(commonMsgReq.recommond_msg, "");
                        String a = EnginePushRegister.f50189a;
                        LoggerFactory.getLogger(a, "onPushMessageReceived() called with:  msgType = [" + intValue + "], data = [" + str + Const.jaRight);
                        if (intValue == 252) {
                            try {
                                engineHandle(this.context, new JsonParser().parse(str).getAsJsonObject());
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    }
                } catch (IOException e2) {
                    e2.printStackTrace();
                }
            }
        }

        private void engineHandle(Context context2, JsonObject jsonObject) {
            PushCallbackCreator pushCallbackCreator;
            if (this.enginePushCallback != null && (pushCallbackCreator = this.creator) != null) {
                XEngineCallback engineCallback = pushCallbackCreator.getEngineCallback();
                String currentScene = this.creator.getCurrentScene();
                XEEngineParser.pushParse(context2, EngineParseModel.Companion.createParseModel(currentScene, TemplateCompRegister.getTemplateKeyList(), TemplateCompRegister.getRequiredTemplateSet(currentScene), jsonObject, engineCallback, (XEngineCommitCallback) null, (BffExtra) null, this.enginePushCallback));
            }
        }
    }
}
