package com.didi.component.expectation;

import android.animation.Animator;
import android.graphics.drawable.Drawable;
import com.didi.component.business.xpanelnew.IXpCompRefresh;
import com.didi.component.common.model.bubble.CommonBubbleItemModel;
import com.didi.component.core.IView;
import com.didi.component.expectation.impl.WebpLocResEnum;
import com.didi.component.expectation.impl.WebpResEnum;
import com.didi.component.expectation.model.AnyCarRequesting;
import com.didi.component.expectation.model.FlexRaise;
import com.didi.component.expectation.model.ProgressState;
import com.didi.component.expectation.model.UsePrivilege;
import com.didi.global.globaluikit.richinfo.LEGORichInfo;
import com.didi.travel.psnger.model.response.GlobalRichInfo;
import java.util.List;

public interface IExpectationView extends IView<AbsExpectationPresenter> {
    void addProgressNode(List<ProgressState> list);

    void cancelAnim();

    void cancelCircleAnim();

    void closeAnyCarTipComplete(String str);

    void finishProgressBar(int i, int i2);

    void hideCaptionText();

    void hideRichSubtitle();

    void hideSubTitleText();

    void hideTime();

    void hideTips();

    boolean isAnimation();

    void openBoxAndShowCoupon(int i);

    void resetViewStatus();

    void setAnyCarRequestingList(List<AnyCarRequesting> list);

    void setCaptionText(String str);

    void setEquityText(String str);

    void setIsAnyCar(Boolean bool);

    void setMainIcon(WebpLocResEnum webpLocResEnum);

    void setMainIcon(WebpResEnum webpResEnum);

    void setObtainedCouponViewVisibility(int i, int i2);

    void setProgressBar(float f);

    void setRichSubtitle(GlobalRichInfo globalRichInfo);

    void setSceneVisibility(int i);

    void setSubTitleText(CharSequence charSequence);

    void setTime(String str);

    void setTimeDes(String str);

    void setTimes(String str, String str2);

    void setTips(LEGORichInfo lEGORichInfo, String str, String str2);

    void setTipsBackground(Drawable drawable);

    void setTitleText(CharSequence charSequence);

    void setTranslationX(float f);

    void setWaitProgressBar(float f, ProgressState progressState, int i);

    void shakeGiftBox(float f, long j, int i, int i2, Animator.AnimatorListener animatorListener);

    void showAnyCarRequestTip(CommonBubbleItemModel commonBubbleItemModel);

    void showEquityUI(UsePrivilege usePrivilege);

    void showThumb(String str, int i, float f, float f2, int i2, boolean z, int i3, int i4, int i5);

    void startCircleAnim();

    void updateFlex(FlexRaise flexRaise);

    void updateViewByIndriver(boolean z, boolean z2, long j, IXpCompRefresh.IXpCompRefreshCb iXpCompRefreshCb);
}
