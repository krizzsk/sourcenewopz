package com.didiglobal.p205sa.biz.component.welcome;

import android.os.Bundle;
import com.didi.component.never.core.ComponentParams;
import com.didi.component.never.core.ComponentPresenterImpl;
import com.didiglobal.p205sa.biz.component.sapanel.PanelAnimatorMgr;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\u0005J\u0012\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J\b\u0010\f\u001a\u00020\tH\u0016R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, mo175978d2 = {"Lcom/didiglobal/sa/biz/component/welcome/WelcomePresenter;", "Lcom/didi/component/never/core/ComponentPresenterImpl;", "Lcom/didiglobal/sa/biz/component/welcome/WelcomeView;", "params", "Lcom/didi/component/never/core/ComponentParams;", "(Lcom/didi/component/never/core/ComponentParams;)V", "scrollListener", "Lcom/didiglobal/sa/biz/component/sapanel/PanelAnimatorMgr$RvScrollingListener;", "onAdd", "", "arguments", "Landroid/os/Bundle;", "onRemove", "biz-library_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* renamed from: com.didiglobal.sa.biz.component.welcome.WelcomePresenter */
/* compiled from: WelcomePresenter.kt */
public final class WelcomePresenter extends ComponentPresenterImpl<WelcomeView> {

    /* renamed from: a */
    private final PanelAnimatorMgr.RvScrollingListener f51189a = new PanelAnimatorMgr.RvScrollingListener() {
        public final void onScroll(int i) {
            WelcomePresenter.m36667a(WelcomePresenter.this, i);
        }
    };

    public WelcomePresenter(ComponentParams componentParams) {
        super(componentParams);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m36667a(WelcomePresenter welcomePresenter, int i) {
        Intrinsics.checkNotNullParameter(welcomePresenter, "this$0");
        ((WelcomeView) welcomePresenter.mView).changeColorByPos(Integer.valueOf(i));
    }

    public void onAdd(Bundle bundle) {
        super.onAdd(bundle);
        PanelAnimatorMgr.addRvScrollListener(this.f51189a);
    }

    public void onRemove() {
        super.onRemove();
        PanelAnimatorMgr.removeRvScrollListener(this.f51189a);
    }
}
