package com.didichuxing.omega.sdk.anr;

import android.os.FileObserver;
import com.didichuxing.omega.sdk.common.backend.AppStateMonitor;
import com.didichuxing.omega.sdk.common.backend.ScreenChangeReceiver;
import java.util.Timer;
import java.util.TimerTask;

public class ANRFileObserver extends FileObserver {
    private boolean anrProcessing = false;
    private boolean isMyAppAnr = false;
    private String mPath;
    private Timer mTimer;

    public ANRFileObserver(String str) {
        super(str);
        this.mPath = str;
    }

    public void onEvent(int i, String str) {
        if (this.isMyAppAnr) {
            ANRTrace.setIsTracedNewAnrFileForMyApp(true);
        }
        if (i == 1024) {
            if (!this.anrProcessing) {
                if (!AppStateMonitor.getInstance().isInForeground() || ScreenChangeReceiver.SCREEN_STATE != ScreenChangeReceiver.ScreenState.ON) {
                    ANRTrace.restartObserver(false);
                } else {
                    ANRTrace.restartObserver(true);
                }
            }
        } else if (i == 16 && this.isMyAppAnr) {
            this.anrProcessing = true;
            Timer timer = new Timer(true);
            this.mTimer = timer;
            timer.schedule(new TimerTask() {
                public void run() {
                    ANRTrace.reportANR();
                }
            }, 0);
        }
    }

    public void setMyAppAnr(boolean z) {
        this.isMyAppAnr = z;
    }

