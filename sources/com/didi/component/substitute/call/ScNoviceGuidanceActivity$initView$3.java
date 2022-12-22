package com.didi.component.substitute.call;

import android.view.View;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.component.business.data.form.FormStore;
import com.didi.sdk.util.SPUtils;
import kotlin.Metadata;

@Metadata(mo175977d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n"}, mo175978d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType"}, mo175979k = 3, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: ScNoviceGuidanceActivity.kt */
final class ScNoviceGuidanceActivity$initView$3 implements View.OnClickListener {
    final /* synthetic */ ScNoviceGuidanceActivity this$0;

    ScNoviceGuidanceActivity$initView$3(ScNoviceGuidanceActivity scNoviceGuidanceActivity) {
        this.this$0 = scNoviceGuidanceActivity;
    }

    public final void onClick(View view) {
        AutoTrackHelper.trackViewOnClick(view);
        Object obj = SPUtils.get(this.this$0, "substitute_call_count", 0);
        if (obj != null) {
            SPUtils.put(this.this$0, "substitute_call_count", Integer.valueOf(((Integer) obj).intValue() + 1));
            FormStore.getInstance().setSkipEstimateGet(true);
            this.this$0.finish();
            this.this$0.overridePendingTransition(0, 0);
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
    }
}
