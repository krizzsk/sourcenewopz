package com.didi.component.bubbleLayout.view;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.taxis99.R;

public class BubbleTopBarView extends RelativeLayout {

    /* renamed from: a */
    private ImageView f11163a;

    /* renamed from: b */
    private TextView f11164b;

    /* renamed from: c */
    private View f11165c;

    public BubbleTopBarView(Context context) {
        this(context, (AttributeSet) null);
    }

    public BubbleTopBarView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public BubbleTopBarView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m7591a();
    }

    /* renamed from: a */
    private void m7591a() {
        LayoutInflater.from(getContext()).inflate(R.layout.bubble_top_bar_view, this, true);
        this.f11163a = (ImageView) findViewById(R.id.bubble_top_bar_arrow);
        this.f11164b = (TextView) findViewById(R.id.bubble_top_bar_title);
        this.f11165c = findViewById(R.id.bubble_top_bar_layout);
    }

    public void setAnimationProgress(float f) {
        if (f >= 1.0f) {
            f = 1.0f;
        }
        if (f < 0.0f) {
            f = 0.0f;
        }
        setAlphaProgress(f);
        setRotationProgress(f);
    }

    private void setAlphaProgress(float f) {
        this.f11165c.setBackgroundColor(Color.argb(((int) (f * 135.0f)) + 120, 255, 255, 255));
    }

    private void setRotationProgress(float f) {
        this.f11163a.setRotation(f * -90.0f);
        this.f11163a.invalidate();
    }

    public void setText(String str) {
        this.f11164b.setText(str);
    }
}
