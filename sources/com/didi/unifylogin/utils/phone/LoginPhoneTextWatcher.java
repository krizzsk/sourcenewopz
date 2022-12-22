package com.didi.unifylogin.utils.phone;

import android.text.Editable;
import android.widget.Button;
import android.widget.EditText;
import com.didi.sdk.util.TextUtil;
import com.didi.unifylogin.utils.simplifycode.LoginTextWatcher;
import com.didichuxing.drtl.tookit.DRtlToolkit;

public class LoginPhoneTextWatcher extends LoginTextWatcher {

    /* renamed from: a */
    Button f45000a;

    /* renamed from: b */
    boolean f45001b = false;

    /* renamed from: c */
    private EditText f45002c;

    /* renamed from: d */
    private boolean f45003d = true;

    public LoginPhoneTextWatcher(Button button) {
        this.f45000a = button;
    }

    public LoginPhoneTextWatcher(Button button, EditText editText) {
        this.f45000a = button;
        this.f45002c = editText;
    }

    public void afterTextChanged(Editable editable) {
        String obj = editable.toString();
        setButtonEnabled(obj);
        String specialPhone = PhoneUtils.toSpecialPhone(obj);
        if (!specialPhone.equals(obj) && !this.f45001b) {
            this.f45001b = true;
            editable.replace(0, editable.length(), specialPhone, 0, specialPhone.length());
            this.f45001b = false;
        }
    }

    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        super.onTextChanged(charSequence, i, i2, i3);
        if (DRtlToolkit.rtl()) {
            try {
                if (!this.f45003d) {
                    if (this.f45002c.getSelectionStart() == 4) {
                        this.f45002c.setSelection(5);
                    }
                    if (this.f45002c.getSelectionStart() == 8) {
                        this.f45002c.setSelection(9);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void setButtonEnabled(String str) {
        String normalPhone = PhoneUtils.toNormalPhone(str);
        if (this.f45000a != null) {
            if (TextUtil.isEmpty(normalPhone) || !PhoneUtils.isNum(normalPhone)) {
                this.f45000a.setEnabled(false);
            } else {
                this.f45000a.setEnabled(true);
            }
        }
    }

    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        if (!DRtlToolkit.rtl()) {
            return;
        }
        if (i3 == 0) {
            try {
                this.f45003d = true;
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (this.f45002c.getSelectionStart() == 4 && i3 == i2) {
            this.f45003d = true;
        } else {
            this.f45003d = false;
        }
    }
}
