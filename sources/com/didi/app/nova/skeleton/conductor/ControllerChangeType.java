package com.didi.app.nova.skeleton.conductor;

public enum ControllerChangeType {
    PUSH_ENTER(true, true),
    PUSH_EXIT(true, false),
    POP_ENTER(false, true),
    POP_EXIT(false, false);
    
    public boolean isEnter;
    public boolean isPush;

    private ControllerChangeType(boolean z, boolean z2) {
        this.isPush = z;
        this.isEnter = z2;
    }
}
