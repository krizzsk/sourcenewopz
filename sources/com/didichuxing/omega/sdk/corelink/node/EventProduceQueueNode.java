package com.didichuxing.omega.sdk.corelink.node;

import android.content.Context;
import com.didichuxing.omega.sdk.common.record.Event;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class EventProduceQueueNode extends Thread {
    private static BlockingQueue<Event> eventQueue = new LinkedBlockingQueue();

    public static void init(Context context) {
        SingletonHolder1.instance.start();
    }

    private static class SingletonHolder1 {
        /* access modifiers changed from: private */
        public static EventProduceQueueNode instance = new EventProduceQueueNode();

        private SingletonHolder1() {
        }
    }

    private EventProduceQueueNode() {
        setName("OmegaSDK.EventProduceQueueThread-" + hashCode());
    }

    public static void add(Event event) {
        eventQueue.offer(event);
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(5:0|1|(1:3)(1:4)|(3:14|15|19)(2:9|(4:11|12|13|18)(1:17))|16) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:0:0x0000 */
    /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
    /* JADX WARNING: Removed duplicated region for block: B:0:0x0000 A[LOOP:0: B:0:0x0000->B:16:0x0000, LOOP_START, MTH_ENTER_BLOCK, SYNTHETIC, Splitter:B:0:0x0000] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void run() {
        /*
            r5 = this;
        L_0x0000:
            boolean r0 = com.didichuxing.omega.sdk.common.OmegaConfig.DEBUG_MODEL     // Catch:{  }
            r1 = 0
            if (r0 == 0) goto L_0x0012
            java.util.ArrayList r0 = new java.util.ArrayList     // Catch:{  }
            r0.<init>()     // Catch:{  }
            java.util.concurrent.BlockingQueue<com.didichuxing.omega.sdk.common.record.Event> r2 = eventQueue     // Catch:{  }
            r3 = 50
            r2.drainTo(r0, r3)     // Catch:{  }
            goto L_0x001d
        L_0x0012:
            java.util.concurrent.BlockingQueue<com.didichuxing.omega.sdk.common.record.Event> r0 = eventQueue     // Catch:{  }
            java.lang.Object r0 = r0.take()     // Catch:{  }
            com.didichuxing.omega.sdk.common.record.Event r0 = (com.didichuxing.omega.sdk.common.record.Event) r0     // Catch:{  }
            r4 = r1
            r1 = r0
            r0 = r4
        L_0x001d:
            if (r1 != 0) goto L_0x0031
            if (r0 == 0) goto L_0x0027
            int r2 = r0.size()     // Catch:{  }
            if (r2 != 0) goto L_0x0031
        L_0x0027:
            boolean r0 = com.didichuxing.omega.sdk.common.OmegaConfig.DEBUG_MODEL     // Catch:{  }
            if (r0 == 0) goto L_0x0000
            r0 = 30
            java.lang.Thread.sleep(r0)     // Catch:{ all -> 0x0000 }
            goto L_0x0000
        L_0x0031:
            com.didichuxing.omega.sdk.corelink.node.EventCollectNode.collectEvent(r0, r1)     // Catch:{  }
            goto L_0x0000
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didichuxing.omega.sdk.corelink.node.EventProduceQueueNode.run():void");
    }
}
