package com.didi.map.global.flow.scene.vamos.orderwait;

import android.view.View;
import com.didi.map.global.flow.scene.ISceneController;

public interface IVamosOrderWaitController extends ISceneController {
    void updateEndMarkerBubble(View view);

    void updateStartMarkerBubble(View view);
}
