package com.didichuxing.omega.sdk.feedback;

public class JavaVMStackSOF {
    private int stackLength = 1;

    public void stackLeak() {
        this.stackLength++;
        stackLeak();
    }
}
