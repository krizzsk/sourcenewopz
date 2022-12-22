package com.microblink.blinkbarcode.licence.exception;

/* compiled from: line */
public class LicenceLockedException extends LicenceKeyException {
    public LicenceLockedException() {
        super("Active licence has been remotely locked");
    }
}
