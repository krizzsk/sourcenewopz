package com.didichuxing.sdk.alphaface.core.liveness;

import com.didichuxing.sdk.alphaface.core.liveness.ILivenessCallback;
import com.didichuxing.sdk.alphaface.core.liveness.IMirrorCallback;
import java.util.List;

public class LivenessCallbackAdapter implements ILivenessCallback {
    public void onActionChange(int i, int i2, int i3, int i4) {
    }

    public void onActionCountdown(int i) {
    }

    public void onActionFailed() {
    }

    public void onActionInfo(int i, int i2, int i3, int[] iArr) {
    }

    public void onActionReset() {
    }

    public void onActionSuccess(List<ILivenessCallback.PicWithScore> list) {
    }

    public void onActionTimeout() {
    }

    public void onActionTip(int i) {
    }

    public void onDetectFace(IMirrorCallback.FaceInfo faceInfo) {
    }

    public void onFaceError(int i) {
    }

    public void onMirrorFaceQualityError() {
    }

    public void onMirrorProcess(long j) {
    }

    public void onMirrorReset() {
    }

    public void onMirrorSuccess(List<ILivenessCallback.PicWithScore> list, List<ILivenessCallback.PicWithScore> list2, List<ILivenessCallback.PicWithScore> list3) {
    }

    public void onRestart() {
    }

    public void onStartAction(int[] iArr) {
    }

    public void onSuccess(LivenessResult livenessResult) {
    }
}
