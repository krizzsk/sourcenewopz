package com.didi.sdk.view.dialog;

import android.app.Dialog;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.didi.sdk.util.TextUtil;
import com.didi.sdk.view.BaseDialogFragment;
import com.taxis99.R;

public class ProgressDialogFragment extends BaseDialogFragment {
    private int mIndeterminateDrawableID = R.drawable.common_loading_progress_bar;
    private String mMessage;
    private boolean mOutsideTouchable = false;

    public ProgressDialogFragment() {
        if (ProductControllerStyleManager.getInstance().getProductThemeStyle().getIndeterminateDrawable() != 0) {
            this.mIndeterminateDrawableID = ProductControllerStyleManager.getInstance().getProductThemeStyle().getIndeterminateDrawable();
        }
    }

    public void onStart() {
        super.onStart();
        Window window = getDialog().getWindow();
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.dimAmount = 0.0f;
        attributes.flags |= 2;
        window.setAttributes(attributes);
    }

    public void show(FragmentManager fragmentManager, String str) {
        if (TextUtils.isEmpty(str)) {
            str = "__didi_ProgressDialogFragment";
        }
        super.show(fragmentManager, str);
    }

    public int show(FragmentTransaction fragmentTransaction, String str) {
        if (isAdded() || isVisible() || isRemoving()) {
            return 0;
        }
        return super.show(fragmentTransaction, str);
    }

    public void setIndeterminateDrawable(int i) {
        this.mIndeterminateDrawableID = i;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Dialog dialog = getDialog();
        if (dialog == null) {
            return null;
        }
        dialog.requestWindowFeature(1);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        if (this.mOutsideTouchable) {
            dialog.getWindow().clearFlags(16);
            dialog.getWindow().addFlags(8);
            dialog.getWindow().addFlags(128);
        }
        View inflate = layoutInflater.inflate(R.layout.common_loading, viewGroup);
        ((ProgressBar) inflate.findViewById(R.id.progress_bar)).setIndeterminateDrawable(getResources().getDrawable(this.mIndeterminateDrawableID));
        if (!TextUtil.isEmpty(this.mMessage)) {
            ((TextView) inflate.findViewById(R.id.tv_msg)).setText(this.mMessage);
        }
        return inflate;
    }

    public void dismiss() {
        try {
            super.dismissAllowingStateLoss();
        } catch (Exception unused) {
        }
    }

    public void setContent(String str, boolean z) {
        this.mMessage = str;
        setCancelable(z);
    }

    public void setOutsideTouchable(boolean z) {
        this.mOutsideTouchable = z;
    }
}
