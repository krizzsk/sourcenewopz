package com.didi.map.global.flow.scene.vamos.sctx.driver;

import android.view.View;
import com.didi.map.global.flow.scene.ISceneController;
import com.didi.map.sdk.nav.car.CameraMode;

public interface IVamosDriverSctxController extends ISceneController {
    void onNavButtonClick();

    void setCameraMode(CameraMode cameraMode);

    void updateMarkerBubble(View view);
}
