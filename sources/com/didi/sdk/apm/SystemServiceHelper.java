package com.didi.sdk.apm;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.AsyncTask;
import android.util.Log;
import com.didi.dimina.container.bridge.network.NetWorkStateReceiver;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

class SystemServiceHelper {

    /* renamed from: a */
    public static final String f34942a = "SystemServiceHelper";

    /* renamed from: b */
    private static final Map<String, Map<String, AtomicReference>> f34943b = new ConcurrentHashMap();

    SystemServiceHelper() {
    }

    /* renamed from: a */
    static void m24705a(Context context) {
        try {
            m24706b(context);
        } catch (Throwable th) {
            Log.e(f34942a, "init err", th);
        }
    }

    /* renamed from: b */
    private static void m24706b(Context context) {
        ConnectivityManager.onInit(context);
    }

    /* renamed from: a */
    public static Object m24704a(Context context, String str) {
        String packageName = context.getPackageName();
        Context applicationContext = context.getApplicationContext();
        if (applicationContext == null) {
            applicationContext = context;
        }
        if (!"window".equals(str)) {
            context = applicationContext;
        }
        Map map = f34943b.get(packageName);
        if (map == null) {
            synchronized (f34943b) {
                if (map == null) {
                    map = new ConcurrentHashMap();
                    f34943b.put(packageName, map);
                }
            }
        }
        AtomicReference atomicReference = (AtomicReference) map.get(str);
        if (atomicReference != null) {
            return atomicReference.get();
        }
        Object systemService = context.getSystemService(str);
        map.put(str, new AtomicReference(systemService));
        return systemService;
    }

    static class ConnectivityManager extends BroadcastReceiver {
        static NetworkInfo sNetworkInfo;
        static android.net.ConnectivityManager sRealManager;
        static AtomicBoolean sUpdateByReceiver = new AtomicBoolean(true);

        ConnectivityManager() {
        }

        static void onInit(Context context) {
            try {
                Context applicationContext = context.getApplicationContext();
                if (applicationContext != null) {
                    context = applicationContext;
                }
                sRealManager = (android.net.ConnectivityManager) SystemServiceHelper.m24704a(context, "connectivity");
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction(NetWorkStateReceiver.ANDROID_NET_CHANGE_ACTION);
                context.registerReceiver(new ConnectivityManager(), intentFilter);
            } catch (Throwable th) {
                th.printStackTrace();
                sUpdateByReceiver.set(false);
            }
        }

        public void onReceive(Context context, Intent intent) {
            if (context != null && NetWorkStateReceiver.ANDROID_NET_CHANGE_ACTION.equals(intent.getAction())) {
                Log.d(SystemServiceHelper.f34942a, "ConnectivityManager connectivity changed" + intent);
                if (!ensureNetworkInfo(sRealManager)) {
                    sNetworkInfo.updateAsync(sRealManager);
                }
            }
        }

        static class NetworkInfo {
            private static final int DEFAULT_EXPIRED_TIME = 45000;
            android.net.NetworkInfo mInfo;
            long mLastAccessTs;
            AtomicBoolean mUpdating = new AtomicBoolean(false);

            NetworkInfo() {
            }

            /* access modifiers changed from: package-private */
            public synchronized boolean isExpired(int i) {
                return System.currentTimeMillis() - this.mLastAccessTs >= ((long) i);
            }

            /* access modifiers changed from: package-private */
            public void update(android.net.ConnectivityManager connectivityManager) {
                try {
                    this.mInfo = connectivityManager.getActiveNetworkInfo();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            /* access modifiers changed from: package-private */
            public void updateAsync(final android.net.ConnectivityManager connectivityManager) {
                if (!this.mUpdating.getAndSet(true)) {
                    AsyncTask.THREAD_POOL_EXECUTOR.execute(new Runnable() {
                        public void run() {
                            try {
                                NetworkInfo.this.update(connectivityManager);
                            } catch (Exception unused) {
                            } catch (Throwable th) {
                                NetworkInfo.this.mUpdating.set(false);
                                throw th;
                            }
                            NetworkInfo.this.mUpdating.set(false);
                        }
                    });
                }
            }
        }

        private static boolean ensureNetworkInfo(android.net.ConnectivityManager connectivityManager) {
            if (sNetworkInfo != null) {
                return false;
            }
            synchronized (ConnectivityManager.class) {
                if (sNetworkInfo != null) {
                    return false;
                }
                NetworkInfo networkInfo = new NetworkInfo();
                sNetworkInfo = networkInfo;
                networkInfo.update(connectivityManager);
                return true;
            }
        }

        public static android.net.NetworkInfo getActiveNetworkInfo(android.net.ConnectivityManager connectivityManager) {
            ensureNetworkInfo(connectivityManager);
            if (!sUpdateByReceiver.get() && sNetworkInfo.isExpired(45000)) {
                sNetworkInfo.updateAsync(connectivityManager);
            }
            return sNetworkInfo.mInfo;
        }
    }

