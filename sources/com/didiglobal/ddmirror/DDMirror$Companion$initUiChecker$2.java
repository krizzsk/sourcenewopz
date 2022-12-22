package com.didiglobal.ddmirror;

import com.didichuxing.omega.sdk.analysis.TrackListener;
import com.didichuxing.omega.sdk.common.record.Event;
import com.didiglobal.ddmirror.DDMirror;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo175978d2 = {"<anonymous>", "", "event", "Lcom/didichuxing/omega/sdk/common/record/Event;", "kotlin.jvm.PlatformType", "afterTrackEvent"}, mo175979k = 3, mo175980mv = {1, 1, 16})
/* compiled from: DDMirror.kt */
final class DDMirror$Companion$initUiChecker$2 implements TrackListener {
    public static final DDMirror$Companion$initUiChecker$2 INSTANCE = new DDMirror$Companion$initUiChecker$2();

    DDMirror$Companion$initUiChecker$2() {
    }

    public final void afterTrackEvent(Event event) {
        DDMirror.Companion companion = DDMirror.Companion;
        Intrinsics.checkExpressionValueIsNotNull(event, "event");
        String eventId = event.getEventId();
        Intrinsics.checkExpressionValueIsNotNull(eventId, "event.eventId");
        companion.doCheckTrack(eventId);
    }
}
