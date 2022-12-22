package com.didi.payment.pix.contacts.fragment;

import android.view.View;
import com.didi.payment.base.widget.DoubleCheckOnClickListener;
import com.didi.payment.pix.contacts.fragment.adapter.PhoneContactsAdapter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\u0006"}, mo175978d2 = {"com/didi/payment/pix/contacts/fragment/CustomContactsFragment$initContentView$2", "Lcom/didi/payment/base/widget/DoubleCheckOnClickListener;", "doClick", "", "v", "Landroid/view/View;", "wallet-service-pix_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: CustomContactsFragment.kt */
public final class CustomContactsFragment$initContentView$2 extends DoubleCheckOnClickListener {
    final /* synthetic */ CustomContactsFragment this$0;

    CustomContactsFragment$initContentView$2(CustomContactsFragment customContactsFragment) {
        this.this$0 = customContactsFragment;
    }

    public void doClick(View view) {
        PhoneContactsAdapter phoneContactsAdapter = null;
        this.this$0.getNameInputEt().setText((CharSequence) null);
        PhoneContactsAdapter access$getAdapter$p = this.this$0.f31029c;
        if (access$getAdapter$p == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
        } else {
            phoneContactsAdapter = access$getAdapter$p;
        }
        phoneContactsAdapter.displayAllContacts();
    }
}
