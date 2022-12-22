package com.didichuxing.mas.sdk.quality.report.safe;

import android.content.Context;
import android.os.Build;
import android.os.Looper;
import android.telephony.PhoneStateListener;
import android.telephony.SignalStrength;
import android.telephony.TelephonyManager;
import com.didi.dimina.container.util.TraceUtil;
import com.didichuxing.mas.sdk.quality.report.MASConfig;
import com.didichuxing.mas.sdk.quality.report.analysis.Tracker;
import com.didichuxing.mas.sdk.quality.report.backend.BatteryChangeReceiver;
import com.didichuxing.mas.sdk.quality.report.collector.NetworkCollector;
import com.didichuxing.mas.sdk.quality.report.record.Event;
import com.didichuxing.mas.sdk.quality.report.threadpool.ScheduledTaskObject;
import com.didiglobal.omegasdkadapter.OmegaSDKAdapter;
import java.util.Timer;
import java.util.TimerTask;

public class SafetyManager {
    private static int TYPE_SIGNAL_2G = 2;
    private static int TYPE_SIGNAL_3G = 3;
    private static int TYPE_SIGNAL_4G = 4;
    private static int TYPE_SIGNAL_NONE = 0;
    private static int lastTrackSignalType = 0;
    private static int lastUploadPercent = -1;
    private static long lastUploadSafetyTime = -1;
    /* access modifiers changed from: private */
    public static PhoneStateListener phoneStateListener = null;
    /* access modifiers changed from: private */
    public static int signalLevel = -1;
    private static Timer timer = new Timer("OMG-Safe");
    private static TimerTask timerTask;

    public static void trackBatteryEvent(boolean z, int i) {
        int[] iArr;
        if (MASConfig.SWITCH_SAFE_BATTERY && i != lastUploadPercent && (iArr = MASConfig.SAFE_BATTERY_THRESHOLD) != null && iArr.length != 0) {
            for (int i2 : iArr) {
                if (i == i2) {
                    lastUploadPercent = i;
                    Event event = new Event("OMGSafeBattery");
                    event.putAttr("bi", Integer.valueOf(i));
                    event.putAttr("bs", Integer.valueOf(z ? 1 : 0));
                    Tracker.trackRealtimeEvent(event);
                    return;
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public static void trackSafetyEvent() {
        if (MASConfig.SWITCH_SAFE_POLLING) {
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - lastUploadSafetyTime >= MASConfig.SWITCH_SAFE_FREQUENCY) {
                lastUploadSafetyTime = currentTimeMillis;
                Event event = new Event("OMGSafeEnv");
                event.putAttr("bi", Integer.valueOf(BatteryChangeReceiver.getBatteryPercent()));
                event.putAttr("sig", Integer.valueOf(signalLevel));
                event.putAttr("carrier", NetworkCollector.getNetworkOperatorType());
                event.putAttr("nt", NetworkCollector.getNetworkType());
                event.putAttr("bs", Integer.valueOf(BatteryChangeReceiver.getBatteryIsCharging() ? 1 : 0));
                OmegaSDKAdapter.trackMasEvent(event);
            }
        }
    }

    public static void trackSafetySignalEvent(int i) {
        String networkType = NetworkCollector.getNetworkType();
        if ("4G".equals(networkType) && i <= 1) {
            int i2 = lastTrackSignalType;
            int i3 = TYPE_SIGNAL_4G;
            if (i2 != i3) {
                lastTrackSignalType = i3;
                scheduleTrackTask(i, "4G");
            }
        } else if ("3G".equals(networkType) && i >= 0 && i <= 2) {
            int i4 = lastTrackSignalType;
            int i5 = TYPE_SIGNAL_3G;
            if (i4 != i5) {
                lastTrackSignalType = i5;
                scheduleTrackTask(i, "3G");
            }
        } else if (!"2G".equals(networkType) || i < 0 || i > 2) {
            TimerTask timerTask2 = timerTask;
            if (timerTask2 != null) {
                timerTask2.cancel();
            }
        } else {
            int i6 = lastTrackSignalType;
            int i7 = TYPE_SIGNAL_2G;
            if (i6 != i7) {
                lastTrackSignalType = i7;
                scheduleTrackTask(i, "2G");
            }
        }
    }

    private static void scheduleTrackTask(final int i, final String str) {
        TimerTask timerTask2 = timerTask;
        if (timerTask2 != null) {
            timerTask2.cancel();
        }
        C158571 r0 = new TimerTask() {
            public void run() {
                Event event = new Event("OMGSafeSignal");
                event.putAttr("carrier", NetworkCollector.getNetworkOperatorType());
                event.putAttr("sig", Integer.valueOf(i));
                event.putAttr("nt", str);
                OmegaSDKAdapter.trackMasEvent(event);
            }
        };
        timerTask = r0;
        timer.schedule(r0, MASConfig.SAFE_SIGNAL_DURATION);
    }

    /* access modifiers changed from: private */
    public static int getSignalLevel(SignalStrength signalStrength) {
        if (signalStrength == null) {
            return TraceUtil.MINA_INDEX_UN_KNOW;
        }
        if (Build.VERSION.SDK_INT >= 23) {
            return signalStrength.getLevel();
        }
        return -2;
    }

    public static void registerNetworkStrengthListener(Context context) {
        final TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
        if (telephonyManager != null) {
            new Thread("SAFE-SIG") {
                public void run() {
                    super.run();
                    Looper.prepare();
                    if (SafetyManager.phoneStateListener == null) {
                        PhoneStateListener unused = SafetyManager.phoneStateListener = new PhoneStateListener() {
                            public void onSignalStrengthsChanged(SignalStrength signalStrength) {
                                super.onSignalStrengthsChanged(signalStrength);
                                if (signalStrength != null) {
                                    int unused = SafetyManager.signalLevel = SafetyManager.getSignalLevel(signalStrength);
                                    SafetyManager.trackSafetySignalEvent(SafetyManager.signalLevel);
                                }
                            }
                        };
                    }
                    telephonyManager.listen(SafetyManager.phoneStateListener, 256);
                    Looper.loop();
                }
            }.start();
        }
    }

    public static void unregisterNetworkStrengthListener(Context context) {
        PhoneStateListener phoneStateListener2;
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
        if (telephonyManager != null && (phoneStateListener2 = phoneStateListener) != null) {
            telephonyManager.listen(phoneStateListener2, 0);
        }
    }

    public static void startSafeTimeTask(long j) {
        if (j >= 1000) {
            ScheduledTaskObject.getInstance().start(new Runnable() {
                public void run() {
                    SafetyManager.trackSafetyEvent();
                }
            }, j, j);
        }
    }
}
