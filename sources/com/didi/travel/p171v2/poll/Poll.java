package com.didi.travel.p171v2.poll;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleRegistry;
import com.didi.travel.p171v2.IKey;
import com.didi.travel.p171v2.session.Scene;
import com.didi.travel.p171v2.session.SceneContainer;
import com.didi.travel.p171v2.session.time.DurationTimestamp;
import com.didi.travel.p171v2.util.LogUtils;
import java.util.concurrent.atomic.AtomicInteger;

/* renamed from: com.didi.travel.v2.poll.Poll */
public abstract class Poll implements LifecycleOwner, IKey {
    public static final long S_DEFAULT_POLL_INTERVAL = 5000;
    public static final long S_POLL_TIME_CHANGE_INTERVAL = 1000;
    /* access modifiers changed from: private */

    /* renamed from: a */
    public static final String f44317a = Poll.class.getSimpleName();
    /* access modifiers changed from: protected */
    public final Handler mHandler = new Handler(Looper.getMainLooper());
    protected volatile long mLastPollTime = -1;
    protected final LifecycleRegistry mLifecycleRegistry = new LifecycleRegistry(this);
    protected IPollCallback mPollCallback;
    protected final AtomicInteger mPollCount = new AtomicInteger(0);
    protected DurationTimestamp mPollDuration;
    protected volatile long mPollInterval = 5000;
    protected final String mPollKey;
    protected final Runnable mPollRunnable = new Runnable() {
        public void run() {
            int isContinue = Poll.this.mPollCallback != null ? Poll.this.mPollCallback.isContinue() : 1;
            if (isContinue != 1) {
                Poll.this.stopPoll(SceneContainer.getInstance().getScene(isContinue));
            } else if (Poll.this.mPollCallback != null) {
                Poll.this.mPollCallback.onTick(Poll.this.mPollCount.addAndGet(1));
                Poll poll = Poll.this;
                poll.mLastPollTime = poll.getTimeStamp();
                Poll.this.mHandler.postDelayed(this, Poll.this.mPollInterval);
            } else {
                throw new NullPointerException(Poll.f44317a + ".run : mPollCallback is null");
            }
        }
    };
    protected final Runnable mPollTimeChangeRunnable = new Runnable() {
        public void run() {
            if (!(Poll.this.mPollCallback == null || Poll.this.mPollDuration == null)) {
                Poll.this.mPollCallback.onPollTimeChanged(Poll.this.mPollDuration.getCurrentDuration());
            }
            Poll.this.mHandler.postDelayed(this, 1000);
        }
    };
    protected final Runnable mPollTimeoutRunnable = new Runnable() {
        public void run() {
            if (Poll.this.mPollCallback != null) {
                if (Poll.this.mPollDuration != null) {
                    Poll.this.mPollCallback.onPollTimeChanged(Poll.this.mPollDuration.getCurrentDuration());
                }
                Poll.this.mPollCallback.onPollTimeout();
                Poll poll = Poll.this;
                poll.stopPoll(poll.m31482a(102));
            }
        }
    };

    /* access modifiers changed from: protected */
    public int isPollInnerReady() {
        return 1;
    }

