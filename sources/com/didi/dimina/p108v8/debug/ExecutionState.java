package com.didi.dimina.p108v8.debug;

import com.didi.dimina.p108v8.Releasable;
import com.didi.dimina.p108v8.V8Array;
import com.didi.dimina.p108v8.V8Object;
import com.didi.dimina.p108v8.debug.mirror.Frame;

/* renamed from: com.didi.dimina.v8.debug.ExecutionState */
public class ExecutionState implements Releasable {
    private static final String FRAME = "frame";
    private static final String FRAME_COUNT = "frameCount";
    private static final String PREPARE_STEP = "prepareStep";
    private V8Object v8Object;

    ExecutionState(V8Object v8Object2) {
        this.v8Object = v8Object2.twin();
    }

    public int getFrameCount() {
        return this.v8Object.executeIntegerFunction(FRAME_COUNT, (V8Array) null);
    }

    public void prepareStep(StepAction stepAction) {
        V8Array v8Array = new V8Array(this.v8Object.getRuntime());
        v8Array.push(stepAction.index);
        try {
            this.v8Object.executeVoidFunction(PREPARE_STEP, v8Array);
        } finally {
            v8Array.close();
        }
    }

    public Frame getFrame(int i) {
        V8Array v8Array = new V8Array(this.v8Object.getRuntime());
        v8Array.push(i);
        V8Object v8Object2 = null;
        try {
            v8Object2 = this.v8Object.executeObjectFunction("frame", v8Array);
            return new Frame(v8Object2);
        } finally {
            v8Array.close();
            if (v8Object2 != null) {
                v8Object2.close();
            }
        }
    }

    public void close() {
        V8Object v8Object2 = this.v8Object;
        if (v8Object2 != null && !v8Object2.isReleased()) {
            this.v8Object.close();
            this.v8Object = null;
        }
    }

    @Deprecated
    public void release() {
        close();
    }
}
