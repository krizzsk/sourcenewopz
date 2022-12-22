package com.didi.component.savingcenter;

import android.os.Bundle;
import com.didi.component.business.xengine.XERequestKey;
import com.didi.component.core.ComponentParams;
import com.didi.component.savingcenter.AbsSavingCenterPresenter;
import com.didi.xengine.register.XERegister;
import com.didiglobal.enginecore.callback.XEResponseCallback;
import com.didiglobal.enginecore.register.XERegisterModel;
import kotlin.Metadata;

@Metadata(mo175977d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\r\u001a\u00020\u0006H\u0016J\u0012\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0014J\b\u0010\u0012\u001a\u00020\u000fH\u0014R\u001a\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u000e\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000¨\u0006\u0013"}, mo175978d2 = {"Lcom/didi/component/savingcenter/TripSavingCenterPresenter;", "Lcom/didi/component/savingcenter/AbsSavingCenterPresenter;", "params", "Lcom/didi/component/core/ComponentParams;", "(Lcom/didi/component/core/ComponentParams;)V", "curStatus", "", "getCurStatus", "()I", "setCurStatus", "(I)V", "mXELogicCallback", "Lcom/didiglobal/enginecore/callback/XEResponseCallback;", "getPageId", "onAdd", "", "arguments", "Landroid/os/Bundle;", "onRemove", "comp-savingcenter_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: TripSavingCenterPresenter.kt */
public final class TripSavingCenterPresenter extends AbsSavingCenterPresenter {

    /* renamed from: a */
    private int f15485a = -1;

    /* renamed from: b */
    private XEResponseCallback f15486b = new TripSavingCenterPresenter$mXELogicCallback$1(this);

    public TripSavingCenterPresenter(ComponentParams componentParams) {
        super(componentParams);
    }

    public final int getCurStatus() {
        return this.f15485a;
    }

    public final void setCurStatus(int i) {
        this.f15485a = i;
    }

    /* access modifiers changed from: protected */
    public void onAdd(Bundle bundle) {
        super.onAdd(bundle);
        XERegister.registerTemplate(new XERegisterModel(XERequestKey.REQUEST_KEY_SAVING_CENTER, XERequestKey.SCENE_TRIP, this.f15486b));
    }

    public int getPageId() {
        int i = this.mComponentParams.scene;
        if (i == 10401) {
            return AbsSavingCenterPresenter.ScPageId.WAIT.getId();
        }
        if (i != 10403) {
            return AbsSavingCenterPresenter.ScPageId.WAIT.getId();
        }
        return AbsSavingCenterPresenter.ScPageId.END.getId();
    }

    /* access modifiers changed from: protected */
    public void onRemove() {
        super.onRemove();
        XERegister.unregisterTemplate(XERequestKey.REQUEST_KEY_SAVING_CENTER);
    }
}
