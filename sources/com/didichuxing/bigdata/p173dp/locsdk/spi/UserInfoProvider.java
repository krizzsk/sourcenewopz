package com.didichuxing.bigdata.p173dp.locsdk.spi;

import com.didichuxing.foundation.spi.ServiceLoader;
import java.util.Iterator;

/* renamed from: com.didichuxing.bigdata.dp.locsdk.spi.UserInfoProvider */
public class UserInfoProvider {

    /* renamed from: a */
    private static IUserInfoProvider f46164a;

    static {
        f46164a = new EmptyProvider();
        try {
            Iterator<S> it = ServiceLoader.load(IUserInfoProvider.class).iterator();
            while (it.hasNext()) {
                IUserInfoProvider iUserInfoProvider = (IUserInfoProvider) it.next();
                if (iUserInfoProvider != null) {
                    f46164a = iUserInfoProvider;
                }
            }
        } catch (Exception unused) {
        }
    }

    public static IUserInfoProvider getDefault() {
        return f46164a;
    }

    /* renamed from: com.didichuxing.bigdata.dp.locsdk.spi.UserInfoProvider$EmptyProvider */
    private static final class EmptyProvider implements IUserInfoProvider {
        public String getPhone() {
            return "";
        }

        public String getPlateNumber() {
            return "";
        }

        public String getToken() {
            return "";
        }

        public String getUid() {
            return "";
        }

        private EmptyProvider() {
        }
    }
}
