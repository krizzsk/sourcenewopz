package com.microblink.blinkbarcode.uisettings;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import com.microblink.blinkbarcode.fragment.overlay.ScanningOverlay;
import com.microblink.blinkbarcode.fragment.overlay.components.settings.OverlayCameraSettings;
import com.microblink.blinkbarcode.view.recognition.ScanResultListener;
import java.io.Serializable;

/* compiled from: line */
public abstract class UISettings<ScanOverlayType extends ScanningOverlay> {
    private static final String IlIllIlIIl = llIIlIlIIl("Common", "usingFlagSecure");
    private static final String IllIIIIllI = llIIlIlIIl("Common", "activityTheme");
    private static final String IllIIIllII = llIIlIlIIl("Common", "filterTouchesWhenObscured");
    private static final String llIIIlllll = llIIlIlIIl("Common", "cameraSettings");
    private Bundle llIIlIlIIl;

    public UISettings() {
        this.llIIlIlIIl = new Bundle();
    }

    public final Serializable IlIllIlIIl(String str) {
        return this.llIIlIlIIl.getSerializable(str);
    }

    public abstract ScanOverlayType createOverlayController(Activity activity, ScanResultListener scanResultListener);

    public final int getActivityTheme() {
        return this.llIIlIlIIl.getInt(IllIIIIllI, 0);
    }

    public final boolean getFilterTouchesWhenObscured() {
        return this.llIIlIlIIl.getBoolean(IllIIIllII, false);
    }

    public abstract Class<?> getTargetActivity();

    public final boolean getUsingFlagSecure() {
        return this.llIIlIlIIl.getBoolean(IlIllIlIIl, false);
    }

    public OverlayCameraSettings llIIlIlIIl() {
        CameraSettings cameraSettings = (CameraSettings) this.llIIlIlIIl.getParcelable(llIIIlllll);
        OverlayCameraSettings.Builder builder = new OverlayCameraSettings.Builder();
        if (cameraSettings != null) {
            builder.setAspectMode(cameraSettings.aspectMode);
            builder.setForceLegacyApi(cameraSettings.forceLegacyApi);
            builder.setIsOptimizedForNearScan(cameraSettings.isOptimizedForNearScan);
            builder.setIsPinchToZoomAllowed(cameraSettings.isPinchToZoomAllowed);
            builder.setSurface(cameraSettings.surface);
            builder.setType(cameraSettings.type);
            builder.setVideoResolutionPreset(cameraSettings.videoResolutionPreset);
        }
        return builder.build();
    }

    public void saveToIntent(Intent intent) {
        intent.putExtra("com.microblink.blinkbarcode.activity.extras.settingsBundle", this.llIIlIlIIl);
    }

    public final void setActivityTheme(int i) {
        this.llIIlIlIIl.putInt(IllIIIIllI, i);
    }

    public final void setCameraSettings(CameraSettings cameraSettings) {
        this.llIIlIlIIl.putParcelable(llIIIlllll, cameraSettings);
    }

    public final void setFilterTouchesWhenObscured(boolean z) {
        this.llIIlIlIIl.putBoolean(IllIIIllII, z);
    }

    public final void setUsingFlagSecure(boolean z) {
        this.llIIlIlIIl.putBoolean(IlIllIlIIl, z);
    }

    public final int IlIllIlIIl(String str, int i) {
        return this.llIIlIlIIl.getInt(str, i);
    }

    public UISettings(Intent intent) {
        Bundle bundleExtra = intent.getBundleExtra("com.microblink.blinkbarcode.activity.extras.settingsBundle");
        this.llIIlIlIIl = bundleExtra;
        if (bundleExtra == null) {
            this.llIIlIlIIl = new Bundle();
        }
    }

    public final boolean IlIllIlIIl(String str, boolean z) {
        return this.llIIlIlIIl.getBoolean(str, z);
    }

    public final void llIIlIlIIl(String str, Parcelable parcelable) {
        this.llIIlIlIIl.putParcelable(str, parcelable);
    }

    public final <T extends Parcelable> T llIIlIlIIl(String str) {
        return this.llIIlIlIIl.getParcelable(str);
    }

    public final void llIIlIlIIl(String str, Serializable serializable) {
        this.llIIlIlIIl.putSerializable(str, serializable);
    }

    public final void llIIlIlIIl(String str, int i) {
        this.llIIlIlIIl.putInt(str, i);
    }

    public final void llIIlIlIIl(String str, boolean z) {
        this.llIIlIlIIl.putBoolean(str, z);
    }

    public static String llIIlIlIIl(String str, String str2) {
        return "mb." + str + "." + str2;
    }
}
