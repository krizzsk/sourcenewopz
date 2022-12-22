package com.didi.sdk.push;

import android.content.Context;

abstract class BasePush implements IPush {
    protected Push push;

    public void config(PushConfig pushConfig) {
    }

    public void configLite(PushConfig pushConfig) {
    }

    public int localIPStackDetect() {
        return 1;
    }

    public void onAppEvent(int i, int i2) {
    }

    public void setBusinessType(int i) {
    }

    public void setDebugMode(int i) {
    }

    public void startConnChannel(PushConnParam pushConnParam) {
    }

    BasePush(Push push2) {
        this.push = push2;
    }

    public void init(Context context) {
        try {
            this.push.init(context);
        } catch (Exception unused) {
        }
    }

    public boolean isConnected() {
        try {
            return this.push.isConnected();
        } catch (Exception unused) {
            return false;
        }
    }

    public int request(PushRequest pushRequest, PushRequestCallback pushRequestCallback) {
        try {
            return this.push.request(pushRequest.getMsgType(), pushRequest.getData(), pushRequest.getPriority(), pushRequest.getSeqIdOut(), pushRequest.isNeedResponse());
        } catch (Exception unused) {
            return -1;
        }
    }

    public void startLoop() {
        new Thread(new Runnable() {
            public void run() {
                try {
                    BasePush.this.push.startLoop();
                } catch (Exception unused) {
                }
            }
        }).start();
    }

    public void stopLoop() {
        try {
            this.push.stopLoop();
        } catch (Exception unused) {
        }
    }

    public void stopConnChannel() {
        try {
            this.push.stopConnChannel();
        } catch (Exception unused) {
        }
    }

    public void destroy() {
        try {
            this.push.destory();
        } catch (Exception unused) {
        }
    }

    public void setPushCallback(IPushCallback iPushCallback) {
        try {
            this.push.setCallback(iPushCallback);
        } catch (Exception unused) {
        }
    }
}
