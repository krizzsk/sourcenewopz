package com.didi.soda.home.topgun.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.didi.app.nova.skeleton.image.RoundedCornersTransformation;
import com.didi.app.nova.support.util.DisplayUtils;
import com.didi.soda.customer.foundation.util.BitmapUtil;
import com.didi.soda.customer.foundation.util.FlyImageLoader;
import com.taxis99.R;

public class HomeLogoPromotionView extends LinearLayout {

    /* renamed from: a */
    private int f43136a;

    /* renamed from: b */
    private Drawable f43137b;

    /* renamed from: c */
    private Drawable f43138c;

    public HomeLogoPromotionView(Context context) {
        super(context);
        m30520a();
    }

    public HomeLogoPromotionView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m30520a();
    }

    public HomeLogoPromotionView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m30520a();
    }

    public void bindData(String str, String str2) {
        removeAllViews();
        boolean z = !TextUtils.isEmpty(str);
        boolean z2 = !TextUtils.isEmpty(str2);
        if (z2 || z) {
            int dip2px = DisplayUtils.dip2px(getContext(), 36.0f);
            if (z) {
                ImageView imageView = new ImageView(getContext());
                FlyImageLoader.loadImage1x1(getContext(), str).placeholder(this.f43138c).error(this.f43138c).transform(new RoundedCornersTransformation(getContext(), this.f43136a, 0, z2 ? RoundedCornersTransformation.CornerType.BOTTOM_LEFT : RoundedCornersTransformation.CornerType.BOTTOM, true)).into(imageView);
                addView(imageView, new LinearLayout.LayoutParams(dip2px, dip2px));
            }
            if (z2) {
                ImageView imageView2 = new ImageView(getContext());
                FlyImageLoader.loadImage1x1(getContext(), str2).placeholder(this.f43137b).transform(new RoundedCornersTransformation(getContext(), this.f43136a, 0, z ? RoundedCornersTransformation.CornerType.BOTTOM_RIGHT : RoundedCornersTransformation.CornerType.BOTTOM, true)).error(this.f43137b).into(imageView2);
                addView(imageView2, new LinearLayout.LayoutParams(dip2px, dip2px));
            }
            setVisibility(0);
            return;
        }
        setVisibility(8);
    }

    /* renamed from: a */
    private void m30520a() {
        setOrientation(0);
        this.f43136a = DisplayUtils.dip2px(getContext(), 2.0f);
        this.f43137b = BitmapUtil.getRoundedDrawable(getContext(), R.drawable.customer_img_topgun_placeholder_business_logo, this.f43136a);
        this.f43138c = BitmapUtil.getRoundedDrawable(getContext(), R.drawable.customer_img_topgun_placeholder_business_promotion, this.f43136a);
    }
}
