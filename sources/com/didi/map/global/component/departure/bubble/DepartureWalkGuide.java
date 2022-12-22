package com.didi.map.global.component.departure.bubble;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import androidx.cardview.widget.CardView;
import com.bumptech.glide.Glide;
import com.didi.common.map.util.DisplayUtils;
import com.didi.map.global.component.departure.model.AddressWalkGuide;
import com.taxis99.R;

public class DepartureWalkGuide extends CardView {

    /* renamed from: a */
    private int f24886a;

    /* renamed from: b */
    private int f24887b;

    /* renamed from: c */
    private int f24888c;

    /* renamed from: d */
    private ImageView f24889d;

    /* renamed from: e */
    private AddressWalkGuide f24890e;

    public DepartureWalkGuide(Context context) {
        this(context, (AttributeSet) null);
    }

    public DepartureWalkGuide(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public DepartureWalkGuide(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f24886a = DisplayUtils.dp2px(context, 80.0f);
        this.f24887b = DisplayUtils.dp2px(context, 80.0f);
        this.f24888c = DisplayUtils.dp2px(context, 20.0f);
        setRadius((float) DisplayUtils.dp2px(context, 15.0f));
        this.f24889d = (ImageView) LayoutInflater.from(context).inflate(R.layout.layout_map_departure_walk_guide, this).findViewById(R.id.departure_image_guide);
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        ImageView imageView = this.f24889d;
        if (imageView != null) {
            imageView.setOnClickListener(onClickListener);
        }
    }

    public void setData(AddressWalkGuide addressWalkGuide) {
        if (addressWalkGuide != null && addressWalkGuide.isValid()) {
            this.f24890e = addressWalkGuide;
            Glide.with(getContext()).load(addressWalkGuide.getGuidePhoto()).into(this.f24889d);
        }
    }

    public int getWIDTH() {
        return this.f24886a;
    }

    public int getHEIGHT() {
        return this.f24887b;
    }

    public int getANGLE() {
        return this.f24888c;
    }
}
