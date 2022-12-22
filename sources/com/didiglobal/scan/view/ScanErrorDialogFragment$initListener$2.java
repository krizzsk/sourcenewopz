package com.didiglobal.scan.view;

import android.view.View;
import com.didi.autotracker.AutoTrackHelper;
import com.didiglobal.scan.view.ScanErrorDialogFragment;
import kotlin.Metadata;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo175978d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, mo175979k = 3, mo175980mv = {1, 1, 16})
/* compiled from: ScanErrorDialogFragment.kt */
final class ScanErrorDialogFragment$initListener$2 implements View.OnClickListener {
    final /* synthetic */ ScanErrorDialogFragment this$0;

    ScanErrorDialogFragment$initListener$2(ScanErrorDialogFragment scanErrorDialogFragment) {
        this.this$0 = scanErrorDialogFragment;
    }

    public final void onClick(View view) {
        AutoTrackHelper.trackViewOnClick(view);
        ScanErrorDialogFragment.ClickCallBack access$getClickCallBack$p = this.this$0.f51368c;
        if (access$getClickCallBack$p != null) {
            access$getClickCallBack$p.onClick();
        }
        this.this$0.dismiss();
    }
}
