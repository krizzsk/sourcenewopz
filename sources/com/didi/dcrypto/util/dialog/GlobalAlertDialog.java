package com.didi.dcrypto.util.dialog;

import android.app.Dialog;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.fragment.app.DialogFragment;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.dcrypto.util.UIUtil;
import com.didi.sdk.view.BaseDialogFragment;
import com.taxis99.R;
import java.util.ArrayList;
import java.util.List;

public class GlobalAlertDialog extends BaseDialogFragment {

    /* renamed from: a */
    private View f16505a;

    /* renamed from: b */
    private TextView f16506b;

    /* renamed from: c */
    private TextView f16507c;

    /* renamed from: d */
    private TextView[] f16508d = new TextView[3];

    /* renamed from: e */
    private List<String> f16509e = new ArrayList();
    /* access modifiers changed from: private */

    /* renamed from: f */
    public List<OnBtnClickListener> f16510f = new ArrayList();

    /* renamed from: g */
    private String f16511g;

    /* renamed from: h */
    private String f16512h;

    public interface OnBtnClickListener {
        void onBtnClick(DialogFragment dialogFragment, int i);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Dialog dialog = getDialog();
        if (dialog != null) {
            dialog.setCanceledOnTouchOutside(false);
            dialog.requestWindowFeature(1);
            dialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
            dialog.getWindow().getAttributes().windowAnimations = R.style.common_dialog_anim_style;
        }
        return layoutInflater.inflate(R.layout.pay_base_global_dialog_alert, viewGroup, false);
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        m12129a(view);
        m12128a();
    }

    /* renamed from: a */
    private void m12129a(View view) {
        this.f16505a = view.findViewById(R.id.image_close);
        this.f16506b = (TextView) view.findViewById(R.id.text_title);
        this.f16507c = (TextView) view.findViewById(R.id.text_message);
        this.f16508d[0] = (TextView) view.findViewById(R.id.button_top_bottom_1);
        this.f16508d[1] = (TextView) view.findViewById(R.id.button_top_bottom_2);
        this.f16508d[2] = (TextView) view.findViewById(R.id.button_top_bottom_3);
    }

    /* renamed from: a */
    private void m12128a() {
        int i = 0;
        while (i < this.f16508d.length && i < this.f16509e.size()) {
            TextView textView = this.f16508d[i];
            if (textView != null) {
                textView.setText(this.f16509e.get(i));
            }
            i++;
        }
        final int i2 = 0;
        while (i2 < this.f16508d.length && i2 < this.f16510f.size()) {
            TextView textView2 = this.f16508d[i2];
            if (textView2 != null) {
                textView2.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        AutoTrackHelper.trackViewOnClick(view);
                        OnBtnClickListener onBtnClickListener = (OnBtnClickListener) GlobalAlertDialog.this.f16510f.get(i2);
                        if (onBtnClickListener != null) {
                            onBtnClickListener.onBtnClick(GlobalAlertDialog.this, i2);
                        }
                    }
                });
            }
            i2++;
        }
        int size = this.f16509e.size();
        while (true) {
            TextView[] textViewArr = this.f16508d;
            if (size >= textViewArr.length) {
                break;
            }
            ((View) textViewArr[size].getParent()).setVisibility(8);
            size++;
        }
        this.f16507c.setText(this.f16511g);
        if (!TextUtils.isEmpty(this.f16512h)) {
            this.f16506b.setVisibility(0);
            this.f16506b.setText(this.f16512h);
            return;
        }
        this.f16506b.setVisibility(8);
    }

    public void setMsg(String str) {
        this.f16511g = str;
    }

    public void setTitle(String str) {
        this.f16512h = str;
    }

    public void setButtons(List<String> list) {
        if (list != null) {
            this.f16509e.clear();
            this.f16509e.addAll(list);
        }
    }

    public void setListeners(List<OnBtnClickListener> list) {
        if (list != null) {
            this.f16510f.clear();
            this.f16510f.addAll(list);
        }
    }

    public void onStart() {
        super.onStart();
        Dialog dialog = getDialog();
        if (dialog != null) {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            getActivity().getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
            dialog.getWindow().setLayout(displayMetrics.widthPixels - UIUtil.dip2px(getContext(), 108.0f), -2);
        }
    }
}
