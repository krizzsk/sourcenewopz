package com.didi.safetoolkit.api;

public interface ISfPushManagerService {

    public interface ISfPushListener {
        void onCommonMsgReceived(int i, String str);
    }

    void registerCommonMsgPush(ISfPushListener iSfPushListener);

    void unregisterCommonMsgPush(ISfPushListener iSfPushListener);
}