    public void setAnrProcessing(boolean z) {
        this.anrProcessing = z;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0057, code lost:
        r2 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:?, code lost:
        r3.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x005d, code lost:
        r1 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x005e, code lost:
        r3 = new java.lang.StringBuilder();
     */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x009b A[SYNTHETIC, Splitter:B:38:0x009b] */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x00c4 A[SYNTHETIC, Splitter:B:47:0x00c4] */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x00d3 A[SYNTHETIC, Splitter:B:54:0x00d3] */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:35:0x0081=Splitter:B:35:0x0081, B:44:0x00aa=Splitter:B:44:0x00aa} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean containMyAppStack() {
        /*
            r9 = this;
            java.lang.String r0 = "close file read fail:"
            r1 = 0
            r2 = 0
            java.io.BufferedReader r3 = new java.io.BufferedReader     // Catch:{ FileNotFoundException -> 0x00a6, IOException -> 0x007d, all -> 0x0079 }
            java.io.FileReader r4 = new java.io.FileReader     // Catch:{ FileNotFoundException -> 0x00a6, IOException -> 0x007d, all -> 0x0079 }
            java.io.File r5 = new java.io.File     // Catch:{ FileNotFoundException -> 0x00a6, IOException -> 0x007d, all -> 0x0079 }
            java.lang.String r6 = r9.mPath     // Catch:{ FileNotFoundException -> 0x00a6, IOException -> 0x007d, all -> 0x0079 }
            r5.<init>(r6)     // Catch:{ FileNotFoundException -> 0x00a6, IOException -> 0x007d, all -> 0x0079 }
            r4.<init>(r5)     // Catch:{ FileNotFoundException -> 0x00a6, IOException -> 0x007d, all -> 0x0079 }
            r3.<init>(r4)     // Catch:{ FileNotFoundException -> 0x00a6, IOException -> 0x007d, all -> 0x0079 }
        L_0x0015:
            java.lang.String r1 = r3.readLine()     // Catch:{ FileNotFoundException -> 0x0077, IOException -> 0x0075 }
            r4 = 1
            if (r1 == 0) goto L_0x0058
            int r5 = com.didichuxing.omega.sdk.common.OmegaConfig.ANR_FILTER_TYPE     // Catch:{ FileNotFoundException -> 0x0077, IOException -> 0x0075 }
            java.lang.String r6 = "Cmd line: "
            if (r5 != r4) goto L_0x003c
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ FileNotFoundException -> 0x0077, IOException -> 0x0075 }
            r5.<init>()     // Catch:{ FileNotFoundException -> 0x0077, IOException -> 0x0075 }
            r5.append(r6)     // Catch:{ FileNotFoundException -> 0x0077, IOException -> 0x0075 }
            java.lang.String r7 = com.didichuxing.omega.sdk.common.collector.PackageCollector.getPkgName()     // Catch:{ FileNotFoundException -> 0x0077, IOException -> 0x0075 }
            r5.append(r7)     // Catch:{ FileNotFoundException -> 0x0077, IOException -> 0x0075 }
            java.lang.String r5 = r5.toString()     // Catch:{ FileNotFoundException -> 0x0077, IOException -> 0x0075 }
            int r5 = r1.indexOf(r5)     // Catch:{ FileNotFoundException -> 0x0077, IOException -> 0x0075 }
            if (r5 < 0) goto L_0x003c
            goto L_0x0057
        L_0x003c:
            int r5 = com.didichuxing.omega.sdk.common.OmegaConfig.ANR_FILTER_TYPE     // Catch:{ FileNotFoundException -> 0x0077, IOException -> 0x0075 }
            r7 = 2
            if (r5 != r7) goto L_0x0052
            int r5 = r1.indexOf(r6)     // Catch:{ FileNotFoundException -> 0x0077, IOException -> 0x0075 }
            if (r5 < 0) goto L_0x0052
            java.lang.String r5 = com.didichuxing.omega.sdk.common.collector.PackageCollector.getPkgName()     // Catch:{ FileNotFoundException -> 0x0077, IOException -> 0x0075 }
            int r1 = r1.indexOf(r5)     // Catch:{ FileNotFoundException -> 0x0077, IOException -> 0x0075 }
            if (r1 <= 0) goto L_0x0058
            goto L_0x0057
        L_0x0052:
            int r1 = com.didichuxing.omega.sdk.common.OmegaConfig.ANR_FILTER_TYPE     // Catch:{ FileNotFoundException -> 0x0077, IOException -> 0x0075 }
            r5 = 3
            if (r1 != r5) goto L_0x0015
        L_0x0057:
            r2 = 1
        L_0x0058:
            r3.close()     // Catch:{ IOException -> 0x005d }
            goto L_0x00cf
        L_0x005d:
            r1 = move-exception
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
        L_0x0063:
            r3.append(r0)
            java.lang.String r0 = r1.getMessage()
            r3.append(r0)
            java.lang.String r0 = r3.toString()
            com.didichuxing.omega.sdk.common.utils.OLog.m34767v(r0)
            goto L_0x00cf
        L_0x0075:
            r1 = move-exception
            goto L_0x0081
        L_0x0077:
            r1 = move-exception
            goto L_0x00aa
        L_0x0079:
            r2 = move-exception
            r3 = r1
            r1 = r2
            goto L_0x00d1
        L_0x007d:
            r3 = move-exception
            r8 = r3
            r3 = r1
            r1 = r8
        L_0x0081:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x00d0 }
            r4.<init>()     // Catch:{ all -> 0x00d0 }
            java.lang.String r5 = "read trace file fail:"
            r4.append(r5)     // Catch:{ all -> 0x00d0 }
            java.lang.String r1 = r1.getMessage()     // Catch:{ all -> 0x00d0 }
            r4.append(r1)     // Catch:{ all -> 0x00d0 }
            java.lang.String r1 = r4.toString()     // Catch:{ all -> 0x00d0 }
            com.didichuxing.omega.sdk.common.utils.OLog.m34767v(r1)     // Catch:{ all -> 0x00d0 }
            if (r3 == 0) goto L_0x00cf
            r3.close()     // Catch:{ IOException -> 0x009f }
            goto L_0x00cf
        L_0x009f:
            r1 = move-exception
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            goto L_0x0063
        L_0x00a6:
            r3 = move-exception
            r8 = r3
            r3 = r1
            r1 = r8
        L_0x00aa:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x00d0 }
            r4.<init>()     // Catch:{ all -> 0x00d0 }
            java.lang.String r5 = "trace file not found!"
            r4.append(r5)     // Catch:{ all -> 0x00d0 }
            java.lang.String r1 = r1.getMessage()     // Catch:{ all -> 0x00d0 }
            r4.append(r1)     // Catch:{ all -> 0x00d0 }
            java.lang.String r1 = r4.toString()     // Catch:{ all -> 0x00d0 }
            com.didichuxing.omega.sdk.common.utils.OLog.m34767v(r1)     // Catch:{ all -> 0x00d0 }
            if (r3 == 0) goto L_0x00cf
            r3.close()     // Catch:{ IOException -> 0x00c8 }
            goto L_0x00cf
        L_0x00c8:
            r1 = move-exception
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            goto L_0x0063
        L_0x00cf:
            return r2
        L_0x00d0:
            r1 = move-exception
        L_0x00d1:
            if (r3 == 0) goto L_0x00ee
            r3.close()     // Catch:{ IOException -> 0x00d7 }
            goto L_0x00ee
        L_0x00d7:
            r2 = move-exception
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            r3.append(r0)
            java.lang.String r0 = r2.getMessage()
            r3.append(r0)
            java.lang.String r0 = r3.toString()
            com.didichuxing.omega.sdk.common.utils.OLog.m34767v(r0)
        L_0x00ee:
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didichuxing.omega.sdk.anr.ANRFileObserver.containMyAppStack():boolean");
    }
}
