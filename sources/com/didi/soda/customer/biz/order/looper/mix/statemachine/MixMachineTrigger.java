package com.didi.soda.customer.biz.order.looper.mix.statemachine;

import android.os.Handler;
import com.didi.soda.customer.biz.order.looper.mix.statemachine.IMixMachineTrigger;
import com.didi.soda.customer.foundation.log.util.LogUtil;

public class MixMachineTrigger implements IMixMachineTrigger {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public Handler f40427a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public IMixMachineTrigger.OnTriggerListener f40428b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public int f40429c = 3000;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public Runnable f40430d = new Runnable() {
        public void run() {
            if (MixMachineTrigger.this.f40428b != null) {
                MixMachineTrigger.this.f40428b.doTrigger();
            }
            MixMachineTrigger.this.f40427a.postDelayed(MixMachineTrigger.this.f40430d, (long) MixMachineTrigger.this.f40429c);
        }
    };

    public void onCreate() {
        LogUtil.m29100d("Looper", "MixMachineTrigger--> onCreate");
        this.f40427a = new Handler();
    }

    public void onDestroy() {
        LogUtil.m29100d("Looper", "MixMachineTrigger--> onDestroy");
        this.f40427a.removeCallbacks(this.f40430d);
        this.f40427a = null;
        this.f40428b = null;
    }

    public void setInterval(int i) {
        this.f40429c = i;
        if (i < 3000) {
            this.f40429c = 3000;
        }
    }

    public void setTriggerListener(IMixMachineTrigger.OnTriggerListener onTriggerListener) {
        this.f40428b = onTriggerListener;
    }

    public void start() {
        LogUtil.m29100d("Looper", "MixMachineTrigger--> start");
        this.f40427a.post(this.f40430d);
    }

    public void stop() {
        LogUtil.m29100d("Looper", "MixMachineTrigger--> stop");
        this.f40427a.removeCallbacks(this.f40430d);
    }
}
