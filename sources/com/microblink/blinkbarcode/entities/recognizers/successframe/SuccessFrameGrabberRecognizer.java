package com.microblink.blinkbarcode.entities.recognizers.successframe;

import android.os.Parcel;
import android.os.Parcelable;
import com.microblink.blinkbarcode.entities.Entity;
import com.microblink.blinkbarcode.entities.recognizers.Recognizer;
import com.microblink.blinkbarcode.image.Image;
import com.microblink.blinkbarcode.image.ImageBuilder;
import com.microblink.blinkbarcode.recognition.IlIllIlIIl;

/* compiled from: line */
public final class SuccessFrameGrabberRecognizer extends Recognizer<Result> {
    public static final Parcelable.Creator<SuccessFrameGrabberRecognizer> CREATOR = new Parcelable.Creator<SuccessFrameGrabberRecognizer>() {
        public SuccessFrameGrabberRecognizer createFromParcel(Parcel parcel) {
            Recognizer recognizer = (Recognizer) parcel.readParcelable(SuccessFrameGrabberRecognizer.class.getClassLoader());
            return new SuccessFrameGrabberRecognizer(parcel, SuccessFrameGrabberRecognizer.nativeConstruct(recognizer.getNativeContext()), recognizer);
        }

        public SuccessFrameGrabberRecognizer[] newArray(int i) {
            return new SuccessFrameGrabberRecognizer[i];
        }
    };
    private Recognizer<?> IllIIIllII;

    /* compiled from: line */
    public static final class Result extends Recognizer.Result {
        public static final Parcelable.Creator<Result> CREATOR = new Parcelable.Creator<Result>() {
            public Result createFromParcel(Parcel parcel) {
                Result result = new Result(Result.nativeConstruct(), (Recognizer.Result) parcel.readParcelable(C203611.class.getClassLoader()));
                result.llIIlIlIIl(parcel);
                return result;
            }

            public Result[] newArray(int i) {
                return new Result[i];
            }
        };
        private Recognizer.Result IllIIIllII;

        public Result(long j, Recognizer.Result result) {
            super(j);
            this.IllIIIllII = result;
        }

        /* access modifiers changed from: private */
        public static native long nativeConstruct();

        private static native long nativeCopy(long j);

        private static native void nativeDeserialize(long j, byte[] bArr);

        private static native void nativeDestruct(long j);

        private static native byte[] nativeSerialize(long j);

        private static native long successFrameNativeGet(long j);

        public byte[] IlIllIlIIl() {
            return nativeSerialize(getNativeContext());
        }

        public Recognizer.Result getSlaveResult() {
            return this.IllIIIllII;
        }

        public Image getSuccessFrame() {
            long successFrameNativeGet = successFrameNativeGet(getNativeContext());
            if (successFrameNativeGet != 0) {
                return ImageBuilder.buildImageFromNativeContext(successFrameNativeGet, true, this);
            }
            return null;
        }

        public String toString() {
            return this.IllIIIllII.toString();
        }

        public void writeToParcel(Parcel parcel, int i) {
            if (this.IlIllIlIIl == null) {
                parcel.writeParcelable(this.IllIIIllII, i);
            }
            super.writeToParcel(parcel, i);
        }

        public void llIIlIlIIl(byte[] bArr) {
            nativeDeserialize(getNativeContext(), bArr);
        }

        public void llIIlIlIIl(long j) {
            nativeDestruct(j);
        }

        public Result clone() {
            return new Result(nativeCopy(getNativeContext()), this.IllIIIllII.clone());
        }
    }

    static {
        IlIllIlIIl.llIIlIlIIl();
    }

    /* access modifiers changed from: private */
    public static native long nativeConstruct(long j);

    private static native void nativeConsumeResult(long j, long j2);

    private static native void nativeDestruct(long j);

    public void consumeResultFrom(Entity entity) {
        if (this != entity) {
            if (entity instanceof SuccessFrameGrabberRecognizer) {
                SuccessFrameGrabberRecognizer successFrameGrabberRecognizer = (SuccessFrameGrabberRecognizer) entity;
                nativeConsumeResult(getNativeContext(), ((Result) successFrameGrabberRecognizer.getResult()).getNativeContext());
                this.IllIIIllII.consumeResultFrom(successFrameGrabberRecognizer.IllIIIllII);
                return;
            }
            throw new IllegalArgumentException("Parameter type has to be SuccessFrameGrabberRecognizer");
        }
    }

    public Recognizer<?> getSlaveRecognizer() {
        return this.IllIIIllII;
    }

    public void llIIlIlIIl(long j) {
        nativeDestruct(j);
    }

    public void llIIlIlIIl(byte[] bArr) {
    }

    public byte[] llIIlIlIIl() {
        return null;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.IllIIIllII, i);
        super.writeToParcel(parcel, i);
    }

    public SuccessFrameGrabberRecognizer(Recognizer<?> recognizer) {
        this(recognizer, nativeConstruct(recognizer.getNativeContext()));
    }

    private SuccessFrameGrabberRecognizer(Recognizer<?> recognizer, long j) {
        super(j, new Result(Entity.nativeGetNativeResultContext(j), (Recognizer.Result) recognizer.getResult()));
        this.IllIIIllII = recognizer;
    }

    public SuccessFrameGrabberRecognizer clone() {
        throw new IllegalStateException("SuccessFrameGrabber recognizer does not support cloning!");
    }

    private SuccessFrameGrabberRecognizer(Parcel parcel, long j, Recognizer<?> recognizer) {
        super(j, new Result(Entity.nativeGetNativeResultContext(j), (Recognizer.Result) recognizer.getResult()), parcel);
        this.IllIIIllII = recognizer;
    }
}
