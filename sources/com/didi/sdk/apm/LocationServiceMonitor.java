package com.didi.sdk.apm;

import android.app.PendingIntent;
import android.location.LocationListener;
import android.location.LocationManager;
import android.util.Log;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class LocationServiceMonitor {
    private static LocationServiceMonitor INSTANCE = new LocationServiceMonitor();
    public static final String TAG = "LocationServiceMonitor";
    private final List<Record> mLocationListenersList = new ArrayList();
    private boolean mStopped = false;

    private static class Record {
        Object[] args;
        Object listener;
        LocationManager manager;
        Class[] types;

        Record(LocationManager locationManager, Object obj, Object[] objArr, Class[] clsArr) {
            this.manager = locationManager;
            this.listener = obj;
            this.args = objArr;
            this.types = clsArr;
        }
    }

    public static LocationServiceMonitor getInstance() {
        return INSTANCE;
    }

    public void registerListener(LocationManager locationManager, Object[] objArr, Class[] clsArr) {
        if (locationManager != null && objArr != null && clsArr != null) {
            Object obj = null;
            for (Object obj2 : objArr) {
                if ((obj2 instanceof LocationListener) || (obj2 instanceof PendingIntent)) {
                    obj = obj2;
                }
            }
            synchronized (this.mLocationListenersList) {
                this.mLocationListenersList.add(new Record(locationManager, obj, objArr, clsArr));
            }
        }
    }

    public void unregisterListener(LocationManager locationManager, Object obj) {
        ArrayList arrayList;
        if (locationManager != null && obj != null) {
            synchronized (this.mLocationListenersList) {
                arrayList = new ArrayList(this.mLocationListenersList);
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                Record record = (Record) it.next();
                if (record != null && record.manager == locationManager && record.listener == obj) {
                    synchronized (this.mLocationListenersList) {
                        this.mLocationListenersList.remove(record);
                    }
                }
            }
        }
    }

    public void dumpListeners() {
        ArrayList<Record> arrayList;
        synchronized (this.mLocationListenersList) {
            arrayList = new ArrayList<>(this.mLocationListenersList);
        }
        LOGW(">>> Dump location listeners start <<<", new Object[0]);
        int i = 0;
        for (Record record : arrayList) {
            if (record != null) {
                LOGW("Listener %d: %s#%s", Integer.valueOf(i), record.manager, record.listener);
                i++;
            }
        }
        LOGW(">>> Dump location listeners end <<<", new Object[0]);
    }

    public void pauseAllLocation() {
        LOGW("pauseAllLocation", new Object[0]);
        stopAllLocation(false);
    }

    public void stopAllLocation() {
        LOGW("stopAllLocation", new Object[0]);
        stopAllLocation(true);
    }

    private void stopAllLocation(boolean z) {
        ArrayList arrayList;
        if (!this.mLocationListenersList.isEmpty()) {
            this.mStopped = true;
            synchronized (this.mLocationListenersList) {
                arrayList = new ArrayList(this.mLocationListenersList);
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                Record record = (Record) it.next();
                if (record != null) {
                    LocationManager locationManager = record.manager;
                    Object obj = record.listener;
                    try {
                        if (obj instanceof PendingIntent) {
                            locationManager.getClass().getDeclaredMethod("removeUpdates", new Class[]{PendingIntent.class}).invoke(locationManager, new Object[]{obj});
                        }
                        if (obj instanceof LocationListener) {
                            locationManager.getClass().getDeclaredMethod("removeUpdates", new Class[]{LocationListener.class}).invoke(locationManager, new Object[]{obj});
                        }
                        if (z) {
                            synchronized (this.mLocationListenersList) {
                                this.mLocationListenersList.remove(record);
                            }
                        }
                    } catch (Exception e) {
                        LOGE("removeUpdates error:", (Throwable) e);
                    }
                }
            }
        }
    }

    public void resumeAllLocation() {
        ArrayList arrayList;
        LOGW("resumeAllLocation", new Object[0]);
        if (!this.mLocationListenersList.isEmpty() && this.mStopped) {
            this.mStopped = false;
            synchronized (this.mLocationListenersList) {
                arrayList = new ArrayList(this.mLocationListenersList);
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                Record record = (Record) it.next();
                if (record != null) {
                    try {
                        record.manager.getClass().getDeclaredMethod("requestLocationUpdates", record.types).invoke(record.manager, record.args);
                    } catch (Exception e) {
                        LOGE("removeUpdates error:", (Throwable) e);
                    }
                }
            }
        }
    }

    private static void LOGD(String str, Object... objArr) {
        Log.d(TAG, String.format(str, objArr));
    }

    private static void LOGI(String str, Object... objArr) {
        Log.d(TAG, String.format(str, objArr));
    }

    private static void LOGW(String str, Object... objArr) {
        Log.w(TAG, String.format(str, objArr));
    }

    private static void LOGE(String str, Object... objArr) {
        Log.e(TAG, String.format(str, objArr));
    }

    private static void LOGE(String str, Throwable th) {
        Log.e(TAG, str, th);
    }
}
