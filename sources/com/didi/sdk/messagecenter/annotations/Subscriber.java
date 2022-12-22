package com.didi.sdk.messagecenter.annotations;

import com.didi.sdk.messagecenter.p152pb.MsgType;
import com.didi.sdk.messagecenter.p152pb.PushMessageType;
import com.didi.sdk.push.manager.DPushType;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface Subscriber {
    @Deprecated
    MsgType[] alternativeTopic() default {};

    PushMessageType[] topic() default {};

    DPushType type() default DPushType.TENCENT_PUSH;

    int unifyId() default 0;
}
