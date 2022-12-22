package com.didi.entrega.order.widgets;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.didi.app.nova.support.util.DisplayUtils;
import com.didi.entrega.customer.map.infowindow.AbInfoWindowView;
import com.didi.entrega.customer.map.marker.InfoWindowViewBuildConfig;
import com.taxis99.R;
import kotlinx.coroutines.internal.LockFreeTaskQueueCore;

public class MarkerInfoWindowView extends AbInfoWindowView {

    /* renamed from: a */
    private TextView f20928a;

    /* renamed from: b */
    private TextView f20929b;

    /* renamed from: c */
    private View f20930c;

    /* renamed from: d */
    private View f20931d;

    /* renamed from: e */
    private View f20932e;

    /* renamed from: f */
    private ImageView f20933f;

    /* renamed from: g */
    private ObjectAnimator f20934g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public int f20935h;

    /* renamed from: i */
    private int f20936i;

    /* renamed from: j */
    private int f20937j;

    /* renamed from: k */
    private int f20938k;

    /* renamed from: a */
    private int m15347a(int i) {
        return (i == 1400 || i == 1500) ? R.drawable.entraga_shape_bill_map_orange_bg : R.drawable.entraga_shape_bill_map_green_bg;
    }

    /* renamed from: b */
    private int m15350b(int i) {
        return (1400 == i || 1500 == i) ? R.drawable.entrega_tips_map_triangle_orange : R.drawable.entrega_tips_map_triangle_green;
    }

    /* access modifiers changed from: protected */
    public int getLayoutRes() {
        return R.layout.entrega_customer_layout_marker_station;
    }

    public MarkerInfoWindowView(Context context) {
        super(context);
    }

    public MarkerInfoWindowView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public MarkerInfoWindowView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public MarkerInfoWindowView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
    }

    public void setMarkInfoWindowRes(int i) {
        View view = this.f20931d;
        if (view != null) {
            view.setBackgroundResource(m15347a(i));
        }
        ImageView imageView = this.f20933f;
        if (imageView != null) {
            imageView.setImageResource(m15350b(i));
        }
    }

    /* access modifiers changed from: protected */
    public void initView(View view) {
        this.f20932e = view;
        this.f20928a = (TextView) view.findViewById(R.id.customer_tv_current_title);
        this.f20929b = (TextView) this.f20932e.findViewById(R.id.customer_tv_current_content);
        this.f20930c = this.f20932e.findViewById(R.id.customer_tv_title_arrow);
        this.f20933f = (ImageView) this.f20932e.findViewById(R.id.customer_iv_bottom_triangle);
        this.f20931d = this.f20932e.findViewById(R.id.customer_cl_marker_station_layout);
        setVisibility(8);
        PropertyValuesHolder ofFloat = PropertyValuesHolder.ofFloat(View.ALPHA, new float[]{0.0f, 1.0f});
        ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(this, new PropertyValuesHolder[]{PropertyValuesHolder.ofFloat(View.SCALE_X, new float[]{0.0f, 1.0f}), PropertyValuesHolder.ofFloat(View.SCALE_Y, new float[]{0.0f, 1.0f}), ofFloat});
        this.f20934g = ofPropertyValuesHolder;
        ofPropertyValuesHolder.setDuration(200);
        this.f20934g.setInterpolator(new DecelerateInterpolator());
        this.f20934g.addListener(new AnimatorListenerAdapter() {
            public void onAnimationEnd(Animator animator) {
                MarkerInfoWindowView markerInfoWindowView = MarkerInfoWindowView.this;
                markerInfoWindowView.setVisibility(markerInfoWindowView.f20935h);
            }
        });
    }

    public void updateView(InfoWindowViewBuildConfig infoWindowViewBuildConfig) {
        if (infoWindowViewBuildConfig != null) {
            setVisibility(0);
            setMarkInfoWindowRes(infoWindowViewBuildConfig.getOrderStatus().intValue());
            if (!TextUtils.isEmpty(infoWindowViewBuildConfig.getTitle())) {
                this.f20928a.setVisibility(0);
                this.f20928a.setText(infoWindowViewBuildConfig.getTitle());
            } else {
                this.f20928a.setVisibility(8);
            }
            if (!TextUtils.isEmpty(infoWindowViewBuildConfig.getSubDesc())) {
                this.f20929b.setVisibility(0);
                this.f20929b.setText(infoWindowViewBuildConfig.getSubDesc());
                return;
            }
            this.f20929b.setVisibility(8);
            return;
        }
        setVisibility(8);
    }

    public void updateView(String str, CharSequence charSequence, boolean z) {
        int i = 8;
        if (!TextUtils.isEmpty(str)) {
            this.f20935h = 0;
            setVisibility(0);
            this.f20928a.setText(str);
            this.f20928a.setVisibility(TextUtils.isEmpty(str) ? 8 : 0);
            this.f20929b.setText(charSequence);
            this.f20929b.setVisibility(TextUtils.isEmpty(charSequence) ? 8 : 0);
            View view = this.f20930c;
            if (z) {
                i = 0;
            }
            view.setVisibility(i);
            return;
        }
        this.f20935h = 8;
        m15352c();
    }

    public void hideViewImmediately() {
        this.f20935h = 8;
        setVisibility(8);
    }

    public void hideViewWithAnim() {
        this.f20935h = 8;
        updateView((String) null, (CharSequence) null, false);
    }

    public void showView(String str, CharSequence charSequence, boolean z) {
        if (!TextUtils.isEmpty(str)) {
            this.f20935h = 0;
            setVisibility(0);
            updateView(str, charSequence, z);
            m15351b();
        }
    }

    public void updateLocation(int i, int i2, boolean z) {
        int i3;
        this.f20936i = i;
        this.f20937j = i2;
        if (z) {
            i3 = 0;
        } else {
            i3 = -DisplayUtils.dip2px(getContext(), 12.0f);
        }
        this.f20938k = i3;
        m15349a();
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ObjectAnimator objectAnimator = this.f20934g;
        if (objectAnimator != null) {
            objectAnimator.cancel();
            this.f20934g = null;
        }
    }

    /* renamed from: a */
    private void m15349a() {
        measure(View.MeasureSpec.makeMeasureSpec(LockFreeTaskQueueCore.MAX_CAPACITY_MASK, Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(LockFreeTaskQueueCore.MAX_CAPACITY_MASK, Integer.MIN_VALUE));
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.leftMargin = this.f20936i - (measuredWidth / 2);
        layoutParams.topMargin = (this.f20937j - measuredHeight) + this.f20938k;
        layoutParams.rightMargin = -measuredWidth;
        layoutParams.bottomMargin = -measuredHeight;
        setLayoutParams(layoutParams);
    }

    /* renamed from: b */
    private void m15351b() {
        ObjectAnimator objectAnimator = this.f20934g;
        if (objectAnimator != null) {
            if (objectAnimator.isRunning()) {
                this.f20934g.end();
            }
            setScaleX(0.0f);
            setScaleX(0.0f);
            setAlpha(0.0f);
            this.f20934g.setStartDelay(1200);
            this.f20934g.start();
        }
    }

    /* renamed from: c */
    private void m15352c() {
        if (this.f20934g != null && isShown()) {
            if (this.f20934g.isRunning()) {
                this.f20934g.end();
            }
            this.f20934g.setStartDelay(0);
            this.f20934g.reverse();
        }
    }
}
