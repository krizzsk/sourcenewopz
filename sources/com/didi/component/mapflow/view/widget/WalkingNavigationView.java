package com.didi.component.mapflow.view.widget;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.didi.component.business.util.UiUtils;
import com.didi.travel.psnger.model.response.StationBoardHintModel;
import com.taxis99.R;

public class WalkingNavigationView extends LinearLayout {

    /* renamed from: a */
    private TextView f14539a;

    /* renamed from: b */
    private ImageView f14540b;

    /* renamed from: c */
    private View f14541c;

    /* renamed from: d */
    private LinearLayout f14542d;

    /* renamed from: e */
    private Context f14543e;

    /* renamed from: f */
    private ImageView f14544f;

    public WalkingNavigationView(Context context) {
        super(context);
        m10334a(context);
        this.f14543e = context;
    }

    public WalkingNavigationView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m10334a(context);
    }

    public WalkingNavigationView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m10334a(context);
    }

    public WalkingNavigationView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        m10334a(context);
    }

    /* renamed from: a */
    private void m10334a(Context context) {
        inflate(context, R.layout.walking_navigation_layout, this);
        this.f14540b = (ImageView) findViewById(R.id.iv_leftView);
        this.f14539a = (TextView) findViewById(R.id.tv_text);
        this.f14541c = findViewById(R.id.v_tail);
        this.f14542d = (LinearLayout) findViewById(R.id.ll_brand);
        this.f14544f = (ImageView) findViewById(R.id.ic_arrow);
    }

    public void setText(String str) {
        this.f14539a.setText(str);
    }

    public void setTextColor(String str) {
        this.f14539a.setText(str);
    }

    public void setBackGroundColor(String str) {
        setBrandBackground(str);
        setTailBackGround(str);
    }

    private void setBrandBackground(String str) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        try {
            gradientDrawable.setColor(Color.parseColor(str));
            gradientDrawable.setCornerRadius((float) UiUtils.dip2px(getContext(), 8.0f));
            this.f14542d.setBackground(gradientDrawable);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void setTailBackGround(String str) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        try {
            gradientDrawable.setColor(Color.parseColor(str));
            this.f14541c.setBackground(gradientDrawable);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setDate(StationBoardHintModel stationBoardHintModel, boolean z) {
        if (!TextUtils.isEmpty(stationBoardHintModel.mBgColor)) {
            setBackGroundColor(stationBoardHintModel.mBgColor);
        }
        if (!TextUtils.isEmpty(stationBoardHintModel.mIcon)) {
            ((RequestBuilder) Glide.with(this.f14543e).load(stationBoardHintModel.mIcon).placeholder(z ? R.drawable.icon_walking_navigation_bus : R.drawable.icon_walking_navigation_end)).into(this.f14540b);
        }
        if (!TextUtils.isEmpty(stationBoardHintModel.mText)) {
            setText(stationBoardHintModel.mText);
        }
        if (stationBoardHintModel.mShowArrow == 0) {
            this.f14544f.setVisibility(8);
        } else if (stationBoardHintModel.mShowArrow == 1) {
            this.f14544f.setVisibility(0);
        }
    }
}
