package com.didi.map.global.flow.scene.order.waiting;

import android.view.View;
import com.didi.common.map.listener.CancelableCallback;
import com.didi.common.map.model.CameraPosition;
import com.didi.map.global.flow.scene.ISceneController;

public interface IWaitingForReplyController extends ISceneController {
    void animateCamera(CameraPosition cameraPosition, int i, CancelableCallback cancelableCallback);

    void sendOrderSuc(String str, String str2);

    void updateWaitingForReplyBubble(View view);
}
