package com.didi.component.business.xpanel.sdk.component;

import android.view.ViewGroup;
import com.didi.component.base.BaseComponent;
import com.didi.component.business.xpanel.sdk.component.InflateController;
import com.didi.component.common.util.GLog;
import com.didi.component.core.ComponentParams;
import com.didi.component.core.IPresenter;
import com.didi.component.core.IView;

public abstract class SelfControlComponent<V extends IView, P extends IPresenter, C extends InflateController> extends BaseComponent<V, P> implements InflateController {
    public static final String BUNDLE_KEY_FROM_XPANEL = "BUNDLE_KEY_FROM_XPANEL";
    protected C mInflateController = createInflateController();
    public boolean mIsDefaultVisible = true;

    /* access modifiers changed from: protected */
    public abstract C createInflateController();

    public void init(ComponentParams componentParams, ViewGroup viewGroup) {
        if (shouldInflate(componentParams) || !componentParams.extras.getBoolean(BUNDLE_KEY_FROM_XPANEL, false)) {
            this.mIsDefaultVisible = isVisible(componentParams);
            super.init(componentParams, viewGroup);
            return;
        }
        GLog.m7974w("SelfControlComponent", componentParams.type + " is not allow to inflate.");
    }

    public boolean shouldInflate(ComponentParams componentParams) {
        C c = this.mInflateController;
        if (c != null) {
            return c.shouldInflate(componentParams);
        }
        return true;
    }

    public boolean isVisible(ComponentParams componentParams) {
        C c = this.mInflateController;
        if (c != null) {
            return c.isVisible(componentParams);
        }
        return true;
    }
}
