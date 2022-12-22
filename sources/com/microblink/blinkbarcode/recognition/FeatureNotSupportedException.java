package com.microblink.blinkbarcode.recognition;

import com.microblink.blinkbarcode.view.NotSupportedReason;

/* compiled from: line */
public class FeatureNotSupportedException extends Exception {
    private NotSupportedReason llIIlIlIIl;

    public FeatureNotSupportedException(NotSupportedReason notSupportedReason) {
        super(notSupportedReason.getDescription());
        this.llIIlIlIIl = notSupportedReason;
    }

    public NotSupportedReason getReason() {
        return this.llIIlIlIIl;
    }

    public FeatureNotSupportedException(NotSupportedReason notSupportedReason, Throwable th) {
        super(notSupportedReason.getDescription(), th);
        this.llIIlIlIIl = notSupportedReason;
    }
}
