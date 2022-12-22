package com.jumio.defaultui.view;

import androidx.activity.OnBackPressedCallback;
import kotlin.Metadata;
import p001a.C0010a;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016¨\u0006\u0004"}, mo175978d2 = {"com/jumio/defaultui/view/ConfirmationFragment$onViewCreated$1", "Landroidx/activity/OnBackPressedCallback;", "", "handleOnBackPressed", "jumio-defaultui_release"}, mo175979k = 1, mo175980mv = {1, 5, 1})
/* compiled from: ConfirmationFragment.kt */
public final class ConfirmationFragment$onViewCreated$1 extends OnBackPressedCallback {
    public final /* synthetic */ ConfirmationFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ConfirmationFragment$onViewCreated$1(ConfirmationFragment confirmationFragment) {
        super(true);
        this.this$0 = confirmationFragment;
    }

    public void handleOnBackPressed() {
        if (this.this$0.getJumioViewModel().mo3A().getValue() == C0010a.C0013c.CONFIRMATION) {
            this.this$0.retakeImage();
        }
    }
}
