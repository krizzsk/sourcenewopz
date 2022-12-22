package com.didiglobal.enginecore.callback;

public abstract class XEReqParamRunnableImpl implements XEReqParamRunnable, Cloneable {
    /* access modifiers changed from: protected */
    public XERunnableCallback runnableCallback;

    public void setRunnableCallback(XERunnableCallback xERunnableCallback) {
        this.runnableCallback = xERunnableCallback;
    }

    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
