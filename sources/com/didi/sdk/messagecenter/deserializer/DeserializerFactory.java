package com.didi.sdk.messagecenter.deserializer;

import com.didi.sdk.messagecenter.model.UnifyMessage;
import com.didi.sdk.push.manager.DPushType;

public class DeserializerFactory {
    public static Deserializer getDeserializer(Class cls, String str) {
        if (UnifyMessage.class.isAssignableFrom(cls)) {
            return new UnifyDeserializer();
        }
        if (str.equals(DPushType.TENCENT_PUSH.getName())) {
            return new TencentDeserializer();
        }
        return new GsonDeserializer();
    }
}
