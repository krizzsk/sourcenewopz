package com.didiglobal.privacysdk.law.update;

import com.didi.global.globaluikit.drawer.LEGODrawerDismissListener;
import com.didiglobal.privacysdk.law.update.LawPopDialogShowManager;
import kotlin.Metadata;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, mo175978d2 = {"<anonymous>", "", "onDismiss"}, mo175979k = 3, mo175980mv = {1, 1, 16})
/* compiled from: LawPopDialogShowManager.kt */
final class LawPopDialogShowManager$realShow$1 implements LEGODrawerDismissListener {
    public static final LawPopDialogShowManager$realShow$1 INSTANCE = new LawPopDialogShowManager$realShow$1();

    LawPopDialogShowManager$realShow$1() {
    }

    public final void onDismiss() {
        LawPopDialogShowManager.f50668b = false;
        LawPopDialogShowManager.OnDismissListener access$getDissmissListener$p = LawPopDialogShowManager.f50671e;
        if (access$getDissmissListener$p != null) {
            access$getDissmissListener$p.onDismiss();
        }
    }
}
