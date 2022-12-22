package com.didi.rlab.uni_foundation.location;

import com.didi.rlab.uni_foundation.UniAPI;
import com.didi.rlab.uni_foundation.location.LocationServicePlugin;
import com.didi.soda.customer.blocks.BlocksConst;
import java.util.HashMap;
import p242io.flutter.plugin.common.BasicMessageChannel;
import p242io.flutter.plugin.common.BinaryMessenger;
import p242io.flutter.plugin.common.StandardMessageCodec;

public class LocationServicePlugin {

    /* renamed from: a */
    private BinaryMessenger f34061a;

    public interface Result<T> {
        void result(T t);
    }

    public void setup(BinaryMessenger binaryMessenger) {
        this.f34061a = binaryMessenger;
        UniAPI.registerModule(this);
    }

    public void locationChangeNotification(double d, double d2, Result<Void> result) {
        BasicMessageChannel basicMessageChannel = new BasicMessageChannel(this.f34061a, "com.didi.rlab.uni_api.LocationServicePlugin.locationChangeNotification", new StandardMessageCodec());
        HashMap hashMap = new HashMap();
        hashMap.put("lng", Double.valueOf(d));
        hashMap.put("lat", Double.valueOf(d2));
        basicMessageChannel.send(hashMap, new BasicMessageChannel.Reply() {
            public final void reply(Object obj) {
                LocationServicePlugin.Result.this.result(null);
            }
        });
    }

    public void headingChangeNotification(double d, Result<Void> result) {
        BasicMessageChannel basicMessageChannel = new BasicMessageChannel(this.f34061a, "com.didi.rlab.uni_api.LocationServicePlugin.headingChangeNotification", new StandardMessageCodec());
        HashMap hashMap = new HashMap();
        hashMap.put(BlocksConst.WIDGET_PARAMS_ANGLE, Double.valueOf(d));
        basicMessageChannel.send(hashMap, new BasicMessageChannel.Reply() {
            public final void reply(Object obj) {
                LocationServicePlugin.Result.this.result(null);
            }
        });
    }
}
