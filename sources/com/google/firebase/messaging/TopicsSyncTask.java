package com.google.firebase.messaging;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.PowerManager;
import android.util.Log;
import com.didi.dimina.container.bridge.network.NetWorkStateReceiver;
import com.didi.sdk.apm.SystemUtils;
import java.io.IOException;

/* compiled from: com.google.firebase:firebase-messaging@@22.0.0 */
class TopicsSyncTask implements Runnable {
    private static final Object TOPIC_SYNC_TASK_LOCK = new Object();
    private static Boolean hasAccessNetworkStatePermission = null;
    private static Boolean hasWakeLockPermission = null;
    /* access modifiers changed from: private */
    public final Context context;
    private final Metadata metadata;
    private final long nextDelaySeconds;
    private final PowerManager.WakeLock syncWakeLock;
    /* access modifiers changed from: private */
    public final TopicsSubscriber topicsSubscriber;

    /* compiled from: com.google.firebase:firebase-messaging@@22.0.0 */
    class ConnectivityChangeReceiver extends BroadcastReceiver {
        private TopicsSyncTask task;

        public ConnectivityChangeReceiver(TopicsSyncTask topicsSyncTask) {
            this.task = topicsSyncTask;
        }

        public synchronized void onReceive(Context context, Intent intent) {
            TopicsSyncTask topicsSyncTask = this.task;
            if (topicsSyncTask != null) {
                if (topicsSyncTask.isDeviceConnected()) {
                    if (TopicsSyncTask.isLoggable()) {
                        SystemUtils.log(3, Constants.TAG, "Connectivity changed. Starting background sync.", (Throwable) null, "com.google.firebase.messaging.TopicsSyncTask$ConnectivityChangeReceiver", 3);
                    }
                    this.task.topicsSubscriber.scheduleSyncTaskWithDelaySeconds(this.task, 0);
                    try {
                        context.unregisterReceiver(this);
                    } catch (Exception e) {
                        Log.d("Context", "unregisterReceiver", e);
                    }
                    this.task = null;
                }
            }
        }

        public void registerReceiver() {
            if (TopicsSyncTask.isLoggable()) {
                SystemUtils.log(3, Constants.TAG, "Connectivity change received registered", (Throwable) null, "com.google.firebase.messaging.TopicsSyncTask$ConnectivityChangeReceiver", 2);
            }
            try {
                TopicsSyncTask.this.context.registerReceiver(this, new IntentFilter(NetWorkStateReceiver.ANDROID_NET_CHANGE_ACTION));
            } catch (Exception e) {
                Log.d("Context", "registerReceiver", e);
            }
        }
    }

    TopicsSyncTask(TopicsSubscriber topicsSubscriber2, Context context2, Metadata metadata2, long j) {
        this.topicsSubscriber = topicsSubscriber2;
        this.context = context2;
        this.nextDelaySeconds = j;
        this.metadata = metadata2;
        this.syncWakeLock = ((PowerManager) context2.getSystemService("power")).newWakeLock(1, Constants.FCM_WAKE_LOCK);
    }

    private static String createPermissionMissingLog(String str) {
        StringBuilder sb = new StringBuilder(str.length() + 142);
        sb.append("Missing Permission: ");
        sb.append(str);
        sb.append(". This permission should normally be included by the manifest merger, but may needed to be manually added to your manifest");
        return sb.toString();
    }

    private static boolean hasAccessNetworkStatePermission(Context context2) {
        boolean z;
        boolean booleanValue;
        synchronized (TOPIC_SYNC_TASK_LOCK) {
            if (hasAccessNetworkStatePermission == null) {
                z = hasPermission(context2, "android.permission.ACCESS_NETWORK_STATE", hasAccessNetworkStatePermission);
            } else {
                z = hasAccessNetworkStatePermission.booleanValue();
            }
            Boolean valueOf = Boolean.valueOf(z);
            hasAccessNetworkStatePermission = valueOf;
            booleanValue = valueOf.booleanValue();
        }
        return booleanValue;
    }

