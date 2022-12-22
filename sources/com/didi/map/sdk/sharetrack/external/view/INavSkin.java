package com.didi.map.sdk.sharetrack.external.view;

import android.view.View;
import com.didi.map.sdk.nav.car.CameraMode;

public interface INavSkin {
    void changeNightMode(boolean z);

    void destroy();

    CameraMode getCameraMode();

    View getSkinRootView();

    boolean isVisible();

    void setOnSkinInteractionListener(OnSkinInteractionListener onSkinInteractionListener);

    void setOrderId(String str);

    void setSafeToolView(View view);

    void setSkinVisibility(int i);

    void setTelephoneView(View view);

    void updateCameraMode(CameraMode cameraMode);

    void updateEtaEda(int i, int i2);

    void updateZoomBackVisibility(boolean z);
}
