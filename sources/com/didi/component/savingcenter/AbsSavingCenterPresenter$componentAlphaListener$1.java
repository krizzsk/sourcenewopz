package com.didi.component.savingcenter;

import android.view.View;
import com.didi.component.business.constant.BaseEventKeys;
import com.didi.component.core.event.BaseEventPublisher;
import com.didi.component.savingcenter.AbsSavingCenterPresenter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0007\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\n"}, mo175978d2 = {"<anonymous>", "", "s", "", "kotlin.jvm.PlatformType", "alpha", ""}, mo175979k = 3, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: AbsSavingCenterPresenter.kt */
final class AbsSavingCenterPresenter$componentAlphaListener$1<T> implements BaseEventPublisher.OnEventListener {
    final /* synthetic */ AbsSavingCenterPresenter this$0;

    AbsSavingCenterPresenter$componentAlphaListener$1(AbsSavingCenterPresenter absSavingCenterPresenter) {
        this.this$0 = absSavingCenterPresenter;
    }

    public final void onEvent(String str, Float f) {
        View view;
        if (Intrinsics.areEqual((Object) BaseEventKeys.NewXpanel.EVENT_XPANEL_COMPONENT_ALPHA, (Object) str) && this.this$0.getPageId() != AbsSavingCenterPresenter.ScPageId.HOME.getId() && (view = ((ISavingCenterView) this.this$0.mView).getView()) != null) {
            view.setAlpha(f == null ? 1.0f : f.floatValue());
        }
    }
}
