package com.microblink.blinkbarcode.uisettings;

import android.content.Intent;
import com.microblink.blinkbarcode.activity.BarcodeScanActivity;
import com.microblink.blinkbarcode.entities.recognizers.RecognizerBundle;
import com.microblink.blinkbarcode.fragment.overlay.basic.BasicOverlaySettings;
import com.microblink.blinkbarcode.fragment.overlay.components.feedback.PointSetFeedbackHandler;
import com.microblink.blinkbarcode.fragment.overlay.components.settings.ControlsLayoutConfig;
import com.microblink.blinkbarcode.metadata.detection.points.PointsType;
import com.microblink.blinkbarcode.view.viewfinder.quadview.QuadViewPreset;

/* compiled from: line */
public class BarcodeUISettings extends BasicScanUISettings {
    public BarcodeUISettings(RecognizerBundle recognizerBundle) {
        super(recognizerBundle);
    }

    public BasicOverlaySettings.Builder createOverlaySettingsBuilder() {
        return new BasicOverlaySettings.Builder(getRecognizerBundle()).setQuadViewPreset(QuadViewPreset.DEFAULT_CORNERS_FROM_BARCODE_SCAN_ACTIVITY).setRecognitionFeedbackHandler(new PointSetFeedbackHandler(PointsType.BARCODE_DETECTION)).setControlsLayoutConfig(ControlsLayoutConfig.createDefault());
    }

    public Class<?> getTargetActivity() {
        return BarcodeScanActivity.class;
    }

    public BarcodeUISettings(Intent intent) {
        super(intent);
    }
}
