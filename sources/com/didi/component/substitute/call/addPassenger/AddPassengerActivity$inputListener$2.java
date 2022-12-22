package com.didi.component.substitute.call.addPassenger;

import android.view.View;
import kotlin.Metadata;

@Metadata(mo175977d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\n"}, mo175978d2 = {"<anonymous>", "", "<anonymous parameter 0>", "Landroid/view/View;", "kotlin.jvm.PlatformType", "hasFocus", ""}, mo175979k = 3, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: AddPassengerActivity.kt */
final class AddPassengerActivity$inputListener$2 implements View.OnFocusChangeListener {
    final /* synthetic */ AddPassengerActivity this$0;

    AddPassengerActivity$inputListener$2(AddPassengerActivity addPassengerActivity) {
        this.this$0 = addPassengerActivity;
    }

    public final void onFocusChange(View view, boolean z) {
        boolean z2 = true;
        if (z) {
            AddPassengerActivity addPassengerActivity = this.this$0;
            addPassengerActivity.m11778a(addPassengerActivity.f16053p, true);
            return;
        }
        CharSequence access$getMPhoneNum$p = this.this$0.f16051n;
        if (!(access$getMPhoneNum$p == null || access$getMPhoneNum$p.length() == 0)) {
            z2 = false;
        }
        if (z2) {
            AddPassengerActivity addPassengerActivity2 = this.this$0;
            addPassengerActivity2.m11778a(addPassengerActivity2.f16053p, false);
            return;
        }
        AddPassengerActivity addPassengerActivity3 = this.this$0;
        addPassengerActivity3.m11777a(addPassengerActivity3.f16053p, 1.5f);
    }
}
