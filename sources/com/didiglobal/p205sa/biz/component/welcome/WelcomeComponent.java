package com.didiglobal.p205sa.biz.component.welcome;

import android.view.ViewGroup;
import com.didi.component.never.base.BaseComponent;
import com.didi.component.never.core.ComponentParams;
import com.didi.component_processor.annonation.ComponentName;
import kotlin.Metadata;

@Metadata(mo175977d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0005¢\u0006\u0002\u0010\u0004J\u0012\u0010\u0005\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0014J\u001c\u0010\b\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0014¨\u0006\u000b"}, mo175978d2 = {"Lcom/didiglobal/sa/biz/component/welcome/WelcomeComponent;", "Lcom/didi/component/never/base/BaseComponent;", "Lcom/didiglobal/sa/biz/component/welcome/WelcomeView;", "Lcom/didiglobal/sa/biz/component/welcome/WelcomePresenter;", "()V", "onCreatePresenter", "params", "Lcom/didi/component/never/core/ComponentParams;", "onCreateView", "viewGroup", "Landroid/view/ViewGroup;", "biz-library_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
@ComponentName(type = "COMPONENT_WELCOME")
/* renamed from: com.didiglobal.sa.biz.component.welcome.WelcomeComponent */
/* compiled from: WelcomeComponent.kt */
public final class WelcomeComponent extends BaseComponent<WelcomeView, WelcomePresenter> {
    /* access modifiers changed from: protected */
    public WelcomeView onCreateView(ComponentParams componentParams, ViewGroup viewGroup) {
        return new WelcomeView();
    }

    /* access modifiers changed from: protected */
    public WelcomePresenter onCreatePresenter(ComponentParams componentParams) {
        return new WelcomePresenter(componentParams);
    }
}
