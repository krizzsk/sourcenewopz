package com.didi.dimina.p108v8.debug;

/* renamed from: com.didi.dimina.v8.debug.StepAction */
public enum StepAction {
    STEP_OUT(0),
    STEP_NEXT(1),
    STEP_IN(2),
    STEP_FRAME(3);
    
    int index;

    private StepAction(int i) {
        this.index = i;
    }
}
