package com.didi.safetoolkit.business.contacts;

import android.graphics.Color;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import kotlin.Metadata;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J*\u0010\u0006\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\tH\u0016J*\u0010\f\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tH\u0016¨\u0006\u000e"}, mo175978d2 = {"com/didi/safetoolkit/business/contacts/SfContactsManageOptActivity$setListener$7", "Landroid/text/TextWatcher;", "afterTextChanged", "", "s", "Landroid/text/Editable;", "beforeTextChanged", "", "start", "", "count", "after", "onTextChanged", "before", "safe-toolkit_passengerRelease"}, mo175979k = 1, mo175980mv = {1, 1, 15})
/* compiled from: SfContactsManageOptActivity.kt */
public final class SfContactsManageOptActivity$setListener$7 implements TextWatcher {
    final /* synthetic */ SfContactsManageOptActivity this$0;

    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    SfContactsManageOptActivity$setListener$7(SfContactsManageOptActivity sfContactsManageOptActivity) {
        this.this$0 = sfContactsManageOptActivity;
    }

    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        if (TextUtils.isEmpty(charSequence)) {
            ImageView access$getPhoneClearIcon$p = this.this$0.f34309f;
            if (access$getPhoneClearIcon$p != null) {
                access$getPhoneClearIcon$p.setVisibility(8);
            }
            Button access$getAddButton$p = this.this$0.f34310g;
            if (access$getAddButton$p != null) {
                access$getAddButton$p.setEnabled(false);
            }
            Button access$getAddButton$p2 = this.this$0.f34310g;
            if (access$getAddButton$p2 != null) {
                access$getAddButton$p2.setTextColor(Color.parseColor("#D4D7D9"));
                return;
            }
            return;
        }
        ImageView access$getPhoneClearIcon$p2 = this.this$0.f34309f;
        if (access$getPhoneClearIcon$p2 != null) {
            access$getPhoneClearIcon$p2.setVisibility(0);
        }
        Button access$getAddButton$p3 = this.this$0.f34310g;
        if (access$getAddButton$p3 != null) {
            access$getAddButton$p3.setEnabled(true);
        }
        Button access$getAddButton$p4 = this.this$0.f34310g;
        if (access$getAddButton$p4 != null) {
            access$getAddButton$p4.setTextColor(Color.parseColor("#FFFFFF"));
        }
    }

    public void afterTextChanged(Editable editable) {
        EditText access$getPhoneInput$p = this.this$0.f34306c;
        boolean hasFocus = access$getPhoneInput$p != null ? access$getPhoneInput$p.hasFocus() : false;
        EditText access$getPhoneInput$p2 = this.this$0.f34306c;
        boolean isEmpty = TextUtils.isEmpty(access$getPhoneInput$p2 != null ? access$getPhoneInput$p2.getText() : null);
        SfContactsManageOptActivity sfContactsManageOptActivity = this.this$0;
        sfContactsManageOptActivity.m24278a(sfContactsManageOptActivity.f34313j, !isEmpty, hasFocus);
    }
}
