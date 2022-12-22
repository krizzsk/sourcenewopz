package com.koushikdutta.async;

import com.koushikdutta.async.callback.CompletedCallback;
import com.koushikdutta.async.callback.DataCallback;

public abstract class DataEmitterBase implements DataEmitter {
    CompletedCallback endCallback;
    private boolean ended;
    DataCallback mDataCallback;

    public String charset() {
        return null;
    }

    /* access modifiers changed from: protected */
    public void report(Exception exc) {
        if (!this.ended) {
            this.ended = true;
            if (getEndCallback() != null) {
                getEndCallback().onCompleted(exc);
            }
        }
    }

    public final void setEndCallback(CompletedCallback completedCallback) {
        this.endCallback = completedCallback;
    }

    public final CompletedCallback getEndCallback() {
        return this.endCallback;
    }

    public void setDataCallback(DataCallback dataCallback) {
        this.mDataCallback = dataCallback;
    }

    public DataCallback getDataCallback() {
        return this.mDataCallback;
    }
}
