package com.didi.component.substitute.call;

import android.view.ViewGroup;
import com.didi.component.base.BaseComponent;
import com.didi.component.common.base.ComponentRegister;
import com.didi.component.core.ComponentParams;
import com.didi.component.substitute.call.present.AbsSubstituteCallPresent;
import com.didi.component.substitute.call.present.SubstituteCallPresent;
import com.didi.component.substitute.call.view.ISubstituteCallView;
import com.didi.component.substitute.call.view.SubstituteCallView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@ComponentRegister(product = "ride", type = "substitute_call")
@Metadata(mo175977d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0005¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0007H\u0014J\u001c\u0010\b\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0014¨\u0006\u000b"}, mo175978d2 = {"Lcom/didi/component/substitute/call/SubstituteComponent;", "Lcom/didi/component/base/BaseComponent;", "Lcom/didi/component/substitute/call/view/ISubstituteCallView;", "Lcom/didi/component/substitute/call/present/AbsSubstituteCallPresent;", "()V", "onCreatePresenter", "p0", "Lcom/didi/component/core/ComponentParams;", "onCreateView", "p1", "Landroid/view/ViewGroup;", "comp-substitute-call_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: SubstituteComponent.kt */
public final class SubstituteComponent extends BaseComponent<ISubstituteCallView, AbsSubstituteCallPresent> {
    /* access modifiers changed from: protected */
    public ISubstituteCallView onCreateView(ComponentParams componentParams, ViewGroup viewGroup) {
        return new SubstituteCallView(componentParams, viewGroup);
    }

    /* access modifiers changed from: protected */
    public AbsSubstituteCallPresent onCreatePresenter(ComponentParams componentParams) {
        Intrinsics.checkNotNullParameter(componentParams, "p0");
        return new SubstituteCallPresent(componentParams);
    }
}
