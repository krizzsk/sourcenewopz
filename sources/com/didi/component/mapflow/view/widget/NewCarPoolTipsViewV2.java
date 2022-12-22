package com.didi.component.mapflow.view.widget;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.taxis99.R;

public class NewCarPoolTipsViewV2 extends LinearLayout {
    public NewCarPoolTipsViewV2(Context context) {
        super(context);
        m10332a();
    }

    public NewCarPoolTipsViewV2(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m10332a();
    }

    public NewCarPoolTipsViewV2(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m10332a();
    }

    /* renamed from: a */
    private void m10332a() {
        setOrientation(1);
        setGravity(1);
        TextView textView = new TextView(getContext());
        textView.setLayoutParams(new LinearLayout.LayoutParams(-2, m10331a(20.0f)));
        textView.setGravity(17);
        textView.setText(R.string.map_flow_circle_text);
        textView.setTextSize(2, 10.0f);
        textView.setTextColor(Color.parseColor("#ffffff"));
        int a = m10331a(8.0f);
        int a2 = m10331a(4.0f);
        textView.setPadding(a, a2, a, a2);
        textView.setBackground(getResources().getDrawable(R.drawable.global_mapflow_tips_bg_shape_v2));
        addView(textView);
    }

    /* renamed from: a */
    private int m10331a(float f) {
        return (int) TypedValue.applyDimension(1, f, getResources().getDisplayMetrics());
    }
}
