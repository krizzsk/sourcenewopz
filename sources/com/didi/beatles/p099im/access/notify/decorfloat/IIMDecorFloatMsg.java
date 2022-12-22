package com.didi.beatles.p099im.access.notify.decorfloat;

import android.animation.Animator;
import android.app.Activity;
import android.view.View;

/* renamed from: com.didi.beatles.im.access.notify.decorfloat.IIMDecorFloatMsg */
public interface IIMDecorFloatMsg<T> {

    /* renamed from: com.didi.beatles.im.access.notify.decorfloat.IIMDecorFloatMsg$RequestCallback */
    public interface RequestCallback {
        void requestCancelDismissTask();

        void requestDismiss(int i);
    }

    boolean canShowFloat(Activity activity);

    T getData();

    long getDisplayDuration();

    Animator getEnterAnimator(View view);

    Animator getExitAnimator(View view);

    View getView(Activity activity, RequestCallback requestCallback);

    boolean showNotification();
}
