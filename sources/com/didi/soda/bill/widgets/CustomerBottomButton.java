package com.didi.soda.bill.widgets;

import android.content.Context;
import android.graphics.PointF;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.didi.soda.customer.biz.helper.PointHelper;
import com.didi.soda.customer.foundation.skin.SkinUtil;
import com.didi.soda.customer.foundation.util.CustomerSystemUtil;
import com.didi.soda.customer.service.CustomerServiceManager;
import com.didi.soda.customer.service.IToolsService;
import com.didi.soda.customer.widget.loading.LottieLoadingView;
import com.taxis99.R;

public class CustomerBottomButton extends ConstraintLayout {

    /* renamed from: a */
    private TextView f39268a;

    /* renamed from: b */
    private TextView f39269b;

    /* renamed from: c */
    private TextView f39270c;

    /* renamed from: d */
    private TextView f39271d;

    /* renamed from: e */
    private LottieLoadingView f39272e;

    /* renamed from: f */
    private FrameLayout f39273f;

    /* renamed from: g */
    private View f39274g;

    /* renamed from: h */
    private View f39275h;

    /* renamed from: i */
    private boolean f39276i;

    public interface OnSuccessAnimatorFinishedListener {
        void onAnimatorFinish();
    }

    public CustomerBottomButton(Context context) {
        super(context);
        m27819a();
    }

    public CustomerBottomButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m27819a();
    }

    public CustomerBottomButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m27819a();
    }

    public View getLeftText() {
        return this.f39268a;
    }

    public void setLeftText(String str) {
        this.f39268a.setText(str);
    }

    public void setLeftTextColor(int i) {
        this.f39268a.setTextColor(i);
    }

    public void setLeftTextSize(int i, float f) {
        this.f39268a.setTextSize(i, f);
    }

    public void setLeftFontType(IToolsService.FontType fontType) {
        ((IToolsService) CustomerServiceManager.getService(IToolsService.class)).setTypeface(this.f39268a, fontType);
    }

    public void setLeftTextBackground(Drawable drawable) {
        this.f39268a.setBackground(drawable);
    }

    public void setLeftPadding(int i, int i2, int i3, int i4) {
        this.f39268a.setPadding(i, i2, i3, i4);
    }

    public PointF getNumberPointF() {
        return PointHelper.getPointF(this.f39268a);
    }

    public void hideLoading() {
        this.f39272e.setVisibility(8);
        this.f39272e.stop();
        this.f39273f.setVisibility(8);
        this.f39271d.setVisibility(0);
    }

    public boolean isLoading() {
        return this.f39272e.isRunning();
    }

    public void loading() {
        this.f39272e.setVisibility(0);
        this.f39272e.start();
        this.f39273f.setVisibility(0);
        this.f39271d.setVisibility(4);
    }

    public void setLeftVisible(int i) {
        this.f39268a.setVisibility(i);
    }

    public void setMiddleTextText(String str) {
        this.f39271d.setText(str);
    }

    public void setMiddleTextGravity(int i) {
        this.f39271d.setGravity(i);
    }

    public void setMiddleVisible(int i) {
        this.f39271d.setVisibility(i);
    }

    public void setMiddleTextSize(int i, float f) {
        this.f39271d.setTextSize(i, f);
    }

    public void setMiddleFontType(IToolsService.FontType fontType) {
        ((IToolsService) CustomerServiceManager.getService(IToolsService.class)).setTypeface(this.f39271d, fontType);
    }

    public void setBackgroundRes(int i) {
        this.f39275h.setBackgroundResource(i);
    }

    public void setRightText(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            this.f39269b.setVisibility(8);
        } else {
            this.f39269b.setText(str);
            this.f39269b.setVisibility(0);
        }
        if (TextUtils.isEmpty(str2)) {
            this.f39270c.setVisibility(8);
            return;
        }
        this.f39270c.setAlpha(0.5f);
        this.f39270c.setText(str2);
        TextView textView = this.f39270c;
        textView.setPaintFlags(textView.getPaintFlags() | 16);
        this.f39270c.setVisibility(0);
    }

    public void setRightTextVisibility(int i) {
        if (!TextUtils.isEmpty(this.f39269b.getText())) {
            this.f39269b.setVisibility(i);
        }
        if (!TextUtils.isEmpty(this.f39270c.getText())) {
            this.f39270c.setVisibility(i);
        }
    }

    public void setEnabledState(boolean z) {
        this.f39276i = z;
        if (z) {
            this.f39274g.setVisibility(4);
            setClickable(true);
            return;
        }
        this.f39274g.setVisibility(0);
        setClickable(false);
    }

    public boolean getIsEnabledState() {
        return this.f39276i;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            CustomerSystemUtil.virate(getContext());
        }
        return super.onTouchEvent(motionEvent);
    }

    /* renamed from: a */
    private void m27819a() {
        LayoutInflater.from(getContext()).inflate(R.layout.customer_widget_bottom_button_container, this);
        this.f39275h = findViewById(R.id.customer_cl_mini_cart_bar);
        this.f39271d = (TextView) findViewById(R.id.customer_tv_bottom_button_middle_text);
        this.f39272e = (LottieLoadingView) findViewById(R.id.customer_custom_loading);
        FrameLayout frameLayout = (FrameLayout) findViewById(R.id.customer_fl_loading_container);
        this.f39273f = frameLayout;
        frameLayout.setBackground(getBackground());
        this.f39268a = (TextView) findViewById(R.id.customer_tv_bottom_button_left_num);
        this.f39269b = (TextView) findViewById(R.id.customer_tv_bottom_button_right_top_text);
        this.f39270c = (TextView) findViewById(R.id.customer_tv_bottom_button_right_bottom_text);
        this.f39274g = findViewById(R.id.customer_view_disabled_mask);
        this.f39268a.setTextColor(SkinUtil.getMainButtonSideTextColor());
        this.f39271d.setTextColor(SkinUtil.getUponBrandPrimaryTextColorStateList());
        this.f39269b.setTextColor(SkinUtil.getMainButtonSideTextColor());
        this.f39270c.setTextColor(SkinUtil.getMainButtonSideTextColor());
        hideLoading();
        ((IToolsService) CustomerServiceManager.getService(IToolsService.class)).setTypeface(this.f39271d, IToolsService.FontType.BOLD);
    }
}
