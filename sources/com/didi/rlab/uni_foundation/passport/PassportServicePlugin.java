package com.didi.rlab.uni_foundation.passport;

import com.didi.rlab.uni_foundation.UniAPI;
import com.didi.rlab.uni_foundation.passport.PassportServicePlugin;
import java.util.HashMap;
import p242io.flutter.plugin.common.BasicMessageChannel;
import p242io.flutter.plugin.common.BinaryMessenger;
import p242io.flutter.plugin.common.StandardMessageCodec;

public class PassportServicePlugin {

    /* renamed from: a */
    private BinaryMessenger f34102a;

    public interface Result<T> {
        void result(T t);
    }

    public void setup(BinaryMessenger binaryMessenger) {
        this.f34102a = binaryMessenger;
        UniAPI.registerModule(this);
    }

    public void fetchConfigData(Result<Void> result) {
        new BasicMessageChannel(this.f34102a, "com.didi.rlab.uni_api.PassportServicePlugin.fetchConfigData", new StandardMessageCodec()).send(new HashMap(), new BasicMessageChannel.Reply() {
            public final void reply(Object obj) {
                PassportServicePlugin.Result.this.result(null);
            }
        });
    }

    public void syncPassportInfo(PassportInfo passportInfo, Result<Void> result) {
        BasicMessageChannel basicMessageChannel = new BasicMessageChannel(this.f34102a, "com.didi.rlab.uni_api.PassportServicePlugin.syncPassportInfo", new StandardMessageCodec());
        HashMap hashMap = new HashMap();
        hashMap.put("user", passportInfo.toMap());
        basicMessageChannel.send(hashMap, new BasicMessageChannel.Reply() {
            public final void reply(Object obj) {
                PassportServicePlugin.Result.this.result(null);
            }
        });
    }

    public void logout(Result<Void> result) {
        new BasicMessageChannel(this.f34102a, "com.didi.rlab.uni_api.PassportServicePlugin.logout", new StandardMessageCodec()).send(new HashMap(), new BasicMessageChannel.Reply() {
            public final void reply(Object obj) {
                PassportServicePlugin.Result.this.result(null);
            }
        });
    }

    public void login(Result<Void> result) {
        new BasicMessageChannel(this.f34102a, "com.didi.rlab.uni_api.PassportServicePlugin.login", new StandardMessageCodec()).send(new HashMap(), new BasicMessageChannel.Reply() {
            public final void reply(Object obj) {
                PassportServicePlugin.Result.this.result(null);
            }
        });
    }

    public void passportResult(LoginResult loginResult, Result<Void> result) {
        BasicMessageChannel basicMessageChannel = new BasicMessageChannel(this.f34102a, "com.didi.rlab.uni_api.PassportServicePlugin.passportResult", new StandardMessageCodec());
        HashMap hashMap = new HashMap();
        hashMap.put("result", loginResult.toMap());
        basicMessageChannel.send(hashMap, new BasicMessageChannel.Reply() {
            public final void reply(Object obj) {
                PassportServicePlugin.Result.this.result(null);
            }
        });
    }

    public void fetchRiderInfo(Result<Void> result) {
        new BasicMessageChannel(this.f34102a, "com.didi.rlab.uni_api.PassportServicePlugin.fetchRiderInfo", new StandardMessageCodec()).send(new HashMap(), new BasicMessageChannel.Reply() {
            public final void reply(Object obj) {
                PassportServicePlugin.Result.this.result(null);
            }
        });
    }
}
