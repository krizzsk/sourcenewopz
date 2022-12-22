package com.microblink.blinkbarcode.entities.recognizers.framegrabber;

import android.os.Parcel;
import android.os.Parcelable;
import com.microblink.blinkbarcode.entities.Entity;
import com.microblink.blinkbarcode.entities.recognizers.Recognizer;
import com.microblink.blinkbarcode.image.Image;
import com.microblink.blinkbarcode.image.ImageBuilder;
import com.microblink.blinkbarcode.recognition.IlIllIlIIl;

/* compiled from: line */
public final class FrameGrabberRecognizer extends Recognizer<Result> {
    public static final Parcelable.Creator<FrameGrabberRecognizer> CREATOR = new Parcelable.Creator<FrameGrabberRecognizer>() {
        public FrameGrabberRecognizer createFromParcel(Parcel parcel) {
            NativeCallback nativeCallback = new NativeCallback((FrameCallback) parcel.readParcelable(FrameGrabberRecognizer.class.getClassLoader()));
            return new FrameGrabberRecognizer(parcel, FrameGrabberRecognizer.nativeConstruct(nativeCallback), nativeCallback);
        }

        public FrameGrabberRecognizer[] newArray(int i) {
            return new FrameGrabberRecognizer[i];
        }
    };
    private NativeCallback IllIIIllII;

    /* compiled from: line */
    public static final class NativeCallback {
        /* access modifiers changed from: private */
        public FrameCallback llIIlIlIIl;

        public NativeCallback(FrameCallback frameCallback) {
            this.llIIlIlIIl = frameCallback;
        }

        public void onFrameAvailable(long j, boolean z, double d) {
            Image buildImageFromNativeContext = ImageBuilder.buildImageFromNativeContext(j, false, (Object) null);
            this.llIIlIlIIl.onFrameAvailable(buildImageFromNativeContext, z, d);
            buildImageFromNativeContext.dispose();
        }
    }

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

        public byte[] IlIllIlIIl() {
            return nativeSerialize(getNativeContext());
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

    private static native boolean grabFocusedFramesNativeGet(long j);

    private static native void grabFocusedFramesNativeSet(long j, boolean z);

    private static native boolean grabUnfocusedFramesNativeGet(long j);

    private static native void grabUnfocusedFramesNativeSet(long j, boolean z);

    /* access modifiers changed from: private */
    public static native long nativeConstruct(NativeCallback nativeCallback);

    private static native long nativeCopy(long j, NativeCallback nativeCallback);

    private static native void nativeDeserialize(long j, byte[] bArr);

    private static native void nativeDestruct(long j);

    private static native byte[] nativeSerialize(long j);

    public void consumeResultFrom(Entity entity) {
    }

    public FrameCallback getFrameCallback() {
        return this.IllIIIllII.llIIlIlIIl;
    }

    public void setFrameCallback(FrameCallback frameCallback) {
        FrameCallback unused = this.IllIIIllII.llIIlIlIIl = frameCallback;
    }

    public void setGrabFocusedFrames(boolean z) {
        grabFocusedFramesNativeSet(getNativeContext(), z);
    }

    public void setGrabUnfocusedFrames(boolean z) {
        grabUnfocusedFramesNativeSet(getNativeContext(), z);
    }

    public boolean shouldGrabFocusedFrames() {
        return grabFocusedFramesNativeGet(getNativeContext());
    }

    public boolean shouldGrabUnfocusedFrames() {
        return grabUnfocusedFramesNativeGet(getNativeContext());
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.IllIIIllII.llIIlIlIIl, i);
        super.writeToParcel(parcel, i);
    }

    public FrameGrabberRecognizer(FrameCallback frameCallback) {
        this(new NativeCallback(frameCallback));
    }

    public void llIIlIlIIl(long j) {
        nativeDestruct(j);
    }

    private FrameGrabberRecognizer(NativeCallback nativeCallback) {
        this(nativeCallback, nativeConstruct(nativeCallback));
    }

    public byte[] llIIlIlIIl() {
        return nativeSerialize(getNativeContext());
    }

    private FrameGrabberRecognizer(NativeCallback nativeCallback, long j) {
        super(j, new Result(Entity.nativeGetNativeResultContext(j)));
        this.IllIIIllII = nativeCallback;
    }

    public FrameGrabberRecognizer clone() {
        NativeCallback nativeCallback = new NativeCallback(this.IllIIIllII.llIIlIlIIl);
        return new FrameGrabberRecognizer(nativeCallback, nativeCopy(getNativeContext(), nativeCallback));
    }

    public void llIIlIlIIl(byte[] bArr) {
        nativeDeserialize(getNativeContext(), bArr);
    }

    private FrameGrabberRecognizer(Parcel parcel, long j, NativeCallback nativeCallback) {
        super(j, new Result(Entity.nativeGetNativeResultContext(j)), parcel);
        this.IllIIIllII = nativeCallback;
    }
}
