package com.didichuxing.sdk.alphaface.core.liveness;

import com.didichuxing.sdk.alphaface.core.liveness.ILivenessCallback;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.List;

public interface IActionCallback {
    public static final int ACTION_BLINK_EYE = 1;
    public static final int ACTION_DONE = 5;
    public static final int ACTION_NO = 0;
    public static final int ACTION_NOD = 4;
    public static final int ACTION_OPEN_MOUTH = 2;
    public static final int ACTION_SHAKE_HEAD = 3;

    @Retention(RetentionPolicy.SOURCE)
    public @interface Action {
    }

    void onActionChange(int i, int i2, int i3, int i4);

    void onActionCountdown(int i);

    void onActionFailed();

    void onActionInfo(int i, int i2, int i3, int[] iArr);

    void onActionReset();

    void onActionSuccess(List<ILivenessCallback.PicWithScore> list);

    void onActionTimeout();

    void onActionTip(int i);

    void onFaceError(int i);

    void onStartAction(int[] iArr);
}
