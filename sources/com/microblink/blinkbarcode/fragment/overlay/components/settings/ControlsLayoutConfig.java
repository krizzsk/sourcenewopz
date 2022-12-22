package com.microblink.blinkbarcode.fragment.overlay.components.settings;

import com.microblink.blinkbarcode.library.R;

/* compiled from: line */
public class ControlsLayoutConfig {
    public final int backButtonId;
    public final int helpButtonId;
    public final int layoutId;
    public final int statusTextId;
    public final int torchButtonId;

    public ControlsLayoutConfig(int i, int i2, int i3, int i4, int i5) {
        this.layoutId = i;
        this.torchButtonId = i2;
        this.backButtonId = i3;
        this.helpButtonId = i4;
        this.statusTextId = i5;
    }

    public static ControlsLayoutConfig createDefault() {
        return new ControlsLayoutConfig(R.layout.mb_default_camera_overlay, R.id.defaultTorchButton, R.id.defaultBackButton, R.id.defaultHelpButton, 0);
    }

    public static ControlsLayoutConfig createDefaultWithStatus() {
        return new ControlsLayoutConfig(R.layout.mb_default_camera_overlay_with_status, R.id.defaultTorchButton, R.id.defaultBackButton, R.id.defaultHelpButton, R.id.defaultStatusTextSwitcher);
    }
}
