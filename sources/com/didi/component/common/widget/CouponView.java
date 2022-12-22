package com.didi.component.common.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.NinePatchDrawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.android.didi.bfflib.business.BffGsonStruct;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.CustomTarget;
import com.bumptech.glide.request.transition.Transition;
import com.didi.component.common.util.OnAntiShakeClickListener;
import com.didi.component.common.util.UIUtils;
import com.didi.drouter.api.DRouter;
import com.didi.global.globalgenerickit.template.yoga.util.NinePatchBuilder;
import com.taxis99.R;

public class CouponView extends RelativeLayout {

    /* renamed from: a */
    private Context f11982a;

    /* renamed from: b */
    private View f11983b;

    /* renamed from: c */
    private ImageView f11984c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public RelativeLayout f11985d;

    /* renamed from: e */
    private TextView f11986e;

    /* renamed from: f */
    private View f11987f;

    public static class CouponModel implements BffGsonStruct {
        public String background_image;
        public String icon;
        public String link;
        public boolean show_redDot;
        public String text;
        public String text_color;
    }

    public CouponView(Context context) {
        super(context);
        init(context);
    }

    public CouponView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
    }

    public CouponView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(context);
    }

    public void init(Context context) {
        this.f11982a = context;
        this.f11983b = LayoutInflater.from(context).inflate(R.layout.g_coupon_layout, this);
        this.f11984c = (ImageView) findViewById(R.id.coupon_img);
        this.f11985d = (RelativeLayout) findViewById(R.id.coupon_bg);
        this.f11986e = (TextView) findViewById(R.id.coupon_text);
        this.f11987f = findViewById(R.id.dot_view);
    }

    public void bindData(CouponModel couponModel) {
        if (couponModel != null) {
            if (couponModel.show_redDot) {
                this.f11987f.setVisibility(0);
                this.f11985d.setVisibility(8);
                this.f11984c.setVisibility(8);
                return;
            }
            this.f11987f.setVisibility(8);
            this.f11985d.setVisibility(0);
            this.f11984c.setVisibility(0);
            m8068a(couponModel);
        }
    }

    /* renamed from: a */
    private void m8068a(CouponModel couponModel) {
        if (!TextUtils.isEmpty(couponModel.text)) {
            this.f11986e.setVisibility(0);
            this.f11986e.setText(couponModel.text);
        } else {
            this.f11986e.setVisibility(8);
        }
        if (!TextUtils.isEmpty(couponModel.text_color)) {
            this.f11986e.setTextColor(Color.parseColor(couponModel.text_color));
        }
        if (!TextUtils.isEmpty(couponModel.icon)) {
            this.f11984c.setVisibility(0);
            Glide.with(this.f11982a).load(couponModel.icon).into(this.f11984c);
        } else {
            this.f11984c.setVisibility(8);
        }
        if (!TextUtils.isEmpty(couponModel.background_image)) {
            Glide.with(this.f11982a).asBitmap().load(couponModel.background_image).into(new CustomTarget<Bitmap>() {
                public void onLoadCleared(Drawable drawable) {
                }

                public void onResourceReady(Bitmap bitmap, Transition<? super Bitmap> transition) {
                    NinePatchDrawable build = new NinePatchBuilder(CouponView.this.getResources(), bitmap).addXCenteredRegion(2).build();
                    if (build != null) {
                        CouponView.this.f11985d.setBackground(build);
                    }
                }
            });
        } else {
            this.f11985d.setBackgroundColor(Color.parseColor("#00000000"));
        }
        if (!TextUtils.isEmpty(couponModel.link)) {
            final String str = couponModel.link;
            this.f11983b.setOnClickListener(new OnAntiShakeClickListener() {
                public void onAntiShakeClick(View view) {
                    DRouter.build(str).start();
                }
            });
        }
        if (!TextUtils.isEmpty(couponModel.icon) || !TextUtils.isEmpty(couponModel.background_image)) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f11986e.getLayoutParams();
            layoutParams.setMarginStart(UIUtils.dip2pxInt(this.f11982a, 16.0f));
            layoutParams.setMarginEnd(UIUtils.dip2pxInt(this.f11982a, 8.0f));
            this.f11986e.setLayoutParams(layoutParams);
            this.f11986e.setTextSize(2, 10.0f);
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.f11985d.getLayoutParams();
            layoutParams2.setMarginStart(UIUtils.dip2pxInt(this.f11982a, 9.0f));
            this.f11985d.setLayoutParams(layoutParams2);
            return;
        }
        RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.f11986e.getLayoutParams();
        layoutParams3.setMarginStart(0);
        layoutParams3.setMarginEnd(0);
        this.f11986e.setLayoutParams(layoutParams3);
        this.f11986e.setTextSize(2, 12.0f);
        RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) this.f11985d.getLayoutParams();
        layoutParams4.setMarginStart(0);
        this.f11985d.setLayoutParams(layoutParams4);
    }
}
