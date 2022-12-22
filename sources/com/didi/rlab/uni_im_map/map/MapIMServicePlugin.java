package com.didi.rlab.uni_im_map.map;

import com.didi.rlab.uni_im_map.UniAPI;
import com.didi.rlab.uni_im_map.map.MapIMServicePlugin;
import java.util.HashMap;
import p242io.flutter.plugin.common.BasicMessageChannel;
import p242io.flutter.plugin.common.BinaryMessenger;
import p242io.flutter.plugin.common.StandardMessageCodec;

public class MapIMServicePlugin {

    /* renamed from: a */
    private BinaryMessenger f34215a;

    public interface Result<T> {
        void result(T t);
    }

    public void setup(BinaryMessenger binaryMessenger) {
        this.f34215a = binaryMessenger;
        UniAPI.registerModule(this);
    }

    public void setMapDragStartChange(Result<Void> result) {
        new BasicMessageChannel(this.f34215a, "com.didi.rlab.uni_api.MapIMServicePlugin.setMapDragStartChange", new StandardMessageCodec()).send(new HashMap(), new BasicMessageChannel.Reply() {
            public final void reply(Object obj) {
                MapIMServicePlugin.Result.this.result(null);
            }
        });
    }

    public void setMapDragDidChange(double d, double d2, Result<Void> result) {
        BasicMessageChannel basicMessageChannel = new BasicMessageChannel(this.f34215a, "com.didi.rlab.uni_api.MapIMServicePlugin.setMapDragDidChange", new StandardMessageCodec());
        HashMap hashMap = new HashMap();
        hashMap.put("centerLat", Double.valueOf(d));
        hashMap.put("centerLng", Double.valueOf(d2));
        basicMessageChannel.send(hashMap, new BasicMessageChannel.Reply() {
            public final void reply(Object obj) {
                MapIMServicePlugin.Result.this.result(null);
            }
        });
    }

    public void isCheckOverlap(boolean z, Result<Void> result) {
        BasicMessageChannel basicMessageChannel = new BasicMessageChannel(this.f34215a, "com.didi.rlab.uni_api.MapIMServicePlugin.isCheckOverlap", new StandardMessageCodec());
        HashMap hashMap = new HashMap();
        hashMap.put("isOverlap", Boolean.valueOf(z));
        basicMessageChannel.send(hashMap, new BasicMessageChannel.Reply() {
            public final void reply(Object obj) {
                MapIMServicePlugin.Result.this.result(null);
            }
        });
    }

    public void setLocationInfo(double d, double d2, Result<Void> result) {
        BasicMessageChannel basicMessageChannel = new BasicMessageChannel(this.f34215a, "com.didi.rlab.uni_api.MapIMServicePlugin.setLocationInfo", new StandardMessageCodec());
        HashMap hashMap = new HashMap();
        hashMap.put("centerLat", Double.valueOf(d));
        hashMap.put("centerLng", Double.valueOf(d2));
        basicMessageChannel.send(hashMap, new BasicMessageChannel.Reply() {
            public final void reply(Object obj) {
                MapIMServicePlugin.Result.this.result(null);
            }
        });
    }

    public void reverseGeo(long j, String str, double d, double d2, Result<Void> result) {
        BasicMessageChannel basicMessageChannel = new BasicMessageChannel(this.f34215a, "com.didi.rlab.uni_api.MapIMServicePlugin.reverseGeo", new StandardMessageCodec());
        HashMap hashMap = new HashMap();
        hashMap.put("code", Long.valueOf(j));
        hashMap.put("data", str);
        hashMap.put("lat", Double.valueOf(d));
        hashMap.put("lng", Double.valueOf(d2));
        basicMessageChannel.send(hashMap, new BasicMessageChannel.Reply() {
            public final void reply(Object obj) {
                MapIMServicePlugin.Result.this.result(null);
            }
        });
    }

    public void setCustomerOrderInfo(String str, Result<Void> result) {
        BasicMessageChannel basicMessageChannel = new BasicMessageChannel(this.f34215a, "com.didi.rlab.uni_api.MapIMServicePlugin.setCustomerOrderInfo", new StandardMessageCodec());
        HashMap hashMap = new HashMap();
        hashMap.put("json", str);
        basicMessageChannel.send(hashMap, new BasicMessageChannel.Reply() {
            public final void reply(Object obj) {
                MapIMServicePlugin.Result.this.result(null);
            }
        });
    }
}
