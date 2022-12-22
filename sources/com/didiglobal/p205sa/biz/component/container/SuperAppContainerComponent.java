package com.didiglobal.p205sa.biz.component.container;

import com.didi.component.never.core.ComponentParams;
import com.didi.component.never.core.container.ContainerComponent;
import com.didi.component_processor.annonation.ComponentName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\u0010\u0010\b\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0007H\u0014¨\u0006\t"}, mo175978d2 = {"Lcom/didiglobal/sa/biz/component/container/SuperAppContainerComponent;", "Lcom/didi/component/never/core/container/ContainerComponent;", "Lcom/didiglobal/sa/biz/component/container/SupperAppContainerComponentPresenter;", "()V", "needInflate", "", "componentParams", "Lcom/didi/component/never/core/ComponentParams;", "onCreatePresenter", "biz-library_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
@ComponentName(category = 4, type = "COMPONENT_CONTAINER")
/* renamed from: com.didiglobal.sa.biz.component.container.SuperAppContainerComponent */
/* compiled from: SuperAppContainerComponent.kt */
public final class SuperAppContainerComponent extends ContainerComponent<SupperAppContainerComponentPresenter> {
    public boolean needInflate(ComponentParams componentParams) {
        return false;
    }

    /* access modifiers changed from: protected */
    public SupperAppContainerComponentPresenter onCreatePresenter(ComponentParams componentParams) {
        Intrinsics.checkNotNullParameter(componentParams, "componentParams");
        return new SupperAppContainerComponentPresenter(componentParams);
    }
}
