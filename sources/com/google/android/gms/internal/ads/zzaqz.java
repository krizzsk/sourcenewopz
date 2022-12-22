package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import com.didi.soda.blocks.constant.Const;
import com.google.android.gms.common.util.CollectionUtils;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzaqz extends zzarj {
    private static final Set<String> zzdqt = CollectionUtils.setOf("top-left", "top-right", "top-center", "center", "bottom-left", "bottom-right", "bottom-center");
    private int height = -1;
    private final Object lock = new Object();
    private int width = -1;
    private zzari zzdjk;
    private final zzbfi zzdkm;
    private final Activity zzdqj;
    private String zzdqu = "top-right";
    private boolean zzdqv = true;
    private int zzdqw = 0;
    private int zzdqx = 0;
    private int zzdqy = 0;
    private int zzdqz = 0;
    private zzbgx zzdra;
    private ImageView zzdrb;
    private LinearLayout zzdrc;
    private PopupWindow zzdrd;
    private RelativeLayout zzdre;
    private ViewGroup zzdrf;

    public zzaqz(zzbfi zzbfi, zzari zzari) {
        super(zzbfi, Const.BlockParamConst.RESIZE);
        this.zzdkm = zzbfi;
        this.zzdqj = zzbfi.zzabx();
        this.zzdjk = zzari;
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:100:0x01a6, code lost:
        if (r5 == 5) goto L_0x01b6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:101:0x01a8, code lost:
        r5 = ((r1.zzdqw + r1.zzdqy) + r1.width) - 50;
        r8 = r1.zzdqx;
        r15 = r1.zzdqz;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:102:0x01b6, code lost:
        r5 = ((r1.zzdqw + r1.zzdqy) + r1.width) - 50;
        r8 = r1.zzdqx + r1.zzdqz;
        r15 = r1.height;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:103:0x01c7, code lost:
        r5 = ((r1.zzdqw + r1.zzdqy) + (r1.width / 2)) - 25;
        r8 = r1.zzdqx + r1.zzdqz;
        r15 = r1.height;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:104:0x01da, code lost:
        r5 = r1.zzdqw + r1.zzdqy;
        r8 = r1.zzdqx + r1.zzdqz;
        r15 = r1.height;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:105:0x01e6, code lost:
        r8 = (r8 + r15) - 50;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:106:0x01e9, code lost:
        r5 = ((r1.zzdqw + r1.zzdqy) + (r1.width / 2)) - 25;
        r8 = ((r1.zzdqx + r1.zzdqz) + (r1.height / 2)) - 25;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:107:0x0200, code lost:
        r5 = ((r1.zzdqw + r1.zzdqy) + (r1.width / 2)) - 25;
        r8 = r1.zzdqx;
        r15 = r1.zzdqz;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:108:0x0210, code lost:
        r5 = r1.zzdqw + r1.zzdqy;
        r8 = r1.zzdqx;
        r15 = r1.zzdqz;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:109:0x0219, code lost:
        r8 = r8 + r15;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:110:0x021a, code lost:
        if (r5 < 0) goto L_0x0236;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:112:0x021d, code lost:
        if ((r5 + 50) > r7) goto L_0x0236;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:114:0x0221, code lost:
        if (r8 < r6[0]) goto L_0x0236;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:116:0x0226, code lost:
        if ((r8 + 50) <= r6[1]) goto L_0x0229;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:94:0x019b, code lost:
        r5 = 65535;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:95:0x019c, code lost:
        if (r5 == 0) goto L_0x0210;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:96:0x019e, code lost:
        if (r5 == 1) goto L_0x0200;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:97:0x01a0, code lost:
        if (r5 == 2) goto L_0x01e9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:98:0x01a2, code lost:
        if (r5 == 3) goto L_0x01da;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:99:0x01a4, code lost:
        if (r5 == 4) goto L_0x01c7;
     */
    /* JADX WARNING: Removed duplicated region for block: B:123:0x0239 A[Catch:{ RuntimeException -> 0x0460 }] */
    /* JADX WARNING: Removed duplicated region for block: B:124:0x023b A[Catch:{ RuntimeException -> 0x0460 }] */
    /* JADX WARNING: Removed duplicated region for block: B:141:0x0297 A[Catch:{ RuntimeException -> 0x0460 }] */
    /* JADX WARNING: Removed duplicated region for block: B:144:0x029e A[Catch:{ RuntimeException -> 0x0460 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzg(java.util.Map<java.lang.String, java.lang.String> r17) {
        /*
            r16 = this;
            r1 = r16
            r0 = r17
            java.lang.Object r2 = r1.lock
            monitor-enter(r2)
            android.app.Activity r3 = r1.zzdqj     // Catch:{ all -> 0x04b6 }
            if (r3 != 0) goto L_0x0012
            java.lang.String r0 = "Not an activity context. Cannot resize."
            r1.zzdt(r0)     // Catch:{ all -> 0x04b6 }
            monitor-exit(r2)     // Catch:{ all -> 0x04b6 }
            return
        L_0x0012:
            com.google.android.gms.internal.ads.zzbfi r3 = r1.zzdkm     // Catch:{ all -> 0x04b6 }
            com.google.android.gms.internal.ads.zzbgx r3 = r3.zzaed()     // Catch:{ all -> 0x04b6 }
            if (r3 != 0) goto L_0x0021
            java.lang.String r0 = "Webview is not yet available, size is not set."
            r1.zzdt(r0)     // Catch:{ all -> 0x04b6 }
            monitor-exit(r2)     // Catch:{ all -> 0x04b6 }
            return
        L_0x0021:
            com.google.android.gms.internal.ads.zzbfi r3 = r1.zzdkm     // Catch:{ all -> 0x04b6 }
            com.google.android.gms.internal.ads.zzbgx r3 = r3.zzaed()     // Catch:{ all -> 0x04b6 }
            boolean r3 = r3.zzafj()     // Catch:{ all -> 0x04b6 }
            if (r3 == 0) goto L_0x0034
            java.lang.String r0 = "Is interstitial. Cannot resize an interstitial."
            r1.zzdt(r0)     // Catch:{ all -> 0x04b6 }
            monitor-exit(r2)     // Catch:{ all -> 0x04b6 }
            return
        L_0x0034:
            com.google.android.gms.internal.ads.zzbfi r3 = r1.zzdkm     // Catch:{ all -> 0x04b6 }
            boolean r3 = r3.zzaek()     // Catch:{ all -> 0x04b6 }
            if (r3 == 0) goto L_0x0043
            java.lang.String r0 = "Cannot resize an expanded banner."
            r1.zzdt(r0)     // Catch:{ all -> 0x04b6 }
            monitor-exit(r2)     // Catch:{ all -> 0x04b6 }
            return
        L_0x0043:
            java.lang.String r3 = "width"
            java.lang.Object r3 = r0.get(r3)     // Catch:{ all -> 0x04b6 }
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3     // Catch:{ all -> 0x04b6 }
            boolean r3 = android.text.TextUtils.isEmpty(r3)     // Catch:{ all -> 0x04b6 }
            if (r3 != 0) goto L_0x0062
            com.google.android.gms.ads.internal.zzr.zzkv()     // Catch:{ all -> 0x04b6 }
            java.lang.String r3 = "width"
            java.lang.Object r3 = r0.get(r3)     // Catch:{ all -> 0x04b6 }
            java.lang.String r3 = (java.lang.String) r3     // Catch:{ all -> 0x04b6 }
            int r3 = com.google.android.gms.ads.internal.util.zzj.zzei(r3)     // Catch:{ all -> 0x04b6 }
            r1.width = r3     // Catch:{ all -> 0x04b6 }
        L_0x0062:
            java.lang.String r3 = "height"
            java.lang.Object r3 = r0.get(r3)     // Catch:{ all -> 0x04b6 }
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3     // Catch:{ all -> 0x04b6 }
            boolean r3 = android.text.TextUtils.isEmpty(r3)     // Catch:{ all -> 0x04b6 }
            if (r3 != 0) goto L_0x0081
            com.google.android.gms.ads.internal.zzr.zzkv()     // Catch:{ all -> 0x04b6 }
            java.lang.String r3 = "height"
            java.lang.Object r3 = r0.get(r3)     // Catch:{ all -> 0x04b6 }
            java.lang.String r3 = (java.lang.String) r3     // Catch:{ all -> 0x04b6 }
            int r3 = com.google.android.gms.ads.internal.util.zzj.zzei(r3)     // Catch:{ all -> 0x04b6 }
            r1.height = r3     // Catch:{ all -> 0x04b6 }
        L_0x0081:
            java.lang.String r3 = "offsetX"
            java.lang.Object r3 = r0.get(r3)     // Catch:{ all -> 0x04b6 }
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3     // Catch:{ all -> 0x04b6 }
            boolean r3 = android.text.TextUtils.isEmpty(r3)     // Catch:{ all -> 0x04b6 }
            if (r3 != 0) goto L_0x00a0
            com.google.android.gms.ads.internal.zzr.zzkv()     // Catch:{ all -> 0x04b6 }
            java.lang.String r3 = "offsetX"
            java.lang.Object r3 = r0.get(r3)     // Catch:{ all -> 0x04b6 }
            java.lang.String r3 = (java.lang.String) r3     // Catch:{ all -> 0x04b6 }
            int r3 = com.google.android.gms.ads.internal.util.zzj.zzei(r3)     // Catch:{ all -> 0x04b6 }
            r1.zzdqy = r3     // Catch:{ all -> 0x04b6 }
        L_0x00a0:
            java.lang.String r3 = "offsetY"
            java.lang.Object r3 = r0.get(r3)     // Catch:{ all -> 0x04b6 }
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3     // Catch:{ all -> 0x04b6 }
            boolean r3 = android.text.TextUtils.isEmpty(r3)     // Catch:{ all -> 0x04b6 }
            if (r3 != 0) goto L_0x00bf
            com.google.android.gms.ads.internal.zzr.zzkv()     // Catch:{ all -> 0x04b6 }
            java.lang.String r3 = "offsetY"
            java.lang.Object r3 = r0.get(r3)     // Catch:{ all -> 0x04b6 }
            java.lang.String r3 = (java.lang.String) r3     // Catch:{ all -> 0x04b6 }
            int r3 = com.google.android.gms.ads.internal.util.zzj.zzei(r3)     // Catch:{ all -> 0x04b6 }
            r1.zzdqz = r3     // Catch:{ all -> 0x04b6 }
        L_0x00bf:
            java.lang.String r3 = "allowOffscreen"
            java.lang.Object r3 = r0.get(r3)     // Catch:{ all -> 0x04b6 }
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3     // Catch:{ all -> 0x04b6 }
            boolean r3 = android.text.TextUtils.isEmpty(r3)     // Catch:{ all -> 0x04b6 }
            if (r3 != 0) goto L_0x00db
            java.lang.String r3 = "allowOffscreen"
            java.lang.Object r3 = r0.get(r3)     // Catch:{ all -> 0x04b6 }
            java.lang.String r3 = (java.lang.String) r3     // Catch:{ all -> 0x04b6 }
            boolean r3 = java.lang.Boolean.parseBoolean(r3)     // Catch:{ all -> 0x04b6 }
            r1.zzdqv = r3     // Catch:{ all -> 0x04b6 }
        L_0x00db:
            java.lang.String r3 = "customClosePosition"
            java.lang.Object r0 = r0.get(r3)     // Catch:{ all -> 0x04b6 }
            java.lang.String r0 = (java.lang.String) r0     // Catch:{ all -> 0x04b6 }
            boolean r3 = android.text.TextUtils.isEmpty(r0)     // Catch:{ all -> 0x04b6 }
            if (r3 != 0) goto L_0x00eb
            r1.zzdqu = r0     // Catch:{ all -> 0x04b6 }
        L_0x00eb:
            int r0 = r1.width     // Catch:{ all -> 0x04b6 }
            r3 = 1
            r4 = 0
            if (r0 < 0) goto L_0x00f7
            int r0 = r1.height     // Catch:{ all -> 0x04b6 }
            if (r0 < 0) goto L_0x00f7
            r0 = 1
            goto L_0x00f8
        L_0x00f7:
            r0 = 0
        L_0x00f8:
            if (r0 != 0) goto L_0x0101
            java.lang.String r0 = "Invalid width and height options. Cannot resize."
            r1.zzdt(r0)     // Catch:{ all -> 0x04b6 }
            monitor-exit(r2)     // Catch:{ all -> 0x04b6 }
            return
        L_0x0101:
            android.app.Activity r0 = r1.zzdqj     // Catch:{ all -> 0x04b6 }
            android.view.Window r0 = r0.getWindow()     // Catch:{ all -> 0x04b6 }
            if (r0 == 0) goto L_0x04af
            android.view.View r5 = r0.getDecorView()     // Catch:{ all -> 0x04b6 }
            if (r5 != 0) goto L_0x0111
            goto L_0x04af
        L_0x0111:
            com.google.android.gms.ads.internal.zzr.zzkv()     // Catch:{ all -> 0x04b6 }
            android.app.Activity r5 = r1.zzdqj     // Catch:{ all -> 0x04b6 }
            int[] r5 = com.google.android.gms.ads.internal.util.zzj.zzg((android.app.Activity) r5)     // Catch:{ all -> 0x04b6 }
            com.google.android.gms.ads.internal.zzr.zzkv()     // Catch:{ all -> 0x04b6 }
            android.app.Activity r6 = r1.zzdqj     // Catch:{ all -> 0x04b6 }
            int[] r6 = com.google.android.gms.ads.internal.util.zzj.zzh((android.app.Activity) r6)     // Catch:{ all -> 0x04b6 }
            r7 = r5[r4]     // Catch:{ all -> 0x04b6 }
            r5 = r5[r3]     // Catch:{ all -> 0x04b6 }
            int r8 = r1.width     // Catch:{ all -> 0x04b6 }
            r9 = 5
            r10 = 4
            r11 = 3
            r12 = -1
            r13 = 2
            r14 = 50
            if (r8 < r14) goto L_0x0231
            int r8 = r1.width     // Catch:{ all -> 0x04b6 }
            if (r8 <= r7) goto L_0x0138
            goto L_0x0231
        L_0x0138:
            int r8 = r1.height     // Catch:{ all -> 0x04b6 }
            if (r8 < r14) goto L_0x022b
            int r8 = r1.height     // Catch:{ all -> 0x04b6 }
            if (r8 <= r5) goto L_0x0142
            goto L_0x022b
        L_0x0142:
            int r8 = r1.height     // Catch:{ all -> 0x04b6 }
            if (r8 != r5) goto L_0x0151
            int r5 = r1.width     // Catch:{ all -> 0x04b6 }
            if (r5 != r7) goto L_0x0151
            java.lang.String r5 = "Cannot resize to a full-screen ad."
            com.google.android.gms.ads.internal.util.zzd.zzez(r5)     // Catch:{ all -> 0x04b6 }
            goto L_0x0236
        L_0x0151:
            boolean r5 = r1.zzdqv     // Catch:{ all -> 0x04b6 }
            if (r5 == 0) goto L_0x0229
            java.lang.String r5 = r1.zzdqu     // Catch:{ all -> 0x04b6 }
            int r8 = r5.hashCode()     // Catch:{ all -> 0x04b6 }
            switch(r8) {
                case -1364013995: goto L_0x0191;
                case -1012429441: goto L_0x0187;
                case -655373719: goto L_0x017d;
                case 1163912186: goto L_0x0173;
                case 1288627767: goto L_0x0169;
                case 1755462605: goto L_0x015f;
                default: goto L_0x015e;
            }     // Catch:{ all -> 0x04b6 }
        L_0x015e:
            goto L_0x019b
        L_0x015f:
            java.lang.String r8 = "top-center"
            boolean r5 = r5.equals(r8)     // Catch:{ all -> 0x04b6 }
            if (r5 == 0) goto L_0x019b
            r5 = 1
            goto L_0x019c
        L_0x0169:
            java.lang.String r8 = "bottom-center"
            boolean r5 = r5.equals(r8)     // Catch:{ all -> 0x04b6 }
            if (r5 == 0) goto L_0x019b
            r5 = 4
            goto L_0x019c
        L_0x0173:
            java.lang.String r8 = "bottom-right"
            boolean r5 = r5.equals(r8)     // Catch:{ all -> 0x04b6 }
            if (r5 == 0) goto L_0x019b
            r5 = 5
            goto L_0x019c
        L_0x017d:
            java.lang.String r8 = "bottom-left"
            boolean r5 = r5.equals(r8)     // Catch:{ all -> 0x04b6 }
            if (r5 == 0) goto L_0x019b
            r5 = 3
            goto L_0x019c
        L_0x0187:
            java.lang.String r8 = "top-left"
            boolean r5 = r5.equals(r8)     // Catch:{ all -> 0x04b6 }
            if (r5 == 0) goto L_0x019b
            r5 = 0
            goto L_0x019c
        L_0x0191:
            java.lang.String r8 = "center"
            boolean r5 = r5.equals(r8)     // Catch:{ all -> 0x04b6 }
            if (r5 == 0) goto L_0x019b
            r5 = 2
            goto L_0x019c
        L_0x019b:
            r5 = -1
        L_0x019c:
            if (r5 == 0) goto L_0x0210
            if (r5 == r3) goto L_0x0200
            if (r5 == r13) goto L_0x01e9
            if (r5 == r11) goto L_0x01da
            if (r5 == r10) goto L_0x01c7
            if (r5 == r9) goto L_0x01b6
            int r5 = r1.zzdqw     // Catch:{ all -> 0x04b6 }
            int r8 = r1.zzdqy     // Catch:{ all -> 0x04b6 }
            int r5 = r5 + r8
            int r8 = r1.width     // Catch:{ all -> 0x04b6 }
            int r5 = r5 + r8
            int r5 = r5 - r14
            int r8 = r1.zzdqx     // Catch:{ all -> 0x04b6 }
            int r15 = r1.zzdqz     // Catch:{ all -> 0x04b6 }
            goto L_0x0219
        L_0x01b6:
            int r5 = r1.zzdqw     // Catch:{ all -> 0x04b6 }
            int r8 = r1.zzdqy     // Catch:{ all -> 0x04b6 }
            int r5 = r5 + r8
            int r8 = r1.width     // Catch:{ all -> 0x04b6 }
            int r5 = r5 + r8
            int r5 = r5 - r14
            int r8 = r1.zzdqx     // Catch:{ all -> 0x04b6 }
            int r15 = r1.zzdqz     // Catch:{ all -> 0x04b6 }
            int r8 = r8 + r15
            int r15 = r1.height     // Catch:{ all -> 0x04b6 }
            goto L_0x01e6
        L_0x01c7:
            int r5 = r1.zzdqw     // Catch:{ all -> 0x04b6 }
            int r8 = r1.zzdqy     // Catch:{ all -> 0x04b6 }
            int r5 = r5 + r8
            int r8 = r1.width     // Catch:{ all -> 0x04b6 }
            int r8 = r8 / r13
            int r5 = r5 + r8
            int r5 = r5 + -25
            int r8 = r1.zzdqx     // Catch:{ all -> 0x04b6 }
            int r15 = r1.zzdqz     // Catch:{ all -> 0x04b6 }
            int r8 = r8 + r15
            int r15 = r1.height     // Catch:{ all -> 0x04b6 }
            goto L_0x01e6
        L_0x01da:
            int r5 = r1.zzdqw     // Catch:{ all -> 0x04b6 }
            int r8 = r1.zzdqy     // Catch:{ all -> 0x04b6 }
            int r5 = r5 + r8
            int r8 = r1.zzdqx     // Catch:{ all -> 0x04b6 }
            int r15 = r1.zzdqz     // Catch:{ all -> 0x04b6 }
            int r8 = r8 + r15
            int r15 = r1.height     // Catch:{ all -> 0x04b6 }
        L_0x01e6:
            int r8 = r8 + r15
            int r8 = r8 - r14
            goto L_0x021a
        L_0x01e9:
            int r5 = r1.zzdqw     // Catch:{ all -> 0x04b6 }
            int r8 = r1.zzdqy     // Catch:{ all -> 0x04b6 }
            int r5 = r5 + r8
            int r8 = r1.width     // Catch:{ all -> 0x04b6 }
            int r8 = r8 / r13
            int r5 = r5 + r8
            int r5 = r5 + -25
            int r8 = r1.zzdqx     // Catch:{ all -> 0x04b6 }
            int r15 = r1.zzdqz     // Catch:{ all -> 0x04b6 }
            int r8 = r8 + r15
            int r15 = r1.height     // Catch:{ all -> 0x04b6 }
            int r15 = r15 / r13
            int r8 = r8 + r15
            int r8 = r8 + -25
            goto L_0x021a
        L_0x0200:
            int r5 = r1.zzdqw     // Catch:{ all -> 0x04b6 }
            int r8 = r1.zzdqy     // Catch:{ all -> 0x04b6 }
            int r5 = r5 + r8
            int r8 = r1.width     // Catch:{ all -> 0x04b6 }
            int r8 = r8 / r13
            int r5 = r5 + r8
            int r5 = r5 + -25
            int r8 = r1.zzdqx     // Catch:{ all -> 0x04b6 }
            int r15 = r1.zzdqz     // Catch:{ all -> 0x04b6 }
            goto L_0x0219
        L_0x0210:
            int r5 = r1.zzdqw     // Catch:{ all -> 0x04b6 }
            int r8 = r1.zzdqy     // Catch:{ all -> 0x04b6 }
            int r5 = r5 + r8
            int r8 = r1.zzdqx     // Catch:{ all -> 0x04b6 }
            int r15 = r1.zzdqz     // Catch:{ all -> 0x04b6 }
        L_0x0219:
            int r8 = r8 + r15
        L_0x021a:
            if (r5 < 0) goto L_0x0236
            int r5 = r5 + r14
            if (r5 > r7) goto L_0x0236
            r5 = r6[r4]     // Catch:{ all -> 0x04b6 }
            if (r8 < r5) goto L_0x0236
            int r8 = r8 + r14
            r5 = r6[r3]     // Catch:{ all -> 0x04b6 }
            if (r8 <= r5) goto L_0x0229
            goto L_0x0236
        L_0x0229:
            r5 = 1
            goto L_0x0237
        L_0x022b:
            java.lang.String r5 = "Height is too small or too large."
            com.google.android.gms.ads.internal.util.zzd.zzez(r5)     // Catch:{ all -> 0x04b6 }
            goto L_0x0236
        L_0x0231:
            java.lang.String r5 = "Width is too small or too large."
            com.google.android.gms.ads.internal.util.zzd.zzez(r5)     // Catch:{ all -> 0x04b6 }
        L_0x0236:
            r5 = 0
        L_0x0237:
            if (r5 != 0) goto L_0x023b
            r5 = 0
            goto L_0x0295
        L_0x023b:
            boolean r5 = r1.zzdqv     // Catch:{ all -> 0x04b6 }
            if (r5 == 0) goto L_0x0250
            int[] r5 = new int[r13]     // Catch:{ all -> 0x04b6 }
            int r6 = r1.zzdqw     // Catch:{ all -> 0x04b6 }
            int r7 = r1.zzdqy     // Catch:{ all -> 0x04b6 }
            int r6 = r6 + r7
            r5[r4] = r6     // Catch:{ all -> 0x04b6 }
            int r6 = r1.zzdqx     // Catch:{ all -> 0x04b6 }
            int r7 = r1.zzdqz     // Catch:{ all -> 0x04b6 }
            int r6 = r6 + r7
            r5[r3] = r6     // Catch:{ all -> 0x04b6 }
            goto L_0x0295
        L_0x0250:
            com.google.android.gms.ads.internal.zzr.zzkv()     // Catch:{ all -> 0x04b6 }
            android.app.Activity r5 = r1.zzdqj     // Catch:{ all -> 0x04b6 }
            int[] r5 = com.google.android.gms.ads.internal.util.zzj.zzg((android.app.Activity) r5)     // Catch:{ all -> 0x04b6 }
            com.google.android.gms.ads.internal.zzr.zzkv()     // Catch:{ all -> 0x04b6 }
            android.app.Activity r6 = r1.zzdqj     // Catch:{ all -> 0x04b6 }
            int[] r6 = com.google.android.gms.ads.internal.util.zzj.zzh((android.app.Activity) r6)     // Catch:{ all -> 0x04b6 }
            r5 = r5[r4]     // Catch:{ all -> 0x04b6 }
            int r7 = r1.zzdqw     // Catch:{ all -> 0x04b6 }
            int r8 = r1.zzdqy     // Catch:{ all -> 0x04b6 }
            int r7 = r7 + r8
            int r8 = r1.zzdqx     // Catch:{ all -> 0x04b6 }
            int r15 = r1.zzdqz     // Catch:{ all -> 0x04b6 }
            int r8 = r8 + r15
            if (r7 >= 0) goto L_0x0272
            r7 = 0
            goto L_0x027b
        L_0x0272:
            int r15 = r1.width     // Catch:{ all -> 0x04b6 }
            int r15 = r15 + r7
            if (r15 <= r5) goto L_0x027b
            int r7 = r1.width     // Catch:{ all -> 0x04b6 }
            int r7 = r5 - r7
        L_0x027b:
            r5 = r6[r4]     // Catch:{ all -> 0x04b6 }
            if (r8 >= r5) goto L_0x0282
            r8 = r6[r4]     // Catch:{ all -> 0x04b6 }
            goto L_0x028f
        L_0x0282:
            int r5 = r1.height     // Catch:{ all -> 0x04b6 }
            int r5 = r5 + r8
            r15 = r6[r3]     // Catch:{ all -> 0x04b6 }
            if (r5 <= r15) goto L_0x028f
            r5 = r6[r3]     // Catch:{ all -> 0x04b6 }
            int r6 = r1.height     // Catch:{ all -> 0x04b6 }
            int r8 = r5 - r6
        L_0x028f:
            int[] r5 = new int[r13]     // Catch:{ all -> 0x04b6 }
            r5[r4] = r7     // Catch:{ all -> 0x04b6 }
            r5[r3] = r8     // Catch:{ all -> 0x04b6 }
        L_0x0295:
            if (r5 != 0) goto L_0x029e
            java.lang.String r0 = "Resize location out of screen or close button is not visible."
            r1.zzdt(r0)     // Catch:{ all -> 0x04b6 }
            monitor-exit(r2)     // Catch:{ all -> 0x04b6 }
            return
        L_0x029e:
            com.google.android.gms.internal.ads.zzww.zzqw()     // Catch:{ all -> 0x04b6 }
            android.app.Activity r6 = r1.zzdqj     // Catch:{ all -> 0x04b6 }
            int r7 = r1.width     // Catch:{ all -> 0x04b6 }
            int r6 = com.google.android.gms.internal.ads.zzbae.zze(r6, r7)     // Catch:{ all -> 0x04b6 }
            com.google.android.gms.internal.ads.zzww.zzqw()     // Catch:{ all -> 0x04b6 }
            android.app.Activity r7 = r1.zzdqj     // Catch:{ all -> 0x04b6 }
            int r8 = r1.height     // Catch:{ all -> 0x04b6 }
            int r7 = com.google.android.gms.internal.ads.zzbae.zze(r7, r8)     // Catch:{ all -> 0x04b6 }
            com.google.android.gms.internal.ads.zzbfi r8 = r1.zzdkm     // Catch:{ all -> 0x04b6 }
            android.view.View r8 = r8.getView()     // Catch:{ all -> 0x04b6 }
            android.view.ViewParent r8 = r8.getParent()     // Catch:{ all -> 0x04b6 }
            if (r8 == 0) goto L_0x04a8
            boolean r15 = r8 instanceof android.view.ViewGroup     // Catch:{ all -> 0x04b6 }
            if (r15 == 0) goto L_0x04a8
            r15 = r8
            android.view.ViewGroup r15 = (android.view.ViewGroup) r15     // Catch:{ all -> 0x04b6 }
            com.google.android.gms.internal.ads.zzbfi r9 = r1.zzdkm     // Catch:{ all -> 0x04b6 }
            android.view.View r9 = r9.getView()     // Catch:{ all -> 0x04b6 }
            r15.removeView(r9)     // Catch:{ all -> 0x04b6 }
            android.widget.PopupWindow r9 = r1.zzdrd     // Catch:{ all -> 0x04b6 }
            if (r9 != 0) goto L_0x0301
            android.view.ViewGroup r8 = (android.view.ViewGroup) r8     // Catch:{ all -> 0x04b6 }
            r1.zzdrf = r8     // Catch:{ all -> 0x04b6 }
            com.google.android.gms.ads.internal.zzr.zzkv()     // Catch:{ all -> 0x04b6 }
            com.google.android.gms.internal.ads.zzbfi r8 = r1.zzdkm     // Catch:{ all -> 0x04b6 }
            android.view.View r8 = r8.getView()     // Catch:{ all -> 0x04b6 }
            android.graphics.Bitmap r8 = com.google.android.gms.ads.internal.util.zzj.zzm(r8)     // Catch:{ all -> 0x04b6 }
            android.widget.ImageView r9 = new android.widget.ImageView     // Catch:{ all -> 0x04b6 }
            android.app.Activity r15 = r1.zzdqj     // Catch:{ all -> 0x04b6 }
            r9.<init>(r15)     // Catch:{ all -> 0x04b6 }
            r1.zzdrb = r9     // Catch:{ all -> 0x04b6 }
            r9.setImageBitmap(r8)     // Catch:{ all -> 0x04b6 }
            com.google.android.gms.internal.ads.zzbfi r8 = r1.zzdkm     // Catch:{ all -> 0x04b6 }
            com.google.android.gms.internal.ads.zzbgx r8 = r8.zzaed()     // Catch:{ all -> 0x04b6 }
            r1.zzdra = r8     // Catch:{ all -> 0x04b6 }
            android.view.ViewGroup r8 = r1.zzdrf     // Catch:{ all -> 0x04b6 }
            android.widget.ImageView r9 = r1.zzdrb     // Catch:{ all -> 0x04b6 }
            r8.addView(r9)     // Catch:{ all -> 0x04b6 }
            goto L_0x0306
        L_0x0301:
            android.widget.PopupWindow r8 = r1.zzdrd     // Catch:{ all -> 0x04b6 }
            r8.dismiss()     // Catch:{ all -> 0x04b6 }
        L_0x0306:
            android.widget.RelativeLayout r8 = new android.widget.RelativeLayout     // Catch:{ all -> 0x04b6 }
            android.app.Activity r9 = r1.zzdqj     // Catch:{ all -> 0x04b6 }
            r8.<init>(r9)     // Catch:{ all -> 0x04b6 }
            r1.zzdre = r8     // Catch:{ all -> 0x04b6 }
            r8.setBackgroundColor(r4)     // Catch:{ all -> 0x04b6 }
            android.widget.RelativeLayout r8 = r1.zzdre     // Catch:{ all -> 0x04b6 }
            android.view.ViewGroup$LayoutParams r9 = new android.view.ViewGroup$LayoutParams     // Catch:{ all -> 0x04b6 }
            r9.<init>(r6, r7)     // Catch:{ all -> 0x04b6 }
            r8.setLayoutParams(r9)     // Catch:{ all -> 0x04b6 }
            com.google.android.gms.ads.internal.zzr.zzkv()     // Catch:{ all -> 0x04b6 }
            android.widget.RelativeLayout r8 = r1.zzdre     // Catch:{ all -> 0x04b6 }
            android.widget.PopupWindow r8 = com.google.android.gms.ads.internal.util.zzj.zza(r8, r6, r7, r4)     // Catch:{ all -> 0x04b6 }
            r1.zzdrd = r8     // Catch:{ all -> 0x04b6 }
            r8.setOutsideTouchable(r3)     // Catch:{ all -> 0x04b6 }
            android.widget.PopupWindow r8 = r1.zzdrd     // Catch:{ all -> 0x04b6 }
            r8.setTouchable(r3)     // Catch:{ all -> 0x04b6 }
            android.widget.PopupWindow r8 = r1.zzdrd     // Catch:{ all -> 0x04b6 }
            boolean r9 = r1.zzdqv     // Catch:{ all -> 0x04b6 }
            if (r9 != 0) goto L_0x0337
            r9 = 1
            goto L_0x0338
        L_0x0337:
            r9 = 0
        L_0x0338:
            r8.setClippingEnabled(r9)     // Catch:{ all -> 0x04b6 }
            android.widget.RelativeLayout r8 = r1.zzdre     // Catch:{ all -> 0x04b6 }
            com.google.android.gms.internal.ads.zzbfi r9 = r1.zzdkm     // Catch:{ all -> 0x04b6 }
            android.view.View r9 = r9.getView()     // Catch:{ all -> 0x04b6 }
            r8.addView(r9, r12, r12)     // Catch:{ all -> 0x04b6 }
            android.widget.LinearLayout r8 = new android.widget.LinearLayout     // Catch:{ all -> 0x04b6 }
            android.app.Activity r9 = r1.zzdqj     // Catch:{ all -> 0x04b6 }
            r8.<init>(r9)     // Catch:{ all -> 0x04b6 }
            r1.zzdrc = r8     // Catch:{ all -> 0x04b6 }
            android.widget.RelativeLayout$LayoutParams r8 = new android.widget.RelativeLayout$LayoutParams     // Catch:{ all -> 0x04b6 }
            com.google.android.gms.internal.ads.zzww.zzqw()     // Catch:{ all -> 0x04b6 }
            android.app.Activity r9 = r1.zzdqj     // Catch:{ all -> 0x04b6 }
            int r9 = com.google.android.gms.internal.ads.zzbae.zze(r9, r14)     // Catch:{ all -> 0x04b6 }
            com.google.android.gms.internal.ads.zzww.zzqw()     // Catch:{ all -> 0x04b6 }
            android.app.Activity r15 = r1.zzdqj     // Catch:{ all -> 0x04b6 }
            int r14 = com.google.android.gms.internal.ads.zzbae.zze(r15, r14)     // Catch:{ all -> 0x04b6 }
            r8.<init>(r9, r14)     // Catch:{ all -> 0x04b6 }
            java.lang.String r9 = r1.zzdqu     // Catch:{ all -> 0x04b6 }
            int r14 = r9.hashCode()     // Catch:{ all -> 0x04b6 }
            switch(r14) {
                case -1364013995: goto L_0x03a2;
                case -1012429441: goto L_0x0398;
                case -655373719: goto L_0x038e;
                case 1163912186: goto L_0x0384;
                case 1288627767: goto L_0x037a;
                case 1755462605: goto L_0x0370;
                default: goto L_0x036f;
            }     // Catch:{ all -> 0x04b6 }
        L_0x036f:
            goto L_0x03ab
        L_0x0370:
            java.lang.String r14 = "top-center"
            boolean r9 = r9.equals(r14)     // Catch:{ all -> 0x04b6 }
            if (r9 == 0) goto L_0x03ab
            r12 = 1
            goto L_0x03ab
        L_0x037a:
            java.lang.String r14 = "bottom-center"
            boolean r9 = r9.equals(r14)     // Catch:{ all -> 0x04b6 }
            if (r9 == 0) goto L_0x03ab
            r12 = 4
            goto L_0x03ab
        L_0x0384:
            java.lang.String r14 = "bottom-right"
            boolean r9 = r9.equals(r14)     // Catch:{ all -> 0x04b6 }
            if (r9 == 0) goto L_0x03ab
            r12 = 5
            goto L_0x03ab
        L_0x038e:
            java.lang.String r14 = "bottom-left"
            boolean r9 = r9.equals(r14)     // Catch:{ all -> 0x04b6 }
            if (r9 == 0) goto L_0x03ab
            r12 = 3
            goto L_0x03ab
        L_0x0398:
            java.lang.String r14 = "top-left"
            boolean r9 = r9.equals(r14)     // Catch:{ all -> 0x04b6 }
            if (r9 == 0) goto L_0x03ab
            r12 = 0
            goto L_0x03ab
        L_0x03a2:
            java.lang.String r14 = "center"
            boolean r9 = r9.equals(r14)     // Catch:{ all -> 0x04b6 }
            if (r9 == 0) goto L_0x03ab
            r12 = 2
        L_0x03ab:
            r9 = 9
            r14 = 10
            if (r12 == 0) goto L_0x03eb
            r15 = 14
            if (r12 == r3) goto L_0x03e4
            if (r12 == r13) goto L_0x03de
            r13 = 12
            if (r12 == r11) goto L_0x03d7
            if (r12 == r10) goto L_0x03d0
            r9 = 11
            r10 = 5
            if (r12 == r10) goto L_0x03c9
            r8.addRule(r14)     // Catch:{ all -> 0x04b6 }
            r8.addRule(r9)     // Catch:{ all -> 0x04b6 }
            goto L_0x03f1
        L_0x03c9:
            r8.addRule(r13)     // Catch:{ all -> 0x04b6 }
            r8.addRule(r9)     // Catch:{ all -> 0x04b6 }
            goto L_0x03f1
        L_0x03d0:
            r8.addRule(r13)     // Catch:{ all -> 0x04b6 }
            r8.addRule(r15)     // Catch:{ all -> 0x04b6 }
            goto L_0x03f1
        L_0x03d7:
            r8.addRule(r13)     // Catch:{ all -> 0x04b6 }
            r8.addRule(r9)     // Catch:{ all -> 0x04b6 }
            goto L_0x03f1
        L_0x03de:
            r9 = 13
            r8.addRule(r9)     // Catch:{ all -> 0x04b6 }
            goto L_0x03f1
        L_0x03e4:
            r8.addRule(r14)     // Catch:{ all -> 0x04b6 }
            r8.addRule(r15)     // Catch:{ all -> 0x04b6 }
            goto L_0x03f1
        L_0x03eb:
            r8.addRule(r14)     // Catch:{ all -> 0x04b6 }
            r8.addRule(r9)     // Catch:{ all -> 0x04b6 }
        L_0x03f1:
            android.widget.LinearLayout r9 = r1.zzdrc     // Catch:{ all -> 0x04b6 }
            com.google.android.gms.internal.ads.zzaqy r10 = new com.google.android.gms.internal.ads.zzaqy     // Catch:{ all -> 0x04b6 }
            r10.<init>(r1)     // Catch:{ all -> 0x04b6 }
            r9.setOnClickListener(r10)     // Catch:{ all -> 0x04b6 }
            android.widget.LinearLayout r9 = r1.zzdrc     // Catch:{ all -> 0x04b6 }
            java.lang.String r10 = "Close button"
            r9.setContentDescription(r10)     // Catch:{ all -> 0x04b6 }
            android.widget.RelativeLayout r9 = r1.zzdre     // Catch:{ all -> 0x04b6 }
            android.widget.LinearLayout r10 = r1.zzdrc     // Catch:{ all -> 0x04b6 }
            r9.addView(r10, r8)     // Catch:{ all -> 0x04b6 }
            android.widget.PopupWindow r8 = r1.zzdrd     // Catch:{ RuntimeException -> 0x0460 }
            android.view.View r0 = r0.getDecorView()     // Catch:{ RuntimeException -> 0x0460 }
            com.google.android.gms.internal.ads.zzww.zzqw()     // Catch:{ RuntimeException -> 0x0460 }
            android.app.Activity r9 = r1.zzdqj     // Catch:{ RuntimeException -> 0x0460 }
            r10 = r5[r4]     // Catch:{ RuntimeException -> 0x0460 }
            int r9 = com.google.android.gms.internal.ads.zzbae.zze(r9, r10)     // Catch:{ RuntimeException -> 0x0460 }
            com.google.android.gms.internal.ads.zzww.zzqw()     // Catch:{ RuntimeException -> 0x0460 }
            android.app.Activity r10 = r1.zzdqj     // Catch:{ RuntimeException -> 0x0460 }
            r11 = r5[r3]     // Catch:{ RuntimeException -> 0x0460 }
            int r10 = com.google.android.gms.internal.ads.zzbae.zze(r10, r11)     // Catch:{ RuntimeException -> 0x0460 }
            r8.showAtLocation(r0, r4, r9, r10)     // Catch:{ RuntimeException -> 0x0460 }
            r0 = r5[r4]     // Catch:{ all -> 0x04b6 }
            r8 = r5[r3]     // Catch:{ all -> 0x04b6 }
            com.google.android.gms.internal.ads.zzari r9 = r1.zzdjk     // Catch:{ all -> 0x04b6 }
            if (r9 == 0) goto L_0x0439
            com.google.android.gms.internal.ads.zzari r9 = r1.zzdjk     // Catch:{ all -> 0x04b6 }
            int r10 = r1.width     // Catch:{ all -> 0x04b6 }
            int r11 = r1.height     // Catch:{ all -> 0x04b6 }
            r9.zza(r0, r8, r10, r11)     // Catch:{ all -> 0x04b6 }
        L_0x0439:
            com.google.android.gms.internal.ads.zzbfi r0 = r1.zzdkm     // Catch:{ all -> 0x04b6 }
            com.google.android.gms.internal.ads.zzbgx r6 = com.google.android.gms.internal.ads.zzbgx.zzs(r6, r7)     // Catch:{ all -> 0x04b6 }
            r0.zza((com.google.android.gms.internal.ads.zzbgx) r6)     // Catch:{ all -> 0x04b6 }
            r0 = r5[r4]     // Catch:{ all -> 0x04b6 }
            r3 = r5[r3]     // Catch:{ all -> 0x04b6 }
            com.google.android.gms.ads.internal.zzr.zzkv()     // Catch:{ all -> 0x04b6 }
            android.app.Activity r5 = r1.zzdqj     // Catch:{ all -> 0x04b6 }
            int[] r5 = com.google.android.gms.ads.internal.util.zzj.zzh((android.app.Activity) r5)     // Catch:{ all -> 0x04b6 }
            r4 = r5[r4]     // Catch:{ all -> 0x04b6 }
            int r3 = r3 - r4
            int r4 = r1.width     // Catch:{ all -> 0x04b6 }
            int r5 = r1.height     // Catch:{ all -> 0x04b6 }
            r1.zzb(r0, r3, r4, r5)     // Catch:{ all -> 0x04b6 }
            java.lang.String r0 = "resized"
            r1.zzdv(r0)     // Catch:{ all -> 0x04b6 }
            monitor-exit(r2)     // Catch:{ all -> 0x04b6 }
            return
        L_0x0460:
            r0 = move-exception
            java.lang.String r3 = "Cannot show popup window: "
            java.lang.String r0 = r0.getMessage()     // Catch:{ all -> 0x04b6 }
            java.lang.String r0 = java.lang.String.valueOf(r0)     // Catch:{ all -> 0x04b6 }
            int r4 = r0.length()     // Catch:{ all -> 0x04b6 }
            if (r4 == 0) goto L_0x0476
            java.lang.String r0 = r3.concat(r0)     // Catch:{ all -> 0x04b6 }
            goto L_0x047b
        L_0x0476:
            java.lang.String r0 = new java.lang.String     // Catch:{ all -> 0x04b6 }
            r0.<init>(r3)     // Catch:{ all -> 0x04b6 }
        L_0x047b:
            r1.zzdt(r0)     // Catch:{ all -> 0x04b6 }
            android.widget.RelativeLayout r0 = r1.zzdre     // Catch:{ all -> 0x04b6 }
            com.google.android.gms.internal.ads.zzbfi r3 = r1.zzdkm     // Catch:{ all -> 0x04b6 }
            android.view.View r3 = r3.getView()     // Catch:{ all -> 0x04b6 }
            r0.removeView(r3)     // Catch:{ all -> 0x04b6 }
            android.view.ViewGroup r0 = r1.zzdrf     // Catch:{ all -> 0x04b6 }
            if (r0 == 0) goto L_0x04a6
            android.view.ViewGroup r0 = r1.zzdrf     // Catch:{ all -> 0x04b6 }
            android.widget.ImageView r3 = r1.zzdrb     // Catch:{ all -> 0x04b6 }
            r0.removeView(r3)     // Catch:{ all -> 0x04b6 }
            android.view.ViewGroup r0 = r1.zzdrf     // Catch:{ all -> 0x04b6 }
            com.google.android.gms.internal.ads.zzbfi r3 = r1.zzdkm     // Catch:{ all -> 0x04b6 }
            android.view.View r3 = r3.getView()     // Catch:{ all -> 0x04b6 }
            r0.addView(r3)     // Catch:{ all -> 0x04b6 }
            com.google.android.gms.internal.ads.zzbfi r0 = r1.zzdkm     // Catch:{ all -> 0x04b6 }
            com.google.android.gms.internal.ads.zzbgx r3 = r1.zzdra     // Catch:{ all -> 0x04b6 }
            r0.zza((com.google.android.gms.internal.ads.zzbgx) r3)     // Catch:{ all -> 0x04b6 }
        L_0x04a6:
            monitor-exit(r2)     // Catch:{ all -> 0x04b6 }
            return
        L_0x04a8:
            java.lang.String r0 = "Webview is detached, probably in the middle of a resize or expand."
            r1.zzdt(r0)     // Catch:{ all -> 0x04b6 }
            monitor-exit(r2)     // Catch:{ all -> 0x04b6 }
            return
        L_0x04af:
            java.lang.String r0 = "Activity context is not ready, cannot get window or decor view."
            r1.zzdt(r0)     // Catch:{ all -> 0x04b6 }
            monitor-exit(r2)     // Catch:{ all -> 0x04b6 }
            return
        L_0x04b6:
            r0 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x04b6 }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzaqz.zzg(java.util.Map):void");
    }

    public final void zzag(boolean z) {
        synchronized (this.lock) {
            if (this.zzdrd != null) {
                this.zzdrd.dismiss();
                this.zzdre.removeView(this.zzdkm.getView());
                if (this.zzdrf != null) {
                    this.zzdrf.removeView(this.zzdrb);
                    this.zzdrf.addView(this.zzdkm.getView());
                    this.zzdkm.zza(this.zzdra);
                }
                if (z) {
                    zzdv("default");
                    if (this.zzdjk != null) {
                        this.zzdjk.zzwb();
                    }
                }
                this.zzdrd = null;
                this.zzdre = null;
                this.zzdrf = null;
                this.zzdrc = null;
            }
        }
    }

    public final void zza(int i, int i2, boolean z) {
        synchronized (this.lock) {
            this.zzdqw = i;
            this.zzdqx = i2;
            PopupWindow popupWindow = this.zzdrd;
        }
    }

    public final boolean zzwa() {
        boolean z;
        synchronized (this.lock) {
            z = this.zzdrd != null;
        }
        return z;
    }

    public final void zzk(int i, int i2) {
        this.zzdqw = i;
        this.zzdqx = i2;
    }
}
