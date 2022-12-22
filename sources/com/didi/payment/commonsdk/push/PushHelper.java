package com.didi.payment.commonsdk.push;

import com.didi.sdk.apm.SystemUtils;
import com.didi.sdk.util.collection.CollectionUtil;
import com.didichuxing.foundation.spi.ServiceLoader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class PushHelper {
    public static PushHelper instance = new PushHelper();

    /* renamed from: a */
    private Map<String, WPushMsgListener> f30167a = new HashMap();

    private PushHelper() {
    }

    public void loadPushListener() {
        Iterator<S> it = ServiceLoader.load(WPushMsgListener.class).iterator();
        while (it.hasNext()) {
            WPushMsgListener wPushMsgListener = (WPushMsgListener) it.next();
            this.f30167a.put(wPushMsgListener.getClass().getCanonicalName(), wPushMsgListener);
        }
    }

    public void mockPush(int i, String str) {
        if (!CollectionUtil.isEmpty((Map<?, ?>) this.f30167a)) {
            for (Map.Entry next : this.f30167a.entrySet()) {
                try {
                    SystemUtils.log(3, "W_push", "expand push msg to " + next.getValue(), (Throwable) null, "com.didi.payment.commonsdk.push.PushHelper", 38);
                    if (!((WPushMsgListener) next.getValue()).onHandlePushMsg(i, str)) {
                        m21124a(str);
                    }
                } catch (Exception unused) {
                }
            }
        }
    }

    /* renamed from: a */
    private void m21124a(String str) {
        SystemUtils.log(3, "W_push", "send notification", (Throwable) null, "com.didi.payment.commonsdk.push.PushHelper", 50);
    }
}
