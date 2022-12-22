package com.didi.soda.customer.widget.map;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.taxis99.R;

public class BusinessMarkerView extends RelativeLayout {

    /* renamed from: a */
    private ImageView f42119a;

    public BusinessMarkerView(Context context) {
        super(context);
        m29703a();
    }

    public ImageView getBusinessImageView() {
        return this.f42119a;
    }

    public ImageView getBusinessLogoIv() {
        return this.f42119a;
    }

    public void setBusinessLogo(Drawable drawable) {
        this.f42119a.setBackgroundDrawable(drawable);
    }

    /* renamed from: a */
    private void m29703a() {
        inflate(getContext(), R.layout.customer_widget_marker_business, this);
        this.f42119a = (ImageView) findViewById(R.id.customer_iv_business_marker);
    }
}
