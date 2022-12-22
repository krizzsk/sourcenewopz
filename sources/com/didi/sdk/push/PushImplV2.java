package com.didi.sdk.push;

import com.didi.sdk.push.PushRequestCallback;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

class PushImplV2 extends BasePush {
    public void setDebugMode(int i) {
    }

    PushImplV2(Push push) {
        super(push);
    }

    public int request(PushRequest pushRequest, PushRequestCallback pushRequestCallback) {
        int request = this.push.request(pushRequest.getMsgType(), pushRequest.getData(), pushRequest.getPriority(), pushRequest.getSeqIdOut(), pushRequest.isNeedResponse());
        if (pushRequestCallback != null) {
            if (request == 0) {
                PushOnRequestDispatcher.getInstance().registerRequestCallback(pushRequest.getSeqIdOut(), pushRequestCallback);
            } else {
                PushOnRequestDispatcher.getInstance().execute(pushRequestCallback, new PushRequestCallback.CallbackInfo(request, pushRequest.getMsgType(), pushRequest.getSeqIdOut()));
            }
        }
        return request;
    }

    public void startConnChannel(PushConnParam pushConnParam) {
        byte[] byteArray = pushConnParam.getUserAgent().toByteArray();
        byte[] bytes = pushConnParam.getDocDir().getBytes();
        ByteBuffer order = ByteBuffer.allocate(byteArray.length + 4 + 8 + 8 + 4 + 4 + 4 + bytes.length).order(ByteOrder.LITTLE_ENDIAN);
        order.putInt(byteArray.length).put(byteArray).putLong(pushConnParam.getWriteBufCheckRepeat()).putLong(pushConnParam.getWriteTimeout()).putInt(pushConnParam.getCityId()).putInt(pushConnParam.getFlowTag()).putInt(bytes.length).put(bytes);
        PushLog.mLogger.info("push-debug->PushImplV2:account->%s,host->%s,port->%d,role->%d,token->%s", pushConnParam.getAccount(), pushConnParam.getHost(), Integer.valueOf(pushConnParam.getPort()), Integer.valueOf(pushConnParam.getRole()), pushConnParam.getToken());
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

    public void onAppEvent(int i, int i2) {
        try {
            this.push.onAppEvent(i, i2);
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
