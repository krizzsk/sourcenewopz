package com.didiglobal.component.imentrance.view;

import android.view.View;
import com.didi.autotracker.AutoTrackHelper;
import com.didiglobal.component.imentrance.view.MessageBubbleHelper;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005¨\u0006\u0006"}, mo175978d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/didiglobal/travel/infra/view/ViewKt$onClick$1"}, mo175979k = 3, mo175980mv = {1, 5, 1})
/* renamed from: com.didiglobal.component.imentrance.view.MessageBubbleHelper$mountWithAnchor$lambda-20$$inlined$onClick$1  reason: invalid class name */
/* compiled from: View.kt */
public final class MessageBubbleHelper$mountWithAnchor$lambda20$$inlined$onClick$1 implements View.OnClickListener {
    final /* synthetic */ Function1 $onClick$inlined;
    final /* synthetic */ MessageBubbleHelper.AnchorBubbleTag $tag$inlined;

    public MessageBubbleHelper$mountWithAnchor$lambda20$$inlined$onClick$1(MessageBubbleHelper.AnchorBubbleTag anchorBubbleTag, Function1 function1) {
        this.$tag$inlined = anchorBubbleTag;
        this.$onClick$inlined = function1;
    }

    public final void onClick(View view) {
        AutoTrackHelper.trackViewOnClick(view);
        Intrinsics.checkExpressionValueIsNotNull(view, "it");
        this.$tag$inlined.clear();
        this.$onClick$inlined.invoke(view);
    }
}
