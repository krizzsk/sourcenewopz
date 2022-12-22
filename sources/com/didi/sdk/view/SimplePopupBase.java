package com.didi.sdk.view;

import android.app.Dialog;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.taxis99.R;

public abstract class SimplePopupBase extends BaseDialogFragment {
    protected View mRootView;

    /* access modifiers changed from: protected */
    public abstract int getLayout();

    /* access modifiers changed from: protected */
    public abstract void initView();

    public Dialog onCreateDialog(Bundle bundle) {
        Dialog onCreateDialog = super.onCreateDialog(bundle);
        onCreateDialog.requestWindowFeature(1);
        onCreateDialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        onCreateDialog.getWindow().getAttributes().windowAnimations = R.style.common_popup_anim_style;
        return onCreateDialog;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        getDialog().requestWindowFeature(1);
        this.mRootView = layoutInflater.inflate(getLayout(), viewGroup);
        initView();
        return this.mRootView;
    }

    public void show(FragmentManager fragmentManager, String str) {
        if (!isAdded() && !isVisible() && !isRemoving()) {
            super.show(fragmentManager, str);
        }
    }

    public int show(FragmentTransaction fragmentTransaction, String str) {
        if (isAdded() || isVisible() || isRemoving()) {
            return 0;
        }
        return super.show(fragmentTransaction, str);
    }

    public void onStart() {
        super.onStart();
        Window window = getDialog().getWindow();
        window.setBackgroundDrawable(new ColorDrawable(0));
        window.getAttributes().windowAnimations = R.style.common_popup_anim_style;
        DisplayMetrics displayMetrics = new DisplayMetrics();
        getActivity().getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        window.setLayout(displayMetrics.widthPixels, -2);
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.dimAmount = 0.4f;
        attributes.flags |= 2;
        attributes.gravity = 80;
        window.setAttributes(attributes);
    }
}
