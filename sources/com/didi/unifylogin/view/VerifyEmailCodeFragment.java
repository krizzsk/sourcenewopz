package com.didi.unifylogin.view;

import android.widget.TextView;
import com.taxis99.R;

public class VerifyEmailCodeFragment extends VerifyCodeFragment {
    /* access modifiers changed from: protected */
    public void updateView() {
        super.updateView();
        this.phoneOrEmailTv.setText(this.messenger.getHideEmail());
        int i = this.curCodeLength == 0 ? 6 : this.curCodeLength;
        String string = getString(R.string.login_unify_verify_code_send_to_email);
        TextView textView = this.subTitleTv;
        textView.setText(string.replace("{{digit}}", i + ""));
    }
}
