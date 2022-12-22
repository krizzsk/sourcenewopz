package com.didi.map.global.flow.scene.order.waiting;

import android.view.View;
import com.didi.common.map.listener.CancelableCallback;
import com.didi.common.map.model.CameraPosition;
import com.didi.common.map.model.CameraUpdateFactory;
import com.didi.common.map.model.Padding;
import com.didi.map.global.component.mapviewholder.MapViewHolder;
import com.didi.map.global.flow.model.Bundle;
import com.didi.map.global.flow.scene.IScene;
import com.didi.map.global.flow.scene.PageScene;

@IScene.Scene(mo74615id = 1004)
public class WaitingForReplyScene extends PageScene<WaitingForReplyParam> implements IWaitingForReplyController {
    public void sendOrderSuc(String str, String str2) {
    }

    public WaitingForReplyScene(WaitingForReplyParam waitingForReplyParam, MapViewHolder mapViewHolder) {
        super(waitingForReplyParam, mapViewHolder);
    }

    public void enter(Bundle bundle) {
        super.enter(bundle);
    }

    public void leave() {
        super.leave();
    }

    public void onResume() {
        if (!this.isSceneValid) {
        }
    }

    public void onPause() {
        if (!this.isSceneValid) {
        }
    }

    public void doBestView(Padding padding) {
        super.doBestView(padding);
        if (this.isSceneValid && getMap() != null) {
            hideResetView();
            this.mHandler.removeCallbacksAndMessages((Object) null);
            getMap().setPadding(padding.left, padding.top, padding.right, padding.bottom);
        }
    }

    public void updateWaitingForReplyBubble(View view) {
        if (!this.isSceneValid) {
        }
    }

    public void animateCamera(CameraPosition cameraPosition, int i, CancelableCallback cancelableCallback) {
        if (cameraPosition != null && getMap() != null) {
            getMap().animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition), i, cancelableCallback);
        }
    }
}
