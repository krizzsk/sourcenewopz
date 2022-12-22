package com.microblink.blinkbarcode.entities.recognizers;

import android.os.Parcel;
import com.microblink.blinkbarcode.entities.Entity;
import com.microblink.blinkbarcode.entities.recognizers.Recognizer.Result;

/* compiled from: line */
public abstract class Recognizer<T extends Result> extends Entity<T> {

    /* compiled from: line */
    public static abstract class Result extends Entity.Result {

        /* compiled from: line */
        public enum State {
            Empty,
            Uncertain,
            Valid,
            StageValid
        }

        public Result(long j) {
            super(j);
        }

        private static native int nativeGetState(long j);

        public abstract Result clone();

        public State getResultState() {
            return State.values()[nativeGetState(getNativeContext())];
        }

        public final boolean llIIlIlIIl() {
            return getResultState() == State.Empty;
        }
    }

    public Recognizer(long j, T t) {
        super(j, t);
    }

    private static native String nativeGetType(long j);

    private static native boolean nativeIsExcludedFromPing(long j);

    private static native boolean nativeRequiresAutofocus(long j);

    private static native boolean nativeRequiresLandscapeMode(long j);

    public abstract Recognizer clone();

    public String getName() {
        return nativeGetType(getNativeContext());
    }

    public boolean isExcludedFromPing() {
        return nativeIsExcludedFromPing(getNativeContext());
    }

    public boolean requiresAutofocus() {
        return nativeRequiresAutofocus(getNativeContext());
    }

    public boolean requiresLandscapeMode() {
        return nativeRequiresLandscapeMode(getNativeContext());
    }

    public Recognizer(long j, T t, Parcel parcel) {
        super(j, t, parcel);
    }
}