    public Poll(Scene scene, String str) {
        if (!TextUtils.isEmpty(str)) {
            this.mPollKey = str;
            this.mLifecycleRegistry.markState(Lifecycle.State.CREATED);
            return;
        }
        throw new IllegalArgumentException(f44317a + ".new:pollKey is empty");
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public Scene m31482a(int i) {
        return SceneContainer.getInstance().getScene(i);
    }

    public long getPollInterval() {
        return this.mPollInterval;
    }

    public void setPollInterval(Scene scene, long j) {
        if (this.mPollInterval != j && j > 0) {
            this.mPollInterval = j;
            if (getLifecycle().getCurrentState() == Lifecycle.State.RESUMED) {
                this.mHandler.removeCallbacks(this.mPollRunnable);
                if (this.mLastPollTime <= 0) {
                    this.mHandler.post(this.mPollRunnable);
                    return;
                }
                long timeStamp = (this.mLastPollTime + j) - getTimeStamp();
                if (timeStamp < 0) {
                    this.mHandler.post(this.mPollRunnable);
                } else {
                    this.mHandler.postDelayed(this.mPollRunnable, timeStamp);
                }
            }
        }
    }

    public void setPollCallback(IPollCallback iPollCallback) {
        this.mPollCallback = iPollCallback;
    }

    public boolean isPollRunning() {
        return this.mLifecycleRegistry.getCurrentState().isAtLeast(Lifecycle.State.STARTED);
    }

    public boolean isPollTicking() {
        return this.mLifecycleRegistry.getCurrentState().isAtLeast(Lifecycle.State.RESUMED);
    }

    /* access modifiers changed from: protected */
    public void tryResumePoll(Scene scene) {
        String str = f44317a;
        LogUtils.m31491d(str, "tryResumePoll : key = " + getKey());
        if (getLifecycle().getCurrentState() != Lifecycle.State.STARTED) {
            String str2 = f44317a;
            LogUtils.m31495w(str2, "tryResumePoll : invalid state = " + getLifecycle().getCurrentState());
            return;
        }
        int isPollInnerReady = isPollInnerReady();
        if (isPollInnerReady == 1) {
            this.mHandler.removeCallbacks(this.mPollRunnable);
            this.mLastPollTime = -1;
            this.mHandler.post(this.mPollRunnable);
            this.mLifecycleRegistry.markState(Lifecycle.State.RESUMED);
            return;
        }
        String str3 = f44317a;
        LogUtils.m31495w(str3, "tryResumePoll : poll is not ready, isInnerPollReady = " + m31482a(isPollInnerReady));
    }

    /* access modifiers changed from: protected */
    public void tryPausePoll(Scene scene) {
        String str = f44317a;
        LogUtils.m31491d(str, "tryPausePoll : key = " + getKey());
        if (getLifecycle().getCurrentState() != Lifecycle.State.RESUMED) {
            String str2 = f44317a;
            LogUtils.m31495w(str2, "tryPausePoll : invalid state = " + getLifecycle().getCurrentState());
            return;
        }
        this.mHandler.removeCallbacks(this.mPollRunnable);
        this.mLastPollTime = -1;
        this.mLifecycleRegistry.markState(Lifecycle.State.STARTED);
    }

    public void startPoll(Scene scene, long j) {
        String str = f44317a;
        LogUtils.m31491d(str, "startPoll : key = " + getKey());
        this.mHandler.removeCallbacks(this.mPollRunnable);
        this.mLastPollTime = -1;
        if (isPollInnerReady() == 1) {
            this.mHandler.post(this.mPollRunnable);
            this.mLifecycleRegistry.markState(Lifecycle.State.RESUMED);
        } else {
            this.mLifecycleRegistry.markState(Lifecycle.State.STARTED);
        }
        this.mHandler.removeCallbacks(this.mPollTimeChangeRunnable);
        this.mHandler.removeCallbacks(this.mPollTimeoutRunnable);
        if (j > 0) {
            DurationTimestamp durationTimestamp = new DurationTimestamp(j);
            this.mPollDuration = durationTimestamp;
            durationTimestamp.startup();
        }
        DurationTimestamp durationTimestamp2 = this.mPollDuration;
        if (durationTimestamp2 == null || durationTimestamp2.getCurrentRestDuration() > 0) {
            this.mHandler.post(this.mPollTimeChangeRunnable);
        }
        DurationTimestamp durationTimestamp3 = this.mPollDuration;
        if (durationTimestamp3 != null && durationTimestamp3.getDuration() > 0) {
            this.mHandler.postDelayed(this.mPollTimeoutRunnable, this.mPollDuration.getDuration());
        }
    }

    public void stopPoll(Scene scene) {
        String str = f44317a;
        LogUtils.m31491d(str, "stopPoll : key = " + getKey());
        this.mLastPollTime = -1;
        if (getLifecycle().getCurrentState() != Lifecycle.State.DESTROYED) {
            this.mLifecycleRegistry.markState(Lifecycle.State.CREATED);
        }
        this.mHandler.removeCallbacks(this.mPollRunnable);
        this.mHandler.removeCallbacks(this.mPollTimeChangeRunnable);
        this.mHandler.removeCallbacks(this.mPollTimeoutRunnable);
    }

    public void destroyPoll(Scene scene) {
        String str = f44317a;
        LogUtils.m31492e(str, "destroyPoll : key = " + getKey());
        this.mLifecycleRegistry.markState(Lifecycle.State.DESTROYED);
    }

    /* renamed from: com.didi.travel.v2.poll.Poll$4 */
    static /* synthetic */ class C144124 {
        static final /* synthetic */ int[] $SwitchMap$androidx$lifecycle$Lifecycle$State;

        /* JADX WARNING: Can't wrap try/catch for region: R(12:0|1|2|3|4|5|6|7|8|9|10|12) */
        /* JADX WARNING: Code restructure failed: missing block: B:13:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                androidx.lifecycle.Lifecycle$State[] r0 = androidx.lifecycle.Lifecycle.State.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$androidx$lifecycle$Lifecycle$State = r0
                androidx.lifecycle.Lifecycle$State r1 = androidx.lifecycle.Lifecycle.State.RESUMED     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$androidx$lifecycle$Lifecycle$State     // Catch:{ NoSuchFieldError -> 0x001d }
                androidx.lifecycle.Lifecycle$State r1 = androidx.lifecycle.Lifecycle.State.STARTED     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$androidx$lifecycle$Lifecycle$State     // Catch:{ NoSuchFieldError -> 0x0028 }
                androidx.lifecycle.Lifecycle$State r1 = androidx.lifecycle.Lifecycle.State.CREATED     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = $SwitchMap$androidx$lifecycle$Lifecycle$State     // Catch:{ NoSuchFieldError -> 0x0033 }
                androidx.lifecycle.Lifecycle$State r1 = androidx.lifecycle.Lifecycle.State.INITIALIZED     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = $SwitchMap$androidx$lifecycle$Lifecycle$State     // Catch:{ NoSuchFieldError -> 0x003e }
                androidx.lifecycle.Lifecycle$State r1 = androidx.lifecycle.Lifecycle.State.DESTROYED     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.didi.travel.p171v2.poll.Poll.C144124.<clinit>():void");
        }
    }

    /* access modifiers changed from: protected */
    public void onPollInnerReady(Scene scene) {
        if (C144124.$SwitchMap$androidx$lifecycle$Lifecycle$State[getLifecycle().getCurrentState().ordinal()] == 2) {
            tryResumePoll(scene);
        }
    }

    /* access modifiers changed from: protected */
    public long getTimeStamp() {
        return SystemClock.elapsedRealtime();
    }

    public String getKey() {
        return this.mPollKey;
    }

    public LifecycleRegistry getLifecycle() {
        return this.mLifecycleRegistry;
    }
}
