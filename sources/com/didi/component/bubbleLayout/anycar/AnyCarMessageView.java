package com.didi.component.bubbleLayout.anycar;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.didi.component.business.util.UiUtils;
import com.didi.travel.psnger.model.response.estimate.CarMessageModel;
import com.taxis99.R;

public class AnyCarMessageView extends FrameLayout {

    /* renamed from: a */
    private Context f11008a;

    /* renamed from: b */
    private View f11009b;

    /* renamed from: c */
    private ImageView f11010c;

    /* renamed from: d */
    private TextView f11011d;

    /* renamed from: e */
    private CarMessageModel f11012e;

    public AnyCarMessageView(Context context) {
        super(context);
        m7456a(context);
    }

    public AnyCarMessageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m7456a(context);
    }

    /* renamed from: a */
    private void m7456a(Context context) {
        this.f11008a = context;
        View inflate = LayoutInflater.from(context).inflate(R.layout.anycar_message_layout, this);
        this.f11009b = inflate;
        this.f11010c = (ImageView) inflate.findViewById(R.id.iv_icon);
        this.f11011d = (TextView) this.f11009b.findViewById(R.id.tv_message);
    }

    public void setData(CarMessageModel carMessageModel) {
        this.f11012e = carMessageModel;
        update();
    }

    public void update() {
        int i;
        int i2;
        CarMessageModel carMessageModel = this.f11012e;
        if (carMessageModel == null || TextUtils.isEmpty(carMessageModel.messageBgStart) || TextUtils.isEmpty(this.f11012e.messageBgEnd)) {
            i2 = Color.parseColor("#FFDDCC");
            i = Color.parseColor("#FFF0E6");
        } else {
            try {
                i2 = Color.parseColor(this.f11012e.messageBgStart);
                i = Color.parseColor(this.f11012e.messageBgEnd);
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
                i2 = Color.parseColor("#FFDDCC");
                i = Color.parseColor("#FFF0E6");
            }
        }
        GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, new int[]{i2, i});
        gradientDrawable.setGradientType(0);
        gradientDrawable.setCornerRadii(new float[]{(float) UiUtils.dip2px(this.f11008a, 20.0f), (float) UiUtils.dip2px(this.f11008a, 20.0f), (float) UiUtils.dip2px(this.f11008a, 20.0f), (float) UiUtils.dip2px(this.f11008a, 20.0f), 0.0f, 0.0f, 0.0f, 0.0f});
        this.f11009b.setBackground(gradientDrawable);
        CarMessageModel carMessageModel2 = this.f11012e;
        if (carMessageModel2 == null || TextUtils.isEmpty(carMessageModel2.messageIcon)) {
            this.f11010c.setVisibility(8);
        } else {
            this.f11010c.setVisibility(0);
            Context context = this.f11008a;
            if (!(context instanceof Activity) || !((Activity) context).isDestroyed()) {
                Glide.with(this.f11008a).load(this.f11012e.messageIcon).into(this.f11010c);
            }
        }
        CarMessageModel carMessageModel3 = this.f11012e;
        if (carMessageModel3 != null && carMessageModel3.msg != null && !TextUtils.isEmpty(this.f11012e.msg.getContent())) {
            this.f11012e.msg.bindTextView(this.f11011d);
        }
    }
}
