package com.didi.payment.kycservice.kyc.view.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.didi.payment.kycservice.kyc.response.GuidesInfoResp;
import com.taxis99.R;
import java.util.ArrayList;

public class StepProgressBar extends LinearLayout {

    /* renamed from: a */
    private View f30847a;

    /* renamed from: b */
    private LinearLayout f30848b;

    /* renamed from: c */
    private TextView f30849c;

    /* renamed from: d */
    private Context f30850d;

    public StepProgressBar(Context context) {
        super(context);
        m21731a(context);
    }

    public StepProgressBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m21731a(context);
    }

    public StepProgressBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m21731a(context);
    }

    /* renamed from: a */
    private void m21731a(Context context) {
        inflate(context, R.layout.kyc_step_layout, this);
        this.f30847a = findViewById(R.id.step_layout);
        this.f30848b = (LinearLayout) findViewById(R.id.step_view_container);
        this.f30849c = (TextView) findViewById(R.id.steep_count_view1);
        this.f30850d = context;
    }

    public void updateView(ArrayList<GuidesInfoResp.StepInfo> arrayList) {
        this.f30848b.removeAllViews();
        if (arrayList == null || arrayList.size() <= 1) {
            this.f30847a.setVisibility(8);
            return;
        }
        this.f30847a.setVisibility(0);
        for (int i = 0; i < arrayList.size(); i++) {
            if (i == 0) {
                this.f30849c.setBackgroundResource(arrayList.get(0).getStatus() == 2 ? R.drawable.kyc_step_point_success : R.drawable.kyc_step_point_bg);
                this.f30849c.setText(arrayList.get(0).getStatus() == 2 ? "" : "1");
            } else {
                m21730a(i, arrayList.get(i));
            }
        }
    }

    /* renamed from: a */
    private void m21730a(int i, GuidesInfoResp.StepInfo stepInfo) {
        LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(this.f30850d).inflate(R.layout.kyc_step_view, this.f30848b, false);
        View findViewById = linearLayout.findViewById(R.id.steep_line);
        TextView textView = (TextView) linearLayout.findViewById(R.id.steep_count_view);
        textView.setText(stepInfo.getStatus() == 2 ? "" : String.valueOf(i + 1));
        int status = stepInfo.getStatus();
        int i2 = R.drawable.kyc_step_point_gray_bg;
        if (status != 0) {
            if (status == 1) {
                i2 = R.drawable.kyc_step_point_bg;
            } else if (status == 2) {
                i2 = R.drawable.kyc_step_point_success;
            }
        }
        textView.setBackgroundResource(i2);
        findViewById.setBackgroundResource(stepInfo.getStatus() > 0 ? R.drawable.kyc_step_line_bg : R.drawable.kyc_step_line_gray_bg);
        this.f30848b.addView(linearLayout);
    }
}
