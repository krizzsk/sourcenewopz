package com.microblink.blinkbarcode.recognition.callback;

import com.microblink.blinkbarcode.entities.recognizers.RecognizerBundle;
import com.microblink.blinkbarcode.geometry.Rectangle;
import com.microblink.blinkbarcode.image.Image;
import com.microblink.blinkbarcode.image.ImageBuilder;
import com.microblink.blinkbarcode.metadata.MetadataCallbacks;
import com.microblink.blinkbarcode.metadata.detection.points.DisplayablePointsDetection;
import com.microblink.blinkbarcode.metadata.detection.quad.DisplayableQuadDetection;
import com.microblink.blinkbarcode.recognition.IlIllIlIIl;
import com.microblink.blinkbarcode.recognition.NativeRecognizerWrapper;

/* compiled from: line */
public abstract class BaseRecognitionProcessCallback {
    @Deprecated
    public static final int DETECTION_METADATA = 3;
    @Deprecated
    public static final int GLARE_METADATA = 5;
    @Deprecated
    public static final int IMAGE_METADATA = 0;
    private static final int NO_MIRROR = 0;
    @Deprecated
    public static final int OCR_METADATA = 2;
    @Deprecated
    public static final int PARTIAL_RESULT_METADATA = 4;
    @Deprecated
    public static final int TEXT_METADATA = 1;
    private static final int XY_MIRROR = 3;
    private static final int X_MIRROR = 1;
    private static final int Y_MIRROR = 2;
    private llIIlIlIIl mLicenseInformationCallback;
    public MetadataCallbacks mMetadataCallbacks;
    public long mNativeContext = 0;
    public NativeRecognizerWrapper mNativeRecognizerWrapper;
    private boolean mPaused = true;

    static {
        IlIllIlIIl.IllIIIllII();
    }

    public BaseRecognitionProcessCallback(llIIlIlIIl lliililiil, Rectangle rectangle, RecognizerBundle.RecognitionDebugMode recognitionDebugMode) {
        this.mLicenseInformationCallback = lliililiil;
        this.mNativeContext = nativeConstruct(recognitionDebugMode.ordinal());
        setScanningRegion(rectangle);
    }

    private native long nativeConstruct(int i);

    private static native void nativeDestruct(long j);

    private static native void nativeSetBaseCallbacks(long j, boolean z, boolean z2, boolean z3, boolean z4, boolean z5);

    private static native void nativeSetMirrorType(long j, int i);

    private static native void nativeSetPaused(long j, boolean z);

    private static native void nativeSetScanningRegion(long j, float f, float f2, float f3, float f4);

    public void dispose() {
        long j = this.mNativeContext;
        if (j != 0) {
            nativeDestruct(j);
            this.mNativeContext = 0;
        }
    }

    public void finalize() throws Throwable {
        super.finalize();
        dispose();
    }

    public long getNativeContext() {
        return this.mNativeContext;
    }

    public boolean isPaused() {
        return this.mPaused;
    }

    public void onDebugText(String str) {
        this.mMetadataCallbacks.getDebugTextCallback().onDebugText(str);
    }

    public void onDetectionFailed() {
        this.mMetadataCallbacks.getFailedDetectionCallback().onDetectionFailed();
    }

    public void onImage(long j) {
        Image buildImageFromNativeContext = ImageBuilder.buildImageFromNativeContext(j, false, (Object) null);
        this.mMetadataCallbacks.getDebugImageCallback().onImageAvailable(buildImageFromNativeContext);
        buildImageFromNativeContext.dispose();
    }

    public void onLicenseInfo(String str) {
        this.mLicenseInformationCallback.onLicenseInformation(str);
    }

    public void onPointsDetection(int i, float[] fArr, float[] fArr2, int i2) {
        this.mMetadataCallbacks.getPointsDetectionCallback().onPointsDetection(new DisplayablePointsDetection(i, fArr, fArr2, i2));
    }

    public void onQuadDetection(int i, float[] fArr, float[] fArr2) {
        this.mMetadataCallbacks.getQuadDetectionCallback().onQuadDetection(new DisplayableQuadDetection(i, fArr, fArr2));
    }

    public void setCameraOptions(boolean z, boolean z2) {
        if (z) {
            int i = 2;
            if (z2) {
                i = 1;
            }
            nativeSetMirrorType(this.mNativeContext, i);
        } else if (z2) {
            nativeSetMirrorType(this.mNativeContext, 3);
        } else {
            nativeSetMirrorType(this.mNativeContext, 0);
        }
    }

    public void setMetadataCallbacks(MetadataCallbacks metadataCallbacks) {
        this.mMetadataCallbacks = metadataCallbacks;
        nativeSetBaseCallbacks(this.mNativeContext, metadataCallbacks.getFailedDetectionCallback() != null, metadataCallbacks.getPointsDetectionCallback() != null, this.mMetadataCallbacks.getQuadDetectionCallback() != null, this.mMetadataCallbacks.getDebugTextCallback() != null, this.mMetadataCallbacks.getDebugImageCallback() != null);
    }

    public void setNativeRecognizerWrapper(NativeRecognizerWrapper nativeRecognizerWrapper) {
        this.mNativeRecognizerWrapper = nativeRecognizerWrapper;
    }

    public void setPaused(boolean z) {
        this.mPaused = z;
        nativeSetPaused(this.mNativeContext, z);
    }

    public void setScanningRegion(Rectangle rectangle) {
        if (rectangle == null) {
            rectangle = Rectangle.getDefaultROI();
        }
        nativeSetScanningRegion(this.mNativeContext, rectangle.getX(), rectangle.getY(), rectangle.getWidth(), rectangle.getHeight());
    }
}
