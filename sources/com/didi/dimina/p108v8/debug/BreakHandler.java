package com.didi.dimina.p108v8.debug;

import com.didi.dimina.p108v8.V8Object;
import com.didi.dimina.p108v8.debug.DebugHandler;

/* renamed from: com.didi.dimina.v8.debug.BreakHandler */
public interface BreakHandler {
    void onBreak(DebugHandler.DebugEvent debugEvent, ExecutionState executionState, EventData eventData, V8Object v8Object);
}
