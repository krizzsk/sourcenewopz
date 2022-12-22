package com.didi.beatles.p099im.views.dialog;

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
import com.taxis99.R;

/* renamed from: com.didi.beatles.im.views.dialog.IMProgressDialogFragment */
public class IMProgressDialogFragment extends IMBaseDialogFragment {

    /* renamed from: a */
    private String f10184a;

    /* renamed from: b */
    private boolean f10185b = false;

    /* renamed from: c */
    private int f10186c = R.drawable.im_widget_loading_anim;

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
            str = "__im_IMProgressDialogFragment";
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
        this.f10186c = i;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Dialog dialog = getDialog();
        if (dialog == null) {
            return null;
        }
        dialog.requestWindowFeature(1);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        if (this.f10185b) {
            dialog.getWindow().clearFlags(16);
            dialog.getWindow().addFlags(8);
            dialog.getWindow().addFlags(128);
        }
        View inflate = layoutInflater.inflate(R.layout.im_common_loading, viewGroup);
        ((ProgressBar) inflate.findViewById(R.id.progress_bar)).setIndeterminateDrawable(getResources().getDrawable(this.f10186c));
        if (!TextUtils.isEmpty(this.f10184a)) {
            ((TextView) inflate.findViewById(R.id.tv_msg)).setText(this.f10184a);
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
        this.f10184a = str;
        setCancelable(z);
    }

    public void setOutsideTouchable(boolean z) {
        this.f10185b = z;
    }
}
