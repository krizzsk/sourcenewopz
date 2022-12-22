package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import com.didi.raven.config.RavenEvent;
import com.google.android.gms.ads.internal.util.zzd;
import com.google.android.gms.common.GooglePlayServicesUtilLight;
import com.google.android.gms.dynamite.DynamiteModule;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.ads.dynamite.ModuleDescriptor;
import java.lang.reflect.Method;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.FutureTask;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public class zzayd {
    private final AtomicReference<ExecutorService> zzecw = new AtomicReference<>((Object) null);
    private final Object zzecx = new Object();
    private String zzecy = null;
    private String zzecz = null;
    private final AtomicBoolean zzeda = new AtomicBoolean(false);
    private final AtomicInteger zzedb = new AtomicInteger(-1);
    private final AtomicReference<Object> zzedc = new AtomicReference<>((Object) null);
    private final AtomicReference<Object> zzedd = new AtomicReference<>((Object) null);
    private final ConcurrentMap<String, Method> zzede = new ConcurrentHashMap(9);
    private final AtomicReference<zzbha> zzedf = new AtomicReference<>((Object) null);
    private final BlockingQueue<FutureTask<?>> zzedg = new ArrayBlockingQueue(20);
    private final Object zzedh = new Object();
    private boolean zzzq = false;

    /* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
    private interface zza {
        void zza(zzbha zzbha) throws RemoteException;
    }

    /* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
    private interface zzb<T> {
        T zzb(zzbha zzbha) throws RemoteException;
    }

    public final boolean isInitialized() {
        synchronized (this.zzedh) {
        }
        return false;
    }

    public final boolean zzaa(Context context) {
        if (((Boolean) zzww.zzra().zzd(zzabq.zzcoo)).booleanValue() && !this.zzeda.get()) {
            if (((Boolean) zzww.zzra().zzd(zzabq.zzcoy)).booleanValue()) {
                return true;
            }
            if (this.zzedb.get() == -1) {
                zzww.zzqw();
                if (!zzbae.zzf(context, GooglePlayServicesUtilLight.GOOGLE_PLAY_SERVICES_VERSION_CODE)) {
                    zzww.zzqw();
                    if (zzbae.zzbr(context)) {
                        zzd.zzez("Google Play Service is out of date, the Google Mobile Ads SDK will not integrate with Firebase. Admob/Firebase integration requires updated Google Play Service.");
                        this.zzedb.set(0);
                    }
                }
                this.zzedb.set(1);
            }
            if (this.zzedb.get() == 1) {
                return true;
            }
        }
        return false;
    }

    private static boolean zzab(Context context) {
        if (!((Boolean) zzww.zzra().zzd(zzabq.zzcov)).booleanValue()) {
            return false;
        }
        if (DynamiteModule.getLocalVersion(context, ModuleDescriptor.MODULE_ID) < ((Integer) zzww.zzra().zzd(zzabq.zzcow)).intValue()) {
            return false;
        }
        if (((Boolean) zzww.zzra().zzd(zzabq.zzcox)).booleanValue()) {
            try {
                context.getClassLoader().loadClass("com.google.firebase.analytics.FirebaseAnalytics");
                return false;
            } catch (ClassNotFoundException unused) {
            }
        }
        return true;
    }

    public final void zza(Context context, zzaat zzaat) {
        zzayt.zzaj(context).zzxs().zzb(zzaat);
        if (((Boolean) zzww.zzra().zzd(zzabq.zzcpa)).booleanValue() && zzaa(context) && zzab(context)) {
            synchronized (this.zzedh) {
            }
        }
    }

    public final void zza(Context context, zzvq zzvq) {
        if (((Boolean) zzww.zzra().zzd(zzabq.zzcpa)).booleanValue() && zzaa(context) && zzab(context)) {
            synchronized (this.zzedh) {
            }
        }
    }

    public final void setConsent(Bundle bundle) {
        zza("setConsent", (zza) new zzayc(bundle));
    }

    public final void zzd(Context context, String str) {
        if (zzaa(context)) {
            if (zzab(context)) {
                zza("beginAdUnitExposure", (zza) new zzayi(str));
            } else {
                zza(context, str, "beginAdUnitExposure");
            }
        }
    }

    public final void zze(Context context, String str) {
        if (zzaa(context)) {
            if (zzab(context)) {
                zza("endAdUnitExposure", (zza) new zzayl(str));
            } else {
                zza(context, str, "endAdUnitExposure");
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v2, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v8, resolved type: java.lang.String} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.String zzac(android.content.Context r7) {
        /*
            r6 = this;
            java.lang.String r0 = "getCurrentScreenName"
            boolean r1 = r6.zzaa(r7)
            java.lang.String r2 = ""
            if (r1 != 0) goto L_0x000b
            return r2
        L_0x000b:
            boolean r1 = zzab(r7)
            if (r1 == 0) goto L_0x001c
            com.google.android.gms.internal.ads.zzayd$zzb r7 = com.google.android.gms.internal.ads.zzayk.zzedi
            java.lang.String r0 = "getCurrentScreenNameOrScreenClass"
            java.lang.Object r7 = r6.zza((java.lang.String) r0, r2, r7)
            java.lang.String r7 = (java.lang.String) r7
            return r7
        L_0x001c:
            java.util.concurrent.atomic.AtomicReference<java.lang.Object> r1 = r6.zzedc
            r3 = 1
            java.lang.String r4 = "com.google.android.gms.measurement.AppMeasurement"
            boolean r1 = r6.zza((android.content.Context) r7, (java.lang.String) r4, (java.util.concurrent.atomic.AtomicReference<java.lang.Object>) r1, (boolean) r3)
            if (r1 != 0) goto L_0x0028
            return r2
        L_0x0028:
            r1 = 0
            java.lang.reflect.Method r3 = r6.zzl(r7, r0)     // Catch:{ Exception -> 0x0056 }
            java.util.concurrent.atomic.AtomicReference<java.lang.Object> r4 = r6.zzedc     // Catch:{ Exception -> 0x0056 }
            java.lang.Object r4 = r4.get()     // Catch:{ Exception -> 0x0056 }
            java.lang.Object[] r5 = new java.lang.Object[r1]     // Catch:{ Exception -> 0x0056 }
            java.lang.Object r3 = r3.invoke(r4, r5)     // Catch:{ Exception -> 0x0056 }
            java.lang.String r3 = (java.lang.String) r3     // Catch:{ Exception -> 0x0056 }
            if (r3 != 0) goto L_0x0052
            java.lang.String r3 = "getCurrentScreenClass"
            java.lang.reflect.Method r7 = r6.zzl(r7, r3)     // Catch:{ Exception -> 0x0056 }
            java.util.concurrent.atomic.AtomicReference<java.lang.Object> r3 = r6.zzedc     // Catch:{ Exception -> 0x0056 }
            java.lang.Object r3 = r3.get()     // Catch:{ Exception -> 0x0056 }
            java.lang.Object[] r4 = new java.lang.Object[r1]     // Catch:{ Exception -> 0x0056 }
            java.lang.Object r7 = r7.invoke(r3, r4)     // Catch:{ Exception -> 0x0056 }
            r3 = r7
            java.lang.String r3 = (java.lang.String) r3     // Catch:{ Exception -> 0x0056 }
        L_0x0052:
            if (r3 == 0) goto L_0x0055
            return r3
        L_0x0055:
            return r2
        L_0x0056:
            r6.zzh((java.lang.String) r0, (boolean) r1)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzayd.zzac(android.content.Context):java.lang.String");
    }

    @Deprecated
    public final void zzf(Context context, String str) {
        if (!zzaa(context) || !(context instanceof Activity)) {
            return;
        }
        if (zzab(context)) {
            zza("setScreenName", (zza) new zzayn(context, str));
        } else if (zza(context, "com.google.firebase.analytics.FirebaseAnalytics", this.zzedd, false)) {
            Method zzm = zzm(context, "setCurrentScreen");
            try {
                zzm.invoke(this.zzedd.get(), new Object[]{(Activity) context, str, context.getPackageName()});
            } catch (Exception unused) {
                zzh("setCurrentScreen", false);
            }
        }
    }

    public final String zzad(Context context) {
        if (!zzaa(context)) {
            return null;
        }
        synchronized (this.zzecx) {
            if (this.zzecy != null) {
                String str = this.zzecy;
                return str;
            }
            if (zzab(context)) {
                this.zzecy = (String) zza("getGmpAppId", this.zzecy, zzaym.zzedi);
            } else {
                this.zzecy = (String) zza("getGmpAppId", context);
            }
            String str2 = this.zzecy;
            return str2;
        }
    }

    public final String zzae(Context context) {
        if (!zzaa(context)) {
            return null;
        }
        long longValue = ((Long) zzww.zzra().zzd(zzabq.zzcot)).longValue();
        if (zzab(context)) {
            if (longValue >= 0) {
                return (String) zzxv().submit(new zzayo(this)).get(longValue, TimeUnit.MILLISECONDS);
            }
            try {
                return (String) zza("getAppInstanceId", (Object) null, zzayp.zzedi);
            } catch (TimeoutException unused) {
                return "TIME_OUT";
            } catch (Exception unused2) {
                return null;
            }
        } else if (longValue < 0) {
            return (String) zza("getAppInstanceId", context);
        } else {
            try {
                return (String) zzxv().submit(new zzayr(this, context)).get(longValue, TimeUnit.MILLISECONDS);
            } catch (TimeoutException unused3) {
                return "TIME_OUT";
            } catch (Exception unused4) {
                return null;
            }
        }
    }

    public final String zzaf(Context context) {
        if (!zzaa(context)) {
            return null;
        }
        if (zzab(context)) {
            Long l = (Long) zza("getAdEventId", (Object) null, zzayf.zzedi);
            if (l != null) {
                return Long.toString(l.longValue());
            }
            return null;
        }
        Object zza2 = zza("generateEventId", context);
        if (zza2 != null) {
            return zza2.toString();
        }
        return null;
    }

    public final String zzag(Context context) {
        if (!zzaa(context)) {
            return null;
        }
        synchronized (this.zzecx) {
            if (this.zzecz != null) {
                String str = this.zzecz;
                return str;
            }
            if (zzab(context)) {
                this.zzecz = (String) zza("getAppIdOrigin", this.zzecz, zzaye.zzedi);
            } else {
                this.zzecz = "fa";
            }
            String str2 = this.zzecz;
            return str2;
        }
    }

    public final void zzg(Context context, String str) {
        zza(context, "_ac", str, (Bundle) null);
    }

    public final void zzh(Context context, String str) {
        zza(context, "_ai", str, (Bundle) null);
    }

    public final void zzi(Context context, String str) {
        zza(context, "_aq", str, (Bundle) null);
    }

    public final void zzj(Context context, String str) {
        zza(context, "_aa", str, (Bundle) null);
    }

    public final void zza(Context context, String str, String str2, String str3, int i) {
        if (zzaa(context)) {
            Bundle bundle = new Bundle();
            bundle.putString("_ai", str2);
            bundle.putString("reward_type", str3);
            bundle.putInt("reward_value", i);
            zza(context, "_ar", str, bundle);
            StringBuilder sb = new StringBuilder(String.valueOf(str3).length() + 75);
            sb.append("Log a Firebase reward video event, reward type: ");
            sb.append(str3);
            sb.append(", reward value: ");
            sb.append(i);
            zzd.zzed(sb.toString());
        }
    }

    private final void zza(Context context, String str, String str2, Bundle bundle) {
        if (zzaa(context)) {
            Bundle zzk = zzk(str2, str);
            if (bundle != null) {
                zzk.putAll(bundle);
            }
            if (zzab(context)) {
                zza("logEventInternal", (zza) new zzayh(str, zzk));
            } else if (zza(context, "com.google.android.gms.measurement.AppMeasurement", this.zzedc, true)) {
                Method zzah = zzah(context);
                try {
                    zzah.invoke(this.zzedc.get(), new Object[]{"am", str, zzk});
                } catch (Exception unused) {
                    zzh("logEventInternal", true);
                }
            }
        }
    }

    private static Bundle zzk(String str, String str2) {
        Bundle bundle = new Bundle();
        try {
            bundle.putLong("_aeid", Long.parseLong(str));
        } catch (NullPointerException | NumberFormatException e) {
            String valueOf = String.valueOf(str);
            zzd.zzc(valueOf.length() != 0 ? "Invalid event ID: ".concat(valueOf) : new String("Invalid event ID: "), e);
        }
        if ("_ac".equals(str2)) {
            bundle.putInt(RavenEvent.DefaultEvent.REQUEST, 1);
        }
        return bundle;
    }

    private final Method zzah(Context context) {
        Method method = (Method) this.zzede.get("logEventInternal");
        if (method != null) {
            return method;
        }
        try {
            Method declaredMethod = context.getClassLoader().loadClass("com.google.android.gms.measurement.AppMeasurement").getDeclaredMethod("logEventInternal", new Class[]{String.class, String.class, Bundle.class});
            this.zzede.put("logEventInternal", declaredMethod);
            return declaredMethod;
        } catch (Exception unused) {
            zzh("logEventInternal", true);
            return null;
        }
    }

    private final Method zzk(Context context, String str) {
        Method method = (Method) this.zzede.get(str);
        if (method != null) {
            return method;
        }
        try {
            Method declaredMethod = context.getClassLoader().loadClass("com.google.android.gms.measurement.AppMeasurement").getDeclaredMethod(str, new Class[]{String.class});
            this.zzede.put(str, declaredMethod);
            return declaredMethod;
        } catch (Exception unused) {
            zzh(str, false);
            return null;
        }
    }

    private final Method zzl(Context context, String str) {
        Method method = (Method) this.zzede.get(str);
        if (method != null) {
            return method;
        }
        try {
            Method declaredMethod = context.getClassLoader().loadClass("com.google.android.gms.measurement.AppMeasurement").getDeclaredMethod(str, new Class[0]);
            this.zzede.put(str, declaredMethod);
            return declaredMethod;
        } catch (Exception unused) {
            zzh(str, false);
            return null;
        }
    }

    private final Method zzm(Context context, String str) {
        Method method = (Method) this.zzede.get(str);
        if (method != null) {
            return method;
        }
        try {
            Method declaredMethod = context.getClassLoader().loadClass("com.google.firebase.analytics.FirebaseAnalytics").getDeclaredMethod(str, new Class[]{Activity.class, String.class, String.class});
            this.zzede.put(str, declaredMethod);
            return declaredMethod;
        } catch (Exception unused) {
            zzh(str, false);
            return null;
        }
    }

    private final void zza(Context context, String str, String str2) {
        if (zza(context, "com.google.android.gms.measurement.AppMeasurement", this.zzedc, true)) {
            Method zzk = zzk(context, str2);
            try {
                zzk.invoke(this.zzedc.get(), new Object[]{str});
                StringBuilder sb = new StringBuilder(String.valueOf(str2).length() + 37 + String.valueOf(str).length());
                sb.append("Invoke Firebase method ");
                sb.append(str2);
                sb.append(", Ad Unit Id: ");
                sb.append(str);
                zzd.zzed(sb.toString());
            } catch (Exception unused) {
                zzh(str2, false);
            }
        }
    }

    private final Object zza(String str, Context context) {
        if (!zza(context, "com.google.android.gms.measurement.AppMeasurement", this.zzedc, true)) {
            return null;
        }
        try {
            return zzl(context, str).invoke(this.zzedc.get(), new Object[0]);
        } catch (Exception unused) {
            zzh(str, true);
            return null;
        }
    }

    private final void zzh(String str, boolean z) {
        if (!this.zzeda.get()) {
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 30);
            sb.append("Invoke Firebase method ");
            sb.append(str);
            sb.append(" error.");
            zzd.zzez(sb.toString());
            if (z) {
                zzd.zzez("The Google Mobile Ads SDK will not integrate with Firebase. Admob/Firebase integration requires the latest Firebase SDK jar, but Firebase SDK is either missing or out of date");
                this.zzeda.set(true);
            }
        }
    }

    /* JADX WARNING: type inference failed for: r0v9, types: [java.util.concurrent.ExecutorService] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final java.util.concurrent.ExecutorService zzxv() {
        /*
            r9 = this;
            java.util.concurrent.atomic.AtomicReference<java.util.concurrent.ExecutorService> r0 = r9.zzecw
            java.lang.Object r0 = r0.get()
            if (r0 != 0) goto L_0x0066
            boolean r0 = com.google.android.gms.common.util.ClientLibraryUtils.isPackageSide()
            if (r0 == 0) goto L_0x002d
            com.google.android.gms.internal.ads.zzdxb r0 = com.google.android.gms.internal.ads.zzdxa.zzazw()
            com.google.android.gms.internal.ads.zzabf<java.lang.Integer> r1 = com.google.android.gms.internal.ads.zzabq.zzcou
            com.google.android.gms.internal.ads.zzabm r2 = com.google.android.gms.internal.ads.zzww.zzra()
            java.lang.Object r1 = r2.zzd(r1)
            java.lang.Integer r1 = (java.lang.Integer) r1
            int r1 = r1.intValue()
            java.util.concurrent.ThreadFactory r2 = r9.zzxw()
            int r3 = com.google.android.gms.internal.ads.zzdxj.zzhyj
            java.util.concurrent.ExecutorService r0 = r0.zza(r1, r2, r3)
            goto L_0x0060
        L_0x002d:
            java.util.concurrent.ThreadPoolExecutor r0 = new java.util.concurrent.ThreadPoolExecutor
            com.google.android.gms.internal.ads.zzabf<java.lang.Integer> r1 = com.google.android.gms.internal.ads.zzabq.zzcou
            com.google.android.gms.internal.ads.zzabm r2 = com.google.android.gms.internal.ads.zzww.zzra()
            java.lang.Object r1 = r2.zzd(r1)
            java.lang.Integer r1 = (java.lang.Integer) r1
            int r2 = r1.intValue()
            com.google.android.gms.internal.ads.zzabf<java.lang.Integer> r1 = com.google.android.gms.internal.ads.zzabq.zzcou
            com.google.android.gms.internal.ads.zzabm r3 = com.google.android.gms.internal.ads.zzww.zzra()
            java.lang.Object r1 = r3.zzd(r1)
            java.lang.Integer r1 = (java.lang.Integer) r1
            int r3 = r1.intValue()
            r4 = 1
            java.util.concurrent.TimeUnit r6 = java.util.concurrent.TimeUnit.MINUTES
            java.util.concurrent.LinkedBlockingQueue r7 = new java.util.concurrent.LinkedBlockingQueue
            r7.<init>()
            java.util.concurrent.ThreadFactory r8 = r9.zzxw()
            r1 = r0
            r1.<init>(r2, r3, r4, r6, r7, r8)
        L_0x0060:
            java.util.concurrent.atomic.AtomicReference<java.util.concurrent.ExecutorService> r1 = r9.zzecw
            r2 = 0
            r1.compareAndSet(r2, r0)
        L_0x0066:
            java.util.concurrent.atomic.AtomicReference<java.util.concurrent.ExecutorService> r0 = r9.zzecw
            java.lang.Object r0 = r0.get()
            java.util.concurrent.ExecutorService r0 = (java.util.concurrent.ExecutorService) r0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzayd.zzxv():java.util.concurrent.ExecutorService");
    }

    private final ThreadFactory zzxw() {
        return new zzayq(this);
    }

    private final boolean zza(Context context, String str, AtomicReference<Object> atomicReference, boolean z) {
        if (atomicReference.get() == null) {
            try {
                atomicReference.compareAndSet((Object) null, context.getClassLoader().loadClass(str).getDeclaredMethod("getInstance", new Class[]{Context.class}).invoke((Object) null, new Object[]{context}));
            } catch (Exception unused) {
                zzh("getInstance", z);
                return false;
            }
        }
        return true;
    }

    private final void zza(String str, zza zza2) {
        synchronized (this.zzedf) {
            FutureTask futureTask = new FutureTask(new zzayg(this, zza2, str), (Object) null);
            if (this.zzedf.get() != null) {
                futureTask.run();
            } else {
                this.zzedg.offer(futureTask);
            }
        }
    }

    private final <T> T zza(String str, T t, zzb<T> zzb2) {
        synchronized (this.zzedf) {
            if (this.zzedf.get() != null) {
                try {
                    T zzb3 = zzb2.zzb(this.zzedf.get());
                    return zzb3;
                } catch (Exception unused) {
                    zzh(str, false);
                    return t;
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zza(zza zza2, String str) {
        if (this.zzedf.get() != null) {
            try {
                zza2.zza(this.zzedf.get());
            } catch (Exception unused) {
                zzh(str, false);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ String zzai(Context context) throws Exception {
        return (String) zza("getAppInstanceId", context);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ String zzxx() throws Exception {
        return (String) zza("getAppInstanceId", (Object) null, zzayj.zzedi);
    }
}
