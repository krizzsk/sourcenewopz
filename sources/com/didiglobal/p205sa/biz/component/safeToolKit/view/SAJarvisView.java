package com.didiglobal.p205sa.biz.component.safeToolKit.view;

import android.content.Context;
import android.view.View;
import com.didi.global.globaluikit.utils.UiUtils;
import com.didi.safetoolkit.business.bubble.ISfJarvisController;
import com.didi.safetoolkit.business.bubble.SfJarvisController;
import com.didi.safetoolkit.business.bubble.model.SfBubbleData;
import com.didi.safetoolkit.business.bubble.model.SfJarvisData;
import com.didiglobal.p205sa.biz.component.safeToolKit.presenter.SAIJarvisPresenter;

/* renamed from: com.didiglobal.sa.biz.component.safeToolKit.view.SAJarvisView */
public class SAJarvisView implements SAIJarvisView {

    /* renamed from: a */
    private ISfJarvisController f51090a;

    /* renamed from: b */
    private View f51091b;

    /* renamed from: c */
    private Context f51092c;

    public void setPresenter(SAIJarvisPresenter sAIJarvisPresenter) {
    }

    public SAJarvisView(Context context) {
        this.f51092c = context;
        SfJarvisController sfJarvisController = new SfJarvisController(context, UiUtils.dip2px(context, 40.0f));
        this.f51090a = sfJarvisController;
        this.f51091b = sfJarvisController.getView();
    }

    public View getView() {
        return this.f51091b;
    }

    public void setJarvisData(SfJarvisData sfJarvisData) {
        ISfJarvisController iSfJarvisController = this.f51090a;
        if (iSfJarvisController != null) {
            iSfJarvisController.refreshJarvisData(sfJarvisData);
        }
    }

    public void closeSafePanel() {
        ISfJarvisController iSfJarvisController = this.f51090a;
        if (iSfJarvisController != null) {
            iSfJarvisController.closeSafePanel();
        }
    }

    public void onRemove() {
        ISfJarvisController iSfJarvisController = this.f51090a;
        if (iSfJarvisController != null) {
            iSfJarvisController.onRemove();
            this.f51090a.removeCallback();
        }
    }

    public void onLeaveHome() {
        ISfJarvisController iSfJarvisController = this.f51090a;
        if (iSfJarvisController != null) {
            iSfJarvisController.onRemove();
        }
    }

    public void onBackHome() {
        ISfJarvisController iSfJarvisController = this.f51090a;
        if (iSfJarvisController != null) {
            iSfJarvisController.init();
        }
    }

    public void setBubbleData(SfBubbleData sfBubbleData) {
        ISfJarvisController iSfJarvisController = this.f51090a;
        if (iSfJarvisController != null) {
            iSfJarvisController.setBubbleStatusAndShow(sfBubbleData);
        }
    }
}
