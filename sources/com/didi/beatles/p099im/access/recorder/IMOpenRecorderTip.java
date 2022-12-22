package com.didi.beatles.p099im.access.recorder;

import android.app.Activity;
import com.didi.beatles.p099im.views.IMAudioDialog;

/* renamed from: com.didi.beatles.im.access.recorder.IMOpenRecorderTip */
public class IMOpenRecorderTip {

    /* renamed from: a */
    private IMAudioDialog f8847a;

    public IMOpenRecorderTip(Activity activity) {
        this.f8847a = new IMAudioDialog(activity);
    }

    public void show() {
        this.f8847a.show();
        this.f8847a.setTip(false);
    }

    public boolean isShowing() {
        return this.f8847a.isShowing();
    }

    public void dismiss() {
        this.f8847a.dissMissAudioDialog();
    }

    public void setTip(boolean z) {
        this.f8847a.setTip(z);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public IMAudioDialog mo41675a() {
        return this.f8847a;
    }
}
