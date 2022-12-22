package com.didi.dimina.starbox.module.jsbridge.performance.perfs;

import com.didi.dimina.starbox.module.jsbridge.performance.base.IDataProvider;
import com.didi.dimina.starbox.module.jsbridge.performance.base.IPerformance;
import com.didi.dimina.starbox.p107ui.windowpop.GlobalDispatcher;
import com.didi.dimina.starbox.util.ForegroundChecker;
import java.io.IOException;
import java.io.RandomAccessFile;

public class CPUProvider implements IPerformance<Float>, ForegroundChecker.OnForegroundChange, Runnable {

    /* renamed from: a */
    private IDataProvider<Float> f18076a;

    /* renamed from: b */
    private float f18077b;

    /* renamed from: c */
    private long f18078c;

    /* renamed from: d */
    private long f18079d;

    /* renamed from: e */
    private RandomAccessFile f18080e;

    /* renamed from: f */
    private RandomAccessFile f18081f;

    public void registerProvider(IDataProvider<Float> iDataProvider) {
        this.f18076a = iDataProvider;
        GlobalDispatcher.post(this);
    }

    public void run() {
        float f;
        try {
            f = getFpsByProc();
        } catch (IOException unused) {
            f = Float.parseFloat(C7745a.m13513a("CPU").replaceAll("\\D$", ""));
        }
        if (f <= 0.0f) {
            f = this.f18077b;
        }
        IDataProvider<Float> iDataProvider = this.f18076a;
        this.f18077b = f;
        iDataProvider.onProvide(Float.valueOf(f));
        GlobalDispatcher.postDelay(this, 1000);
    }

    public float getFpsByProc() throws IOException {
        String[] strArr;
        long j;
        if (this.f18080e == null) {
            this.f18080e = new RandomAccessFile("/proc/stat", "r");
        }
        this.f18080e.seek(0);
        String readLine = this.f18080e.readLine();
        if (this.f18081f == null) {
            this.f18081f = new RandomAccessFile("/proc/self/stat", "r");
        }
        this.f18081f.seek(0);
        String readLine2 = this.f18081f.readLine();
        String[] strArr2 = null;
        if (readLine == null || readLine2 == null) {
            strArr = null;
        } else {
            strArr2 = readLine.trim().split("\\s+");
            strArr = readLine2.trim().split("\\s+");
        }
        if (strArr2 != null) {
            if (strArr2.length >= 9) {
                j = 0;
                for (int i = 2; i <= 8; i++) {
                    j += Long.parseLong(strArr2[i]);
                }
            } else {
                j = 0;
            }
            long parseLong = strArr.length >= 15 ? Long.parseLong(strArr[13]) + Long.parseLong(strArr[14]) : 0;
            long j2 = this.f18078c;
            if (j2 != 0) {
                long j3 = this.f18079d;
                if (j3 != 0) {
                    this.f18078c = j;
                    this.f18079d = parseLong;
                    return (float) ((((double) (parseLong - j3)) / ((double) (j - j2))) * 100.0d);
                }
            }
            this.f18078c = j;
            this.f18079d = parseLong;
            return -1.0f;
        }
        throw new IOException("status error");
    }

    public void onChange(boolean z) {
        GlobalDispatcher.removeCallbacks(this);
        if (z) {
            GlobalDispatcher.post(this);
        }
    }
}
