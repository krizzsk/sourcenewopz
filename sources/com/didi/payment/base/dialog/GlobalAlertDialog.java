package com.didi.payment.base.dialog;

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
import com.didi.payment.base.utils.UIUtil;
import com.didi.sdk.view.BaseDialogFragment;
import com.taxis99.R;
import java.util.ArrayList;
import java.util.List;

public class GlobalAlertDialog extends BaseDialogFragment {

    /* renamed from: a */
    private View f29868a;

    /* renamed from: b */
    private TextView f29869b;

    /* renamed from: c */
    private TextView f29870c;

    /* renamed from: d */
    private TextView[] f29871d = new TextView[3];

    /* renamed from: e */
    private List<String> f29872e = new ArrayList();
    /* access modifiers changed from: private */

    /* renamed from: f */
    public List<OnBtnClickListener> f29873f = new ArrayList();

    /* renamed from: g */
    private String f29874g;

    /* renamed from: h */
    private String f29875h;

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
        m20949a(view);
        m20948a();
    }

    /* renamed from: a */
    private void m20949a(View view) {
        this.f29868a = view.findViewById(R.id.image_close);
        this.f29869b = (TextView) view.findViewById(R.id.text_title);
        this.f29870c = (TextView) view.findViewById(R.id.text_message);
        this.f29871d[0] = (TextView) view.findViewById(R.id.button_top_bottom_1);
        this.f29871d[1] = (TextView) view.findViewById(R.id.button_top_bottom_2);
        this.f29871d[2] = (TextView) view.findViewById(R.id.button_top_bottom_3);
    }

    /* renamed from: a */
    private void m20948a() {
        int i = 0;
        while (i < this.f29871d.length && i < this.f29872e.size()) {
            TextView textView = this.f29871d[i];
            if (textView != null) {
                textView.setText(this.f29872e.get(i));
            }
            i++;
        }
        final int i2 = 0;
        while (i2 < this.f29871d.length && i2 < this.f29873f.size()) {
            TextView textView2 = this.f29871d[i2];
            if (textView2 != null) {
                textView2.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        AutoTrackHelper.trackViewOnClick(view);
                        OnBtnClickListener onBtnClickListener = (OnBtnClickListener) GlobalAlertDialog.this.f29873f.get(i2);
                        if (onBtnClickListener != null) {
                            onBtnClickListener.onBtnClick(GlobalAlertDialog.this, i2);
                        }
                    }
                });
            }
            i2++;
        }
        int size = this.f29872e.size();
        while (true) {
            TextView[] textViewArr = this.f29871d;
            if (size >= textViewArr.length) {
                break;
            }
            ((View) textViewArr[size].getParent()).setVisibility(8);
            size++;
        }
        this.f29870c.setText(this.f29874g);
        if (!TextUtils.isEmpty(this.f29875h)) {
            this.f29869b.setVisibility(0);
            this.f29869b.setText(this.f29875h);
            return;
        }
        this.f29869b.setVisibility(8);
    }

    public void setMsg(String str) {
        this.f29874g = str;
    }

    public void setTitle(String str) {
        this.f29875h = str;
    }

    public void setButtons(List<String> list) {
        if (list != null) {
            this.f29872e.clear();
            this.f29872e.addAll(list);
        }
    }

    public void setListeners(List<OnBtnClickListener> list) {
        if (list != null) {
            this.f29873f.clear();
            this.f29873f.addAll(list);
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
