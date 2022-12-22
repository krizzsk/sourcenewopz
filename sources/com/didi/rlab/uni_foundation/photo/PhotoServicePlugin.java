package com.didi.rlab.uni_foundation.photo;

import com.didi.rlab.uni_foundation.UniAPI;
import com.didi.rlab.uni_foundation.photo.PhotoServicePlugin;
import com.didi.rlab.uni_foundation.photo.model.PhotoErrorModel;
import java.util.HashMap;
import p242io.flutter.plugin.common.BasicMessageChannel;
import p242io.flutter.plugin.common.BinaryMessenger;
import p242io.flutter.plugin.common.StandardMessageCodec;

public class PhotoServicePlugin {

    /* renamed from: a */
    private BinaryMessenger f34157a;

    public interface Result<T> {
        void result(T t);
    }

    public void setup(BinaryMessenger binaryMessenger) {
        this.f34157a = binaryMessenger;
        UniAPI.registerModule(this);
    }

    public void sendImageCode(String str, Result<Void> result) {
        BasicMessageChannel basicMessageChannel = new BasicMessageChannel(this.f34157a, "com.didi.rlab.uni_api.PhotoServicePlugin.sendImageCode", new StandardMessageCodec());
        HashMap hashMap = new HashMap();
        hashMap.put("base64Code", str);
        basicMessageChannel.send(hashMap, new BasicMessageChannel.Reply() {
            public final void reply(Object obj) {
                PhotoServicePlugin.Result.this.result(null);
            }
        });
    }

    public void sendCancelEvent(Result<Void> result) {
        new BasicMessageChannel(this.f34157a, "com.didi.rlab.uni_api.PhotoServicePlugin.sendCancelEvent", new StandardMessageCodec()).send(new HashMap(), new BasicMessageChannel.Reply() {
            public final void reply(Object obj) {
                PhotoServicePlugin.Result.this.result(null);
            }
        });
    }

    public void sendPhotoErrorEvent(PhotoErrorModel photoErrorModel, Result<Void> result) {
        BasicMessageChannel basicMessageChannel = new BasicMessageChannel(this.f34157a, "com.didi.rlab.uni_api.PhotoServicePlugin.sendPhotoErrorEvent", new StandardMessageCodec());
        HashMap hashMap = new HashMap();
        hashMap.put("errorModel", photoErrorModel.toMap());
        basicMessageChannel.send(hashMap, new BasicMessageChannel.Reply() {
            public final void reply(Object obj) {
                PhotoServicePlugin.Result.this.result(null);
            }
        });
    }
}
