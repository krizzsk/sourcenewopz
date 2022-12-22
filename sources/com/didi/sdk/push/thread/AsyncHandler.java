package com.didi.sdk.push.thread;

import com.didi.sdk.push.PushReceiveListener;
import com.didi.sdk.push.PushResponse;
import java.util.concurrent.ExecutorService;

public final class AsyncHandler implements Runnable {
    private final PendingPostQueue mQueue = new PendingPostQueue();

    public void enqueue(ExecutorService executorService, PushReceiveListener pushReceiveListener, PushResponse pushResponse) {
        this.mQueue.enqueue(PendingPost.obtainPendingPost(pushReceiveListener, pushResponse));
        executorService.execute(this);
    }

    public void run() {
        PushReceiveListener pushReceiveListener;
        PendingPost poll = this.mQueue.poll();
        if (poll != null && (pushReceiveListener = poll.mPushRcvDataListener) != null) {
            pushReceiveListener.onReceive(poll.mResponse);
            PendingPost.releasePendingPost(poll);
        }
    }
}
