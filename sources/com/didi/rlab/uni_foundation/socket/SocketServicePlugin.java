package com.didi.rlab.uni_foundation.socket;

import com.didi.rlab.uni_foundation.UniAPI;
import com.didi.rlab.uni_foundation.socket.SocketServicePlugin;
import java.util.HashMap;
import p242io.flutter.plugin.common.BasicMessageChannel;
import p242io.flutter.plugin.common.BinaryMessenger;
import p242io.flutter.plugin.common.StandardMessageCodec;

public class SocketServicePlugin {

    /* renamed from: a */
    private BinaryMessenger f34171a;

    public interface Result<T> {
        void result(T t);
    }

    public void setup(BinaryMessenger binaryMessenger) {
        this.f34171a = binaryMessenger;
        UniAPI.registerModule(this);
    }

    public void onReceivePushMsg(long j, String str, String str2, Result<Void> result) {
        BasicMessageChannel basicMessageChannel = new BasicMessageChannel(this.f34171a, "com.didi.rlab.uni_api.SocketServicePlugin.onReceivePushMsg", new StandardMessageCodec());
        HashMap hashMap = new HashMap();
        hashMap.put("binaryType", Long.valueOf(j));
        hashMap.put("seqId", str);
        hashMap.put("data", str2);
        basicMessageChannel.send(hashMap, new BasicMessageChannel.Reply() {
            public final void reply(Object obj) {
                SocketServicePlugin.Result.this.result(null);
            }
        });
    }
}
