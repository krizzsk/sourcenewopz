package com.didi.entrega.info.component.stuf;

import android.os.Bundle;
import android.view.ViewGroup;
import com.didi.app.nova.skeleton.mvp.MvpComponent;
import com.didi.entrega.info.component.StuffConstract;
import com.didi.entrega.info.helper.InfoStepConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\f\u001a\u00020\u0003H\u0014J\b\u0010\r\u001a\u00020\u000eH\u0014J\u0006\u0010\u000f\u001a\u00020\u0010J\u0010\u0010\u0011\u001a\u00020\u00102\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013R\u001a\u0010\u0007\u001a\u00020\u0003X.¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000b¨\u0006\u0014"}, mo175978d2 = {"Lcom/didi/entrega/info/component/stuf/StuffComponent;", "Lcom/didi/app/nova/skeleton/mvp/MvpComponent;", "Lcom/didi/entrega/info/component/StuffConstract$AbsCommonStuffView;", "Lcom/didi/entrega/info/component/StuffConstract$AbsCommonStuffPresenter;", "viewGroup", "Landroid/view/ViewGroup;", "(Landroid/view/ViewGroup;)V", "presenter", "getPresenter", "()Lcom/didi/entrega/info/component/StuffConstract$AbsCommonStuffPresenter;", "setPresenter", "(Lcom/didi/entrega/info/component/StuffConstract$AbsCommonStuffPresenter;)V", "onCreatePresenter", "onCreateView", "Lcom/didi/entrega/info/component/stuf/StuffView;", "onHandleBack", "", "onPageResult", "data", "Landroid/os/Bundle;", "entrega-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: StuffComponent.kt */
public final class StuffComponent extends MvpComponent<StuffConstract.AbsCommonStuffView, StuffConstract.AbsCommonStuffPresenter> {
    public StuffConstract.AbsCommonStuffPresenter presenter;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public StuffComponent(ViewGroup viewGroup) {
        super(viewGroup);
        Intrinsics.checkNotNullParameter(viewGroup, "viewGroup");
    }

    public final StuffConstract.AbsCommonStuffPresenter getPresenter() {
        StuffConstract.AbsCommonStuffPresenter absCommonStuffPresenter = this.presenter;
        if (absCommonStuffPresenter != null) {
            return absCommonStuffPresenter;
        }
        Intrinsics.throwUninitializedPropertyAccessException("presenter");
        return null;
    }

    public final void setPresenter(StuffConstract.AbsCommonStuffPresenter absCommonStuffPresenter) {
        Intrinsics.checkNotNullParameter(absCommonStuffPresenter, "<set-?>");
        this.presenter = absCommonStuffPresenter;
    }

    /* access modifiers changed from: protected */
    public StuffConstract.AbsCommonStuffPresenter onCreatePresenter() {
        InfoStepConfig update = InfoStepConfig.Companion.getUPDATE();
        update.setCurrentStep(3);
        setPresenter(new StuffUpdatePresenter());
        getPresenter().setCurrentStepConfig(update);
        return getPresenter();
    }

    /* access modifiers changed from: protected */
    public StuffView onCreateView() {
        return new StuffView();
    }

    public final void onHandleBack() {
        getPresenter().handleBack();
    }

    public final void onPageResult(Bundle bundle) {
        getPresenter().onPageResult(bundle);
    }
}
