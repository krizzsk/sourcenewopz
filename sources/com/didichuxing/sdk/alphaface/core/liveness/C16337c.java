package com.didichuxing.sdk.alphaface.core.liveness;

import com.didichuxing.sdk.alphaface.core.liveness.ILivenessCallback;
import com.didichuxing.sdk.alphaface.core.liveness.IMirrorCallback;
import com.didichuxing.sdk.alphaface.utils.UIHandler;
import java.util.List;

/* renamed from: com.didichuxing.sdk.alphaface.core.liveness.c */
/* compiled from: CallbackWrapper */
final class C16337c implements ILivenessCallback {

    /* renamed from: a */
    final ILivenessCallback f48730a;

    /* renamed from: b */
    final LivenessManager f48731b;

    /* renamed from: c */
    private final int f48732c;

    /* renamed from: d */
    private final int f48733d;

    /* renamed from: e */
    private int f48734e = -1;

    /* renamed from: f */
    private int f48735f = 0;

    /* renamed from: g */
    private final int f48736g;

    /* renamed from: h */
    private int f48737h = 0;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public final LivenessResult f48738i;

    public C16337c(LivenessManager livenessManager) {
        this.f48731b = livenessManager;
        this.f48730a = livenessManager.mo120617b().getCallback();
        this.f48732c = livenessManager.mo120617b().getDetectTime();
        this.f48733d = livenessManager.mo120617b().getFaceErrorCountMax();
        this.f48736g = livenessManager.mo120617b().getActionTimeout();
        this.f48738i = new LivenessResult();
    }

    public void onFaceError(int i) {
        UIHandler.post(new CallbackWrapper$1(this, i));
    }

    public void onStartAction(int[] iArr) {
        UIHandler.post(new CallbackWrapper$2(this, iArr));
    }

    public void onDetectFace(IMirrorCallback.FaceInfo faceInfo) {
        UIHandler.post(new CallbackWrapper$3(this, faceInfo));
    }

    public void onMirrorSuccess(List<ILivenessCallback.PicWithScore> list, List<ILivenessCallback.PicWithScore> list2, List<ILivenessCallback.PicWithScore> list3) {
        this.f48738i.mo120628a(list, list2, list3);
        UIHandler.post(new CallbackWrapper$4(this, list, list2, list3));
    }

    public void onMirrorFaceQualityError() {
        UIHandler.post(new CallbackWrapper$5(this));
    }

    public void onMirrorProcess(long j) {
        UIHandler.post(new CallbackWrapper$6(this, (int) ((j * 100) / ((long) this.f48732c))));
    }

    public void onMirrorReset() {
        this.f48738i.mo120626a();
        UIHandler.post(new CallbackWrapper$7(this));
    }

    public void onActionReset() {
        UIHandler.post(new CallbackWrapper$8(this));
    }

    public void onActionCountdown(int i) {
        UIHandler.post(new CallbackWrapper$9(this, i));
    }

    public void onActionTimeout() {
        this.f48731b.exit();
        UIHandler.post(new CallbackWrapper$10(this));
    }

    public void onActionChange(int i, int i2, int i3, int i4) {
        UIHandler.post(new CallbackWrapper$11(this, i, i2, i3, i4));
    }

    public void onActionSuccess(List<ILivenessCallback.PicWithScore> list) {
        this.f48738i.mo120627a(list);
        this.f48731b.exit();
        UIHandler.post(new CallbackWrapper$12(this, list));
    }

    public void onActionInfo(int i, int i2, int i3, int[] iArr) {
        UIHandler.post(new CallbackWrapper$13(this, i, i2, i3, iArr));
    }

    public void onActionTip(int i) {
        if (i != this.f48737h) {
            this.f48737h = i;
            UIHandler.post(new CallbackWrapper$14(this, i));
        }
    }

    public void onActionFailed() {
        this.f48731b.exit();
        UIHandler.post(new CallbackWrapper$15(this));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo120641a(int i) {
        if (this.f48734e == i) {
            onFaceError(i);
        } else {
            this.f48734e = i;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo120642b(int i) {
        int i2 = this.f48735f;
        if (i2 == this.f48733d) {
            this.f48735f = 0;
            this.f48731b.reset();
            onFaceError(i);
            return;
        }
        this.f48735f = i2 + 1;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public void mo120643c(int i) {
        int i2 = this.f48735f;
        if (i2 == this.f48733d) {
            this.f48735f = 0;
            onFaceError(i);
            return;
        }
        this.f48735f = i2 + 1;
    }

    public void onSuccess(LivenessResult livenessResult) {
        UIHandler.post(new CallbackWrapper$16(this, livenessResult));
    }

    public void onRestart() {
        UIHandler.post(new CallbackWrapper$17(this));
    }
}
