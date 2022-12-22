package com.didi.hawaii.p118ar.core;

/* renamed from: com.didi.hawaii.ar.core.BaseDelegate */
public abstract class BaseDelegate {
    protected DiAREngine mAREngine = null;

    public void release() {
    }

    public void attachEngine(DiAREngine diAREngine) {
        this.mAREngine = diAREngine;
    }
}
