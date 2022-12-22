package com.didichuxing.gbankcard.ocr;

import android.content.Context;
import android.os.Build;
import com.didichuxing.dfbasesdk.utils.BusUtils;
import com.didichuxing.dfbasesdk.utils.LogUtils;
import com.didichuxing.dfbasesdk.utils.UIHandler;
import com.didichuxing.gbankcard.ocr.act.GBankcardOcrAct;
import com.didichuxing.gbankcard.ocr.ottoevent.OcrVerifyDoneEvent;
import java.util.Arrays;

public class ScanCardHelper {
    /* access modifiers changed from: private */
    public static IScanCardCallback sCallback;

    private ScanCardHelper() {
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x005a A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x005b A[RETURN] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean supportScan(android.content.Context r4) {
        /*
            r0 = 0
            android.content.pm.PackageManager r4 = r4.getPackageManager()     // Catch:{ Exception -> 0x004f }
            java.lang.String r1 = "android.hardware.camera"
            boolean r4 = r4.hasSystemFeature(r1)     // Catch:{ Exception -> 0x004f }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x004d }
            r1.<init>()     // Catch:{ Exception -> 0x004d }
            java.lang.String r2 = "sdk camera avail? "
            r1.append(r2)     // Catch:{ Exception -> 0x004d }
            r1.append(r4)     // Catch:{ Exception -> 0x004d }
            java.lang.String r1 = r1.toString()     // Catch:{ Exception -> 0x004d }
            com.didichuxing.dfbasesdk.utils.LogUtils.m33569i(r1)     // Catch:{ Exception -> 0x004d }
            if (r4 == 0) goto L_0x0054
            java.lang.String r1 = "armeabi-v7a"
            boolean r1 = isABISupport(r1)     // Catch:{ Exception -> 0x004d }
            if (r1 != 0) goto L_0x0035
            java.lang.String r1 = "arm64-v8a"
            boolean r1 = isABISupport(r1)     // Catch:{ Exception -> 0x004d }
            if (r1 == 0) goto L_0x0033
            goto L_0x0035
        L_0x0033:
            r1 = 0
            goto L_0x0036
        L_0x0035:
            r1 = 1
        L_0x0036:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x004d }
            r2.<init>()     // Catch:{ Exception -> 0x004d }
            java.lang.String r3 = "sdk v7a/v8a support? "
            r2.append(r3)     // Catch:{ Exception -> 0x004d }
            r2.append(r1)     // Catch:{ Exception -> 0x004d }
            java.lang.String r2 = r2.toString()     // Catch:{ Exception -> 0x004d }
            com.didichuxing.dfbasesdk.utils.LogUtils.m33569i(r2)     // Catch:{ Exception -> 0x004d }
            r4 = r1
            goto L_0x0054
        L_0x004d:
            r1 = move-exception
            goto L_0x0051
        L_0x004f:
            r1 = move-exception
            r4 = 0
        L_0x0051:
            com.didichuxing.dfbasesdk.utils.LogUtils.logStackTrace(r1)
        L_0x0054:
            int r1 = android.os.Build.VERSION.SDK_INT
            r2 = 20
            if (r1 <= r2) goto L_0x005b
            return r4
        L_0x005b:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didichuxing.gbankcard.ocr.ScanCardHelper.supportScan(android.content.Context):boolean");
    }

    private static boolean isABISupport(String str) {
        if (Build.VERSION.SDK_INT >= 21) {
            if (Arrays.asList(Build.SUPPORTED_ABIS).contains(str)) {
                return true;
            }
        } else if (str.equals(Build.CPU_ABI) || str.equals(Build.CPU_ABI2)) {
            return true;
        }
        return false;
    }

    public static void scan(Context context, ScanCardParam scanCardParam, IScanCardCallback iScanCardCallback) {
        LogUtils.m33569i("sdk scan called, sdkVer===1.3.8, param=" + scanCardParam);
        if (iScanCardCallback == null) {
            LogUtils.m33565e("callback==null!!!");
            return;
        }
        sCallback = iScanCardCallback;
        if (context == null) {
            LogUtils.m33565e("context==null!!!");
            notifyCallback(new ScanCardResult(100));
        } else if (scanCardParam == null || !scanCardParam.isValid()) {
            LogUtils.m33565e("param is null or invalid!!!");
            notifyCallback(new ScanCardResult(101));
        } else if (!supportScan(context)) {
            LogUtils.m33565e("device scan not supported!!!");
            notifyCallback(new ScanCardResult(107));
        } else {
            GBankcardOcrAct.start(context, scanCardParam);
        }
    }

    public static void onOcrVerifyDone(final boolean z) {
        UIHandler.post(new Runnable() {
            public void run() {
                LogUtils.m33569i("sdk onOcrVerifyDone called, verifyOk===" + z);
                if (z) {
                    LogUtils.m33569i("clear sCallback 2...");
                    IScanCardCallback unused = ScanCardHelper.sCallback = null;
                }
                BusUtils.post(new OcrVerifyDoneEvent(z));
            }
        });
    }

    public static void notifyCallback(ScanCardResult scanCardResult) {
        LogUtils.m33569i("sdk notifyCallback called, result===" + scanCardResult);
        IScanCardCallback iScanCardCallback = sCallback;
        if (iScanCardCallback != null) {
            iScanCardCallback.onScanResult(scanCardResult);
            if (!scanCardResult.isForceType() || scanCardResult.code != 0) {
                LogUtils.m33569i("clear sCallback...");
                sCallback = null;
                return;
            }
            LogUtils.m33569i("not clear sCallback...");
        }
    }
}
