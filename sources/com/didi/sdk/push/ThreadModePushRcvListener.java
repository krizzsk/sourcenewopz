package com.didi.sdk.push;

import com.didi.sdk.push.PushResponse;
import com.didi.sdk.push.thread.ThreadMode;

public interface ThreadModePushRcvListener<T extends PushResponse> extends PushReceiveListener<T> {
    ThreadMode getThreadMode();
}
