package com.didiglobal.p205sa.biz.component.safeToolKit;

import android.view.ViewGroup;
import com.didi.component.never.base.BaseComponent;
import com.didi.component.never.core.ComponentParams;
import com.didi.component_processor.annonation.ComponentName;
import com.didiglobal.p205sa.biz.component.safeToolKit.presenter.SAIJarvisPresenter;
import com.didiglobal.p205sa.biz.component.safeToolKit.presenter.SAJarvisPresenter;
import com.didiglobal.p205sa.biz.component.safeToolKit.view.SAIJarvisView;
import com.didiglobal.p205sa.biz.component.safeToolKit.view.SAJarvisView;

@ComponentName(category = 2, type = "component_sa_safe_jarvis")
/* renamed from: com.didiglobal.sa.biz.component.safeToolKit.SAJarvisComponent */
public class SAJarvisComponent extends BaseComponent<SAIJarvisView, SAIJarvisPresenter> {
    /* access modifiers changed from: protected */
    public SAIJarvisView onCreateView(ComponentParams componentParams, ViewGroup viewGroup) {
        return new SAJarvisView(componentParams.getActivity());
    }

    /* access modifiers changed from: protected */
    public SAIJarvisPresenter onCreatePresenter(ComponentParams componentParams) {
        return new SAJarvisPresenter(componentParams);
    }

    public ViewGroup.LayoutParams getLayoutParams(ComponentParams componentParams) {
        return new ViewGroup.LayoutParams(-2, -2);
    }
}
