package com.didi.payment.creditcard.global.utils;

import android.app.Dialog;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.sdk.view.BaseDialogFragment;
import com.taxis99.R;

public class GlobalCreditPayTipDialogFragment extends BaseDialogFragment {

    /* renamed from: a */
    private TextView f30461a;

    /* renamed from: b */
    private TextView f30462b;

    /* renamed from: c */
    private Button f30463c;

    /* renamed from: d */
    private Button f30464d;

    /* renamed from: e */
    private LinearLayout f30465e;

    /* renamed from: f */
    private String f30466f;

    /* renamed from: g */
    private String f30467g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public PayTipDialogEventListener f30468h;

    public interface PayTipDialogEventListener {
        void onFaqClick();

        void onNegativeClick();

        void onPositiveClick();
    }

    public void setTip(String str) {
        this.f30467g = str;
    }

    public void setContent(String str) {
        this.f30466f = str;
    }

    public void setPayTipDialogEventListener(PayTipDialogEventListener payTipDialogEventListener) {
        this.f30468h = payTipDialogEventListener;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Dialog dialog = getDialog();
        if (dialog != null) {
            dialog.requestWindowFeature(1);
            dialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
            dialog.getWindow().getAttributes().windowAnimations = R.style.common_dialog_anim_style;
        }
        return layoutInflater.inflate(R.layout.one_payment_creditcard_global_dialog_pay_tip, viewGroup, false);
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        m21423a(view);
        m21422a();
    }

    /* renamed from: a */
    private void m21423a(View view) {
        this.f30461a = (TextView) view.findViewById(R.id.tv_dialog_content);
        this.f30462b = (TextView) view.findViewById(R.id.tv_dialog_tip);
        this.f30463c = (Button) view.findViewById(R.id.btn_confirm);
        this.f30464d = (Button) view.findViewById(R.id.btn_cancel);
        this.f30465e = (LinearLayout) view.findViewById(R.id.ll_faq_tip);
    }

    /* renamed from: a */
    private void m21422a() {
        this.f30461a.setText(this.f30466f);
        this.f30462b.setText(this.f30467g);
        this.f30463c.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                GlobalCreditPayTipDialogFragment.this.dismissAllowingStateLoss();
                if (GlobalCreditPayTipDialogFragment.this.f30468h != null) {
                    GlobalCreditPayTipDialogFragment.this.f30468h.onPositiveClick();
                }
            }
        });
        this.f30464d.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                GlobalCreditPayTipDialogFragment.this.dismissAllowingStateLoss();
                if (GlobalCreditPayTipDialogFragment.this.f30468h != null) {
                    GlobalCreditPayTipDialogFragment.this.f30468h.onNegativeClick();
                }
            }
        });
        this.f30465e.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                GlobalCreditPayTipDialogFragment.this.dismissAllowingStateLoss();
                if (GlobalCreditPayTipDialogFragment.this.f30468h != null) {
                    GlobalCreditPayTipDialogFragment.this.f30468h.onFaqClick();
                }
            }
        });
    }
}
