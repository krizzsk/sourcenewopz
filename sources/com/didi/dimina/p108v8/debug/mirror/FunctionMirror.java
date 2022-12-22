package com.didi.dimina.p108v8.debug.mirror;

import com.didi.dimina.p108v8.V8Array;
import com.didi.dimina.p108v8.V8Object;

/* renamed from: com.didi.dimina.v8.debug.mirror.FunctionMirror */
public class FunctionMirror extends ObjectMirror {
    private static final String NAME = "name";
    private static final String SCRIPT = "script";

    public boolean isFunction() {
        return true;
    }

    FunctionMirror(V8Object v8Object) {
        super(v8Object);
    }

    public String getName() {
        return this.v8Object.executeStringFunction("name", (V8Array) null);
    }

    public String getScriptName() {
        V8Object executeObjectFunction = this.v8Object.executeObjectFunction(SCRIPT, (V8Array) null);
        try {
            return executeObjectFunction.executeStringFunction("name", (V8Array) null);
        } finally {
            executeObjectFunction.close();
        }
    }
}