    private static boolean hasPermission(Context context2, String str, Boolean bool) {
        if (bool != null) {
            return bool.booleanValue();
        }
        boolean z = context2.checkCallingOrSelfPermission(str) == 0;
        if (z || !Log.isLoggable(Constants.TAG, 3)) {
            return z;
        }
        SystemUtils.log(3, Constants.TAG, createPermissionMissingLog(str), (Throwable) null, "com.google.firebase.messaging.TopicsSyncTask", 4);
        return false;
    }

    private static boolean hasWakeLockPermission(Context context2) {
        boolean z;
        boolean booleanValue;
        synchronized (TOPIC_SYNC_TASK_LOCK) {
            if (hasWakeLockPermission == null) {
                z = hasPermission(context2, "android.permission.WAKE_LOCK", hasWakeLockPermission);
            } else {
                z = hasWakeLockPermission.booleanValue();
            }
            Boolean valueOf = Boolean.valueOf(z);
            hasWakeLockPermission = valueOf;
            booleanValue = valueOf.booleanValue();
        }
        return booleanValue;
    }

    /* access modifiers changed from: private */
    public synchronized boolean isDeviceConnected() {
        NetworkInfo activeNetworkInfo;
        ConnectivityManager connectivityManager = (ConnectivityManager) this.context.getSystemService("connectivity");
        activeNetworkInfo = connectivityManager != null ? SystemUtils.getActiveNetworkInfo(connectivityManager) : null;
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    /* access modifiers changed from: private */
    public static boolean isLoggable() {
        if (Log.isLoggable(Constants.TAG, 3) || (Build.VERSION.SDK_INT == 23 && Log.isLoggable(Constants.TAG, 3))) {
            return true;
        }
        return false;
    }

    public void run() {
        String str;
        if (hasWakeLockPermission(this.context)) {
            this.syncWakeLock.acquire(Constants.WAKE_LOCK_ACQUIRE_TIMEOUT_MILLIS);
        }
        try {
            this.topicsSubscriber.setSyncScheduledOrRunning(true);
            if (!this.metadata.isGmscorePresent()) {
                this.topicsSubscriber.setSyncScheduledOrRunning(false);
                if (hasWakeLockPermission(this.context)) {
                    try {
                        this.syncWakeLock.release();
                    } catch (RuntimeException unused) {
                        SystemUtils.log(4, Constants.TAG, "TopicsSyncTask's wakelock was already released due to timeout.", (Throwable) null, "com.google.firebase.messaging.TopicsSyncTask", 8);
                    }
                }
            } else if (!hasAccessNetworkStatePermission(this.context) || isDeviceConnected()) {
                if (this.topicsSubscriber.syncTopics()) {
                    this.topicsSubscriber.setSyncScheduledOrRunning(false);
                } else {
                    this.topicsSubscriber.syncWithDelaySecondsInternal(this.nextDelaySeconds);
                }
                if (hasWakeLockPermission(this.context)) {
                    this.syncWakeLock.release();
                }
            } else {
                new ConnectivityChangeReceiver(this).registerReceiver();
                if (hasWakeLockPermission(this.context)) {
                    this.syncWakeLock.release();
                }
            }
        } catch (IOException e) {
            String valueOf = String.valueOf(e.getMessage());
            if (valueOf.length() != 0) {
                str = "Failed to sync topics. Won't retry sync. ".concat(valueOf);
            } else {
                str = new String("Failed to sync topics. Won't retry sync. ");
            }
            SystemUtils.log(6, Constants.TAG, str, (Throwable) null, "com.google.firebase.messaging.TopicsSyncTask", 16);
            this.topicsSubscriber.setSyncScheduledOrRunning(false);
            if (hasWakeLockPermission(this.context)) {
                this.syncWakeLock.release();
            }
        } catch (Throwable th) {
            if (hasWakeLockPermission(this.context)) {
                try {
                    this.syncWakeLock.release();
                } catch (RuntimeException unused2) {
                    SystemUtils.log(4, Constants.TAG, "TopicsSyncTask's wakelock was already released due to timeout.", (Throwable) null, "com.google.firebase.messaging.TopicsSyncTask", 8);
                }
            }
            throw th;
        }
    }
}
