package com.didi.sdk.sidebar.account;

import android.app.Dialog;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import androidx.fragment.app.DialogFragment;
import com.taxis99.R;

public class MyAccountBaseFragment extends DialogFragment {
    /* access modifiers changed from: protected */
    public int getWindowAnimations() {
        return R.style.MyAccountAnimation;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setStyle(0, R.style.PopDialog);
    }

    /* access modifiers changed from: protected */
    public boolean initStyle() {
        Dialog dialog = getDialog();
        if (dialog == null) {
            return false;
        }
        dialog.requestWindowFeature(1);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        if (getWindowAnimations() > 0) {
            dialog.getWindow().setWindowAnimations(getWindowAnimations());
        }
        return true;
    }
}
