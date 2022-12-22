package com.didiglobal.p205sa.biz.component.safeToolKit.view;

import com.didi.component.never.core.IView;
import com.didi.safetoolkit.business.bubble.model.SfBubbleData;
import com.didi.safetoolkit.business.bubble.model.SfJarvisData;
import com.didiglobal.p205sa.biz.component.safeToolKit.presenter.SAIJarvisPresenter;

/* renamed from: com.didiglobal.sa.biz.component.safeToolKit.view.SAIJarvisView */
public interface SAIJarvisView extends IView<SAIJarvisPresenter> {
    void closeSafePanel();

    void onBackHome();

    void onLeaveHome();

    void onRemove();

    void setBubbleData(SfBubbleData sfBubbleData);

    void setJarvisData(SfJarvisData sfJarvisData);
}
