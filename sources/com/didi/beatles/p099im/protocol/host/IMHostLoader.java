package com.didi.beatles.p099im.protocol.host;

import com.didi.beatles.p099im.protocol.service.IMSpiServiceProvider;
import com.didi.beatles.p099im.utils.IMLog;

/* renamed from: com.didi.beatles.im.protocol.host.IMHostLoader */
public class IMHostLoader {

    /* renamed from: a */
    private static final String f9567a = IMHostLoader.class.getSimpleName();

    /* renamed from: b */
    private static final IMHostService f9568b = new IMHostService() {
        public boolean invoke(String str, Object... objArr) {
            return false;
        }
    };

    private IMHostLoader() {
    }

    /* renamed from: a */
    private static IMHostLoader m6483a() {
        return Holder.INSTANCE;
    }

    /* renamed from: com.didi.beatles.im.protocol.host.IMHostLoader$Holder */
    private static final class Holder {
        /* access modifiers changed from: private */
        public static final IMHostLoader INSTANCE = new IMHostLoader();

        private Holder() {
        }
    }

    public static IMHostService getHost() {
        return m6483a().m6484b();
    }

    /* renamed from: b */
    private IMHostService m6484b() {
        IMHostService iMHostService = (IMHostService) IMSpiServiceProvider.getService(IMHostService.class);
        if (iMHostService != null) {
            return iMHostService;
        }
        IMLog.m6632e(f9567a, "[getPlugin] No one plugin implement compiled. -> ");
        return f9568b;
    }
}
