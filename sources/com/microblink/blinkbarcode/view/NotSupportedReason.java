package com.microblink.blinkbarcode.view;

/* compiled from: line */
public enum NotSupportedReason {
    UNSUPPORTED_ANDROID_VERSION("Current Android version is not supported. SDK requires newer version of Android."),
    NO_CAMERA("Device does not have camera."),
    BLACKLISTED_DEVICE("Device is blacklisted."),
    INVALID_OR_MISSING_LICENSE("Entered license is invalid."),
    CUSTOM_UI_FORBIDDEN("Entered license does not allow using SDK outside of default provided activities."),
    UNSUPPORTED_PROCESSOR_ARCHITECTURE("Device CPU has incompatible architecture.");
    
    private String llIIlIlIIl;

    private NotSupportedReason(String str) {
        this.llIIlIlIIl = str;
    }

    public String getDescription() {
        return this.llIIlIlIIl;
    }
}
