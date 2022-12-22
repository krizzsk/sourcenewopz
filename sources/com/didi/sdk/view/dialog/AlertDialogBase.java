package com.didi.sdk.view.dialog;

import android.app.Dialog;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import androidx.fragment.app.FragmentManager;
import com.didi.sdk.view.BaseDialogFragment;
import com.taxis99.R;

public abstract class AlertDialogBase extends BaseDialogFragment {
    /* access modifiers changed from: protected */
    public abstract View getRootView(LayoutInflater layoutInflater, ViewGroup viewGroup);

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setStyle(1, 16973939);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Dialog dialog = getDialog();
        if (dialog != null) {
            dialog.requestWindowFeature(1);
            dialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
            dialog.getWindow().getAttributes().windowAnimations = R.style.common_dialog_anim_style;
        }
        return getRootView(layoutInflater, viewGroup);
    }

    public void onStart() {
        super.onStart();
        Dialog dialog = getDialog();
        if (dialog != null) {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            getActivity().getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
            Window window = dialog.getWindow();
            window.setLayout((int) (((double) displayMetrics.widthPixels) * 0.712d), -2);
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.dimAmount = 0.4f;
            attributes.flags |= 2;
            window.setAttributes(attributes);
        }
    }

    public void show(FragmentManager fragmentManager, String str) {
        if (TextUtils.isEmpty(str)) {
            str = "__didi_AlertDialogFragment";
        }
        super.show(fragmentManager, str);
    }
}
