package com.didi.drouter.router;

import com.didi.drouter.store.RouterMeta;

public interface IRouterMonitor {
    void onRequest(Request request, RouterMeta routerMeta, String str);
}
