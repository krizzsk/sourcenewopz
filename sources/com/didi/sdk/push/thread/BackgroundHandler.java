package com.didi.sdk.push.thread;

import com.didi.sdk.push.PushReceiveListener;
import com.didi.sdk.push.PushResponse;
import java.util.concurrent.ExecutorService;

public final class BackgroundHandler implements Runnable {
    private volatile boolean executorRunning;
    private final PendingPostQueue mQueue = new PendingPostQueue();

    public void enqueue(ExecutorService executorService, PushReceiveListener pushReceiveListener, PushResponse pushResponse) {
        PendingPost obtainPendingPost = PendingPost.obtainPendingPost(pushReceiveListener, pushResponse);
        synchronized (this) {
            this.mQueue.enqueue(obtainPendingPost);
            if (!this.executorRunning) {
                this.executorRunning = true;
                executorService.execute(this);
            }
        }
    }

    public void run() {
        while (true) {
            try {
                PendingPost poll = this.mQueue.poll(60000);
                if (poll == null) {
                    synchronized (this) {
                        poll = this.mQueue.poll();
                        if (poll == null) {
                            this.executorRunning = false;
                            this.executorRunning = false;
                            return;
                        }
                    }
                }
                PushReceiveListener pushReceiveListener = poll.mPushRcvDataListener;
                if (pushReceiveListener != null) {
                    pushReceiveListener.onReceive(poll.mResponse);
                }
                PendingPost.releasePendingPost(poll);
            } catch (InterruptedException unused) {
                this.executorRunning = false;
                return;
            } catch (Throwable th) {
                this.executorRunning = false;
                throw th;
            }
        }
    }
}
