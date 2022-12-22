package com.didichuxing.nightmode.sdk;

import android.content.Context;
import com.didi.map.setting.common.IMapSettingPreferences;
import com.didi.map.setting.common.MapSettingFactory;
import java.util.Timer;
import java.util.TimerTask;

class NightModeTimer {
    private boolean bIsStarted;
    private Context mContext;
    /* access modifiers changed from: private */
    public NightModeState mCurrState;
    /* access modifiers changed from: private */
    public InnerNightModeChangeCallback mInnerCallback;
    private long mLoopTimeInSeconds = 60;
    private Timer mTimer = new Timer();
    private TimerTask mTimerTask;
    /* access modifiers changed from: private */
    public IMapSettingPreferences mapSettingPreferences;

    interface InnerNightModeChangeCallback extends INightModeChangeCallback {
        NightModeState getNightModeState();
    }

    public NightModeTimer(NightModeState nightModeState, InnerNightModeChangeCallback innerNightModeChangeCallback, Context context) {
        this.mCurrState = nightModeState;
        this.mInnerCallback = innerNightModeChangeCallback;
        this.mContext = context;
        this.mapSettingPreferences = MapSettingFactory.createMapPreferences(context);
    }

    /* access modifiers changed from: package-private */
    public boolean isStarted() {
        return this.bIsStarted;
    }

    /* access modifiers changed from: package-private */
    public void start() {
        if (!this.bIsStarted) {
            if (this.mTimer == null) {
                this.mTimer = new Timer();
            }
            this.bIsStarted = true;
            TimerTask timerTask = this.mTimerTask;
            if (timerTask != null) {
                timerTask.cancel();
            }
            C159381 r2 = new TimerTask() {
                public void run() {
                    NightModeState nightModeState;
                    if ((NightModeTimer.this.mapSettingPreferences == null || NightModeTimer.this.mapSettingPreferences.getNavDayNightMode() == 0) && NightModeTimer.this.mInnerCallback != null && (nightModeState = NightModeTimer.this.mInnerCallback.getNightModeState()) != NightModeTimer.this.mCurrState) {
                        NightModeState unused = NightModeTimer.this.mCurrState = nightModeState;
                        NightModeTimer.this.mInnerCallback.onNightModeStateChange(nightModeState);
                    }
                }
            };
            this.mTimerTask = r2;
            Timer timer = this.mTimer;
            long j = this.mLoopTimeInSeconds;
            timer.schedule(r2, j * 1000, 1000 * j);
        }
    }

    /* access modifiers changed from: package-private */
    public void stop() {
        TimerTask timerTask = this.mTimerTask;
        if (timerTask != null) {
            timerTask.cancel();
        }
        this.bIsStarted = false;
    }

    /* access modifiers changed from: package-private */
    public void destroy() {
        TimerTask timerTask = this.mTimerTask;
        if (timerTask != null) {
            timerTask.cancel();
        }
        Timer timer = this.mTimer;
        if (timer != null) {
            timer.cancel();
            this.mTimer = null;
        }
        this.bIsStarted = false;
        this.mInnerCallback = null;
    }
}
