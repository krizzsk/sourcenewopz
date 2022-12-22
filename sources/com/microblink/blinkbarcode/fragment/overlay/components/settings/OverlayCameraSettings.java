package com.microblink.blinkbarcode.fragment.overlay.components.settings;

import com.microblink.blinkbarcode.hardware.camera.CameraType;
import com.microblink.blinkbarcode.hardware.camera.VideoResolutionPreset;
import com.microblink.blinkbarcode.view.CameraAspectMode;
import com.microblink.blinkbarcode.view.recognition.RecognizerRunnerView;
import com.microblink.blinkbarcode.view.surface.CameraSurface;

/* compiled from: line */
public class OverlayCameraSettings {
    public final CameraAspectMode aspectMode;
    public final boolean forceLegacyApi;
    public final boolean isOptimizedForNearScan;
    public final boolean isPinchToZoomAllowed;
    public final CameraSurface surface;
    public final CameraType type;
    public final VideoResolutionPreset videoResolutionPreset;

    /* compiled from: line */
    public static class Builder {
        private boolean IlIllIlIIl = false;
        private boolean IllIIIIllI = false;
        private CameraAspectMode IllIIIllII = CameraAspectMode.ASPECT_FILL;
        private boolean lIlIIIIlIl = false;
        private CameraSurface llIIIlllll = CameraSurface.SURFACE_DEFAULT;
        private VideoResolutionPreset llIIlIIlll = VideoResolutionPreset.VIDEO_RESOLUTION_DEFAULT;
        private CameraType llIIlIlIIl = CameraType.CAMERA_DEFAULT;

        public OverlayCameraSettings build() {
            return new OverlayCameraSettings(this.llIIlIlIIl, this.IlIllIlIIl, this.IllIIIllII, this.llIIIlllll, this.IllIIIIllI, this.lIlIIIIlIl, this.llIIlIIlll);
        }

        public Builder setAspectMode(CameraAspectMode cameraAspectMode) {
            this.IllIIIllII = cameraAspectMode;
            return this;
        }

        public Builder setForceLegacyApi(boolean z) {
            this.IllIIIIllI = z;
            return this;
        }

        public Builder setIsOptimizedForNearScan(boolean z) {
            this.IlIllIlIIl = z;
            return this;
        }

        public Builder setIsPinchToZoomAllowed(boolean z) {
            this.lIlIIIIlIl = z;
            return this;
        }

        public Builder setSurface(CameraSurface cameraSurface) {
            this.llIIIlllll = cameraSurface;
            return this;
        }

        public Builder setType(CameraType cameraType) {
            this.llIIlIlIIl = cameraType;
            return this;
        }

        public Builder setVideoResolutionPreset(VideoResolutionPreset videoResolutionPreset) {
            this.llIIlIIlll = videoResolutionPreset;
            return this;
        }
    }

    public void apply(RecognizerRunnerView recognizerRunnerView) {
        recognizerRunnerView.setOptimizeCameraForNearScan(this.isOptimizedForNearScan);
        recognizerRunnerView.setCameraType(this.type);
        recognizerRunnerView.setAspectMode(this.aspectMode);
        recognizerRunnerView.setRequestedSurfaceViewForCameraDisplay(this.surface);
        recognizerRunnerView.setVideoResolutionPreset(this.videoResolutionPreset);
        recognizerRunnerView.setForceUseLegacyCamera(this.forceLegacyApi);
        recognizerRunnerView.setPinchToZoomAllowed(this.isPinchToZoomAllowed);
    }

    private OverlayCameraSettings(CameraType cameraType, boolean z, CameraAspectMode cameraAspectMode, CameraSurface cameraSurface, boolean z2, boolean z3, VideoResolutionPreset videoResolutionPreset2) {
        this.type = cameraType;
        this.isOptimizedForNearScan = z;
        this.aspectMode = cameraAspectMode;
        this.surface = cameraSurface;
        this.forceLegacyApi = z2;
        this.isPinchToZoomAllowed = z3;
        this.videoResolutionPreset = videoResolutionPreset2;
    }
}
