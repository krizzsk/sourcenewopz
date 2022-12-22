package com.microblink.blinkbarcode.fragment.overlay.basic;

import com.microblink.blinkbarcode.entities.recognizers.RecognizerBundle;
import com.microblink.blinkbarcode.fragment.overlay.components.feedback.RecognitionFeedbackHandler;
import com.microblink.blinkbarcode.fragment.overlay.components.settings.ControlsLayoutConfig;
import com.microblink.blinkbarcode.fragment.overlay.components.settings.OverlayCameraSettings;
import com.microblink.blinkbarcode.fragment.overlay.components.settings.ScanRegionOfInterestSettings;
import com.microblink.blinkbarcode.fragment.overlay.components.statusmsg.StatusMessageTranslator;
import com.microblink.blinkbarcode.geometry.Rectangle;
import com.microblink.blinkbarcode.image.DebugImageListener;
import com.microblink.blinkbarcode.uisettings.options.OverlayOrientation;
import com.microblink.blinkbarcode.view.viewfinder.quadview.QuadViewPreset;

/* compiled from: line */
public class BasicOverlaySettings {
    private DebugImageListener IIlIIIllIl;
    private OverlayCameraSettings IlIllIlIIl;
    private RecognitionFeedbackHandler IlIllIlllI;
    private int IllIIIIllI;
    private ScanRegionOfInterestSettings IllIIIllII;
    private StatusMessageTranslator IllIIlIIII;
    private OverlayOrientation lIIIIIllll;
    private boolean lIlIIIIlIl;
    private Runnable llIIIlllll;
    private int llIIlIIlll;
    private RecognizerBundle llIIlIlIIl;
    private QuadViewPreset lllIIIlIlI;
    private ControlsLayoutConfig lllIlIlIIl;

    /* compiled from: line */
    public static class Builder {
        private DebugImageListener IIlIIIllIl;
        private OverlayCameraSettings IlIllIlIIl = new OverlayCameraSettings.Builder().build();
        private RecognitionFeedbackHandler IlIllIlllI = RecognitionFeedbackHandler.EMPTY;
        private int IllIIIIllI;
        private ScanRegionOfInterestSettings IllIIIllII = new ScanRegionOfInterestSettings((Rectangle) null, false);
        private StatusMessageTranslator IllIIlIIII = StatusMessageTranslator.EMPTY;
        private OverlayOrientation lIIIIIllll;
        private boolean lIlIIIIlIl;
        private Runnable llIIIlllll;
        private int llIIlIIlll;
        private RecognizerBundle llIIlIlIIl;
        private QuadViewPreset lllIIIlIlI = QuadViewPreset.DEFAULT_CORNERS_FROM_BARCODE_SCAN_ACTIVITY;
        private ControlsLayoutConfig lllIlIlIIl = ControlsLayoutConfig.createDefault();

        public Builder(RecognizerBundle recognizerBundle) {
            this.llIIlIlIIl = recognizerBundle;
        }

        public BasicOverlaySettings build() {
            return new BasicOverlaySettings(this.llIIlIlIIl, this.IlIllIlIIl, this.IllIIIllII, this.llIIIlllll, this.IllIIIIllI, this.lIlIIIIlIl, this.llIIlIIlll, this.IIlIIIllIl, this.lIIIIIllll, this.lllIIIlIlI, this.IlIllIlllI, this.lllIlIlIIl, this.IllIIlIIII);
        }

        public Builder setBeepSoundId(int i) {
            this.llIIlIIlll = i;
            return this;
        }

        public Builder setCameraSettings(OverlayCameraSettings overlayCameraSettings) {
            this.IlIllIlIIl = overlayCameraSettings;
            return this;
        }

        public Builder setControlsLayoutConfig(ControlsLayoutConfig controlsLayoutConfig) {
            this.lllIlIlIIl = controlsLayoutConfig;
            return this;
        }

