package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import android.view.View;
import android.webkit.WebView;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
public final class zzasb {
    private static final Object lock = new Object();
    private static boolean zzdsi = false;
    private static boolean zzzq = false;
    private zzduq zzdsj;

    public final boolean zzm(Context context) {
        synchronized (lock) {
            if (!((Boolean) zzww.zzra().zzd(zzabq.zzcwh)).booleanValue()) {
                return false;
            }
            if (zzzq) {
                return true;
            }
            try {
                zzn(context);
                boolean zzaw = this.zzdsj.zzaw(ObjectWrapper.wrap(context));
                zzzq = zzaw;
                return zzaw;
            } catch (RemoteException e) {
                e = e;
                zzbao.zze("#007 Could not call remote method.", e);
                return false;
            } catch (NullPointerException e2) {
                e = e2;
                zzbao.zze("#007 Could not call remote method.", e);
                return false;
            }
        }
    }

    private final void zzn(Context context) {
        synchronized (lock) {
            if (((Boolean) zzww.zzra().zzd(zzabq.zzcwh)).booleanValue() && !zzdsi) {
                try {
                    zzdsi = true;
                    this.zzdsj = (zzduq) zzban.zza(context, "com.google.android.gms.ads.omid.DynamiteOmid", zzasd.zzbys);
                } catch (zzbap e) {
                    zzbao.zze("#007 Could not call remote method.", e);
                }
            }
        }
    }

    public final String getVersion(Context context) {
        if (!((Boolean) zzww.zzra().zzd(zzabq.zzcwh)).booleanValue()) {
            return null;
        }
        try {
            zzn(context);
            String valueOf = String.valueOf(this.zzdsj.getVersion());
            return valueOf.length() != 0 ? "a.".concat(valueOf) : new String("a.");
        } catch (RemoteException | NullPointerException e) {
            zzbao.zze("#007 Could not call remote method.", e);
            return null;
        }
    }

    public final IObjectWrapper zza(String str, WebView webView, String str2, String str3, String str4) {
        return zza(str, webView, str2, str3, str4, "Google");
    }

    public final IObjectWrapper zza(String str, WebView webView, String str2, String str3, String str4, String str5) {
        synchronized (lock) {
            try {
                if (((Boolean) zzww.zzra().zzd(zzabq.zzcwh)).booleanValue()) {
                    if (zzzq) {
                        try {
                            return this.zzdsj.zza(str, ObjectWrapper.wrap(webView), str2, str3, str4, str5);
                        } catch (RemoteException | NullPointerException e) {
                            zzbao.zze("#007 Could not call remote method.", e);
                            return null;
                        }
                    }
                }
                return null;
            } catch (Throwable th) {
                th = th;
                throw th;
            }
        }
    }

