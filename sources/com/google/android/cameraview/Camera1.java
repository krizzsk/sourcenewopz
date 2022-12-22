package com.google.android.cameraview;

import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import android.os.Build;
import android.view.SurfaceHolder;
import androidx.collection.SparseArrayCompat;
import com.didi.sdk.apm.SystemUtils;
import com.google.android.cameraview.CameraViewImpl;
import com.google.android.cameraview.PreviewImpl;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.SortedSet;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlinx.coroutines.DebugKt;

class Camera1 extends CameraViewImpl {
    private static final SparseArrayCompat<String> FLASH_MODES;
    private static final int INVALID_CAMERA_ID = -1;
    /* access modifiers changed from: private */
    public final AtomicBoolean isPictureCaptureInProgress = new AtomicBoolean(false);
    private AspectRatio mAspectRatio;
    private boolean mAutoFocus;
    Camera mCamera;
    private int mCameraId;
    private final Camera.CameraInfo mCameraInfo = new Camera.CameraInfo();
    private Camera.Parameters mCameraParameters;
    private int mDisplayOrientation;
    private int mFacing;
    private int mFlash;
    private final SizeMap mPictureSizes = new SizeMap();
    private final SizeMap mPreviewSizes = new SizeMap();
    private boolean mShowingPreview;

    private boolean isLandscape(int i) {
        return i == 90 || i == 270;
    }

    static {
        SparseArrayCompat<String> sparseArrayCompat = new SparseArrayCompat<>();
        FLASH_MODES = sparseArrayCompat;
        sparseArrayCompat.put(0, DebugKt.DEBUG_PROPERTY_VALUE_OFF);
        FLASH_MODES.put(1, "on");
        FLASH_MODES.put(2, "torch");
        FLASH_MODES.put(3, DebugKt.DEBUG_PROPERTY_VALUE_AUTO);
        FLASH_MODES.put(4, "red-eye");
    }

    Camera1(CameraViewImpl.Callback callback, PreviewImpl previewImpl) {
        super(callback, previewImpl);
        previewImpl.setCallback(new PreviewImpl.Callback() {
            public void onSurfaceChanged() {
                if (Camera1.this.mCamera != null) {
                    Camera1.this.setUpPreview();
                    Camera1.this.adjustCameraParameters();
                }
            }
        });
    }

