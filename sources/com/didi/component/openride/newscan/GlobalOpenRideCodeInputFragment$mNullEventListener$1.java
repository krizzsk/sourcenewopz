package com.didi.component.openride.newscan;

import androidx.fragment.app.FragmentActivity;
import com.didi.component.business.constant.BaseEventKeys;
import com.didi.component.core.event.BaseEventPublisher;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u00010\u00060\u0006H\n"}, mo175978d2 = {"<anonymous>", "", "category", "", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "Lcom/didi/component/core/event/BaseEventPublisher$NullEvent;"}, mo175979k = 3, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: GlobalOpenRideCodeInputFragment.kt */
final class GlobalOpenRideCodeInputFragment$mNullEventListener$1<T> implements BaseEventPublisher.OnEventListener {
    final /* synthetic */ GlobalOpenRideCodeInputFragment this$0;

    GlobalOpenRideCodeInputFragment$mNullEventListener$1(GlobalOpenRideCodeInputFragment globalOpenRideCodeInputFragment) {
        this.this$0 = globalOpenRideCodeInputFragment;
    }

    public final void onEvent(String str, BaseEventPublisher.NullEvent nullEvent) {
        FragmentActivity activity;
        if (Intrinsics.areEqual((Object) BaseEventKeys.OpenRide.EVENT_OPEN_RIDE_SHOW_SUG_PAGE, (Object) str) && (activity = this.this$0.getActivity()) != null) {
            activity.finish();
        }
    }
}
