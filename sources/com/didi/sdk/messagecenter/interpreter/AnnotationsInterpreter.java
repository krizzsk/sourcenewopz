package com.didi.sdk.messagecenter.interpreter;

import com.didi.sdk.messagecenter.annotations.Subscriber;
import com.didi.sdk.messagecenter.p152pb.MsgType;
import com.didi.sdk.messagecenter.p152pb.PushMessageType;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class AnnotationsInterpreter implements IInterpreter {

    /* renamed from: a */
    private static final Map<Class, Set<String>> f36771a = new LinkedHashMap();

    /* renamed from: b */
    private static final Map<Class, String> f36772b = new LinkedHashMap();

    public int explainUnifyId(Class<?> cls) {
        return 0;
    }

    public Set<String> explainTopic(Class<?> cls) {
        Subscriber subscriber;
        if (f36771a.containsKey(cls)) {
            return f36771a.get(cls);
        }
        if (!cls.isAnnotationPresent(Subscriber.class) || (subscriber = (Subscriber) cls.getAnnotation(Subscriber.class)) == null) {
            return null;
        }
        HashSet hashSet = new HashSet();
        PushMessageType[] pushMessageTypeArr = subscriber.topic();
        MsgType[] alternativeTopic = subscriber.alternativeTopic();
        if (pushMessageTypeArr != null && pushMessageTypeArr.length > 0) {
            for (PushMessageType pushMessageType : pushMessageTypeArr) {
                hashSet.add(pushMessageType.getValue() + "");
            }
        }
        if (alternativeTopic != null && alternativeTopic.length > 0) {
            for (MsgType msgType : alternativeTopic) {
                hashSet.add(msgType.getValue() + "");
            }
        }
        f36771a.put(cls, hashSet);
        return hashSet;
    }

    public String explainType(Class<?> cls) {
        Subscriber subscriber;
        if (f36772b.containsKey(cls)) {
            return f36772b.get(cls);
        }
        if (!cls.isAnnotationPresent(Subscriber.class) || (subscriber = (Subscriber) cls.getAnnotation(Subscriber.class)) == null) {
            return "";
        }
        String name = subscriber.type().getName();
        f36772b.put(cls, name);
        return name;
    }
}
