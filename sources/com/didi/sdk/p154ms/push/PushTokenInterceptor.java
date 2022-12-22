package com.didi.sdk.p154ms.push;

import android.content.Context;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* renamed from: com.didi.sdk.ms.push.PushTokenInterceptor */
public class PushTokenInterceptor {
    private static Set<Interceptor> mInterceptor;

    /* renamed from: com.didi.sdk.ms.push.PushTokenInterceptor$Interceptor */
    public interface Interceptor {
        void onNewToken(Context context, String str, String str2);
    }

    public static synchronized boolean addInterceptor(Interceptor interceptor) {
        synchronized (PushTokenInterceptor.class) {
            if (interceptor == null) {
                return false;
            }
            if (mInterceptor == null) {
                mInterceptor = new HashSet();
            }
            boolean add = mInterceptor.add(interceptor);
            return add;
        }
    }

    public static synchronized boolean removeInterceptor(Interceptor interceptor) {
        synchronized (PushTokenInterceptor.class) {
            if (interceptor == null) {
                return false;
            }
            boolean remove = mInterceptor.remove(interceptor);
            return remove;
        }
    }

    public static synchronized List<Interceptor> getInterceptors() {
        synchronized (PushTokenInterceptor.class) {
            if (mInterceptor == null) {
                return null;
            }
            ArrayList arrayList = new ArrayList(mInterceptor);
            return arrayList;
        }
    }
}
