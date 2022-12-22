package com.microblink.blinkbarcode.entities.recognizers.blinkbarcode.pdf417;

import android.os.Parcel;
import android.os.Parcelable;
import com.microblink.blinkbarcode.entities.Entity;
import com.microblink.blinkbarcode.entities.recognizers.Recognizer;
import com.microblink.blinkbarcode.entities.recognizers.blinkbarcode.BarcodeType;
import com.microblink.blinkbarcode.recognition.IlIllIlIIl;

@Deprecated
/* compiled from: line */
public final class Pdf417Recognizer extends Recognizer<Result> {
    public static final Parcelable.Creator<Pdf417Recognizer> CREATOR = new Parcelable.Creator<Pdf417Recognizer>() {
        public Pdf417Recognizer createFromParcel(Parcel parcel) {
            return new Pdf417Recognizer(parcel, Pdf417Recognizer.nativeConstruct());
        }

        public Pdf417Recognizer[] newArray(int i) {
            return new Pdf417Recognizer[i];
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

        private static native int barcodeTypeNativeGet(long j);

        /* access modifiers changed from: private */
        public static native long nativeConstruct();

        private static native long nativeCopy(long j);

        private static native void nativeDeserialize(long j, byte[] bArr);

        private static native void nativeDestruct(long j);

        private static native byte[] nativeSerialize(long j);

        private static native byte[] rawBytesNativeGet(long j);

        private static native String stringDataNativeGet(long j);

        private static native boolean uncertainNativeGet(long j);

        public byte[] IlIllIlIIl() {
            return nativeSerialize(getNativeContext());
        }

        public BarcodeType getBarcodeType() {
            return BarcodeType.values()[barcodeTypeNativeGet(getNativeContext())];
        }

        public byte[] getRawData() {
            return rawBytesNativeGet(getNativeContext());
        }

        public String getStringData() {
            return stringDataNativeGet(getNativeContext());
        }

        public boolean isUncertain() {
            return uncertainNativeGet(getNativeContext());
        }

        public String toString() {
            return getBarcodeType().name() + "\n\n" + getStringData();
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

    private static native long nativeCopy(long j);

    private static native void nativeDeserialize(long j, byte[] bArr);

    private static native void nativeDestruct(long j);

    private static native byte[] nativeSerialize(long j);

    private static native boolean nullQuietZoneAllowedNativeGet(long j);

    private static native void nullQuietZoneAllowedNativeSet(long j, boolean z);

    private static native boolean shouldScanInverseNativeGet(long j);

    private static native void shouldScanInverseNativeSet(long j, boolean z);

    private static native boolean uncertainDecodingNativeGet(long j);

    private static native void uncertainDecodingNativeSet(long j, boolean z);

    public void consumeResultFrom(Entity entity) {
        if (this == entity) {
            return;
        }
        if (entity instanceof Pdf417Recognizer) {
            nativeConsumeResult(getNativeContext(), entity.getResult().getNativeContext());
            return;
        }
        throw new IllegalArgumentException("Parameter type has to be Pdf417Recognizer");
    }

    public boolean isNullQuietZoneAllowed() {
        return nullQuietZoneAllowedNativeGet(getNativeContext());
    }

    public boolean isScanInverse() {
        return shouldScanInverseNativeGet(getNativeContext());
    }

    public boolean isScanUncertain() {
        return uncertainDecodingNativeGet(getNativeContext());
    }

    public void llIIlIlIIl(long j) {
        nativeDestruct(j);
    }

    public void setNullQuietZoneAllowed(boolean z) {
        nullQuietZoneAllowedNativeSet(getNativeContext(), z);
    }

    public void setScanInverse(boolean z) {
        shouldScanInverseNativeSet(getNativeContext(), z);
    }

    public void setScanUncertain(boolean z) {
        uncertainDecodingNativeSet(getNativeContext(), z);
    }

    public Pdf417Recognizer() {
        this(nativeConstruct());
    }

    public byte[] llIIlIlIIl() {
        return nativeSerialize(getNativeContext());
    }

    private Pdf417Recognizer(long j) {
        super(j, new Result(Entity.nativeGetNativeResultContext(j)));
    }

    public void llIIlIlIIl(byte[] bArr) {
        nativeDeserialize(getNativeContext(), bArr);
    }

    private Pdf417Recognizer(Parcel parcel, long j) {
        super(j, new Result(Entity.nativeGetNativeResultContext(j)), parcel);
    }

    public Pdf417Recognizer clone() {
        return new Pdf417Recognizer(nativeCopy(getNativeContext()));
    }
}
