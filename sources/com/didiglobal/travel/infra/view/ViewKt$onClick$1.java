package com.didiglobal.travel.infra.view;

import android.view.View;
import com.didi.autotracker.AutoTrackHelper;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo175978d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, mo175979k = 3, mo175980mv = {1, 1, 16})
/* compiled from: View.kt */
public final class ViewKt$onClick$1 implements View.OnClickListener {
    final /* synthetic */ Function1 $block;

    public ViewKt$onClick$1(Function1 function1) {
        this.$block = function1;
    }

    public final void onClick(View view) {
        AutoTrackHelper.trackViewOnClick(view);
        Function1 function1 = this.$block;
        Intrinsics.checkExpressionValueIsNotNull(view, "it");
        function1.invoke(view);
    }
}
