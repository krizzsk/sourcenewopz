package com.didi.component.common.util;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.SystemClock;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.OnLifecycleEvent;
import com.didi.component.lifecycle.LifecycleListener;
import java.util.HashMap;
import java.util.Map;

public class HandlerUtils {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public static String f11770a = "HANDLER-Main";
    /* access modifiers changed from: private */

    /* renamed from: b */
    public static Map<String, HandlerThreadBuild> f11771b = new HashMap();

    public static HandlerThreadBuild getMainHandler() {
        HandlerThreadBuild handlerThreadBuild = f11771b.get(f11770a);
        if (handlerThreadBuild != null) {
            return handlerThreadBuild;
        }
        HandlerThreadBuild handlerThreadBuild2 = new HandlerThreadBuild();
        f11771b.put(f11770a, handlerThreadBuild2);
        return handlerThreadBuild2;
    }

    public static HandlerThreadBuild getHandlerThread(String str) {
        HandlerThreadBuild handlerThreadBuild = f11771b.get(str);
        if (handlerThreadBuild != null) {
            return handlerThreadBuild;
        }
        HandlerThreadBuild handlerThreadBuild2 = new HandlerThreadBuild(str);
        f11771b.put(str, handlerThreadBuild2);
        return handlerThreadBuild2;
    }

    public static class HandlerThreadBuild implements LifecycleObserver {
        /* access modifiers changed from: private */
        public Runnable mFirstAction;
        /* access modifiers changed from: private */
        public Handler mHandler;
        private HandlerTask mHandlerTask;
        private HandlerThread mHandlerThread;
        /* access modifiers changed from: private */
        public int mInterval;
        /* access modifiers changed from: private */
        public boolean mIsLoopEnable;
        /* access modifiers changed from: private */
        public Runnable mLastAction;
        /* access modifiers changed from: private */
        public long mLoopDuration;
        private String mName;
        /* access modifiers changed from: private */
        public boolean mStopped;

        HandlerThreadBuild() {
            this.mLoopDuration = 30000;
            this.mName = HandlerUtils.f11770a;
            this.mHandler = new Handler(Looper.getMainLooper());
        }

        HandlerThreadBuild(String str) {
            this.mLoopDuration = 30000;
            this.mName = str;
            HandlerThread handlerThread = new HandlerThread(str);
            this.mHandlerThread = handlerThread;
            handlerThread.start();
            this.mHandler = new Handler(this.mHandlerThread.getLooper());
        }

        public HandlerThreadBuild lifecycle(LifecycleOwner lifecycleOwner) {
            if (lifecycleOwner != null) {
                lifecycleOwner.getLifecycle().addObserver(this);
            }
            return this;
        }

        public HandlerThreadBuild lifecycle(com.didi.component.lifecycle.LifecycleOwner lifecycleOwner) {
            if (lifecycleOwner != null) {
                lifecycleOwner.getLifecycle().addLifecycleListener(new BaseLifecycleListener() {
                    public void onRemove() {
                        HandlerThreadBuild.this.stop();
                    }
                });
            }
            return this;
        }

        public HandlerThreadBuild first(Runnable runnable) {
            this.mFirstAction = runnable;
            return this;
        }

        public HandlerThreadBuild last(Runnable runnable) {
            this.mLastAction = runnable;
            return this;
        }

        public void loop(Runnable runnable, int i) {
            loop(runnable, i, 0);
        }

        public void loop(Runnable runnable, int i, int i2) {
            loop(runnable, i, i2, 0);
        }

        public void loop(Runnable runnable, int i, int i2, int i3) {
            this.mInterval = i;
            this.mIsLoopEnable = true;
            if (i2 >= 1000 && i2 <= 600000) {
                this.mLoopDuration = (long) i2;
            }
            postDelay(runnable, i3);
        }

        public void post(Runnable runnable) {
            postDelay(runnable, 0);
        }

        public void postDelay(Runnable runnable, int i) {
            Handler handler;
            HandlerTask handlerTask = this.mHandlerTask;
            if (!(handlerTask == null || (handler = this.mHandler) == null)) {
                handler.removeCallbacks(handlerTask);
            }
            HandlerTask handlerTask2 = new HandlerTask(runnable);
            this.mHandlerTask = handlerTask2;
            this.mHandler.postDelayed(handlerTask2, (long) i);
        }

        public int getLoopIndex() {
            return this.mHandlerTask.mLoopIndex;
        }

        public long getLoopCount() {
            int i = this.mInterval;
            if (i > 0) {
                return this.mLoopDuration / ((long) i);
            }
            return -1;
        }

        public void clear() {
            this.mStopped = false;
            this.mIsLoopEnable = false;
            this.mLastAction = null;
            this.mLoopDuration = 30000;
        }

        @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
        public void stop() {
            Handler handler;
            this.mStopped = true;
            this.mIsLoopEnable = false;
            HandlerTask handlerTask = this.mHandlerTask;
            if (!(handlerTask == null || (handler = this.mHandler) == null)) {
                handler.removeCallbacks(handlerTask);
                this.mHandler = null;
            }
            HandlerThread handlerThread = this.mHandlerThread;
            if (handlerThread != null) {
                handlerThread.quit();
                this.mHandlerThread = null;
            }
            HandlerUtils.f11771b.remove(this.mName);
        }

        private class HandlerTask implements Runnable {
            /* access modifiers changed from: private */
            public int mLoopIndex;
            private long mStartTimestamp;
            private Runnable mTask;

            HandlerTask(Runnable runnable) {
                this.mTask = runnable;
            }

            public void run() {
                if (this.mStartTimestamp == 0) {
                    performFirstAction();
                    this.mStartTimestamp = SystemClock.elapsedRealtime();
                }
                if (HandlerThreadBuild.this.mStopped) {
                    performLastAction();
                    return;
                }
                Runnable runnable = this.mTask;
                if (runnable != null) {
                    runnable.run();
                }
                if (HandlerThreadBuild.this.mHandler == null) {
                    return;
                }
                if (!HandlerThreadBuild.this.mIsLoopEnable) {
                    performLastAction();
                } else if (SystemClock.elapsedRealtime() - this.mStartTimestamp >= HandlerThreadBuild.this.mLoopDuration) {
                    performLastAction();
                    HandlerThreadBuild.this.stop();
                } else {
                    this.mLoopIndex++;
                    HandlerThreadBuild.this.mHandler.postDelayed(this, (long) HandlerThreadBuild.this.mInterval);
                }
            }

            private void performFirstAction() {
                if (HandlerThreadBuild.this.mFirstAction != null) {
                    HandlerThreadBuild.this.mHandler.post(HandlerThreadBuild.this.mFirstAction);
                    Runnable unused = HandlerThreadBuild.this.mFirstAction = null;
                }
            }

            private void performLastAction() {
                if (HandlerThreadBuild.this.mLastAction != null) {
                    HandlerThreadBuild.this.mHandler.post(HandlerThreadBuild.this.mLastAction);
                    Runnable unused = HandlerThreadBuild.this.mLastAction = null;
                }
            }
        }

        private class BaseLifecycleListener implements LifecycleListener {
            public void onAdd() {
            }

            public void onBackHome() {
            }

            public void onLeaveHome() {
            }

            public void onPageHide() {
            }

            public void onPagePause() {
            }

            public void onPageResume() {
            }

            public void onPageShow() {
            }

            public void onPageStart() {
            }

            public void onPageStop() {
            }

            public void onRemove() {
            }

            private BaseLifecycleListener() {
            }
        }
    }
}
