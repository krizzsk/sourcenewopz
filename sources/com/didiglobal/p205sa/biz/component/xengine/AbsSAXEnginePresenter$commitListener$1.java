package com.didiglobal.p205sa.biz.component.xengine;

import com.didi.component.never.core.event.BaseEventPublisher;
import com.didi.xengine.request.XECommitBizParams;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u001a\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\u0002H\u0016¨\u0006\b"}, mo175978d2 = {"com/didiglobal/sa/biz/component/xengine/AbsSAXEnginePresenter$commitListener$1", "Lcom/didi/component/never/core/event/BaseEventPublisher$OnEventListener;", "Lcom/didi/xengine/request/XECommitBizParams;", "onEvent", "", "p0", "", "xeCommitBizParams", "biz-library_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* renamed from: com.didiglobal.sa.biz.component.xengine.AbsSAXEnginePresenter$commitListener$1 */
/* compiled from: AbsSAXEnginePresenter.kt */
public final class AbsSAXEnginePresenter$commitListener$1 implements BaseEventPublisher.OnEventListener<XECommitBizParams> {
    final /* synthetic */ AbsSAXEnginePresenter this$0;

    AbsSAXEnginePresenter$commitListener$1(AbsSAXEnginePresenter absSAXEnginePresenter) {
        this.this$0 = absSAXEnginePresenter;
    }

    public void onEvent(String str, XECommitBizParams xECommitBizParams) {
        Intrinsics.checkNotNullParameter(xECommitBizParams, "xeCommitBizParams");
        this.this$0.engineCommitRequest(xECommitBizParams);
    }
}
