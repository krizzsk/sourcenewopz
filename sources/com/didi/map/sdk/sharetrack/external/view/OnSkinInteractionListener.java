package com.didi.map.sdk.sharetrack.external.view;

import android.view.View;
import com.didi.map.sdk.nav.car.CameraMode;

public interface OnSkinInteractionListener {
    void onCloseClicked();

    void onMapPaddingCalculateComplete(int i, int i2, int i3, int i4);

    void onMaskDragged();

    void onSafeToolClicked(View view);

    void onSettingToolClicked();

    void onSwitchCameraModeClicked(CameraMode cameraMode);

    void onTelClicked(View view);

    void onZoomBackClicked(CameraMode cameraMode);
}
