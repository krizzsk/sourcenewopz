package com.microblink.blinkbarcode.uisettings;

import android.os.Parcel;
import android.os.Parcelable;
import com.microblink.blinkbarcode.hardware.camera.CameraType;
import com.microblink.blinkbarcode.hardware.camera.VideoResolutionPreset;
import com.microblink.blinkbarcode.view.CameraAspectMode;
import com.microblink.blinkbarcode.view.recognition.RecognizerRunnerView;
import com.microblink.blinkbarcode.view.surface.CameraSurface;

/* compiled from: line */
public class CameraSettings implements Parcelable {
    public static final Parcelable.Creator<CameraSettings> CREATOR = new Parcelable.Creator<CameraSettings>() {
        public CameraSettings createFromParcel(Parcel parcel) {
            return new CameraSettings(parcel);
        }

        public CameraSettings[] newArray(int i) {
            return new CameraSettings[i];
        }
    };
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

        public CameraSettings build() {
            return new CameraSettings(this.llIIlIlIIl, this.IlIllIlIIl, this.IllIIIllII, this.llIIIlllll, this.IllIIIIllI, this.lIlIIIIlIl, this.llIIlIIlll);
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

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.type, i);
        parcel.writeByte(this.isOptimizedForNearScan ? (byte) 1 : 0);
        parcel.writeParcelable(this.aspectMode, i);
        parcel.writeParcelable(this.surface, i);
        parcel.writeByte(this.forceLegacyApi ? (byte) 1 : 0);
        parcel.writeByte(this.isPinchToZoomAllowed ? (byte) 1 : 0);
        parcel.writeParcelable(this.videoResolutionPreset, i);
    }

    private CameraSettings(CameraType cameraType, boolean z, CameraAspectMode cameraAspectMode, CameraSurface cameraSurface, boolean z2, boolean z3, VideoResolutionPreset videoResolutionPreset2) {
        this.type = cameraType;
        this.isOptimizedForNearScan = z;
        this.aspectMode = cameraAspectMode;
        this.surface = cameraSurface;
        this.forceLegacyApi = z2;
        this.isPinchToZoomAllowed = z3;
        this.videoResolutionPreset = videoResolutionPreset2;
    }

    private CameraSettings(Parcel parcel) {
        this.type = (CameraType) parcel.readParcelable(CameraType.class.getClassLoader());
        boolean z = true;
        this.isOptimizedForNearScan = parcel.readByte() != 0;
        this.aspectMode = (CameraAspectMode) parcel.readParcelable(CameraAspectMode.class.getClassLoader());
        this.surface = (CameraSurface) parcel.readParcelable(CameraSurface.class.getClassLoader());
        this.forceLegacyApi = parcel.readByte() != 0;
        this.isPinchToZoomAllowed = parcel.readByte() == 0 ? false : z;
        this.videoResolutionPreset = (VideoResolutionPreset) parcel.readParcelable(VideoResolutionPreset.class.getClassLoader());
    }
}
