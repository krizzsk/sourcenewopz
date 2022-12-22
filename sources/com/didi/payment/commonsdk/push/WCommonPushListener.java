package com.didi.payment.commonsdk.push;

import com.didi.sdk.apm.SystemUtils;
import com.didi.sdk.util.TextUtil;
import com.didichuxing.foundation.spi.annotation.ServiceProvider;
import org.greenrobot.eventbus.EventBus;
import org.json.JSONException;
import org.json.JSONObject;

@ServiceProvider({WPushMsgListener.class})
public class WCommonPushListener implements WPushMsgListener {
    public boolean onHandlePushMsg(int i, String str) {
        SystemUtils.log(3, "hgl", "onHandlePushMsg() receive msgType " + i + " payloadjson: " + str, (Throwable) null, "com.didi.payment.commonsdk.push.WCommonPushListener", 35);
        if (i != 270) {
            return false;
        }
        try {
            String optString = new JSONObject(str).optString("inner_message");
            if (!TextUtil.isEmpty(optString)) {
                PixTransferAction pixTransferAction = new PixTransferAction();
                pixTransferAction.payloadJson = optString;
                pixTransferAction.parseInner();
                EventBus.getDefault().post(pixTransferAction);
                return false;
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return false;
    }
}
