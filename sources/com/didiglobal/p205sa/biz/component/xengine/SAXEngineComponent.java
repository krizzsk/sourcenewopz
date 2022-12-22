package com.didiglobal.p205sa.biz.component.xengine;

import android.view.ViewGroup;
import com.didi.component.never.base.BaseComponent;
import com.didi.component.never.core.ComponentParams;
import com.didi.component.never.core.IView;
import com.didi.component_processor.annonation.ComponentName;
import com.didiglobal.p205sa.biz.node.NodeIds;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0007\u0018\u00002\u0014\u0012\n\u0012\b\u0012\u0002\b\u0003\u0018\u00010\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0005¢\u0006\u0002\u0010\u0004J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH\u0014J\u001e\u0010\n\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00022\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\fH\u0014J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\bH\u0016¨\u0006\u0010"}, mo175978d2 = {"Lcom/didiglobal/sa/biz/component/xengine/SAXEngineComponent;", "Lcom/didi/component/never/base/BaseComponent;", "Lcom/didi/component/never/core/IView;", "Lcom/didiglobal/sa/biz/component/xengine/AbsSAXEnginePresenter;", "()V", "getLayoutParams", "Landroid/view/ViewGroup$LayoutParams;", "componentParams", "Lcom/didi/component/never/core/ComponentParams;", "onCreatePresenter", "onCreateView", "viewGroup", "Landroid/view/ViewGroup;", "recreateWhenNodeChange", "", "params", "biz-library_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
@ComponentName(type = "component_SAXEngine")
/* renamed from: com.didiglobal.sa.biz.component.xengine.SAXEngineComponent */
/* compiled from: SAXEngineComponent.kt */
public final class SAXEngineComponent extends BaseComponent<IView<?>, AbsSAXEnginePresenter> {
    public ViewGroup.LayoutParams getLayoutParams(ComponentParams componentParams) {
        Intrinsics.checkNotNullParameter(componentParams, "componentParams");
        return null;
    }

    /* access modifiers changed from: protected */
    public IView<?> onCreateView(ComponentParams componentParams, ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(componentParams, "componentParams");
        Intrinsics.checkNotNullParameter(viewGroup, "viewGroup");
        return null;
    }

    public boolean recreateWhenNodeChange(ComponentParams componentParams) {
        Intrinsics.checkNotNullParameter(componentParams, "params");
        return true;
    }

    /* access modifiers changed from: protected */
    public AbsSAXEnginePresenter onCreatePresenter(ComponentParams componentParams) {
        Intrinsics.checkNotNullParameter(componentParams, "componentParams");
        if (Intrinsics.areEqual((Object) NodeIds.NODE_SUPPER_ACTIVITY, (Object) componentParams.nodeId)) {
            return new SAActivityXEnginePresenter(componentParams);
        }
        return new SAXEnginePresenter(componentParams);
    }
}
