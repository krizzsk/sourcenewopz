package com.didi.entrega.uni_entrega_business.privacy;

import com.didi.entrega.uni_entrega_business.UniAPI;
import com.didi.entrega.uni_entrega_business.privacy.GLEUniPrivacyChangeService;
import java.util.HashMap;
import p242io.flutter.plugin.common.BasicMessageChannel;
import p242io.flutter.plugin.common.BinaryMessenger;
import p242io.flutter.plugin.common.StandardMessageCodec;

public class GLEUniPrivacyChangeService {

    /* renamed from: a */
    private BinaryMessenger f21065a;

    public interface Result<T> {
        void result(T t);
    }

    public void setup(BinaryMessenger binaryMessenger) {
        this.f21065a = binaryMessenger;
        UniAPI.registerModule(this);
    }

    public void locationPrivacyChanged(boolean z, Result<Void> result) {
        BasicMessageChannel basicMessageChannel = new BasicMessageChannel(this.f21065a, "com.didi.rlab.uni_api.GLEUniPrivacyChangeService.locationPrivacyChanged", new StandardMessageCodec());
        HashMap hashMap = new HashMap();
        hashMap.put("isEnable", Boolean.valueOf(z));
        basicMessageChannel.send(hashMap, new BasicMessageChannel.Reply() {
            public final void reply(Object obj) {
                GLEUniPrivacyChangeService.Result.this.result(null);
            }
        });
    }
}
