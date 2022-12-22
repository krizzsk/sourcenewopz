package com.didi.sdk.messagecenter.interpreter;

import java.util.Set;

public interface IInterpreter {
    Set<String> explainTopic(Class<?> cls);

    String explainType(Class<?> cls);

    int explainUnifyId(Class<?> cls);
}
