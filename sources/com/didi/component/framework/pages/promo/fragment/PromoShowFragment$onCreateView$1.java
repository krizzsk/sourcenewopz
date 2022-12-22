package com.didi.component.framework.pages.promo.fragment;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;
import kotlin.Metadata;

@Metadata(mo175977d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J*\u0010\u0006\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\tH\u0016J*\u0010\f\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tH\u0016¨\u0006\u000e"}, mo175978d2 = {"com/didi/component/framework/pages/promo/fragment/PromoShowFragment$onCreateView$1", "Landroid/text/TextWatcher;", "afterTextChanged", "", "s", "Landroid/text/Editable;", "beforeTextChanged", "", "start", "", "count", "after", "onTextChanged", "before", "framework_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: PromoShowFragment.kt */
public final class PromoShowFragment$onCreateView$1 implements TextWatcher {
    final /* synthetic */ Button $confirmBtn;

    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    PromoShowFragment$onCreateView$1(Button button) {
        this.$confirmBtn = button;
    }

    public void afterTextChanged(Editable editable) {
        boolean z = false;
        int length = editable == null ? 0 : editable.length();
        Button button = this.$confirmBtn;
        if (button != null) {
            if (length >= 3) {
                z = true;
            }
            button.setEnabled(z);
        }
    }
}
