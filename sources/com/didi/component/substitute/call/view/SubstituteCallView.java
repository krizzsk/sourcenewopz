package com.didi.component.substitute.call.view;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.didi.component.core.ComponentParams;
import com.didi.component.substitute.call.present.AbsSubstituteCallPresent;
import com.didi.sdk.app.BusinessContext;
import kotlin.Metadata;

@Metadata(mo175977d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0019\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\n\u0010\r\u001a\u0004\u0018\u00010\fH\u0016J\u0012\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0002\u001a\u0004\u0018\u00010\nH\u0016R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000¨\u0006\u0010"}, mo175978d2 = {"Lcom/didi/component/substitute/call/view/SubstituteCallView;", "Lcom/didi/component/substitute/call/view/ISubstituteCallView;", "p0", "Lcom/didi/component/core/ComponentParams;", "p1", "Landroid/view/ViewGroup;", "(Lcom/didi/component/core/ComponentParams;Landroid/view/ViewGroup;)V", "mContext", "Landroid/content/Context;", "mPresent", "Lcom/didi/component/substitute/call/present/AbsSubstituteCallPresent;", "mView", "Landroid/view/View;", "getView", "setPresenter", "", "comp-substitute-call_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: SubstituteCallView.kt */
public final class SubstituteCallView implements ISubstituteCallView {

    /* renamed from: a */
    private View f16098a;

    /* renamed from: b */
    private AbsSubstituteCallPresent f16099b;

    /* renamed from: c */
    private Context f16100c;

    public SubstituteCallView(ComponentParams componentParams, ViewGroup viewGroup) {
        BusinessContext businessContext;
        Context context = null;
        if (!(componentParams == null || (businessContext = componentParams.bizCtx) == null)) {
            context = businessContext.getContext();
        }
        this.f16100c = context;
    }

    public View getView() {
        return this.f16098a;
    }

    public void setPresenter(AbsSubstituteCallPresent absSubstituteCallPresent) {
        this.f16099b = absSubstituteCallPresent;
    }
}
