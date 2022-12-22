package com.didi.sdk.messagecenter.interpreter;

import com.didi.sdk.messagecenter.C12462M;
import com.didi.sdk.messagecenter.annotations.UnifySubscriber;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class UnifyAnnotationsInterpreter extends AnnotationsInterpreter {

    /* renamed from: a */
    private static final Class f36773a = C12462M.UnifyMsg.class;

    /* renamed from: b */
    private static final Map<Class, Integer> f36774b = new LinkedHashMap();

    public Set<String> explainTopic(Class<?> cls) {
        return super.explainTopic(f36773a);
    }

    public String explainType(Class<?> cls) {
        return super.explainType(f36773a);
    }

    public int explainUnifyId(Class<?> cls) {
        UnifySubscriber unifySubscriber;
        if (f36774b.containsKey(cls)) {
            return f36774b.get(cls).intValue();
        }
        if (!cls.isAnnotationPresent(UnifySubscriber.class) || (unifySubscriber = (UnifySubscriber) cls.getAnnotation(UnifySubscriber.class)) == null) {
            return 0;
        }
        int id = unifySubscriber.mo92866id();
        f36774b.put(cls, Integer.valueOf(id));
        return id;
    }
}
