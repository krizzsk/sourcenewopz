package com.didi.entrega.uni_entrega_business.order;

import com.didi.entrega.uni_entrega_business.UniAPI;
import com.didi.entrega.uni_entrega_business.order.GLEUniOrderDataService;
import java.util.HashMap;
import java.util.Map;
import p242io.flutter.plugin.common.BasicMessageChannel;
import p242io.flutter.plugin.common.BinaryMessenger;
import p242io.flutter.plugin.common.StandardMessageCodec;

public class GLEUniOrderDataService {

    /* renamed from: a */
    private BinaryMessenger f21064a;

    public interface Result<T> {
        void result(T t);
    }

    public void setup(BinaryMessenger binaryMessenger) {
        this.f21064a = binaryMessenger;
        UniAPI.registerModule(this);
    }

    public void updateOrderData(String str, Result<Void> result) {
        BasicMessageChannel basicMessageChannel = new BasicMessageChannel(this.f21064a, "com.didi.rlab.uni_api.GLEUniOrderDataService.updateOrderData", new StandardMessageCodec());
        HashMap hashMap = new HashMap();
        hashMap.put("dataJsonStr", str);
        basicMessageChannel.send(hashMap, new BasicMessageChannel.Reply() {
            public final void reply(Object obj) {
                GLEUniOrderDataService.Result.this.result(null);
            }
        });
    }

    public void updateUnreadCount(Map<String, String> map, Result<Void> result) {
        BasicMessageChannel basicMessageChannel = new BasicMessageChannel(this.f21064a, "com.didi.rlab.uni_api.GLEUniOrderDataService.updateUnreadCount", new StandardMessageCodec());
        HashMap hashMap = new HashMap();
        hashMap.put("unreadData", map);
        basicMessageChannel.send(hashMap, new BasicMessageChannel.Reply() {
            public final void reply(Object obj) {
                GLEUniOrderDataService.Result.this.result(null);
            }
        });
    }
}
