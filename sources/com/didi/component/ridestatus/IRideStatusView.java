package com.didi.component.ridestatus;

import android.graphics.drawable.Drawable;
import com.didi.component.core.IView;

public interface IRideStatusView extends IView<AbsRideStatusPresenter> {
    void setActivityIcon(String str);

    void setContentText(String str);

    void setContentVisible(boolean z);

    void setContentWarning(boolean z);

    void setContextTextMinLines(int i);

    void setIcon(Drawable drawable);

    void setPlaceHolderTitle(String str);

    void setPlaceHolderTitleVisible(boolean z);

    void setTimeTextVisible(boolean z);

    void setTipText(String str);

    void setTitleText(String str);

    void setTitleVisible(boolean z);

    void setTitleWarning(boolean z);

    void showWhyWaitIcon(boolean z);

    void startLottieAnimation(String str, String str2, long j);

    void startSubTitleFadeInAnimation(long j);

    void startTitleFadeInAnimation(long j);
}
