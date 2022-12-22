package com.didi.payment.creditcard.global.utils;

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
import android.widget.Button;
import android.widget.TextView;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.sdk.view.BaseDialogFragment;
import com.taxis99.R;

public class GlobalAddCardFailureDialogFragment extends BaseDialogFragment {

    /* renamed from: a */
    private TextView f30449a;

    /* renamed from: b */
    private TextView f30450b;

    /* renamed from: c */
    private Button f30451c;

    /* renamed from: d */
    private Button f30452d;

    /* renamed from: e */
    private String f30453e;

    /* renamed from: f */
    private String f30454f;

    /* renamed from: g */
    private String f30455g;

    /* renamed from: h */
    private String f30456h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public View.OnClickListener f30457i;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public View.OnClickListener f30458j;

    public void setTitle(String str) {
        this.f30453e = str;
    }

    public void setContent(String str) {
        this.f30454f = str;
    }

    public void setNegativeButton(String str, View.OnClickListener onClickListener) {
        this.f30456h = str;
        this.f30458j = onClickListener;
    }

    public void setPositiveButton(String str, View.OnClickListener onClickListener) {
        this.f30455g = str;
        this.f30457i = onClickListener;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Dialog dialog = getDialog();
        if (dialog != null) {
            dialog.requestWindowFeature(1);
            dialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
            dialog.getWindow().getAttributes().windowAnimations = R.style.common_dialog_anim_style;
        }
        return layoutInflater.inflate(R.layout.one_payment_creditcard_global_dialog_failureguide, viewGroup, false);
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

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        m21419a(view);
        m21418a();
    }

    /* renamed from: a */
    private void m21419a(View view) {
        this.f30449a = (TextView) view.findViewById(R.id.tv_title);
        this.f30450b = (TextView) view.findViewById(R.id.tv_content);
        this.f30451c = (Button) view.findViewById(R.id.btn_confirm);
        this.f30452d = (Button) view.findViewById(R.id.btn_cancel);
    }

    /* renamed from: a */
    private void m21418a() {
        if (!TextUtils.isEmpty(this.f30453e)) {
            this.f30449a.setVisibility(0);
            this.f30449a.setText(this.f30453e);
        }
        if (!TextUtils.isEmpty(this.f30454f)) {
            this.f30450b.setVisibility(0);
            this.f30450b.setText(this.f30454f);
        }
        if (!TextUtils.isEmpty(this.f30455g)) {
            this.f30451c.setVisibility(0);
            this.f30451c.setText(this.f30455g);
            this.f30451c.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    AutoTrackHelper.trackViewOnClick(view);
                    GlobalAddCardFailureDialogFragment.this.dismiss();
                    if (GlobalAddCardFailureDialogFragment.this.f30457i != null) {
                        GlobalAddCardFailureDialogFragment.this.f30457i.onClick(view);
                    }
                }
            });
        }
        if (!TextUtils.isEmpty(this.f30456h)) {
            this.f30452d.setVisibility(0);
            this.f30452d.setText(this.f30456h);
            this.f30452d.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    AutoTrackHelper.trackViewOnClick(view);
                    GlobalAddCardFailureDialogFragment.this.dismiss();
                    if (GlobalAddCardFailureDialogFragment.this.f30458j != null) {
                        GlobalAddCardFailureDialogFragment.this.f30458j.onClick(view);
                    }
                }
            });
        }
    }
}
