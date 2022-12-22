package com.didi.sdk.messagecenter.deserializer;

import com.didi.sdk.messagecenter.model.PushMessage;

public interface Deserializer<T extends PushMessage> {
    T deserialize(byte[] bArr, Class<T> cls);
}
