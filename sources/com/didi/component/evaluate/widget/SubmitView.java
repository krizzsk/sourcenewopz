package com.didi.component.evaluate.widget;

import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.android.didi.theme.DidiThemeManager;
import com.didi.autotracker.AutoTrackHelper;
import com.taxis99.R;

public class SubmitView extends LinearLayout implements ISubmitView {

    /* renamed from: a */
    private final int f13474a = 0;

    /* renamed from: b */
    private final int f13475b = 1;

    /* renamed from: c */
    private final int f13476c = 2;

    /* renamed from: d */
    private final int f13477d = 3;

    /* renamed from: e */
    private TextView f13478e;

    /* renamed from: f */
    private View f13479f;

    /* renamed from: g */
    private ImageView f13480g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public View.OnClickListener f13481h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public int f13482i = 0;

    public SubmitView(Context context) {
        super(context);
        m9228a();
    }

    public SubmitView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m9228a();
    }

    public SubmitView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m9228a();
    }

    /* renamed from: a */
    private void m9228a() {
        setOrientation(1);
        setGravity(1);
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.global_evaluate_submit_view, this, true);
        this.f13479f = inflate;
        this.f13478e = (TextView) inflate.findViewById(R.id.submit_button_view);
        this.f13480g = (ImageView) this.f13479f.findViewById(R.id.submitting_view);
        this.f13479f.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                if (SubmitView.this.f13481h != null && SubmitView.this.f13482i != 1 && SubmitView.this.f13482i != 3) {
                    SubmitView.this.m9230b();
                    SubmitView.this.f13481h.onClick(view);
                }
            }
        });
        setTipHint((String) null);
        this.f13478e.setTextColor(DidiThemeManager.getIns().getResPicker(getContext()).getColor(R.attr.submit_btn_text_color_selector));
        this.f13478e.setBackgroundResource(DidiThemeManager.getIns().getResPicker(getContext()).getResIdByTheme(R.attr.submit_btn_bg_selector));
        this.f13480g.setBackgroundResource(DidiThemeManager.getIns().getResPicker(getContext()).getResIdByTheme(R.attr.submit_btn_bg_selector));
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m9230b() {
        this.f13482i = 1;
        this.f13478e.setVisibility(8);
        this.f13480g.setVisibility(0);
        ((AnimationDrawable) this.f13480g.getDrawable()).start();
    }

    public void setEnable(boolean z) {
        setVisibility(0);
        if (z) {
            this.f13478e.setTextColor(DidiThemeManager.getIns().getResPicker(getContext()).getColor(R.attr.submit_btn_text_color_selector));
            this.f13478e.setBackgroundResource(DidiThemeManager.getIns().getResPicker(getContext()).getResIdByTheme(R.attr.submit_btn_bg_selector));
        } else {
            this.f13478e.setTextColor(getResources().getColor(R.color.g_color_CCCCCC));
            this.f13478e.setBackgroundColor(getResources().getColor(R.color.g_color_EEE));
        }
        this.f13479f.setClickable(z);
    }

    public void showLoading() {
        this.f13480g.setVisibility(0);
        this.f13478e.setVisibility(8);
        this.f13479f.setClickable(false);
    }

    public void hideLoading() {
        this.f13480g.setVisibility(8);
        this.f13478e.setVisibility(0);
        this.f13479f.setClickable(true);
    }

    public void setOnclickListener(View.OnClickListener onClickListener) {
        this.f13481h = onClickListener;
    }

    public void setTipHint(String str) {
        if (TextUtils.isEmpty(str)) {
            this.f13478e.setText(R.string.oc_evaluate_submit);
        } else {
            this.f13478e.setText(String.format(getResources().getString(R.string.global_evaluate_commit_tip), new Object[]{str}));
        }
        this.f13478e.setContentDescription(this.f13478e.getText().toString().trim() + getResources().getString(R.string.global_evaluate_button_to_submit));
    }

    public void submitSuccess() {
        this.f13482i = 3;
        this.f13478e.setVisibility(0);
        this.f13480g.setVisibility(8);
        this.f13478e.setText(R.string.oc_evaluate_submitted);
    }

    public void submitFail() {
        this.f13482i = 2;
        this.f13478e.setVisibility(0);
        this.f13480g.setVisibility(8);
        this.f13478e.setText(R.string.oc_evaluate_submit_retry);
    }
}
