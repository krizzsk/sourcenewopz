package com.didi.sdk.messagecenter.interpreter;

import com.didi.sdk.messagecenter.model.UnifyMessage;

public class InterpreterFactory {
    public static IInterpreter getInterpreter(Class<?> cls) {
        if (UnifyMessage.class.isAssignableFrom(cls)) {
            return new UnifyAnnotationsInterpreter();
        }
        return new AnnotationsInterpreter();
    }
}
