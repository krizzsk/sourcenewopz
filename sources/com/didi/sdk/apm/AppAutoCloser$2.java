package com.didi.sdk.apm;

import com.didi.sdk.apm.utils.RemoteConfiguration;
import com.didi.soda.customer.foundation.tracker.param.ParamConst;
import java.util.concurrent.TimeUnit;

class AppAutoCloser$2 implements Runnable {
    final /* synthetic */ C11877a this$0;

    AppAutoCloser$2(C11877a aVar) {
        this.this$0 = aVar;
    }

    public void run() {
        int intValue = ((Integer) RemoteConfiguration.getCommonConfig("close_delay", -1)).intValue();
        if (intValue > 0) {
            int unused = this.this$0.f34974h = ((Integer) RemoteConfiguration.getCommonConfig(ParamConst.CLOSE_TYPE, 0)).intValue();
            this.this$0.m24715a(TimeUnit.SECONDS.toMillis((long) intValue));
        }
    }
}
