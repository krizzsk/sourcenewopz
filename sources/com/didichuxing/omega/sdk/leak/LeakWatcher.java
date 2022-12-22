package com.didichuxing.omega.sdk.leak;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.didichuxing.ditest.agent.android.background.ApplicationStateEvent;
import com.didichuxing.ditest.agent.android.background.ApplicationStateListener;
import com.didichuxing.ditest.agent.android.background.ApplicationStateMonitor;
import com.didichuxing.omega.sdk.common.utils.CommonUtil;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArraySet;

class LeakWatcher {
    /* access modifiers changed from: private */
    public LeakCollector mCollector;
    /* access modifiers changed from: private */
    public final GCTrigger mGCTrigger;
    private final ReferenceQueue<Object> mQueue;
    private final Set<String> mRetainedKeys;
    private final Handler mWatchHandler;
    private Runnable mWatchRetainedRun = new Runnable() {
        public void run() {
            if (LeakWatcher.this.mCollector != null && LeakWatcher.this.mCollector.hasRetainedRef()) {
                long currentTimeMillis = System.currentTimeMillis();
                LeakWatcher.this.mGCTrigger.runGc();
                LeakWatcher.this.mCollector.onGCRan(currentTimeMillis);
            }
        }
    };

    public LeakWatcher(Handler handler, GCTrigger gCTrigger) {
        this.mGCTrigger = gCTrigger;
        this.mWatchHandler = handler;
        this.mQueue = new ReferenceQueue<>();
        this.mRetainedKeys = new CopyOnWriteArraySet();
    }

    private void registerActivitListener() {
        ApplicationStateMonitor.getInstance().addApplicationStateListener(new ApplicationStateListener() {
            public void applicationForegrounded(ApplicationStateEvent applicationStateEvent) {
            }

            public void applicationBackgrounded(ApplicationStateEvent applicationStateEvent) {
                LeakWatcher.this.watchRetainedRef();
            }
        });
    }

    /* access modifiers changed from: private */
    public void watchRetainedRef() {
        LeakCollector leakCollector = this.mCollector;
        if (leakCollector != null && leakCollector.hasRetainedRef()) {
            this.mWatchHandler.removeCallbacks(this.mWatchRetainedRun);
            this.mWatchHandler.postDelayed(this.mWatchRetainedRun, (long) (LeakCollector.MAX_WATCH_TIME - 100));
        }
    }

    public void watch(Object obj) {
        if (obj != null) {
            watch(obj, obj.getClass().getName());
        }
    }

    public void watch(Object obj, String str) {
        if (!CommonUtil.isUpperLimitByDay("upper_limit_obj_leaked_event_key", LeakCollector.MAX_UPPER_COUNT_BY_DAY) && obj != null && !TextUtils.isEmpty(str) && !(obj instanceof WeakReference)) {
            String uuid = UUID.randomUUID().toString();
            this.mRetainedKeys.add(uuid);
            final KeyedWeakReference keyedWeakReference = new KeyedWeakReference(obj, this.mQueue, uuid, str);
            final long currentTimeMillis = System.currentTimeMillis();
            this.mWatchHandler.post(new Runnable() {
                public void run() {
                    LeakWatcher.this.ensureGone(keyedWeakReference, currentTimeMillis);
                }
            });
        }
    }

    /* access modifiers changed from: package-private */
    public void ensureGone(KeyedWeakReference keyedWeakReference, long j) {
        if (Looper.getMainLooper().getThread() != Thread.currentThread()) {
            removeWeaklyReachableReferences();
            if (!gone(keyedWeakReference)) {
                long currentTimeMillis = System.currentTimeMillis();
                this.mGCTrigger.runGc();
                removeWeaklyReachableReferences();
                boolean z = false;
                if (!gone(keyedWeakReference)) {
                    this.mRetainedKeys.remove(keyedWeakReference.key);
                    if (keyedWeakReference.get() != null) {
                        z = true;
                    }
                }
                if (this.mCollector == null) {
                    this.mCollector = new LeakCollector();
                }
                if (z) {
                    this.mCollector.add(keyedWeakReference, j, currentTimeMillis);
                }
                this.mCollector.onGCRan(currentTimeMillis);
                watchRetainedRef();
            }
        }
    }

    private boolean gone(KeyedWeakReference keyedWeakReference) {
        return !this.mRetainedKeys.contains(keyedWeakReference.key);
    }

    private void removeWeaklyReachableReferences() {
        while (true) {
            KeyedWeakReference keyedWeakReference = (KeyedWeakReference) this.mQueue.poll();
            if (keyedWeakReference != null) {
                this.mRetainedKeys.remove(keyedWeakReference.key);
            } else {
                return;
            }
        }
    }
}
