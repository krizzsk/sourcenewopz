package com.didi.rfusion.widget.push;

import android.view.View;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.rfusion.widget.push.RFPush;
import kotlin.Metadata;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo175978d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, mo175979k = 3, mo175980mv = {1, 1, 16})
/* compiled from: RFPush.kt */
final class RFPush$pushViewOnClickListener$1 implements View.OnClickListener {
    final /* synthetic */ RFPush.Builder $builder;
    final /* synthetic */ RFPush this$0;

    RFPush$pushViewOnClickListener$1(RFPush rFPush, RFPush.Builder builder) {
        this.this$0 = rFPush;
        this.$builder = builder;
    }

    public final void onClick(View view) {
        AutoTrackHelper.trackViewOnClick(view);
        if (this.$builder.isDismissible$r_fusion_ninePhoneRelease()) {
            this.this$0.dismiss();
        }
        View.OnClickListener access$getOnClickListener$p = this.this$0.f33667f;
        if (access$getOnClickListener$p != null) {
            access$getOnClickListener$p.onClick(view);
        }
    }
}
