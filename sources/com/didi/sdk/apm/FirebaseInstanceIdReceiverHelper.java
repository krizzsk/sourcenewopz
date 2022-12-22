package com.didi.sdk.apm;

import android.content.BroadcastReceiver;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import com.didi.sdk.apm.utils.PendingResultHelper;
import com.didi.sdk.apm.utils.RemoteConfiguration;

public class FirebaseInstanceIdReceiverHelper {

    /* renamed from: a */
    static FinishHandler f34938a = null;

    /* renamed from: b */
    private static final String f34939b = "FirebaseInstanceIdReceiverHelper";

    /* renamed from: c */
    private static final long f34940c = 7000;

    public static BroadcastReceiver.PendingResult goAsync(BroadcastReceiver broadcastReceiver) {
        Log.d(f34939b, broadcastReceiver.toString());
        BroadcastReceiver.PendingResult goAsync = broadcastReceiver.goAsync();
        if (TextUtils.equals("FirebaseInstanceIdReceiver", broadcastReceiver.getClass().getSimpleName())) {
            m24701a(goAsync);
        }
        return goAsync;
    }

    /* renamed from: a */
    private static synchronized void m24701a(BroadcastReceiver.PendingResult pendingResult) {
        synchronized (FirebaseInstanceIdReceiverHelper.class) {
            if (f34938a == null) {
                HandlerThread handlerThread = new HandlerThread("Firebase#MonitorBroadcastActive", -2);
                handlerThread.start();
                f34938a = new FinishHandler(handlerThread.getLooper());
            }
            Log.d(f34939b, "FirebaseInstanceIdReceiver monitor start time is :" + SystemClock.elapsedRealtime());
            if (f34938a != null) {
                Message obtain = Message.obtain();
                obtain.obj = pendingResult;
                f34938a.sendMessageDelayed(obtain, ((Long) RemoteConfiguration.getConfig(SystemUtils.TOGGLE_APM_FIREBASEINSTANCEIDRECEIVER, "threshold_time", Long.valueOf(f34940c))).longValue());
            }
        }
    }

    static class FinishHandler extends Handler {
        public FinishHandler(Looper looper) {
            super(looper);
        }

        public void handleMessage(Message message) {
            super.handleMessage(message);
            if (message.obj instanceof BroadcastReceiver.PendingResult) {
                PendingResultHelper.finish((BroadcastReceiver.PendingResult) message.obj);
            }
        }
    }
}
