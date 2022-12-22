package com.didi.beatles.p099im.access.notify.decorfloat.wrapper;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import com.didi.beatles.p099im.IMCommonContextInfoHelper;
import com.didi.beatles.p099im.access.IMEngine;
import com.didi.beatles.p099im.access.core.IMPushEngine;
import com.didi.beatles.p099im.access.notify.IMFloatWindowController;
import com.didi.beatles.p099im.access.notify.NotificationUtils;
import com.didi.beatles.p099im.access.notify.decorfloat.IIMDecorFloatMsg;
import com.didi.beatles.p099im.access.notify.decorfloat.view.IMFloatMessageCard;
import com.didi.beatles.p099im.module.entity.IMMessage;
import com.didi.beatles.p099im.utils.IMLog;
import com.didi.beatles.p099im.utils.IMViewUtil;
import java.util.ArrayList;

/* renamed from: com.didi.beatles.im.access.notify.decorfloat.wrapper.IMFloatMessageWrapper */
public class IMFloatMessageWrapper implements IIMDecorFloatMsg<IMMessage> {

    /* renamed from: a */
    private static final String f8833a = IMFloatMessageWrapper.class.getSimpleName();

    /* renamed from: b */
    private static final int f8834b = 400;

    /* renamed from: c */
    private static final int f8835c = 200;

    /* renamed from: d */
    private static final int f8836d = 5000;

    /* renamed from: e */
    private final IMMessage f8837e;

    public long getDisplayDuration() {
        return 5000;
    }

    public IMFloatMessageWrapper(IMMessage iMMessage) {
        this.f8837e = iMMessage;
    }

    public IMMessage getData() {
        return this.f8837e;
    }

    public boolean canShowFloat(Activity activity) {
        if (!IMFloatWindowController.isEnable()) {
            return false;
        }
        if (IMEngine.getInstance(activity).getCurrentBusinessConfig(this.f8837e.getSidType(), this.f8837e.getBusinessId()).isOpenGlobalAlert() && IMPushEngine.isInApplication() && !IMPushEngine.inThisMessagePage(this.f8837e)) {
            return true;
        }
        return false;
    }

    public boolean showNotification() {
        IMLog.m6631d(f8833a, "[showNotification]");
        Context context = IMCommonContextInfoHelper.getContext();
        if (context == null) {
            return false;
        }
        NotificationUtils.showPushMsgNotification(context, this.f8837e, new NotificationUtils.NotificationConfig(this.f8837e), true);
        return true;
    }

    public View getView(Activity activity, IIMDecorFloatMsg.RequestCallback requestCallback) {
        IMFloatMessageCard iMFloatMessageCard = new IMFloatMessageCard(activity);
        iMFloatMessageCard.setRequestCallback(requestCallback);
        iMFloatMessageCard.bind(this.f8837e);
        return iMFloatMessageCard;
    }

    public Animator getEnterAnimator(View view) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, "translationY", new float[]{(float) (-IMViewUtil.dp2px(view.getContext(), 78.0f)), 0.0f});
        ofFloat.setDuration(400);
        ofFloat.setInterpolator(new AccelerateDecelerateInterpolator());
        return ofFloat;
    }

    public Animator getExitAnimator(View view) {
        int dp2px = IMViewUtil.dp2px(view.getContext(), 78.0f);
        AnimatorSet animatorSet = new AnimatorSet();
        ArrayList arrayList = new ArrayList();
        arrayList.add(ObjectAnimator.ofFloat(view, "translationY", new float[]{0.0f, (float) (-dp2px)}));
        arrayList.add(ObjectAnimator.ofFloat(view, "alpha", new float[]{1.0f, 0.0f}));
        animatorSet.playTogether(arrayList);
        animatorSet.setDuration(200);
        animatorSet.setInterpolator(new AccelerateInterpolator());
        return animatorSet;
    }
}
