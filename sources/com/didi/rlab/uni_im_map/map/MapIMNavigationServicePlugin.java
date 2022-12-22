package com.didi.rlab.uni_im_map.map;

import com.didi.rlab.uni_im_map.UniAPI;
import com.didi.rlab.uni_im_map.map.MapIMNavigationServicePlugin;
import java.util.HashMap;
import p242io.flutter.plugin.common.BasicMessageChannel;
import p242io.flutter.plugin.common.BinaryMessenger;
import p242io.flutter.plugin.common.StandardMessageCodec;

public class MapIMNavigationServicePlugin {

    /* renamed from: a */
    private BinaryMessenger f34214a;

    public interface Result<T> {
        void result(T t);
    }

    public void setup(BinaryMessenger binaryMessenger) {
        this.f34214a = binaryMessenger;
        UniAPI.registerModule(this);
    }

    public void setIMNavigationState(long j, String str, Result<Void> result) {
        BasicMessageChannel basicMessageChannel = new BasicMessageChannel(this.f34214a, "com.didi.rlab.uni_api.MapIMNavigationServicePlugin.setIMNavigationState", new StandardMessageCodec());
        HashMap hashMap = new HashMap();
        hashMap.put("state", Long.valueOf(j));
        hashMap.put("message", str);
        basicMessageChannel.send(hashMap, new BasicMessageChannel.Reply() {
            public final void reply(Object obj) {
                MapIMNavigationServicePlugin.Result.this.result(null);
            }
        });
    }

    public void setNavigationInfo(String str, String str2, Result<Void> result) {
        BasicMessageChannel basicMessageChannel = new BasicMessageChannel(this.f34214a, "com.didi.rlab.uni_api.MapIMNavigationServicePlugin.setNavigationInfo", new StandardMessageCodec());
        HashMap hashMap = new HashMap();
        hashMap.put("timeText", str);
        hashMap.put("distanceText", str2);
        basicMessageChannel.send(hashMap, new BasicMessageChannel.Reply() {
            public final void reply(Object obj) {
                MapIMNavigationServicePlugin.Result.this.result(null);
            }
        });
    }

    public void setMapNavigationDragDidChange(Result<Void> result) {
        new BasicMessageChannel(this.f34214a, "com.didi.rlab.uni_api.MapIMNavigationServicePlugin.setMapNavigationDragDidChange", new StandardMessageCodec()).send(new HashMap(), new BasicMessageChannel.Reply() {
            public final void reply(Object obj) {
                MapIMNavigationServicePlugin.Result.this.result(null);
            }
        });
    }

    public void setMapNavigationFinish(Result<Void> result) {
        new BasicMessageChannel(this.f34214a, "com.didi.rlab.uni_api.MapIMNavigationServicePlugin.setMapNavigationFinish", new StandardMessageCodec()).send(new HashMap(), new BasicMessageChannel.Reply() {
            public final void reply(Object obj) {
                MapIMNavigationServicePlugin.Result.this.result(null);
            }
        });
    }
}
