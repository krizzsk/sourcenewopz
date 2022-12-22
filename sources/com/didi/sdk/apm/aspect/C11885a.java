package com.didi.sdk.apm.aspect;

import org.aspectj.lang.reflect.SourceLocation;

/* renamed from: com.didi.sdk.apm.aspect.a */
/* compiled from: BaseAspect */
class C11885a {
    C11885a() {
    }

    static String getDisplaySourceLocation(SourceLocation sourceLocation) {
        return sourceLocation.getWithinType().getName() + ":" + sourceLocation.getLine();
    }
}
