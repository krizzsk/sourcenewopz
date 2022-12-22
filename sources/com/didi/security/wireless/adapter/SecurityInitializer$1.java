package com.didi.security.wireless.adapter;

import com.didi.sdk.protobuf.PushMsg;
import com.didi.sdk.push.PushMsgResponse;
import com.didi.sdk.push.PushReceiveListener;
import com.didi.sdk.push.PushResponse;
import com.didi.security.wireless.SecurityManager;

class SecurityInitializer$1 implements PushReceiveListener {
    SecurityInitializer$1() {
    }

    public void onReceive(PushResponse pushResponse) {
        PushMsg pushMsg;
        if (pushResponse != null && (pushResponse instanceof PushMsgResponse) && (pushMsg = ((PushMsgResponse) pushResponse).getPushMsg()) != null && pushMsg.payload != null) {
            SecurityManager.reportByCmd(pushMsg.payload.utf8());
        }
    }
}
