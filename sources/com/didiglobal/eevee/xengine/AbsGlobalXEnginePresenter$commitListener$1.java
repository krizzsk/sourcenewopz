package com.didiglobal.eevee.xengine;

import com.didi.component.never.core.event.BaseEventPublisher;
import com.didi.xengine.request.XECommitBizParams;
import kotlin.Metadata;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u00010\u00060\u0006H\n¢\u0006\u0002\b\u0007"}, mo175978d2 = {"<anonymous>", "", "<anonymous parameter 0>", "", "kotlin.jvm.PlatformType", "xeCommitBizParams", "Lcom/didi/xengine/request/XECommitBizParams;", "onEvent"}, mo175979k = 3, mo175980mv = {1, 1, 16})
/* compiled from: AbsGlobalXEnginePresenter.kt */
final class AbsGlobalXEnginePresenter$commitListener$1<T> implements BaseEventPublisher.OnEventListener<XECommitBizParams> {
    final /* synthetic */ AbsGlobalXEnginePresenter this$0;

    AbsGlobalXEnginePresenter$commitListener$1(AbsGlobalXEnginePresenter absGlobalXEnginePresenter) {
        this.this$0 = absGlobalXEnginePresenter;
    }

    public final void onEvent(String str, XECommitBizParams xECommitBizParams) {
        this.this$0.engineCommitRequest(xECommitBizParams);
    }
}
