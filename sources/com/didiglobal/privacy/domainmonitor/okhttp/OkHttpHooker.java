package com.didiglobal.privacy.domainmonitor.okhttp;

import java.util.ArrayList;
import java.util.List;
import okhttp3.Interceptor;

public class OkHttpHooker {
    public static List<Interceptor> globalNetworkInterceptors = new ArrayList();

    public static void installNetworkInterceptors(Interceptor interceptor) {
        if (interceptor != null) {
            globalNetworkInterceptors.add(interceptor);
        }
    }
}
