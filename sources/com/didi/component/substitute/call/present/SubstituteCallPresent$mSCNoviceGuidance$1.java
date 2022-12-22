package com.didi.component.substitute.call.present;

import com.didi.component.core.event.BaseEventPublisher;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u00010\u00060\u0006H\n"}, mo175978d2 = {"<anonymous>", "", "<anonymous parameter 0>", "", "kotlin.jvm.PlatformType", "params", ""}, mo175979k = 3, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: SubstituteCallPresent.kt */
final class SubstituteCallPresent$mSCNoviceGuidance$1<T> implements BaseEventPublisher.OnEventListener {
    final /* synthetic */ SubstituteCallPresent this$0;

    SubstituteCallPresent$mSCNoviceGuidance$1(SubstituteCallPresent substituteCallPresent) {
        this.this$0 = substituteCallPresent;
    }

    public final void onEvent(String str, Integer num) {
        SubstituteCallPresent substituteCallPresent = this.this$0;
        Intrinsics.checkNotNullExpressionValue(num, "params");
        substituteCallPresent.m11800a(num.intValue());
    }
}
