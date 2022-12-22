package com.didichuxing.diface.biz.bioassay.self_liveness;

import com.didichuxing.sdk.alphaface.core.liveness.ILivenessCallback;
import com.didichuxing.sdk.alphaface.core.liveness.IMirrorCallback;
import com.didichuxing.sdk.alphaface.core.liveness.LivenessResult;
import java.util.Collections;
import java.util.List;

public class LivenessWrapper implements ILivenessCallback {

    /* renamed from: a */
    private final List<ILivenessCallback> f47321a;

    public LivenessWrapper(List<ILivenessCallback> list) {
        this.f47321a = Collections.unmodifiableList(list);
    }

    public void onStartAction(int[] iArr) {
        for (ILivenessCallback onStartAction : this.f47321a) {
            onStartAction.onStartAction(iArr);
        }
    }

    public void onSuccess(LivenessResult livenessResult) {
        for (ILivenessCallback onSuccess : this.f47321a) {
            onSuccess.onSuccess(livenessResult);
        }
    }

    public void onActionChange(int i, int i2, int i3, int i4) {
        for (ILivenessCallback onActionChange : this.f47321a) {
            onActionChange.onActionChange(i, i2, i3, i4);
        }
    }

    public void onActionSuccess(List<ILivenessCallback.PicWithScore> list) {
        for (ILivenessCallback onActionSuccess : this.f47321a) {
            onActionSuccess.onActionSuccess(list);
        }
    }

    public void onActionFailed() {
        for (ILivenessCallback onActionFailed : this.f47321a) {
            onActionFailed.onActionFailed();
        }
    }

    public void onActionInfo(int i, int i2, int i3, int[] iArr) {
        for (ILivenessCallback onActionInfo : this.f47321a) {
            onActionInfo.onActionInfo(i, i2, i3, iArr);
        }
    }

    public void onActionTip(int i) {
        for (ILivenessCallback onActionTip : this.f47321a) {
            onActionTip.onActionTip(i);
        }
    }

    public void onActionCountdown(int i) {
        for (ILivenessCallback onActionCountdown : this.f47321a) {
            onActionCountdown.onActionCountdown(i);
        }
    }

    public void onActionTimeout() {
        for (ILivenessCallback onActionTimeout : this.f47321a) {
            onActionTimeout.onActionTimeout();
        }
    }

    public void onActionReset() {
        for (ILivenessCallback onActionReset : this.f47321a) {
            onActionReset.onActionReset();
        }
    }

    public void onFaceError(int i) {
        for (ILivenessCallback onFaceError : this.f47321a) {
            onFaceError.onFaceError(i);
        }
    }

    public void onDetectFace(IMirrorCallback.FaceInfo faceInfo) {
        for (ILivenessCallback onDetectFace : this.f47321a) {
            onDetectFace.onDetectFace(faceInfo);
        }
    }

    public void onMirrorSuccess(List<ILivenessCallback.PicWithScore> list, List<ILivenessCallback.PicWithScore> list2, List<ILivenessCallback.PicWithScore> list3) {
        for (ILivenessCallback onMirrorSuccess : this.f47321a) {
            onMirrorSuccess.onMirrorSuccess(list, list2, list3);
        }
    }

    public void onMirrorFaceQualityError() {
        for (ILivenessCallback onMirrorFaceQualityError : this.f47321a) {
            onMirrorFaceQualityError.onMirrorFaceQualityError();
        }
    }

    public void onMirrorProcess(long j) {
        for (ILivenessCallback onMirrorProcess : this.f47321a) {
            onMirrorProcess.onMirrorProcess(j);
        }
    }

    public void onMirrorReset() {
        for (ILivenessCallback onMirrorReset : this.f47321a) {
            onMirrorReset.onMirrorReset();
        }
    }

    public void onRestart() {
        for (ILivenessCallback onRestart : this.f47321a) {
            onRestart.onRestart();
        }
    }
}
