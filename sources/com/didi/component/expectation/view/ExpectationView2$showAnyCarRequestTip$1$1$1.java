package com.didi.component.expectation.view;

import android.view.View;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.component.common.model.bubble.CommonBubbleItemModel;
import kotlin.Metadata;

@Metadata(mo175977d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n"}, mo175978d2 = {"<anonymous>", "", "<anonymous parameter 0>", "Landroid/view/View;", "kotlin.jvm.PlatformType"}, mo175979k = 3, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: ExpectationView2.kt */
final class ExpectationView2$showAnyCarRequestTip$1$1$1 implements View.OnClickListener {
    final /* synthetic */ CommonBubbleItemModel $it;
    final /* synthetic */ ExpectationView2 this$0;

    ExpectationView2$showAnyCarRequestTip$1$1$1(ExpectationView2 expectationView2, CommonBubbleItemModel commonBubbleItemModel) {
        this.this$0 = expectationView2;
        this.$it = commonBubbleItemModel;
    }

    public final void onClick(View view) {
        AutoTrackHelper.trackViewOnClick(view);
        this.this$0.closeAnyCarTipComplete(this.$it.bubbleId);
    }
}
