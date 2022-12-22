package com.google.android.gms.internal.ads;

import android.app.ActivityManager;
import android.app.KeyguardManager;
import android.content.Context;
import android.graphics.Rect;
import android.os.PowerManager;
import android.os.Process;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.EditText;
import android.widget.TextView;
import com.google.android.gms.ads.internal.util.zzd;
import com.google.android.gms.ads.internal.zzr;
import com.google.android.gms.common.util.PlatformVersion;
import java.util.List;
import javax.annotation.ParametersAreNonnullByDefault;
import org.json.JSONException;
import org.json.JSONObject;

@ParametersAreNonnullByDefault
/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzrq extends Thread {
    private final Object lock;
    private boolean started;
    private final int zzbsq;
    private final int zzbss;
    private final boolean zzbst;
    private boolean zzbtr;
    private boolean zzbts;
    private final zzrn zzbtt;
    private final int zzbtu;
    private final int zzbtv;
    private final int zzbtw;
    private final int zzbtx;
    private final int zzbty;
    private final int zzbtz;
    private final String zzbua;
    private final boolean zzbub;
    private final boolean zzbuc;

    public zzrq() {
        this(new zzrn());
    }

    private zzrq(zzrn zzrn) {
        this.started = false;
        this.zzbtr = false;
        this.zzbts = false;
        this.zzbtt = zzrn;
        this.lock = new Object();
        this.zzbsq = zzadh.zzdeh.get().intValue();
        this.zzbtv = zzadh.zzdee.get().intValue();
        this.zzbss = zzadh.zzdei.get().intValue();
        this.zzbtw = zzadh.zzdeg.get().intValue();
        this.zzbtx = ((Integer) zzww.zzra().zzd(zzabq.zzcog)).intValue();
        this.zzbty = ((Integer) zzww.zzra().zzd(zzabq.zzcoh)).intValue();
        this.zzbtz = ((Integer) zzww.zzra().zzd(zzabq.zzcoi)).intValue();
        this.zzbtu = zzadh.zzdej.get().intValue();
        this.zzbua = (String) zzww.zzra().zzd(zzabq.zzcok);
        this.zzbub = ((Boolean) zzww.zzra().zzd(zzabq.zzcol)).booleanValue();
        this.zzbst = ((Boolean) zzww.zzra().zzd(zzabq.zzcom)).booleanValue();
        this.zzbuc = ((Boolean) zzww.zzra().zzd(zzabq.zzcon)).booleanValue();
        setName("ContentFetchTask");
    }

    public final void zzmo() {
        synchronized (this.lock) {
            if (this.started) {
                zzd.zzdz("Content hash thread already started, quiting...");
                return;
            }
            this.started = true;
            start();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x003d, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:?, code lost:
        com.google.android.gms.ads.internal.zzr.zzkz().zza(r0, "ContentFetchTask.extractContent");
        com.google.android.gms.ads.internal.util.zzd.zzdz("Failed getting root view of activity. Content not extracted.");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x007b, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x007c, code lost:
        com.google.android.gms.ads.internal.util.zzd.zzc("Error in ContentFetchTask", r0);
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:30:0x0084 */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x007b A[ExcHandler: InterruptedException (r0v1 'e' java.lang.InterruptedException A[CUSTOM_DECLARE]), Splitter:B:0:0x0000] */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0084 A[LOOP:1: B:30:0x0084->B:42:0x0084, LOOP_START, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void run() {
        /*
            r4 = this;
        L_0x0000:
            boolean r0 = zzmp()     // Catch:{ InterruptedException -> 0x007b, Exception -> 0x006b }
            if (r0 == 0) goto L_0x005a
            com.google.android.gms.internal.ads.zzrm r0 = com.google.android.gms.ads.internal.zzr.zzky()     // Catch:{ InterruptedException -> 0x007b, Exception -> 0x006b }
            android.app.Activity r0 = r0.getActivity()     // Catch:{ InterruptedException -> 0x007b, Exception -> 0x006b }
            if (r0 != 0) goto L_0x0019
            java.lang.String r0 = "ContentFetchThread: no activity. Sleeping."
            com.google.android.gms.ads.internal.util.zzd.zzdz(r0)     // Catch:{ InterruptedException -> 0x007b, Exception -> 0x006b }
            r4.zzmr()     // Catch:{ InterruptedException -> 0x007b, Exception -> 0x006b }
            goto L_0x0062
        L_0x0019:
            if (r0 == 0) goto L_0x0062
            r1 = 0
            android.view.Window r2 = r0.getWindow()     // Catch:{ Exception -> 0x003d, InterruptedException -> 0x007b }
            if (r2 == 0) goto L_0x004c
            android.view.Window r2 = r0.getWindow()     // Catch:{ Exception -> 0x003d, InterruptedException -> 0x007b }
            android.view.View r2 = r2.getDecorView()     // Catch:{ Exception -> 0x003d, InterruptedException -> 0x007b }
            if (r2 == 0) goto L_0x004c
            android.view.Window r0 = r0.getWindow()     // Catch:{ Exception -> 0x003d, InterruptedException -> 0x007b }
            android.view.View r0 = r0.getDecorView()     // Catch:{ Exception -> 0x003d, InterruptedException -> 0x007b }
            r2 = 16908290(0x1020002, float:2.3877235E-38)
            android.view.View r0 = r0.findViewById(r2)     // Catch:{ Exception -> 0x003d, InterruptedException -> 0x007b }
            r1 = r0
            goto L_0x004c
        L_0x003d:
            r0 = move-exception
            com.google.android.gms.internal.ads.zzazs r2 = com.google.android.gms.ads.internal.zzr.zzkz()     // Catch:{ InterruptedException -> 0x007b, Exception -> 0x006b }
            java.lang.String r3 = "ContentFetchTask.extractContent"
            r2.zza(r0, r3)     // Catch:{ InterruptedException -> 0x007b, Exception -> 0x006b }
            java.lang.String r0 = "Failed getting root view of activity. Content not extracted."
            com.google.android.gms.ads.internal.util.zzd.zzdz(r0)     // Catch:{ InterruptedException -> 0x007b, Exception -> 0x006b }
        L_0x004c:
            if (r1 == 0) goto L_0x0062
            if (r1 != 0) goto L_0x0051
            goto L_0x0062
        L_0x0051:
            com.google.android.gms.internal.ads.zzrt r0 = new com.google.android.gms.internal.ads.zzrt     // Catch:{ InterruptedException -> 0x007b, Exception -> 0x006b }
            r0.<init>(r4, r1)     // Catch:{ InterruptedException -> 0x007b, Exception -> 0x006b }
            r1.post(r0)     // Catch:{ InterruptedException -> 0x007b, Exception -> 0x006b }
            goto L_0x0062
        L_0x005a:
            java.lang.String r0 = "ContentFetchTask: sleeping"
            com.google.android.gms.ads.internal.util.zzd.zzdz(r0)     // Catch:{ InterruptedException -> 0x007b, Exception -> 0x006b }
            r4.zzmr()     // Catch:{ InterruptedException -> 0x007b, Exception -> 0x006b }
        L_0x0062:
            int r0 = r4.zzbtu     // Catch:{ InterruptedException -> 0x007b, Exception -> 0x006b }
            int r0 = r0 * 1000
            long r0 = (long) r0     // Catch:{ InterruptedException -> 0x007b, Exception -> 0x006b }
            java.lang.Thread.sleep(r0)     // Catch:{ InterruptedException -> 0x007b, Exception -> 0x006b }
            goto L_0x0081
        L_0x006b:
            r0 = move-exception
            java.lang.String r1 = "Error in ContentFetchTask"
            com.google.android.gms.ads.internal.util.zzd.zzc(r1, r0)
            com.google.android.gms.internal.ads.zzazs r1 = com.google.android.gms.ads.internal.zzr.zzkz()
            java.lang.String r2 = "ContentFetchTask.run"
            r1.zza(r0, r2)
            goto L_0x0081
        L_0x007b:
            r0 = move-exception
            java.lang.String r1 = "Error in ContentFetchTask"
            com.google.android.gms.ads.internal.util.zzd.zzc(r1, r0)
        L_0x0081:
            java.lang.Object r0 = r4.lock
            monitor-enter(r0)
        L_0x0084:
            boolean r1 = r4.zzbtr     // Catch:{ all -> 0x0096 }
            if (r1 == 0) goto L_0x0093
            java.lang.String r1 = "ContentFetchTask: waiting"
            com.google.android.gms.ads.internal.util.zzd.zzdz(r1)     // Catch:{ InterruptedException -> 0x0084 }
            java.lang.Object r1 = r4.lock     // Catch:{ InterruptedException -> 0x0084 }
            r1.wait()     // Catch:{ InterruptedException -> 0x0084 }
            goto L_0x0084
        L_0x0093:
            monitor-exit(r0)     // Catch:{ all -> 0x0096 }
            goto L_0x0000
        L_0x0096:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0096 }
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzrq.run():void");
    }

    /* access modifiers changed from: package-private */
    public final void zzj(View view) {
        try {
            zzrk zzrk = new zzrk(this.zzbsq, this.zzbtv, this.zzbss, this.zzbtw, this.zzbtx, this.zzbty, this.zzbtz, this.zzbst);
            Context context = zzr.zzky().getContext();
            if (context != null && !TextUtils.isEmpty(this.zzbua)) {
                String str = (String) view.getTag(context.getResources().getIdentifier((String) zzww.zzra().zzd(zzabq.zzcoj), "id", context.getPackageName()));
                if (str != null && str.equals(this.zzbua)) {
                    return;
                }
            }
            zzru zza = zza(view, zzrk);
            zzrk.zzmm();
            if (zza.zzbuj != 0 || zza.zzbuk != 0) {
                if (zza.zzbuk != 0 || zzrk.zzmn() != 0) {
                    if (zza.zzbuk != 0 || !this.zzbtt.zza(zzrk)) {
                        this.zzbtt.zzc(zzrk);
                    }
                }
            }
        } catch (Exception e) {
            zzd.zzc("Exception in fetchContentOnUIThread", e);
            zzr.zzkz().zza(e, "ContentFetchTask.fetchContent");
        }
    }

    private static boolean zzmp() {
        boolean z;
        try {
            Context context = zzr.zzky().getContext();
            if (context == null) {
                return false;
            }
            ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
            KeyguardManager keyguardManager = (KeyguardManager) context.getSystemService("keyguard");
            if (activityManager == null) {
                return false;
            }
            if (keyguardManager == null) {
                return false;
            }
            List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = activityManager.getRunningAppProcesses();
            if (runningAppProcesses == null) {
                return false;
            }
            for (ActivityManager.RunningAppProcessInfo next : runningAppProcesses) {
                if (Process.myPid() == next.pid) {
                    if (next.importance != 100 || keyguardManager.inKeyguardRestrictedInputMode()) {
                        return false;
                    }
                    PowerManager powerManager = (PowerManager) context.getSystemService("power");
                    if (powerManager == null) {
                        z = false;
                    } else {
                        z = powerManager.isScreenOn();
                    }
                    if (z) {
                        return true;
                    }
                    return false;
                }
            }
            return false;
        } catch (Throwable th) {
            zzr.zzkz().zza(th, "ContentFetchTask.isInForeground");
            return false;
        }
    }

    private final zzru zza(View view, zzrk zzrk) {
        boolean z;
        if (view == null) {
            return new zzru(this, 0, 0);
        }
        boolean globalVisibleRect = view.getGlobalVisibleRect(new Rect());
        if ((view instanceof TextView) && !(view instanceof EditText)) {
            CharSequence text = ((TextView) view).getText();
            if (TextUtils.isEmpty(text)) {
                return new zzru(this, 0, 0);
            }
            zzrk.zzb(text.toString(), globalVisibleRect, view.getX(), view.getY(), (float) view.getWidth(), (float) view.getHeight());
            return new zzru(this, 1, 0);
        } else if ((view instanceof WebView) && !(view instanceof zzbfi)) {
            WebView webView = (WebView) view;
            if (!PlatformVersion.isAtLeastKitKat()) {
                z = false;
            } else {
                zzrk.zzmk();
                webView.post(new zzrs(this, zzrk, webView, globalVisibleRect));
                z = true;
            }
            if (z) {
                return new zzru(this, 0, 1);
            }
            return new zzru(this, 0, 0);
        } else if (!(view instanceof ViewGroup)) {
            return new zzru(this, 0, 0);
        } else {
            ViewGroup viewGroup = (ViewGroup) view;
            int i = 0;
            int i2 = 0;
            for (int i3 = 0; i3 < viewGroup.getChildCount(); i3++) {
                zzru zza = zza(viewGroup.getChildAt(i3), zzrk);
                i += zza.zzbuj;
                i2 += zza.zzbuk;
            }
            return new zzru(this, i, i2);
        }
    }

    /* access modifiers changed from: package-private */
    public final void zza(zzrk zzrk, WebView webView, String str, boolean z) {
        zzrk.zzmj();
        try {
            if (!TextUtils.isEmpty(str)) {
                String optString = new JSONObject(str).optString("text");
                if (this.zzbub || TextUtils.isEmpty(webView.getTitle())) {
                    zzrk.zza(optString, z, webView.getX(), webView.getY(), (float) webView.getWidth(), (float) webView.getHeight());
                } else {
                    String title = webView.getTitle();
                    StringBuilder sb = new StringBuilder(String.valueOf(title).length() + 1 + String.valueOf(optString).length());
                    sb.append(title);
                    sb.append("\n");
                    sb.append(optString);
                    zzrk.zza(sb.toString(), z, webView.getX(), webView.getY(), (float) webView.getWidth(), (float) webView.getHeight());
                }
            }
            if (zzrk.zzme()) {
                this.zzbtt.zzb(zzrk);
            }
        } catch (JSONException unused) {
            zzd.zzdz("Json string may be malformed.");
        } catch (Throwable th) {
            zzd.zzb("Failed to get webview content.", th);
            zzr.zzkz().zza(th, "ContentFetchTask.processWebViewContent");
        }
    }

    public final zzrk zzmq() {
        return this.zzbtt.zzp(this.zzbuc);
    }

    public final void wakeup() {
        synchronized (this.lock) {
            this.zzbtr = false;
            this.lock.notifyAll();
            zzd.zzdz("ContentFetchThread: wakeup");
        }
    }

    private final void zzmr() {
        synchronized (this.lock) {
            this.zzbtr = true;
            StringBuilder sb = new StringBuilder(42);
            sb.append("ContentFetchThread: paused, mPause = ");
            sb.append(true);
            zzd.zzdz(sb.toString());
        }
    }

    public final boolean zzms() {
        return this.zzbtr;
    }
}
