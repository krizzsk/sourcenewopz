package com.didichuxing.nightmode.sdk;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.didichuxing.bigdata.p173dp.locsdk.DIDILocation;
import com.didichuxing.bigdata.p173dp.locsdk.DIDILocationListener;
import com.didichuxing.bigdata.p173dp.locsdk.DIDILocationManager;
import com.didichuxing.bigdata.p173dp.locsdk.DIDILocationUpdateOption;
import com.didichuxing.bigdata.p173dp.locsdk.ErrInfo;
import com.didichuxing.nightmode.sdk.NightModeTimer;
import java.util.Date;
import java.util.Iterator;
import java.util.Locale;
import java.util.concurrent.CopyOnWriteArraySet;

public final class NightModeManager implements NightModeTimer.InnerNightModeChangeCallback {
    private static volatile NightModeManager mInstance;
    private Context mApplicationContext;
    private CopyOnWriteArraySet<INightModeChangeCallback> mCallbacks;
    private NightModeState mCurNightMode;
    /* access modifiers changed from: private */
    public DIDILocation mCurrDIDILocation;
    private NightModeState mGoogleNightModeState;
    private DIDILocationListener mInternalListener = new DIDILocationListener() {
        public void onStatusUpdate(String str, int i, String str2) {
        }

        public void onLocationChanged(DIDILocation dIDILocation) {
            if (dIDILocation != null) {
                DIDILocation unused = NightModeManager.this.mCurrDIDILocation = dIDILocation;
            }
        }

        public void onLocationError(int i, ErrInfo errInfo) {
            if (errInfo != null && errInfo.getErrMessage() != null) {
                NightModeUtils.log(errInfo.getErrMessage());
            }
        }
    };
    private NightModeTimer mTimer;
    private Handler mUIHandler;

    private NightModeManager(Context context) {
        this.mApplicationContext = context.getApplicationContext();
        this.mCallbacks = new CopyOnWriteArraySet<>();
        requestLocUpdates();
    }

    public static NightModeManager getInstance(Context context) {
        if (mInstance == null) {
            synchronized (NightModeManager.class) {
                if (mInstance == null) {
                    mInstance = new NightModeManager(context);
                }
            }
        }
        return mInstance;
    }

    private void requestLocUpdates() {
        DIDILocationManager instance = DIDILocationManager.getInstance(this.mApplicationContext);
        DIDILocationUpdateOption defaultLocationUpdateOption = instance.getDefaultLocationUpdateOption();
        defaultLocationUpdateOption.setModuleKey("night_mode_sdk");
        instance.requestLocationUpdates(this.mInternalListener, defaultLocationUpdateOption);
    }

    public synchronized NightModeState getNightModeState() {
        NightModeState nightModeState = null;
        if (this.mCurrDIDILocation != null) {
            nightModeState = NightModeUtils.getNightModeState(this.mCurrDIDILocation.getLatitude(), this.mCurrDIDILocation.getLongitude(), this.mCurrDIDILocation.getTime());
        } else {
            DIDILocation lastKnownLocation = DIDILocationManager.getInstance(this.mApplicationContext).getLastKnownLocation();
            if (lastKnownLocation != null) {
                NightModeUtils.log(String.format(Locale.getDefault(), "Use lastKnownLocation(%.6f, %.6f) to calculate NightMode", new Object[]{Double.valueOf(lastKnownLocation.getLatitude()), Double.valueOf(lastKnownLocation.getLongitude())}));
                nightModeState = NightModeUtils.getNightModeState(lastKnownLocation.getLatitude(), lastKnownLocation.getLongitude(), lastKnownLocation.getTime());
            }
            NightModeUtils.log("No useful location, return NightModeState.DAY by default");
        }
        if (this.mCurNightMode == null && nightModeState != null) {
            this.mCurNightMode = nightModeState;
        } else if (!(this.mCurNightMode == null || this.mCurNightMode == nightModeState)) {
            this.mCurNightMode = nightModeState;
            NightModeUtils.log("return didi night mode = " + this.mCurNightMode);
            this.mGoogleNightModeState = nightModeState;
            return nightModeState;
        }
        if (this.mGoogleNightModeState != null) {
            NightModeUtils.log("Google's NightMode was set before, return Google's by default");
            return this.mGoogleNightModeState;
        }
        if (this.mCurNightMode == null) {
            this.mCurNightMode = NightModeState.DAY;
        }
        return this.mCurNightMode;
    }

    public synchronized void setGoogleNightModeForcely(NightModeState nightModeState) {
        this.mGoogleNightModeState = nightModeState;
        Iterator<INightModeChangeCallback> it = this.mCallbacks.iterator();
        while (it.hasNext()) {
            it.next().onNightModeStateChange(this.mGoogleNightModeState);
        }
    }

    public synchronized void onOrderStageChanged(boolean z) {
        StringBuilder sb = new StringBuilder();
        sb.append("NightModeManager - onOrderStageChanged() is called, callback");
        sb.append(z ? "Night" : "Day");
        NightModeUtils.log(sb.toString());
        Iterator<INightModeChangeCallback> it = this.mCallbacks.iterator();
        while (it.hasNext()) {
            it.next().onNightModeStateChange(z ? NightModeState.NIGHT : NightModeState.DAY);
        }
    }

