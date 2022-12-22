package com.didi.rlab.uni_foundation.map;

import com.didi.rlab.uni_foundation.UniAPI;
import com.didi.rlab.uni_foundation.map.MapServicePlugin;
import java.util.HashMap;
import p242io.flutter.plugin.common.BasicMessageChannel;
import p242io.flutter.plugin.common.BinaryMessenger;
import p242io.flutter.plugin.common.StandardMessageCodec;

public class MapServicePlugin {

    /* renamed from: a */
    private BinaryMessenger f34074a;

    public interface Result<T> {
        void result(T t);
    }

    public void setup(BinaryMessenger binaryMessenger) {
        this.f34074a = binaryMessenger;
        UniAPI.registerModule(this);
    }

    public void setNavigationState(long j, String str, Result<Void> result) {
        BasicMessageChannel basicMessageChannel = new BasicMessageChannel(this.f34074a, "com.didi.rlab.uni_api.MapServicePlugin.setNavigationState", new StandardMessageCodec());
        HashMap hashMap = new HashMap();
        hashMap.put("state", Long.valueOf(j));
        hashMap.put("message", str);
        basicMessageChannel.send(hashMap, new BasicMessageChannel.Reply() {
            public final void reply(Object obj) {
                MapServicePlugin.Result.this.result(null);
            }
        });
    }

    public void setNavigationInfo(String str, String str2, Result<Void> result) {
        BasicMessageChannel basicMessageChannel = new BasicMessageChannel(this.f34074a, "com.didi.rlab.uni_api.MapServicePlugin.setNavigationInfo", new StandardMessageCodec());
        HashMap hashMap = new HashMap();
        hashMap.put("timeText", str);
        hashMap.put("distanceText", str2);
        basicMessageChannel.send(hashMap, new BasicMessageChannel.Reply() {
            public final void reply(Object obj) {
                MapServicePlugin.Result.this.result(null);
            }
        });
    }

    public void setMapDragDidChange(Result<Void> result) {
        new BasicMessageChannel(this.f34074a, "com.didi.rlab.uni_api.MapServicePlugin.setMapDragDidChange", new StandardMessageCodec()).send(new HashMap(), new BasicMessageChannel.Reply() {
            public final void reply(Object obj) {
                MapServicePlugin.Result.this.result(null);
            }
        });
    }

    public void setMapNavigationDragDidChange(Result<Void> result) {
        new BasicMessageChannel(this.f34074a, "com.didi.rlab.uni_api.MapServicePlugin.setMapNavigationDragDidChange", new StandardMessageCodec()).send(new HashMap(), new BasicMessageChannel.Reply() {
            public final void reply(Object obj) {
                MapServicePlugin.Result.this.result(null);
            }
        });
    }

    public void setMapNavigationFinish(Result<Void> result) {
        new BasicMessageChannel(this.f34074a, "com.didi.rlab.uni_api.MapServicePlugin.setMapNavigationFinish", new StandardMessageCodec()).send(new HashMap(), new BasicMessageChannel.Reply() {
            public final void reply(Object obj) {
                MapServicePlugin.Result.this.result(null);
            }
        });
    }

    public void resetPolygon(boolean z, String str, Result<Void> result) {
        BasicMessageChannel basicMessageChannel = new BasicMessageChannel(this.f34074a, "com.didi.rlab.uni_api.MapServicePlugin.resetPolygon", new StandardMessageCodec());
        HashMap hashMap = new HashMap();
        hashMap.put("isSelect", Boolean.valueOf(z));
        hashMap.put("tag", str);
        basicMessageChannel.send(hashMap, new BasicMessageChannel.Reply() {
            public final void reply(Object obj) {
                MapServicePlugin.Result.this.result(null);
            }
        });
    }

    public void resetMarker(double d, double d2, String str, Result<Void> result) {
        BasicMessageChannel basicMessageChannel = new BasicMessageChannel(this.f34074a, "com.didi.rlab.uni_api.MapServicePlugin.resetMarker", new StandardMessageCodec());
        HashMap hashMap = new HashMap();
        hashMap.put("centerLat", Double.valueOf(d));
        hashMap.put("centerLng", Double.valueOf(d2));
        hashMap.put("tag", str);
        basicMessageChannel.send(hashMap, new BasicMessageChannel.Reply() {
            public final void reply(Object obj) {
                MapServicePlugin.Result.this.result(null);
            }
        });
    }
}
