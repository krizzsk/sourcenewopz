package com.didichuxing.bigdata.p173dp.locsdk.impl.p174v3;

import com.didichuxing.bigdata.p173dp.locsdk.DLog;
import java.util.Timer;
import java.util.TimerTask;

/* renamed from: com.didichuxing.bigdata.dp.locsdk.impl.v3.CountsLog */
public class CountsLog {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public String f45793a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public int f45794b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public int f45795c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public int f45796d;

    /* renamed from: e */
    private Timer f45797e;

    public CountsLog(String str, int i) {
        this(str, i, -1);
    }

    public CountsLog(String str, int i, int i2) {
        this.f45793a = str;
        this.f45795c = i;
        this.f45794b = 0;
        this.f45796d = i2;
        m32812a();
    }

    /* renamed from: a */
    private void m32812a() {
        Timer timer = new Timer(this.f45793a);
        this.f45797e = timer;
        timer.schedule(new TimerTask() {
            public void run() {
                if (CountsLog.this.f45794b < CountsLog.this.f45795c && CountsLog.this.f45794b > CountsLog.this.f45796d) {
                    DLog.m32737d(CountsLog.this.f45793a + ", timecount is low, count " + CountsLog.this.f45794b + "/ceil " + CountsLog.this.f45795c + "/floor " + CountsLog.this.f45796d + "/period 60s");
                }
                int unused = CountsLog.this.f45794b = 0;
            }
        }, 60000, 60000);
    }

    public void cancelTimer() {
        Timer timer = this.f45797e;
        if (timer != null) {
            timer.cancel();
            this.f45797e = null;
        }
    }

    public void count() {
        this.f45794b++;
    }
}
