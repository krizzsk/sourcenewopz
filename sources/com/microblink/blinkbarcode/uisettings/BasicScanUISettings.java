package com.microblink.blinkbarcode.uisettings;

import android.app.Activity;
import android.content.Intent;
import android.os.Parcelable;
import com.microblink.blinkbarcode.entities.recognizers.Recognizer;
import com.microblink.blinkbarcode.entities.recognizers.RecognizerBundle;
import com.microblink.blinkbarcode.fragment.overlay.basic.BasicOverlayController;
import com.microblink.blinkbarcode.fragment.overlay.basic.BasicOverlaySettings;
import com.microblink.blinkbarcode.fragment.overlay.components.settings.ScanRegionOfInterestSettings;
import com.microblink.blinkbarcode.geometry.Rectangle;
import com.microblink.blinkbarcode.image.DebugImageListener;
import com.microblink.blinkbarcode.library.R;
import com.microblink.blinkbarcode.uisettings.options.BeepSoundUIOptions;
import com.microblink.blinkbarcode.uisettings.options.DebugImageListenerUIOptions;
import com.microblink.blinkbarcode.uisettings.options.HelpIntentUIOptions;
import com.microblink.blinkbarcode.uisettings.options.HighResSuccessFrameCaptureUIOptions;
import com.microblink.blinkbarcode.uisettings.options.OverlayOrientation;
import com.microblink.blinkbarcode.uisettings.options.SplashScreenUIOptions;
import com.microblink.blinkbarcode.view.recognition.ScanResultListener;
import java.io.Serializable;

/* compiled from: line */
public abstract class BasicScanUISettings extends UISettings<BasicOverlayController> implements BeepSoundUIOptions, DebugImageListenerUIOptions, HelpIntentUIOptions, HighResSuccessFrameCaptureUIOptions, SplashScreenUIOptions {
    private static final String IIlIIIllIl = UISettings.llIIlIlIIl("BasicScanActivity", "roiRotatable");
    private static final String IlIllIlllI = UISettings.llIIlIlIIl("BasicScanActivity", "imageListener");
    private static final String IllIIlIIII = UISettings.llIIlIlIIl("BasicScanActivity", "overlayOrientation");
    private static final String lIIIIIlIlI = UISettings.llIIlIlIIl("BasicScanActivity", "helpIntent");
    private static final String lIIIIIllll = UISettings.llIIlIlIIl("BasicScanActivity", "beepResource");
    private static final String llIIlIIlll = UISettings.llIIlIlIIl("BasicScanActivity", "roi");
    private static final String lllIIIlIlI = UISettings.llIIlIlIIl("BasicScanActivity", "splashResource");
    private static final String lllIlIlIIl = UISettings.llIIlIlIIl("BasicScanActivity", "highResCapture");
    private final RecognizerBundle lIlIIIIlIl;

    public BasicScanUISettings(RecognizerBundle recognizerBundle) {
        this.lIlIIIIlIl = recognizerBundle;
    }

    private int IlIllIlIIl() {
        return IlIllIlIIl(lllIIIlIlI, R.layout.mb_camera_splash);
    }

    public abstract BasicOverlaySettings.Builder createOverlaySettingsBuilder();

    public void enableHighResSuccessFrameCapture(boolean z) {
        llIIlIlIIl(lllIlIlIIl, z);
    }

    public RecognizerBundle getRecognizerBundle() {
        return this.lIlIIIIlIl;
    }

    public final void saveToIntent(Intent intent) {
        super.saveToIntent(intent);
        this.lIlIIIIlIl.saveToIntent(intent);
    }

    public final void setBeepSoundResourceID(int i) {
        llIIlIlIIl(lIIIIIllll, i);
    }

    public final void setDebugImageListener(DebugImageListener debugImageListener) {
        llIIlIlIIl(IlIllIlllI, (Parcelable) debugImageListener);
    }

    public void setForcedOrientation(OverlayOrientation overlayOrientation) {
        llIIlIlIIl(IllIIlIIII, (Serializable) overlayOrientation);
    }

    public final void setHelpIntent(Intent intent) {
        llIIlIlIIl(lIIIIIlIlI, (Parcelable) intent);
    }

    public final void setRegionOfInterestRotatable(boolean z) {
        llIIlIlIIl(IIlIIIllIl, z);
    }

    public final void setScanRegionOfInterest(Rectangle rectangle) {
        llIIlIlIIl(llIIlIIlll, (Parcelable) rectangle);
    }

    public final void setSplashScreenLayoutResourceID(int i) {
        llIIlIlIIl(lllIIIlIlI, i);
    }

    public BasicOverlayController createOverlayController(final Activity activity, ScanResultListener scanResultListener) {
        BasicOverlaySettings.Builder scanRegionOfInterestSettings = createOverlaySettingsBuilder().setCameraSettings(llIIlIlIIl()).setScanRegionOfInterestSettings(new ScanRegionOfInterestSettings((Rectangle) llIIlIlIIl(llIIlIIlll), IlIllIlIIl(IIlIIIllIl, false)));
        final Intent intent = (Intent) llIIlIlIIl(lIIIIIlIlI);
        return new BasicOverlayController(scanRegionOfInterestSettings.setHelpAction(intent != null ? new Runnable(this) {
            public void run() {
                activity.startActivity(intent);
            }
        } : null).setSplashResourceId(IlIllIlIIl()).setHighResFrameCaptureEnabled(IlIllIlIIl(lllIlIlIIl, false)).setBeepSoundId(IlIllIlIIl(lIIIIIllll, 0)).setDebugImageListener((DebugImageListener) llIIlIlIIl(IlIllIlllI)).setForcedOrientation((OverlayOrientation) IlIllIlIIl(IllIIlIIII)).build(), scanResultListener);
    }

    public BasicScanUISettings(Intent intent) {
        super(intent);
        RecognizerBundle recognizerBundle = new RecognizerBundle(new Recognizer[0]);
        this.lIlIIIIlIl = recognizerBundle;
        recognizerBundle.loadFromIntent(intent);
    }
}
