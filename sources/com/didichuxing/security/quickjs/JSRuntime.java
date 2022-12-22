package com.didichuxing.security.quickjs;

import java.io.Closeable;

public class JSRuntime implements Closeable {
    private long pointer;
    private final QuickJS quickJS;

    public interface InterruptHandler {
        boolean onInterrupt();
    }

    JSRuntime(long j, QuickJS quickJS2) {
        this.pointer = j;
        this.quickJS = quickJS2;
    }

    private void checkClosed() {
        if (this.pointer == 0) {
            throw new IllegalStateException("The JSRuntime is closed");
        }
    }

    public synchronized void setMallocLimit(int i) {
        checkClosed();
        if (i == 0 || i < -1) {
            throw new IllegalArgumentException("Only positive number and -1 are accepted as malloc limit");
        }
        QuickJS.setRuntimeMallocLimit(this.pointer, i);
    }

    public synchronized void setInterruptHandler(InterruptHandler interruptHandler) {
        checkClosed();
        QuickJS.setRuntimeInterruptHandler(this.pointer, interruptHandler);
    }

    public synchronized JSContext createJSContext() {
        long createContext;
        checkClosed();
        createContext = QuickJS.createContext(this.pointer);
        if (createContext != 0) {
        } else {
            throw new IllegalStateException("Cannot create JSContext instance");
        }
        return new JSContext(createContext, this.quickJS, this);
    }

    public synchronized void close() {
        if (this.pointer != 0) {
            long j = this.pointer;
            this.pointer = 0;
            QuickJS.destroyRuntime(j);
        }
    }
}
