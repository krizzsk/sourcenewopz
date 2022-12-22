package com.didi.entrega.info.component.receive;

import android.os.Bundle;
import android.view.ViewGroup;
import com.didi.app.nova.skeleton.mvp.MvpComponent;
import com.didi.entrega.info.component.ContactConstract;
import com.didi.entrega.info.helper.InfoStepConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\f\u001a\u00020\u0003H\u0014J\b\u0010\r\u001a\u00020\u0002H\u0014J\u0006\u0010\u000e\u001a\u00020\u000fJ\u0010\u0010\u0010\u001a\u00020\u000f2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012R\u001a\u0010\u0007\u001a\u00020\u0003X.¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000b¨\u0006\u0013"}, mo175978d2 = {"Lcom/didi/entrega/info/component/receive/ReceiveContactComponent;", "Lcom/didi/app/nova/skeleton/mvp/MvpComponent;", "Lcom/didi/entrega/info/component/receive/ReceiveContactView;", "Lcom/didi/entrega/info/component/ContactConstract$AbsEditContactPresenter;", "viewGroup", "Landroid/view/ViewGroup;", "(Landroid/view/ViewGroup;)V", "presenter", "getPresenter", "()Lcom/didi/entrega/info/component/ContactConstract$AbsEditContactPresenter;", "setPresenter", "(Lcom/didi/entrega/info/component/ContactConstract$AbsEditContactPresenter;)V", "onCreatePresenter", "onCreateView", "onHandleBack", "", "onPageResult", "data", "Landroid/os/Bundle;", "entrega-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: ReceiveContactComponent.kt */
public final class ReceiveContactComponent extends MvpComponent<ReceiveContactView, ContactConstract.AbsEditContactPresenter> {
    public ContactConstract.AbsEditContactPresenter presenter;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ReceiveContactComponent(ViewGroup viewGroup) {
        super(viewGroup);
        Intrinsics.checkNotNullParameter(viewGroup, "viewGroup");
    }

    public final ContactConstract.AbsEditContactPresenter getPresenter() {
        ContactConstract.AbsEditContactPresenter absEditContactPresenter = this.presenter;
        if (absEditContactPresenter != null) {
            return absEditContactPresenter;
        }
        Intrinsics.throwUninitializedPropertyAccessException("presenter");
        return null;
    }

    public final void setPresenter(ContactConstract.AbsEditContactPresenter absEditContactPresenter) {
        Intrinsics.checkNotNullParameter(absEditContactPresenter, "<set-?>");
        this.presenter = absEditContactPresenter;
    }

    /* access modifiers changed from: protected */
    public ContactConstract.AbsEditContactPresenter onCreatePresenter() {
        InfoStepConfig update = InfoStepConfig.Companion.getUPDATE();
        update.setCurrentStep(2);
        setPresenter(new ReceiveContactUpdatePresenter());
        getPresenter().setCurrentStepConfig(update);
        return getPresenter();
    }

    /* access modifiers changed from: protected */
    public ReceiveContactView onCreateView() {
        return new ReceiveContactView();
    }

    public final void onHandleBack() {
        getPresenter().handleBack();
    }

    public final void onPageResult(Bundle bundle) {
        getPresenter().onPageResult(bundle);
    }
}
