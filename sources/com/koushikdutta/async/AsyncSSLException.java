package com.koushikdutta.async;

public class AsyncSSLException extends Exception {
    private boolean mIgnore = false;

    public AsyncSSLException(Throwable th) {
        super("Peer not trusted by any of the system trust managers.", th);
    }

    public void setIgnore(boolean z) {
        this.mIgnore = z;
    }

    public boolean getIgnore() {
        return this.mIgnore;
    }
}
