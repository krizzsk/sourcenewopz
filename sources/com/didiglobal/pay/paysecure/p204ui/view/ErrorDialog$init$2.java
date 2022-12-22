package com.didiglobal.pay.paysecure.p204ui.view;

import android.text.TextUtils;
import android.view.View;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.drouter.api.DRouter;
import com.didiglobal.pay.paysecure.PaySecure;
import com.didiglobal.pay.paysecure.WebUrlListener;
import com.didiglobal.pay.paysecure.net.pojo.response.Button;
import com.didiglobal.pay.paysecure.omega.OmegaUtil;
import com.didiglobal.pay.paysecure.omega.OmegaUtilKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo175978d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, mo175979k = 3, mo175980mv = {1, 1, 16})
/* renamed from: com.didiglobal.pay.paysecure.ui.view.ErrorDialog$init$2 */
/* compiled from: ErrorDialog.kt */
final class ErrorDialog$init$2 implements View.OnClickListener {
    final /* synthetic */ Button $button;
    final /* synthetic */ ErrorDialog this$0;

    ErrorDialog$init$2(ErrorDialog errorDialog, Button button) {
        this.this$0 = errorDialog;
        this.$button = button;
    }

    public final void onClick(View view) {
        AutoTrackHelper.trackViewOnClick(view);
        if (!TextUtils.isEmpty(this.$button.getAction())) {
            if (PaySecure.INSTANCE.getConfig().getWebUrlListener() != null) {
                WebUrlListener webUrlListener = PaySecure.INSTANCE.getConfig().getWebUrlListener();
                if (webUrlListener == null) {
                    Intrinsics.throwNpe();
                }
                String action = this.$button.getAction();
                if (action == null) {
                    Intrinsics.throwNpe();
                }
                webUrlListener.openUrl(action);
            } else {
                DRouter.build(this.$button.getAction()).start(this.this$0.getContext());
            }
        }
        if (!TextUtils.isEmpty(this.$button.getEventId())) {
            new OmegaUtil(this.$button.getEventId()).add(OmegaUtilKt.ENTRANCE_PAGE_ID, Integer.valueOf(this.this$0.getSourcePageId())).send();
        }
        this.this$0.dismiss();
        ErrorDialogCallback access$getListener$p = this.this$0.f50451f;
        if (access$getListener$p != null) {
            access$getListener$p.onPositiveClicked(this.this$0);
        }
    }
}
