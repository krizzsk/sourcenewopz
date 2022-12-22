package com.didi.travel.psnger.common.push;

import com.didi.sdk.messagecenter.model.BaseMessage;
import com.didi.sdk.messagecenter.util.JsonFormat;
import com.didi.travel.psnger.utils.GsonUtil;

public class MessageParser<T> {

    /* renamed from: a */
    private Class<T> f44067a;

    public MessageParser(Class<T> cls) {
        this.f44067a = cls;
    }

    public T parse(BaseMessage baseMessage) {
        return GsonUtil.objectFromJson(JsonFormat.toJson(baseMessage.msg), this.f44067a);
    }
}