    /* access modifiers changed from: package-private */
    public boolean start() {
        try {
            chooseCamera();
            openCamera();
            if (this.mPreview.isReady()) {
                setUpPreview();
            }
            this.mShowingPreview = true;
            this.mCamera.startPreview();
            return true;
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    /* access modifiers changed from: package-private */
    public void stop() {
        Camera camera = this.mCamera;
        if (camera != null) {
            camera.stopPreview();
        }
        this.mShowingPreview = false;
        releaseCamera();
    }

    /* access modifiers changed from: package-private */
    public void setUpPreview() {
        try {
            if (this.mPreview.getOutputClass() == SurfaceHolder.class) {
                boolean z = this.mShowingPreview && Build.VERSION.SDK_INT < 14;
                if (z) {
                    this.mCamera.stopPreview();
                }
                this.mCamera.setPreviewDisplay(this.mPreview.getSurfaceHolder());
                if (z) {
                    this.mCamera.startPreview();
                    return;
                }
                return;
            }
            SystemUtils.log(6, "panlei", "setPreviewTexture", (Throwable) null, "com.google.android.cameraview.Camera1", 128);
            this.mCamera.setPreviewTexture((SurfaceTexture) this.mPreview.getSurfaceTexture());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /* access modifiers changed from: package-private */
    public boolean isCameraOpened() {
        return this.mCamera != null;
    }

    /* access modifiers changed from: package-private */
    public void setFacing(int i) {
        if (this.mFacing != i) {
            this.mFacing = i;
            if (isCameraOpened()) {
                stop();
                start();
            }
        }
    }

    /* access modifiers changed from: package-private */
    public int getFacing() {
        return this.mFacing;
    }

    /* access modifiers changed from: package-private */
    public Set<AspectRatio> getSupportedAspectRatios() {
        SizeMap sizeMap = this.mPreviewSizes;
        for (AspectRatio next : sizeMap.ratios()) {
            if (this.mPictureSizes.sizes(next) == null) {
                sizeMap.remove(next);
            }
        }
        return sizeMap.ratios();
    }

    /* access modifiers changed from: package-private */
    public boolean setAspectRatio(AspectRatio aspectRatio) {
        if (this.mAspectRatio == null || !isCameraOpened()) {
            this.mAspectRatio = aspectRatio;
            return true;
        } else if (this.mAspectRatio.equals(aspectRatio)) {
            return false;
        } else {
            if (this.mPreviewSizes.sizes(aspectRatio) != null) {
                this.mAspectRatio = aspectRatio;
                adjustCameraParameters();
                return true;
            }
            throw new UnsupportedOperationException(aspectRatio + " is not supported");
        }
    }

    /* access modifiers changed from: package-private */
    public AspectRatio getAspectRatio() {
        return this.mAspectRatio;
    }

    /* access modifiers changed from: package-private */
    public void setAutoFocus(boolean z) {
        if (this.mAutoFocus != z && setAutoFocusInternal(z)) {
            this.mCamera.setParameters(this.mCameraParameters);
        }
    }

    /* access modifiers changed from: package-private */
    public boolean getAutoFocus() {
        if (!isCameraOpened()) {
            return this.mAutoFocus;
        }
        String focusMode = this.mCameraParameters.getFocusMode();
        return focusMode != null && focusMode.contains("continuous");
    }

    /* access modifiers changed from: package-private */
    public void setFlash(int i) {
        if (i != this.mFlash && setFlashInternal(i)) {
            this.mCamera.setParameters(this.mCameraParameters);
        }
    }

    /* access modifiers changed from: package-private */
    public int getFlash() {
        return this.mFlash;
    }

    /* access modifiers changed from: package-private */
    public void takePicture() {
        if (!isCameraOpened()) {
            throw new IllegalStateException("Camera is not ready. Call start() before takePicture().");
        } else if (getAutoFocus()) {
            this.mCamera.cancelAutoFocus();
            this.mCamera.autoFocus(new Camera.AutoFocusCallback() {
                public void onAutoFocus(boolean z, Camera camera) {
                    Camera1.this.takePictureInternal();
                }
            });
        } else {
            takePictureInternal();
        }
    }

    /* access modifiers changed from: package-private */
    public void takePictureInternal() {
        if (!this.isPictureCaptureInProgress.getAndSet(true)) {
            this.mCamera.takePicture((Camera.ShutterCallback) null, (Camera.PictureCallback) null, (Camera.PictureCallback) null, new Camera.PictureCallback() {
                public void onPictureTaken(byte[] bArr, Camera camera) {
                    Camera1.this.isPictureCaptureInProgress.set(false);
                    Camera1.this.mCallback.onPictureTaken(bArr);
                    camera.cancelAutoFocus();
                    camera.startPreview();
                }
            });
        }
    }

    /* access modifiers changed from: package-private */
    public void setDisplayOrientation(int i) {
        if (this.mDisplayOrientation != i) {
            this.mDisplayOrientation = i;
            if (isCameraOpened()) {
                this.mCameraParameters.setRotation(calcCameraRotation(i));
                this.mCamera.setParameters(this.mCameraParameters);
                boolean z = this.mShowingPreview && Build.VERSION.SDK_INT < 14;
                if (z) {
                    this.mCamera.stopPreview();
                }
                this.mCamera.setDisplayOrientation(calcDisplayOrientation(i));
                if (z) {
                    this.mCamera.startPreview();
                }
            }
        }
    }

    private void chooseCamera() {
        int numberOfCameras = Camera.getNumberOfCameras();
        for (int i = 0; i < numberOfCameras; i++) {
            Camera.getCameraInfo(i, this.mCameraInfo);
            if (this.mCameraInfo.facing == this.mFacing) {
                this.mCameraId = i;
                return;
            }
        }
        this.mCameraId = -1;
    }

    private void openCamera() {
        if (this.mCamera != null) {
            releaseCamera();
        }
        SystemUtils.log(6, "panlei", "opencamera", (Throwable) null, "com.google.android.cameraview.Camera1", 298);
        Camera open = Camera.open(this.mCameraId);
        this.mCamera = open;
        this.mCameraParameters = open.getParameters();
        this.mPreviewSizes.clear();
        for (Camera.Size next : this.mCameraParameters.getSupportedPreviewSizes()) {
            this.mPreviewSizes.add(new Size(next.width, next.height));
        }
        Camera.Size previewSize = this.mCameraParameters.getPreviewSize();
        if (previewSize != null) {
            this.mPreviewSizes.setDefaultSize(new Size(previewSize.width, previewSize.height));
            this.mPictureSizes.setDefaultSize(new Size(previewSize.width, previewSize.height));
        }
        this.mPictureSizes.clear();
        for (Camera.Size next2 : this.mCameraParameters.getSupportedPictureSizes()) {
            this.mPictureSizes.add(new Size(next2.width, next2.height));
        }
        if (this.mAspectRatio == null) {
            this.mAspectRatio = Constants.DEFAULT_ASPECT_RATIO;
        }
        adjustCameraParameters();
        this.mCamera.setDisplayOrientation(calcDisplayOrientation(this.mDisplayOrientation));
        this.mCallback.onCameraOpened();
    }

    private AspectRatio chooseAspectRatio() {
        Iterator<AspectRatio> it = this.mPreviewSizes.ratios().iterator();
        AspectRatio aspectRatio = null;
        while (it.hasNext()) {
            aspectRatio = it.next();
            if (aspectRatio.equals(Constants.DEFAULT_ASPECT_RATIO)) {
                break;
            }
        }
        return aspectRatio;
    }

    /* access modifiers changed from: package-private */
    public void adjustCameraParameters() {
        if (this.mPreview.isReady()) {
            SortedSet<Size> sizes = this.mPreviewSizes.sizes(this.mAspectRatio);
            if (sizes == null) {
                AspectRatio chooseAspectRatio = chooseAspectRatio();
                this.mAspectRatio = chooseAspectRatio;
                sizes = this.mPreviewSizes.sizes(chooseAspectRatio);
            }
            Size chooseOptimalSize = chooseOptimalSize(sizes, this.mPreviewSizes.getDefaultSize());
            Size last = this.mPictureSizes.sizes(this.mAspectRatio).last();
            if (this.mShowingPreview) {
                this.mCamera.stopPreview();
            }
            this.mCameraParameters.setPreviewSize(chooseOptimalSize.getWidth(), chooseOptimalSize.getHeight());
            this.mCameraParameters.setPictureSize(last.getWidth(), last.getHeight());
            this.mCameraParameters.setRotation(calcCameraRotation(this.mDisplayOrientation));
            setAutoFocusInternal(this.mAutoFocus);
            setFlashInternal(this.mFlash);
            this.mCamera.setParameters(this.mCameraParameters);
            if (this.mShowingPreview) {
                this.mCamera.startPreview();
            }
        }
    }

    private Size chooseOptimalSize(SortedSet<Size> sortedSet, Size size) {
        if (!this.mPreview.isReady()) {
            return sortedSet.first();
        }
        int width = this.mPreview.getWidth();
        int height = this.mPreview.getHeight();
        if (isLandscape(this.mDisplayOrientation)) {
            int i = height;
            height = width;
            width = i;
        }
        return BestPreviewSizeUtil.findBestPreviewSizeValue(sortedSet, size, new Size(width, height));
    }

    private void releaseCamera() {
        Camera camera = this.mCamera;
        if (camera != null) {
            camera.release();
            this.mCamera = null;
            this.mCallback.onCameraClosed();
        }
    }

    private int calcDisplayOrientation(int i) {
        if (this.mCameraInfo.facing == 1) {
            return (360 - ((this.mCameraInfo.orientation + i) % 360)) % 360;
        }
        return ((this.mCameraInfo.orientation - i) + 360) % 360;
    }

    private int calcCameraRotation(int i) {
        if (this.mCameraInfo.facing == 1) {
            return (this.mCameraInfo.orientation + i) % 360;
        }
        return ((this.mCameraInfo.orientation + i) + (isLandscape(i) ? 180 : 0)) % 360;
    }

    private boolean setAutoFocusInternal(boolean z) {
        this.mAutoFocus = z;
        if (!isCameraOpened()) {
            return false;
        }
        List<String> supportedFocusModes = this.mCameraParameters.getSupportedFocusModes();
        if (z && supportedFocusModes.contains("continuous-picture")) {
            this.mCameraParameters.setFocusMode("continuous-picture");
            return true;
        } else if (supportedFocusModes.contains("fixed")) {
            this.mCameraParameters.setFocusMode("fixed");
            return true;
        } else if (supportedFocusModes.contains("infinity")) {
            this.mCameraParameters.setFocusMode("infinity");
            return true;
        } else {
            this.mCameraParameters.setFocusMode(supportedFocusModes.get(0));
            return true;
        }
    }

    private boolean setFlashInternal(int i) {
        if (isCameraOpened()) {
            List<String> supportedFlashModes = this.mCameraParameters.getSupportedFlashModes();
            String str = FLASH_MODES.get(i);
            if (supportedFlashModes == null || !supportedFlashModes.contains(str)) {
                String str2 = FLASH_MODES.get(this.mFlash);
                if (supportedFlashModes != null && supportedFlashModes.contains(str2)) {
                    return false;
                }
                this.mCameraParameters.setFlashMode(DebugKt.DEBUG_PROPERTY_VALUE_OFF);
                this.mFlash = 0;
                return true;
            }
            this.mCameraParameters.setFlashMode(str);
            this.mFlash = i;
            return true;
        }
        this.mFlash = i;
        return false;
    }
}
