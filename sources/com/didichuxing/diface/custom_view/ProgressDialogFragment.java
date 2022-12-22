package com.didichuxing.diface.custom_view;

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
import com.taxis99.R;

public class ProgressDialogFragment extends BaseDialogFragment {

    /* renamed from: a */
    private String f47507a;

    /* renamed from: b */
    private boolean f47508b = false;

    /* renamed from: c */
    private int f47509c = R.drawable.common_loading_progress_bar;

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
        this.f47509c = i;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Dialog dialog = getDialog();
        if (dialog == null) {
            return null;
        }
        dialog.requestWindowFeature(1);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        if (this.f47508b) {
            dialog.getWindow().clearFlags(16);
            dialog.getWindow().addFlags(8);
            dialog.getWindow().addFlags(128);
        }
        View inflate = layoutInflater.inflate(R.layout.common_loading_rtl, viewGroup);
        ((ProgressBar) inflate.findViewById(R.id.progress_bar)).setIndeterminateDrawable(getResources().getDrawable(this.f47509c));
        if (!TextUtil.isEmpty(this.f47507a)) {
            ((TextView) inflate.findViewById(R.id.tv_msg)).setText(this.f47507a);
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
        this.f47507a = str;
        setCancelable(z);
    }

    public void setOutsideTouchable(boolean z) {
        this.f47508b = z;
    }
}
