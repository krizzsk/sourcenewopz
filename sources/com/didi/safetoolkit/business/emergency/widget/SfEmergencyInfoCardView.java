package com.didi.safetoolkit.business.emergency.widget;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.didi.safetoolkit.business.emergency.model.SfEmgInfo;
import com.didi.safetoolkit.util.SfStringGetter;
import com.taxis99.R;

public class SfEmergencyInfoCardView extends FrameLayout {

    /* renamed from: a */
    static int f34347a = 300;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public TextView f34348b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public ImageView f34349c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public TextView f34350d;

    /* renamed from: e */
    private TextView f34351e;

    /* renamed from: f */
    private TextView f34352f;

    /* renamed from: g */
    private TextView f34353g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public long f34354h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public String f34355i;

    public SfEmergencyInfoCardView(Context context) {
        super(context);
        m24303a(context);
    }

    public SfEmergencyInfoCardView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m24303a(context);
    }

    /* renamed from: a */
    private void m24303a(Context context) {
        LayoutInflater.from(context).inflate(R.layout.sf_emergency_info_view, this);
        TextView textView = (TextView) findViewById(R.id.sf_location_tv);
        this.f34348b = textView;
        textView.setText(SfStringGetter.getString(R.string.sf_emergency_assistance_updating_location));
        this.f34349c = (ImageView) findViewById(R.id.sf_address_status_icon);
        TextView textView2 = (TextView) findViewById(R.id.sf_address_tv);
        this.f34350d = textView2;
        textView2.setBackground(getResources().getDrawable(R.drawable.sf_emergency_location_info_bg));
        this.f34351e = (TextView) findViewById(R.id.vehicle_info);
        this.f34352f = (TextView) findViewById(R.id.vehicle_id_number);
        this.f34353g = (TextView) findViewById(R.id.vehicle_model);
    }

    public void setVehicleInfoVisible(boolean z) {
        if (!z) {
            this.f34351e.setVisibility(8);
            this.f34352f.setVisibility(8);
            this.f34353g.setVisibility(8);
            return;
        }
        this.f34351e.setVisibility(0);
        this.f34352f.setVisibility(0);
        this.f34353g.setVisibility(0);
    }

    public void setEmgInfo(SfEmgInfo sfEmgInfo) {
        this.f34352f.setText(sfEmgInfo.data.carLicense);
        this.f34353g.setText(sfEmgInfo.data.carBrand);
    }

    public void updatingLocation() {
        this.f34348b.setText(SfStringGetter.getString(R.string.sf_emergency_assistance_updating_location));
        final Animator loadAnimator = AnimatorInflater.loadAnimator(getContext(), R.animator.jump_flip_anim);
        loadAnimator.setTarget(this.f34349c);
        TranslateAnimation translateAnimation = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, 0.0f, 1, -0.2f);
        translateAnimation.setDuration((long) f34347a);
        translateAnimation.setStartOffset(0);
        translateAnimation.setInterpolator(new JumpInterpolator(0.5f));
        translateAnimation.setAnimationListener(new SimpleAnimationListenerAdapter() {
            public void onAnimationStart(Animation animation) {
                loadAnimator.start();
            }

            public void onAnimationEnd(Animation animation) {
                animation.cancel();
                SfEmergencyInfoCardView.this.f34349c.clearAnimation();
                if (!TextUtils.isEmpty(SfEmergencyInfoCardView.this.f34355i)) {
                    SfEmergencyInfoCardView.this.f34348b.setText(SfStringGetter.getString(R.string.sf_emergency_assistance_current_location));
                    SfEmergencyInfoCardView.this.f34350d.setText(SfEmergencyInfoCardView.this.f34355i);
                    SfEmergencyInfoCardView.this.f34350d.setBackground((Drawable) null);
                    SfEmergencyInfoCardView.this.f34350d.setTextColor(SfEmergencyInfoCardView.this.getResources().getColor(R.color.sf_color_333333));
                    long unused = SfEmergencyInfoCardView.this.f34354h = System.currentTimeMillis();
                    String unused2 = SfEmergencyInfoCardView.this.f34355i = "";
                }
            }
        });
        this.f34349c.startAnimation(translateAnimation);
        this.f34350d.setTextColor(getResources().getColor(R.color.sf_color_CCCCCC));
    }

    public void updateCurrentLocation(String str) {
        this.f34355i = str;
    }

    public void showLastKnowLocation() {
        if (!TextUtils.isEmpty(this.f34350d.getText())) {
            this.f34348b.setText(SfStringGetter.getString(R.string.sf_emergency_assistance_last_know_location, Integer.valueOf((int) Math.ceil((double) (((float) ((System.currentTimeMillis() - this.f34354h) / 1000)) / 60.0f)))));
            this.f34350d.setBackground((Drawable) null);
            this.f34350d.setTextColor(getResources().getColor(R.color.sf_color_333333));
        }
    }

    public void onPause() {
        Animation animation = this.f34349c.getAnimation();
        if (animation != null) {
            animation.cancel();
            this.f34349c.clearAnimation();
        }
    }
}
