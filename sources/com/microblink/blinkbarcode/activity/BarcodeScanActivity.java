package com.microblink.blinkbarcode.activity;

import android.content.Intent;
import com.microblink.blinkbarcode.fragment.overlay.ScanningOverlay;
import com.microblink.blinkbarcode.fragment.overlay.basic.BasicOverlayController;
import com.microblink.blinkbarcode.uisettings.BarcodeUISettings;

/* compiled from: line */
public final class BarcodeScanActivity extends BaseScanActivity<BarcodeUISettings, BasicOverlayController> {
    public /* bridge */ /* synthetic */ ScanningOverlay getScanningOverlay() {
        return super.getScanningOverlay();
    }

    public /* bridge */ /* synthetic */ void onBackPressed() {
        super.onBackPressed();
    }

    public void saveResultsToIntent(Intent intent) {
        ((BasicOverlayController) this.scanningOverlay).getHighResImagesBundle().saveToIntent(intent);
        ((BarcodeUISettings) this.uiSettings).getRecognizerBundle().saveToIntent(intent);
    }

    public BarcodeUISettings loadUiSettings(Intent intent) {
        return new BarcodeUISettings(intent);
    }
}
