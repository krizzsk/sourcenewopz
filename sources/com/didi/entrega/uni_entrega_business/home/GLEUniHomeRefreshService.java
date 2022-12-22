package com.didi.entrega.uni_entrega_business.home;

import com.didi.entrega.uni_entrega_business.UniAPI;
import com.didi.entrega.uni_entrega_business.home.GLEUniHomeRefreshService;
import java.util.HashMap;
import java.util.List;
import p242io.flutter.plugin.common.BasicMessageChannel;
import p242io.flutter.plugin.common.BinaryMessenger;
import p242io.flutter.plugin.common.StandardMessageCodec;

public class GLEUniHomeRefreshService {

    /* renamed from: a */
    private BinaryMessenger f21063a;

    public interface Result<T> {
        void result(T t);
    }

    public void setup(BinaryMessenger binaryMessenger) {
        this.f21063a = binaryMessenger;
        UniAPI.registerModule(this);
    }

    public void homepageRequestEnd(List<String> list, Result<Void> result) {
        BasicMessageChannel basicMessageChannel = new BasicMessageChannel(this.f21063a, "com.didi.rlab.uni_api.GLEUniHomeRefreshService.homepageRequestEnd", new StandardMessageCodec());
        HashMap hashMap = new HashMap();
        hashMap.put("orderIds", list);
        basicMessageChannel.send(hashMap, new BasicMessageChannel.Reply() {
            public final void reply(Object obj) {
                GLEUniHomeRefreshService.Result.this.result(null);
            }
        });
    }
}
