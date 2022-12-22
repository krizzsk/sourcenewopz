package com.appsflyer.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Parcel;
import android.os.RemoteException;
import com.didi.sdk.apm.SystemUtils;
import java.io.IOException;
import java.util.concurrent.LinkedBlockingQueue;

/* renamed from: com.appsflyer.internal.u */
final class C1712u {
    C1712u() {
    }

    /* renamed from: ι */
    static C1713b m1691(Context context) throws Exception {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            try {
                SystemUtils.getPackageInfo(context.getPackageManager(), "com.android.vending", 0);
                C1714d dVar = new C1714d((byte) 0);
                Intent intent = new Intent("com.google.android.gms.ads.identifier.service.START");
                intent.setPackage("com.google.android.gms");
                try {
                    if (!context.bindService(intent, dVar, 1)) {
                        if (context != null) {
                            context.unbindService(dVar);
                        }
                        throw new IOException("Google Play connection failed");
                    } else if (!dVar.f2027) {
                        dVar.f2027 = true;
                        C1715e eVar = new C1715e(dVar.f2028.take());
                        C1713b bVar = new C1713b(eVar.mo16160(), eVar.mo16159());
                        if (context != null) {
                            context.unbindService(dVar);
                        }
                        return bVar;
                    } else {
                        throw new IllegalStateException();
                    }
                } catch (Exception e) {
                    throw e;
                } catch (Throwable th) {
                    if (context != null) {
                        context.unbindService(dVar);
                    }
                    throw th;
                }
            } catch (Exception e2) {
                throw e2;
            }
        } else {
            throw new IllegalStateException("Cannot be called from the main thread");
        }
    }

    /* renamed from: com.appsflyer.internal.u$b */
    static final class C1713b {

        /* renamed from: ǃ */
        private final boolean f2025;

        /* renamed from: ɩ */
        final String f2026;

        C1713b(String str, boolean z) {
            this.f2026 = str;
            this.f2025 = z;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: ɩ */
        public final boolean mo16155() {
            return this.f2025;
        }
    }

    /* renamed from: com.appsflyer.internal.u$d */
    static final class C1714d implements ServiceConnection {

        /* renamed from: ı */
        boolean f2027;

        /* renamed from: Ι */
        final LinkedBlockingQueue<IBinder> f2028;

        public final void onServiceDisconnected(ComponentName componentName) {
        }

        private C1714d() {
            this.f2028 = new LinkedBlockingQueue<>(1);
            this.f2027 = false;
        }

        /* synthetic */ C1714d(byte b) {
            this();
        }

        public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                this.f2028.put(iBinder);
            } catch (InterruptedException unused) {
            }
        }
    }

    /* renamed from: com.appsflyer.internal.u$e */
    static final class C1715e implements IInterface {

        /* renamed from: ǃ */
        private IBinder f2029;

        C1715e(IBinder iBinder) {
            this.f2029 = iBinder;
        }

        public final IBinder asBinder() {
            return this.f2029;
        }

        /* renamed from: ǃ */
        public final String mo16160() throws RemoteException {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                this.f2029.transact(1, obtain, obtain2, 0);
                obtain2.readException();
                return obtain2.readString();
            } finally {
                obtain2.recycle();
                obtain.recycle();
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: ı */
        public final boolean mo16159() throws RemoteException {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                boolean z = true;
                obtain.writeInt(1);
                this.f2029.transact(2, obtain, obtain2, 0);
                obtain2.readException();
                if (obtain2.readInt() == 0) {
                    z = false;
                }
                return z;
            } finally {
                obtain2.recycle();
                obtain.recycle();
            }
        }
    }
}
