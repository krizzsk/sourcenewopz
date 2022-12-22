package com.didi.component.safetoolkit.sodaentregaapi;

import com.didi.safetoolkit.api.ISfPushManagerService;
import com.didi.safetoolkit.util.SfLog;
import com.didi.safetoolkit.util.SfUIThreadHelper;
import com.didi.sdk.messagecenter.p152pb.CommonMsgReq;
import com.didi.sdk.messagecenter.p152pb.PushMessageType;
import com.didi.sdk.push.manager.DPushBody;
import com.didi.sdk.push.manager.DPushListener;
import com.didi.sdk.push.manager.DPushManager;
import com.didi.sdk.push.manager.DPushType;
import com.didichuxing.foundation.spi.annotation.ServiceProvider;
import com.squareup.wire.Wire;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@ServiceProvider(alias = "sodaEntrega", value = {ISfPushManagerService.class})
public class SodaEntregaPushManagerProvider implements ISfPushManagerService {

    /* renamed from: a */
    private Map<ISfPushManagerService.ISfPushListener, DPushListener> f15416a = new HashMap();

    public void registerCommonMsgPush(final ISfPushManagerService.ISfPushListener iSfPushListener) {
        final int value = PushMessageType.kPushMessageTypeCommonMsgReq.getValue();
        C67751 r1 = new DPushListener() {
            public DPushType pushType() {
                return DPushType.TENCENT_PUSH;
            }

            public void pushBody(DPushBody dPushBody) {
                CommonMsgReq commonMsgReq;
                try {
                    commonMsgReq = (CommonMsgReq) new Wire((Class<?>[]) new Class[0]).parseFrom(dPushBody.getData(), CommonMsgReq.class);
                } catch (IOException e) {
                    e.printStackTrace();
                    commonMsgReq = null;
                }
                if (commonMsgReq != null) {
                    final int intValue = ((Integer) Wire.get(commonMsgReq.recommond_type, CommonMsgReq.DEFAULT_RECOMMOND_TYPE)).intValue();
                    final String str = (String) Wire.get(commonMsgReq.recommond_msg, "");
                    SfLog.m24401d("received push message: (type: " + intValue + "\t  message: " + str + ")");
                    SfUIThreadHelper.post(new Runnable() {
                        public void run() {
                            iSfPushListener.onCommonMsgReceived(intValue, str);
                        }
                    });
                }
            }

            public String topic() {
                return value + "";
            }
        };
        this.f15416a.put(iSfPushListener, r1);
        DPushManager.getInstance().registerPush((DPushListener) r1);
    }

    public void unregisterCommonMsgPush(ISfPushManagerService.ISfPushListener iSfPushListener) {
        if (this.f15416a.containsKey(iSfPushListener)) {
            DPushManager.getInstance().unregisterPush(this.f15416a.remove(iSfPushListener));
        }
    }
}