        public Builder setDebugImageListener(DebugImageListener debugImageListener) {
            this.IIlIIIllIl = debugImageListener;
            return this;
        }

        public Builder setForcedOrientation(OverlayOrientation overlayOrientation) {
            this.lIIIIIllll = overlayOrientation;
            return this;
        }

        public Builder setHelpAction(Runnable runnable) {
            this.llIIIlllll = runnable;
            return this;
        }

        public Builder setHighResFrameCaptureEnabled(boolean z) {
            this.lIlIIIIlIl = z;
            return this;
        }

        public Builder setQuadViewPreset(QuadViewPreset quadViewPreset) {
            this.lllIIIlIlI = quadViewPreset;
            return this;
        }

        public Builder setRecognitionFeedbackHandler(RecognitionFeedbackHandler recognitionFeedbackHandler) {
            this.IlIllIlllI = recognitionFeedbackHandler;
            return this;
        }

        public Builder setScanRegionOfInterestSettings(ScanRegionOfInterestSettings scanRegionOfInterestSettings) {
            this.IllIIIllII = scanRegionOfInterestSettings;
            return this;
        }

        public Builder setSplashResourceId(int i) {
            this.IllIIIIllI = i;
            return this;
        }

        public Builder setStatusMessageTranslator(StatusMessageTranslator statusMessageTranslator) {
            this.IllIIlIIII = statusMessageTranslator;
            return this;
        }
    }

    public RecognitionFeedbackHandler IIlIIIllIl() {
        return this.IlIllIlllI;
    }

    public OverlayCameraSettings IlIllIlIIl() {
        return this.IlIllIlIIl;
    }

    public int IlIllIlllI() {
        return this.IllIIIIllI;
    }

    public OverlayOrientation IllIIIIllI() {
        return this.lIIIIIllll;
    }

    public ControlsLayoutConfig IllIIIllII() {
        return this.lllIlIlIIl;
    }

    public boolean IllIIlIIII() {
        return this.lIlIIIIlIl;
    }

    public RecognizerBundle lIIIIIllll() {
        return this.llIIlIlIIl;
    }

    public Runnable lIlIIIIlIl() {
        return this.llIIIlllll;
    }

    public DebugImageListener llIIIlllll() {
        return this.IIlIIIllIl;
    }

    public QuadViewPreset llIIlIIlll() {
        return this.lllIIIlIlI;
    }

    public int llIIlIlIIl() {
        return this.llIIlIIlll;
    }

    public ScanRegionOfInterestSettings lllIIIlIlI() {
        return this.IllIIIllII;
    }

    public StatusMessageTranslator lllIlIlIIl() {
        return this.IllIIlIIII;
    }

    private BasicOverlaySettings(RecognizerBundle recognizerBundle, OverlayCameraSettings overlayCameraSettings, ScanRegionOfInterestSettings scanRegionOfInterestSettings, Runnable runnable, int i, boolean z, int i2, DebugImageListener debugImageListener, OverlayOrientation overlayOrientation, QuadViewPreset quadViewPreset, RecognitionFeedbackHandler recognitionFeedbackHandler, ControlsLayoutConfig controlsLayoutConfig, StatusMessageTranslator statusMessageTranslator) {
        this.llIIlIlIIl = recognizerBundle;
        this.IlIllIlIIl = overlayCameraSettings;
        this.IllIIIllII = scanRegionOfInterestSettings;
        this.llIIIlllll = runnable;
        this.IllIIIIllI = i;
        this.lIlIIIIlIl = z;
        this.llIIlIIlll = i2;
        this.IIlIIIllIl = debugImageListener;
        this.lIIIIIllll = overlayOrientation;
        this.lllIIIlIlI = quadViewPreset;
        this.IlIllIlllI = recognitionFeedbackHandler;
        this.lllIlIlIIl = controlsLayoutConfig;
        this.IllIIlIIII = statusMessageTranslator;
    }
}
