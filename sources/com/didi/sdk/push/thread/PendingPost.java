package com.didi.sdk.push.thread;

import com.didi.sdk.push.PushReceiveListener;
import com.didi.sdk.push.PushResponse;
import java.util.ArrayList;
import java.util.List;

final class PendingPost {
    private static final int DEFAULT_CACHED_SIZE = 100;
    private static final List<PendingPost> pendingPostPool = new ArrayList();
    PendingPost mNext;
    PushReceiveListener mPushRcvDataListener;
    PushResponse mResponse;

    private PendingPost(PushReceiveListener pushReceiveListener, PushResponse pushResponse) {
        this.mPushRcvDataListener = pushReceiveListener;
        this.mResponse = pushResponse;
    }

    static PendingPost obtainPendingPost(PushReceiveListener pushReceiveListener, PushResponse pushResponse) {
        synchronized (pendingPostPool) {
            int size = pendingPostPool.size();
            if (size <= 0) {
                return new PendingPost(pushReceiveListener, pushResponse);
            }
            PendingPost remove = pendingPostPool.remove(size - 1);
            remove.mResponse = pushResponse;
            remove.mPushRcvDataListener = pushReceiveListener;
            remove.mNext = null;
            return remove;
        }
    }

    static void releasePendingPost(PendingPost pendingPost) {
        pendingPost.mResponse = null;
        pendingPost.mPushRcvDataListener = null;
        pendingPost.mNext = null;
        synchronized (pendingPostPool) {
            if (pendingPostPool.size() < 100) {
                pendingPostPool.add(pendingPost);
            }
        }
    }
}
