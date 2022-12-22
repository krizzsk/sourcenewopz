package com.didi.sdk.home.bizbar;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.view.animation.Animation;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.request.target.CustomTarget;
import com.bumptech.glide.request.transition.Transition;
import com.didi.global.globaluikit.animation.GlobalUIKitAnimationFactory;
import com.taxis99.R;

public class BizNavItemView extends RelativeLayout {

    /* renamed from: a */
    private TextView f36371a;

    /* renamed from: b */
    private ImageView f36372b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public ImageView f36373c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public int f36374d;

    /* renamed from: e */
    private View f36375e;

    public BizNavItemView(Context context, boolean z) {
        super(context);
        m25744a(z);
    }

    /* renamed from: a */
    private void m25744a(boolean z) {
        if (z) {
            inflate(getContext(), R.layout.new_ui_biz_bar_item_horizontal, this);
        } else {
            inflate(getContext(), R.layout.new_ui_biz_bar_item_vertical, this);
        }
        this.f36371a = (TextView) findViewById(R.id.biz_bar_item_text);
        this.f36372b = (ImageView) findViewById(R.id.biz_bar_item_icon);
        this.f36373c = (ImageView) findViewById(R.id.biz_bar_item_red_point);
        this.f36375e = findViewById(R.id.biz_bar_item);
    }

    public View getBizBarll() {
        return this.f36375e;
    }

    public void setText(String str) {
        TextView textView = this.f36371a;
        if (textView != null) {
            textView.setText(str);
        }
    }

    public void setTextColor(int i) {
        TextView textView = this.f36371a;
        if (textView != null) {
            textView.setTextColor(i);
        }
    }

    public void setTypeface(Typeface typeface) {
        TextView textView = this.f36371a;
        if (textView != null) {
            textView.setTypeface(typeface);
        }
    }

    public void setIcon(String str) {
        if (this.f36372b != null && getContext() != null && !TextUtils.isEmpty(str)) {
            ((RequestBuilder) Glide.with(getContext()).asBitmap().load(str).placeholder((int) R.drawable.biz_bar_nav_icon_default)).into(this.f36372b);
        }
    }

    public void setIconRes(int i) {
        ImageView imageView = this.f36372b;
        if (imageView != null) {
            imageView.setImageResource(i);
        }
    }

    public void setIconAlpha(float f) {
        ImageView imageView = this.f36372b;
        if (imageView != null) {
            imageView.setAlpha(f);
        }
    }

    public void setRedPoint(String str) {
        if (this.f36373c != null && getContext() != null) {
            Glide.with(getContext()).asBitmap().load(str).into(new CustomTarget<Bitmap>() {
                public void onLoadCleared(Drawable drawable) {
                }

                public void onResourceReady(Bitmap bitmap, Transition<? super Bitmap> transition) {
                    BizNavItemView.this.f36373c.setImageBitmap(bitmap);
                    BizNavItemView.this.f36373c.setVisibility(0);
                    int unused = BizNavItemView.this.f36374d = bitmap.getHeight();
                    BizNavItemView.this.f36373c.startAnimation(GlobalUIKitAnimationFactory.getScaleAnimation(0.0f, 1.0f, 0.0f, 1.0f, (float) (BizNavItemView.this.f36374d / 2), (float) (BizNavItemView.this.f36374d / 2), GlobalUIKitAnimationFactory.InterpolatorType.EASY_OUT, false, false, 400, 0, 0, (Animation.AnimationListener) null));
                }
            });
        }
    }

    public void setRedPointVisibility(int i) {
        ImageView imageView = this.f36373c;
        if (imageView == null) {
            return;
        }
        if (i == 0) {
            imageView.setVisibility(0);
            return;
        }
        int i2 = this.f36374d;
        this.f36373c.startAnimation(GlobalUIKitAnimationFactory.getScaleAnimation(1.0f, 0.0f, 1.0f, 0.0f, (float) (i2 / 2), (float) (i2 / 2), GlobalUIKitAnimationFactory.InterpolatorType.EASY_OUT, false, false, 400, 0, 0, new Animation.AnimationListener() {
            public void onAnimationRepeat(Animation animation) {
            }

            public void onAnimationStart(Animation animation) {
            }

            public void onAnimationEnd(Animation animation) {
                if (BizNavItemView.this.f36373c != null) {
                    BizNavItemView.this.f36373c.setVisibility(8);
                }
            }
        }));
    }

    public int getRedPointVisibility() {
        ImageView imageView = this.f36373c;
        if (imageView == null) {
            return 8;
        }
        return imageView.getVisibility();
    }

    public void showIconAnimation() {
        ImageView imageView = this.f36372b;
        if (imageView != null) {
            this.f36372b.startAnimation(GlobalUIKitAnimationFactory.getScaleAnimation(0.0f, 1.0f, 0.0f, 1.0f, (float) (imageView.getWidth() / 2), (float) (this.f36372b.getHeight() / 2), GlobalUIKitAnimationFactory.InterpolatorType.EASY_OUT, false, false, 400, 0, 0, (Animation.AnimationListener) null));
        }
    }
}
