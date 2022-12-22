package com.didi.soda.blocks.style;

import android.view.View;
import kotlin.Metadata;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u00032\u000e\u0010\u0004\u001a\n \u0005*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0006"}, mo175978d2 = {"<anonymous>", "", "T", "Landroid/view/View;", "it", "kotlin.jvm.PlatformType", "onLongClick"}, mo175979k = 3, mo175980mv = {1, 1, 16})
/* compiled from: BaseBinder.kt */
final class BaseBinder$onBindFinish$1 implements View.OnLongClickListener {
    final /* synthetic */ BaseBinder this$0;

    BaseBinder$onBindFinish$1(BaseBinder baseBinder) {
        this.this$0 = baseBinder;
    }

    public final boolean onLongClick(View view) {
        this.this$0.outputNodeInfo();
        return false;
    }
}
