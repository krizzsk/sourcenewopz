package com.didi.dimina.p108v8.debug;

import com.didi.dimina.p108v8.V8Array;
import com.didi.dimina.p108v8.V8Object;

/* renamed from: com.didi.dimina.v8.debug.BreakEvent */
public class BreakEvent extends EventData {
    private static final String SOURCE_COLUMN = "sourceColumn";
    private static final String SOURCE_LINE = "sourceLine";
    private static final String SOURCE_LINE_TEXT = "sourceLineText";

    BreakEvent(V8Object v8Object) {
        super(v8Object);
    }

    public int getSourceLine() {
        return this.v8Object.executeIntegerFunction(SOURCE_LINE, (V8Array) null);
    }

    public int getSourceColumn() {
        return this.v8Object.executeIntegerFunction(SOURCE_COLUMN, (V8Array) null);
    }

    public String getSourceLineText() {
        return this.v8Object.executeStringFunction(SOURCE_LINE_TEXT, (V8Array) null);
    }
}
