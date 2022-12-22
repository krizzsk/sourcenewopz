package com.didi.security.wireless;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Parcel;
import android.os.RemoteException;
import android.text.TextUtils;
import com.didi.sdk.apm.SystemUtils;
import java.io.IOException;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

public class AIdClient {

    /* renamed from: a */
    private Context f38564a;

    /* renamed from: b */
    private String f38565b;

    /* renamed from: c */
    private boolean f38566c;

    /* renamed from: d */
    private Runnable f38567d = new Runnable() {
        public void run() {
            AIdClient.this.m27320b();
        }
    };

    private static class SingleInstance {
        /* access modifiers changed from: private */
        public static final AIdClient INSTANCE = new AIdClient();

        private SingleInstance() {
        }
    }

    public static AIdClient getInstance() {
        return SingleInstance.INSTANCE;
    }

    public void init(Context context) {
        if (SingleInstance.INSTANCE.f38564a == null) {
            this.f38564a = context;
            m27318a();
        }
    }

    public String getID() {
        if (this.f38564a == null) {
            return null;
        }
        if (TextUtils.isEmpty(this.f38565b)) {
            m27318a();
        }
        return this.f38565b;
    }

    public boolean isLimitAdTrackingEnabled() {
        return this.f38566c;
    }

    /* renamed from: a */
    private void m27318a() {
        SecurityController.getInstance().post(this.f38567d);
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m27320b() {
        Context context = this.f38564a;
        if (context != null) {
            try {
                AdInfo advertisingIdInfo = getAdvertisingIdInfo(context);
                this.f38565b = advertisingIdInfo.getId();
                this.f38566c = advertisingIdInfo.isLimitAdTrackingEnabled();
            } catch (Exception unused) {
            }
        }
    }

    public static final class AdInfo {
        private final String advertisingId;
        private final boolean limitAdTrackingEnabled;

        AdInfo(String str, boolean z) {
            this.advertisingId = str;
            this.limitAdTrackingEnabled = z;
        }

        public String getId() {
            return this.advertisingId;
        }

        public boolean isLimitAdTrackingEnabled() {
            return this.limitAdTrackingEnabled;
        }
    }

    public static AdInfo getAdvertisingIdInfo(Context context) throws Exception {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            try {
                SystemUtils.getPackageInfo(context.getPackageManager(), "com.android.vending", 0);
            } catch (Exception unused) {
            }
            AdvertisingConnection advertisingConnection = new AdvertisingConnection();
            Intent intent = new Intent("com.google.android.gms.ads.identifier.service.START");
            intent.setPackage("com.google.android.gms");
            if (context.bindService(intent, advertisingConnection, 1)) {
                try {
                    AdvertisingInterface advertisingInterface = new AdvertisingInterface(advertisingConnection.getBinder());
                    AdInfo adInfo = new AdInfo(advertisingInterface.getId(), advertisingInterface.isLimitAdTrackingEnabled(true));
                    context.unbindService(advertisingConnection);
                    return adInfo;
                } catch (Exception e) {
                    throw e;
                } catch (Throwable th) {
                    context.unbindService(advertisingConnection);
                    throw th;
                }
            } else {
                throw new IOException("Google Play connection failed");
            }
        } else {
            throw new IllegalStateException("Cannot be called from the main thread");
        }
    }

    private static final class AdvertisingConnection implements ServiceConnection {
        private final LinkedBlockingQueue<IBinder> queue;
        boolean retrieved;

        public void onServiceDisconnected(ComponentName componentName) {
        }

        private AdvertisingConnection() {
            this.retrieved = false;
            this.queue = new LinkedBlockingQueue<>(1);
        }

        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                this.queue.put(iBinder);
            } catch (InterruptedException unused) {
            }
        }

        public IBinder getBinder() throws InterruptedException {
            if (!this.retrieved) {
                this.retrieved = true;
                return this.queue.poll(2, TimeUnit.SECONDS);
            }
            throw new IllegalStateException();
        }
    }

    private static final class AdvertisingInterface implements IInterface {
        private IBinder binder;

        public AdvertisingInterface(IBinder iBinder) {
            this.binder = iBinder;
        }

        public IBinder asBinder() {
            return this.binder;
        }

        public String getId() throws RemoteException {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                this.binder.transact(1, obtain, obtain2, 0);
                obtain2.readException();
                return obtain2.readString();
            } finally {
                obtain2.recycle();
                obtain.recycle();
            }
        }

        public boolean isLimitAdTrackingEnabled(boolean z) throws RemoteException {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                boolean z2 = true;
                obtain.writeInt(z ? 1 : 0);
                this.binder.transact(2, obtain, obtain2, 0);
                obtain2.readException();
                if (obtain2.readInt() == 0) {
                    z2 = false;
                }
                return z2;
            } finally {
                obtain2.recycle();
                obtain.recycle();
            }
        }
    }
}
