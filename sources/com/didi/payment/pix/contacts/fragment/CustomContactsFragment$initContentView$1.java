package com.didi.payment.pix.contacts.fragment;

import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import com.didi.payment.pix.contacts.fragment.adapter.PhoneContactsAdapter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J*\u0010\u0006\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\tH\u0016J*\u0010\f\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tH\u0016¨\u0006\u000e"}, mo175978d2 = {"com/didi/payment/pix/contacts/fragment/CustomContactsFragment$initContentView$1", "Landroid/text/TextWatcher;", "afterTextChanged", "", "s", "Landroid/text/Editable;", "beforeTextChanged", "", "start", "", "count", "after", "onTextChanged", "before", "wallet-service-pix_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: CustomContactsFragment.kt */
public final class CustomContactsFragment$initContentView$1 implements TextWatcher {
    final /* synthetic */ CustomContactsFragment this$0;

    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    CustomContactsFragment$initContentView$1(CustomContactsFragment customContactsFragment) {
        this.this$0 = customContactsFragment;
    }

    public void afterTextChanged(Editable editable) {
        String valueOf = String.valueOf(editable);
        PhoneContactsAdapter phoneContactsAdapter = null;
        if (!TextUtils.isEmpty(valueOf)) {
            View access$getClearImg$p = this.this$0.f31028b;
            if (access$getClearImg$p == null) {
                Intrinsics.throwUninitializedPropertyAccessException("clearImg");
                access$getClearImg$p = null;
            }
            access$getClearImg$p.setVisibility(0);
        } else {
            View access$getClearImg$p2 = this.this$0.f31028b;
            if (access$getClearImg$p2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("clearImg");
                access$getClearImg$p2 = null;
            }
            access$getClearImg$p2.setVisibility(8);
        }
        PhoneContactsAdapter access$getAdapter$p = this.this$0.f31029c;
        if (access$getAdapter$p == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
        } else {
            phoneContactsAdapter = access$getAdapter$p;
        }
        phoneContactsAdapter.filterByInputPrefix(valueOf);
    }
}
