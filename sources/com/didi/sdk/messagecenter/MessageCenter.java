package com.didi.sdk.messagecenter;

import androidx.lifecycle.LifecycleOwner;
import com.didi.sdk.messagecenter.interfaces.ISubscribe;
import com.didi.sdk.messagecenter.model.PushMessage;
import com.didi.sdk.messagecenter.p152pb.MsgType;
import com.squareup.wire.Message;

public class MessageCenter {
    public static ISubscribe.ISubscribeWrapper bind(Object obj) {
        return C12468b.m26031a().bind(obj);
    }

    public static ISubscribe.ISubscribeWrapper autoBind(LifecycleOwner lifecycleOwner) {
        return C12468b.m26031a().autoBind(lifecycleOwner);
    }

    public static void release(Object obj) {
        C12468b.m26031a().release(obj);
    }

    public static void release(Object obj, Class<? extends PushMessage> cls) {
        C12468b.m26031a().release(obj, cls);
    }

    public static void send(Message message) {
        C12466a.m26019a().mo92858a(message);
    }

    public static void send(MsgType msgType, Message message) {
        C12466a.m26019a().mo92856a(msgType, message);
    }

    public static void send(Message message, PushCallback pushCallback) {
        C12466a.m26019a().mo92859a(message, pushCallback);
    }

    public static void send(MsgType msgType, Message message, PushCallback pushCallback) {
        C12466a.m26019a().mo92857a(msgType, message, pushCallback);
    }
}
