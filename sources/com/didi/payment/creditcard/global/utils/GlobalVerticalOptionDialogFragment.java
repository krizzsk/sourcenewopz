package com.didi.payment.creditcard.global.utils;

import android.app.Dialog;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.sdk.view.BaseDialogFragment;
import com.taxis99.R;

public class GlobalVerticalOptionDialogFragment extends BaseDialogFragment {

    /* renamed from: a */
    private TextView f30469a;

    /* renamed from: b */
    private TextView f30470b;

    /* renamed from: c */
    private LinearLayout f30471c;

    /* renamed from: d */
    private TextView f30472d;

    /* renamed from: e */
    private LinearLayout f30473e;

    /* renamed from: f */
    private TextView f30474f;

    /* renamed from: g */
    private String f30475g;

    /* renamed from: h */
    private String f30476h;

    /* renamed from: i */
    private String f30477i;

    /* renamed from: j */
    private String f30478j;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public View.OnClickListener f30479k;
    /* access modifiers changed from: private */

    /* renamed from: l */
    public View.OnClickListener f30480l;

    public void setTitle(String str) {
        this.f30475g = str;
    }

    public void setContent(String str) {
        this.f30476h = str;
    }

    public void setNegativeButton(String str, View.OnClickListener onClickListener) {
        this.f30478j = str;
        this.f30480l = onClickListener;
    }

    public void setPositiveButton(String str, View.OnClickListener onClickListener) {
        this.f30477i = str;
        this.f30479k = onClickListener;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Dialog dialog = getDialog();
        if (dialog != null) {
            dialog.requestWindowFeature(1);
            dialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
            dialog.getWindow().getAttributes().windowAnimations = R.style.common_dialog_anim_style;
        }
        return layoutInflater.inflate(R.layout.one_payment_creditcard_global_dialog_vertical_option, viewGroup, false);
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        m21426a(view);
        m21425a();
    }

    /* renamed from: a */
    private void m21426a(View view) {
        this.f30469a = (TextView) view.findViewById(R.id.tv_title);
        this.f30470b = (TextView) view.findViewById(R.id.tv_content);
        this.f30471c = (LinearLayout) view.findViewById(R.id.ll_option_1);
        this.f30472d = (TextView) view.findViewById(R.id.tv_option_1);
        this.f30473e = (LinearLayout) view.findViewById(R.id.ll_option_2);
        this.f30474f = (TextView) view.findViewById(R.id.tv_option_2);
    }

    /* renamed from: a */
    private void m21425a() {
        if (!TextUtils.isEmpty(this.f30475g)) {
            this.f30469a.setVisibility(0);
            this.f30469a.setText(this.f30475g);
        }
        if (!TextUtils.isEmpty(this.f30476h)) {
            this.f30470b.setVisibility(0);
            this.f30470b.setText(this.f30476h);
        }
        if (!TextUtils.isEmpty(this.f30477i)) {
            this.f30471c.setVisibility(0);
            this.f30472d.setText(this.f30477i);
            this.f30471c.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    AutoTrackHelper.trackViewOnClick(view);
                    GlobalVerticalOptionDialogFragment.this.dismiss();
                    if (GlobalVerticalOptionDialogFragment.this.f30479k != null) {
                        GlobalVerticalOptionDialogFragment.this.f30479k.onClick(view);
                    }
                }
            });
        }
        if (!TextUtils.isEmpty(this.f30478j)) {
            this.f30473e.setVisibility(0);
            this.f30474f.setText(this.f30478j);
            this.f30473e.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    AutoTrackHelper.trackViewOnClick(view);
                    GlobalVerticalOptionDialogFragment.this.dismiss();
                    if (GlobalVerticalOptionDialogFragment.this.f30480l != null) {
                        GlobalVerticalOptionDialogFragment.this.f30480l.onClick(view);
                    }
                }
            });
        }
    }
}
