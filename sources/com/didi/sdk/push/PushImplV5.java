package com.didi.sdk.push;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

class PushImplV5 extends PushImplV4 {
    PushImplV5(Push push) {
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
        PushLog.mLogger.info("push-debug->PushImplV5:account->%s,host->%s,port->%d,role->%d,token->%s", pushConnParam.getAccount(), pushConnParam.getHost(), Integer.valueOf(pushConnParam.getPort()), Integer.valueOf(pushConnParam.getRole()), pushConnParam.getToken());
        try {
            this.push.startConnChannel(pushConnParam.getHost(), pushConnParam.getPort(), pushConnParam.getRole(), pushConnParam.getAccount(), pushConnParam.getToken(), order.array());
        } catch (Exception unused) {
        }
    }

    public void setBusinessType(int i) {
        try {
            this.push.setBusinessType(i);
        } catch (Exception unused) {
        }
    }
}
