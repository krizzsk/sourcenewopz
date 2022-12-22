package com.didi.component.savingcenter;

import android.app.Activity;
import android.view.ViewGroup;
import com.didi.component.base.BaseComponent;
import com.didi.component.common.base.ComponentRegister;
import com.didi.component.core.ComponentParams;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@ComponentRegister(product = "ride", type = "saving_center")
@Metadata(mo175977d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0005¢\u0006\u0002\u0010\u0004J\u0014\u0010\u0005\u001a\u0004\u0018\u00010\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0014J\u001a\u0010\b\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0014¨\u0006\u000b"}, mo175978d2 = {"Lcom/didi/component/savingcenter/SavingCenterComponent;", "Lcom/didi/component/base/BaseComponent;", "Lcom/didi/component/savingcenter/ISavingCenterView;", "Lcom/didi/component/savingcenter/AbsSavingCenterPresenter;", "()V", "onCreatePresenter", "componentParams", "Lcom/didi/component/core/ComponentParams;", "onCreateView", "viewGroup", "Landroid/view/ViewGroup;", "comp-savingcenter_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: SavingCenterComponent.kt */
public final class SavingCenterComponent extends BaseComponent<ISavingCenterView, AbsSavingCenterPresenter> {
    /* access modifiers changed from: protected */
    public ISavingCenterView onCreateView(ComponentParams componentParams, ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(componentParams, "componentParams");
        Activity activity = componentParams.getActivity();
        Intrinsics.checkNotNullExpressionValue(activity, "componentParams.activity");
        return new SavingCenterView(activity);
    }

    /* access modifiers changed from: protected */
    public AbsSavingCenterPresenter onCreatePresenter(ComponentParams componentParams) {
        Integer valueOf = componentParams == null ? null : Integer.valueOf(componentParams.pageID);
        if (valueOf != null && valueOf.intValue() == 1001) {
            return new HomeSavingCenterPresenter(componentParams);
        }
        if (valueOf != null && valueOf.intValue() == 1040) {
            return new TripSavingCenterPresenter(componentParams);
        }
        return null;
    }
}
