package com.didi.drouter.router;

import android.os.Bundle;
import com.didi.drouter.store.RouterMeta;
import com.didi.drouter.store.RouterStore;
import com.didi.drouter.utils.RouterLogger;
import java.util.Queue;

class InterceptorHandler {
    InterceptorHandler() {
    }

    /* renamed from: a */
    static void m14351a(Request request, RouterMeta routerMeta, IInterceptor iInterceptor) {
        RouterLogger.getCoreLogger().mo59000d(">> Enter request \"%s\" all interceptors", request.getNumber());
        m14353b(InterceptorLoader.m14355a(routerMeta), request, routerMeta, iInterceptor);
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static void m14353b(Queue<IRouterInterceptor> queue, Request request, RouterMeta routerMeta, IInterceptor iInterceptor) {
        IRouterInterceptor poll = queue.poll();
        if (poll == null) {
            RouterLogger.getCoreLogger().mo59000d("<< Pass request \"%s\" all interceptors", request.getNumber());
            iInterceptor.onContinue();
            return;
        }
        RouterMeta routerMeta2 = RouterStore.getInterceptors().get(poll.getClass());
        RouterLogger.getCoreLogger().mo59000d("interceptor \"%s\" execute, for request \"%s\", global:%s, priority:%s", poll.getClass().getSimpleName(), request.getNumber(), Boolean.valueOf(routerMeta2.isGlobal()), Integer.valueOf(routerMeta2.getPriority()));
        final Queue<IRouterInterceptor> queue2 = queue;
        final Request request2 = request;
        final RouterMeta routerMeta3 = routerMeta;
        final IInterceptor iInterceptor2 = iInterceptor;
        final IRouterInterceptor iRouterInterceptor = poll;
        request.f19186h = new IInterceptor() {
            public void onContinue() {
                InterceptorHandler.m14353b(queue2, request2, routerMeta3, iInterceptor2);
            }

            public void onInterrupt() {
                RouterLogger.getCoreLogger().mo59002w("request \"%s\" interrupt by \"%s\"", request2.getNumber(), iRouterInterceptor.getClass().getSimpleName());
                iInterceptor2.onInterrupt();
            }

            public void onRedirect(String str, Bundle... bundleArr) {
                iInterceptor2.onRedirect(str, bundleArr);
            }
        };
        routerMeta.addInterceptorHandled(request.getNumber(), poll);
        poll.handle(request);
    }

    static class Default implements IInterceptor {
        public void onContinue() {
        }

        public void onInterrupt() {
        }

        public void onRedirect(String str, Bundle... bundleArr) {
        }

        Default() {
        }
    }
}
