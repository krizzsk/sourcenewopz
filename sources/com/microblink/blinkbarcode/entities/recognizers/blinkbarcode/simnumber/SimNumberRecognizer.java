package com.microblink.blinkbarcode.entities.recognizers.blinkbarcode.simnumber;

import android.os.Parcel;
import android.os.Parcelable;
import com.microblink.blinkbarcode.entities.Entity;
import com.microblink.blinkbarcode.entities.recognizers.Recognizer;
import com.microblink.blinkbarcode.recognition.IlIllIlIIl;

@Deprecated
/* compiled from: line */
public final class SimNumberRecognizer extends Recognizer<Result> {
    public static final Parcelable.Creator<SimNumberRecognizer> CREATOR = new Parcelable.Creator<SimNumberRecognizer>() {
        public SimNumberRecognizer createFromParcel(Parcel parcel) {
            return new SimNumberRecognizer(parcel, SimNumberRecognizer.nativeConstruct());
        }

        public SimNumberRecognizer[] newArray(int i) {
            return new SimNumberRecognizer[i];
        }
    };

    /* compiled from: line */
    public static final class Result extends Recognizer.Result {
        public static final Parcelable.Creator<Result> CREATOR = new Parcelable.Creator<Result>() {
            public Result createFromParcel(Parcel parcel) {
                Result result = new Result(Result.nativeConstruct());
                result.llIIlIlIIl(parcel);
                return result;
            }

            public Result[] newArray(int i) {
                return new Result[i];
            }
        };

        public Result(long j) {
            super(j);
        }

        /* access modifiers changed from: private */
        public static native long nativeConstruct();

        private static native long nativeCopy(long j);

        private static native void nativeDeserialize(long j, byte[] bArr);

        private static native void nativeDestruct(long j);

        private static native byte[] nativeSerialize(long j);

        private static native String simNumberNativeGet(long j);

        public byte[] IlIllIlIIl() {
            return nativeSerialize(getNativeContext());
        }

        public String getSimNumber() {
            return simNumberNativeGet(getNativeContext());
        }

        public String toString() {
            return getSimNumber();
        }

        public void llIIlIlIIl(byte[] bArr) {
            nativeDeserialize(getNativeContext(), bArr);
        }

        public void llIIlIlIIl(long j) {
            nativeDestruct(j);
        }

        public Result clone() {
            return new Result(nativeCopy(getNativeContext()));
        }
    }

    static {
        IlIllIlIIl.llIIlIlIIl();
    }

    /* access modifiers changed from: private */
    public static native long nativeConstruct();

    private static native void nativeConsumeResult(long j, long j2);

    private static native void nativeDestruct(long j);

    public void consumeResultFrom(Entity entity) {
        if (this == entity) {
            return;
        }
        if (entity instanceof SimNumberRecognizer) {
            nativeConsumeResult(getNativeContext(), entity.getResult().getNativeContext());
            return;
        }
        throw new IllegalArgumentException("Parameter type has to be SimNumberRecognizer");
    }

    public void llIIlIlIIl(long j) {
        nativeDestruct(j);
    }

    public void llIIlIlIIl(byte[] bArr) {
    }

    public byte[] llIIlIlIIl() {
        return null;
    }

    public SimNumberRecognizer() {
        this(nativeConstruct());
    }

    private SimNumberRecognizer(long j) {
        super(j, new Result(Entity.nativeGetNativeResultContext(j)));
    }

    private SimNumberRecognizer(Parcel parcel, long j) {
        super(j, new Result(Entity.nativeGetNativeResultContext(j)), parcel);
    }

    public SimNumberRecognizer clone() {
        return new SimNumberRecognizer(nativeConstruct());
    }
}
