package com.didi.sdk.push;

import com.didichuxing.apollo.sdk.Apollo;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

class PushImplV4 extends PushImplV2 {
    public void setBusinessType(int i) {
    }

    PushImplV4(Push push) {
        super(push);
    }

    public void startConnChannel(PushConnParam pushConnParam) {
        byte[] byteArray = pushConnParam.getUserAgent().toByteArray();
        byte[] bytes = pushConnParam.getDocDir().getBytes();
        byte[] bytes2 = pushConnParam.getAppId().getBytes();
        byte[] bytes3 = pushConnParam.getDeviceId().getBytes();
        byte[] bytes4 = pushConnParam.getFluxMsgType().getBytes();
        ByteBuffer order = ByteBuffer.allocate(byteArray.length + 4 + 8 + 8 + 4 + 4 + 4 + bytes.length + 4 + 4 + 4 + bytes2.length + 4 + bytes3.length + 4 + bytes4.length).order(ByteOrder.LITTLE_ENDIAN);
        order.putInt(byteArray.length).put(byteArray).putLong(pushConnParam.getWriteBufCheckRepeat()).putLong(pushConnParam.getWriteTimeout()).putInt(pushConnParam.getCityId()).putInt(pushConnParam.getFlowTag()).putInt(bytes.length).put(bytes).putInt(pushConnParam.getHeartBeatInterval()).putInt(pushConnParam.getHeartBeatRetryInterval()).putInt(bytes2.length).put(bytes2).putInt(bytes3.length).put(bytes3).putInt(bytes4.length).put(bytes4);
        try {
            String account = pushConnParam.getAccount();
            if (Apollo.getToggle("push_sdk_is_only_use_token", false).allow()) {
                account = "";
            }
            String str = account;
            PushLog.mLogger.info("push-debug->PushImplV4:account->%s,host->%s,port->%d,role->%d,token->%s", str, pushConnParam.getHost(), Integer.valueOf(pushConnParam.getPort()), Integer.valueOf(pushConnParam.getRole()), pushConnParam.getToken());
            this.push.startConnChannel(pushConnParam.getHost(), pushConnParam.getPort(), pushConnParam.getRole(), str, pushConnParam.getToken(), order.array());
        } catch (Exception unused) {
        }
    }

    public void setDebugMode(int i) {
        try {
            this.push.setDebugMode(i);
        } catch (Exception unused) {
        }
    }

    public int localIPStackDetect() {
        try {
            return this.push.localIPStackDetect();
        } catch (Exception unused) {
            return 1;
        }
    }
}
