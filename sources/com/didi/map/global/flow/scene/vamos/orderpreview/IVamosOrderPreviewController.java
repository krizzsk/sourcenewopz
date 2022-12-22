package com.didi.map.global.flow.scene.vamos.orderpreview;

import android.view.View;
import com.didi.map.global.flow.scene.ISceneController;

public interface IVamosOrderPreviewController extends ISceneController {
    void updateEndMarkerBubble(View view);

    void updateStartMarkerBubble(View view);
}