    public synchronized void addNightModeChangeListener(INightModeChangeCallback iNightModeChangeCallback, boolean z) {
        NightModeState nightModeState = NightModeState.DAY;
        if (this.mCallbacks.add(iNightModeChangeCallback) && z) {
            nightModeState = getNightModeState();
            iNightModeChangeCallback.onNightModeStateChange(nightModeState);
        }
        if (this.mCallbacks.size() > 0 && !isJapan()) {
            if (this.mTimer == null) {
                this.mTimer = new NightModeTimer(nightModeState, this, this.mApplicationContext);
                if (this.mUIHandler == null) {
                    this.mUIHandler = new Handler(Looper.getMainLooper());
                }
            }
            if (!this.mTimer.isStarted()) {
                this.mTimer.start();
            }
        }
    }

    private boolean isJapan() {
        Context context = this.mApplicationContext;
        if (context != null) {
            return context.getApplicationContext().getPackageName().endsWith(".jp");
        }
        return false;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x001e, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void removeNightModeChangeListener(com.didichuxing.nightmode.sdk.INightModeChangeCallback r2) {
        /*
            r1 = this;
            monitor-enter(r1)
            java.util.concurrent.CopyOnWriteArraySet<com.didichuxing.nightmode.sdk.INightModeChangeCallback> r0 = r1.mCallbacks     // Catch:{ all -> 0x001f }
            if (r0 != 0) goto L_0x0007
            monitor-exit(r1)
            return
        L_0x0007:
            java.util.concurrent.CopyOnWriteArraySet<com.didichuxing.nightmode.sdk.INightModeChangeCallback> r0 = r1.mCallbacks     // Catch:{ all -> 0x001f }
            r0.remove(r2)     // Catch:{ all -> 0x001f }
            java.util.concurrent.CopyOnWriteArraySet<com.didichuxing.nightmode.sdk.INightModeChangeCallback> r2 = r1.mCallbacks     // Catch:{ all -> 0x001f }
            int r2 = r2.size()     // Catch:{ all -> 0x001f }
            if (r2 != 0) goto L_0x001d
            com.didichuxing.nightmode.sdk.NightModeTimer r2 = r1.mTimer     // Catch:{ all -> 0x001f }
            if (r2 == 0) goto L_0x001d
            com.didichuxing.nightmode.sdk.NightModeTimer r2 = r1.mTimer     // Catch:{ all -> 0x001f }
            r2.stop()     // Catch:{ all -> 0x001f }
        L_0x001d:
            monitor-exit(r1)
            return
        L_0x001f:
            r2 = move-exception
            monitor-exit(r1)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didichuxing.nightmode.sdk.NightModeManager.removeNightModeChangeListener(com.didichuxing.nightmode.sdk.INightModeChangeCallback):void");
    }

    public synchronized void destroy() {
        if (this.mTimer != null) {
            this.mTimer.destroy();
            this.mTimer = null;
        }
        if (this.mUIHandler != null) {
            this.mUIHandler.removeCallbacks((Runnable) null);
            this.mUIHandler = null;
        }
        this.mCallbacks.clear();
        DIDILocationManager.getInstance(this.mApplicationContext).removeLocationUpdates(this.mInternalListener);
        this.mCurrDIDILocation = null;
        this.mGoogleNightModeState = null;
        mInstance = null;
    }

    public synchronized void onNightModeStateChange(final NightModeState nightModeState) {
        Iterator<INightModeChangeCallback> it = this.mCallbacks.iterator();
        while (it.hasNext()) {
            final INightModeChangeCallback next = it.next();
            if (this.mUIHandler != null) {
                this.mUIHandler.post(new Runnable() {
                    public void run() {
                        next.onNightModeStateChange(nightModeState);
                    }
                });
            }
        }
    }

    /* access modifiers changed from: package-private */
    public synchronized double getInternalSunriseSunsetTime(NightModeState nightModeState) {
        if (this.mCurrDIDILocation != null) {
            Date date = new Date(this.mCurrDIDILocation.getTime());
            if (NightModeState.DAY == nightModeState) {
                return SunriseSunsetCalculator.getSunriseDate(this.mCurrDIDILocation.getLatitude(), this.mCurrDIDILocation.getLongitude(), date.getYear(), date.getMonth(), date.getDay());
            } else if (NightModeState.NIGHT == nightModeState) {
                return SunriseSunsetCalculator.getSunsetDate(this.mCurrDIDILocation.getLatitude(), this.mCurrDIDILocation.getLongitude(), date.getYear(), date.getMonth(), date.getDay());
            }
        }
        DIDILocation lastKnownLocation = DIDILocationManager.getInstance(this.mApplicationContext).getLastKnownLocation();
        if (lastKnownLocation != null) {
            Date date2 = new Date(lastKnownLocation.getTime());
            if (NightModeState.DAY == nightModeState) {
                return SunriseSunsetCalculator.getSunriseDate(lastKnownLocation.getLatitude(), lastKnownLocation.getLongitude(), date2.getYear(), date2.getMonth(), date2.getDay());
            } else if (NightModeState.NIGHT == nightModeState) {
                return SunriseSunsetCalculator.getSunsetDate(lastKnownLocation.getLatitude(), lastKnownLocation.getLongitude(), date2.getYear(), date2.getMonth(), date2.getDay());
            }
        }
        return 0.0d;
    }
}
