package com.microblink.blinkbarcode.entities.recognizers.blinkbarcode.barcode;

import android.os.Parcel;
import android.os.Parcelable;
import com.microblink.blinkbarcode.entities.Entity;
import com.microblink.blinkbarcode.entities.recognizers.Recognizer;
import com.microblink.blinkbarcode.entities.recognizers.blinkbarcode.BarcodeType;
import com.microblink.blinkbarcode.recognition.IlIllIlIIl;

/* compiled from: line */
public final class BarcodeRecognizer extends Recognizer<Result> {
    public static final Parcelable.Creator<BarcodeRecognizer> CREATOR = new Parcelable.Creator<BarcodeRecognizer>() {
        public BarcodeRecognizer createFromParcel(Parcel parcel) {
            return new BarcodeRecognizer(parcel, BarcodeRecognizer.nativeConstruct());
        }

        public BarcodeRecognizer[] newArray(int i) {
            return new BarcodeRecognizer[i];
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

    private static native boolean autoScaleDetectionNativeGet(long j);

    private static native void autoScaleDetectionNativeSet(long j, boolean z);

    private static native boolean aztecNativeGet(long j);

    private static native void aztecNativeSet(long j, boolean z);

    private static native boolean code128NativeGet(long j);

    private static native void code128NativeSet(long j, boolean z);

    private static native boolean code39NativeGet(long j);

    private static native void code39NativeSet(long j, boolean z);

    private static native boolean dataMatrixNativeGet(long j);

    private static native void dataMatrixNativeSet(long j, boolean z);

    private static native boolean ean13NativeGet(long j);

    private static native void ean13NativeSet(long j, boolean z);

    private static native boolean ean8NativeGet(long j);

    private static native void ean8NativeSet(long j, boolean z);

    private static native boolean itfNativeGet(long j);

    private static native void itfNativeSet(long j, boolean z);

    /* access modifiers changed from: private */
    public static native long nativeConstruct();

    private static native void nativeConsumeResult(long j, long j2);

    private static native long nativeCopy(long j);

    private static native void nativeDeserialize(long j, byte[] bArr);

    private static native void nativeDestruct(long j);

    private static native byte[] nativeSerialize(long j);

    private static native boolean nullQuietZoneAllowedNativeGet(long j);

    private static native void nullQuietZoneAllowedNativeSet(long j, boolean z);

    private static native boolean pdf417NativeGet(long j);

    private static native void pdf417NativeSet(long j, boolean z);

    private static native boolean qrcodeNativeGet(long j);

    private static native void qrcodeNativeSet(long j, boolean z);

    private static native boolean readAsExtendedDataNativeGet(long j);

    private static native void readAsExtendedDataNativeSet(long j, boolean z);

    private static native boolean shouldScanInverseNativeGet(long j);

    private static native void shouldScanInverseNativeSet(long j, boolean z);

    private static native boolean slowerThoroughScanNativeGet(long j);

    private static native void slowerThoroughScanNativeSet(long j, boolean z);

    private static native boolean uncertainDecodingNativeGet(long j);

    private static native void uncertainDecodingNativeSet(long j, boolean z);

    private static native boolean upcaNativeGet(long j);

    private static native void upcaNativeSet(long j, boolean z);

    private static native boolean upceNativeGet(long j);

    private static native void upceNativeSet(long j, boolean z);

    public void consumeResultFrom(Entity entity) {
        if (this == entity) {
            return;
        }
        if (entity instanceof BarcodeRecognizer) {
            nativeConsumeResult(getNativeContext(), entity.getResult().getNativeContext());
            return;
        }
        throw new IllegalArgumentException("Parameter type has to be BarcodeRecognizer");
    }

    public boolean isAutoScaleDetection() {
        return autoScaleDetectionNativeGet(getNativeContext());
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

    public boolean isSlowerThoroughScan() {
        return slowerThoroughScanNativeGet(getNativeContext());
    }

    public void llIIlIlIIl(long j) {
        nativeDestruct(j);
    }

    public void setAutoScaleDetection(boolean z) {
        autoScaleDetectionNativeSet(getNativeContext(), z);
    }

    public void setNullQuietZoneAllowed(boolean z) {
        nullQuietZoneAllowedNativeSet(getNativeContext(), z);
    }

    public void setReadCode39AsExtendedData(boolean z) {
        readAsExtendedDataNativeSet(getNativeContext(), z);
    }

    public void setScanAztecCode(boolean z) {
        aztecNativeSet(getNativeContext(), z);
    }

    public void setScanCode128(boolean z) {
        code128NativeSet(getNativeContext(), z);
    }

    public void setScanCode39(boolean z) {
        code39NativeSet(getNativeContext(), z);
    }

    public void setScanDataMatrix(boolean z) {
        dataMatrixNativeSet(getNativeContext(), z);
    }

    public void setScanEan13(boolean z) {
        ean13NativeSet(getNativeContext(), z);
    }

    public void setScanEan8(boolean z) {
        ean8NativeSet(getNativeContext(), z);
    }

    public void setScanInverse(boolean z) {
        shouldScanInverseNativeSet(getNativeContext(), z);
    }

    public void setScanItf(boolean z) {
        itfNativeSet(getNativeContext(), z);
    }

    public void setScanPdf417(boolean z) {
        pdf417NativeSet(getNativeContext(), z);
    }

    public void setScanQrCode(boolean z) {
        qrcodeNativeSet(getNativeContext(), z);
    }

    public void setScanUncertain(boolean z) {
        uncertainDecodingNativeSet(getNativeContext(), z);
    }

    public void setScanUpca(boolean z) {
        upcaNativeSet(getNativeContext(), z);
    }

    public void setScanUpce(boolean z) {
        upceNativeSet(getNativeContext(), z);
    }

    public void setSlowerThoroughScan(boolean z) {
        slowerThoroughScanNativeSet(getNativeContext(), z);
    }

    public boolean shouldReadCode39AsExtendedData() {
        return readAsExtendedDataNativeGet(getNativeContext());
    }

    public boolean shouldScanAztecCode() {
        return aztecNativeGet(getNativeContext());
    }

    public boolean shouldScanCode128() {
        return code128NativeGet(getNativeContext());
    }

    public boolean shouldScanCode39() {
        return code39NativeGet(getNativeContext());
    }

    public boolean shouldScanDataMatrix() {
        return dataMatrixNativeGet(getNativeContext());
    }

    public boolean shouldScanEan13() {
        return ean13NativeGet(getNativeContext());
    }

    public boolean shouldScanEan8() {
        return ean8NativeGet(getNativeContext());
    }

    public boolean shouldScanItf() {
        return itfNativeGet(getNativeContext());
    }

    public boolean shouldScanPdf417() {
        return pdf417NativeGet(getNativeContext());
    }

    public boolean shouldScanQrCode() {
        return qrcodeNativeGet(getNativeContext());
    }

    public boolean shouldScanUpca() {
        return upcaNativeGet(getNativeContext());
    }

    public boolean shouldScanUpce() {
        return upceNativeGet(getNativeContext());
    }

    public BarcodeRecognizer() {
        this(nativeConstruct());
    }

    public byte[] llIIlIlIIl() {
        return nativeSerialize(getNativeContext());
    }

    private BarcodeRecognizer(long j) {
        super(j, new Result(Entity.nativeGetNativeResultContext(j)));
    }

    public void llIIlIlIIl(byte[] bArr) {
        nativeDeserialize(getNativeContext(), bArr);
    }

    private BarcodeRecognizer(Parcel parcel, long j) {
        super(j, new Result(Entity.nativeGetNativeResultContext(j)), parcel);
    }

    public BarcodeRecognizer clone() {
        return new BarcodeRecognizer(nativeCopy(getNativeContext()));
    }
}