    public final IObjectWrapper zza(String str, WebView webView, String str2, String str3, String str4, zzase zzase, zzasc zzasc, String str5) {
        return zza(str, webView, str2, str3, str4, "Google", zzase, zzasc, str5);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x002c, code lost:
        if (((java.lang.Boolean) com.google.android.gms.internal.ads.zzww.zzra().zzd(com.google.android.gms.internal.ads.zzabq.zzcwk)).booleanValue() != false) goto L_0x0033;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0032, code lost:
        return zza(r15, r16, r17, r18, r19, r20);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0051, code lost:
        return r14.zzdsj.zzb(r15, com.google.android.gms.dynamic.ObjectWrapper.wrap(r16), r17, r18, r19, r20, r21.toString(), r22.toString(), r23);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0052, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0055, code lost:
        com.google.android.gms.internal.ads.zzbao.zze("#007 Could not call remote method.", r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x005a, code lost:
        return null;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final com.google.android.gms.dynamic.IObjectWrapper zza(java.lang.String r15, android.webkit.WebView r16, java.lang.String r17, java.lang.String r18, java.lang.String r19, java.lang.String r20, com.google.android.gms.internal.ads.zzase r21, com.google.android.gms.internal.ads.zzasc r22, java.lang.String r23) {
        /*
            r14 = this;
            java.lang.Object r1 = lock
            monitor-enter(r1)
            com.google.android.gms.internal.ads.zzabf<java.lang.Boolean> r0 = com.google.android.gms.internal.ads.zzabq.zzcwh     // Catch:{ all -> 0x005e }
            com.google.android.gms.internal.ads.zzabm r2 = com.google.android.gms.internal.ads.zzww.zzra()     // Catch:{ all -> 0x005e }
            java.lang.Object r0 = r2.zzd(r0)     // Catch:{ all -> 0x005e }
            java.lang.Boolean r0 = (java.lang.Boolean) r0     // Catch:{ all -> 0x005e }
            boolean r0 = r0.booleanValue()     // Catch:{ all -> 0x005e }
            r2 = 0
            if (r0 == 0) goto L_0x005b
            boolean r0 = zzzq     // Catch:{ all -> 0x005e }
            if (r0 != 0) goto L_0x001b
            goto L_0x005b
        L_0x001b:
            monitor-exit(r1)     // Catch:{ all -> 0x005e }
            com.google.android.gms.internal.ads.zzabf<java.lang.Boolean> r0 = com.google.android.gms.internal.ads.zzabq.zzcwk
            com.google.android.gms.internal.ads.zzabm r1 = com.google.android.gms.internal.ads.zzww.zzra()
            java.lang.Object r0 = r1.zzd(r0)
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            boolean r0 = r0.booleanValue()
            if (r0 != 0) goto L_0x0033
            com.google.android.gms.dynamic.IObjectWrapper r0 = r14.zza(r15, r16, r17, r18, r19, r20)
            return r0
        L_0x0033:
            r3 = r14
            com.google.android.gms.internal.ads.zzduq r4 = r3.zzdsj     // Catch:{ RemoteException -> 0x0054, NullPointerException -> 0x0052 }
            com.google.android.gms.dynamic.IObjectWrapper r6 = com.google.android.gms.dynamic.ObjectWrapper.wrap(r16)     // Catch:{ RemoteException -> 0x0054, NullPointerException -> 0x0052 }
            java.lang.String r11 = r21.toString()     // Catch:{ RemoteException -> 0x0054, NullPointerException -> 0x0052 }
            java.lang.String r12 = r22.toString()     // Catch:{ RemoteException -> 0x0054, NullPointerException -> 0x0052 }
            r5 = r15
            r7 = r17
            r8 = r18
            r9 = r19
            r10 = r20
            r13 = r23
            com.google.android.gms.dynamic.IObjectWrapper r0 = r4.zzb(r5, r6, r7, r8, r9, r10, r11, r12, r13)     // Catch:{ RemoteException -> 0x0054, NullPointerException -> 0x0052 }
            return r0
        L_0x0052:
            r0 = move-exception
            goto L_0x0055
        L_0x0054:
            r0 = move-exception
        L_0x0055:
            java.lang.String r1 = "#007 Could not call remote method."
            com.google.android.gms.internal.ads.zzbao.zze(r1, r0)
            return r2
        L_0x005b:
            r3 = r14
            monitor-exit(r1)     // Catch:{ all -> 0x0062 }
            return r2
        L_0x005e:
            r0 = move-exception
            r3 = r14
        L_0x0060:
            monitor-exit(r1)     // Catch:{ all -> 0x0062 }
            throw r0
        L_0x0062:
            r0 = move-exception
            goto L_0x0060
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzasb.zza(java.lang.String, android.webkit.WebView, java.lang.String, java.lang.String, java.lang.String, java.lang.String, com.google.android.gms.internal.ads.zzase, com.google.android.gms.internal.ads.zzasc, java.lang.String):com.google.android.gms.dynamic.IObjectWrapper");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x002c, code lost:
        if (((java.lang.Boolean) com.google.android.gms.internal.ads.zzww.zzra().zzd(com.google.android.gms.internal.ads.zzabq.zzcwl)).booleanValue() != false) goto L_0x0033;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0032, code lost:
        return zza(r15, r16, r17, r18, r19, r20);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0051, code lost:
        return r14.zzdsj.zza(r15, com.google.android.gms.dynamic.ObjectWrapper.wrap(r16), r17, r18, r19, r20, r21.toString(), r22.toString(), r23);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0052, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0055, code lost:
        com.google.android.gms.internal.ads.zzbao.zze("#007 Could not call remote method.", r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x005a, code lost:
        return null;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.gms.dynamic.IObjectWrapper zzb(java.lang.String r15, android.webkit.WebView r16, java.lang.String r17, java.lang.String r18, java.lang.String r19, java.lang.String r20, com.google.android.gms.internal.ads.zzase r21, com.google.android.gms.internal.ads.zzasc r22, java.lang.String r23) {
        /*
            r14 = this;
            java.lang.Object r1 = lock
            monitor-enter(r1)
            com.google.android.gms.internal.ads.zzabf<java.lang.Boolean> r0 = com.google.android.gms.internal.ads.zzabq.zzcwh     // Catch:{ all -> 0x005e }
            com.google.android.gms.internal.ads.zzabm r2 = com.google.android.gms.internal.ads.zzww.zzra()     // Catch:{ all -> 0x005e }
            java.lang.Object r0 = r2.zzd(r0)     // Catch:{ all -> 0x005e }
            java.lang.Boolean r0 = (java.lang.Boolean) r0     // Catch:{ all -> 0x005e }
            boolean r0 = r0.booleanValue()     // Catch:{ all -> 0x005e }
            r2 = 0
            if (r0 == 0) goto L_0x005b
            boolean r0 = zzzq     // Catch:{ all -> 0x005e }
            if (r0 != 0) goto L_0x001b
            goto L_0x005b
        L_0x001b:
            monitor-exit(r1)     // Catch:{ all -> 0x005e }
            com.google.android.gms.internal.ads.zzabf<java.lang.Boolean> r0 = com.google.android.gms.internal.ads.zzabq.zzcwl
            com.google.android.gms.internal.ads.zzabm r1 = com.google.android.gms.internal.ads.zzww.zzra()
            java.lang.Object r0 = r1.zzd(r0)
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            boolean r0 = r0.booleanValue()
            if (r0 != 0) goto L_0x0033
            com.google.android.gms.dynamic.IObjectWrapper r0 = r14.zza(r15, r16, r17, r18, r19, r20)
            return r0
        L_0x0033:
            r3 = r14
            com.google.android.gms.internal.ads.zzduq r4 = r3.zzdsj     // Catch:{ RemoteException -> 0x0054, NullPointerException -> 0x0052 }
            com.google.android.gms.dynamic.IObjectWrapper r6 = com.google.android.gms.dynamic.ObjectWrapper.wrap(r16)     // Catch:{ RemoteException -> 0x0054, NullPointerException -> 0x0052 }
            java.lang.String r11 = r21.toString()     // Catch:{ RemoteException -> 0x0054, NullPointerException -> 0x0052 }
            java.lang.String r12 = r22.toString()     // Catch:{ RemoteException -> 0x0054, NullPointerException -> 0x0052 }
            r5 = r15
            r7 = r17
            r8 = r18
            r9 = r19
            r10 = r20
            r13 = r23
            com.google.android.gms.dynamic.IObjectWrapper r0 = r4.zza(r5, r6, r7, r8, r9, r10, r11, r12, r13)     // Catch:{ RemoteException -> 0x0054, NullPointerException -> 0x0052 }
            return r0
        L_0x0052:
            r0 = move-exception
            goto L_0x0055
        L_0x0054:
            r0 = move-exception
        L_0x0055:
            java.lang.String r1 = "#007 Could not call remote method."
            com.google.android.gms.internal.ads.zzbao.zze(r1, r0)
            return r2
        L_0x005b:
            r3 = r14
            monitor-exit(r1)     // Catch:{ all -> 0x0062 }
            return r2
        L_0x005e:
            r0 = move-exception
            r3 = r14
        L_0x0060:
            monitor-exit(r1)     // Catch:{ all -> 0x0062 }
            throw r0
        L_0x0062:
            r0 = move-exception
            goto L_0x0060
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzasb.zzb(java.lang.String, android.webkit.WebView, java.lang.String, java.lang.String, java.lang.String, java.lang.String, com.google.android.gms.internal.ads.zzase, com.google.android.gms.internal.ads.zzasc, java.lang.String):com.google.android.gms.dynamic.IObjectWrapper");
    }

    public final void zzac(IObjectWrapper iObjectWrapper) {
        synchronized (lock) {
            if (((Boolean) zzww.zzra().zzd(zzabq.zzcwh)).booleanValue()) {
                if (zzzq) {
                    try {
                        this.zzdsj.zzac(iObjectWrapper);
                    } catch (RemoteException | NullPointerException e) {
                        zzbao.zze("#007 Could not call remote method.", e);
                    }
                }
            }
        }
    }

    public final void zzad(IObjectWrapper iObjectWrapper) {
        synchronized (lock) {
            if (((Boolean) zzww.zzra().zzd(zzabq.zzcwh)).booleanValue()) {
                if (zzzq) {
                    try {
                        this.zzdsj.zzad(iObjectWrapper);
                    } catch (RemoteException | NullPointerException e) {
                        zzbao.zze("#007 Could not call remote method.", e);
                    }
                }
            }
        }
    }

    public final void zza(IObjectWrapper iObjectWrapper, View view) {
        synchronized (lock) {
            if (((Boolean) zzww.zzra().zzd(zzabq.zzcwh)).booleanValue()) {
                if (zzzq) {
                    try {
                        this.zzdsj.zzc(iObjectWrapper, ObjectWrapper.wrap(view));
                    } catch (RemoteException | NullPointerException e) {
                        zzbao.zze("#007 Could not call remote method.", e);
                    }
                }
            }
        }
    }

    public final void zzb(IObjectWrapper iObjectWrapper, View view) {
        synchronized (lock) {
            if (((Boolean) zzww.zzra().zzd(zzabq.zzcwh)).booleanValue()) {
                if (zzzq) {
                    try {
                        this.zzdsj.zzd(iObjectWrapper, ObjectWrapper.wrap(view));
                    } catch (RemoteException | NullPointerException e) {
                        zzbao.zze("#007 Could not call remote method.", e);
                    }
                }
            }
        }
    }
}
