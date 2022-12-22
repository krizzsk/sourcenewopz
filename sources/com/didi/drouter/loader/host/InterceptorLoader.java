package com.didi.drouter.loader.host;

import com.didi.app.router.DRouterUrlInterceptor;
import com.didi.component.common.router.GooglePlayHandler;
import com.didi.drouter.store.MetaLoader;
import com.didi.drouter.store.RouterMeta;
import com.didi.payment.kycservice.interceptor.PixKeyManagerInterceptor;
import com.didi.payment.kycservice.interceptor.SignUpInterceptor;
import java.util.Map;

public class InterceptorLoader extends MetaLoader {
    @Override
    public void load(Map map) {
        map.put(DRouterUrlInterceptor.class, RouterMeta.build(RouterMeta.INTERCEPTOR).assembleInterceptor(DRouterUrlInterceptor.class, 0, true, 0));
        map.put(GooglePlayHandler.class, RouterMeta.build(RouterMeta.INTERCEPTOR).assembleInterceptor(GooglePlayHandler.class, 1, true, 0));
        map.put(PixKeyManagerInterceptor.class, RouterMeta.build(RouterMeta.INTERCEPTOR).assembleInterceptor(PixKeyManagerInterceptor.class, 0, false, 0));
        map.put(SignUpInterceptor.class, RouterMeta.build(RouterMeta.INTERCEPTOR).assembleInterceptor(SignUpInterceptor.class, 0, false, 0));
    }
}
