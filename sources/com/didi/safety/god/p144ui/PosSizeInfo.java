package com.didi.safety.god.p144ui;

/* renamed from: com.didi.safety.god.ui.PosSizeInfo */
public class PosSizeInfo {
    public int disState;
    public boolean notCentered;

    public boolean notOk() {
        return this.disState > 0 || this.notCentered;
    }
}
