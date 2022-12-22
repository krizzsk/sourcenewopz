package com.didiglobal.pay.paysecure.prepaidcard;

import android.view.View;
import com.didi.autotracker.AutoTrackHelper;
import com.didiglobal.pay.paysecure.prepaidcard.BottomDialog;
import kotlin.Metadata;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo175978d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, mo175979k = 3, mo175980mv = {1, 1, 16})
/* compiled from: BottomDialog.kt */
final class BottomDialog$onViewCreated$1 implements View.OnClickListener {
    final /* synthetic */ BottomDialog this$0;

    BottomDialog$onViewCreated$1(BottomDialog bottomDialog) {
        this.this$0 = bottomDialog;
    }

    public final void onClick(View view) {
        AutoTrackHelper.trackViewOnClick(view);
        BottomDialog.IClickListener access$getListener$p = this.this$0.f50331d;
        if (access$getListener$p != null) {
            access$getListener$p.onClick();
        }
        this.this$0.dismiss();
    }
}
