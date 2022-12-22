package com.didi.soda.home.topgun.component.feed;

import com.didi.app.nova.support.view.recyclerview.binder.RecyclerModel;
import com.didi.soda.datasource.page.UpdateUtils;
import com.didi.soda.home.topgun.binder.model.FilterRvModel;

/* renamed from: com.didi.soda.home.topgun.component.feed.-$$Lambda$HomeFeedPresenter$XmPINIyHgz1tRlegEy80zFpu0X4  reason: invalid class name */
/* compiled from: lambda */
public final /* synthetic */ class $$Lambda$HomeFeedPresenter$XmPINIyHgz1tRlegEy80zFpu0X4 implements UpdateUtils.UpdateCallback {
    public static final /* synthetic */ $$Lambda$HomeFeedPresenter$XmPINIyHgz1tRlegEy80zFpu0X4 INSTANCE = new $$Lambda$HomeFeedPresenter$XmPINIyHgz1tRlegEy80zFpu0X4();

    private /* synthetic */ $$Lambda$HomeFeedPresenter$XmPINIyHgz1tRlegEy80zFpu0X4() {
    }

    public final void doUpdate(int i, Object obj) {
        ((FilterRvModel) ((RecyclerModel) obj)).setHasAnim(true);
    }
}
