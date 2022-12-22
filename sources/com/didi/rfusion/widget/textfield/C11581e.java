package com.didi.rfusion.widget.textfield;

import android.text.TextWatcher;
import android.text.method.PasswordTransformationMethod;
import android.text.method.TransformationMethod;
import android.view.View;
import android.widget.EditText;
import com.didi.rfusion.material.internal.RFCheckableIconButton;
import com.didi.rfusion.widget.textfield.RFTextInputLayout;
import com.taxis99.R;

/* renamed from: com.didi.rfusion.widget.textfield.e */
/* compiled from: RFPasswordToggleEndIconDelegate */
class C11581e extends C11578b {
    /* access modifiers changed from: private */

    /* renamed from: c */
    public RFCheckableIconButton f33926c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public final TextWatcher f33927d = new RFPasswordToggleEndIconDelegate$1(this);

    /* renamed from: e */
    private final RFTextInputLayout.OnEditTextAttachedListener f33928e = new RFPasswordToggleEndIconDelegate$2(this);

    /* renamed from: f */
    private final RFTextInputLayout.OnEndIconChangedListener f33929f = new RFPasswordToggleEndIconDelegate$3(this);

    C11581e(RFTextInputLayout rFTextInputLayout) {
        super(rFTextInputLayout);
        this.f33926c = rFTextInputLayout.getInnerEndIconView();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo88388a() {
        this.f33926c.setIcon(this.f33887b.getString(R.string.rf_icon_filled_hide), this.f33887b.getString(R.string.rf_icon_filled_see));
        this.f33926c.setTextColor(this.f33887b.getResources().getColor(R.color.rf_color_gery_1_0_000000));
        this.f33886a.setInnerEndIconOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                C11581e.this.m23938a(view);
            }
        });
        this.f33886a.addOnEditTextAttachedListener(this.f33928e);
        this.f33886a.mo88276a(this.f33929f);
        EditText editText = this.f33886a.getEditText();
        if (m23939a(editText)) {
            editText.setTransformationMethod(PasswordTransformationMethod.getInstance());
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m23938a(View view) {
        EditText editText = this.f33886a.getEditText();
        if (editText != null) {
            int selectionEnd = editText.getSelectionEnd();
            if (m23942b()) {
                editText.setTransformationMethod((TransformationMethod) null);
            } else {
                editText.setTransformationMethod(PasswordTransformationMethod.getInstance());
            }
            int length = editText.getText().length();
            if (selectionEnd >= 0 && selectionEnd <= length) {
                editText.setSelection(selectionEnd);
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public boolean m23942b() {
        EditText editText = this.f33886a.getEditText();
        return editText != null && (editText.getTransformationMethod() instanceof PasswordTransformationMethod);
    }

    /* renamed from: a */
    private static boolean m23939a(EditText editText) {
        return editText != null && (editText.getInputType() == 16 || editText.getInputType() == 128 || editText.getInputType() == 144 || editText.getInputType() == 224);
    }
}