    static class PackageManager {
        private static final String TAG = "Apm_PackageManager";
        static final Map<String, Map<Integer, ApplicationInfo>> sApplicationInfoCache = new HashMap();
        static final Map<String, Map<Integer, PackageInfo>> sPackageInfoCache = new HashMap();

        PackageManager() {
        }

        public static PackageInfo getPackageInfo(android.content.pm.PackageManager packageManager, String str, int i) throws PackageManager.NameNotFoundException {
            synchronized (sPackageInfoCache) {
                Map map = sPackageInfoCache.get(str);
                if (map == null) {
                    map = new HashMap();
                    sPackageInfoCache.put(str, map);
                }
                for (Map.Entry entry : map.entrySet()) {
                    int intValue = ((Integer) entry.getKey()).intValue();
                    if (intValue == i) {
                        Log.i(TAG, "getPackageInfo from Cache,pkg is :" + str + ",flag is :" + i + ",cache flag is :" + intValue);
                        PackageInfo packageInfo = (PackageInfo) entry.getValue();
                        return packageInfo;
                    }
                }
                try {
                    PackageInfo packageInfo2 = packageManager.getPackageInfo(str, i);
                    Log.i(TAG, "getPackageInfo from Binder,pkg is :" + str + ",flag is :" + i);
                    if (packageInfo2 != null) {
                        map.put(Integer.valueOf(i), packageInfo2);
                    }
                    return packageInfo2;
                } catch (PackageManager.NameNotFoundException e) {
                    throw e;
                } catch (Exception e2) {
                    Log.e(TAG, "getPackageInfo error", e2);
                    return null;
                }
            }
        }

        public static ApplicationInfo getApplicationInfo(android.content.pm.PackageManager packageManager, String str, int i) throws PackageManager.NameNotFoundException {
            synchronized (sApplicationInfoCache) {
                Map map = sApplicationInfoCache.get(str);
                if (map == null) {
                    map = new HashMap();
                    sApplicationInfoCache.put(str, map);
                }
                for (Map.Entry entry : map.entrySet()) {
                    int intValue = ((Integer) entry.getKey()).intValue();
                    if (intValue == i) {
                        Log.i(TAG, "getApplicationInfo from Cache,pkg is :" + str + ",flag is :" + i + ",cache flag is :" + intValue);
                        ApplicationInfo applicationInfo = (ApplicationInfo) entry.getValue();
                        return applicationInfo;
                    }
                }
                try {
                    ApplicationInfo applicationInfo2 = packageManager.getApplicationInfo(str, i);
                    Log.i(TAG, "getApplicationInfo from Binder,pkg is :" + str + ",flag is :" + i);
                    if (applicationInfo2 != null) {
                        map.put(Integer.valueOf(i), applicationInfo2);
                    }
                    return applicationInfo2;
                } catch (PackageManager.NameNotFoundException e) {
                    throw e;
                } catch (Exception e2) {
                    Log.e(TAG, "getApplicationInfo error", e2);
                    return null;
                }
            }
        }
    }

    static class TelephonyManager {
        private static AtomicReference<String> sDeviceIdRef;
        private static final Object sGetDeviceIdLock = new Object();

        TelephonyManager() {
        }

        public static String getDeviceId(android.telephony.TelephonyManager telephonyManager) {
            synchronized (sGetDeviceIdLock) {
                if (sDeviceIdRef != null) {
                    String str = sDeviceIdRef.get();
                    return str;
                }
                String deviceId = telephonyManager.getDeviceId();
                sDeviceIdRef = new AtomicReference<>(deviceId);
                return deviceId;
            }
        }
    }

    static class Environment {
        private static AtomicReference<File> sExternalStorageDirectory;
        private static final Object sLock = new Object();

        Environment() {
        }

        public static File getExternalStorageDirectory() {
            synchronized (sLock) {
                if (sExternalStorageDirectory != null) {
                    File file = sExternalStorageDirectory.get();
                    return file;
                }
                File externalStorageDirectory = android.os.Environment.getExternalStorageDirectory();
                sExternalStorageDirectory = new AtomicReference<>(externalStorageDirectory);
                return externalStorageDirectory;
            }
        }
    }
}
