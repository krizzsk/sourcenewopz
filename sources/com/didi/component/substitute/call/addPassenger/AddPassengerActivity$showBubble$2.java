package com.didi.component.substitute.call.addPassenger;

import android.view.View;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.global.globaluikit.popup.LEGOBubble;
import com.didi.sdk.util.SPUtils;
import kotlin.Metadata;

@Metadata(mo175977d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n"}, mo175978d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType"}, mo175979k = 3, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: AddPassengerActivity.kt */
final class AddPassengerActivity$showBubble$2 implements View.OnClickListener {
    final /* synthetic */ AddPassengerActivity this$0;

    AddPassengerActivity$showBubble$2(AddPassengerActivity addPassengerActivity) {
        this.this$0 = addPassengerActivity;
    }

    public final void onClick(View view) {
        AutoTrackHelper.trackViewOnClick(view);
        LEGOBubble access$getMBubble$p = this.this$0.f16061x;
        if (access$getMBubble$p != null) {
            access$getMBubble$p.dismiss();
        }
        this.this$0.f16061x = null;
        AddPassengerActivity addPassengerActivity = this.this$0;
        SPUtils.put(addPassengerActivity, addPassengerActivity.f16060w, true);
    }
}
