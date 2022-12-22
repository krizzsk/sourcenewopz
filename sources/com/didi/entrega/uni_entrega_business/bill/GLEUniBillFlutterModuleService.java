package com.didi.entrega.uni_entrega_business.bill;

import com.didi.entrega.uni_entrega_business.UniAPI;
import com.didi.entrega.uni_entrega_business.bill.GLEUniBillFlutterModuleService;
import java.util.HashMap;
import p242io.flutter.plugin.common.BasicMessageChannel;
import p242io.flutter.plugin.common.BinaryMessenger;
import p242io.flutter.plugin.common.StandardMessageCodec;

public class GLEUniBillFlutterModuleService {

    /* renamed from: a */
    private BinaryMessenger f21062a;

    public interface Result<T> {
        void result(T t);
    }

    public void setup(BinaryMessenger binaryMessenger) {
        this.f21062a = binaryMessenger;
        UniAPI.registerModule(this);
    }

    public void updateBillInfoData(String str, Result<Void> result) {
        BasicMessageChannel basicMessageChannel = new BasicMessageChannel(this.f21062a, "com.didi.rlab.uni_api.GLEUniBillFlutterModuleService.updateBillInfoData", new StandardMessageCodec());
        HashMap hashMap = new HashMap();
        hashMap.put("paramsJson", str);
        basicMessageChannel.send(hashMap, new BasicMessageChannel.Reply() {
            public final void reply(Object obj) {
                GLEUniBillFlutterModuleService.Result.this.result(null);
            }
        });
    }

    public void updatePayChannel4(String str, Result<Void> result) {
        BasicMessageChannel basicMessageChannel = new BasicMessageChannel(this.f21062a, "com.didi.rlab.uni_api.GLEUniBillFlutterModuleService.updatePayChannel4", new StandardMessageCodec());
        HashMap hashMap = new HashMap();
        hashMap.put("paramJson", str);
        basicMessageChannel.send(hashMap, new BasicMessageChannel.Reply() {
            public final void reply(Object obj) {
                GLEUniBillFlutterModuleService.Result.this.result(null);
            }
        });
    }

    public void tiedCardWithPreInterface(String str, Result<Void> result) {
        BasicMessageChannel basicMessageChannel = new BasicMessageChannel(this.f21062a, "com.didi.rlab.uni_api.GLEUniBillFlutterModuleService.tiedCardWithPreInterface", new StandardMessageCodec());
        HashMap hashMap = new HashMap();
        hashMap.put("paramJson", str);
        basicMessageChannel.send(hashMap, new BasicMessageChannel.Reply() {
            public final void reply(Object obj) {
                GLEUniBillFlutterModuleService.Result.this.result(null);
            }
        });
    }
}
