package com.adyen.threeds2.internal.p059ui.activity;

import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.DialogFragment;
import com.taxis99.R;

/* renamed from: com.adyen.threeds2.internal.ui.activity.c */
public class C1422c extends DialogFragment {
    /* renamed from: a */
    public static C1422c m1209a() {
        return new C1422c();
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        getDialog().getWindow().setBackgroundDrawable(new ColorDrawable(0));
        setCancelable(false);
        return layoutInflater.inflate(R.layout.a3ds2_widget_progress_dialog, viewGroup, false);
    }
}
